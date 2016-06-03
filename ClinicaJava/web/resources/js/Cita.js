  function Cita(codigo,descripcion) {
    this.Cita(codigo,descripcion);
  }
  
  Cita.prototype={
  	codigo: "",
        descripcion: "",
	Cita: function(codigo,descripcion ){
		this.codigo=codigo;
                this.descripcion = descripcion;

	},
	toString:function(){
	  return this.codigo;
	}
  };
  
  //Duda que hace el plain o la funcion from en este caso, para que se utiliza
  Cita.from= function(plain){
    cita = new Cita(plain.codigo, plain.descripcion);
	return cita;
  };
  
    Cita.to= function(usuario){
    return {
        _class : 'Cita',
        codigo : usuario.codigo,
        descripcion : usuario.descripcion
    };	
  };

