import java.rmi.Naming;

public class Test {

    public static void main(String[] args) {
        GumballMachineRemote gumballMachine = null;
        int count = 0;

        if (args.length < 2) {
            System.out.println("Machine <name> <inventory>");
            System.exit(1);
        }

        try {
            count = Integer.parseInt(args[1]);
            GumballMachine gumballMachine = new GumballMachine(args[0], count);

            Naming.rebind("//" + args[0] + "/gumball", gumballMachine);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
