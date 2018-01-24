package ua.com.airline.view;

import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Владислав on 23.01.2018.
 */
public class ConsoleWorker implements UIWorker {
    private int selectedVar;
    private BufferedReader bufferedReader;
    private Logger logger = Logger.getRootLogger();

    public ConsoleWorker() {
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
                "Pls your choice:" +"\n"+ "1 - Show all planes;" + " \n" + "2 - Show summed power and carrying of company planes;"
        + "\n" +"3 - Show sorted planes by range;" + "\n" + "4 - Select plane by fuel consumption; (Pls enter like 14-15);"
        );
    }

    /**
     * Method which using when need fuel params from user;
     * @return String where inside integers like(XX-XX)
     * @throws IOException
     */
    public String getFuelParams() throws IOException {
          String res = bufferedReader.readLine();
          if (validationFuelParams(res)){
              logger.info("Successful validates params " + res);
              return  res;
          }
          else {
              logger.error("Fail in your params ");
            System.exit(1);
          }
          return null;
    }

    /**
     * Method which validate string as params for searching planes by luent
     * @param stringParam must be like XX-XX
     * @return true if expected string like in regex
     */
    boolean validationFuelParams(String stringParam){
        Pattern pattern = Pattern.compile("\\d{1,2}(-)\\d{1,2}");
        Matcher matcher = pattern.matcher(stringParam);
        return matcher.matches();
    }

}
