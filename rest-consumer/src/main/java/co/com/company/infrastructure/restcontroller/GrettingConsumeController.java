package co.com.company.infrastructure.restcontroller;

import co.com.company.infrastructure.adapter.resttemplate.GrettingConsumeRestTemplate;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
public class GrettingConsumeController {

    @Autowired
    GrettingConsumeRestTemplate grettingConsumeRestTemplate;

    @GetMapping(value = "{name}", produces = MediaType.TEXT_PLAIN_VALUE)
    public String grettingUser(@PathVariable("name") String name) {
        return grettingConsumeRestTemplate.grettingUser(name);
    }

    @HystrixCommand
    @GetMapping(value = "bye", produces = MediaType.TEXT_PLAIN_VALUE)
    public String byeUser() {
        return String.format("Bye");
    }
}