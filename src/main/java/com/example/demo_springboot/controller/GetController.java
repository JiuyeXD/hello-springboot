package com.example.demo_springboot.controller;

import com.example.demo_springboot.domain.ServerSettings;
import com.example.demo_springboot.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/*
 * @author: Jiuye
 * @date: 2020-07-16 13:28
 * @package: com.example.demo_springboot.controller
 * @Description:
 */
@RestController
public class GetController {

    private Map<String, Object> params = new HashMap<>();

    /*
     * 测试restful协议 从路径中获得字段
     * */
    @RequestMapping(path = "/v1/{city_id}/{user_id}", method = RequestMethod.GET)
    public Object findUser(@PathVariable("city_id") String cityId,
                           @PathVariable("user_id") String userId) {
        params.clear();

        params.put("city_id", cityId);
        params.put("user_id", userId);
        return params;
    }
    /*测试get*/
    @GetMapping("/v1/page_user1")
    public Object pageUser(int from,int size){
        params.clear();
        params.put("from",from);
        params.put("size",size);
        return params;
    }
    /*默认值参数*/
    @GetMapping("/v1/page_user2")
    public Object pageUserV2(@RequestParam(defaultValue = "0",name = "page") int from,int size){
        params.clear();
        params.put("from",from);
        params.put("size",size);
        return params;
    }

    /*
    * bean对象传参
    * 注意: 1.注意需要指定http头为 content-type为application/json
    *      2.注意使用body传输数据
    * */
    @RequestMapping("/v1/save_user")
    public Object saveUser(@RequestBody User user){
        params.clear();
        params.put("user",user);
        return params;
    }

    /*
    * 测试获取http头信息
    * */

    @GetMapping("/v1/get_header")
    public Object getHeader(@RequestHeader("access_token") String accessToken,String id){
        params.clear();
        params.put("access_token",accessToken);
        params.put("id",id);
        return params;
    }

    @GetMapping("/v1/test_request")
    public Object testRequest(HttpServletRequest request){
        params.clear();
        String id = request.getParameter("id");
        params.put("id",id);
        return params;
    }

    @Autowired
    private ServerSettings serverSettings;
    @GetMapping("/v1/test_properties")
    public Object testProperties(){
        return serverSettings;
    }
}
