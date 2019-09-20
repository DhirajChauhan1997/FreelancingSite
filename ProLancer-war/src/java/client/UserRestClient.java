/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import javax.ws.rs.ClientErrorException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.WebTarget;

/**
 * Jersey REST client generated for REST resource:UserRest [client]<br>
 * USAGE:
 * <pre>
 *        UserRestClient client = new UserRestClient();
 *        Object response = client.XXX(...);
 *        // do whatever with response
 *        client.close();
 * </pre>
 *
 * @author Dhiraj Chauhan
 */
public class UserRestClient {

    private WebTarget webTarget;
    private Client client;
    private static final String BASE_URI = "http://localhost:8080/ProLancer-war/webresources";

    public UserRestClient() {
        client = javax.ws.rs.client.ClientBuilder.newClient();
        webTarget = client.target(BASE_URI).path("client");
    }

    public String getWelcome() throws ClientErrorException {
        WebTarget resource = webTarget;
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_XML).get(String.class);
    }

    public <T> T getAllPostByTitle_XML(Class<T> responseType, String title) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("getAllPostByTitle/{0}", new Object[]{title}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_XML).get(responseType);
    }

    public <T> T getAllPostByTitle_JSON(Class<T> responseType, String title) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("getAllPostByTitle/{0}", new Object[]{title}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T getAllPostByPostedOn_XML(Class<T> responseType, String date) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("getAllPostByPostedOn/{0}", new Object[]{date}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_XML).get(responseType);
    }

    public <T> T getAllPostByPostedOn_JSON(Class<T> responseType, String date) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("getAllPostByPostedOn/{0}", new Object[]{date}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void createapplyProject_XML(Object requestEntity, String postid, String userid) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("createapplyProject/{0}/{1}", new Object[]{postid, userid})).request(javax.ws.rs.core.MediaType.APPLICATION_XML).post(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_XML));
    }

    public void createapplyProject_JSON(Object requestEntity, String postid, String userid) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("createapplyProject/{0}/{1}", new Object[]{postid, userid})).request(javax.ws.rs.core.MediaType.APPLICATION_JSON).post(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON));
    }

    public <T> T getAllPostByPostID_XML(Class<T> responseType, String postid) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("getAllPostByPostID/{0}", new Object[]{postid}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_XML).get(responseType);
    }

    public <T> T getAllPostByPostID_JSON(Class<T> responseType, String postid) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("getAllPostByPostID/{0}", new Object[]{postid}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T getAllPostByPrice_XML(Class<T> responseType, String price) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("getAllPostByPrice/{0}", new Object[]{price}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_XML).get(responseType);
    }

    public <T> T getAllPostByPrice_JSON(Class<T> responseType, String price) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("getAllPostByPrice/{0}", new Object[]{price}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void createPost_XML(Object requestEntity, String posterid, String skillid, String categid) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("createPost/{0}/{1}/{2}", new Object[]{posterid, skillid, categid})).request(javax.ws.rs.core.MediaType.APPLICATION_XML).post(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_XML));
    }

    public void createPost_JSON(Object requestEntity, String posterid, String skillid, String categid) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("createPost/{0}/{1}/{2}", new Object[]{posterid, skillid, categid})).request(javax.ws.rs.core.MediaType.APPLICATION_JSON).post(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON));
    }

    public <T> T getAllPost_XML(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("getAllPost");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_XML).get(responseType);
    }

    public <T> T getAllPost_JSON(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("getAllPost");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T getAllPostByPosterID_XML(Class<T> responseType, String posterid) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("getAllPostByPosterID/{0}", new Object[]{posterid}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_XML).get(responseType);
    }

    public <T> T getAllPostByPosterID_JSON(Class<T> responseType, String posterid) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("getAllPostByPosterID/{0}", new Object[]{posterid}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void updateUser_XML(Object requestEntity, String skillid) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("updateUser/{0}", new Object[]{skillid})).request(javax.ws.rs.core.MediaType.APPLICATION_XML).put(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_XML));
    }

    public void updateUser_JSON(Object requestEntity, String skillid) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("updateUser/{0}", new Object[]{skillid})).request(javax.ws.rs.core.MediaType.APPLICATION_JSON).put(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON));
    }

    public void removeApplyProject(String applyID) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("removeApplyProject/{0}", new Object[]{applyID})).request().delete();
    }

    public <T> T getAllPostByDuration_XML(Class<T> responseType, String duration) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("getAllPostByDuration/{0}", new Object[]{duration}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_XML).get(responseType);
    }

    public <T> T getAllPostByDuration_JSON(Class<T> responseType, String duration) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("getAllPostByDuration/{0}", new Object[]{duration}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T getAllApplyProject_XML(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("getAllApplyProject}");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_XML).get(responseType);
    }

    public <T> T getAllApplyProject_JSON(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("getAllApplyProject}");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void updatePost_XML(Object requestEntity, String skillid, String categid) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("updatepost/{0}/{1}", new Object[]{skillid, categid})).request(javax.ws.rs.core.MediaType.APPLICATION_XML).put(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_XML));
    }

    public void updatePost_JSON(Object requestEntity, String skillid, String categid) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("updatepost/{0}/{1}", new Object[]{skillid, categid})).request(javax.ws.rs.core.MediaType.APPLICATION_JSON).put(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON));
    }

    public void removeUser(String userid) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("removeUser/{0}", new Object[]{userid})).request().delete();
    }

    public void updateApplyProject_XML(Object requestEntity, String postid, String userid) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("createapplyProject/{0}/{1}", new Object[]{postid, userid})).request(javax.ws.rs.core.MediaType.APPLICATION_XML).put(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_XML));
    }

    public void updateApplyProject_JSON(Object requestEntity, String postid, String userid) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("createapplyProject/{0}/{1}", new Object[]{postid, userid})).request(javax.ws.rs.core.MediaType.APPLICATION_JSON).put(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON));
    }

    public void createUser_XML(Object requestEntity, String skillid, String groupid) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("createUser/{0}/{1}", new Object[]{skillid, groupid})).request(javax.ws.rs.core.MediaType.APPLICATION_XML).post(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_XML));
    }

    public void createUser_JSON(Object requestEntity, String skillid, String groupid) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("createUser/{0}/{1}", new Object[]{skillid, groupid})).request(javax.ws.rs.core.MediaType.APPLICATION_JSON).post(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON));
    }

    public void removePost(String postid) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("removePost/{0}", new Object[]{postid})).request().delete();
    }

    public void close() {
        client.close();
    }
    
}
