import model.CoffeeDrink;
import model.GroundCoffee;
import utils.CoffeeSelection;

public class BrewingUnit {
	public CoffeeDrink brew(CoffeeSelection selection, GroundCoffee groundCoffee, double quantity) {
		return new CoffeeDrink(selection, quantity);
	}
}
