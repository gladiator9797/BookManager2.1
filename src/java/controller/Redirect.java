/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import com.opensymphony.xwork2.ActionContext;
import java.util.Map;

/**
 *
 * @author gladi
 */
public class Redirect {

    Map session;

    public Map getSession() {
        return session;
    }

    public void setSession(Map session) {
        this.session = session;
    }

    public String redirect() {
        session = ActionContext.getContext().getSession();
        if ((String)session.get("username") != null) {
            return "success";
        } else {
            return "fail";
        }
    }
}
