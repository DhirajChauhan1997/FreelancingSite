/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManageBean;

import EJB.AdminSessionBeanLocal;
import Entity.User;
import java.util.Collection;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author Dhiraj Chauhan
 */
@Named(value = "testManagedBean")
@RequestScoped
public class TestManagedBean {

    @EJB
    AdminSessionBeanLocal asbl;

    Collection<User> UserList;

    public Collection getUserList() {
        UserList = asbl.getAllUser();
        return UserList;
    }

    public void setUserList(Collection<User> UserList) {
        this.UserList = UserList;
    }

    public TestManagedBean() {
    }

}
