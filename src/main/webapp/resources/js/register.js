function User(){
    var self=this;
    self.userName=null;
   // self.password=null;
}
function setUser(){
   var user=new User();
   user.userName="deb"
  // user.password="deb123"
   return user; 	   
}
/*********************************************************************************
 * Function to save one to one mapping of Sub Sub Class with GL Code.
 *********************************************************************************/
 function saveUser(){

     var date=new Date();
    
      var url="UserService/Save/unprotected";
      $.ajax({
              type:"POST",
               url: url,
               data :JSON.stringify(setUser()),
              
               beforeSend: function(xhr) {
                   xhr.setRequestHeader("Accept", "application/json");
                   xhr.setRequestHeader("Content-Type", "application/json");
               },
               success:function(data){
                   alert(data);                     
                 },
            error:function(jqXHR, textStatus, errorThrown){
                 alert(getAjaxErrorMessage("Failed to save User data.",jqXHR, textStatus, errorThrown,"\n"));
                 $("#glMappingSaveImg").hide();
           }
      })
 }
