package Entity;

import Entity.Skill;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-12-18T17:29:11")
@StaticMetamodel(User.class)
public class User_ { 

    public static volatile SingularAttribute<User, String> fname;
    public static volatile SingularAttribute<User, Skill> skillid;
    public static volatile SingularAttribute<User, String> password;
    public static volatile SingularAttribute<User, String> mobno;
    public static volatile SingularAttribute<User, String> lname;
    public static volatile SingularAttribute<User, String> photo;
    public static volatile SingularAttribute<User, String> description;
    public static volatile SingularAttribute<User, Integer> userid;
    public static volatile SingularAttribute<User, String> createdon;
    public static volatile SingularAttribute<User, String> email;
    public static volatile SingularAttribute<User, String> username;

}