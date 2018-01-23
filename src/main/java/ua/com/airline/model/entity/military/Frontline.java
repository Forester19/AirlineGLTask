package ua.com.airline.model.entity.military;

/**
 * lower level of inheritance classes ((Using pattern builder))
 */
public class Frontline extends Military {
    private int timeOfReloading;
    private boolean reactiveSpeed;

    public Frontline(FrontlineBuilder frontlineBuilder){
       this.title = frontlineBuilder.getTitle();
       this.description= frontlineBuilder.getDescription();
       this.power = frontlineBuilder.getPower();
       this.carrying = frontlineBuilder.getCarrying();
       this.range = frontlineBuilder.getRange();
       this.ammunition = frontlineBuilder.getAmmunition();
       this.protectionRadars = frontlineBuilder.isProtectionRadars();
       this.timeOfReloading = frontlineBuilder.getTimeOfReloading();
       this.reactiveSpeed = frontlineBuilder.isReactiveSpeed();
    }

    public class FrontlineBuilder{
        private String title;
        private String description;
        private int  power;
        private int  carrying;
        private int  range;
        private int ammunition;
        private boolean protectionRadars;
        private int timeOfReloading;
        private boolean reactiveSpeed;

        public FrontlineBuilder title(String title){
            this.title = title;
            return this;
        }
        public FrontlineBuilder description(String descr){
            this.description = descr;
            return this;
        }
        public FrontlineBuilder power(int power){
            this.power = power;
            return this;
        }
        public FrontlineBuilder carrying(int carrying){
            this.carrying = carrying;
            return this;
        }
        public FrontlineBuilder range(int range){
            this.range = range;
            return this;
        }
        public FrontlineBuilder ammunition(int ammunition){
            this.ammunition =ammunition;
            return this;
        }
        public FrontlineBuilder ammunition(boolean pr){
            this.protectionRadars =pr;
            return this;
        }
        public FrontlineBuilder timeOfReloading(int time){
            this.timeOfReloading =time;
            return this;
        }
        public FrontlineBuilder reactiveSpeed(boolean speed){
            this.reactiveSpeed  =speed;
            return this;
        }
        public Frontline build(){
            return  new Frontline(this);
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

        public int getAmmunition() {
            return ammunition;
        }

        public boolean isProtectionRadars() {
            return protectionRadars;
        }

        public int getTimeOfReloading() {
            return timeOfReloading;
        }

        public boolean isReactiveSpeed() {
            return reactiveSpeed;
        }
    }

    public int getTimeOfReloading() {
        return timeOfReloading;
    }

    public boolean isReactiveSpeed() {
        return reactiveSpeed;
    }

    @Override
    public String toString() {
        return super.toString() + " " + timeOfReloading +" "+ reactiveSpeed;
    }
}
