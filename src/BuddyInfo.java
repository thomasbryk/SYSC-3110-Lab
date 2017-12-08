import java.util.Scanner;

public class BuddyInfo {
	private String name;
	private String homeAddress;
	private String phoneNumber;
	private int age;
	
	public BuddyInfo (String name) {
		super();
		this.name = name;
	}
	
	public BuddyInfo (String name, String homeAddress, String phoneNumber) {
		super();
		this.name = name;
		this.homeAddress = homeAddress;
		this.phoneNumber = phoneNumber;
	}
	
	public BuddyInfo (BuddyInfo buddy) {
		super();
		setName(buddy.getName());
		setHomeAddress(buddy.getHomeAddress());
		setPhoneNumber(buddy.getPhoneNumber());
	}
	

	
	public String getName() {
		return name;
	}
	
	public void setName (String name) {
		this.name=name;
	}
	
	public String getHomeAddress() {
		return this.homeAddress;
	}
	
	public void setHomeAddress(String homeAddress) {
		this.homeAddress=homeAddress;
	}
	
	public String getPhoneNumber() {
		return this.phoneNumber;
	}
	
	public void setPhoneNumber (String phoneNumber) {
		this.phoneNumber=phoneNumber;
	}
	
	public int getAge() {
		return this.age;
	}
	
	public void setAge(int age) {
		this.age=age;
	}
	
	public boolean isOver18() {
		return (this.age > 18);
	}
	
	public String toString() {
		return (this.getName() + "$" + this.getHomeAddress() + "$" + this.getPhoneNumber());
	}
	
	public static BuddyInfo newBuddy(String buddyString) {
		Scanner sc = new Scanner(buddyString).useDelimiter("$");
		BuddyInfo buddy = new BuddyInfo(sc.next(), sc.next(), sc.next());
		sc.close();
		return buddy;
	}
}
