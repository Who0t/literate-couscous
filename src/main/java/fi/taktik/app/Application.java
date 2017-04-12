package fi.taktik.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
        System.out.println("GET: http://localhost:8080/items");
        System.out.println("GET: http://localhost:8080/items/{id}");
        System.out.println("POST: http://localhost:8080/items");
    }
}
