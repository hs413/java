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

    public static void mapTest() {
        Map<String, Integer> ageOfFriends = Map.of("B", 12, "A", 13);

        // map forEach
        for(Map.Entry<String, Integer> entry : ageOfFriends.entrySet()) {
            String friend = entry.getKey();
            Integer age = entry.getValue();
            System.out.println(friend + " is " + age + " years old");
        }

        ageOfFriends.forEach((key, value) -> System.out.println(key + " is " + value));

        // map sort
        Map<String, String> favouriteMovies = Map.ofEntries(
                Map.entry("R", "S"),
                Map.entry("C", "M"),
                Map.entry("O", "J"));

        favouriteMovies
                .entrySet()
                .stream()
                .sorted(Entry.comparingByKey())
                .forEachOrdered(System.out::println);

        // getOrDefault
        System.out.println(favouriteMovies.getOrDefault("R", "S"));
        System.out.println(favouriteMovies.getOrDefault("T", "M"));

        // computeIfAbsent 키가 없으면 맵에 추가, 있으면 기존 값을 반환
        Map<String, List<String>> friendsToMovies = new HashMap<>();
        String friend = "Raphael";
        List<String> movies = friendsToMovies.get(friend);
        if (movies == null) {
            movies = new ArrayList<>();
            friendsToMovies.put(friend, movies);
        }

        movies.add("S");
        System.out.println(friendsToMovies);

        friendsToMovies.computeIfAbsent(friend, k -> new ArrayList<>())
                .add("S");
        System.out.println(friendsToMovies);

        Map<String, String> favouriteMovies2 = new HashMap<>();
        favouriteMovies2.put("R", "S");
        favouriteMovies2.put("T", "M");

        // 키가 특정 값과 연관되었을 때만 제거
        // favouriteMovies2.remove("R", "SS");
        favouriteMovies2.remove("R", "S");
        System.out.println(favouriteMovies2);

        favouriteMovies2.replaceAll((f, movie) -> movie.toLowerCase());
        System.out.println(favouriteMovies2);

        Map<String, String> family = Map.of(
                "Teo", "Star Wars",
                "Cristina", "James Bond");

        Map<String, String> friends = Map.of("Raphael", "Star Wars","Cristina", "Matrix");

        Map<String, String> everyone = new HashMap<>(family);
        everyone.putAll(friends);
        System.out.println(everyone);

        Map<String, String> everyone2 = new HashMap<>(family);
        friends.forEach((k, v) -> everyone2.merge(k, v, (movie1, movie2) -> movie1 + " & " + movie2));
        System.out.println(everyone2);

    }
}
