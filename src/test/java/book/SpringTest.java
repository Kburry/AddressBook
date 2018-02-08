package book;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest()
public class SpringTest {

    @Autowired
    AddressBookController controller;
    @Autowired
    AddressBookRepository addressRepo;
    @Autowired
    BuddyInfoRepository buddyRepo;


    @Test
    public void controllerLoads() throws Exception{
        assertThat(addressRepo).isNotNull();
    }


    @Test
    public void addressRepoLoads() throws Exception{
        assertThat(addressRepo).isNotNull();
    }

    @Test
    public void buddyRepoLoads() throws Exception{
        assertThat(buddyRepo).isNotNull();
    }
}
