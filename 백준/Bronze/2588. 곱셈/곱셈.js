// 세자리 수 입력 받기
let fs = require('fs');
let [a,b] = fs.readFileSync('/dev/stdin').toString().split('\n');

a = parseInt(a);
b = parseInt(b);

// b의 일의 자리 수
let b1 = b%10;
// b의 십의 자리 수
let b2 = Math.floor(b%100-b1)/10;
// b의 100의 자리 수 
let b3 = Math.floor(b/100);

// 3 : a*b의 첫번째 자리 수
console.log(a*b1);
// 4 : a*b의 두번째 자리 수
console.log(a*b2);
// 5 : a*b의 세번째 자리 수
console.log(a*b3);
// 6 : a*b
console.log(a*b);