package com.example.testsimpleexternalservice.service;

import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;

public interface FileService {
    ResponseEntity<Resource> showFile(String fileUniqueName);
}
