package co.com.company.infrastructure.adapter.resttemplate;

import co.com.company.infrastructure.restcontroller.exception.TechnicalException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;

@Component
public class GrettingConsumeRestTemplate {

    private static final String URL_BASE = "http://192.168.2.112:8080/rest-producer/greeting/";
    final RestTemplate restTemplate;

    @Autowired
    public GrettingConsumeRestTemplate(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public String gretting(String name) {
        try {
            ResponseEntity<String> response = restTemplate.exchange(URL_BASE + name, HttpMethod.GET, HttpEntity.EMPTY, String.class);
            return response.getBody();
        }catch (ResourceAccessException e){
            throw new TechnicalException("Servicio demorado, timeout agotado",e);
        }
    }
}