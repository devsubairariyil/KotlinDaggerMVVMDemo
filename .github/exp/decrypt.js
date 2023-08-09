const fs = require('fs');
const crypto = require('crypto');

const encryptedData = fs.readFileSync('path/to/encrypted.txt', 'utf8');
const passphrase = 'yourpassphrase';

const decipher = crypto.createDecipher('aes-256-cbc', passphrase);
let decrypted = decipher.update(encryptedData, 'base64', 'utf8');
decrypted += decipher.final('utf8');

console.log(decrypted);
