## 사용이 완료된 객체의 참조를 해제하라
- 사용하지 않는 객체에 대한 참조를 제거하여 가비지 컬렉터가 해당 객체를 회수할 수 있도록 해야 한다. 
- 더 이상 필요하지 않은 객체의 참조를 명시적으로 해제하거나, 참조를 관리하는 컨테이너 구조를 적절히 설계해야 한다.

### 메모리 누수의 원인
- 자체적으로 관리되는 메모리 누수
    - 자바 컬렉션 클래스에 객체를 추가한 뒤 삭제하지 않으면 참조가 유지된다
    - 컬렉션에 객체를 넣고 필요 없어졌음에도 제거하지 않으면 누수가 발생한다
- 캐시
    - 캐시에 저장된 객체가 계속 참조되고 있으면 가비지 컬렉터가 해당 객체를 회수하지 못한다.
    - 약한 참조(Weak Reference)를 사용하거나 적절한 제거 정책을 구현해야 한다.
- 리스너와 콜백
    - 이벤트 리스너나 콜백은 등록된 이후 명시적으로 제거하지 않으면 참조가 유지된다.
    - 강한 참조를 방지하기 위해 약한 참조를 사용하는 것이 좋다.
### 해결 방법
- 다 쓴 객체 참조를 null로 설정
    - 객체 참조가 더 이상 필요하지 않을 때 null로 설정하여 가비지 컬렉터가 이를 회수할 수 있도록 한다.
    - 대부분의 경우, 이는 불필요하고 잘못된 설계의 신호로 간주된다.
- 적절한 범위를 벗어나게 설계
    - 객체를 더 이상 사용할 수 없는 범위로 설계하여 자동으로 참조가 해제되도록 한다.
- 약한 참조(Weak Reference)를 활용하여 참조가 없어질 경우 자동으로 제거되도록 한다.
- 적절한 데이터 구조 사용
  - 객체가 참조될 필요가 없는 경우에는 적절히 제거하도록 설계한다.
  - 예를 들어, try-with-resources 구문을 사용하여 리소스를 자동으로 닫는다.

### 예시
- 다 쓴 객체 참조를 null로 설정
```java
public class Stack {
    private Object[] elements;
    private int size;
    private static final int DEFAULT_INITIAL_CAPACITY = 16;

    public Stack() {
        elements = new Object[DEFAULT_INITIAL_CAPACITY];
    }

    public void push(Object e) {
        ensureCapacity();
        elements[size++] = e;
    }
    
    // 가비지 컬렉터가 객체를 회수하지 않는다.
    public Object pop() {
        if (size == 0)
            throw new EmptyStackException();

        return elements[--size];
    }

    private void ensureCapacity() {
        if (elements.length == size) {
            elements = Arrays.copyOf(elements, size * 2 + 1);
        }
    }
}

// 게대로 구현한 메서드
public Object pop() {
    if (size == 0)
        throw new EmptyStackException();
    
    Object result = elements[--size];
    elments[size] = null; // 참조 해제
    
    return result;
}
```
- WeakHashMap을 활용한 캐시 관리
```java
import java.util.WeakHashMap;

public class Cache {
private final WeakHashMap<String, Object> cache = new WeakHashMap<>();

    public void put(String key, Object value) {
        cache.put(key, value);
    }

    public Object get(String key) {
        return cache.get(key);
    }
}
```
