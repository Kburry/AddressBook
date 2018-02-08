package book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class AddressBookController {

    @Autowired
    AddressBookRepository addressRepository;
    @Autowired
    BuddyInfoRepository buddyRepository;

    @RequestMapping("/getAddressBook")
    public AddressBook getAddressBook(){
        return addressRepository.findAll().iterator().next();
    }

    @RequestMapping("/getBuddies")
    public Iterable<BuddyInfo> getBuddies(){
        return buddyRepository.findAll();
    }

    @GetMapping("/addBuddy")
    public int addBuddy(@Param("name") String name,
                        @Param("address") String address,
                        @Param("phoneNumber") String phoneNumber){
        BuddyInfo buddy = new BuddyInfo(name, address, phoneNumber);
        buddyRepository.save(buddy);
        return buddy.getId();
    }

    @GetMapping("/removeBuddy")
    public BuddyInfo removeBuddy(@Param("id") int id){
        BuddyInfo removedBuddy = buddyRepository.findOne(id);
        buddyRepository.delete(id);
        return removedBuddy;
    }

    @GetMapping("/addBuddyToBookById")
    public AddressBook addBuddyToBookById(@Param("id") int id){
        AddressBook book = addressRepository.findOne(1);
        book.addBuddy(buddyRepository.findOne(id));
        addressRepository.save(book);
        return book;
    }

    @GetMapping("/removeBuddyFromBookByBuddyId")
    public BuddyInfo addBuddy(@Param("id") int id){
        BuddyInfo buddy = buddyRepository.findOne(id);
        AddressBook book = addressRepository.findOne(1);
        book.remove(buddy);
        addressRepository.save(book);
        return buddy;
    }

}
