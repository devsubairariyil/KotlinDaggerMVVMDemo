// set-outputs.js
const fs = require('fs');
const { exec } = require('child_process');



async function run() {
  try {
    // Calculate the value for 'blocks'
    const blocks = "some value";
    console.log('test_data:$blocks')
    exec('echo test_data=$blocks >> GITHUB_OUTPUT', (err, stdout, stderr) => {
      if (err) {
        // node couldn't execute the command
        return;
      }

      // the *entire* stdout and stderr (buffered)
      console.log(`stdout: ${stdout}`);
      console.log(`stderr: ${stderr}`);
    });
  } catch (error) {
    console.error(error);
    process.exit(1);
  }
}

run();


