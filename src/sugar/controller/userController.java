package sugar.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import sugar.bean.User;
import sugar.service.userService;

import javax.servlet.http.HttpSession;
import java.util.Map;

/*
 *@auther suger
 *2019
 *0:16
 */
@Controller
@RequestMapping("user")
public class userController {
    //状态码
    private final String SUCCESS = "1";
    private final String fail = "0";

    @Autowired
    private userService userService;

    /**
     * 用户登录接口
     * @return String
     */
    @RequestMapping(value = "login",method =RequestMethod.POST)
    @ResponseBody
    public String login(@RequestBody User tuser,HttpSession session){
        //获取账号密码
        JSONObject jsonObject=new JSONObject();
        String username = tuser.getUsername();
        String password = tuser.getPassword();

        System.out.println(tuser.getUsername());
        System.out.println(tuser.getPassword());
        //如果有一个为空
        if(username==null||password==null){
            jsonObject.put("state",fail);
            return jsonObject.toJSONString();
        }
        //查询数据
        User user=userService.login(username,password);
        if (user!=null){
            session.setAttribute("user",user);
            String sessionId = session.getId();
            jsonObject.put("state",SUCCESS);
            jsonObject.put("token",sessionId);
            return jsonObject.toJSONString();
        }else{
            jsonObject.put("state",fail);
            return jsonObject.toJSONString();
        }
    }

    /**
     * 用户注册接口
     * @param user
     * @return String
     */
    @RequestMapping(value = "user",method =RequestMethod.PUT)
    @ResponseBody
    public String regist(@RequestBody User user){
        JSONObject jsonObject=new JSONObject();
        if(userService.regist(user)){
            jsonObject.put("state",SUCCESS);
            return jsonObject.toJSONString();
        }else{
            jsonObject.put("state",fail);
            return jsonObject.toJSONString();
        }
    }

}
