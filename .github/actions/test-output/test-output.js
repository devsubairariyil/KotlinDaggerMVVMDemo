// set-outputs.js
const fs = require('fs');
const core = require('@actions/core');


async function run() {
  try {
    // Calculate the value for 'blocks'
    const blocks = "some value";
    console.log('test_data:$blocks')
    core.setOutput('test_data', $blocks)
  } catch (error) {
    console.error(error);
    process.exit(1);
  }
}

run();


