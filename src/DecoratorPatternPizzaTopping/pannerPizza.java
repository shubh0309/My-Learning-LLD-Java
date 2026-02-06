package DecoratorPatternPizzaTopping;

public class pannerPizza extends ToppingDecorator{
    BasePizza pizza;
    public pannerPizza(BasePizza pizza){
        this.pizza = pizza;
    }

    @Override
    public int cost() {
        return pizza.cost()+ 30;
    }
}
