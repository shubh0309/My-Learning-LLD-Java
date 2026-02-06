package PracticeBasic;

import PracticeBasic.Strategy.DriveStrategy;

public class Vechile {
    public DriveStrategy driveStrategy;
    public Vechile(DriveStrategy driveStrategy){
        this.driveStrategy = driveStrategy;
    }
    public void drive(){
        driveStrategy.drive();
    }
}
