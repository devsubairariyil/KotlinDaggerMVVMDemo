const { exec } = require('child_process');

const outputValue = 'Your output value'; // Replace this with your actual output value

exec(`echo "MY_OUTPUT_NAME=${outputValue}" >> $GITHUB_ENV`, (error, stdout, stderr) => {
  if (error) {
    console.error(error);
    process.exit(1);
  }
  console.log(stdout);
  console.error(stderr);
});