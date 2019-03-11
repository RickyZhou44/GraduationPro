package whu.iss.insurancesys.control;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")
@RestController
public class Test {

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String test(){
        System.out.println("hello");
        return "hello";
    }
}
