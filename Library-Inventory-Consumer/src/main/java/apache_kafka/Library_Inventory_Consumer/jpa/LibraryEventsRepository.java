package apache_kafka.Library_Inventory_Consumer.jpa;

import apache_kafka.Library_Inventory_Consumer.entity.LibraryEvent;
import org.springframework.data.repository.CrudRepository;

public interface LibraryEventsRepository extends CrudRepository<LibraryEvent,Integer> {
}