import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_NBA_formPreview_form1Part4Preview_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/formPreview/_form1Part4Preview.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
if(true && (appForm.instituteParticipation == true)) {
printHtmlPart(1)
invokeTag('radio','g',20,['class':("instituteparticipation"),'checked':("checked"),'name':("instituteParticipation"),'value':("Yes"),'disabled':("disabled")],-1)
printHtmlPart(2)
}
else if(true && (appForm.instituteParticipation == false)) {
printHtmlPart(3)
invokeTag('radio','g',26,['class':("instituteparticipation"),'radio-check':("activities"),'checked':("checked"),'name':("instituteParticipation"),'value':("No"),'disabled':("disabled")],-1)
printHtmlPart(4)
}
else {
printHtmlPart(5)
}
printHtmlPart(6)
if(true && (appForm.instituteParticipation == true)) {
printHtmlPart(7)
invokeTag('textArea','g',43,['class':("width txtreq"),'name':("detailsOfInstitute"),'disabled':("disabled"),'value':(appForm?.detailsOfInstitute)],-1)
printHtmlPart(8)
if(true && (appForm?.letterOfintent)) {
printHtmlPart(9)
createTagBody(3, {->
printHtmlPart(10)
expressionOut.print(appForm?.letterOfIntentName)
printHtmlPart(11)
})
invokeTag('link','g',65,['controller':("applicationManagement"),'action':("showAppDc"),'id':(appForm?.id),'target':("_blank"),'params':([filename: 'letterOfIntentName', dataName: 'letterOfIntentName',csrfPreventionSalt:'${csrfPreventionSalt}'])],3)
printHtmlPart(12)
}
else {
printHtmlPart(13)
}
printHtmlPart(14)
}
printHtmlPart(15)

int i=1

printHtmlPart(16)
for( mapKeyValue in (quesAnswerMap) ) {
printHtmlPart(17)
expressionOut.print(mapKeyValue?.getKey()?.questionNo)
printHtmlPart(18)
expressionOut.print(mapKeyValue?.getKey()?.question)
printHtmlPart(19)
invokeTag('textArea','g',85,['placeholder':(mapKeyValue?.getKey()?.placeholder),'disabled':("disabled"),'class':("width"),'name':("answer_${mapKeyValue?.getKey()?.id}"),'value':(mapKeyValue?.getValue()?.answer),'data-toggle':("tooltip"),'req':("1"),'data-placement':("top"),'title':(mapKeyValue?.getKey()?.questionTooltip)],-1)
printHtmlPart(20)

i++

printHtmlPart(16)
}
printHtmlPart(21)
if(true && (appForm?.isBenefitSharing == true)) {
printHtmlPart(22)
invokeTag('radio','g',108,['name':("isBenefitSharing"),'class':("radioshow"),'radio-check':("Proposed"),'checked':("checked"),'value':("Yes"),'disabled':("disabled")],-1)
printHtmlPart(23)
}
else if(true && (appForm?.isBenefitSharing == false)) {
printHtmlPart(24)
invokeTag('radio','g',115,['name':("isBenefitSharing"),'value':("No"),'class':("radioshow"),'radio-check':("Proposed"),'checked':("checked"),'disabled':("disabled")],-1)
printHtmlPart(25)
}
else {
printHtmlPart(26)
}
printHtmlPart(27)
if(true && (appForm?.isBenefitSharing == true)) {
printHtmlPart(28)
if(true && (appForm?.sharingDoc)) {
printHtmlPart(29)
createTagBody(3, {->
printHtmlPart(12)
expressionOut.print(appForm?.sharingDocName)
printHtmlPart(30)
})
invokeTag('link','g',134,['controller':("applicationManagement"),'action':("showAppDc"),'id':(appForm?.id),'target':("_blank"),'params':([filename: 'sharingDocName', dataName: 'sharingDocName',csrfPreventionSalt:'${csrfPreventionSalt}'])],3)
printHtmlPart(22)
}
else {
printHtmlPart(31)
}
printHtmlPart(32)
}
printHtmlPart(33)
invokeTag('textArea','g',150,['class':("width"),'name':("otherInfo"),'disabled':("disabled"),'value':(appForm?.otherInfo)],-1)
printHtmlPart(34)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1537268168000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
