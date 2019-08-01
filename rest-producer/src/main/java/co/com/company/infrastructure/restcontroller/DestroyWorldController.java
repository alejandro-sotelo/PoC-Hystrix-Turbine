package co.com.company.infrastructure.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;


@RestController
public class DestroyWorldController {

    private HttpServletRequest request;

    @Autowired
    public DestroyWorldController(HttpServletRequest request) {
        this.request = request;
    }

    @GetMapping(value = "/destroy", produces = MediaType.TEXT_PLAIN_VALUE)
    public String greeting() {
        String remoteAdr = request.getHeader("X-FORWADED-FOR");
        if (remoteAdr == null || "".equals(remoteAdr)) {
            remoteAdr = request.getRemoteAddr();
        }
        return String.format("Request accepted, the world will be destroy");
    }

}
