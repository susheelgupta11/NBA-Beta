import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_NBA_dashboard_dashRight_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/dashboard/_dashRight.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
if(true && (commApplication)) {
printHtmlPart(1)
loop:{
int l = 0
for( comm in (commApplication) ) {
printHtmlPart(1)
if(true && (comm?.client_id)) {
printHtmlPart(2)
expressionOut.print(l+1)
printHtmlPart(3)
expressionOut.print(comm?.app_number)
printHtmlPart(3)
expressionOut.print(comm?.subject)
printHtmlPart(4)
createClosureForHtmlPart(5, 4)
invokeTag('remoteLink','g',32,['action':("viewCommunication"),'controller':("letterCommunication"),'title':("Client Communication Details"),'params':([editId:comm?.client_id,csrfPreventionSalt:csrfPreventionSalt]),'data-target':("#success"),'data-toggle':("modal"),'update':("nin")],4)
printHtmlPart(6)
}
else if(true && (comm?.sbb_consent_id)) {
printHtmlPart(2)
expressionOut.print(l+1)
printHtmlPart(3)
expressionOut.print(comm?.app_number)
printHtmlPart(3)
expressionOut.print('Consent Reply '+comm?.app_number)
printHtmlPart(7)
createClosureForHtmlPart(5, 4)
invokeTag('remoteLink','g',50,['action':("viewConsent"),'controller':("SBB"),'title':("SBB Communication Details"),'params':([editId:comm?.sbb_consent_id,csrfPreventionSalt:csrfPreventionSalt]),'data-target':("#success"),'data-toggle':("modal"),'update':("nin")],4)
printHtmlPart(8)
}
printHtmlPart(9)
l++
}
}
printHtmlPart(9)
}
else {
printHtmlPart(10)
}
printHtmlPart(11)
if(true && (virtualApplications)) {
printHtmlPart(9)
loop:{
int i = 0
for( virtual in (virtualApplications) ) {
printHtmlPart(12)
expressionOut.print(i+1)
printHtmlPart(13)
expressionOut.print(virtual?.appNumber)
printHtmlPart(13)
expressionOut.print(virtual?.currentStatus?.statusUpdate)
printHtmlPart(13)
expressionOut.print(virtual?.currentStatus?.reasonForRecordRoom)
printHtmlPart(13)
expressionOut.print(virtual?.currentStatus?.changedBy?.name)
printHtmlPart(14)
createClosureForHtmlPart(15, 3)
invokeTag('link','g',101,['controller':("dashboard"),'action':("movetoInbox"),'onclick':("return confirmation('Are you sure')"),'params':([instance:virtual?.id])],3)
printHtmlPart(16)
i++
}
}
printHtmlPart(17)
}
else {
printHtmlPart(18)
}
printHtmlPart(19)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1646653827980L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
