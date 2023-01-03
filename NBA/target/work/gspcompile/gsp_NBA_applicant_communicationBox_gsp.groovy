import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_NBA_applicant_communicationBox_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/applicant/_communicationBox.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
expressionOut.print(communicationInstance?.subject)
printHtmlPart(1)
invokeTag('textArea','g',10,['id':("editor1"),'name':("comment"),'value':(communicationInstance?.messageBody)],-1)
printHtmlPart(2)
if(true && (communicationInstance?.pdfFileAttachments)) {
printHtmlPart(3)
for( attachmentPdf in (communicationInstance?.pdfFileAttachments) ) {
printHtmlPart(4)
createTagBody(3, {->
expressionOut.print(attachmentPdf?.pdfName)
})
invokeTag('link','g',32,['action':("communicationFileShow"),'target':("_blank"),'params':([showId:attachmentPdf?.id,csrfPreventionSalt:csrfPreventionSalt])],3)
printHtmlPart(5)
createClosureForHtmlPart(6, 3)
invokeTag('link','g',38,['action':("deleteCommunicationPdf"),'params':([deleteId:attachmentPdf?.id,formId:formDetails?.id,csrfPreventionSalt:csrfPreventionSalt]),'onclick':("return confirm('Are you sure?');")],3)
printHtmlPart(7)
}
printHtmlPart(8)
}
printHtmlPart(9)
invokeTag('hiddenField','g',39,['name':("formId"),'value':(formDetails?.id)],-1)
printHtmlPart(10)
invokeTag('hiddenField','g',43,['name':("csrfPreventionSalt"),'value':(csrfPreventionSalt)],-1)
printHtmlPart(11)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1651332339403L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
