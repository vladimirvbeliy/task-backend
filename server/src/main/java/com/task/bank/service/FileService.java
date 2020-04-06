package com.task.bank.service;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.experimental.NonFinal;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;

@Service
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@Slf4j
public class FileService {

    @NonFinal
    @Value("${file.name}")
    String fileName;

    public  InputStream getFile() throws IOException {
        log.info("getting file: {} content from resources folder", fileName);
        Resource resource = new ClassPathResource(fileName);
        return resource.getInputStream();
    }
}
