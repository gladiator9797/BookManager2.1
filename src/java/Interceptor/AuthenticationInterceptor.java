package Interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import java.util.Map;

public class AuthenticationInterceptor extends AbstractInterceptor {

    /*
    @Override
    public void destroy() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void init() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    } */

    @Override
    public String intercept(ActionInvocation ai) throws Exception {
        Map<String,Object> session = ai.getInvocationContext().getSession();
        if(session == null || session.get("username")==null){
            //return ActionSupport.LOGIN;
            return "noSession";  //no session => login page
        }
        return ai.invoke();  //has session => next action
        
    }

}
