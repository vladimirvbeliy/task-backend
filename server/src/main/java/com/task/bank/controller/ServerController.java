package com.task.bank.controller;

import com.task.bank.service.FileService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.io.InputStream;

@RestController
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@RequiredArgsConstructor
@RequestMapping("/server")
@Slf4j
public class ServerController {

    FileService fileService;

    @Deprecated
    @GetMapping("/test")
    public String test() {
        return "HELLO FROM SERVER";
    }

    @GetMapping(value = "/file", produces = MediaType.APPLICATION_XML_VALUE)
    public @ResponseBody byte[] getFile() throws IOException {
        InputStream in = fileService.getFile();
        return IOUtils.toByteArray(in);
    }

}
