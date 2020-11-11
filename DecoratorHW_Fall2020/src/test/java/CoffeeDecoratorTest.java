import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.DisplayName;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CoffeeDecoratorTest {

	@Test
	void not_null_test(){
		Coffee order = new BasicCoffee();
		assertNotNull(order);
	}
	@Test
	void basic_coffee() {
		Coffee order = new BasicCoffee();
		assertEquals(3.99, order.makeCoffee());
	}

	@Test
	void single_addition(){
		Coffee order = new Chocolate(new BasicCoffee());
		assertEquals(4.99, order.makeCoffee());

	}

	@Test
	void multiple_addition(){
		Coffee order =new Chocolate(new Mint(new BasicCoffee()));
		assertEquals(5.49, order.makeCoffee());
	}

	@Test
	void multiple_same_addition(){
		Coffee order = new Chocolate(new Chocolate(new BasicCoffee()));
		assertEquals(5.99, order.makeCoffee());
	}

	@Test
	void one_of_each(){
		Coffee order = new Cream(new ExtraShot(new Sugar(new Chocolate(new Mint(new BasicCoffee())))));
		assertEquals(7.69, order.makeCoffee());
	}

	@Test
	void no_basic_coffee(){
		Coffee order = new Mint(null);
		assertNotNull(order);
	}

	@Test
	void basic_coffee_two(){
		Coffee order = new BasicCoffee();
		order = new Chocolate(order);
		assertEquals(4.99, order.makeCoffee());
	}

	@Test
	void couple_different_items(){
		Coffee order = new Mint(new Mint(new Chocolate(new Chocolate(new BasicCoffee()))));
		assertEquals(6.99, order.makeCoffee());
	}

	@Test
	void enormous_coffee(){
		Coffee order = new Chocolate(new Chocolate(new Chocolate(new Chocolate(new Sugar(new Sugar(new Sugar(new ExtraShot(new ExtraShot(new BasicCoffee())))))))));
		assertEquals(11.89, order.makeCoffee());
	}

}
