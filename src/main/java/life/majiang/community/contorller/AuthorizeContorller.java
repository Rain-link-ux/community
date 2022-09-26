package life.majiang.community.contorller;
import life.majiang.community.dto.AccessTokenDTO;
import life.majiang.community.provider.GitubProvider;

import life.majiang.community.provider.GitubUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;



/**
 * Author: 奔跑的狮子
 * Date: 2022/9/25 22:43
 */
@Controller
public class AuthorizeContorller {


    @Autowired
    private GitubProvider gitubProvider;

    //去配置文件里面读取github.client.id的key 和value
    @Value("${github.client.id}")
    private String clientId;

    @Value("${github.client.secret}")
    private String clientSecret;

    @Value("${github.redirect.uri}")
    private String redirectUri;

    @GetMapping("/callback")
    //@RequestParam 接收参数
    public String callback(@RequestParam(name = "code") String code,
                           @RequestParam(name = "state") String state) {

        AccessTokenDTO accessTokenDTO = new AccessTokenDTO();
        accessTokenDTO.setClient_id(clientId);
        accessTokenDTO.setClient_secret(clientSecret);
        accessTokenDTO.setCode(code);
        accessTokenDTO.setRedirect_uri(redirectUri);
        accessTokenDTO.setState(state);
        String accessToken = gitubProvider.getAccessToken(accessTokenDTO);
        GitubUser user = gitubProvider.getUser(accessToken);
        System.out.println(user.getName());
        return "index";

    }




}
