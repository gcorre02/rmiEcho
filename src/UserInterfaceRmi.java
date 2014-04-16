/**
 * Created by user on 16-04-2014.
 */
public class UserInterfaceRmi implements UserInterfaceGeneral {
    private EchoServer es ;
    public UserInterfaceRmi(EchoServer echoServer) {
        es = echoServer;
    }

    @Override
    public String readFromUser(String output) {
        return es.echo(output);
    }

    @Override
    public String readFromUser() {
        return es.echo("");
    }

    @Override
    public char getUserAnswer(String aBunchOfChoices) {
        return es.echo(aBunchOfChoices).toUpperCase().charAt(0);
    }
}
