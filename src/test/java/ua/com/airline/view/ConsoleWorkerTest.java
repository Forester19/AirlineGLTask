package ua.com.airline.view;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.*;

import java.io.BufferedReader;
import java.security.Principal;

import static org.junit.Assert.*;

/**
 * Created by Владислав on 23.01.2018.
 */
public class ConsoleWorkerTest {
    private BufferedReader bufferedReader;
    private ConsoleWorker consoleWorker;
    @Before
    public void setUp() throws Exception {
    bufferedReader = mock(BufferedReader.class);
    consoleWorker = ConsoleWorker.getInstance();
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void showMenu() throws Exception {
        when(bufferedReader.readLine()).thenReturn("1");
        assertEquals(consoleWorker.executeMenu(),"1");

        verify(bufferedReader).readLine();
        verifyNoMoreInteractions(bufferedReader);

    }

    @Test
    public void getStringParams() throws Exception {
        boolean a = consoleWorker.validationFuelParams("15-23");
        System.out.println(a);
    }

}