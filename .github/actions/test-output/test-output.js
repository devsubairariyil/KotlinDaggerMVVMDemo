// set-outputs.js
const core = require('@actions/core');
const fs = require('fs');


async function run() {
  try {
    // Calculate the value for 'blocks'
    const blocks = "some value";
    core.setOutput('test_data', $blocks)
  } catch (error) {
    console.error(error);
    process.exit(1);
  }
}

run();


