import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_NBA_manualUploadaddDocument_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/manualUpload/addDocument.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',4,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("dashPage")],-1)
printHtmlPart(2)
createTagBody(2, {->
createClosureForHtmlPart(3, 3)
invokeTag('captureTitle','sitemesh',10,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',10,[:],2)
printHtmlPart(4)
})
invokeTag('captureHead','sitemesh',11,[:],1)
printHtmlPart(4)
createTagBody(1, {->
printHtmlPart(5)
if(true && (message)) {
printHtmlPart(6)
expressionOut.print(message)
printHtmlPart(7)
}
printHtmlPart(8)
createTagBody(2, {->
printHtmlPart(9)
expressionOut.print(manualDataDetails?.classified)
printHtmlPart(10)
expressionOut.print(manualDataDetails?.language)
printHtmlPart(11)
expressionOut.print(manualDataDetails?.letterDate)
printHtmlPart(12)
expressionOut.print(manualDataDetails?.letterDate)
printHtmlPart(13)
expressionOut.print(manualDataDetails?.mobileNumber)
printHtmlPart(14)
expressionOut.print(manualDataDetails?.fileNumber)
printHtmlPart(15)
expressionOut.print(manualDataDetails?.deliveryMode)
printHtmlPart(16)
expressionOut.print(manualDataDetails?.letterReferenceNumber)
printHtmlPart(17)
expressionOut.print(manualDataDetails?.name)
printHtmlPart(18)
expressionOut.print(manualDataDetails?.designation)
printHtmlPart(19)
expressionOut.print(manualDataDetails?.address1)
printHtmlPart(20)
expressionOut.print(manualDataDetails?.address2)
printHtmlPart(21)
expressionOut.print(manualDataDetails?.country)
printHtmlPart(22)
expressionOut.print(manualDataDetails?.state)
printHtmlPart(23)
expressionOut.print(manualDataDetails?.city)
printHtmlPart(24)
expressionOut.print(manualDataDetails?.pin)
printHtmlPart(25)
invokeTag('submitButton','g',126,['name':("Submit"),'value':("Submit"),'class':("btn btn-primary text-center")],-1)
printHtmlPart(26)
invokeTag('hiddenField','g',128,['name':("formId"),'value':(getFormId)],-1)
printHtmlPart(27)
invokeTag('hiddenField','g',129,['name':("csrfPreventionSalt"),'value':(csrfPreventionSalt)],-1)
printHtmlPart(28)
})
invokeTag('form','g',131,['controller':("manualUpload"),'action':("save"),'id':("uplod")],2)
printHtmlPart(29)
invokeTag('render','g',134,['template':("/rightPane/matchdata")],-1)
printHtmlPart(30)
})
invokeTag('captureBody','sitemesh',167,[:],1)
printHtmlPart(31)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1667545168675L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
