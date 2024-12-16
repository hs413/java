## 생성자 대신 정적 팩터리 메서드 사용
클래스의 인스턴스를 반환하는 단순 정적 메서드
```java
public static Boolean valueOf(boolean b) {
    return b ? Boolean.TRUE : Boolean.FALSE;
}
```
### 장점
**1. 이름을 가질 수 있다**
- 생성자 만으로는 반환될 객체의 특성을 제대로 설명하기 어렵다.
- 정적 팩터리는 이름만 잘 지으면 객체의 특성을 쉽게 묘사할 수 있다.


- 하나의 시그니처로는 생성자를 하나만 만들 수 있다.
- 입력 매개변수의 순서를 변경하여 여러 생성자를 만들 수 있지만 역할을 파악하기 힘들다.
```java
public class A {
    // 여러 생성자를 만들 수 있지만 역할을 파악하기 힘들다
    public A(String a) { }
    public A(int a) { }
    public A(String a, int b) { }
} 
```
- 한 클래스에 시그니처가 같은 생성자가 여러 개 필요할 것 같으면 
생성자를 정적 팩터리 메서드로 바꾸고 차이를 잘 드러내는 이름을 지어주는 것을 권장한다.
```java
// 정적 팩터리 메서드 예시
public class User {
    private String name;
    private int age;

    // private 생성자
    private User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // 정적 팩터리 메서드
    public static User of(String name, int age) {
        return new User(name, age);
    }
}

User user = User.of("Alice", 25);
```

**2. 호출될 때마다 인스턴스를 새로 생성하지 않아도 된다.**
- 불변 클래스의 인스턴스를 미리 만들어 놓거나 새로 생성한 
인스턴스를 캐싱하여 재활용하여 불필요한 객체 생성을 피할 수 있다.
  - **플라이웨이트 패턴**

- 팩터리 방식의 클래스는 인스턴스를 철저히 통제할 수 있으며 이를 인스턴스 통제 클래스라 한다.
```java
Boolean b1 = Boolean.valueOf(true); // 캐싱된 객체 반환
Boolean b2 = Boolean.valueOf(true); // b1과 동일 객체

// 캐싱된 객체 반환
public class DatabaseConnection {
    private static final DatabaseConnection INSTANCE = new DatabaseConnection();

    private DatabaseConnection() {
        // private 생성자
    }

    // 캐싱된 싱글톤 반환
    public static DatabaseConnection getInstance() {
        return INSTANCE;
    }
}

// 사용 예
DatabaseConnection db1 = DatabaseConnection.getInstance();
DatabaseConnection db2 = DatabaseConnection.getInstance();

System.out.println(db1 == db2); // true
```
**3. 반환 타입의 하위 타입 객체를 반환할 수 있다.**
- 반환할 객체의 클래스를 선택할 수 있게 하는 유연성을 제공한다.
- 구체적인 구현 클래스를 숨길 수 있어 API를 작게 유지할 수 있다.


```java
public static List<String> newInstance() {
    return new ArrayList<>();
}

// 예시
interface Payment {
    void pay();
}

class CreditCardPayment implements Payment {
    public void pay() {
        System.out.println("Paying with Credit Card");
    }
}

class PayPalPayment implements Payment {
    public void pay() {
        System.out.println("Paying with PayPal");
    }
}

public class PaymentFactory {
    public static Payment getPayment(String method) {
        if ("credit".equals(method)) {
            return new CreditCardPayment();
        } else if ("paypal".equals(method)) {
            return new PayPalPayment();
        }
        throw new IllegalArgumentException("Unknown payment method: " + method);
    }
}

// 사용 예
Payment payment = PaymentFactory.getPayment("credit");
payment.pay(); // Paying with Credit Card
```

**4. 입력 매개변수에 따라 다른 객체를 반환할 수 있다.**
- 하위 클래스이기만 하면 다른 클래스를 반환하도록 쉽게 변경 가능하다. (3번과 비슷함)

**5. 정적 팩터리 메서드를 작성하는 시점에는 반환할 객체의 클래스가 존재하지 않아도 됨**
- **서비스 제공자 프레임워크**를 구현하는 근간이 된다. (대표적으로 JDBC가 있다)
  - 서비스 제공자 프레임워크에서 제공자는 서비스의 구현체다.
  - 구현체들을 클라이언트에게 제공하는 역할을 프레임워크가 통제하여, 클라이언트를 구현체로부터 분리해준다.
- 서비스 제공자 프레임워크는 3개의 핵심 컴포넌트로 이뤄진다.
  - 구현체의 동작을 정의하는 서비스 인터페이스
  - 제공자가 구현체를 등록할 때 사용하는 제공자 등록 API
  - 클라이언트가 서비스의 인스턴스를 얻을 때 사용하는 서비스 접근 API
- **브릿지 패턴**

### 단점
- 상속을 하려면 public 생성자가 필요하므로 정적 팩터리 메서드만 제공하면 하위 클래스를 만들 수 없다.
- 정적 팩터리 메서드는 다른 정적 메서드와 확연히 구분되지 않는다.

### 명명 방식
- from: 매겨변수를 하나 받아서 해당 타입의 인스턴스를 반환하는 형변환 메서드
- of: 여러 매개변수를 받아 적합한 타입의 인스턴스를 반환하는 집계 메서드
- valueOf: from과 of의 자세한 버전
- instance 혹은 getInstance: 매개변수로 명시한 인스턴스를 반환, 각은 인스턴스임을 보장하지는 않는다.
  - StackWalker luke = StackWalker.**getInstance**();
- create 혹은 newInstance: instance와 같지만, 항상 새로운 인스턴스를 생성해 반환함을 보장한다.
  - Object newArray - Array.**newInstance**();
- getType: getInstance와 같으나, 생성할 클래스가 아닌 다른 클래스의 팩터리 메서드를 정의
  - FileStore fs = Files.**getFileStore**();
- newType: newInstance와 같으나, 생성할 클래스가 아닌 다른 클래스의 팩터리 메서드를 정의
  - BufferedReader br = Files.**newBufferedReader**();
- type: getType과 newType의 간결한 버전
  - Collections.**list**();