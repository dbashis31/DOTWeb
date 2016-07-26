angular.module('fm.services', []).factory('fmjquimodal', [
    function (){
        return function FMjquimodal(popupId,options){
             $("#"+popupId).dialog({
                        width: options.width,
                        modal: options.modal,
                        position:options.position,
                        resizable:options.resizable,
                        closeOnEscape:options.closeOnEscape,
                        open: function(event) {
                            //append the dialog to form for check spelling to work
                            $("#"+popupId).parent().appendTo($('form:first'));
                            if(options.topLocation!=null && options.topLocation!="" && options.topLocation!=undefined)
                            $("#"+popupId).parent().css("top", options.topLocation);
                            if(options.htmlContainerID!=undefined && options.htmlContainerID!="" && options.htmlContainerID!=null){
                                 $("#"+options.htmlContainerID).html(options.message);
                             }
                             if(options.extraHtmlContainerID!=undefined && options.extraHtmlContainerID!="" && options.extraHtmlContainerID!=null){
                                 $("#"+options.extraHtmlContainerID).html(options.extraMessage);
                             }

                            if(options.closeOnClickingBtn){
                                $("a.closePopup", "#"+popupId).focus();
                                $("a.closePopup", "#"+popupId).click(function(e){
                                    e.preventDefault();
                                    $("#"+popupId).dialog("destroy");
                                    if(options.isremove){
                                       $("#"+popupId).remove();
                                    }
                                    return false;
                                });
                                //if focus did nto worked then do it here--IE8 fix
                                if($(document.activeElement).attr("class")==undefined){
                                    $("a.closePopup", "#"+popupId).focus();
                                }
                            } 
                            if(options.closeOnClicking){
                                $("div.ui-widget-overlay").one("click", function(){
                                    $("#"+popupId).dialog("destroy");
                                    if(options.isremove){
                                       $("#"+popupId).remove();
                                    }
                                    return false;
                                });
                            }
                            //call the service for the pop up on opening the poup
                           if(options.onOpenCallService!=null){
                                options.onOpenCallService(options);
                            }
                        },
                        close: function(event,ui){
                            if(options.isremove){
                                $("#"+popupId).remove();
                            }
                        }
                    });
        }
    }])
.factory('fmmodal', ["$document", "$compile", "$controller","$templateCache", "$http","fmjquimodal",
    function ($document, $compile, $controller,$templateCache,$http,fmjquimodal) {
        var body = $document.find("body");
        return function Modal(templateUrl, popupId,options) {
             if(angular.isString(templateUrl)){
                $http.get(templateUrl,{cache:$templateCache})
                 .success( function( data ) {
                    if(!angular.isObject(options.scope)) {
                        options.scope = scope.$new();
                    }
                    templateScope = options.scope;
                    if(!angular.isObject(options.controller)){
                        options.controller = $controller(options.controllerName, {
                            $scope: templateScope
                        })
                    }
                    var ctrl = options.controller;
                    var modal = angular.element(data);
                    modal.children().data('$ngControllerController', ctrl);
                    $compile(modal.contents())( templateScope );
                    body.append(modal);
                    popupId = modal.attr('id');
                    options.isremove = true;
                    fmjquimodal(popupId,options);
                });
            }
            else if(angular.isString(popupId)){
                fmjquimodal(popupId,options);
            }
        };
    }]).factory('fmmodalclose',function(){
      return function(options){
          $("#"+options.popupId).dialog("destroy");
          if(options.isremove){
             $("#"+options.popupId).remove();
          }
          
      }
    }).factory('fmmodalopen',function(){
      return function(options){
            options.scope.popupHeader=options.popupHeader;
            options.scope.buttonName=options.buttonName;            
            options.scope.confirmBtnYes=options.confirmBtnYes;
            options.scope.confirmBtnNo=options.confirmBtnNo;
            options.fmmodal(options.url,null,options);
      }
    }).factory('onmodalopen',["$window","fmjquimodal",
    function($window){
      return function(options){
             if(options.servicetoServe==1){
                var w = angular.element($window);
                var newHeight=w.height();
                $("div.previewSurveyContent").css({"max-height":newHeight-115+"px"});
                $("div.previewContentDiv").css({
                                "max-height":newHeight-175+"px",
                                 overflow:"auto"
                     });
                }
          }
    }])