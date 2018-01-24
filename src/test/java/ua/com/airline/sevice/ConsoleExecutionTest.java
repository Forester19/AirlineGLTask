package ua.com.airline.sevice;

import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import ua.com.airline.model.Airline;
import ua.com.airline.model.entity.Plane;
import ua.com.airline.model.entity.military.Frontline;
import ua.com.airline.view.ConsoleWorker;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Владислав on 24.01.2018.
 */
public class ConsoleExecutionTest {
    private ConsoleExecution consoleExecution;
    private ConsoleWorker consoleWorker;
    private Airline airline;

    @Before
    public void doBefore() throws Exception {
        consoleWorker = Mockito.mock(ConsoleWorker.class);
        airline = Mockito.mock(Airline.class);
      consoleExecution = new ConsoleExecution(consoleWorker,airline);
    }

    @Test
    public void calculate(){
        consoleExecution.calulatingSummaryPowerAndCarrying(airline);
        Mockito.verify(airline).getAllPlanes();
    }
    @Test
    public void getPlanesByFuelParams(){
        Mockito.when(airline.getAllPlanes()).thenReturn(listForTesting());
        Assert.assertEquals(2,consoleExecution.getPlanesByFluentParams(20,25,airline).size());
        Mockito.verify(airline).getAllPlanes();
    }

    private List<Plane> listForTesting(){
List<Plane> planeList = new ArrayList<>();
        planeList.add(  new Frontline.FrontlineBuilder().title("AD-123").description("military").power(1000)
                .carrying(20).range(1400).fuel(25).ammunition(5).protctionRadar(false).timeOfReloading(3).reactiveSpeed(false).build()
        );
        planeList.add(new Frontline.FrontlineBuilder().title("AD-144").description("military").power(1200)
                .carrying(40).range(1400).fuel(22).ammunition(5).protctionRadar(false).timeOfReloading(5).reactiveSpeed(true).build());
        planeList.add(new Frontline.FrontlineBuilder().title("AN-443").description("military").power(1600)
                .carrying(33).range(1600).fuel(21).ammunition(3).protctionRadar(true).timeOfReloading(3).reactiveSpeed(true).build());
    return planeList;
    }

}