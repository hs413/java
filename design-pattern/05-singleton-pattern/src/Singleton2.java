public enum Singleton2 {
    INSTANCE;
}

class SingletonClient {

    public static void main(String[] args) {
        Singleton2 singleton = Singleton2.INSTANCE;
    }
}