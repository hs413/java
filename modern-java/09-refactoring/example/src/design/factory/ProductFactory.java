package design.factory;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class ProductFactory {
    public static Product createProduct(String name) {
        switch (name) {
            case "loan": return new Loan();
            case "stock": return new Stock();
            case "bond": return new Bond();
                default: throw new RuntimeException("No such product:" + name);
        }

//        Supplier<Product> loanSupplier = Loan::new;
//        Loan loan = loanSupplier.get();
    }

    final static Map<String, Supplier<Product>> map = new HashMap<>();
    static {
        map.put("loan", Loan::new);
        map.put("stock", Stock::new);
        map.put("bond", Bond::new);
    }

    public static Product createProduct2(String name) {
        Supplier<Product> supplier = map.get(name);
        if (supplier != null) return supplier.get();

        throw new RuntimeException("No such product:" + name);
    }
}
