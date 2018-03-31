/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function quest_opt(){
    var quest_format_element = document.getElementById('question_format');
    var quest_format = quest_format_element.options[quest_format_element.selectedIndex].value;
    console.log(quest_format);
    if(quest_format === 'Multiple Choice' || quest_format === 'Radio Button' || quest_format === 'Drop Down' || quest_format === 'Linear Scale'){
        document.getElementById('question_option').style.display = "block";
    }
    else{
        document.getElementById('question_option').style.display = "none";
    }
}

function change_opt(){
    var no_of_option = document.getElementById('no_of_option').value;
    console.log(no_of_option);
    var option_div = '<input placeholder="1)" class="form-control" type="text" name="option1" id="option1"/>';
    console.log(option_div);
    for(var i=2; i<=no_of_option; i++){
        option_div+= '<input placeholder="'+i+')" class="form-control" type="text" name="option'+i+'" id="option'+i+'" />';
    }
    console.log(option_div);
    document.getElementById('option').innerHTML = option_div;
}

function create_question(tid){
    var text = 'tid='+tid+'&';
    var question = document.getElementById('question').value;
    text += 'question='+question+'&';
    var quest_format_element = document.getElementById('question_format');
    var quest_format = quest_format_element.options[quest_format_element.selectedIndex].value;
    text += 'quest_format='+quest_format+'&';
    var visit_type_element = document.getElementById('visit_type');
    var visit_type = visit_type_element.options[visit_type_element.selectedIndex].value;
    text += 'visit_type='+visit_type+'&';
    
    var description = document.getElementById('question_description').value;
    text += 'description='+description+'&';
    
    //****************validation************************
    if(question === ''){
        alert("Enter question!!");
    }
    else if(description === ''){
        alert("Enter Description for the Question!!");
    }
    //**************************************************
    var no_of_option = 0;
    
    if(quest_format === 'Multiple Choice' || quest_format === 'Radio Button' || quest_format === 'Drop Down' || quest_format === 'Linear Scale'){
        
        var no_of_option = document.getElementById('no_of_option').value;
        
        
        //*****************validation*******************
        if(no_of_option<1){
            alert("Invalid number of options");
        }
        //***********************************************
        
        var i =1;
        for(; i<=no_of_option; i++){
            text += 'option'+i+'='+document.getElementById('option'+i).value+'&';
            //*********** validation *********************
            if(document.getElementById('option'+i).value === ''){
                alert("option"+i+" field is empty!!");
            }
            //********************************************
        }
        
    }
    text += 'no_of_option='+no_of_option+'&';
    
    
    var required = document.getElementById('required').checked;
    text += 'required='+required;
    
    console.log(text);
    if(question !== '' && description!== ''){
        var count = 0;
        for(var k=1; k<=no_of_option; k++){
            if(document.getElementById('option'+k).value === ''){
                count++;
            }
        }
        if(count===0){
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
            var url="create_question.jsp";
            url += "?"+text;

            xmlHttp.onreadystatechange = stateChange;
            xmlHttp.open("POST", url, true);
            xmlHttp.send(null);
        }
    }
}

function stateChange(){   
if (xmlHttp.readyState===4 || xmlHttp.readyState==="complete"){   
console.log(xmlHttp.responseText);  
var text = xmlHttp.responseText;
var output = text.split("#");
if(output[0].trim() === 'Already exist'){
    alert("already exist");
}
else{
    showQuestion(output[1]);
    cancel_question();
}
}   
}

function showQuestion(tid){
    if (typeof XMLHttpRequest !== "undefined"){
        xmlHttp1= new XMLHttpRequest();
    }
    else if (window.ActiveXObject){
      xmlHttp1= new ActiveXObject("Microsoft.XMLHTTP");
    }
    if (xmlHttp1===null){
      alert("Browser does not support XMLHTTP Request")
      return;
    } 
    var url1="show_question.jsp";
    url1 += "?tid="+tid;
    console.log(tid);
    console.log(url1);
    xmlHttp1.onreadystatechange = questionChange;
    xmlHttp1.open("POST", url1, true);
    xmlHttp1.send(null);
}

function questionChange(){
    if (xmlHttp1.readyState===4 || xmlHttp1.readyState==="complete"){   
        console.log(xmlHttp1.responseText);
        
        document.getElementById('add_ques').innerHTML = xmlHttp1.responseText;
    } 
}

function cancel_question(){
    document.getElementById('question_option').style.display = "none";
    document.getElementById('question').value = '';
    document.getElementById("question_format").selectedIndex = "0";
    document.getElementById('question_description').value = '';
}

function save(){
    //redirect to the task page
}

function form_delete(tid){
    if (typeof XMLHttpRequest !== "undefined"){
        xmlHttp1= new XMLHttpRequest();
    }
    else if (window.ActiveXObject){
      xmlHttp1= new ActiveXObject("Microsoft.XMLHTTP");
    }
    if (xmlHttp1===null){
      alert("Browser does not support XMLHTTP Request")
      return;
    } 
    var url1="delete_question_form.jsp";
    url1 += "?tid="+tid;
    console.log(tid);
    console.log(url1);
    xmlHttp1.onreadystatechange = del_form;
    xmlHttp1.open("POST", url1, true);
    xmlHttp1.send(null);
}

function del_form(){
    if (xmlHttp1.readyState===4 || xmlHttp1.readyState==="complete"){   
        console.log(xmlHttp1.responseText);
        showQuestion(xmlHttp1.responseText);
        //redirect to the add question page
    } 
}