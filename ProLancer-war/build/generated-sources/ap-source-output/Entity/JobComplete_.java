package Entity;

import Entity.User;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-12-18T17:29:11")
@StaticMetamodel(JobComplete.class)
public class JobComplete_ { 

    public static volatile SingularAttribute<JobComplete, Integer> jobComplateId;
    public static volatile SingularAttribute<JobComplete, String> finishOn;
    public static volatile SingularAttribute<JobComplete, Integer> postid;
    public static volatile SingularAttribute<JobComplete, User> userid;

}