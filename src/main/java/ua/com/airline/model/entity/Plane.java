package ua.com.airline.model.entity;

/**
 * High level class inheritance of planes
 */
public abstract class Plane {
    protected String title;
    protected String description;
    protected int  power;
    protected int  carrying;
    protected int  range;

    public Plane() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public int getCarrying() {
        return carrying;
    }

    public void setCarrying(int carrying) {
        this.carrying = carrying;
    }

    public int getRange() {
        return range;
    }

    public void setRange(int range) {
        this.range = range;
    }

    @Override
    public String toString() {
        return title + '\'' + description + '\''+ power +'\''+ carrying +'\''+ range;
    }
}
