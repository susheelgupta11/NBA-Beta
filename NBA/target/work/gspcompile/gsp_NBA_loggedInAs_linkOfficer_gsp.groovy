import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_NBA_loggedInAs_linkOfficer_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/loggedInAs/_linkOfficer.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
if(true && (linkOfficerInstance)) {
printHtmlPart(1)
expressionOut.print(linkOfficerInstance?.nbaUserFrom?.name)
printHtmlPart(2)
}
else {
printHtmlPart(3)
invokeTag('select','g',13,['name':("userLinkByAdmin"),'from':(nbauser),'value':(linkOfficerInstance?.nbaUserFrom?.name),'noSelection':(['':'-Choose User -']),'required':("required")],-1)
printHtmlPart(4)
}
printHtmlPart(5)
if(true && (linkOfficerInstance)) {
printHtmlPart(1)
expressionOut.print(linkOfficerInstance?.nbaUserTo?.name)
printHtmlPart(2)
}
else {
printHtmlPart(1)
invokeTag('select','g',27,['name':("linkUser"),'from':(nbauser),'value':(linkOfficerInstance?.nbaUserTo?.name),'noSelection':(['':'-Choose Link Officer -']),'required':("required")],-1)
printHtmlPart(6)
}
printHtmlPart(7)
invokeTag('datePicker','g',37,['name':("fromDate"),'value':(linkOfficerInstance?.fromDate)],-1)
printHtmlPart(8)
invokeTag('datePicker','g',45,['name':("toDate"),'value':(linkOfficerInstance?.toDate)],-1)
printHtmlPart(9)
invokeTag('textArea','g',48,['name':("reason"),'style':("width:100%"),'value':(linkOfficerInstance?.reason)],-1)
printHtmlPart(10)
if(true && (linkOfficerInstance?.status == '' || linkOfficerInstance?.status == null)) {
printHtmlPart(11)
invokeTag('radio','g',60,['name':("status"),'value':("yes")],-1)
printHtmlPart(12)
invokeTag('radio','g',61,['name':("status"),'value':("no"),'checked':("true")],-1)
printHtmlPart(13)
}
printHtmlPart(14)
if(true && (linkOfficerInstance?.status == true)) {
printHtmlPart(11)
invokeTag('radio','g',63,['name':("status"),'value':("yes"),'checked':("true")],-1)
printHtmlPart(12)
invokeTag('radio','g',65,['name':("status"),'value':("no")],-1)
printHtmlPart(13)
}
printHtmlPart(14)
if(true && (linkOfficerInstance?.status == false)) {
printHtmlPart(11)
invokeTag('radio','g',68,['name':("status"),'value':("yes")],-1)
printHtmlPart(12)
invokeTag('radio','g',70,['name':("status"),'value':("no"),'checked':("true")],-1)
printHtmlPart(13)
}
printHtmlPart(15)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1586255810000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
