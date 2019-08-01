package co.com.company.infrastructure.adapter.resttemplate;

import co.com.company.infrastructure.restcontroller.exception.TechnicalException;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;
import org.tinylog.Logger;

import java.time.LocalDateTime;

@Component
public class DestroyTheWorldConsumeRestTemplate {

    private static final String URL_BASE = "http://localhost:8080/rest-producer/destroy/";
    final RestTemplate restTemplate;

    @Autowired
    public DestroyTheWorldConsumeRestTemplate(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @HystrixCommand(fallbackMethod = "genericDestroy")
    public String destroy() {
        try {
            ResponseEntity<String> response = restTemplate.exchange(URL_BASE , HttpMethod.GET, HttpEntity.EMPTY, String.class);
            return response.getBody();
        }catch (ResourceAccessException e){
            throw new TechnicalException("Timeout expired",e);
        }
    }

    public String genericDestroy() {
        Logger.tag("EXPOSE_WS").info("{} - Service destroyTheWorld unavailable, as the world will be destroyed, contingency is activated", LocalDateTime.now());
        return String.format("Contingency - Autodestruction in 5,4,3,2...");
    }


}