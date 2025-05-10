// 불기 연도가 주어질 때 이를 서기 연도로 바꿔 주는 프로그램
// 불기 원년(1년)은 기원전 544년이므로 서기를 불기로 변환할 때는 543 더하면 됨
// 반대는 -543

const fs = require('fs');

const input = fs.readFileSync('/dev/stdin').toString().trim();
const y = parseInt(input);

console.log(y-543);