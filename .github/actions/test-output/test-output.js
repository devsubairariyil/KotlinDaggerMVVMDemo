// set-outputs.js
const fs = require('fs');
const exec = require('@actions/exec');



async function run() {
  try {
    // Calculate the value for 'blocks'
    const blocks = "some value";
    console.log('test_data:$blocks')
    await exec.exec('echo', ['Hello, world!']);
  } catch (error) {
    console.error(error);
    process.exit(1);
  }
}

run();


