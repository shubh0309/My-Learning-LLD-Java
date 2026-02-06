package PracticeBasic;

import PracticeBasic.Strategy.SportDrive;

public class SportsBike extends Vechile{

    SportsBike(){
        super(new SportDrive());
    }
}
