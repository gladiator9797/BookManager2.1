package Interceptor;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;
import java.util.Map;

public class FirstInterceptor implements Interceptor {

    Map session;

    public Map getSession() {
        return session;
    }

    public void setSession(Map session) {
        this.session = session;
    }

    @Override
    public void destroy() {
    }

    @Override
    public void init() {
    }

    @Override
    public String intercept(ActionInvocation actionInvocation) throws Exception {
        String result;
        session = ActionContext.getContext().getSession();
        if (session.get("username") != null) {
            result = "success";
        } else {
            result = "fail";
        }
        return result;
    }
}
