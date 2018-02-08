package book;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@Configuration
@ComponentScan
public class AddressBookLauncher {
    public void launch() {
        String[] contextPaths = new String[] {"app-context.xml"};
        new ClassPathXmlApplicationContext(contextPaths);
    }

    public static void main(String[] args) {
        AddressBookLauncher launcher = new AddressBookLauncher();
        launcher.launch();
    }
}
