import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class AddressBook {
	private List <BuddyInfo> buddyInfo;
	
	public AddressBook() {
		this.buddyInfo = new ArrayList<BuddyInfo>();
	}
	
	public void addBuddy(BuddyInfo aBuddyInfo) {
		if (aBuddyInfo != null) {
			this.buddyInfo.add(aBuddyInfo);
		}
	}
	
	public BuddyInfo removeBuddy (int index) {
		if (index >=0 && index < this.buddyInfo.size()) {
			return this.buddyInfo.remove(index);
		}
		return null;
	}
	
	public boolean removeBuddy (String buddyName) {
		for (BuddyInfo b : this.buddyInfo) {
			if (b.getName()==buddyName) {
				buddyInfo.remove(b);
				return true;
			}
		}
		return false;
	}
	
	public String editBuddy(String buddyName) {
		for (BuddyInfo b : this.buddyInfo) {
			if (b.getName()==buddyName) {
				b.setHomeAddress(JOptionPane.showInputDialog("Home Address",b.getHomeAddress()));
				b.setPhoneNumber(JOptionPane.showInputDialog("Phone Number",b.getPhoneNumber()));
			}
		}
		return buddyName;
	}
	
	public int size() {
		return buddyInfo.size();
	}
	
	public void clear() {
		buddyInfo.clear();
	}
	
	public String toString(){
		String s="";
		for (BuddyInfo b : this.buddyInfo) {
			s += (b.toString() + "\n");
		}
		return s;
	}
	
	public boolean saveAddressBook() {
		String s = this.toString();
		BufferedWriter out;
		try {
			out = new BufferedWriter(new FileWriter("myFile.txt"));
			out.write(s);
			out.close();
			return true;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public static void main(String[] args) {
		
		new MenuFrame();
		
		}

}
