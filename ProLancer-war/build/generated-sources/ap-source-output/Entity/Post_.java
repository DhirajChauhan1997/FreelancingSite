package Entity;

import Entity.ApplyProject;
import Entity.Categ;
import Entity.Skill;
import Entity.User;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-12-18T17:29:11")
@StaticMetamodel(Post.class)
public class Post_ { 

    public static volatile SingularAttribute<Post, String> duration;
    public static volatile SingularAttribute<Post, String> hmworker;
    public static volatile SingularAttribute<Post, Skill> skillid;
    public static volatile SingularAttribute<Post, Categ> categId;
    public static volatile ListAttribute<Post, ApplyProject> applyProjectList;
    public static volatile SingularAttribute<Post, String> price;
    public static volatile SingularAttribute<Post, String> jobdescr;
    public static volatile SingularAttribute<Post, String> postedOn;
    public static volatile SingularAttribute<Post, Integer> postid;
    public static volatile SingularAttribute<Post, String> title;
    public static volatile SingularAttribute<Post, User> posterid;

}