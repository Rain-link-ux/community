package life.majiang.community.contorller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Author: 奔跑的狮子
 * Date: 2022/9/25 22:43
 */
@Controller
public class AuthorizeContorller {

    @GetMapping("/callback")
    //@RequestParam 接收参数
    public String callback(@RequestParam(name = "code") String code,
                           @RequestParam(name = "state") String state) {

        return "index";

    }

}
