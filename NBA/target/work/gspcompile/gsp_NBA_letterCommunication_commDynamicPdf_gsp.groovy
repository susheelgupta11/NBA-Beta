import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_NBA_letterCommunication_commDynamicPdf_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/letterCommunication/_commDynamicPdf.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',7,['gsp_sm_xmlClosingForEmptyTag':("/"),'http-equiv':("Content-Type"),'content':("text/html; charset=ISO-8859-1")],-1)
printHtmlPart(2)
createTagBody(2, {->
createClosureForHtmlPart(3, 3)
invokeTag('captureTitle','sitemesh',9,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',9,[:],2)
printHtmlPart(4)
invokeTag('stylesheet','asset',15,['src':("beta-version/css/bootstrap.min.css")],-1)
printHtmlPart(1)
invokeTag('javascript','asset',18,['src':("beta-version/js/datatable/bootstrap.min.js")],-1)
printHtmlPart(5)
})
invokeTag('captureHead','sitemesh',19,[:],1)
printHtmlPart(6)
createTagBody(1, {->
printHtmlPart(7)
expressionOut.print(body?.dynamicLetterNumberNbaOUT)
printHtmlPart(8)
invokeTag('formatDate','g',26,['format':("dd/MM/yyyy"),'date':(body?.sendDate)],-1)
printHtmlPart(9)
expressionOut.print(body?.appNumber)
printHtmlPart(10)
if(true && (appForm1)) {
printHtmlPart(11)
if(true && (appForm1.individualProfiles)) {
printHtmlPart(1)
for( indi in (appForm1.individualProfiles) ) {
printHtmlPart(12)
expressionOut.print(indi?.title)
printHtmlPart(13)
expressionOut.print(indi?.firstName)
printHtmlPart(13)
expressionOut.print(indi?.middleName)
printHtmlPart(13)
expressionOut.print(indi?.lastName)
printHtmlPart(14)
expressionOut.print(indi?.address1)
printHtmlPart(13)
expressionOut.print(indi?.address2)
printHtmlPart(13)
expressionOut.print(indi?.address3)
printHtmlPart(15)
expressionOut.print(indi?.email)
printHtmlPart(16)
}
printHtmlPart(1)
}
printHtmlPart(17)
if(true && (appForm1?.companyProfiles)) {
printHtmlPart(1)
for( com in (appForm1?.companyProfiles) ) {
printHtmlPart(12)
expressionOut.print(com?.entityName)
printHtmlPart(14)
expressionOut.print(com?.address1)
printHtmlPart(13)
expressionOut.print(com?.address2)
printHtmlPart(13)
expressionOut.print(com?.address3)
printHtmlPart(15)
expressionOut.print(com?.email)
printHtmlPart(16)
}
printHtmlPart(1)
}
printHtmlPart(11)
if(true && (appForm1?.indianResearcher)) {
printHtmlPart(1)
for( ir in (appForm1?.indianResearcher) ) {
printHtmlPart(12)
expressionOut.print(ir?.title ?:'')
expressionOut.print(ir?.firstName?: '')
expressionOut.print(ir?.middleName?:'')
expressionOut.print(ir?.lastName?:'')
printHtmlPart(18)
expressionOut.print(ir?.designation)
printHtmlPart(19)
expressionOut.print(ir?.address1)
printHtmlPart(13)
expressionOut.print(ir?.address2)
printHtmlPart(13)
expressionOut.print(ir?.address3)
printHtmlPart(15)
expressionOut.print(ir?.email)
printHtmlPart(16)
}
printHtmlPart(1)
}
printHtmlPart(11)
if(true && (appForm1?.depostionOfMicroOrganism)) {
printHtmlPart(1)
for( dm in (appForm1?.depostionOfMicroOrganism) ) {
printHtmlPart(12)
expressionOut.print(dm?.nameOfDepositor)
printHtmlPart(14)
expressionOut.print(dm?.address1)
printHtmlPart(13)
expressionOut.print(dm?.address2)
printHtmlPart(13)
expressionOut.print(dm?.address3)
printHtmlPart(15)
expressionOut.print(dm?.email)
printHtmlPart(16)
}
printHtmlPart(1)
}
printHtmlPart(11)
if(true && (appForm1?.indianGovtInst)) {
printHtmlPart(1)
for( ig in (appForm1?.indianGovtInst) ) {
printHtmlPart(12)
expressionOut.print(ig?.govtInstName)
printHtmlPart(18)
expressionOut.print(ig?.designation)
printHtmlPart(19)
expressionOut.print(ig?.address1)
printHtmlPart(13)
expressionOut.print(ig?.address2)
printHtmlPart(13)
expressionOut.print(ig?.address3)
printHtmlPart(15)
expressionOut.print(ig?.email)
printHtmlPart(16)
}
printHtmlPart(1)
}
printHtmlPart(1)
}
printHtmlPart(20)
expressionOut.print(body?.subject)
printHtmlPart(21)
expressionOut.print(raw(body?.messageBody))
printHtmlPart(22)
expressionOut.print(body?.emailId)
printHtmlPart(23)
expressionOut.print(body?.ccEmailId)
printHtmlPart(24)
invokeTag('formatDate','g',82,['format':("dd/MM/yyyy"),'date':(body?.createdDate)],-1)
printHtmlPart(25)
invokeTag('formatDate','g',84,['format':("dd/MM/yyyy"),'date':(body?.approvedDate)],-1)
printHtmlPart(26)
expressionOut.print(body?.createdBy)
printHtmlPart(27)
expressionOut.print(body?.sendBy)
printHtmlPart(28)
})
invokeTag('captureBody','sitemesh',87,[:],1)
printHtmlPart(29)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1671616405765L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
