  function Usuario(codigo,clave,categoria,descripcion,telefono,correo) {
    this.Usuario(codigo,clave,categoria,descripcion,telefono,correo);
  }
  
  Usuario.prototype={
  	codigo: "",
	clave: "",
        categoria: "",
        descripcion: "",
        telefono: "",
        correo : "",
	Usuario: function(codigo,clave,categoria, descripcion,telefono,correo ){
		this.codigo=codigo;
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
  
  Usuario.from= function(plain){
    usuario = new Usuario(plain.codigo,plain.clave,plain.categoria, plain.descripcion, plain.telefono, plain.correo);
	return usuario;
  };
  
    Usuario.to= function(usuario){
    return {
        _class : 'Usuario',
        codigo : usuario.codigo,
        clave : usuario.clave,
        categoria : usuario.categoria,
        descripcion : usuario.descripcion,
        telefono : usuario.telefono,
        correo : usuario.correo
    };	
  };
 