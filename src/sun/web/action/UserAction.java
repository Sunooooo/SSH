package sun.web.action;

import com.opensymphony.xwork2.ActionContext;
import sun.domain.User;
import sun.service.UserService;

public class UserAction {
    private User user = new User();

    private UserService userService;

    public String login() throws Exception {
        // 1.调用 Service 执行登录逻辑
        User u = userService.getUserByCodePassword(user);
        // 2 将返回的user对象放入session
        ActionContext.getContext().getSession().put("user",u);
        // 重定向到项目
        return "toHome";
    }


    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;

    }
}
