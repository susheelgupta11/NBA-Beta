
import org.nba.application.ApplicationForm1


import org.nba.application.FormCategory

import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_NBA_layoutsapplicant_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/layouts/applicant.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(1)
createTagBody(1, {->
printHtmlPart(0)

response.setHeader("Cache-Control","private");
response.setHeader("Cache-Control","no-store");
response.setHeader("Cache-Control","no-cache"); //HTTP 1.1
response.setHeader("Pragma","no-cache"); //HTTP 1.0
response.setDateHeader ("Expires", -1);

printHtmlPart(0)

response.setHeader("Cache-control","no-store"); //HTTP 1.1 
response.setHeader("Pragma","no-cache"); //HTTP1.0 
response.setDateHeader("Expire",0); //prevents caching at the proxy server

printHtmlPart(0)
invokeTag('captureMeta','sitemesh',27,['gsp_sm_xmlClosingForEmptyTag':(""),'http-equiv':("Content-Type"),'content':("text/html; charset=UTF-8")],-1)
printHtmlPart(0)
invokeTag('captureMeta','sitemesh',28,['gsp_sm_xmlClosingForEmptyTag':(""),'http-equiv':("X-UA-Compatible"),'content':("IE=edge,chrome=1")],-1)
printHtmlPart(0)
createTagBody(2, {->
createTagBody(3, {->
invokeTag('layoutTitle','g',30,['default':("National Biodiversity Application")],-1)
})
invokeTag('captureTitle','sitemesh',30,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',30,[:],2)
printHtmlPart(0)
invokeTag('captureMeta','sitemesh',31,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("viewport"),'content':("width=device-width, initial-scale=1.0")],-1)
printHtmlPart(2)
expressionOut.print(assetPath(src: 'logo.png'))
printHtmlPart(3)
expressionOut.print(assetPath(src: 'logo.png'))
printHtmlPart(4)
expressionOut.print(assetPath(src: 'logo.png'))
printHtmlPart(5)
expressionOut.print(assetPath(src: 'logo.png'))
printHtmlPart(6)
invokeTag('captureMeta','sitemesh',44,['gsp_sm_xmlClosingForEmptyTag':(""),'content':("width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no"),'name':("viewport")],-1)
printHtmlPart(0)
invokeTag('stylesheet','asset',45,['src':("googlefont.css")],-1)
printHtmlPart(7)
invokeTag('stylesheet','asset',47,['src':("beta-version/css/bootstrap.min.css")],-1)
printHtmlPart(0)
invokeTag('stylesheet','asset',48,['src':("beta-version/css/responsive.bootstrap.min.css")],-1)
printHtmlPart(0)
invokeTag('stylesheet','asset',49,['src':("beta-version/css/font-awesome.min.css")],-1)
printHtmlPart(0)
invokeTag('stylesheet','asset',50,['src':("beta-version/css/AdminLTE.css")],-1)
printHtmlPart(0)
invokeTag('stylesheet','asset',51,['src':("beta-version/css/custom.css")],-1)
printHtmlPart(0)
invokeTag('stylesheet','asset',52,['src':("beta-version/css/all-skins.css")],-1)
printHtmlPart(0)
invokeTag('stylesheet','asset',53,['src':("beta-version/css/dataTables.bootstrap.min.css")],-1)
printHtmlPart(7)
invokeTag('stylesheet','asset',55,['src':("morquee.css")],-1)
printHtmlPart(7)
invokeTag('javascript','asset',57,['src':("beta-version/js/jquery.min.js")],-1)
printHtmlPart(0)
invokeTag('javascript','asset',58,['src':("beta-version/js/sample.js")],-1)
printHtmlPart(0)
invokeTag('javascript','asset',59,['src':("beta-version/js/adminlte.min.js")],-1)
printHtmlPart(0)
invokeTag('javascript','asset',60,['src':("beta-version/js/bootstrap.min.js")],-1)
printHtmlPart(7)
invokeTag('javascript','asset',62,['src':("/ckeditor/ckeditor.js")],-1)
printHtmlPart(8)
invokeTag('stylesheet','asset',67,['src':("beta-version/css/jquery.datetimepicker.min.css")],-1)
printHtmlPart(9)
invokeTag('javascript','asset',70,['src':("dashboard.js")],-1)
printHtmlPart(7)
invokeTag('layoutHead','g',70,[:],-1)
printHtmlPart(0)
})
invokeTag('captureHead','sitemesh',72,[:],1)
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(10)
invokeTag('render','g',77,['template':("/layouts/adminHeader")],-1)
printHtmlPart(11)
invokeTag('set','g',80,['var':("formID"),'value':(formDetails?.id)],-1)
printHtmlPart(12)
createClosureForHtmlPart(13, 2)
invokeTag('link','g',87,['action':("applicantDash"),'params':([csrfPreventionSalt:csrfPreventionSalt])],2)
printHtmlPart(14)
createClosureForHtmlPart(15, 2)
invokeTag('link','g',92,['controller':("applicant"),'action':("createComment"),'params':([inst:formID, csrfPreventionSalt:csrfPreventionSalt])],2)
printHtmlPart(16)
createClosureForHtmlPart(17, 2)
invokeTag('link','g',93,['controller':("applicant"),'action':("sendClientLetter"),'params':([inst:formID, csrfPreventionSalt:csrfPreventionSalt])],2)
printHtmlPart(18)
if(true && (formDetails?.category?.category == FormCategory?.Category?.Form_1)) {
printHtmlPart(19)
if(true && (formDetails?.purposeOfProposal == 'Research')) {
printHtmlPart(20)
createClosureForHtmlPart(21, 4)
invokeTag('link','g',114,['controller':("Applicant"),'action':("createPeriodicReport"),'params':([instance:formID,act:'1', csrfPreventionSalt:csrfPreventionSalt])],4)
printHtmlPart(22)
}
else {
printHtmlPart(23)
createClosureForHtmlPart(24, 4)
invokeTag('link','g',120,['controller':("Applicant"),'action':("createPeriodicReport"),'params':([instance:formID,act:'1C',csrfPreventionSalt:csrfPreventionSalt])],4)
printHtmlPart(25)
}
printHtmlPart(26)
}
printHtmlPart(27)
if(true && (formDetails?.category?.category == FormCategory?.Category?.Form_2)) {
printHtmlPart(20)
createClosureForHtmlPart(28, 3)
invokeTag('link','g',124,['controller':("Applicant"),'action':("createPeriodicReport"),'params':([instance:formID,act:'2',csrfPreventionSalt:csrfPreventionSalt])],3)
printHtmlPart(29)
}
printHtmlPart(19)
if(true && (formDetails?.category?.category == FormCategory?.Category?.Form_3)) {
printHtmlPart(30)
createClosureForHtmlPart(31, 3)
invokeTag('link','g',129,['controller':("Applicant"),'action':("createPeriodicReport"),'params':([instance:formID,act:'3', csrfPreventionSalt:csrfPreventionSalt])],3)
printHtmlPart(32)
}
printHtmlPart(19)
if(true && (formDetails?.category?.category == FormCategory?.Category?.Form_4)) {
printHtmlPart(33)
createClosureForHtmlPart(34, 3)
invokeTag('link','g',133,['controller':("Applicant"),'action':("createPeriodicReport"),'params':([instance:formID,act:'4', csrfPreventionSalt:csrfPreventionSalt])],3)
printHtmlPart(32)
}
printHtmlPart(35)
createClosureForHtmlPart(36, 2)
invokeTag('link','g',138,['action':("receivedCommunication"),'controller':("applicant"),'params':([instance:formID, csrfPreventionSalt:csrfPreventionSalt])],2)
printHtmlPart(37)
invokeTag('layoutBody','g',139,[:],-1)
printHtmlPart(38)
invokeTag('javascript','asset',139,['src':("beta-version/js/datatable/jquery.min.js")],-1)
printHtmlPart(39)
invokeTag('javascript','asset',140,['src':("beta-version/js/datatable/bootstrap.min.js")],-1)
printHtmlPart(39)
invokeTag('javascript','asset',144,['src':("beta-version/js/datatable/jquery.dataTables.min.js")],-1)
printHtmlPart(39)
invokeTag('javascript','asset',149,['src':("beta-version/js/datatable/dataTables.bootstrap.min.")],-1)
printHtmlPart(39)
invokeTag('javascript','asset',152,['src':("beta-version/js/datatable/dataTables.responsive.min.js")],-1)
printHtmlPart(40)
invokeTag('javascript','asset',152,['src':("beta-version/js/calander/jquery.datetimepicker.js")],-1)
printHtmlPart(41)
invokeTag('render','g',163,['template':("/layouts/footer")],-1)
printHtmlPart(42)
})
invokeTag('captureBody','sitemesh',163,['class':("hold-transition skin-blue sidebar-mini")],1)
printHtmlPart(43)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1668157271732L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
