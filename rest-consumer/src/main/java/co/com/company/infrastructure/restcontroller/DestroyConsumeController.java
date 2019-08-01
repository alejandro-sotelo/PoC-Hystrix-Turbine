package co.com.company.infrastructure.restcontroller;

import co.com.company.infrastructure.adapter.resttemplate.DestroyTheWorldConsumeRestTemplate;
import co.com.company.infrastructure.adapter.resttemplate.GrettingConsumeRestTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DestroyConsumeController {

    @Autowired
    DestroyTheWorldConsumeRestTemplate destroyTheWorldConsumeRestTemplate;

    @GetMapping(value = "destroy", produces = MediaType.TEXT_PLAIN_VALUE)
    public String destroyTheWorld() {
        return destroyTheWorldConsumeRestTemplate.destroy();
    }

}