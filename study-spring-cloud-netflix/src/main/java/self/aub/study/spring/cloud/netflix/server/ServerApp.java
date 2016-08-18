package self.aub.study.spring.cloud.netflix.server;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

import java.util.Properties;

/**
 * Created by liujinxin on 16/8/16.
 */
@EnableEurekaServer
@SpringBootApplication
public class ServerApp {


    public static void main(String[] args) {
        Properties properties = System.getProperties();
        properties.setProperty("spring.config.name","server");
        System.setProperties(properties);


        new SpringApplicationBuilder(ServerApp.class).web(true).run(args);
    }

}
