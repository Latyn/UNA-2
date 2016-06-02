var Proxy = Proxy || {};

Proxy.usuariosDelete = function(product,callBack){
    jsonText = JSON.stringify(product,replacer);
    var AJAX_req = new XMLHttpRequest();
    url="/ClinicaJava/ControllerServlet?action=UsuarioDelete";
    AJAX_req.open( "POST", url, true );
    AJAX_req.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    var callBackConstructor= function(productParameter){ 
            return function(){
                if( AJAX_req.readyState === 4 && AJAX_req.status === 200 ){
                    callBack(productParameter);
                }            
            };
        };
    AJAX_req.onreadystatechange = callBackConstructor(product);
    AJAX_req.send("product="+jsonText);   
};

Proxy.usuariosListCategory = function(category,callBack){
    jsonText = category;
    var AJAX_req = new XMLHttpRequest();
    url="/ClinicaJava/ControllerServlet?action=usuarioListCategory";
    AJAX_req.open( "POST", url, true );
    AJAX_req.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    AJAX_req.onreadystatechange = function(){
        if( AJAX_req.readyState === 4 && AJAX_req.status === 200 ){
            jsonText=AJAX_req.responseText;
            var object = JSON.parse( jsonText,revive );
            callBack(object);
        }
    };
    AJAX_req.send("category="+jsonText);   
};

Proxy.usuariosListSearch = function(criteria,callBack){
    jsonText = criteria;
    var AJAX_req = new XMLHttpRequest();
    url="/ClinicaJava/ControllerServlet?action=UsuarioListSearch";
    AJAX_req.open( "POST", url, true );
    AJAX_req.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    AJAX_req.onreadystatechange = function(){
        if( AJAX_req.readyState === 4 && AJAX_req.status === 200 ){
            jsonText=AJAX_req.responseText;
            var object = JSON.parse( jsonText,revive );
            callBack(object);
        }
    };
    AJAX_req.send("criteria="+jsonText);   
};

Proxy.usuariosListAll = function(callBack){
    var AJAX_req = new XMLHttpRequest();
    url="/ClinicaJava/ControllerServlet?action=UsuarioListAll";
    AJAX_req.open( "POST", url, true );
    AJAX_req.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    AJAX_req.onreadystatechange = function(){
        if( AJAX_req.readyState === 4 && AJAX_req.status === 200 ){
            jsonText=AJAX_req.responseText;
            var object = JSON.parse( jsonText,revive );
            callBack(object);
        }
    };
    AJAX_req.send();   
};

Proxy.usuariosUpdate = function(product,callBack){
    jsonText = JSON.stringify(product,replacer);
    var AJAX_req = new XMLHttpRequest();
    url="/ClinicaJava/ControllerServlet?action=ProductUpdate";
    AJAX_req.open( "POST", url, true );
    AJAX_req.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    AJAX_req.onreadystatechange = function(){
        if( AJAX_req.readyState === 4 && AJAX_req.status === 200 ){
            jsonText=AJAX_req.responseText;
            var status = JSON.parse( jsonText,revive );
            callBack(status);
        }
    };
    AJAX_req.send("product="+jsonText);   
};

Proxy.usuariosAdd = function(product,callBack){
    jsonText = JSON.stringify(product,replacer);
    var AJAX_req = new XMLHttpRequest();
    url="/ClinicaJava/ControllerServlet?action=UsuarioAdd";
    AJAX_req.open( "POST", url, true );
    AJAX_req.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    AJAX_req.onreadystatechange = function(){
        if( AJAX_req.readyState === 4 && AJAX_req.status === 200 ){
            jsonText=AJAX_req.responseText;
            var status = JSON.parse( jsonText,revive );
            callBack(status);
        }
    };
    AJAX_req.send("product="+jsonText);   
};



