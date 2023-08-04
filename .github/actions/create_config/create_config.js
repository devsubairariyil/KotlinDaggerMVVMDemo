const fs = require('fs');
const path = require('path');

function scanFeaturesAndDivide(featureFolder) {
  // Your script here to scan features and calculate blocks and files per block
  // Calculate blocks and files_per_block based on your logic

  const blocks = 5;
  const filesPerBlock = 12;

  return { blocks, filesPerBlock };
}

async function run() {
  try {
    const featureFolder = process.env.INPUT_FEATURE_FOLDER;

    // Call the function to scan features and divide them into blocks
    const { blocks, filesPerBlock } = scanFeaturesAndDivide(featureFolder);

    // Set the outputs for other steps to use
    console.log(`blocks=${blocks}`);
    console.log(`files_per_block=${filesPerBlock}`);
    console.log(`::set-output name=blocks::${blocks}`);
    console.log(`::set-output name=files_per_block::${filesPerBlock}`);
  } catch (error) {
    console.error(error);
    process.exit(1);
  }
}

run();
