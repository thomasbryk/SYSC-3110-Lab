import static org.junit.Assert.assertNotEquals;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import junit.framework.*;

public class AddressBookTest extends TestCase {

	private AddressBook book;

	@Before
	public void setUp() throws Exception {
		book = new AddressBook();
	}

	@After
	public void tearDown() throws Exception {
		book = null;
	}

	@Test
	public void testAddressBook() {
		AddressBook book2 = new AddressBook();
		assertEquals(0, book2.size());
	}

	@Test
	public void testAddBuddy() {
		book.addBuddy(new BuddyInfo("Joe"));
		assertEquals(1, book.size());
	}

	@Test
	public void testRemoveBuddyInt() {
		book.addBuddy(new BuddyInfo("Joe"));
		assertFalse(book.size()==0);
		book.removeBuddy(0);
		assertTrue(book.size()==0);
	}

	@Test
	public void testRemoveBuddyString() {
		book.addBuddy(new BuddyInfo("Joe"));
		assertFalse(book.size()==0);
		assertTrue(book.removeBuddy("Joe") && (book.size()==0));
	}

	@Test
	public void testEditBuddy() {
		BuddyInfo buddy = new BuddyInfo("Joe", "Toronto", "311");
		book.addBuddy(buddy);
		book.editBuddy("Joe");
		assertNotEquals("Toronto", buddy.getHomeAddress());
		assertNotEquals("311", buddy.getPhoneNumber());
	}

	@Test
	public void testSize() {
		book.addBuddy(new BuddyInfo("Joe"));
		assertEquals(1, book.size());
	}

	@Test
	public void testClear() {
		book.clear();
		assertEquals(0, book.size());
	}

	@Test
	public void testSaveAddressBook() {
		assertTrue(book.saveAddressBook());
	}
}
