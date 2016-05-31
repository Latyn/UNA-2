  function Usuario(id,clave,tipo) {
    this.Usuario(id,clave,tipo);
  }
  
  Usuario.prototype={
  	codigo: "",
	clave: "",
	Usuario: function(codigo,clave){
		this.codigo=codigo;
		this.clave=clave;
	},
	toString:function(){
	  return this.id;
	}
  };
  
  Usuario.from= function(plain){
    usuario = new Usuario(plain.codigo,plain.clave);
	return usuario;
  };
  
    Usuario.to= function(usuario){
    return {
        _class : 'Usuario',
        codigo : usuario.codigo,
        clave : usuario.clave,
    };	
  };
 