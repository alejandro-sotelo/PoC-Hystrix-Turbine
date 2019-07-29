package co.com.company.infrastructure.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.tinylog.Logger;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;


@RestController
public class GreetingController {

    private HttpServletRequest request;

    @Autowired
    public GreetingController(HttpServletRequest request) {
        this.request = request;
    }

    @GetMapping(value = "/greeting/{name}", produces = MediaType.TEXT_PLAIN_VALUE)
    public String greeting(@PathVariable("name") String name) {
        String remoteAdr = request.getHeader("X-FORWADED-FOR");
        if (remoteAdr == null || "".equals(remoteAdr)) {
            remoteAdr = request.getRemoteAddr();
        }

        return String.format("Hello %s!%n", name);
    }

}
