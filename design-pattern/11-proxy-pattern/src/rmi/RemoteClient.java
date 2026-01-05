package rmi;

import java.rmi.Naming;

public class RemoteClient {

    public static void main(String[] args) {
        new RemoteClient().go();
    }

    public void go() {
        try {
            MyRemote service = (MyRemote) Naming.lookup("rmi://127.0.0.1/remote");

            String s = service.sayHello();

            System.out.println(s);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
