import java.util.HashMap;
import java.util.Map;

import model.CoffeeBean;
import utils.CoffeeException;
import utils.CoffeeSelection;

public class CoffeeAppStarter {
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
			app.prepareCoffee();
		} catch (CoffeeException e) {
			e.printStackTrace();
		}
	}
}