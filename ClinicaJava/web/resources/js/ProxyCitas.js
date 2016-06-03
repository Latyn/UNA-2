var ProxyCitas = ProxyCitas || {};

ProxyCitas.citasDelete = function(product,callBack){
    jsonText = JSON.stringify(product,replacer);
    var AJAX_req = new XMLHttpRequest();
    url="/ClinicaJava/ControllerServlet?action=CitaDelete";
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

ProxyCitas.citasListCategory = function(category,callBack){
    jsonText = category;
    var AJAX_req = new XMLHttpRequest();
    url="/ClinicaJava/ControllerServlet?action=CitaListCategory";
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

ProxyCitas.citasListSearch = function(criteria,callBack){
    jsonText = criteria;
    var AJAX_req = new XMLHttpRequest();
    url="/ClinicaJava/ControllerServlet?action=CitaListSearch";
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

ProxyCitas.citasListAll = function(callBack){
    var AJAX_req = new XMLHttpRequest();
    url="/ClinicaJava/ControllerServlet?action=CitaListAll";
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

ProxyCitas.citasUpdate = function(product,callBack){
    jsonText = JSON.stringify(product,replacer);
    var AJAX_req = new XMLHttpRequest();
    url="/ClinicaJava/ControllerServlet?action=CitaUpdate";
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

ProxyCitas.citasAdd = function(product,callBack){
    jsonText = JSON.stringify(product,replacer);
    var AJAX_req = new XMLHttpRequest();
    url="/ClinicaJava/ControllerServlet?action=CitaAdd";
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



