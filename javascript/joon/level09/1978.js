const fs = require('fs');

const n = parseInt(fs.readFileSync('/dev/stdin').toString());
const map = {};
const go = (n) => {
  if (map[n]) return map[n];
  if (n <= 1) return 1;
  return map[n] = go(n - 1) * n;
}

console.log(go(n));