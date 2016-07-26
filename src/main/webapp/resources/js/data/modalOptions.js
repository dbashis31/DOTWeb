/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


function Options(){
    var self = this;
       self.fmmodal=null;
       self.scope=null;
       self.modal=true;
       self.controller=null,
       self.url="";
       self.width="420";
       self.position='center',
       self.resizable=false;
       self.closeOnEscape=false;
       self.closeOnClicking=false;
       self.closeOnClickingBtn=true;
       self.popupHeader="Information";
       self.message="";
       self.buttonName="Ok";
       self.confirmBtnYes="Yes";
       self.confirmBtnNo="No";
       self.htmlContainerID="";
       self.isremove=true;
       self.onOpenCallService=null,
       self.servicetoServe=null
}
