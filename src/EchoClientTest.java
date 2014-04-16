import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by user on 16-04-2014.
 */
public class EchoClientTest {
    UserInterface ui;
    EchoClient ec;
    @Before
    public void setUp() throws Exception {
        ui = mock(UserInterface.class);
        ec = new EchoClient(ui);

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testMain() throws Exception {
        when(ui.readFromUser()).thenReturn("Sending","Stuff","To","The","Server","Dynamically","close");
        ec.run();
    }
}
