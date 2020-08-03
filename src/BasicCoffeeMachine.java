import java.util.HashMap;
import java.util.Map;

import model.Coffee;
import model.CoffeeDrink;
import model.Configuration;
import model.GroundCoffee;
import utils.CoffeeException;
import utils.CoffeeSelection;

public class BasicCoffeeMachine implements CoffeeMachine {
	private Map<CoffeeSelection, Configuration> configMap;
	private Map<CoffeeSelection, GroundCoffee> groundCoffee;
	private BrewingUnit brewingUnit;

	public BasicCoffeeMachine(Map coffee) {
		this.groundCoffee = coffee;
		this.brewingUnit = new BrewingUnit();

		this.configMap = new HashMap<>();
		this.configMap.put(CoffeeSelection.FILTER_COFFEE, new Configuration(30, 400));
	}

	@Override
	public CoffeeDrink brewCoffee(CoffeeSelection selection) throws CoffeeException {
		switch (selection) {
		case FILTER_COFFEE:
			return brewFilterCoffee();
		default:
			throw new CoffeeException("CoffeeSelection [" + selection + "] not supported!");
		}
	}

	private CoffeeDrink brewFilterCoffee() {
		Configuration config = configMap.get(CoffeeSelection.FILTER_COFFEE);

		// Get the coffee:
		GroundCoffee groundCoffee = this.groundCoffee.get(CoffeeSelection.FILTER_COFFEE);

		// Brew a filter coffee:
		return this.brewingUnit.brew(CoffeeSelection.FILTER_COFFEE, groundCoffee, config.getQuantityWater());
	}

	public void addCoffee(CoffeeSelection sel, GroundCoffee newCoffee) throws CoffeeException {
		GroundCoffee existingCoffee = this.groundCoffee.get(sel);

		if (existingCoffee != null) {
			if (existingCoffee.getName().equals(newCoffee.getName())) {
				existingCoffee.setQuantity(existingCoffee.getQuantity() + newCoffee.getQuantity());
			} else
				throw new CoffeeException("Only one kind of coffee supported for each CoffeeSelection.");
		} else
			this.groundCoffee.put(sel, newCoffee);
	}
}
