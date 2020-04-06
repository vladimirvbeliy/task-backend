package com.task.bank.controller;

import com.task.bank.service.ServerService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@RequestMapping("/client")
public class ClientController {

    ServerService serverService;

    @Deprecated
    @GetMapping("/test")
    public String test() {
        return "HELLO FORM CLIENT";
    }

    @GetMapping("/connect")
    public String connect() {
        return serverService.getServerHello();
    }
    @GetMapping(value = "/file", produces = MediaType.APPLICATION_XML_VALUE)
    public @ResponseBody byte[] getFileFromServer() {
        return serverService.getServerFile();
    }
}
