# Your script here to scan features and calculate blocks and files per block
        # You can use any scripting language you prefer (e.g., bash, Python, Node.js)

          # Get the list of feature files into an array
          files=()
          while IFS= read -r -d '' file; do
            files+=("$file")
          done < <(find ${{ inputs.feature_folder }} -type f -name "*.feature" -print0)

          # Calculate the number of strategies (5 or 3) based on the total file count
          total_files=${#files[@]}
          if [[ $total_files -gt 12 ]]; then
            strategies=5
          elif [[ $total_files -gt 3 ]]; then
            strategies=3
          else
            strategies=1
          fi

          # Calculate the number of files for each strategy and the remaining files
          files_per_strategy=$(( total_files / strategies ))
          remaining_files=$(( total_files % strategies ))

          # Increment max_files_per_strategy by 1 if the remainder is greater than 0
          if [[ $remaining_files -gt 0 ]]; then
            max_files_per_strategy=$(( files_per_strategy + 1 ))
          else
            max_files_per_strategy=$files_per_strategy
          fi

          echo Total File : $total_files
          echo Files Per Strategy : $max_files_per_strategy
          # Construct the JSON output with the strategies
          json="{"

          # Include the devices block if devices are provided or use a default value
          if [ -n "${{ inputs.device_list }}" ]; then
            json+="\"devices\": [${{ inputs.device_list }}], "
          else
            json+="\"devices\": [\"device1\", \"device2\"], "  # Default device list
          fi

          # Add additional keys outside the shard block
          json+="\"project\": \"${{ inputs.project }}\", "
          json+="\"custom_id\": \"${{ inputs.custom_id }}\", "
          json+="\"locale\": \"en-GB\", "

          json+="\"mapping\": ["

          # Create and allocate files to the strategies using Round Robin logic
          strategyCount=1
           for (( i = 0; i < total_files; i++ )); do
             if((i%max_files_per_strategy == 0 && i != 0)); then
               files_string=$(IFS=, ; echo "${strategy_files[*]}")
               strategy_object="{\"name\": \"Shard $((strategyCount))\", \"strategy\": \"Cucumber\", \"values\": {\"features\": [$files_string]}}"
               json+="$strategy_object"
               if (( strategyCount <= strategies )); then
                 json+=", "
               fi
               ((strategyCount++))
               strategy_files=()
             fi
        
             folderName="assets/"
             text=${files[i]}
             filteredName=$(echo "$text" | grep -o -P "(?<=${folderName}).*")
             strategy_files+=("\"${filteredName}\"")

           done

          #Add the last strategy if it has not added items
          if (( strategyCount <= strategies )); then
             files_string=$(IFS=, ; echo "${strategy_files[*]}")
             strategy_object="{\"name\": \"Shard $((strategyCount))\", \"strategy\": \"Cucumber\", \"values\": {\"features\": [$files_string]}}"
             json+="$strategy_object"
          fi
          json+="], "

          json+="\"numberOfShard\": $strategies, "  # Number of strategies
          json+="\"deviceSelection\": \"any\""   # Device selection

          json+="}"
        
          echo "config_json=$json" >> $GITHUB_OUTPUT

          # Save JSON to a file named config.json in the .github folder
          echo "$json" > .github/config.json