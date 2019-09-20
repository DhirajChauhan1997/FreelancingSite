package Entity;

import Entity.Post;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-12-18T17:29:11")
@StaticMetamodel(Categ.class)
public class Categ_ { 

    public static volatile SingularAttribute<Categ, Integer> categid;
    public static volatile CollectionAttribute<Categ, Post> postCollection;
    public static volatile SingularAttribute<Categ, String> categname;

}