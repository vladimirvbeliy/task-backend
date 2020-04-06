package com.task.bank.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "server-application-client", url = "${feign-client.serverUrl}")
public interface ServerApplicationClient {

    @RequestMapping(method = RequestMethod.GET, value = "/server/test", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    String getHelloFromServer();

    @RequestMapping(method = RequestMethod.GET, value = "/server/file", consumes = MediaType.APPLICATION_XML_VALUE)
    byte[] getXmlFileFromServer();

}
