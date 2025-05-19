# 버퍼(Buffer)란?
- 어떤 장치에서 다른 장치로 데이터를 송신할 때 일어나는 시간의 차이나 데이터 흐름의 속도 차이를 조정하기 위해 일시적으로 데이터를 기억시키는 장치
-> 데이터를 잠깐 저장하는 **임시 저장 공간**
- 한번에 여러 데이터를 처리할 수 있도록 도와줌
- **입출력(I/O) 속도를 높이는 역할** 

### 🥊 Scanner vs Buffer
```java
Scanner sc = new Scanner(System.in);
```
Scanner : 한 글자, 한 줄 읽을 때마다 **바로 처리**
```java
BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
```
Buffer : **모았다가 한 번에 처리**
<br>

# import package
I/O(입출력) 관련 클래스 `java.io` 패키지 import
```java
import java.io.*;
```
또는
```java
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException; 
```
- `ctrl+shift+O` 단축키를 사용하여 import할 수 있다. 

<br>

# `main` 메서드에서의 예외 처리
`BufferedReader.readLine()`은 예외(IOException)를 발생시킬 수 있기 때문에, `main()` 메서드에 아래처럼 `throws IOException` 을 붙이거나 `try-catch`를 써야 한다.
```java
public static void main(String[] args) throws IOException {
    // 여기에 코드 작성
}
```
예외 상황 ex) 
- 사용자가 입력을 안 했거나
- 입력 도중 키보드 연결이 끊겼거나
- 내부적으로 스트림 오류가 났거나
- etc ...

<br>


# BufferedReader 빠른 입력
### 1️⃣ 기본 구조
```java
BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
```
- `BufferedReader` : **줄 단위**로 입력, **버퍼를 통해 빠르게 처리** 
- `InputStreamReader` : 바이트 -> 문자 변환 (보조 스트림) 
- `System.in` : 키보드 입력 (바이트 단위) 

### 2️⃣ 줄 입력 받기
```java
String line = br.readLine(); // 한 줄 전체 입력
```
### 3️⃣ 숫자 입력 받기 (공백 기준)
```java
String[] input = br.readLine().split(" ");
int a = Integer.parseInt(input[0]);
int b = Integer.parseInt(input[1]);
```
### String 입력 받기 
```java
 // 1. String 입력 받기
 System.out.print("문자열 입력: ");
 String str = br.readLine();
 System.out.println("입력받은 문자열: " + str);
```
### Char 입력 받기
```java
// 2. char 입력 받기 (첫 번째 문자만 사용)
System.out.print("문자 입력: ");
char ch = (char) br.read();  // 한 문자만 읽음
br.readLine(); // 남은 개행 문자 제거
System.out.println("입력받은 문자: " + ch);
```
### int 입력 받기
```java
// 3. int 입력 받기
System.out.print("정수 입력: ");
int num = Integer.parseInt(br.readLine());
System.out.println("입력받은 정수: " + num);
```




<br>

# BufferWirter 빠른 출력 
### 1️⃣ 기본 구조
```java
BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
```
- `BufferedWriter` : 버퍼에 출력 내용을 모아 두었다가 한꺼번에 출력
- `OutputStreamWritter` : 문자 스트림으로 변환
- `System.out` : 화면 출력 (바이트 단위)
### 2️⃣ 출력 쓰기
```java
bw.write("Hello\n"); // println과 달리, 개행 직접 써야 함
```
### 3️⃣ 버퍼 비우기
```java
bw.flush(); // 버퍼에 남은 내용을 강제로 출력
bw.close(); // 스트림 닫기 (flush 포함됨)
```
- `flush()` : 버퍼에 있는 내용을 강제로 출력하는 메서드. flush()를 하지 않으면 버퍼에만 있고 실제 출력이 되지 않음. 
- `close()` : 스트림을 닫는 동작. 닫기 전에 자동으로 `flush()`를 호출한다. 버퍼 비우기, 메모리 해제 등을 하며 이후에는 해당 스트림을 사용하지 못한다. 

### 4️⃣ flush() vs close()
```java
bw.write("출력할 문자열\n");
bw.write("출력할 문자열\n");
bw.write("출력할 문자열\n");
bw.flush();		// 버퍼의 내용을 비움
bw.write("버퍼 비운 후 다시 출력");
bw.flush();		// 버퍼의 내용을 비움
bw.close();		// 버퍼의 메모리를 해제함 
```
![](https://velog.velcdn.com/images/yurisekai/post/7c5f9879-6bc6-416e-ae0d-f05a50d6edcf/image.png)



<br>

# ⚠ 스트림 Stream
> **데이터가 흐르는 통로**

- 자바에서 데이터를 읽고 쓰는 연속적인 데이터 흐름 통로
- InputStream/Reader는 데이터를 읽을 때, OutputStream/Writer는 데이터를 쓸 때 사용되며, 문자 또는 바이트 단위로 나뉜다.
- 파일, 키보드, 콘솔, 네트워크 등 다양한 입출력 작업을 효율적으로 처리하기 위해 스트림을 사용한다.
