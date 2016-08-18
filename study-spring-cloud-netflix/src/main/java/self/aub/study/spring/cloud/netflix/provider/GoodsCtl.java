package self.aub.study.spring.cloud.netflix.provider;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Properties;

/**
 * Created by liujinxin on 16/8/16.
 */

@RestController
@RequestMapping("/goods")
public class GoodsCtl {

    private final Logger logger = Logger.getLogger(getClass());

    @Autowired
    private DiscoveryClient client;

    @RequestMapping("/")
    public String home() {
        return "Hello World";
    }

    @RequestMapping(value = "/add" ,method = RequestMethod.GET)
    public Integer add(@RequestParam Integer a, @RequestParam Integer b) {
        ServiceInstance instance = client.getLocalServiceInstance();
        Integer r = a + b;
        logger.info("/add, host:" + instance.getHost() + ", service_id:" + instance.getServiceId() + ", result:" + r);
        return r;
    }


    public static void main(String[] args) {
        Properties properties = System.getProperties();
        properties.setProperty("spring.config.name","provider1");
        System.setProperties(properties);

        SpringApplication.run(GoodsCtl.class, args);
    }

}
