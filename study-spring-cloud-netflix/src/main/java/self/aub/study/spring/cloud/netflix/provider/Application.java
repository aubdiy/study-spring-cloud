package self.aub.study.spring.cloud.netflix.provider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import java.util.Properties;

/**
 * Created by liujinxin on 16/8/16.
 */
@SpringBootApplication
@EnableDiscoveryClient
public class Application {

    @Bean
    @LoadBalanced
    RestTemplate restTemplate() {
        return new RestTemplate();
    }

    public static void main(String[] args) {
        Properties properties = System.getProperties();
        properties.setProperty("spring.config.name","provider");
        System.setProperties(properties);

        SpringApplication.run(Application.class, args);
    }

}
