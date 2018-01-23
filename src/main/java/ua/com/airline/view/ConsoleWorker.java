package ua.com.airline.view;

import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Владислав on 23.01.2018.
 */
public class ConsoleWorker implements UIWorker {
    private int selectedVar;
    private BufferedReader bufferedReader;
    private Logger logger = Logger.getRootLogger();

    private ConsoleWorker() {
        bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        logger.info("Crated instance " + this.toString());
    }

    private static class Holder{
    private final static  ConsoleWorker consoleWorker = new ConsoleWorker();
    }
    public static ConsoleWorker getInstance(){
        return Holder.consoleWorker;
    }
    @Override
    public int executeMenu(){
        showMenu();
        try {
            selectedVar = Integer.parseInt(bufferedReader.readLine());
            logger.info("Selected var " + selectedVar);
        } catch (IOException e) {
            e.printStackTrace();
            logger.error("Error in getting var from console " + e);
        }
        return selectedVar;
    }
    private void showMenu(){
        System.out.println("Welcome in airline!!! \n"  +
                "Pls your choice:");
    }

}
