package design.templatemethod;

class Database {
    public static Customer getCustomerWithId(int id) {
        return new Customer();
    }

}

class Consumer<T> {
    public void accept(T t) {

    }
}

public abstract class OnlineBanking {
    public void processCustomer(int id) {
        Customer c = Database.getCustomerWithId(id);
        makeCustomerHappy(c);
    }

    abstract void makeCustomerHappy(Customer c);



    public void processCustomer(int id, Consumer<Customer> makeCustomerHappy) {
        Customer c = Database.getCustomerWithId(id);
        makeCustomerHappy.accept(c);
    }
}

