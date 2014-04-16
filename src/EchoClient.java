import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
/**
 * Created by user on 16-04-2014.
 */
public class EchoClient {
    private static UserInterface ui;

    public EchoClient(UserInterface uiInput){
        ui = uiInput;
    }

    public static void main(String[] args) {
        EchoClient ec = new EchoClient(ui);
        ec.run();
    }

    public void run() {
        if(ui == null)
            ui = new UserInterface();
        Remote service = null;
        try {
            service = Naming.lookup("//192.168.1.75:1099/echo");
        } catch (NotBoundException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        EchoService echoService = (EchoService) service;
        String input = ui.readFromUser();
        try {
            while(!input.equals("close")){
                System.out.println(echoService.echo(input));
                input = ui.readFromUser();
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

}
