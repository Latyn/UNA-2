  function Usuario(codigo,clave,categoria) {
    this.Usuario(codigo,clave,categoria);
  }
  
  Usuario.prototype={
  	codigo: "",
	clave: "",
        categoria: "",
	Usuario: function(codigo,clave,categoria){
		this.codigo=codigo;
		this.clave=clave;
                this.categoria=categoria;
	},
	toString:function(){
	  return this.codigo;
	}
  };
  
  Usuario.from= function(plain){
    usuario = new Usuario(plain.codigo,plain.clave,plain.categoria);
	return usuario;
  };
  
    Usuario.to= function(usuario){
    return {
        _class : 'Usuario',
        codigo : usuario.codigo,
        clave : usuario.clave,
        categoria : usuario.categoria
    };	
  };
 