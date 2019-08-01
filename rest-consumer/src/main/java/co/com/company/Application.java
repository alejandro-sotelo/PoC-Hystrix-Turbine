package co.com.company;


import io.micrometer.core.instrument.binder.hystrix.HystrixMetricsBinder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableHystrix
public class Application {

    @Bean
    HystrixMetricsBinder hystrixMetricsBinder() {
        return new HystrixMetricsBinder();
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
