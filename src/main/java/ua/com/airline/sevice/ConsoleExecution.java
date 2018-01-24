package ua.com.airline.sevice;

import org.apache.log4j.Logger;
import ua.com.airline.AirlineStarter;
import ua.com.airline.model.Airline;
import ua.com.airline.model.Company;
import ua.com.airline.model.entity.Plane;
import ua.com.airline.view.ConsoleWorker;
import ua.com.airline.view.UIWorker;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


/**
 * Created by Владислав on 23.01.2018.
 */
public class ConsoleExecution {
    private Logger logger = Logger.getRootLogger();
    private UIWorker uiWorker;
    private Company company;

    public ConsoleExecution(UIWorker uiWorker, Company company) {
        this.uiWorker = uiWorker;
        this.company = company;
    }

    public void doExecution() throws IOException {
        ConsoleWorker consoleWorker = (ConsoleWorker) uiWorker;
        Airline airline = (Airline) company;
        int selVar = consoleWorker.executeMenu();
        logger.info("Detected param from user " + selVar);
        if (selVar < 1 || selVar > 5) {
            System.out.println("Bad way number ");
            try {
                restartApplication();
            } catch (URISyntaxException e) {
                logger.error("Error in restarting app " + e);
            }
        }
        if (selVar == 1) {
            for (Plane plane : airline.getAllPlanes()) {
                System.out.println(plane);
            }
        }
        if (selVar == 2) {
            calulatingSummaryPowerAndCarrying(airline);
        }
        if (selVar == 3) {
            sortingPlanesByRange(airline);
        }
        if (selVar == 4) {
            String fuelParams = consoleWorker.getFuelParams();
            List<Plane> newPalnesList = getPlanesByFluentParams(Integer.parseInt(fuelParams.split("-")[0]), Integer.parseInt(fuelParams.split("-")[1]), airline);
            if (newPalnesList == null) {
                System.out.println("No exist planes like your criteria");
            } else {
                for (Plane plane : newPalnesList) {
                    System.out.println(plane);
                }
            }
        }
    }

    /**
     * Method calculate some params of planes.
     * @param airline
     */
     void calulatingSummaryPowerAndCarrying(Airline airline) {
        int sumaryPower = 0;
        int sumaryCarrying = 0;
        for (Plane plane : airline.getAllPlanes()) {
            sumaryPower += plane.getPower();
            sumaryCarrying += plane.getCarrying();
        }
        System.out.println(sumaryPower + " " + sumaryCarrying);
    }

    /**
     * Method sorts by range all planes and return new List
     * Using Comparator
     * @param airline
     */
    private void sortingPlanesByRange(Airline airline) {
        Collections.sort(airline.getAllPlanes(), new Comparator<Plane>() {
            @Override
            public int compare(Plane o1, Plane o2) {
                return o1.getRange() > o2.getRange() ? 1 : -1;
            }
        });
        for (Plane plane : airline.getAllPlanes()) {
            System.out.println(plane);
        }
    }

    /**
     *
     * @param param1 first field of fuel
     * @param param2 second field of fuel
     * @param airline our company
     * @return list of planes witch selected by fuel params
     */
    List<Plane> getPlanesByFluentParams(int param1, int param2, Airline airline) {
        List<Plane> newPlanesList = new ArrayList<>();
        for (Plane plane : airline.getAllPlanes()) {
            if (plane.getFuel() > param1 && plane.getFuel() < param2) {
                newPlanesList.add(plane);
            }
        }
        return newPlanesList;
    }

    public void restartApplication() throws URISyntaxException, IOException {
        final String javaBin = System.getProperty("java.home") + File.separator + "bin" + File.separator + "java";
        final File currentJar = new File(AirlineStarter.class.getProtectionDomain().getCodeSource().getLocation().toURI());

  /* is it a jar file? */
        if(!currentJar.getName().endsWith(".jar"))
            return;

  /* Build command: java -jar application.jar */
        final ArrayList<String> command = new ArrayList<String>();
        command.add(javaBin);
        command.add("-jar");
        command.add(currentJar.getPath());

        final ProcessBuilder builder = new ProcessBuilder(command);
        builder.start();
        System.exit(0);
    }

}
