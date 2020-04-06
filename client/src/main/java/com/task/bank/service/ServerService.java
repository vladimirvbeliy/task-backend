package com.task.bank.service;

import com.task.bank.client.ServerApplicationClient;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@Slf4j
public class ServerService {
    ServerApplicationClient serverApplicationClient;

    public byte[] getServerFile() {
        log.info("sending request to server");
        return serverApplicationClient.getXmlFileFromServer();
    }
}
