package book;

import book.BuddyInfo;

import static org.junit.Assert.*;

public class BuddyInfoTest {

    private String name;
    private String phone;
    private String address;
    private BuddyInfo buddy;

    @org.junit.Before
    public void setUp() throws Exception {
        name = "test";
        phone = "555 555-4567";
        address = "foo bar";
        buddy = new BuddyInfo(name, address, phone);
    }

    @org.junit.Test
    public void getPhoneNumber() throws Exception {
        assertEquals(phone, buddy.getPhoneNumber());
        assertNotEquals(name, buddy.getPhoneNumber());
    }

    @org.junit.Test
    public void setPhoneNumber() throws Exception {
        buddy.setPhoneNumber(name);
        assertEquals(name, buddy.getPhoneNumber());
        assertNotEquals(phone, buddy.getPhoneNumber());
    }

    @org.junit.Test
    public void getAddress() throws Exception {
        assertEquals(address, buddy.getAddress());
        assertNotEquals(name, buddy.getAddress());
    }

    @org.junit.Test
    public void setAddress() throws Exception {
        buddy.setAddress(name);
        assertEquals(name, buddy.getAddress());
        assertNotEquals(address, buddy.getAddress());
    }

    @org.junit.Test
    public void getName() throws Exception {
        assertEquals(name, buddy.getName());
        assertNotEquals(address, buddy.getName());
    }

    @org.junit.Test
    public void setName() throws Exception {
        buddy.setName(address);
        assertEquals(address, buddy.getName());
        assertNotEquals(name, buddy.getAddress());
    }

    @org.junit.Test
    public void testToString() throws Exception {
        assertEquals( "test: foo bar 555 555-4567", buddy.toString() );
    }

    @org.junit.Test
    public void testEquals() throws Exception {
        assertEquals(buddy, new BuddyInfo(name, address, phone));
        assertNotEquals(buddy, new BuddyInfo());
    }
}