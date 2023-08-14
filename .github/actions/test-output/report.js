const fs = require('fs');
const path = require('path');

function copyFolderSync(source, target) {
  if (!fs.existsSync(target)) {
    fs.mkdirSync(target);
  }

  const entries = fs.readdirSync(source, { withFileTypes: true });
  for (const entry of entries) {
    const sourcePath = path.join(source, entry.name);
    const targetPath = path.join(target, entry.name);
    if (entry.isDirectory()) {
      copyFolderSync(sourcePath, targetPath);
    } else {
      fs.copyFileSync(sourcePath, targetPath);
    }
  }
}

try {
  const sourceFolders = process.env.INPUT_SOURCE_FOLDERS.split(' ');
  const consolidatedFolder = process.env.INPUT_CONSOLIDATED_FOLDER;

  for (const sourceFolder of sourceFolders) {
    const sourcePath = path.join(process.env.GITHUB_WORKSPACE, sourceFolder);
    const targetPath = path.join(process.env.GITHUB_WORKSPACE, consolidatedFolder);
    copyFolderSync(sourcePath, targetPath);
  }

  console.log(`Consolidated reports copied to ${consolidatedFolder}`);
  console.log(`::set-output name=consolidated_folder::${consolidatedFolder}`);
} catch (error) {
  console.error(error);
  process.exit(1);
}
