package com.example.testsimpleexternalservice.controller;

import com.example.testsimpleexternalservice.service.FileService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class FileControllerImpl implements FileController {
    private final FileService fileService;

    @Override
    public ResponseEntity<Resource> showFile(String fileName) {
        return fileService.showFile(fileName);
    }
}
