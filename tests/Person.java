import static org.junit.Assert.*;

import java.text.ParseException;

import org.junit.Before;
import org.junit.Test;
import org.easymock.EasyMock;

public class Person {

	MufasaAccountCreation xliu;
	MufasaAddress userAddress;
	MufasaBankACC userBank;
	MufasaTransaction transaction;
	Transaction info;
	
	@Before
	public void setup(){
		info = new Transaction();
		
		xliu = EasyMock.createMock(MufasaAccountCreation.class);
		info.setAccount(xliu);
		
		userAddress = EasyMock.createMock(MufasaAddress.class);
		info.setAddress(userAddress);
		
		userBank = EasyMock.createMock(MufasaBankACC.class);
		info.setBank(userBank);
		
		transaction = EasyMock.createMock(MufasaTransaction.class);
		info.setTransaction(transaction);
	}

	@Test
	public void test() throws UserException, ParseException, AddressException, BankAccountException {
		//User
		User newUser = new User();
		
		newUser.setFirstName("Wenting");
		newUser.setLastName("Tao");
//		newUser.setPassword("12345678", "12345678");
//		newUser.setUsername("Twt1999");
		newUser.setPhoneNumber("0441111111");
		newUser.setBirthdate("01/01/1980");
		newUser.setCountry("China");
//		newUser.setEmail("Twt22@gmail.com", "Twt22@gmail.com");
		
		EasyMock.expect(xliu.getAccInfo()).andReturn(newUser);
		EasyMock.replay(xliu);
		
		//Address
		Address newAddress = new Address();
		
		try {
			newAddress.setStreetAddress("Palhokuja2");
			newAddress.setCity("Oulu");
			newAddress.setPostalCode("90540");
			newAddress.setCountry("finland");
		}
		catch(Address.AddressException e)
		{
			e.printStackTrace();
		}
		
		
		EasyMock.expect(userAddress.getAddressInfo()).andReturn(newAddress);
		EasyMock.replay(userAddress);
		
		//Bank Account
		BankAccount newBank = new BankAccount();
		
		newBank.setUserAddress(newAddress);
//		newBank.setBankAccountPassword("twt!@#", "twt!@#");
		newBank.setCardHolderName("WentingTao");						    	
		newBank.setCardNumber("1111111111111111");
		newBank.setExpiryDate("09/21");
		
		EasyMock.expect(userBank.getBankInfo(newUser)).andReturn(newBank);
		EasyMock.replay(userBank);
		
		EasyMock.expect(transaction.getTransactionResult()).andReturn(334);
		
		String result = info.getTransactionResult();
		
		
		assertEquals("Transaction Failed", result);
	}

}
