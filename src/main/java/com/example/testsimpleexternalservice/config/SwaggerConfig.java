package com.example.testsimpleexternalservice.config;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info = @Info(
                title = "Spring Boot Swagger Title 2",
                version = "1.5.5",
                contact = @Contact(
                        name = "Alisher Farkhodov",
                        email = "farkhodovalisher@gmail.com",
                        url = "https://www.myportfolio2002.com"
                ),
                license = @License(name = "Apache 999", url = "https://springdoc.org")
        ),
        externalDocs = @ExternalDocumentation(
                url = "https://springdoc.org/v/2",
                description = "This is a external documentation (If you must it)"
        ),
        servers = {
                @Server(url = "http://localhost:8080", description = "global main server")
        },
        security = @SecurityRequirement(name = "bearerAuth")
)

@SecurityScheme(
        name = "bearerAuth",
        description = "Bearer Authentication with JWT token [description]",
        type = SecuritySchemeType.HTTP,
        bearerFormat = "JWT",
        scheme = "bearer",
        in = SecuritySchemeIn.HEADER
)
public class SwaggerConfig {
}
