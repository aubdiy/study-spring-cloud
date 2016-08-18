package self.aub.study.spring.cloud.netflix.ribbon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Created by liujinxin on 16/8/16.
 */
@RestController
public class ConsumerController {

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    ConsumerService consumerService;

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String add() {
        return restTemplate.getForEntity("http://COMPUTE-SERVICE/add?a=10&b=20", String.class).getBody();
    }

    @RequestMapping(value = "/addWithFallback", method = RequestMethod.GET)
    public String addWithFallback() {
        return consumerService.addService();
    }




}
