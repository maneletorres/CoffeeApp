import model.Coffee;
import model.CoffeeDrink;
import utils.CoffeeException;
import utils.CoffeeSelection;

public interface CoffeeMachine {
	CoffeeDrink brewCoffee(CoffeeSelection selection) throws CoffeeException;
}
