import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_NBA_SBBreplyConsent_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/SBB/replyConsent.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',4,['gsp_sm_xmlClosingForEmptyTag':("/"),'http-equiv':("Content-Type"),'content':("text/html; charset=ISO-8859-1")],-1)
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',5,['gsp_sm_xmlClosingForEmptyTag':("/"),'name':("layout"),'content':("sbb")],-1)
printHtmlPart(1)
createTagBody(2, {->
createClosureForHtmlPart(2, 3)
invokeTag('captureTitle','sitemesh',6,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',6,[:],2)
printHtmlPart(1)
})
invokeTag('captureHead','sitemesh',7,[:],1)
printHtmlPart(1)
createTagBody(1, {->
printHtmlPart(3)
if(true && (sbbInstance?.other)) {
printHtmlPart(4)
}
printHtmlPart(5)
if(true && (message)) {
printHtmlPart(6)
expressionOut.print(message)
printHtmlPart(7)
}
printHtmlPart(8)
createTagBody(2, {->
printHtmlPart(9)
invokeTag('hiddenField','g',35,['name':("sbbName"),'value':(sbbName)],-1)
printHtmlPart(10)
invokeTag('hiddenField','g',36,['name':("appNumber"),'value':(formDetails?.appNumber)],-1)
printHtmlPart(10)
invokeTag('hiddenField','g',37,['name':("formId"),'value':(formDetails?.id)],-1)
printHtmlPart(10)
invokeTag('hiddenField','g',38,['name':("csrfPreventionSalt"),'value':(csrfPreventionSalt)],-1)
printHtmlPart(11)
invokeTag('hiddenField','g',39,['name':("instance"),'value':(formDetails?.id)],-1)
printHtmlPart(12)
invokeTag('hiddenField','g',40,['name':("sbbInst"),'value':(sbbInstance?.id)],-1)
printHtmlPart(13)
expressionOut.print(sbbName?:sbbInstance?.sbbName)
printHtmlPart(14)
expressionOut.print(formDetails?.appNumber)
printHtmlPart(15)
expressionOut.print(sbbInstance?.dynLetterNumber)
printHtmlPart(16)
invokeTag('formatDate','g',59,['format':("dd/MM/yyyy"),'date':(sbbInstance?.letterCreatedDate)],-1)
printHtmlPart(17)
invokeTag('formatDate','g',66,['name':("consentCreateDate"),'format':("dd/MM/yyyy"),'date':(new Date())],-1)
printHtmlPart(18)
if(true && (sbbInstance?.localBody)) {
printHtmlPart(1)
for( local in (sbbInstance?.localBody) ) {
printHtmlPart(19)
expressionOut.print(local)
printHtmlPart(20)
}
printHtmlPart(21)
}
else {
printHtmlPart(22)
}
printHtmlPart(23)
expressionOut.print(sbbName?:sbbInstance?.sbbName)
printHtmlPart(24)
invokeTag('select','g',142,['name':("consentDdn"),'from':(replyDdn),'noSelection':(['':'-Select-']),'onchange':("checkOther(this)"),'value':(sbbInstance?.ddn)],-1)
printHtmlPart(25)
expressionOut.print(sbbInstance?.other)
printHtmlPart(26)
if(true && (show == 'show')) {
printHtmlPart(27)
}
printHtmlPart(28)
if(true && (show == 'show')) {
printHtmlPart(1)
createClosureForHtmlPart(29, 4)
invokeTag('link','g',177,['controller':("SBB"),'action':("sbbConsentPrint"),'params':([sbbInst:sbbInstance?.id,instance:formDetails?.id,csrfPreventionSalt:csrfPreventionSalt]),'class':("btn btn-primary pull-right"),'target':("_blank")],4)
printHtmlPart(30)
}
else {
printHtmlPart(31)
invokeTag('actionSubmit','g',180,['value':("Save"),'action':("consentTempSave"),'class':("btn btn-primary pull-right"),'style':("margin-right: 10px;")],-1)
printHtmlPart(32)
}
printHtmlPart(33)
if(true && (show == 'show')) {
printHtmlPart(34)
invokeTag('actionSubmit','g',185,['value':("Submit"),'action':("sbbConsentStatus"),'class':("btn btn-primary pull-center"),'style':("margin-right: 10px;")],-1)
printHtmlPart(35)
}
printHtmlPart(36)
})
invokeTag('form','g',189,['controller':("SBB"),'action':("sbbConsentStatus"),'method':("Post"),'enctype':("multipart/form-data")],2)
printHtmlPart(37)
})
invokeTag('captureBody','sitemesh',195,[:],1)
printHtmlPart(38)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1620367786246L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
