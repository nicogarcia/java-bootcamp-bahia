package Topic_1.ShoppingCart.Domain.Utilities;

/**
 * Manages the IDs of the business items
 */
public class IdManager {

	static int id = 0;

	public static int nextId() {
		return id++;
	}
}
