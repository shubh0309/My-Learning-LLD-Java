package FactoryPattern_Shape;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello, Factory Pattern!");
        ShapeFactory shapeFactory = new ShapeFactory();
        Shape shapeObj = shapeFactory.getShape("CIRCLE");
        shapeObj.draw();
    }
}