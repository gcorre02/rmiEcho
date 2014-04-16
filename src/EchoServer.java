/**
 * Created by user on 16-04-2014.
 */

import menu.LoginMenu;
import persistence.Loader;
import persistence.Saver;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * Implements Echo Service
 * Impl of the Server.
 */
public class EchoServer extends UnicastRemoteObject implements EchoService {
    LoginMenu lm;
    public EchoServer() throws RemoteException {
        String path = "testRmiFiles";
        Loader l = new Loader(path);
        Saver s = new Saver(path);
        UserInterfaceGeneral ui = new UserInterfaceRmi(this);
        lm = new LoginMenu(l,s, (userInterface.UserInterface) ui);
    }

    @Override
    public String echo(String s) {

    // This println is not necessary, but helps verifying whether
    // the server has received the call or not on the remote machine
       // System.out.println("Replied to some client saying ’" + s + "’");
        return s;
    }
    @Override
    public String run() {

        // This println is not necessary, but helps verifying whether
        // the server has received the call or not on the remote machine
        // System.out.println("Replied to some client saying ’" + s + "’");
        lm.run();
        return "Server Running";
    }
}
