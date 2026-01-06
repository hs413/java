import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class GumballMachine extends UnicastRemoteObject implements GumballMachineRemote {
    private static final long serialVersionUID = 2L;
    String location;

    public GumballMachine(String location, int numberGumballs) throws RemoteException {
        this.location = location;
    }

    public String getLocation() {
        return location;
    }
}
