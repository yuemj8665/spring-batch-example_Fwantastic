## 스프링 배치 연습하기
==
### 1. 참고주소
1. [**Spring Batch 강좌**](https://www.fwantastic.com/p/spring-batch.html)
날짜 : 2021-01-22
   
### 2. 주절주절
    주절주절
    좀 쉬웠다
    이전 삼성에서하던 스프링 배치랑 별반 차이 없어서 그런것 같다.
    복습한다 생각해야겠다.
    이거 적으신분은 아마 더이상 안적으실 예정인가보다. 19년도에 머물러있다.
### 3. TO DO List
    1. Hibernate으로 디비를 읽어서 JSON으로 저장하기
    2. JSON 파일 읽어서 Hibernate으로 디비에 저장하기
    3. Flat file (fixed length) 고정 길이 파일 읽기
    4. CSV 파일 읽어서 CompositeItemProcessor를 사용해 여러번의 가공 과정 거치기
    5. CSV 파일 읽어서 CompositeItemWriter를 사용해 디비와 XML에 둘다 쓰기
    6. 리스너 사용하기
    7. 파티션 사용하기
    8. job parameter validator

    ++ 1,2번은 JsonParser 사용해서 해보자. 
    인터넷에서 Json 예시를 찾아서 해보자.
    자고로 배치란 실행시켜놓으면 특정 시간대에 실행시켜야 한다. 특정 시간대나 일정 주기로 반복실행이 되게끔 만들어보자.

### 4. Error 확인 및 해결법 History



