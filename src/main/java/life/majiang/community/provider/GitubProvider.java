package life.majiang.community.provider;

import com.alibaba.fastjson.JSON;
import life.majiang.community.dto.AccessTokenDTO;


import okhttp3.*;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * Author: 奔跑的狮子
 * Date: 2022/9/26 9:47
 */
//注入bean容器
@Component
public class GitubProvider {
    public String getAccessToken(AccessTokenDTO accessTokenDTO) {

        MediaType mediaType = MediaType.get("application/json; charset=utf-8");
        OkHttpClient client = new OkHttpClient();
        RequestBody body = RequestBody.create(mediaType, JSON.toJSONBytes(accessTokenDTO));
        Request request = new Request.Builder()
                .url("https://github.com/login/oauth/access_token")
                .post(body)
                .build();
        try (Response response = client.newCall(request).execute()) {
            String string = response.body().string();
            String token = string.split("&")[0].split("=")[1];
            return token;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }

    public GitubUser getUser(String accessTokenDTO) {

        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url("https://api.github.com/user?access_token=" + accessTokenDTO)
                .build();
        try {
            Response response = client.newCall(request).execute();
            String string = response.body().string();
            //把string 的对象自动转换为json对象
            GitubUser gitubUser = JSON.parseObject(string, GitubUser.class);
            return gitubUser;
        } catch (IOException e) {
        }
        return null;

    }


}


