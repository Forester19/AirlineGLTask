package ua.com.airline;

import ua.com.airline.sevice.ConsoleExecution;
import ua.com.airline.view.ConsoleWorker;
import ua.com.airline.view.UIWorker;

import java.io.IOException;

/**
 * Created by Владислав on 24.01.2018.
 */
public class AirlineStarter {
    public static void main(String[] args) {
        Airline airline = Airline.getInstance();
        UIWorker consoleWorker = new ConsoleWorker();

        ConsoleExecution consoleExecution = new ConsoleExecution(consoleWorker,airline);
        try {
            consoleExecution.doExecution();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
