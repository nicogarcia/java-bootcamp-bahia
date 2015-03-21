package com.globant.app.domain.transactionScripts;

import com.globant.app.domain.entities.Order;
import com.globant.app.domain.entities.carts.Cart;
import com.globant.app.domain.entities.carts.OrderCart;
import com.globant.app.domain.entities.items.CartOffer;
import com.globant.app.domain.entities.items.CartProduct;
import com.globant.app.domain.entities.items.Offer;
import com.globant.app.domain.entities.items.Product;
import com.globant.app.domain.exceptions.EmptyCartException;
import com.globant.app.persistence.repositories.ICartOffersRepo;
import com.globant.app.persistence.repositories.ICartProductsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderCartProcessingTS implements IOrderCartProcessingTS {

	@Autowired
	private ICartOffersRepo cartOffersRepo;

	@Autowired
	private ICartProductsRepo cartProductsRepo;

	@Override public void loadOrderCartFromCart(Order order) {
		Cart cart = order.getCart();

		if(cart.getProducts().size() + cart.getOffers().size() == 0)
			throw new EmptyCartException();

		OrderCart orderCart = new OrderCart();

		for (Offer offer : cart.getOffers()) {
			CartOffer cartOffer = new CartOffer(offer);

			cartOffersRepo.save(cartOffer);

			orderCart.getCartOffers().add(cartOffer);
		}

		for (Product product : cart.getProducts()) {
			CartProduct cartProduct = new CartProduct(product);

			cartProductsRepo.save(cartProduct);

			orderCart.getCartProducts().add(cartProduct);
		}

		order.setOrderCart(orderCart);
	}

	@Override public void processOrderCart(Order order){

		// Calculate total amount
		double amount = 0;

		for (CartOffer cartOffer : order.getOrderCart().getCartOffers()) {
			amount += cartOffer.getPrice();
		}

		for (CartProduct cartProduct : order.getOrderCart().getCartProducts()) {
			amount += cartProduct.getPrice();
		}

		// Set amount to the order
		order.getOrderCart().getAmount().setUndiscountedAmount(amount);
	}
}
