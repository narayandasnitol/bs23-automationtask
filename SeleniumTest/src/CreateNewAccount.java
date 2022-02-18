import java.util.Random;

public class CreateNewAccount {
	Random random = new Random();

	String firstName = "Narayan Das";
	String lastName = "Nitol";
	String email = "testmailbs23" + random.nextInt(10000) + random.nextInt(100) + "@yahoo.com";
	String password = "testmailbs23" + random.nextInt(10000) + random.nextInt(100) + "@yahoo.com";
	String address = "200 street, London, UK";
	String city = "London";
	String state = "Alaska";
	String postalCode = "43027";
	String mobileNumber = "+8801753458871";
	String reference = "Dhaka, Bangladesh";
}
