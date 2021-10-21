# URI와 웹 브라우저 요청 흐름

* URI
* 웹 브라우저 요청 흐름

## 1. URI(Uniform Resource Identifier)
* URI는 로케이터(locator), 이름(name) 또는 둘 다 추가로 분류될 수 있다.
* 이는 즉슨 URI 내에 URL, URN이 둘다 포함됨을 알 수 있다.

* URI는 리소스 식별자를 나타내며 URL은 리소스의 위치를, URN은 리소스의 이름을 나타낸다.

- URL(Resource Locator) 예시
  - ``foo: //example.com:8042/over/there?name=ferret#nose``
    - foo = scheme
    - ``example.com:8042`` = authority
    - over/there? = path
    - name = ferret = query
    - nose = fragment

- URN(Resource Name) 예시
  - ``urn:example:animal:ferret:nose``
    - urn =  scheme
    - example:animal:ferret:nose = path

### URI 개념
- Unifrom: 리소스 식별하는 **통일된 방식**
- Resource: 자원, URI로 식별할 수 있는 모든 것(제한 없음)
- Identifier: 다른 항목과 구분하는데 필요한 정보

### URL, URN 개념
- URL - Locator: 리소스가 있는 위치를 지정
- URN - Name: 리소스에 이름을 부여
- 위치는 변할 수 있지만, 이름은 변하지 않는다.
- urn:isbn:896077731 (어떤 책의 isbn URN)
- URN 이름 만으로 실제 리소스를 찾을 수 있는 방법이 보편화 되지 않음

1. URL
   - 프로토콜: https
   - 호스트명(``www.google.com``)
   - 포트 번호(443)
   - 패스(/search)
   - 쿼리 파라미터(q=hello&hl=ko)
  
2. Scheme
   - 주로 프로토콜 사용
   - 프로토콜: 어떤 방식으로 자원에 접근할 것인가 하는 약속 규치
     - 예) http, https, ftp 등등
   - http는 80 포트, https는 443 포트를 주로 사용, 포트는 생략 가능
   - https는 http에 보안추가(HTTP Secure)
  
3. Userinfo
   - URL에 사용자 정보를 포함해서 인증
   - 거의 사용하지 않음
  
4. Host
    - 호스트명
    - 도메인명 또는 IP 주소를 직접 사용가능

5. Port
    - 포트(port)
    - 접속 포트
    - 일반적으로 생략, 생략 시 http는 80, https는 443

6. path
    - 리소스 경로(path), 계층적 구조
    - 예)
      - /home/file1.jpg
      - /members
      - members/100, /items/iphone12
7. query
    - key=value 형태
    - ?로 시작, &로 추가 가능 ?keyA=Value&keyB=valueB
    - query parameter, query string 등으로 불림,웹서버에 제공하는 파라미터, 문자형태
8. fragment
    - fragment
    - html 내부 북마크 등에 사용
    - 서버에 전송하는 정보 아님

## 2. 웹 브라우저 요청 흐름
``https://www.google.com:443/search?q=hello&hl=ko``
<u>``www.google.com:443``</u>: DNS조회 및 https port 생략, 443 => HTTP 요청 매사자 생성

- HTTP 요청 메시지
``GET /search?q=hello&hl=ko HTTP/1.1``
``Host: www.google.com``

1. 웹 브라우저가 HTTP 메시지 생성
2. SOCKET 라이브러리를 통해 전달
   A: tcp/ip 연결(ip/port)
   B: 데이터 전달
3. tcp/ip 패킷 생성, HTTP 메시지 포함

- HTTP 응답 메시지
``HTTP/1.1 200 OK``
``Content-Type: text/html;charset=UTF-8``
``Content-Length:3423``

    ``<html>``
    `` <body></body>``
    ``</html>``

이후 웹 브라우저에서 HTML 렌더링을 수행한다.