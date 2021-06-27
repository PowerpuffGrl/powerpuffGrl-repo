package banking;

import java.util.LinkedHashMap;
import java.util.Random;

/**
 * Private Variables:<br>
 * {@link #accounts}: List&lt;Long, Account&gt;
 */
public class Bank implements BankInterface {
	private LinkedHashMap<Long, Account> accounts;

	public Bank() {
		// complete the function
	}

	private Account getAccount(Long accountNumber) {
		// complete the function
		
		return accounts.get(accountNumber);
	}

	public Long openCommercialAccount(Company company, int pin, double startingDeposit) {
		// complete the function
		// complete the function
				Random random = new Random();
				long accountNumber = random.nextLong();
				Long accountNr = Long.valueOf(accountNumber);
				do {
					accountNumber = random.nextLong();
					accountNr = Long.valueOf(accountNumber);
				} while (accounts.containsKey(accountNr));

				return accountNr;
	}

	public Long openConsumerAccount(Person person, int pin, double startingDeposit) {
		// complete the function
		Random random = new Random();
		long accountNumber = random.nextLong();
		Long accountNr = Long.valueOf(accountNumber);
		do {
			accountNumber = random.nextLong();
			accountNr = Long.valueOf(accountNumber);
		} while (accounts.containsKey(accountNr));
		ConsumerAccount ca =new ConsumerAccount(person, accountNr, pin, startingDeposit);
		accounts.put(accountNr, ca);
		return accountNr;
	}

	public boolean authenticateUser(Long accountNumber, int pin) {
		// complete the function
		Account account=accounts.get(accountNumber);
		
		return account.validatePin(pin);
	}

	public double getBalance(Long accountNumber) {
		// complete the function
		Account account=accounts.get(accountNumber);
		return account.getBalance();
	}

	public void credit(Long accountNumber, double amount) {
		// complete the function
		Account account=accounts.get(accountNumber);
		account.creditAccount(amount);
	}

	public boolean debit(Long accountNumber, double amount) {
		Account account=accounts.get(accountNumber);
		return account.debitAccount(amount);
	}
}
