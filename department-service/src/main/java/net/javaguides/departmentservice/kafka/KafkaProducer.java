package net.javaguides.departmentservice.kafka;

import net.javaguides.departmentservice.dto.DepartmentDto;
import net.javaguides.departmentservice.entity.Department;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducer {

    private static final Logger log = LoggerFactory.getLogger(KafkaProducer.class);

    private KafkaTemplate<String, Department> kafkaTemplate;

    public void sendMessage(DepartmentDto department) {

        log.info(String.format("Message sent --> %s", department.toString()));
        Message<DepartmentDto> message = MessageBuilder
                .withPayload(department)
                .setHeader(KafkaHeaders.TOPIC, "department_json")
                .build();

        kafkaTemplate.send(message);
    }
}
