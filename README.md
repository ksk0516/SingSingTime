## Commit Convention
- Udacity Style 커밋 양식
```
커밋 메시지 양식

type: Subject

ex) 
docs: Update README.md
feat: Add 로그인 유효성 검사 기능
feat: Add Openvidu 컨트롤러 기능
fix: Modify 비밀번호 유효성 체크 기능
```

</br>

**type 규칙**
- feat: 새로운 기능 추가
- fix: 버그 수정
- docs: 문서 수정
- style: 코드 포맷 변경, 세미콜론 누락, 코드 변경 없음
- refactor: 프로덕션 코드 리팩터링
- test: 테스트 추가, 테스트 코드 리팩터링, 프로덕션 코드 변경 없음
- chore: 빌드 테스크 업데이트, 패키지 매니저 환경설정, 프로덕션 코드 변경 없음

</br>

**Subject 규칙**
- 동사(ex. Add, Update, Modify)로 시작
- 첫 글자 대문자
- 끝에 마침표 x


</br></br></br>

## Jira Convention

**Epic**

  - 큰 파트 생성
  - [단계] ~~~
  ex)
  [기획] 자료 탐색
  [기본기능] 로그인
  [필수기능] 플레이룸 사용
  [심화기능] 영상 커스터마이징


**Story**
  - 사용자 행위 생성
  - 사용자는 ~~~할 수 있다
  ex)
  사용자는 회원가입할 수 있다
  사용자는 플레이룸을 생성할 수 있다.


**Task**

  - 개발자 업무 생성
  - Story point는 4시간 이하 할당
  - [포지션] ~~~ 정의/구현/설계/학습
  ex)
  [BE] 유저 엔티티 설계 
  [FE] 회원가입 기능 구현



