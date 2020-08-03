import model.CoffeeDrink;
import utils.CoffeeException;

public class CoffeeApp {
	private CoffeeMachine coffeeMachine;

	public CoffeeApp(CoffeeMachine coffeeMachine) {
		this.coffeeMachine = coffeeMachine;
	}

	public CoffeeDrink prepareCoffee() throws CoffeeException {
		CoffeeDrink coffee = this.coffeeMachine.brewFilterCoffee();
		System.out.println("Coffee is ready!");
		return coffee;
	}
}