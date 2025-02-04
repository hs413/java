import java.util.Iterator;
import java.util.List;
import transaction.Trader;
import transaction.Transaction;

public class BasicExample {
    public static void test() {
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

}
