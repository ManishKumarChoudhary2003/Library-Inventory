package apache_kafka.Library_Inventory_Consumer.scheduler;

import apache_kafka.Library_Inventory_Consumer.config.LibraryEventsConsumerConfig;
import apache_kafka.Library_Inventory_Consumer.entity.FailureRecord;
import apache_kafka.Library_Inventory_Consumer.jpa.FailureRecordRepository;
import apache_kafka.Library_Inventory_Consumer.service.LibraryEventsService;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;

//@Component
@Slf4j
public class RetryScheduler {

    @Autowired
    LibraryEventsService libraryEventsService;

    @Autowired
    FailureRecordRepository failureRecordRepository;


    @Scheduled(fixedRate = 10000 )
    public void retryFailedRecords(){

        log.info("Retrying Failed Records Started!");
        var status = LibraryEventsConsumerConfig.RETRY;
        failureRecordRepository.findAllByStatus(status)
                .forEach(failureRecord -> {
                    try {
                        //libraryEventsService.processLibraryEvent();
                        var consumerRecord = buildConsumerRecord(failureRecord);
                        libraryEventsService.processLibraryEvent(consumerRecord);
                       // libraryEventsConsumer.onMessage(consumerRecord); // This does not involve the recovery code for in the consumerConfig
                        failureRecord.setStatus(LibraryEventsConsumerConfig.SUCCESS);
                    } catch (Exception e){
                        log.error("Exception in retryFailedRecords : ", e);
                    }

                });

    }

    private ConsumerRecord<Integer, String> buildConsumerRecord(FailureRecord failureRecord) {

        return new ConsumerRecord<>(failureRecord.getTopic(),
                failureRecord.getPartition(), failureRecord.getOffset_value(), failureRecord.getKey_value(),
                failureRecord.getErrorRecord());

    }
}