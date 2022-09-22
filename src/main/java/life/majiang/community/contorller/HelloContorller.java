package life.majiang.community.contorller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Author: 奔跑的狮子
 * Date: 2022/9/22 15:02
 */
@Controller
public class HelloContorller {

    @GetMapping("/hello")
    public String hello(@RequestParam(name="name") String name, Model model) {
        model.addAttribute("name",name);
        return  "hello";
    }

}
