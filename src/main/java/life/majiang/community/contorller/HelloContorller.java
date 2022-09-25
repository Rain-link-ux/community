package life.majiang.community.contorller;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;

/**
 * Author: 奔跑的狮子
 * Date: 2022/9/22 15:02
 */
@Controller
public class HelloContorller {

    @GetMapping("/")
    public String hello() {
        return  "index";
    }

}
