## private 생성자나 열거 타입으로 싱글턴임을 보증

### 싱글턴
- 인스턴스를 하나만 생성할 수 있는 클래스
- 함수 같은 무상태 객체나 설계상 유일해야 하는 시스템 컴포넌트
- 클라이언트를 테스트하기 어려워질 수 있다.

### 생성방법
- 생성자는 private으로 감추고 인스턴스에 접근할 수단으로 public static 멤버를 제공한다.

1. public static final 필드 방식
```java
public class Elvis {
    public static final Elvis INSTANCE = new Elvis(); // public
    private Elvis() {}
    
    public void leaveTheBuilding() {}
}
```
- private 생성자는 INSTANCE를 초기화할 때 한 번만 호출된다.
- 클래스가 싱글턴임이 API에 명백히 드러난다.
- 간결함

2. 정적 팩터리 방식
```java
public class Elvis {
    private static final Elvis INSTANCE = new Elvis(); // private
    private Elvis() {}
    public static Elvis getInstance() { return INSTANCE; } // 추가
    
    public void leaveTheBuilding() {}
}
```
- API를 바꾸지 않고도 변경 가능하다.
- 스레드별로 다른 인스턴스를 넘겨주게 할 수 있다.
- 제네릭 싱글턴 팩터리로 만들 수 있다. 
- 메서드 참조를 공급자로 사용 가능
- 위의 두 방식은 직렬화 시 추가적인 코드 구현이 필요하다

3. 열거 타입 방식
```java
public enum Elvis {
    INSTANCE;

    public void leaveTheBuilding() {}
}
```
- public 방식과 비슷하나, 더 간결하고 추가적인 노력없이 직렬화가 가능하다
- 리플렉션 공격도 방지된다
- 가장 좋은 방법



