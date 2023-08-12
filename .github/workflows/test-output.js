// set-outputs.js

const fs = require('fs');

// Calculate the value for 'blocks'
const blocks = "some value";

// Set the output value as an environment variable
process.env['BLOCKS_OUTPUT'] = blocks;
