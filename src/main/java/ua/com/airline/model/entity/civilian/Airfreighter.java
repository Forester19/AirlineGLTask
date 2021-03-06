package ua.com.airline.model.entity.civilian;

/**
 * Entity class using builder.
 */
public class Airfreighter extends Civilian {
    private boolean reinforcedChassis;

    public Airfreighter(AirfreighterBuilder airfreighterBuilder) {
        this.title = airfreighterBuilder.getTitle();
        this.description = airfreighterBuilder.getDescription();
        this.power = airfreighterBuilder.getPower();
        this.carrying = airfreighterBuilder.getCarrying();
        this.range = airfreighterBuilder.getRange();
        this.fuel = airfreighterBuilder.getFuel();
        this.seatsCount = airfreighterBuilder.getSeatsCount();
        this.staffCount = airfreighterBuilder.getStaffCount();
        this.reinforcedChassis = airfreighterBuilder.isReinforcedChassis();
    }

    public static class AirfreighterBuilder {
        private String title;
        private String description;
        private int power;
        private int carrying;
        private int range;
        private int fuel;
        private int seatsCount;
        private int staffCount;
        private boolean reinforcedChassis;

        public AirfreighterBuilder title(String title) {
            this.title = title;
            return this;
        }

        public AirfreighterBuilder description(String description) {
            this.description = description;
            return this;
        }

        public AirfreighterBuilder power(int power) {
            this.power = power;
            return this;
        }
        public AirfreighterBuilder fuel(int fuel) {
            this.fuel = fuel;
            return this;
        }
        public AirfreighterBuilder carrying(int carrying) {
            this.carrying = carrying;
            return this;
        }

        public AirfreighterBuilder range(int range) {
            this.range = range;
            return this;
        }

        public AirfreighterBuilder seatsCount(int seatsCount) {
            this.seatsCount = seatsCount;
            return this;
        }

        public AirfreighterBuilder staffCount(int staffCount) {
            this.staffCount = staffCount;
            return this;
        }

        public AirfreighterBuilder reinforcedChassis(boolean reinforcedChassis) {
            this.reinforcedChassis = reinforcedChassis;
            return this;
        }

        public Airfreighter build() {
            return new Airfreighter(this);
        }

        public String getTitle() {
            return title;
        }

        public String getDescription() {
            return description;
        }

        public int getPower() {
            return power;
        }

        public int getCarrying() {
            return carrying;
        }

        public int getRange() {
            return range;
        }

        public int getFuel() {
            return fuel;
        }

        public int getSeatsCount() {
            return seatsCount;
        }

        public int getStaffCount() {
            return staffCount;
        }

        public boolean isReinforcedChassis() {
            return reinforcedChassis;
        }
    }

    public boolean isReinforcedChassis() {
        return reinforcedChassis;
    }

    @Override
    public String toString() {
        return super.toString() + " " + reinforcedChassis;
    }
}
