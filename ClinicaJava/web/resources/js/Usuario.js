  function Usuario(codigo,clave,categoria,descripcion) {
    this.Usuario(codigo,clave,categoria,descripcion);
  }
  
  Usuario.prototype={
  	codigo: "",
	clave: "",
        categoria: "",
        descripcion:"",
	Usuario: function(codigo,clave,categoria, descripcion){
		this.codigo=codigo;
		this.clave=clave;
                this.categoria=categoria;
                this.descripcion = descripcion;
	},
	toString:function(){
	  return this.codigo;
	}
  };
  
  Usuario.from= function(plain){
    usuario = new Usuario(plain.codigo,plain.clave,plain.categoria, plain.descripcion);
	return usuario;
  };
  
    Usuario.to= function(usuario){
    return {
        _class : 'Usuario',
        codigo : usuario.codigo,
        clave : usuario.clave,
        categoria : usuario.categoria,
        descripcion : usuario.descripcion
    };	
  };
 