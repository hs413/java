import static java.util.Comparator.*;

import fin.Trader;
import fin.Transaction;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Example {
    public static void test() {
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");

        List<Transaction> transactions = List.of(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );

        // 2011년 트랜잭션 오름차순
        transactions.stream()
                .sorted(comparing(Transaction::getValue))
                .takeWhile(transaction -> transaction.getYear() == 2011)
                .forEach(System.out::println);

//        transactions.stream()
//                .filter(transaction -> transaction.getYear() == 2011)
//                .sorted(comparing(Transaction::getValue))

        System.out.println();
        // 거래자가 근무하는 도시를 중복 없이 나열
        transactions.stream()
                .map(Transaction::getTrader)
                .map(Trader::getCity)
                .distinct()
                .forEach(System.out::println);

//        transactions.stream()
//                .map(transaction -> transaction.getTrader().getCity())
//                .collect(Collectors.toSet())

        System.out.println();

        // 케임브리지에서 근무하는 거래자 이름순 정렬
        transactions.stream()
                .map(Transaction::getTrader)
                .filter(trader -> trader.getCity().equals("Cambridge"))
                .sorted(comparing(Trader::getName))
                .map(Trader::getName)
                .forEach(System.out::println);

//        transactions.stream()
//                .map(Transaction::getTrader)
//                .filter(trader -> trader.getCity().equals("Cambridge"))
//                .distinct()
//                .sorted(comparing(Trader::getName))

        System.out.println();

        // 거래자의 이름을 알파벳순 정렬
        transactions.stream()
                .map(Transaction::getTrader)
                .sorted(comparing(Trader::getName))
                .map(Trader::getName)
                .forEach(System.out::println);

//        transactions.stream()
//                .map(transaction -> transaction.getTrader().getName())
//                .distinct()
//                .sorted()
//                .collect(Collectors.joining());

        System.out.println();

        // 밀라노 거래자가 있는지
        boolean bool1 = transactions.stream()
                .anyMatch(transaction -> transaction.getTrader().getCity().equals("Milan"));

        System.out.println(bool1);
        System.out.println();

        // 케임브리지에 거주하는 거래자의 모든 트랜잭션값
        transactions.stream()
                .filter(transaction -> transaction.getTrader().getCity().equals("Cambridge"))
                .map(Transaction::getValue)
                .forEach(System.out::println);

        System.out.println();

        // 트랜잭션 중 최댓값
        int max = transactions.stream()
                .map(Transaction::getValue)
                .reduce(0, Integer::max);
        System.out.println(max);

        // 트랜잭션 중 최솟값
        Optional<Transaction> minTransaction = transactions.stream()
                .min(Comparator.comparing(Transaction::getValue));
        System.out.println(minTransaction);
    }
}

