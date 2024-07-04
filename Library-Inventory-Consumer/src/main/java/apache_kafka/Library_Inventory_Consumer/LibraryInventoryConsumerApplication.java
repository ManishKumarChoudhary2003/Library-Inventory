package apache_kafka.Library_Inventory_Consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class LibraryInventoryConsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(LibraryInventoryConsumerApplication.class, args);
	}

}
