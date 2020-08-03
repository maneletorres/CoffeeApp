import java.util.HashMap;
import java.util.Map;

import model.Coffee;
import model.CoffeeBean;
import model.CoffeeDrink;
import utils.CoffeeException;
import utils.CoffeeSelection;

public class CoffeeApp {

	private CoffeeMachine coffeeMachine;

	public CoffeeApp(CoffeeMachine coffeeMachine) {
		this.coffeeMachine = coffeeMachine;
	}

	public CoffeeDrink prepareCoffee(CoffeeSelection selection) throws CoffeeException {
		CoffeeDrink coffee = this.coffeeMachine.brewCoffee(selection);
		System.out.println("Coffee is ready!");
		return coffee;
	}

	public static void main(String[] args) {
		// Create a Map of available coffee beans:
		Map<CoffeeSelection, CoffeeBean> beans = new HashMap<>();
		beans.put(CoffeeSelection.ESPRESSO, new CoffeeBean("My favorite espresso bean", 1000));
		beans.put(CoffeeSelection.FILTER_COFFEE, new CoffeeBean("My favorite filter coffee bean", 1000));

		// Get a new CoffeeMachine object:
		PremiumCoffeeMachine machine = new PremiumCoffeeMachine(beans);

		// Instantiate CoffeeApp:
		CoffeeApp app = new CoffeeApp(machine);

		// Brew a fresh coffee:
		try {
			app.prepareCoffee(CoffeeSelection.ESPRESSO);
		} catch (CoffeeException e) {
			e.printStackTrace();
		}
	}

}
