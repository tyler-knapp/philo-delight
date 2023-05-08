package dev.tknapp.philodelight;

import dev.tknapp.philodelight.cart.ShoppingCart;
import dev.tknapp.philodelight.item.model.Item;
import dev.tknapp.philodelight.util.DataFileReader;
import dev.tknapp.philodelight.util.Validator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Arrays;

@SpringBootApplication
@Slf4j
public class PhiloDelightApplication {
	
	private static final Menu menu = new Menu();
	private static final DataFileReader dataFileReader = new DataFileReader();
	
	private static void run() {
		
		
		ShoppingCart cart = new ShoppingCart();
		cart.addToCart(new Item(2L, "mary", BigDecimal.valueOf(999.88)));
		cart.showCart();
		log.info(Validator.of(cart)
				.validate(ShoppingCart::getCoupon, coupon -> !coupon.isEmpty(), "coupon is empty")
				.validate(ShoppingCart::getItems, item -> !item.isEmpty(), "item is empty").get().toString());
		
		try{
			dataFileReader.readFromFile();
			menu.sayHello();
		} catch(IOException err) {
			System.out.println(Arrays.toString(err.getStackTrace()));
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		SpringApplication.run(PhiloDelightApplication.class, args);
		run();
	}

}
