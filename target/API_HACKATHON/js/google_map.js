/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
function getData(){
    console.log("you are in getData()")
    if (typeof XMLHttpRequest !== "undefined"){
      xmlHttp= new XMLHttpRequest();
      }
      else if (window.ActiveXObject){
      xmlHttp= new ActiveXObject("Microsoft.XMLHTTP");
      }
      if (xmlHttp===null){
      alert("Browser does not support XMLHTTP Request")
      return;
      } 
      var url="get_long_lat.jsp";
      xmlHttp.onreadystatechange = stateChange;
      xmlHttp.open("GET", url, true);
      xmlHttp.send(null);
}

function stateChange(){
    if (xmlHttp.readyState===4 || xmlHttp.readyState==="complete"){   
        var jsonObj = JSON.parse(xmlHttp.responseText);
//        console.log(jsonObj);
    
    
    var india = {lat: 20.5937, lng: 78.9629};
    var map = new google.maps.Map(document.getElementById('map'), {
      zoom: 4.5,
      center: india
    });
    
    for (var i = 0, length = jsonObj.length; i < length; i++) {
        var data = JSON.parse(jsonObj[i]);
        console.log(data);
        
        var pos = {lat: Number(data.lat), lng: Number(data.long)};
                
        var marker = new google.maps.Marker({
          position: pos,
          map: map,
        });
        
        if(data.action==="1"){
            marker.setIcon('http://maps.google.com/mapfiles/ms/icons/green-dot.png')
        }
        else if(data.action==="2"){
            marker.setIcon('http://maps.google.com/mapfiles/ms/icons/yellow-dot.png')
        }
        else if(data.action==="3"){
            marker.setIcon('http://maps.google.com/mapfiles/ms/icons/red-dot.png')
        }

      }
    
        
    } 
}

function initMap(){
//    var india = {lat: 20.5937, lng: 78.9629};
//    var map = new google.maps.Map(document.getElementById('map'), {
//      zoom: 5,
//      center: india
//    });
    
    var marker = new google.maps.Marker({
          position: india,
          map: map
    });
    
}




