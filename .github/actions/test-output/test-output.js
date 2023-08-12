// set-outputs.js

const fs = require('fs');


async function run() {
  try {
    // Calculate the value for 'blocks'
    const blocks = "some value";
    setOutput('test_data', $blocks)
  } catch (error) {
    console.error(error);
    process.exit(1);
  }
}

run();


