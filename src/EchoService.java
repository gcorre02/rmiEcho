/**
 * Created by user on 16-04-2014.
 */
import java.rmi.Remote;
import java.rmi.RemoteException;
/**
 * An implementation of the echo service.
 * this is the interface for the server class.
 */
public interface EchoService extends Remote {
    /**
     * Returns the same string passed as parameter
     * @param s a string
     * @return the same string passed as parameter
     */
    public String echo(String s) throws RemoteException;

    public String run() throws RemoteException;
}