package resources;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class ResourceCloseTest {
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

    // try-with-resources 사용
    static String firstLineOfFile2(String path) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            return br.readLine();
        }
    }

    static void copy2(String src, String dst) throws IOException {
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
    static String firstLineOfFile3(String path, String defaultVal) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            return br.readLine();
        } catch (IOException e) {
            return defaultVal;
        }
    }
}
