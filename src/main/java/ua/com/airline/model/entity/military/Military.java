package ua.com.airline.model.entity.military;

import ua.com.airline.model.entity.Plane;

/**
 * Created by Владислав on 23.01.2018.
 */
public abstract class Military extends Plane {

    protected int ammunition;// count of warhead
    protected boolean protectionRadars;

    public Military() {
    }

    public int getAmmunition() {
        return ammunition;
    }

    public void setAmmunition(int ammunition) {
        this.ammunition = ammunition;
    }

    public boolean isProtectionRadars() {
        return protectionRadars;
    }

    public void setProtectionRadars(boolean protectionRadars) {
        this.protectionRadars = protectionRadars;
    }

    @Override
    public String toString() {
        return super.toString()+ ammunition+ " " +protectionRadars;
    }
}
