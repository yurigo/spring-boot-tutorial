package com.example.springboottutorial;

import org.apache.catalina.connector.Response;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.util.List;

@SpringBootApplication
@RestController
public class SpringBootTutorialApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootTutorialApplication.class, args);
    }

    @CrossOrigin
    @GetMapping("/hello")
    public String sayHello(@RequestParam(value = "myName", defaultValue = "World") String name) {
        return String.format("Hello %s!", name);
    }

    @CrossOrigin
    @RequestMapping(
            method = RequestMethod.PUT,
            value = "/v1/product/{draftProductId}",
            produces = { "application/json;charset=UTF-8" },
            consumes = { MediaType.MULTIPART_FORM_DATA_VALUE }
    )
    public ResponseEntity<DraftProductDTO> putProduct(
            //....
            @Valid @RequestParam(value = "productStatus", required = false) ProductStatusDTO productStatus,
            @Valid @RequestParam(value = "comments", required = false) String comments,
            @Valid @RequestPart(value = "assets", required = false) List<@Valid AssetDTO> assets,
            @Valid @RequestPart(value = "file", required = false) MultipartFile file
            ) {

        System.out.println("productStatus: " + productStatus);
        System.out.println("comments: " + comments);
        System.out.println("file: " + file.getName());
        System.out.println("file: " + file.getSize());

        System.out.println("assets" + assets);
        // System.out.println("assets: " + assets);

        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }
}
