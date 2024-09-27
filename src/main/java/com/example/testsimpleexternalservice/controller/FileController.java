package com.example.testsimpleexternalservice.controller;

import com.example.testsimpleexternalservice.constant.PathConstant;
import jdk.jfr.ContentType;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

@RequestMapping(PathConstant.FilePathConstant.BASE_PATH)
public interface FileController {

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = PathConstant.FilePathConstant.SHOW_BY_FILE_NAME)
    ResponseEntity<Resource> showFile(@PathVariable String fileUniqueName);
}
