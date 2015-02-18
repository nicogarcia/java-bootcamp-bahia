package Topic_1.ShoppingCart.Domain.Utilities;

/**
 * Manages the ID of the transactions
 */
public class TransactionManager {

	private static long transactionCounter = 0;

	public static long getNextId() {
		return transactionCounter++;
	}

}
