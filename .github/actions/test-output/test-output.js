// set-outputs.js

const fs = require('fs');


async function run() {
  try {
    // Calculate the value for 'blocks'
    const blocks = "some value";

    // Set the output value as an environment variable
    process.env['BLOCKS_OUTPUT'] = blocks;
    process.env['TASK_OUTPUT'] = 'Hhhaaa';
    console.log(`TASK_OUTPUT=HaHa`);
    process.stdout.write(`::set-output name=sample::${blocks}\n`);
  } catch (error) {
    console.error(error);
    process.exit(1);
  }
}

run();


