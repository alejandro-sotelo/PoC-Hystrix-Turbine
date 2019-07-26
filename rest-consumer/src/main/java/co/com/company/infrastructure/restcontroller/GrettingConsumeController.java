package co.com.company.infrastructure.restcontroller;

import co.com.company.infrastructure.adapter.resttemplate.GrettingConsumeRestTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
public class GrettingConsumeController {

    @Autowired
    GrettingConsumeRestTemplate grettingConsumeRestTemplate;

    @GetMapping(value = "{name}", produces = MediaType.TEXT_PLAIN_VALUE)
    public String processStatus(@PathVariable("name") String name) {
        return grettingConsumeRestTemplate.gretting(name);
    }

}