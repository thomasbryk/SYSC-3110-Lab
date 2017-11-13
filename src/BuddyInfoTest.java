import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import junit.framework.*;

public class BuddyInfoTest extends TestCase {

	private BuddyInfo buddy;

	@Before
	public void setUp() throws Exception {

		buddy = new BuddyInfo("Bob");
	}

	@After
	public void tearDown() throws Exception {
		buddy = null;
	}

	@Test
	public void testBuddyInfoStringStringString() {
		BuddyInfo buddy2 = new BuddyInfo("John", "Ottawa", "911");
		assertEquals("John  Ottawa  911", buddy2.toString());
	}

	@Test
	public void testBuddyInfoBuddyInfo() {
		BuddyInfo buddy2 = new BuddyInfo(buddy);
		assertEquals(buddy2.toString(), buddy.toString());
	}

	@Test
	public void testSetName() {
		buddy.setName("Sam");
		assertEquals("Sam", buddy.getName());
		buddy.setName("Bob");
	}

	@Test
	public void testSetHomeAddress() {
		buddy.setHomeAddress("Carleton");
		assertEquals("Carleton", buddy.getHomeAddress());
	}

	@Test
	public void testSetPhoneNumber() {
		buddy.setPhoneNumber("123-456-7890");
		assertEquals("123-456-7890", buddy.getPhoneNumber());
	}

	@Test
	public void testSetAge() {
		buddy.setAge(19);
		assertEquals(19, buddy.getAge());
	}

	@Test
	public void testIsOver18() {
		buddy.setAge(19);
		assertTrue(buddy.isOver18());
	}

	@Test
	public void testToString() {
		buddy = new BuddyInfo ("Bob", "Carleton", "123-456-7890");
		assertEquals("Bob  Carleton  123-456-7890", buddy.toString());
	}

}
