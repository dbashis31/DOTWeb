function getAjaxErrorMessage(contextMessage,jqXHR, textStatus, errorThrown,lineSeperator)
{
    var msg="";
    if(errorThrown!=null && errorThrown.response !=null && errorThrown.response!=undefined)
    {
        msg=errorThrown.response;
    }else{
    msg = contextMessage + lineSeperator;
    msg += 'Technical Details:'+lineSeperator;
    if (textStatus === 'parsererror') {
        msg+= 'Failed to parse the response';
    } else if (textStatus === 'timeout') {
        msg+= 'Operation timed out.';
    } else if (textStatus === 'abort') {
        msg+= 'Operation aborted.';
    }
    else{
        var responseStr = jqXHR.responseText.toUpperCase();
        if(jqXHR.status==0){
            msg+='Unable to connect to remote server.\nPlease check your Internet connection and try again.\nIf this issue persists, please contact your Internet Service Provider.';
        }else if(jqXHR.responseText=='Session has timed out.'){
            msg='Session has timed out. Please re-log in.' ;
        }
        else if(errorThrown!=null && errorThrown!='undefined'){
            msg+='[Status Code:'+ jqXHR.status +']- ' + errorThrown.description;
        }
        else if(responseStr.indexOf("<HTML>")>=0|| responseStr.indexOf("<HEAD>")>=0 || responseStr.indexOf("<BODY>")>=0)
        {
                msg+='[Status Code: '+ jqXHR.status +']- ' + jqXHR.statusText ;
        }
        else
        {
            msg+='[Status Code: '+ jqXHR.status +']- Server Exception Message:' + jqXHR.responseText ;
        }

      }
    }
    return msg;
}