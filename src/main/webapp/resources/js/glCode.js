/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/***********************************************
 * Function to initialize Gl Code Properties.
 ************************************************/
function initGlProperties(){
  $(window).resize();
  accountAutoComplete('');
  initSubClassAutoComplete('');
  $("#tabs" ).tabs({
          selected:0
  });
  $(".glMappingProcessingImg").hide();
  $(".addNewSubClass").click(function(){
      appendNewSubClassRow();
  });

  $(".deleteImage").live('click',function(){

      if($(this).hasClass('existingRow')){
         $(this).parent().parent().find("input[name=subClass]").attr("checked", "checked");
         $(this).parent().parent().hide();
      }
      else{
           $(this).parent().parent().remove();
      }
  });

  $("#glCodeContainer").hide();
  $("#subClassContainer").hide();
}

/**************************************************
 * Function to initialize Account Code Autocomplete.
 **************************************************/
function accountAutoComplete(counter){


    var currentElementId='';

    $('.accountCode').autocomplete({

        cache:false,
        delay:1000,
        source: function(request, response) {

            currentElementId=$(this.element).attr("id");
            if(currentElementId!="editGlCode" || currentElementId!="glGlCode" ||currentElementId!="subSubGlCode"){
                $("#hdnTxtAccount_"+counter).val('');
            }
            if(currentElementId=="glGlCode"){
                 $("#glGlDesc").text("");
                 $("#glAccountGroup").text("");
                 $("#hdnglGlCodeId").val("");
                 $("#hdnglGlCode").val("");
            }
            var date = new Date();
            var url="ClientBillingReviewAjax?refresh="+ date.getMilliseconds();
            $.getJSON(url,{
                        type: "post",
                        contentType: "application/json",
                        format: "json",
                        q: request.term,
                        reqType:'GetAccountCode'
                    },
                    function(data) {

                    response($.map(data, function(item, index) {

                    if(currentElementId=="editGlCode" || currentElementId=="glGlCode" ||currentElementId=="subSubGlCode"){
                       return {
                            value: item.glCode,
                            idnum: item.glCode,
                            glCodeId:item.glCodeID,
                            description:item.description,
                            groupId:item.accountGroupID,
                            active:item.activeYN,
                            guiCode:item.accountGrpGuiCode
                          }
                       }
                    else{
                       return {
                            value: item.guiCode,
                            idnum: item.glCode,
                            glCodeId:item.glCodeID,
                            description:item.description,
                            groupId:item.accountGroupID,
                            active:item.activeYN
                          }
                       }
                    }))
            });
            $.ajaxSetup({
                "error":function(xhr, textStatus, thrownError) {
                        alert(getAjaxErrorMessage("Failed to Fetch GL Code data.",xhr, textStatus, thrownError,"\n"));
                }
            });
        },
        minLength: 3,
        select: function(event, ui) {
            
            if(currentElementId=="editGlCode"){
                $("#glCodeDesc").val(ui.item.description);
                $("#grpCodeId").val(ui.item.groupId);
                $("#activeYN").val(ui.item.active);
                $("#hdnEditGlCodeId").val(ui.item.glCodeId);
                $("#hdnGlCode").val(ui.item.idnum);
            }
            else if(currentElementId=="glGlCode"){
                 $("#glGlDesc").text(ui.item.description);
                 $("#glAccountGroup").text(ui.item.guiCode);
                 $("#hdnglGlCodeId").val(ui.item.glCodeId);
                 $("#hdnglGlCode").val(ui.item.value);

            }
            else if(currentElementId=="subSubGlCode"){
                $("#subSubGlCode").val(ui.item.idnum);
                $("#subSubAccGrpId").text(ui.item.guiCode);
                $("#subSubGlDesc").text(ui.item.description);
                $("#hdnSubClassGlCodeId").val(ui.item.glCodeId);
                $("#hdnSubClassGlCode").val(ui.item.idnum);

            }

            else{
                $("#hdnTxtAccount_"+counter).val(ui.item.idnum);
            }
        },
        open: function() {
            $(this).removeClass("ui-corner-all").addClass("ui-corner-top");
        },
        close: function() {
            $(this).removeClass("ui-corner-top").addClass("ui-corner-all");
        }
    });

    $('.accountGrpCode').autocomplete({

        cache:false,
        source: function(request, response) {

            var date = new Date();
            var url="ClientBillingReviewAjax?refresh="+ date.getMilliseconds();
            $.getJSON(url,{
                        type: "post",
                        contentType: "application/json",
                        format: "json",
                        q: request.term,
                        reqType:'GetAccountGroupCode'
                    },
                    function(data) {

                    response($.map(data, function(item, index) {
                        return {
                            idnum: item.accountGrpID,
                            value: item.accountGrp,
                            description:item.description
                        }
                    }))
            });
            $.ajaxSetup({
                "error":function(xhr, textStatus, thrownError) {
                        alert(getAjaxErrorMessage("Failed to fetch Account Group Code data.",xhr, textStatus, thrownError,"\n"));
                }
            });
        },
        minLength: 2,
        select: function(event, ui) {
            $("#hdnAccountGrpId").val(ui.item.idnum);
            $("#accountCodeDesc").val(ui.item.description);
            $("#hdnAccountGrpCode").val(ui.item.value);
        },
        open: function() {
            $(this).removeClass("ui-corner-all").addClass("ui-corner-top");
        },
        close: function() {
            $(this).removeClass("ui-corner-top").addClass("ui-corner-all");
        }
    });
}
/****************************************************
 * Function to initialize Sub Sub Class Autocomplete.
 ****************************************************/
function initSubClassAutoComplete(counter){

var markupClass=$.trim("subSubClass"+counter);
var currentElementId;

$("."+markupClass).autocomplete({

     cache:false,
     source: function(request, response) {

          currentElementId='';
          currentElementId=$(this.element).attr("id");

         if(currentElementId!="subSubClass"){
             $("#"+currentElementId).parent().parent().find(".subClass"+counter).attr("problemclassid","");
             $("#"+currentElementId).parent().find("label").text("");
         }
         else{
                    $("#hdnProblemClassID").val("");
                    $("#hdnSubSubClass").val("");
                    $("#subClassLabel").text("");
                    $("#classLabel").text("");

                    $("#subSubGlCode").val("");
                    $("#subSubAccGrpId").text("");
                    $("#subSubGlDesc").text("");
                    $("#hdnSubClassGlCodeId").val("");
                    $("#hdnSubClassGlCode").val("");

          }
         var date = new Date();
         var url="GLMappingAjax?refresh="+ date.getMilliseconds();

         $.getJSON(url,{
                        type: "post",
                        contentType: "application/json",
                        format: "json",
                        q: request.term,
                        clientID:$("#clientID").val(),
                        reqType:'GetSubSubclasses'
                    },
                    function(data) {

                    response($.map(data, function(item, index) {
                        return {
                            idnum: item.problemClassID,
                            value: item.problemClass+' | '+item.problemSubClass +' | '+item.problemSubSubClass,
                            description:item.description,
                            problemSubSubClass:item.problemSubSubClass,
                            problemSubClass:item.problemSubClass,
                            problemClass:item.problemClass
                        }
                    }))
            });
            $.ajaxSetup({
                "error":function(xhr, textStatus, thrownError) {
                        alert(getAjaxErrorMessage("Failed to fetch sub sub class.",xhr, textStatus, thrownError,"\n"));
                }
            });

        },
        minLength: 2,
        select: function(event, ui) {

                if(currentElementId!="subSubClass"){

                 $("#"+currentElementId).parent().parent().find(".subClass"+counter).attr("problemclassid",ui.item.idnum);
                 $("#"+currentElementId).parent().find("label:eq(0)").text(ui.item.problemClass);
                 $("#"+currentElementId).parent().find("label:last").text(ui.item.problemSubClass);
                 $("#"+currentElementId).parent().find("input:last").val(ui.item.value);

               }
               else{
                    $("#hdnProblemClassID").val(ui.item.idnum);
                    $("#hdnSubSubClass").val(ui.item.problemSubSubClass);
                    $("#subClassLabel").text(ui.item.problemSubClass);
                    $("#classLabel").text(ui.item.problemClass);
                    searchSubOrGL('subSubClass');
               }
        },
        open: function() {
            $(this).removeClass("ui-corner-all").addClass("ui-corner-top");
        },
        close: function() {
            $(this).removeClass("ui-corner-top").addClass("ui-corner-all");
        }

   });
}

/**************************************************
 * Function to Reset Create/Edit Account Group Code.
 **************************************************/
function resetAccGroup(mode){
  if(mode=='add'){
      $("#createAccountGrpCode").val("");
      $("#createAccountCodeDesc").val("");
  }
 else{
      $("#accountGrpCode").val("");
      $("#accountCodeDesc").val("");
      $("#hdnAccountGrpId").val("");
   }
}

/**********************************
 * Function to Create/Edit GL Code.
 **********************************/
function saveGLCode(mode){
    var glCodeObj='';
    if(mode=='add'){
       glCodeObj=getGLCodeObj(mode);
    }
    else {
      glCodeObj=getGLCodeObj(mode);
    }
    $("#glMappingSaveImg").show();
    var date=new Date();
    var url="GLMappingAjax?&refresh="+date.getMilliseconds();
    $.ajax({
        type:"POST",
        url: url,
        dataType:"json",
        data:{
            glCodeDO:JSON.stringify(glCodeObj),
            reqType:"saveGLCode"
        },
        success:function(data){
             if(data.errorMessage==null && data.spDataId!=null){

                if(mode=='add'){
                       alert("GL Code has been created successfully.");
                  } else{
                        alert("GL Code has been updated successfully.");
                 }
            }
            else{
                 alert(data.errorMessage);
            }
           $("#glMappingSaveImg").hide();
        },
        error:function(jqXHR, textStatus, errorThrown){
              alert(getAjaxErrorMessage("Failed to save GL Code data.",jqXHR, textStatus, errorThrown,"\n"));
              $("#glMappingSaveImg").hide();
        }
    })
}
/***************************************************
 * Function to initialize Create/Edit GL Code object.
 ***************************************************/
function getGLCodeObj(mode){

     var glCodeObj=new GLCode();

     if(mode=='add'){
         glCodeObj.glCode=$.trim($("#createGlCode").val());
         glCodeObj.description=$.trim($("#createGlDesc").val());
         glCodeObj.accountGroupID=parseInt($.trim($("#createAccGrpId").val()));
         glCodeObj.activeYN=$.trim($("#createActiveYN").val());
         glCodeObj.updatedUserID=parseInt($.trim($("#updatedUserId").val()));
     }
     else{
         glCodeObj.glCode=$.trim($("#editGlCode").val());
         glCodeObj.glCodeID=parseInt($.trim($("#hdnEditGlCodeId").val()));
         glCodeObj.description=$.trim($("#glCodeDesc").val());
         glCodeObj.accountGroupID=parseInt($.trim($("#grpCodeId").val()));
         glCodeObj.activeYN=$.trim($("#activeYN").val());
         glCodeObj.updatedUserID=parseInt($.trim($("#updatedUserId").val()));
     }

     return glCodeObj;
}

/********************************************************
 * Constructor declaration for Create/Edit GL Code object.
 ********************************************************/
function GLCode(){
    var self = this;
    self.glCode=null;
    self.glCodeID=null;
    self.description=null;
    self.accountGroupID=null;
    self.activeYN=null;
    self.updatedUserID=null;
}
/*******************************
 * Function to validate GL Save.
 *******************************/
function validateGLCodeSave(mode){

    var errorCount=0;
    var glCode='';
    var glDesc='';
    var activeYN='';
    var msgStr='';
    var accountGroup='';

   if(mode=='add'){
        glCode=$.trim($("#createGlCode").val());
        glDesc=$.trim($("#createGlDesc").val());
        activeYN=$.trim($("#createActiveYN").val());
        accountGroup=$.trim($("#createAccGrpId").val());
        msgStr="Please enter/select ";

    if(glCode.length==0){
        msgStr+="GL Code";
        errorCount++;
    }
    if(glDesc.length==0){
      if(errorCount==1){
          errorCount++;
          msgStr+=", GL Code Description";
        }
      else{
          msgStr+="GL Code Description";
          errorCount++;
          }
    }
    if(accountGroup==0){
       if(errorCount==2 ||errorCount==1){
           errorCount++;
          msgStr+=", Account Group";
        }
        else{
            errorCount++;
            msgStr+="Account Group";
          }
       }
    if(activeYN.length==0){
        if(errorCount==3 || errorCount==2 ||errorCount==1){
          errorCount++;
          msgStr+=", Active Status";
        }
        else{
            errorCount++;
            msgStr+="Active Status";

         }
       }
   }
   else{
          glCode=$.trim($("#hdnGlCode").val());
          var glCodeFieldValue=$.trim($("#editGlCode").val());
          glDesc=$.trim($("#glCodeDesc").val());
          activeYN=$.trim($("#activeYN").val());
          accountGroup=$.trim($("#grpCodeId").val());
          msgStr="Please enter/select a valid ";

    if(glCode!=glCodeFieldValue || glCode.length==0){
        msgStr+="GL Code";
        errorCount++;
    }
    if(glDesc.length==0){
      if(errorCount==1){
          errorCount++;
          msgStr+=", GL Code Description";
        }
      else{
          errorCount++;
          msgStr+="GL Code Description";
          }
    }
    if(accountGroup==0){
       if(errorCount==2 ||errorCount==1){
          errorCount++;
          msgStr+=", Account Group";
        }
        else{
            errorCount++;
            msgStr+="Account Group";
          }
       }
    if(activeYN.length==0){
        if(errorCount==3 ||errorCount==2 ||errorCount==1){
          errorCount++;
          msgStr+=", Active Status";
        }
        else{
            errorCount++;
            msgStr+="Active Status";
        }
      }
   }
    if(errorCount>0)
        alert(msgStr+".");
    else saveGLCode(mode);
}

/******************************************************************
 * Function to manage Sub Sub class and GL Code display in last tab.
 ******************************************************************/
function manageSubClass(){

    var manageSubClassVal=$("#manageSB").val();


    if(manageSubClassVal.length>0){

        manageDisplay(manageSubClassVal)

    }
    else{
        $("#glCodeContainer").hide();
        $("#subClassContainer").hide();
        resetGlMapping();
    }

}

/**********************************************************************
 * Function to validate Sub Sub class and GL Code display in last tab.
 **********************************************************************/
function manageDisplay(displayVal){

    var errorCount=0;
    var errorMsg='';
    var clientID=$("#clientID").val();
    var locType=$("input[name=locType]:checked").val();

        errorMsg+='Please select a '
        if(clientID.length==0){
            errorMsg+='Client';
            errorCount++;
        }
        if(locType==undefined||locType.length==0){
            if(errorCount==1){
              errorMsg+=', Location Type';
              errorCount++;
            }
            else{
                errorMsg+='Location Type';
                errorCount++;
            }
        }


     if(errorCount>0){

           $("#manageSB").val("")
           alert(errorMsg+".");
         }
      else{
           if(displayVal==1){
              $("#glCodeContainer").hide();
              $("#subClassContainer").show();
           }
           else{
               $("#subClassContainer").hide();
               $("#glCodeContainer").show();
           }
       }
}

/******************************************
 * Function to validate Account Group Save.
 ******************************************/
function validateAccountGroupSave(mode){
    var errorCount=0;
    var accountGrpCode='';
    var accountGrpDesc='';
    var msgStr='';

    if(mode=='add'){
           accountGrpCode=$.trim($("#createAccountGrpCode").val());
           accountGrpDesc=$.trim($("#createAccountCodeDesc").val());
           msgStr='Please enter '

           if(accountGrpCode.length==0){
              errorCount++;
              msgStr+='Account Group Code';
           }
           if(accountGrpDesc.length==0){
               if(errorCount==1){
                   msgStr+=', Account Group Description';
               }
               else{
                  msgStr+='Account Group Description';
               }
              errorCount++;
           }
    }
    else{
          accountGrpCode=$.trim($("#hdnAccountGrpCode").val());
          var accountGroup=$.trim($("#accountGrpCode").val());
          accountGrpDesc=$.trim($("#accountCodeDesc").val());
          msgStr='Please enter/select a valid '
           if(accountGrpCode!=accountGroup || accountGroup.length==0){
              errorCount++;
              msgStr+='Account Group Code';
           }
           if(accountGrpDesc.length==0){
               if(errorCount==1){
                   msgStr+=', Account Group Description';
               }
               else{
                  msgStr+='Account Group Description';
               }
              errorCount++;
           }
    }

    if(errorCount>0)
        alert(msgStr+".");
    else saveAccountGroupCode(mode);
}

/*************************************
 * Function to save Account Group Save.
 *************************************/
function saveAccountGroupCode(mode){
    var accGrpObj='';
    if(mode=='add'){
       accGrpObj=getAccountGroupObj(mode);
    }
    else {
      accGrpObj=getAccountGroupObj();
    }
    $("#glMappingSaveImg").show();
    var date=new Date();
    var url="GLMappingAjax?&refresh="+date.getMilliseconds();
    $.ajax({
        type:"POST",
        url: url,
        dataType:"json",
        data:{
            accountGroupDO:JSON.stringify(accGrpObj),
            reqType:"saveAccountGroup"
        },
        success:function(data){
                if(data.errorMessage==null && data.spDataId!=null){
                if(mode=='add'){
                    alert("Account Group Code has been created successfully.")
                  } else{
                      alert("Account Group Code has been updated successfully.")
                 }
                 refreshAccountGroupId();
            }
            else{
                 alert(data.errorMessage);
            }
            $("#glMappingSaveImg").hide();
        },
        error:function(jqXHR, textStatus, errorThrown){
              alert(getAjaxErrorMessage("Failed to save Account Group Code data.",jqXHR, textStatus, errorThrown,"\n"));
              $("#glMappingSaveImg").hide();
         }
    });
}

/***************************************************
 * Function to initialize Account Group Save Object.
 ****************************************************/
function getAccountGroupObj(mode){

    var accGrpObj=new AccountGroup();
    if(mode=='add'){
        accGrpObj.accountGrp=$.trim($("#createAccountGrpCode").val());
        accGrpObj.description=$.trim($("#createAccountCodeDesc").val());
        accGrpObj.updatedUserId=Number($.trim($("#updatedUserId").val()));
    }
    else{
        accGrpObj.accountGrp=$.trim($("#accountGrpCode").val());
        accGrpObj.description=$.trim($("#accountCodeDesc").val());
        accGrpObj.accountGrpID=Number($.trim($("#hdnAccountGrpId").val()));
        accGrpObj.updatedUserId=Number($.trim($("#updatedUserId").val()));
    }

    return accGrpObj;
}
/***************************************************
 * Constructor for Account Group Save Object.
 ****************************************************/
function AccountGroup(){
    var self=this;
    self.accountGrp=null;
    self.description=null;
    self.accountGrpID=null;
    self.updatedUserId=null;
}
/***************************************************
 * Function to reset Map GL Code to Sub Sub Class tab.
 ****************************************************/
function resetSubClass(){

    $("#manageSB").val("");
    $("input[name=locType]").removeAttr("checked");

    $("#subSubClass").val("");
    $("#subSubGlCode").val("");
    $("#subSubGlDesc").text("");
    $("#subSubAccGrpId").text("");
    $("#hdnSubClassGlCodeId").val();

    $("#subClassLabel").text("");
    $("#classLabel").text("");

    $("#glGlDesc").text("");
    $("#glAccountGroup").text("");
    $("#hdnglGlCodeId").val("");
    $("#glGlCode").val("");

    $("#glCodeContainer").hide();
    $("#subClassContainer").hide();

    $("#glSearchTableTbody").html("");


}
/***************************************************
 * Function to reset Create/Edit GL Code Tab.
 ****************************************************/
function resetGl(mode){
   if(mode=='add'){
      $("#createGlCode").val("");
      $("#createGlDesc").val("");
      $("#createAccGrpId").val("");
      $("#createActiveYN").val("");
   }
   else{
      $("#editGlCode").val("");
      $("#glCodeDesc").val("");
      $("#grpCodeId").val("");
      $("#activeYN").val("");
      $("#hdnEditGlCodeId").val("");
      $("#hdnGlCode").val("");
   }
}

/*************************************************************
 * Wrapper Function to reset Map GL Code to Sub Sub Class tab.
 *************************************************************/
function resetGlMapping(){
        $("#clientID").val("");
         resetSubClass();
}
/*********************************************************************
 * Function to perform seacrh operation of GL Code or Sub Class entity.
 *********************************************************************/
function searchSubOrGL(serachType){

        var subOrGLObj=new SubClassOrGLProcess();
        var hdnGlCode='';
        var glCode='';
        var errorCount=0;
        
        subOrGLObj.clientPartyID=Number($.trim($("#clientID").val()));
        subOrGLObj.locationType=$.trim($("input[name=locType]:checked").val());

        if(serachType=='subSubClass'){
            
             subOrGLObj.problemSubSubClass=$.trim($("#hdnSubSubClass").val());
             subOrGLObj.problemClassID=Number($.trim($("#hdnProblemClassID").val()));
            }
        else{
              hdnGlCode=$.trim($("#hdnglGlCode").val());
              glCode=$.trim($("#glGlCode").val());
              if(hdnGlCode!=glCode || glCode.length==0){
                errorCount++;
                alert("Please enter a valid GL Code.");
              }
              subOrGLObj.glCodeID=Number($.trim($("#hdnglGlCodeId").val()));
        }
           
       if(errorCount==0){
         var date=new Date();
         $("#glMappingSearchImg").show();
         var url="GLMappingAjax?&refresh="+date.getMilliseconds();
         $.ajax({
               type:"POST",
               url: url,
               dataType:"json",
               data:{
                     subOrGLDO:JSON.stringify(subOrGLObj),
                     reqType:"GetGLCodeAndPUCByClient"
                    },
            success:function(data){
                      if(data!=null && data.length>0){

                          if(serachType=='subSubClass'){
                               $("#subSubGlCode").val(data[0].glCode);
                               $("#subSubAccGrpId").text(data[0].accountGrpGuiCode);
                               $("#subSubGlDesc").text(data[0].description);
                               $("#hdnSubClassGlCodeId").val(data[0].glCodeID);
                               $("#hdnSubClassGlCode").val(data[0].glCode);
                              }
                            else{
                               renderSubSubClass(data);
                              }
                       }
                      else{
                           alert("GL Code mapping not found.");
                           if(serachType!='subSubClass')
                               $("#glSearchTableTbody").html("");
                       }
                       $("#glMappingSearchImg").hide();

                 },
            error:function(jqXHR, textStatus, errorThrown){
                 alert(getAjaxErrorMessage("Failed to Fetch GL Code data.",jqXHR, textStatus, errorThrown,"\n"));
                 $("#glMappingSearchImg").hide();
           }
      })
     }
  }
/***************************************************
 * Constructor for Sub Sub Class or GL Code objcet.
 ***************************************************/
  function SubClassOrGLProcess(){
      var self=this;
      self.clientPartyID=null;
      self.glCodeID=null;
      self.problemSubSubClass=null;
      self.locationType=null;
      self.problemClassID=null;
      self.updatedUserID=null;
  }
/***************************************************
 * Constructor for GL Code save objcet.
 ***************************************************/
  function GLSaveProcess(){
      var self=this;
      self.clientPartyID=null;
      self.glCodeID=null;
      self.problemSubSubClass=null;
      self.locationType=null;
      self.updatedUserID=null;
      self.glList=[];
  }

/**************************************************************************
 * Constructor for Sub Sub Class save object in GL Code section of last Tab.
 ***************************************************************************/
function GLSubClassSaveProcess(){

      var self=this;
      self.problemClassID=null;
      self.addDeleteFlag=null;
}
/*********************************************************************
 * Function to render Sub Sub Class mapped data with specific GL Code.
 *********************************************************************/
  function renderSubSubClass(data){
     var strSubClassArr=[];
     var o=-1;
     var counter=0;
     if(data!=null || data!=undefined){
      for(var i=0;i<data.length;i++){
       counter=i+0;
       strSubClassArr[++o]="<tr class='defaultRow'>"
       strSubClassArr[++o]="<td class='tabledatarows' width='10%'><input type='checkbox' name='subClass' class='subClass"+counter+" hiddenGlChkbx' value='d' problemclassid='"+data[i].problemClassID+"'/></td>";
       strSubClassArr[++o]="<td class='tabledatarows' width='*'>";
       strSubClassArr[++o]="<div class='classtext'><span class='boldText'>Class &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span><label>"+data[i].problemClass+"</label></div>";
       strSubClassArr[++o]="<div class='subClasstext'><span class='boldText'>Sub Class &nbsp;</span><label>"+data[i].problemSubClass+"</label></div>";
       strSubClassArr[++o]="&nbsp;<label class='subClassText'>&nbsp;"+data[i].problemSubSubClass+"</label>";
       strSubClassArr[++o]="</td>";
       strSubClassArr[++o]="<td class='tabledatarows' width='7%'><img title='Delete Row' alt='Delete' class='deleteImage existingRow' src='graphics/delete.gif'/></td>"
       strSubClassArr[++o]="</tr>";
     }
    }
     $("#glSearchTableTbody").html(strSubClassArr.join(''));
  }
/*********************************************************************************
 * Function to validate save one to one mapping of Sub Sub Class with GL Code.
 *********************************************************************************/
  function validateSubClassSave(){

    var errorCount=0;
    var errorMsg='Please enter/select a valid ';
    var problemClassId=$.trim($("#hdnProblemClassID").val());
    var hdnGlCode=$.trim($("#hdnSubClassGlCode").val());
    var glCode=$.trim($("#subSubGlCode").val());

    if(problemClassId.length==0){
       errorCount++;
       errorMsg+='Sub Sub Class'
    }
    if(hdnGlCode!=glCode || glCode.length==0){
        if(errorCount==1){
          errorCount++;
          errorMsg+=', GL Code'
        }
        else{
          errorCount++;
          errorMsg+='GL Code'
        }
    }

    if(errorCount>0){
        alert(errorMsg+'.');
    }
    else
        {
           var subClassObj=new SubClassOrGLProcess();
           subClassObj.clientPartyID=Number($.trim($("#clientID").val()));
           subClassObj.glCodeID=Number($.trim($("#hdnSubClassGlCodeId").val()));
           subClassObj.locationType=$.trim($("input[name=locType]:checked").val());
           subClassObj.problemClassID=Number($.trim($("#hdnProblemClassID").val()));
           subClassObj.updatedUserID=Number($.trim($("#updatedUserId").val()));

           saveSubClassData(subClassObj,'subClass');
        }
 }
/*********************************************************************************
 * Function to save one to one mapping of Sub Sub Class with GL Code.
 *********************************************************************************/
 function saveSubClassData(subClassObj,saveType){

     var date=new Date();
     $("#glMappingSaveImg").show();
      var url="GLMappingAjax?refresh="+ date.getMilliseconds();
      $.ajax({
              type:"POST",
               url: url,
               dataType:"json",
               data:{
                     subClassOrGLDO:JSON.stringify(subClassObj),
                     reqType:saveType
                    },
            success:function(data){

                      if(data.errorMessage==null && data.spDataId!=null){
                        alert("The Sub Sub Class data has been saved successfully.");
                       }
                      else{
                           alert(data.errorMessage);
                       }
                       $("#glMappingSaveImg").hide();
                 },
            error:function(jqXHR, textStatus, errorThrown){
                 alert(getAjaxErrorMessage("Failed to save Sub Class data.",jqXHR, textStatus, errorThrown,"\n"));
                 $("#glMappingSaveImg").hide();
           }
      })
 }
 /***************************************************************************
 * Function to validate save one to many mapping of GL Code with Sub Sub Class.
 ****************************************************************************/
function validateGLSave(){

    var hdnGlCode=$.trim($("#hdnglGlCode").val());
    var glCode=$.trim($("#glGlCode").val());
    var errorCount=0;
    var eCount=0;

    if(hdnGlCode!=glCode || glCode.length==0){
       errorCount++;
       alert("Please enter a valid GL Code.");
    }
    else if($("#glSearchTableTbody").find("input[@name=subClass]:checked").size()==0){
       errorCount++;
       alert("Please select atleast one Sub Sub Class to save the data.");
    }
    if(errorCount==0){
        var glObj=new GLSaveProcess();
        var glArray=new Array();

          glObj.clientPartyID=Number($.trim($("#clientID").val()));
          glObj.glCodeID=Number($.trim($("#hdnglGlCodeId").val()));
          glObj.glCode=$.trim($("#hdnglGlCode").val());
          glObj.locationType=$.trim($("input[name=locType]:checked").val());
          glObj.updatedUserID=Number($.trim($("#updatedUserId").val()));


        $("#glSearchTableTbody").find("input[@name=subClass]:checked").each(function(index) {

             var subClass=new GLSubClassSaveProcess();
             var textValue='';
             var problemClassId=$.trim($(this).attr("problemClassId"));
             var hdnTextValue='';
             var subSubClassText='';
             
             if($(this).hasClass("hiddenGlChkbx")){
                subSubClassText=$(this).parent().parent().find("label.subClassText").text()
              }
             else{
                 
                  textValue=$.trim($(this).parent().parent().find("input:text").val());
                  hdnTextValue=$.trim($(this).parent().parent().find("input:hidden").val());
                  
                  subSubClassText=textValue.split(' | ')[2];

                  if(hdnTextValue!=textValue || textValue.length==0 || problemClassId.length==0){
                      eCount++;
                      alert("Please select a valid Sub Sub Class.");
                  }
             }
             
             subClass.problemClassID=Number($(this).attr("problemclassid"));
             subClass.addDeleteFlag=$.trim($(this).val());
             subClass.problemSubSubClass=$.trim(subSubClassText);
             glArray.push(subClass);
        });
       if(glArray.length>0 && eCount==0){

         saveGLData(glObj,glArray,'gl');
       }
     }
   }
/***************************************************************************
 * Function to perform save one to many mapping of GL Code with Sub Sub Class.
 ****************************************************************************/
 function saveGLData(GLObj,glArray,saveType){

      var date=new Date();
//      alert(JSON.stringify(glArray))
      $("#glMappingSaveImg").show();
      var url="GLMappingAjax?refresh="+ date.getMilliseconds();
      $.ajax({
              type:"POST",
               url: url,
               dataType:"json",
               data:{
                     GLDO:JSON.stringify(GLObj),
                     glObjList:JSON.stringify(glArray),
                     reqType:saveType
                    },
            success:function(data){

                      if(data.errorMessage==null && data.spDataId!=null){
                         searchSubOrGL('gl');
                         alert("The GL data has been saved successfully.");
                       }
                      else{
                           alert(data.errorMessage);
                       }
                       $("#glMappingSaveImg").hide();
                 },
            error:function(jqXHR, textStatus, errorThrown){
                 alert(getAjaxErrorMessage("Failed to save GL Code data.",jqXHR, textStatus, errorThrown,"\n"));
                 $("#glMappingSaveImg").hide();
            }
      })

 }
/***************************************************************************
 * Function to generate new row of Sub Sub Class for one to many mapping of
 * GL Code with Sub Sub Class.
 ****************************************************************************/
 function appendNewSubClassRow(){

     var strSubClassArr=[];
     var o=-1;
     var counter=0;
     counter=$("#glSearchTableTbody tr").size()+1;
       strSubClassArr[++o]="<tr class='newRow'>"
       strSubClassArr[++o]="<td class='tabledatarows' width='10%'><input type='checkbox' checked name='subClass' class='subClass"+counter+"' value='i' problemclassid=''/></td>";
       strSubClassArr[++o]="<td class='tabledatarows'>";
       strSubClassArr[++o]="<div class='classtext'><span class='boldText'>Class &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span><label id='addedClassLabel"+counter+"'></label></div>";
       strSubClassArr[++o]="<div class='subClasstext'><span class='boldText'>Sub Class &nbsp;</span><label id='addedSubClassLabel"+counter+"'></label></div>";
       strSubClassArr[++o]="<input type='text' id='subSubClass"+counter+"' class='subSubClass"+counter+" leftPadding' value='' size='72' maxlength='190' />";
       strSubClassArr[++o]="<input type='hidden' value=''/>";
       strSubClassArr[++o]="</td>";
       strSubClassArr[++o]="<td class='tabledatarows' width='7%'><img title='Delete Row' alt='Delete' class='deleteImage' src='graphics/delete.gif'/></td>"
       strSubClassArr[++o]="</tr>";

       $("#glSearchTableTbody").append(strSubClassArr.join(''));
       initSubClassAutoComplete(counter);
 }

/***************************************************************************
 * Function to fetch and Refresh the Account Group Id on Creating/Editing
 * Account Group ID.
 ****************************************************************************/
 function refreshAccountGroupId(){
     var date =new Date();
     var url="GLMappingAjax?refresh="+ date.getMilliseconds();
     $.ajax({
        type:"POST",
               url: url,
               dataType:"json",
               data:{
                     reqType:'fetchAccountGroup'
                    },
        success:function(data){
                if(data!=null ||data!=undefined){
                     var optionStr = "<option value='' selected>-- Select --</option>";
                     $.each(data,function(data){
                        optionStr+="<option value='"+this.accountGrpID+"'>"+this.guiCode+"</option>";
                     });
                     $("select.accountGroup").html(optionStr);
                     $("#glMappingSaveImg").hide();
                }
          },
        error:function(jqXHR, textStatus, errorThrown){
                 alert(getAjaxErrorMessage("Failed to refresh Account Group ID.",jqXHR, textStatus, errorThrown,"\n"));
                 $("#glMappingSaveImg").hide();
        }
     })
 }
 function glCodeStaticComplete(counter){
      var data=eval($('#glCodeStore').val());
     var finalData =$.map(data, function(item) {
  	  return {
 	    	   label:item.guiCode,
 	    	   value:item.guiCode,
                   idnum: item.glCode
 	    	
                   }

      });
$(".accountCode").autocomplete({
        source: finalData,
        width: 300,
        max: 20,
        delay: 100,
        minLength: 1,
        autoFocus: true,
        cacheLength: 1,
        scroll: true,
        highlight: false,
        select: function(event, ui) {
          $("#hdnTxtAccount_"+counter).val(ui.item.idnum);
         }
    });
 }