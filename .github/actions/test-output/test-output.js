const { exec } = require('child_process');
const fs = require('fs-extra');

const outputValue = 'Your output value'; // Replace this with your actual output value

exec(`echo "MY_OUTPUT_NAME=${outputValue}" >> $GITHUB_ENV`);