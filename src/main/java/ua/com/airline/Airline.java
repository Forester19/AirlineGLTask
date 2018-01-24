package ua.com.airline;

import ua.com.airline.model.entity.Plane;
import ua.com.airline.model.entity.civilian.Airfreighter;
import ua.com.airline.model.entity.military.Frontline;

import java.util.ArrayList;
import java.util.List;

/**
 * Our airline company
 */
public class Airline extends Company {
    private static Airline airline;

    public static Airline getInstance(){
        if (airline == null){
            airline = new Airline();
            return airline;
        }else {
            return airline;
        }
    }

    private Airline() {
    planeList = new ArrayList<>();
    planeList.add(  new Frontline.FrontlineBuilder().title("AD-123").description("military").power(1000)
            .carrying(20).range(1400).fuel(25).ammunition(5).protctionRadar(false).timeOfReloading(3).reactiveSpeed(false).build()
      );
    planeList.add(new Frontline.FrontlineBuilder().title("AD-144").description("military").power(1200)
                .carrying(40).range(1400).fuel(22).ammunition(5).protctionRadar(false).timeOfReloading(5).reactiveSpeed(true).build());
    planeList.add(new Frontline.FrontlineBuilder().title("AN-443").description("military").power(1600)
                .carrying(33).range(1600).fuel(21).ammunition(3).protctionRadar(true).timeOfReloading(3).reactiveSpeed(true).build());
    planeList.add(
    new Airfreighter.AirfreighterBuilder().title("AN-NAN").description("civilian").power(1600)
                .carrying(33).range(1600).fuel(26).seatsCount(134).staffCount(14).reinforcedChassis(true).build());
    planeList.add(
        new Airfreighter.AirfreighterBuilder().title("AN-44").description("civilian").power(800)
                .carrying(19).range(900).fuel(19).seatsCount(40).staffCount(6).reinforcedChassis(false).build());
    planeList.add(new Airfreighter.AirfreighterBuilder().title("CA-12").description("civilian").power(600)
                .carrying(12).range(700).fuel(15).seatsCount(20).staffCount(3).reinforcedChassis(true).build());

    }
    @Override
    public List<Plane> getAllPlanes(){
        return planeList;
    }
}
