## 람다와 스트림

### 익명 클래스 대신 람다 사용

- 추상 메서드를 한 개만 갖는 인터페이스를 함수형 인터페이스(함수 객체)라고 한다.
- 익명 클래스를 활용하여 함수형 인터페이스를 구현하는 경우 코드가 너무 길어진다. (함수형 프로그래밍에 적합하지 않음)
```java
// 익명 클래스의 인스턴스를 함수 객체로 사용 - 옛 기법
Collections.sort(words, new Comparator<String>() {
    public int compare(String o1, String o2) {
        return Integer.compare(o1.length(), o2.length());
    }
});

```
- 자바 8에서 추가된 람다식을 사용하여 함수형 인터페이스를 구현하기 쉬워졌다.
```java
// 람다식을 함수 객체로 사용 - 익명 클래스 대체
Collections.sort(words,
        (s1, s2) -> Integer.compare(s1.length(), s2.length()));
```
- 람다, 매개변수, 반환값의 타입은 컴파일러가 문맥을 통해 추론한다.
- 타입을 명시해야 코드가 더 명확한 경우를 제외하고 람다의 모든 매개변수 타입은 생략하는 것을 권장.

```text
컴파일러가 타입을 추론하는 데 필요한 타입 정보 대부분은 제네렉을 통해 얻는다. 
위 코드에서 words가 List<String>이 아니라 List(raw 타입)로 선언되었다면 컴파일 오류가 발생한다.
제네릭을 타입을 제공하지 않으면 컴파일러가 람다의 타입을 추론할 수 없게 되어 타입을 일일이 명시해야 한다. 
```
```java
// 비교자 생성 메서드를 사용하여 코드를 더 간결하게 만들 수 있다.
Collections.sort(words, comparingInt(String::length);

// 자바 8 때 List 인터페이스에 추가된 sort 메서드를 이용하면 더 간결해진다.
words.sort(comparingInt(String::length));
```
**열거형 에서 람다 사용**

```java
import java.util.function.DoubleBinaryOperator;

// 상수별 클래스 몸체와 데이터를 사용한 열거 타입
public enum Operation {
    PLUS("+") {
        public double apply(double x, double y) {
            return x + y;
        }
    },
    PLUS("-") {
        public double apply(double x, double y) {
            return x - y;
        }
    },
    PLUS("*") {
        public double apply(double x, double y) {
            return x * y;
        }
    },
    PLUS("/") {
        public double apply(double x, double y) {
            return x / y;
        }
    };

    private final String symbol;

    Operation(String symbol) {
        this.symbol = symbol;
    }

    public abstract double apply(double x, double y);
}

// 함수 객체를 인스턴스 필드에 저장해 상수별 동작을 구현한 열거 타입
public enum Operation {
    PLUS("+", (x, y) -> x + y),
    PLUS("-", (x, y) -> x - y),
    PLUS("*", (x, y) -> x * y),
    PLUS("/", (x, y) -> x / y);

    private final String symbol;

    /**
     * @DoubleBinaryOperator
     * java.util.function 패키지가 제공하는 함수 인터페이스 중 하나
     * double 타입 인수 2개를 받아 double 타입 결과를 반환한다.
     */
    private final DoubleBinaryOperator op;
     
    Operation(String symbol, DoubleBinaryOperator op) {
        this.symbol = symbol;
        this.op = op;
    }
    
    public double apply(double x, double y) {
        return op.applyAsDouble(x, y);
    }
}

```
- 람다는 이름이 없고 문서화를 못 한다.
- 코드 자체로 동작이 명확히 설명되지 않거나 코드 줄 수가 많아지면 람다 사용을 지양해야한다.

### 람다보다 메서드 참조를 사용
```java
// 람다
map.merge(key, 1, (count, incr) -> count + incr);

// 메서드 참조
map.merge(key, 1, Integer::sum);
```
###  