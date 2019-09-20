package Entity;

import Entity.Grouptbl;
import Entity.User;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-12-18T17:29:11")
@StaticMetamodel(UserGroup.class)
public class UserGroup_ { 

    public static volatile SingularAttribute<UserGroup, Integer> userGroupId;
    public static volatile SingularAttribute<UserGroup, Grouptbl> groupId;
    public static volatile SingularAttribute<UserGroup, User> userid;

}