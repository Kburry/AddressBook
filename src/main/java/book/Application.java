package book;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

    private static final Logger log = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public CommandLineRunner demo2(AddressBookRepository repository){
        return (args) -> {
            AddressBook book = new AddressBook();
            book.addBuddy(new BuddyInfo("Jon", "Hamm", "1"));
            book.addBuddy(new BuddyInfo());
            book.addBuddy(new BuddyInfo("test", "test2", "3"));
            repository.save(book);

            log.info("AddressBook found with findAll():");
            log.info("-------------------------------");
            for (AddressBook book1 : repository.findAll()) {
                log.info(book1.toString());
                log.info("");
            }
            log.info("");
        };
    }

    @Bean
    public CommandLineRunner demo(BuddyInfoRepository repository) {
        return (args) -> {
            // save a couple of customers
            BuddyInfo buddy = new BuddyInfo();
            repository.save(new BuddyInfo("Jack", "Bauer","1"));
            repository.save(buddy);
            repository.save(new BuddyInfo("foo", "bar","4"));
            repository.save(new BuddyInfo("David", "Palmer", "2"));
            repository.save(new BuddyInfo("Michelle", "Dessler", "3"));

            // fetch all customers
            log.info("BuddyInfo found with findAll():");
            log.info("-------------------------------");
            for (BuddyInfo buddyInfo : repository.findAll()) {
                log.info(buddyInfo.toString());
            }
            log.info("");

            // fetch an individual customer by ID
            BuddyInfo buddyInfo = repository.findOne(1);
            log.info("BuddyInfo found with findOne(1):");
            log.info("--------------------------------");
            log.info(buddyInfo.toString());
            log.info("");

            // fetch customers by last name
            log.info("BuddyInfo found with findByAddress('Bauer'):");
            log.info("--------------------------------------------");
            for (BuddyInfo buddyInfo2 : repository.findByAddress("Bauer")) {
                log.info(buddyInfo2.toString());
            }
            log.info("");
        };
    }

}
