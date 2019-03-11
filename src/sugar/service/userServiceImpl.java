package sugar.service;
/*
 *@auther suger
 *2019
 *0:01
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sugar.bean.User;
import sugar.bean.UserExample;
import sugar.mapper.UserMapper;

import java.util.List;

@Service
public class userServiceImpl implements userService{

    @Autowired
    private UserMapper userMapper;

    @Override
    public User login(String username, String password) {
        UserExample example=new UserExample();
        UserExample.Criteria criteria=example.createCriteria();
        criteria.andUsernameEqualTo(username).andPasswordEqualTo(password);
        List<User> users = userMapper.selectByExample(example);
        if(users.isEmpty())
        return null;
        else{
            return users.get(0);
        }
    }
}
