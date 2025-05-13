# 📁 fs 모듈이란?
Node.js의 fs 모듈은 **File System(파일 시스템)**을 다룰 수 있도록 도와주는 내장 모듈. <br>
파일을 읽고, 쓰고, 수정하고, 삭제할 수 있다. <br><br>

fs.readFileSync() : 파일을 동기적으로 읽는 함수. <br><br>

예시: <br>
`let data = fs.readFileSync('example.txt');`<br>
➡️ example.txt 파일의 내용을 읽어서 data에 저장<br><br>

# 🧪 /dev/stdin
/dev/stdin은 리눅스나 유닉스 기반 시스템에서 표준 입력(stdin)을 나타내는 특수한 파일.<br>
터미널에서 입력하는 것(예: node app.js 후 키보드로 치는 입력)을 받아옴.<br><br>

fs.readFileSync('/dev/stdin')는 사용자가 터미널에 직접 입력한 내용을 파일처럼 읽는 것과 같음.<br><br>

예시:<br>
`let input = fs.readFileSync('/dev/stdin');`<br>
➡️ 사용자가 터미널에 입력한 내용을 그대로 읽어와서 변수에 저장

