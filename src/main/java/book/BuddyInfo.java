package book;

import javax.persistence.*;

@Entity
public class BuddyInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String name;

    private String address;

    private String phoneNumber;

    @ManyToOne
    private AddressBook book;

    public BuddyInfo(String name, String address, String phoneNumber ){
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public BuddyInfo(){
        this("foo bar", "123 fake St", "555 555-5555");
    }

    public Integer getId() {return id;}

    public void setId(Integer id) {this.id = id;}

    public void setBook(AddressBook book) {this.book = book;}

    public AddressBook getBook() {return book;}

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString(){
        return this.getName() + ": " + this.getAddress() + " " + this.getPhoneNumber();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BuddyInfo buddyInfo = (BuddyInfo) o;

        if (name != null ? !name.equals(buddyInfo.name) : buddyInfo.name != null) return false;
        if (address != null ? !address.equals(buddyInfo.address) : buddyInfo.address != null) return false;
        return phoneNumber != null ? phoneNumber.equals(buddyInfo.phoneNumber) : buddyInfo.phoneNumber == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (phoneNumber != null ? phoneNumber.hashCode() : 0);
        return result;
    }
}
