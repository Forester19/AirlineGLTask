package ua.com.airline.model.entity.civilian;

import ua.com.airline.model.entity.Plane;

/**
 * Created by Владислав on 23.01.2018.
 */
public abstract class Civilian extends Plane {
    protected int seatsCount;
    protected int staffCount;

    public Civilian() {
    }

    public int getSeatsCount() {
        return seatsCount;
    }

    public void setSeatsCount(int seatsCount) {
        this.seatsCount = seatsCount;
    }

    public int getStaffCount() {
        return staffCount;
    }

    public void setStaffCount(int staffCount) {
        this.staffCount = staffCount;
    }

    @Override
    public String toString() {
        return super.toString() + " "+seatsCount + " " +  staffCount;
    }
}
