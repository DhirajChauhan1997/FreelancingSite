package Entity;

import Entity.Post;
import Entity.User;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-12-18T17:29:11")
@StaticMetamodel(Skill.class)
public class Skill_ { 

    public static volatile SingularAttribute<Skill, Integer> skillid;
    public static volatile ListAttribute<Skill, User> userList;
    public static volatile ListAttribute<Skill, Post> postList;
    public static volatile SingularAttribute<Skill, String> skill;

}