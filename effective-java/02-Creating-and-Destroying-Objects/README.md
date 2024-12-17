# 객체 생성과 파괴

## [팩터리 메서드](./docs/FectoryMethod.md)
## [빌더 패턴](./docs/Builder.md)
## [싱글턴](./docs/Builder.md)

## 인스턴스화를 막기 위해서는 private 생성자를 사용

## 자원을 직접 명시하지 말고 의존 객체 주입을 사용

## 불필요한 객체 생성은 피하라

```java
String s = String("aa"); // 절대 금지

String s = "aa"; // 좋음
```
- 문자열을 리터럴로 사용하는 경우 같은 문자열을 사용하는 코드가 같은 객체를 재사용함을 보장한다
- 박싱타입 보다는 기본 타입을 사용하는 것을 권장한다.

## [객체 참조](./docs/Reference.md)
