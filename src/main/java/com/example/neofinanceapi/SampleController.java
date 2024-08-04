package com.example.neofinanceapi;

import lombok.Getter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Getter
@RestController
public class SampleController {

    @GetMapping("/")
    public String home() {
        return "Spring";
    }

}
