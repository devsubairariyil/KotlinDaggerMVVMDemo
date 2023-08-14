name: Filter .feature Files

on:
  push:
    branches:
      - main

jobs:
  filter_files:
    runs-on: ubuntu-latest

    steps:
      - name: Checkout code
        uses: actions/checkout@v2

      - name: Filter files by content
        id: filter_files
        run: |
          node -e '
            const fs = require("fs");
            const path = require("path");

            const folderPath = "your_folder_path"; // Replace with your folder path
            const searchWord = "@Yes"; // Replace with your search word

            const filteredFiles = [];
            function scanAndFilterFiles(folder) {
              const files = fs.readdirSync(folder);
              for (const file of files) {
                const filePath = path.join(folder, file);
                const stat = fs.statSync(filePath);
                if (stat.isDirectory()) {
                  scanAndFilterFiles(filePath);
                } else if (path.extname(filePath) === ".feature") {
                  const content = fs.readFileSync(filePath, "utf-8");
                  const regex = new RegExp(`\\b${searchWord}\\b`, "g");
                  if (content.match(regex)) {
                    filteredFiles.push(filePath);
                  }
                }
              }
            }

            scanAndFilterFiles(folderPath);
            console.log(filteredFiles.join("\\n"));
          '
          echo "::set-output name=filtered_files::$(node -e 'console.log(filteredFiles.join(\\"\\n\\"))')"

      - name: Print filtered files
        run: |
          echo "Filtered Files:"
          echo "${{ steps.filter_files.outputs.filtered_files }}"
