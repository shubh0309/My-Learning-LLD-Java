package PracticeBasic;

import PracticeBasic.Strategy.NormalDrive;

public class OffRoadBike extends Vechile{
    OffRoadBike(){
        super(new NormalDrive());
    }
}
