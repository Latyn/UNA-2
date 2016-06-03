package service;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import service.Usuario;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-06-03T00:47:48")
@StaticMetamodel(Categoria.class)
public class Categoria_ { 

    public static volatile SingularAttribute<Categoria, String> descripcion;
    public static volatile SingularAttribute<Categoria, String> codigo;
    public static volatile CollectionAttribute<Categoria, Usuario> usuarioCollection;

}