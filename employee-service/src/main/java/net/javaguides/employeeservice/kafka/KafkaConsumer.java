package net.javaguides.employeeservice.kafka;

import net.javaguides.employeeservice.dto.DepartmentDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.EventListener;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaConsumer.class);
    private DepartmentDto department;

    @KafkaListener(topics="department_json", groupId = "department")
    public void consume(DepartmentDto department){

        LOGGER.info(String.format("Order event received in email service => %s", department.toString()));
        this.department = department;
    }

    public DepartmentDto getDepartmentJson (){

        return department;
    }
}
