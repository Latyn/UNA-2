package service;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import service.Usuario;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-06-02T10:22:37")
@StaticMetamodel(Cita.class)
public class Cita_ { 

    public static volatile SingularAttribute<Cita, String> descripcion;
    public static volatile SingularAttribute<Cita, String> codigo;
    public static volatile SingularAttribute<Cita, Date> fechaHora;
    public static volatile CollectionAttribute<Cita, Usuario> usuarioCollection;

}