package design.templatemethod;

public class OnlineBankingLambda extends OnlineBanking{
    @Override
    void makeCustomerHappy(Customer c) {
        System.out.println("Customer is happy");
    }

}
