import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Created by user on 16-04-2014.
 */
public class EchoClient {
    public static void main(String[] args) {
        Remote service = null;
        try {
            service = Naming.lookup("//192.168.1.75:1099/echo");//for host computer needs to be 127.0.0.1
        } catch (NotBoundException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        EchoService echoService = (EchoService) service;
        try {
            for(String input : args){
                System.out.println(echoService.echo(input));
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
}
