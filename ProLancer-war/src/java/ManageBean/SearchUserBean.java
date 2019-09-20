/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManageBean;

import Entity.*;
import client.AdminRestClient;
import java.util.ArrayList;
import java.util.Collection;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.ws.rs.ClientErrorException;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;

/**
 *
 * @author Dhiraj Chauhan
 */
@Named(value = "searchUserBean")
@RequestScoped
public class SearchUserBean {

    // public AdminRestClient adminRestClient;
    AdminRestClient Adminclient;
    Response rs;
    Collection<User> userList;
    GenericType<Collection<User>> usersgeneric;

    public Collection<User> getUserList() {
        return userList;
    }

    public void setUserList(Collection<User> userList) {
        this.userList = userList;
    }

    /**
     * Creates a new instance of SearchUserBean
     */
    public SearchUserBean() {
        Adminclient = new AdminRestClient();
        userList = new ArrayList<>();
        usersgeneric = new GenericType<Collection<User>>() {
        };

    }

    public Collection getAllUserList() {
        return userList;
    }

    private enum SEARCH_BY {

        FIRSTNAME(1), LASTNAME(0), EMAIL(2), USERNAME(3), MOBILENO(4), CREATEDON(5);
        private int value = -1;

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        private SEARCH_BY(int value) {
            this.value = value;
        }
    }

    private int searchBy;

    private String keyword;

    public int getSearchBy() {
        return searchBy;
    }

    public void setSearchBy(int searchBy) {
        this.searchBy = searchBy;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public void search() {

        try {

            if (searchBy == SEARCH_BY.FIRSTNAME.getValue()) {
                rs = Adminclient.getUserByFirstName_JSON(Response.class, keyword);
                userList = rs.readEntity(usersgeneric);
            } else if (searchBy == SEARCH_BY.LASTNAME.getValue()) {
                rs = Adminclient.getAllUserByLastName_XML(Response.class, keyword);
                userList = rs.readEntity(usersgeneric);
            } else if (searchBy == SEARCH_BY.EMAIL.getValue()) {
                rs = Adminclient.getAllUserByEmail_XML(Response.class, keyword);
                userList = rs.readEntity(usersgeneric);
            } else if (searchBy == SEARCH_BY.MOBILENO.getValue()) {
                rs = Adminclient.getAllUserByEmail_XML(Response.class, keyword);
                userList = rs.readEntity(usersgeneric);
            } else if (searchBy == SEARCH_BY.CREATEDON.getValue()) {
                rs = Adminclient.getAllUserByEmail_XML(Response.class, keyword);
                userList = rs.readEntity(usersgeneric);
            } else {
                rs = Adminclient.getAllUser_JSON(Response.class);
                userList = rs.readEntity(usersgeneric);
            }
        } catch (ClientErrorException ex) {
            System.out.println("Error is in Search User Bean " + ex);
        }
    }
}
