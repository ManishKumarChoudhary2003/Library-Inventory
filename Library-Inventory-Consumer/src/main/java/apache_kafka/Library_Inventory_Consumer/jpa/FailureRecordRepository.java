package apache_kafka.Library_Inventory_Consumer.jpa;

import apache_kafka.Library_Inventory_Consumer.entity.FailureRecord;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface FailureRecordRepository extends CrudRepository<FailureRecord,Integer> {

    List<FailureRecord> findAllByStatus(String status);
}