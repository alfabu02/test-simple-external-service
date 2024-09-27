package com.example.testsimpleexternalservice.service;

import com.example.testsimpleexternalservice.exception.MyException;
import com.example.testsimpleexternalservice.util.FileUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Slf4j
@Service
@RequiredArgsConstructor
public class FileServiceImpl implements FileService {

    @Override
    public ResponseEntity<Resource> showFile(String fileUniqueName) {
        Path path = FileUtil.filesDirectoryPath.resolve(fileUniqueName);

        FileSystemResource resource = new FileSystemResource(path);

        return ResponseEntity
                .ok()
                .contentType(MediaType.IMAGE_JPEG)
                .body(resource);
    }
}
