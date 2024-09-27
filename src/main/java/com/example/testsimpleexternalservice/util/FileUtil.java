package com.example.testsimpleexternalservice.util;

import com.example.testsimpleexternalservice.exception.MyException;
import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.UUID;

@Slf4j
@UtilityClass
public class FileUtil {

    public static final Path filesDirectoryPath = Path.of("D:\\project\\idea\\java\\pdp\\spring-advenced\\test-simple-external-service\\src\\main\\resources\\image");

    public static String writeFile(MultipartFile multipartFile) {
        String fileUniqueName = UUID.randomUUID() + multipartFile.getOriginalFilename();
        Path path = filesDirectoryPath.resolve(fileUniqueName);
        try {
            Files.copy(multipartFile.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
            return fileUniqueName;
        } catch (IOException e) {
            log.error(e.getMessage());
            throw new MyException(HttpStatus.INTERNAL_SERVER_ERROR, "Error happened while writing file, please try again");
        }
    }

}
