// set-outputs.js

const fs = require('fs');


async function run() {
  try {
    // Calculate the value for 'blocks'
    const blocks = "some value";

    // Set the output value as an environment variable
    process.env['BLOCKS_OUTPUT'] = blocks;
    console.log(`TASK_OUTPUT=HaHa`);
  } catch (error) {
    console.error(error);
    process.exit(1);
  }
}

run();


