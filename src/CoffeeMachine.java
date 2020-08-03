import exception.CoffeeException;
import model.Coffee;
import model.CoffeeDrink;
import utils.CoffeeSelection;

public interface CoffeeMachine {
	CoffeeDrink brewCoffee(CoffeeSelection selection) throws CoffeeException;
}
