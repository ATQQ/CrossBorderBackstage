package sugar.service;

import sugar.bean.User;

public interface userService {
    /**
     * 用户登录
     * @param username 用户名
     * @param password  密码
     * @return User
     */
    public User login(String username,String password);

    /**
     * 用户注册
     * @param user
     * @return boolean
     */
    public boolean regist(User user);

    /**
     * 查询用户是否存在
     * @param username
     * @return
     */
    public boolean isUserExist(String username);
}
