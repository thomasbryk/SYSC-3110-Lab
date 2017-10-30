
public class BuddyInfo {
	private String name;
	private String homeAddress;
	private String phoneNumber;
	
	public BuddyInfo (String name, String homeAddress, String phoneNumber) {
		super();
		this.name=name;
		this.homeAddress=homeAddress;
		this.phoneNumber=phoneNumber;
	}
	
	public static void main (String[] args) {
		
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
	
	public String toString() {
		return (this.getName() + "  " + this.getHomeAddress() + "  " + this.getPhoneNumber());
	}
}
