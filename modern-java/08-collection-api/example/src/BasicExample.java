import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import transaction.Trader;
import transaction.Transaction;

public class BasicExample {
    public static void removeIfTest() {
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");

        List<Transaction> transactions = List.of(
                new Transaction(brian, 2011, 300, "12"),
                new Transaction(raoul, 2012, 1000, "12"),
                new Transaction(raoul, 2011, 400, "12"),
                new Transaction(mario, 2012, 710, "12"),
                new Transaction(mario, 2012, 700, "12"),
                new Transaction(alan, 2012, 950, "12")
        );

        // 에러
        /*for (Transaction t : transactions) {
            if (Character.isDigit(t.getReferenceCode().charAt(0))) {
                transactions.remove(t);
            }
        }*/

        // 예전 코드
        for (Iterator<Transaction> iterator = transactions.iterator(); iterator.hasNext();) {
            Transaction transaction = iterator.next();
            if (Character.isDigit(transaction.getReferenceCode().charAt(0))) {
                iterator.remove();
            }
        }

        // removeIf
        transactions.removeIf(transaction -> Character.isDigit(transaction.getReferenceCode().charAt(0)));
    }

    public static void replaceAllTest() {
        List<String> referenceCodes = List.of("a12", "C14", "b13");

        // 새로운 컬렉션을 생성
        referenceCodes.stream()
                .map(code -> Character.toUpperCase(code.charAt(0)) + code.substring(1))
                .collect(Collectors.toUnmodifiableList())
                .forEach(System.out::println);

        // 기존 컬렉션 변경
        for (ListIterator<String> iterator = referenceCodes.listIterator(); iterator.hasNext();) {
            String code = iterator.next();
            iterator.set(Character.toUpperCase(code.charAt(0)) + code.substring(1));
        }

        // replaceAll
        referenceCodes.replaceAll(code -> Character.toUpperCase(code.charAt(0)) + code.substring(1));
    }
;








    }
}
