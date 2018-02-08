package book;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class AddressBook {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @OneToMany(targetEntity=BuddyInfo.class, mappedBy = "book", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<BuddyInfo> buddies;

    public AddressBook(){
        buddies = new ArrayList<BuddyInfo>();
    }

    public void addBuddy(BuddyInfo buddy) {
        this.buddies.add(buddy);
        buddy.setBook(this);
    }

    public void setBuddies(List<BuddyInfo> buddies) {
        this.buddies = buddies;
    }

    public List<BuddyInfo> getBuddies() {
        return buddies;
    }

    public Integer getId() {return id;}

    public void setId(Integer id) {this.id = id;}

    @Override
    public String toString() {
        String content= "";
        for(BuddyInfo buddy : buddies){
            content += buddy.toString()+ "\n";
        }
        return content;
    }

    public void setBuddyAt(int rowIndex, BuddyInfo value){
        buddies.set(rowIndex,value);
    }

    public BuddyInfo getBuddyAt(int rowIndex){
        return buddies.get(rowIndex);
    }

    public void remove(int i){
        buddies.remove(i);
    }

    public void remove(BuddyInfo buddy) { buddies.remove(buddy); }

    public int size(){
        return buddies.size();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AddressBook that = (AddressBook) o;

        return buddies != null ? buddies.equals(that.buddies) : that.buddies == null;
    }

    @Override
    public int hashCode() {
        return buddies != null ? buddies.hashCode() : 0;
    }

    public static void main(String args[]){
        AddressBook book = new AddressBook();
        BuddyInfo buddy1 = new BuddyInfo();
        BuddyInfo buddy2 = new BuddyInfo("test", "test street", "123 456-7890");
        book.addBuddy(buddy1);
        book.addBuddy(buddy2);
        System.out.println(book.toString());
    }
}
