// fs 모듈 불러옴 
let fs = require('fs');

// 표준 입력을 동기적으로 읽어옵 + toString() + split(' ')
let input = fs.readFileSync('/dev/stdin').toString().split(' ');

// parseInt() : 정수형으로 반환 
let a = parseInt(input[0]);
let b = parseInt(input[1]);

// a+b 출력
console.log(a+b);
