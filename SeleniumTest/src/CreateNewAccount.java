import java.util.Random;

public class CreateNewAccount {
	Random random = new Random();

	String firstName = "Narayan Das";
	String lastName = "Nitol";
	String email = "mytestemail" + random.nextInt(10000) + "@gmail.com";
	String password = "mytestmail" + random.nextInt(10000) + random.nextInt(100) + "automation";
	String address = "200 street, London, UK";
	String city = "London";
	String state = "Alaska";
	String postalCode = "43027";
	String mobileNumber = "+8801753458871";
	String reference = "Dhaka, Bangladesh";
}
