  function Cita(codigo,descripcion,fecha_hora) {
    this.Cita(codigo,descripcion,fecha_hora);
  }
  
  Cita.prototype={
  	codigo: "",
        descripcion: "",
        fecha_hora: "",
	Cita: function(codigo,descripcion,fecha_hora ){
		this.codigo=codigo;
                this.descripcion = descripcion;
                this.fecha_hora = fecha_hora;

	},
	toString:function(){
	  return this.codigo;
	}
  };
  
  //Duda que hace el plain o la funcion from en este caso, para que se utiliza
  Cita.from= function(plain){
    cita = new Cita(plain.codigo, plain.descripcion, plain.fecha_hora);
	return cita;
  };
  
    Cita.to= function(cita){
    return {
        _class : 'Cita',
        codigo : cita.codigo,
        descripcion : cita.descripcion,
        fecha_hora : cita.fecha_hora
    };	
  };

