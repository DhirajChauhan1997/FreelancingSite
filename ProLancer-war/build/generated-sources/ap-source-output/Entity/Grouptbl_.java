package Entity;

import Entity.UserGroup;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-12-18T17:29:11")
@StaticMetamodel(Grouptbl.class)
public class Grouptbl_ { 

    public static volatile SingularAttribute<Grouptbl, String> groupName;
    public static volatile SingularAttribute<Grouptbl, Integer> groupId;
    public static volatile ListAttribute<Grouptbl, UserGroup> userGroupList;

}