package FactoryPattern_Shape;

public class ShapeFactory {
    Shape getShape(String input){
        switch(input){
            case "CIRCLE":
                return new Circle();
            case "RECTANGLE":
                return new rectangle();
            default:
                return null;
        }
    }

}
