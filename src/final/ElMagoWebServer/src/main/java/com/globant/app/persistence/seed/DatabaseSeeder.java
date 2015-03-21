package com.globant.app.persistence.seed;

import com.globant.app.domain.entities.Category;
import com.globant.app.domain.entities.Customer;
import com.globant.app.domain.entities.items.Offer;
import com.globant.app.domain.entities.items.Product;
import com.globant.app.persistence.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

@Component
public class DatabaseSeeder implements ApplicationListener<ContextRefreshedEvent>{

	@Autowired
	private IProductsRepo productsRepo;

	@Autowired
	private IOffersRepo offersRepo;

	@Autowired
	private ICustomerRepo customerRepo;

	@Autowired
	private IOrderRepo orderRepo;

	@Autowired
	private ICategoryRepo categoryRepo;

	@Override
	@Transactional
	public void onApplicationEvent(ContextRefreshedEvent event) {
		if (event.getApplicationContext().getParent() == null) {
			if((productsRepo.count() > 0) && (offersRepo.count() > 0))
				return;

			System.out.println(">>>>>>>>  Parent started");
			System.out.println("before: " + productsRepo.count());

			Customer customer = new Customer();
			customer.setUsername("user");
			customer.setPassword("user");
			customer.setLocked(false);
			customer.setEnabled(true);
			customer.setExpired(false);
			customer.setCredentialsExpired(false);

			customerRepo.save(customer);

			List<Category> categoryList = new ArrayList<Category>();

			Category pizza = new Category("Pizzas", "pizza.jpg");
			Category tarta = new Category("Tartas", "tartas.jpg");
			Category empanada = new Category("Empanadas", "empanadas.jpg");
			Category hamburpizza = new Category("Hamburpizzas", "hamburpizzas.jpg");

			categoryList.add(pizza);
			categoryList.add(tarta);
			categoryList.add(empanada);
			categoryList.add(hamburpizza);

			List<Product> productList = new ArrayList<Product>();

			productList.add(new Product("Jamón con palmitos", empanada, 12));
			productList.add(new Product("Jamón y ananá", empanada, 12));
			productList.add(new Product("Panceta, queso y ciruela", empanada, 12));
			productList.add(new Product("Queso y cebolla", empanada, 12));
			productList.add(new Product("Roquefort con nuez", empanada, 12));
			productList.add(new Product("Roquefort y cebolla", empanada, 12));
			productList.add(new Product("Roquefort con palmitos", empanada, 12));
			productList.add(new Product("Calabresa y muzzarella", empanada, 12));
			productList.add(new Product("Choclo", empanada, 12));
			productList.add(new Product("Verdura", empanada, 12));
			productList.add(new Product("Carne criolla", empanada, 12));
			productList.add(new Product("Carne criolla sin aceitunas", empanada, 12));
			productList.add(new Product("Carne con pasas de uva", empanada, 12));
			productList.add(new Product("Carne cortada a cuchillo", empanada, 12));
			productList.add(new Product("Carne cortada a cuchillo con pasas de uva", empanada, 12));
			productList.add(new Product("Carne picante", empanada, 12));
			productList.add(new Product("Carne a la cerveza", empanada, 12));
			productList.add(new Product("Jamón y Queso hojaldrada", empanada, 12));
			productList.add(new Product("Jamón y Queso sin hojaldre", empanada, 12));
			productList.add(new Product("Dos quesos", empanada, 12));
			productList.add(new Product("Queso, tomate y albahaca", empanada, 12));
			productList.add(new Product("Atún", empanada, 12));
			productList.add(new Product("Pollo", empanada, 12));
			productList.add(new Product("Pollo con ciruela", empanada, 12));
			productList.add(new Product("Jamón crudo, queso y rúcula", empanada, 12));
			productList.add(new Product("Soja texturizada", empanada, 12));

			productList.add(new Product("Especial", pizza, 90));
			productList.add(new Product("De la casa", pizza, 90));
			productList.add(new Product("Muzzarella", pizza, 90));
			productList.add(new Product("Muzzarella con aceitunas", pizza, 90));
			productList.add(new Product("Muzzarella con anchoas", pizza, 90));
			productList.add(new Product("Muzzarella con morrones", pizza, 90));
			productList.add(new Product("Muzzarella con huevo duro", pizza, 90));
			productList.add(new Product("Muzzarella con palmitos", pizza, 90));
			productList.add(new Product("Jamón crudo", pizza, 90));
			productList.add(new Product("Pollo", pizza, 90));
			productList.add(new Product("Tomate y anchoas", pizza, 90));
			productList.add(new Product("Napolitana", pizza, 90));
			productList.add(new Product("Napolitana con jamón y huevo", pizza, 90));
			productList.add(new Product("Roquefort", pizza, 90));
			productList.add(new Product("Roquefort con palmitos", pizza, 90));
			productList.add(new Product("Jamón", pizza, 90));
			productList.add(new Product("Jamón con morrones", pizza, 90));
			productList.add(new Product("Jamón con palmitos", pizza, 90));
			productList.add(new Product("Jamón y ananá", pizza, 90));
			productList.add(new Product("Provolone", pizza, 90));
			productList.add(new Product("Provolone con tomates", pizza, 90));
			productList.add(new Product("Fugazza", pizza, 90));
			productList.add(new Product("Fugazzeta", pizza, 90));
			productList.add(new Product("Fugazzeta con roquefort", pizza, 90));
			productList.add(new Product("Fugazzeta con jamón", pizza, 90));
			productList.add(new Product("Tomateada", pizza, 90));
			productList.add(new Product("Tomateada con jamón", pizza, 90));
			productList.add(new Product("Atún", pizza, 90));
			productList.add(new Product("Calabreza", pizza, 90));
			productList.add(new Product("Calabreza con jamón", pizza, 90));
			productList.add(new Product("Panceta", pizza, 90));
			productList.add(new Product("Cuatro quesos", pizza, 90));
			productList.add(new Product("Choclo", pizza, 90));

			productList.add(new Product("Jamón y queso", tarta, 110));
			productList.add(new Product("Choclo", tarta, 110));
			productList.add(new Product("Verdura", tarta, 110));
			productList.add(new Product("Atún", tarta, 110));
			productList.add(new Product("Queso y cebolla", tarta, 110));

			productList.add(new Product("Muzzarella", hamburpizza, 60));
			productList.add(new Product("Napolitana", hamburpizza, 60));
			productList.add(new Product("Muzzarella y roquefort", hamburpizza, 60));
			productList.add(new Product("Jamón y muzzarella", hamburpizza, 60));
			productList.add(new Product("Panceta y huevo frito", hamburpizza, 60));

			Collection<Offer> offers = Arrays.asList(
					new Offer("Pizza + Coca 2.25L",  100, pizza),
					new Offer("2 Hamburpizza + Coca 1.5L", 120, hamburpizza)
			);

			for (Category category : categoryList) {
				categoryRepo.save(category);
			}

			for (Product product : productList) {
				productsRepo.save(product);
			}

			for (Offer offer : offers) {
				offersRepo.save(offer);
			}

			System.out.println("after: " + productsRepo.count());
		} else {
			System.out.println(">>>>>>>>  Child started; ignoring");
		}
	}
}
