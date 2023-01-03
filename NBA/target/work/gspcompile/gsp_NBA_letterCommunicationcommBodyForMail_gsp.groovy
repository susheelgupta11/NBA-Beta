import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_NBA_letterCommunicationcommBodyForMail_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/letterCommunication/commBodyForMail.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('stylesheet','asset',5,['src':("beta-version/css/bootstrap.min.css")],-1)
printHtmlPart(2)
})
invokeTag('captureHead','sitemesh',55,[:],1)
printHtmlPart(3)
createTagBody(1, {->
printHtmlPart(4)
expressionOut.print(emailInstance?.dynamicLetterNumberNbaOUT)
printHtmlPart(5)
invokeTag('formatDate','g',105,['format':("dd/MM/yyyy"),'date':(emailInstance?.sendDate)],-1)
printHtmlPart(6)
if(true && (appForm1)) {
printHtmlPart(7)
if(true && (appForm1.individualProfiles)) {
printHtmlPart(8)
for( indi in (appForm1.individualProfiles) ) {
printHtmlPart(9)
expressionOut.print(indi?.title)
printHtmlPart(10)
expressionOut.print(indi?.firstName)
printHtmlPart(10)
expressionOut.print(indi?.middleName)
printHtmlPart(10)
expressionOut.print(indi?.lastName)
printHtmlPart(11)
expressionOut.print(indi?.address1)
printHtmlPart(10)
expressionOut.print(indi?.address2)
printHtmlPart(10)
expressionOut.print(indi?.address3)
printHtmlPart(12)
expressionOut.print(indi?.email)
printHtmlPart(13)
}
printHtmlPart(8)
}
printHtmlPart(14)
if(true && (appForm1?.companyProfiles)) {
printHtmlPart(8)
for( com in (appForm1?.companyProfiles) ) {
printHtmlPart(9)
expressionOut.print(com?.entityName)
printHtmlPart(11)
expressionOut.print(com?.address1)
printHtmlPart(10)
expressionOut.print(com?.address2)
printHtmlPart(10)
expressionOut.print(com?.address3)
printHtmlPart(15)
expressionOut.print(com?.email)
printHtmlPart(13)
}
printHtmlPart(8)
}
printHtmlPart(7)
if(true && (appForm1?.indianResearcher)) {
printHtmlPart(8)
for( ir in (appForm1?.indianResearcher) ) {
printHtmlPart(9)
expressionOut.print(ir?.title ?:'')
expressionOut.print(ir?.firstName?: '')
expressionOut.print(ir?.middleName?:'')
expressionOut.print(ir?.lastName?:'')
printHtmlPart(11)
expressionOut.print(ir?.designation)
printHtmlPart(16)
expressionOut.print(ir?.address1)
printHtmlPart(10)
expressionOut.print(ir?.address2)
printHtmlPart(10)
expressionOut.print(ir?.address3)
printHtmlPart(12)
expressionOut.print(ir?.email)
printHtmlPart(13)
}
printHtmlPart(8)
}
printHtmlPart(7)
if(true && (appForm1?.depostionOfMicroOrganism)) {
printHtmlPart(8)
for( dm in (appForm1?.depostionOfMicroOrganism) ) {
printHtmlPart(9)
expressionOut.print(dm?.nameOfDepositor)
printHtmlPart(11)
expressionOut.print(dm?.address1)
printHtmlPart(10)
expressionOut.print(dm?.address2)
printHtmlPart(10)
expressionOut.print(dm?.address3)
printHtmlPart(12)
expressionOut.print(dm?.email)
printHtmlPart(13)
}
printHtmlPart(8)
}
printHtmlPart(7)
if(true && (appForm1?.indianGovtInst)) {
printHtmlPart(8)
for( ig in (appForm1?.indianGovtInst) ) {
printHtmlPart(9)
expressionOut.print(ig?.govtInstName)
printHtmlPart(11)
expressionOut.print(ig?.designation)
printHtmlPart(16)
expressionOut.print(ig?.address1)
printHtmlPart(10)
expressionOut.print(ig?.address2)
printHtmlPart(10)
expressionOut.print(ig?.address3)
printHtmlPart(12)
expressionOut.print(ig?.email)
printHtmlPart(13)
}
printHtmlPart(8)
}
printHtmlPart(8)
}
printHtmlPart(17)
expressionOut.print(emailInstance?.subject)
printHtmlPart(18)
expressionOut.print(raw(emailInstance?.messageBody))
printHtmlPart(19)
invokeTag('javascript','asset',247,['src':("beta-version/js/bootstrap.min.js")],-1)
printHtmlPart(8)
invokeTag('javascript','asset',248,['src':("beta-version/js/jquery.min.js")],-1)
printHtmlPart(7)
})
invokeTag('captureBody','sitemesh',250,[:],1)
printHtmlPart(20)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1671616102048L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
