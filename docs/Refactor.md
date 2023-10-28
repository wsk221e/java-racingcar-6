## 리팩터링 체크리스트

### 문제점 및 해결방안

- [ ] 미흡한 MVC 패턴 적용
    - 현재: 사용자가 View를 통해 직접 입력을 받도록 설계함
        - 사용자는 Controller에게만 명령을 내리는 것이고, Controller는 필요하다면 View를 통해 입력을 받고, 출력을 제공해야 한다.
    - 개선방향: View에서 직접 받는 입력을 Controller로 이전
- [ ] RacingGame 클래스 구조
    - 현재: 기능의 구현에만 집중하다보니 전체적인 구조가 좋지 않음
    - 개선방향: 내부 구조 최적화(메소드), 필요한 경우 클래스 분할(응집도)