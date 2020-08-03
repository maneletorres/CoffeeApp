import java.util.HashMap;
import java.util.Map;
import exception.CoffeeException;
import model.Coffee;
import model.CoffeeDrink;
import model.Configuration;
import model.GroundCoffee;
import utils.CoffeeSelection;

public class BasicCoffeeMachine implements CoffeeMachine {
	private Map<CoffeeSelection, Configuration> configMap;
	private Map<CoffeeSelection, GroundCoffee> groundCoffee;
	private BrewingUnit brewingUnit;

	public BasicCoffeeMachine(Map<CoffeeSelection, GroundCoffee> coffee) {
		this.groundCoffee = coffee;
		this.brewingUnit = new BrewingUnit();

		this.configMap = new HashMap<>();
		this.configMap.put(CoffeeSelection.FILTER_COFFEE, new Configuration(30, 400));
	}

	@Override
	public CoffeeDrink brewCoffee(CoffeeSelection selection) {
		Configuration config = configMap.get(CoffeeSelection.FILTER_COFFEE);

		// Get the coffee:
		GroundCoffee groundCoffee = this.groundCoffee.get(CoffeeSelection.FILTER_COFFEE);

		// Brew a filter coffee:
		return this.brewingUnit.brew(CoffeeSelection.FILTER_COFFEE, groundCoffee, config.getQuantityWater());
	}

	public void addGroundCoffee(CoffeeSelection sel, GroundCoffee newCoffee) throws CoffeeException {
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
