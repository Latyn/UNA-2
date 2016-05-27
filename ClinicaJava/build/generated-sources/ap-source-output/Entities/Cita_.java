package Entities;

import Entities.CitaPK;
import Entities.Usuario;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-05-27T00:25:43")
@StaticMetamodel(Cita.class)
public class Cita_ { 

    public static volatile SingularAttribute<Cita, String> descripcion;
    public static volatile SingularAttribute<Cita, CitaPK> citaPK;
    public static volatile ListAttribute<Cita, Usuario> usuarioList;
    public static volatile SingularAttribute<Cita, Date> fechaHora;
    public static volatile SingularAttribute<Cita, Usuario> usuario;

}