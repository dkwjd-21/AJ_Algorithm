const fs = require('fs');

// trim() : 문자열의 앞뒤 공백(whitespace)을 제거하는 메서드
const input = fs.readFileSync('/dev/stdin').toString().trim();

console.log(input+"??!");