/*-----------------------------------------
 * Utility Service
 *---------------------------------------*/

angular.module('fm.services.utility', []).
    factory('Utility',["$http","fmmodalopen","fmmodalclose", function($http,fmmodalopen,fmmodalclose){
        return {
                checkSpelling: function(id,formName,index){

                                 if(index!=undefined && index!=null){
                                     id= id+index;
                                 }
                                $("#xsc_fields").val();
//                                scope.$apply(function(){
                                    xsc.popup2(document.forms[formName], 0);
 //                               });
                                return false;
                             },

                 fmvalidateEmail: function(testEmail){
                                var emailReg = /^([\w-\.]+@([\w-]+\.)+[\w-]{2,4})?$/;
                                var isValid=true;
                                if( !emailReg.test(testEmail) ) {
                                        isValid=false;
                                    }
                                return isValid;
                             },

                 fmvalidatePhoneNumber: function(testPhoneNo){
                                //var noTest = /^\(?([0-9]{3})\)?[-]?([0-9]{3})[-]?([0-9]{4})$/;
                                var phoneNoArr = testPhoneNo.split("-");
                                var isValid = true;
                                if(phoneNoArr.length==3){
                                    if(isNaN(phoneNoArr[0]) || isNaN(phoneNoArr[1]) || isNaN(phoneNoArr[2])) isValid=false;
                                    else if(!isNaN(phoneNoArr[0]) && phoneNoArr[0].length!=3) isValid=false;
                                    else if(!isNaN(phoneNoArr[1]) && phoneNoArr[1].length!=3) isValid=false;
                                    else if(!isNaN(phoneNoArr[2]) && phoneNoArr[2].length!=4) isValid=false;
                                }else isValid=false;
                              
                                return isValid;
                 },

                 fmvalidateDate: function(dateValue){
                     var valid = true;
                     if(dateValue!="" ||dateValue!=null){                               
                            var rxDatePattern = /^(\d{1,2})(\/|-)(\d{1,2})(\/|-)(\d{4})$/;
                            if(rxDatePattern.test(dateValue)){ // Checks for mm/dd/yyyy format.is format OK?

                                var datearray = dateValue.split('/');

                                if(datearray.length==3){
                                    var dtMonth = datearray[0];
                                    var dtDay= datearray[1];
                                    var dtYear = datearray[2];
                                }
                                if(datearray.length!=3)
                                {
                                    valid = false;
                                }
                                else if(dtMonth<1 || dtMonth>12||dtDay>31 || dtDay<1 ||  dtYear.length>4 || ((dtMonth==4 || dtMonth==6 || dtMonth==9 || dtMonth==11) && dtDay>30)){
                                    valid = false;
                                }
                                else if (dtMonth == 2){
                                     var isleap = (dtYear % 4 == 0 && (dtYear % 100 != 0 || dtYear % 400 == 0));
                                     if (dtDay> 29 || (dtDay ==29 && !isleap))
                                       valid = false;
                                  }

                            } else {
                                valid = false;
                            }
                         }
                          return  valid;
                      }
                 ,

                 fmSetfocus: function(elementId,eventName){
                                var parentId =  $("#"+elementId).parent().attr("id");
                                if(eventName=='focus'){
                                    //set focus to specific element
                                    $("#"+elementId).focus();
                                    $("#"+elementId).focus(function () { $("#"+elementId).select2("open"); });
                                    $("#"+parentId+" a.select2-choice" ).css("border","1px solid #1E90FF");
                                }
                                //Remove focus from Select element.
                                else $("#"+parentId+" a.select2-choice" ).removeAttr("style");
                               
                             },
                fmSetfocusOnElement: function(elementId,eventName){
                                if(eventName=='focus'){
                                    //set focus to specific element
                                    $("#"+elementId).focus();                                   
                                }                                

                             },

                 fmdownload: function(downloadUrl,queryStringParams) {
                             if($('#fmdownload').length==0){
                                    $('body').append("<form id='fmdownload'></form>");
                             }
                            var url = downloadUrl + "?" + $.param(queryStringParams,true);
                            $('#fmdownload').attr('action',url);
                            $('#fmdownload').attr('method','POST');
                            $('#fmdownload').submit();
                    },

                 setScrollBarPosition: function(divID){
                     $("#"+divID).stop().animate({
                          scrollTop: $("#"+divID)[0].scrollHeight
                        }, 800);
                 },
                 getMACTValues: function(elementID){
                     var values = new Array();
                     $("#"+elementID+" option").each(function() {
                            values.push($(this).val());
                       });
                     return values.join(",");
                 },
                 /*----------------------------------------------------------------------
                  * Remove element from Multi select Autocomplete listbox on dbClick
                  *------------------------------------------------------------------*/
                 removeElement: function(elementId,scope){
                     var itemToRemove = new Array();
                     $("#"+elementId+" option").each(function(idx) {
                      if($(this).attr("selected")){
                          $(this).remove();
                        //  itemToRemove.push(scope["selectedSPList"][idx])
                      }
                    
                    });
                 },
                 fmdownloadPost: function(downloadUrl,reqType,queryStringParams,dwmldDataName) {
                    
                    if($('#fmdownload').length==0){
                        $('body').append("<form id='fmdownload'><input type='hidden' name='"+dwmldDataName+"' id='"+dwmldDataName+"'/><input type='hidden' name='m' id='m'/></form>");
                    }   
                                $('#'+dwmldDataName).val(queryStringParams);
                                $('#m').val(reqType);
                                var url = downloadUrl ;
                                $('#fmdownload').attr('action',url);
                                $('#fmdownload').attr('method','POST');
                                $('#fmdownload').submit();

                    },
                   creatingArray: function(number){
                                var populatedArray = new Array();
                                for(var i=0; i<number; i++){
                                    populatedArray.push(i+1);
                                }
                                return populatedArray;
                          },
                  //Call the autocomplete on ngChange events
                  initAutocomplete: function(elementID,labelName,valueName,minlength,hiddenFieldId,url,params,resetAutocompleteParams,onSelectFunction){
                        $("#"+elementID).autocomplete({
                source: function(request, response) {
                            //reset the required params if needed
                            if(resetAutocompleteParams!=null && resetAutocompleteParams!=undefined){
                                resetAutocompleteParams(params,hiddenFieldId);
                            }
                            $http({  url:url,
                                     method:"POST",
                                     params:params
                                 }).success(function(data) {
                                    if(data.response!=undefined && data.response!=null){
                                        data=data.response;
                                        response($.map(data, function(item) {
                                        return {
                                            value: item[labelName],
                                            idnum: item[valueName]
                                           }
                                        }));
                                       }   
                                    }
                                  
                                 ).error(function(error){
                                            
                          });                              
                },
               minLength: minlength,
                 select: function(event, ui) {
                            $("#"+hiddenFieldId).val(ui.item.idnum);
                            if(onSelectFunction!=null && onSelectFunction!=undefined){
                                onSelectFunction(params,ui);
                            }
                 }
               });
                  },
                  showProgressBar: function(scope,commonDesignPopup){
                   var url = "js/partials/progressBar.html";
                   /*-------------------------------
                    *  Display Progressbar
                    * -----------------------------*/                        
                        scope.disableButton = true;
                        commonDesignPopup.width="600";
                        commonDesignPopup.popupHeader="";
                        commonDesignPopup.url= url;
                        commonDesignPopup.onOpenCallService = null;
                        commonDesignPopup.serviceToServe = null;
                        fmmodalopen(commonDesignPopup);
                  },
                  closeProgressbar:function(scope){
                        fmmodalclose({popupId:"progressMsg",isremove:true});
                        scope.disableButton = false;
                  },
                  fmvalidateDecimalFormat: function(decimalNumber,regExpToTest){
                      //for ####.## format,pass regExpToTest=/^\d{0,4}(\.\d{0,2})?$/
                                var isValid = true;
                                if(!regExpToTest.test(decimalNumber)) {
                                        isValid=false;
                                }
                                return isValid;
                 },
                 toggleSortImage:function(sortColumnId,orderByDirection,sortColumnSelector) {
                    $(sortColumnSelector).each(function(){                        
                        if($(this).attr("id")==sortColumnId){
                            if( orderByDirection == "" || orderByDirection == "ASC"){
                                $("#"+sortColumnId).removeClass('SortImage');
                                $("#"+sortColumnId).removeClass('SortDownImage');
                                $("#"+sortColumnId).addClass('SortUpImage');
                            } else if(orderByDirection == "DESC"){
                                $("#"+sortColumnId).removeClass('SortImage');
                                $("#"+sortColumnId).removeClass('SortUpImage');
                                $("#"+sortColumnId).addClass('SortDownImage');
                            }
                        } else {
                            $(this).removeClass('SortUpImage').removeClass('SortDownImage').addClass("SortImage");
                        }
                    });
                  },
                  getHiddenValue:function(hiddenFieldId){
                     return  $("#"+hiddenFieldId).val();
                  },
                  resetHiddenValue:function(hiddenFieldId,resetVal){
                      $("#"+hiddenFieldId).val(resetVal);
                  },
                  scrollTableTo:function(scrollableElement,rowId,scrollSpeed){
                      if($("#"+rowId).offset()!=null){
                         $("."+scrollableElement).animate({ scrollTop: $("#"+rowId).offset().top - $("#"+rowId).parent().offset().top}, scrollSpeed);
                      }
                  },
                  showServerError:function(options,contextMessage,error, status, headers,config,lineSeperator){
                            if(error.response!=null && error.response!=undefined){
                                options.message=error.response;
                            }else{
                                var msg = contextMessage + lineSeperator;
                                     msg += 'Technical Details:'+lineSeperator;
                                if (status === 'parsererror') {
                                    msg+= 'Failed to parse the response';
                                } else if (status === 'timeout') {
                                    msg+= 'Operation timed out.';
                                } else if (status === 'abort') {
                                    msg+= 'Operation aborted.';
                                } else {
                                    if(error.data!= null && error.data!= undefined){
                                        var responseStr = error.data.toUpperCase();
                                        if(error.data=='Session has timed out.'){
                                            msg='Session has timed out. Please re-log in.' ;
                                        }else if(headers!=null && headers!='undefined'){
                                            msg+='[Status Code:'+ status.status +']- ' + headers.description;
                                        }else if(responseStr.indexOf("<HTML>")>=0|| responseStr.indexOf("<HEAD>")>=0 || responseStr.indexOf("<BODY>")>=0){
                                            msg+='[Status Code: '+ error.status +']- ' + error.status ;
                                        }else{
                                            msg+='[Status Code: '+ error.status +']- Server Exception Message:' + error.data ;
                                        }
                                    }
                                }
                                options.message=msg;
                            }
                            options.scope.popupHeader=options.popupHeader;
                            options.scope.buttonName=options.buttonName;
                            options.fmmodal(options.url,null,options);
                        }
                 
                // Add other utility functions here using ','
               }
     }]);
