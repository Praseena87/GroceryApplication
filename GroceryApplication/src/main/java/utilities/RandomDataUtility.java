package utilities;

import com.github.javafaker.Faker;

public class RandomDataUtility {
	
	Faker fk=new Faker();
	
	public String generateRandomUserName() {
		
		return fk.name().username();
	}
	
	public String generateRandomPassword() {
		return fk.internet().password();
	}
	
	public String generateFullName() {
		return fk.name().fullName();
	}
	
	public String generateRandomEmailID() {
		
		return fk.internet().emailAddress();
	}
	
	public String generateRandomPhoneNo() {
		
		return fk.phoneNumber().cellPhone();
		
	}

}
