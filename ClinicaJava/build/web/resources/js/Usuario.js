  function Usuario(codigo,nombre,clave,categoria,descripcion,telefono,correo) {
    this.Usuario(codigo,nombre,clave,categoria,descripcion,telefono,correo);
  }
  
  Usuario.prototype={
  	codigo: "",
        nombre: "",
	clave: "",
        categoria: "",
        descripcion: "",
        telefono: "",
        correo : "",
	Usuario: function(codigo,nombre,clave,categoria, descripcion,telefono,correo ){
		this.codigo=codigo;
                this.nombre=nombre;
		this.clave=clave;
                this.categoria=categoria;
                this.descripcion = descripcion;
                this.telefono = telefono;
                this.correo = correo;
	},
	toString:function(){
	  return this.codigo;
	}
  };
  
  //Duda que hace el plain o la funcion from en este caso, para que se utiliza
  Usuario.from= function(plain){
    usuario = new Usuario(plain.codigo,plain.nombre,plain.clave,plain.categoria, plain.descripcion, plain.telefono, plain.correo);
	return usuario;
  };
  
    Usuario.to= function(usuario){
    return {
        _class : 'Usuario',
        codigo : usuario.codigo,
        nombre : usuario.nombre,
        clave : usuario.clave,
        categoria : usuario.categoria,
        descripcion : usuario.descripcion,
        telefono : usuario.telefono,
        correo : usuario.correo
    };	
  };
 