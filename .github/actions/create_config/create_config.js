const fs = require('fs');
const path = require('path');

function scanFeaturesAndDivide(featureFolder) {
  function findFeatureFiles(folderPath) {
    const featureFiles = [];

    function findFilesRecursively(folderPath) {
      const files = fs.readdirSync(folderPath);

      for (const file of files) {
        const filePath = path.join(folderPath, file);
        const stat = fs.statSync(filePath);

        if (stat.isDirectory()) {
          findFilesRecursively(filePath);
        } else if (file.endsWith('.feature')) {
          featureFiles.push(filePath);
        }
      }
    }

    findFilesRecursively(folderPath);
    return featureFiles;
  }

  const allFeatureFiles = findFeatureFiles(featureFolder);
  const totalFiles = allFeatureFiles.length;
  const blocks = Math.min(Math.ceil(totalFiles / 5), 5); // Number of blocks should be 5 at most
  const filesPerBlock = Math.ceil(totalFiles / blocks);

  process.stdout.write(`::set-output name=blocks::${blocks}\n`);
  process.stdout.write(`::set-output name=filesPerBlock::${filesPerBlock}\n`);

  // Divide files into blocks
  const blocksArray = new Array(blocks).fill().map((_, index) => {
    const startIndex = index * filesPerBlock;
    const endIndex = Math.min((index + 1) * filesPerBlock, totalFiles);
    return {
      tags: process.env.INPUT_TAG_NAME,
      features: allFeatureFiles.slice(startIndex, endIndex),
    };
  });

  return blocksArray;
}

async function run() {
  try {
    const featureFolder = process.env.INPUT_FEATURE_FOLDER;

    // Call the function to scan features, divide them into blocks, and get the result
    const result = scanFeaturesAndDivide(featureFolder);

    // Set the outputs for other steps to use
    process.stdout.write(`::set-output name=config_json::${JSON.stringify(result)}\n`);

  } catch (error) {
    console.error(error);
    process.exit(1);
  }
}

run();
