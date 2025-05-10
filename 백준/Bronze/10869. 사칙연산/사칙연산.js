// 두 자연수 A와 B가 주어진다. 이때, 
// A+B, A-B, A*B, A/B(몫), A%B(나머지)를 출력하는 프로그램을 작성하시오. 

let fs = require("fs");
let input = fs.readFileSync('/dev/stdin').toString().split(' ');

const a = parseInt(input[0]);
const b = parseInt(input[1]);

console.log(a+b);
console.log(a-b);
console.log(a*b);
// Math.floor() 정수 몫만 구하고 싶을 때 사용 
console.log(Math.floor(a/b));
console.log(a%b);