package Entity;

import Entity.Post;
import Entity.User;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-12-18T17:28:32")
@StaticMetamodel(ApplyProject.class)
public class ApplyProject_ { 

    public static volatile SingularAttribute<ApplyProject, Integer> applyProjectId;
    public static volatile SingularAttribute<ApplyProject, String> applyOn;
    public static volatile SingularAttribute<ApplyProject, String> coverLatter;
    public static volatile SingularAttribute<ApplyProject, Post> postid;
    public static volatile SingularAttribute<ApplyProject, User> userid;
    public static volatile SingularAttribute<ApplyProject, String> status;

}