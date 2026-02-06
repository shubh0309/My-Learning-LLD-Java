package DecoratorPatternPizzaTopping;

public class DecoratorPizzaTopping {
    public static void main(String[] args) {
        BasePizza pizza = new pannerPizza(new ExtraCheese(new pannerPizza(new farmHousePizza())));
        System.out.println(pizza.cost());

    }
}
