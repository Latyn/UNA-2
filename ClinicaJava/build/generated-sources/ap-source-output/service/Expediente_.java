package service;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import service.Usuario;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-05-31T23:13:15")
@StaticMetamodel(Expediente.class)
public class Expediente_ { 

    public static volatile SingularAttribute<Expediente, String> descripcion;
    public static volatile SingularAttribute<Expediente, String> codigo;
    public static volatile CollectionAttribute<Expediente, Usuario> usuarioCollection;

}