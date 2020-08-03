import java.util.HashMap;
import java.util.Map;

import model.Coffee;
import model.CoffeeDrink;
import model.GroundCoffee;
import utils.CoffeeException;
import utils.CoffeeSelection;

public class BasicCoffeeApp {

	private BasicCoffeeMachine coffeeMachine;

	public BasicCoffeeApp(BasicCoffeeMachine coffeeMachine) {
		this.coffeeMachine = coffeeMachine;
	}

	public CoffeeDrink prepareCoffee(CoffeeSelection selection) throws CoffeeException {
		CoffeeDrink coffee = this.coffeeMachine.brewCoffee(selection);
		System.out.println("Coffee is ready!");
		return coffee;
	}

	public static void main(String[] args) {
		// Create a Map of available coffee beans:
		Map<CoffeeSelection, GroundCoffee> beans = new HashMap<CoffeeSelection, GroundCoffee>();
		beans.put(CoffeeSelection.FILTER_COFFEE, new GroundCoffee("My favorite filter coffee bean", 1000));

		// Get a new CoffeeMachine object:
		BasicCoffeeMachine machine = new BasicCoffeeMachine(beans);

		// Instantiate CoffeeApp:
		BasicCoffeeApp app = new BasicCoffeeApp(machine);

		// Brew a fresh coffee:
		try {
			app.prepareCoffee(CoffeeSelection.FILTER_COFFEE);
		} catch (CoffeeException e) {
			e.printStackTrace();
		}
	}

}
