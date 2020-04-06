package com.task.bank.service;

import com.task.bank.client.ServerApplicationClient;
import com.task.bank.dto.PaymentListDto;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

@Service
@Slf4j
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class ScheduledService {
    ServerApplicationClient client;
    DataHandlingService service;

    @Scheduled(cron = "${cron.value}")
    public void scheduledFile() throws JAXBException {
        log.info("SCHEDULED SERVER CALL");

        InputStream in = new ByteArrayInputStream(client.getXmlFileFromServer());
        JAXBContext jaxbContext  = JAXBContext.newInstance(PaymentListDto.class);
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        PaymentListDto paymentList = (PaymentListDto) jaxbUnmarshaller.unmarshal(in);

        service.handleReceivedData(paymentList);
    }
}
