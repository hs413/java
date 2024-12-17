## try-finally 대신 try-with-resources를 사용
- 회수해야 하는 자원을 다룰 때는 반드시 try-with-resources 사용
- 코드가 간결해지고, 예외 정보도 유용하다

- try-finally를 사용한 자원 회수
```java
    // 자원이 하나인 경우
    static String firstLineOfFile(String path) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(path));
        try {
            return br.readLine();
        } finally {
            br.close();
        }
    }

    // 자원이 둘 이상인 경우
    static void copy(String src, String dst) throws IOException {
        InputStream in = new FileInputStream(src);
        try {
            OutputStream out = new FileOutputStream(dst);
            try {
                byte[] buf = new byte[1024];
                int n;
                while( (n = in.read(buf)) >= 0 ) {
                    out.write(buf, 0, n);
                }
            } finally {
                out.close();
            }
        } finally {
            in.close();
        }
    }
```
- try-with-resources를 사용한 자원 회수
```java
    // try-with-resources 사용
    static String firstLineOfFile(String path) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            return br.readLine();
        }
    }

    static void copy(String src, String dst) throws IOException {
        try (InputStream in = new FileInputStream(src)) {
            try (OutputStream out = new FileOutputStream(dst)) {
                byte[] buf = new byte[1024];
                int n;
                while( (n = in.read(buf)) >= 0 ) {
                    out.write(buf, 0, n);
                }
            }
        }
    }

    // try-with-resources와 catch절 사용
    static String firstLineOfFile(String path, String defaultVal) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            return br.readLine();
        } catch (IOException e) {
            return defaultVal;
        }
    }
```








