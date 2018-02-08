import book.AddressBook;
import book.BuddyInfo;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class AddressBookTest {

    private BuddyInfo buddy;
    private AddressBook book;

    @org.junit.Before
    public void setUp() throws Exception {
        String name = "test";
        String phone = "555 555-4567";
        String address = "foo bar";
        buddy = new BuddyInfo(name, address, phone);
        book = new AddressBook();
    }

    @org.junit.Test
    public void addBuddy() throws Exception {
        book.addBuddy(buddy);
        assertEquals(buddy, book.getBuddies().get(0));
    }

    @org.junit.Test
    public void getBuddies() throws Exception {
        List<BuddyInfo> list = new ArrayList<BuddyInfo>();
        assertEquals(list, book.getBuddies());
        book.addBuddy(buddy);
        assertNotEquals(list, book.getBuddies());
        list.add(buddy);
        assertEquals(list, book.getBuddies());
    }

    @org.junit.Test
    public void testToString() throws Exception {
        book.addBuddy(buddy);
        assertEquals( buddy.toString() +"\n", book.toString());
    }
}