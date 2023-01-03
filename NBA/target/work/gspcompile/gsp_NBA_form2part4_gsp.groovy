import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_NBA_form2part4_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/form2/part4.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',6,['gsp_sm_xmlClosingForEmptyTag':("/"),'name':("layout"),'content':("loggedInUser")],-1)
printHtmlPart(1)
createTagBody(2, {->
createClosureForHtmlPart(2, 3)
invokeTag('captureTitle','sitemesh',7,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',7,[:],2)
printHtmlPart(3)
})
invokeTag('captureHead','sitemesh',16,[:],1)
printHtmlPart(4)
createTagBody(1, {->
printHtmlPart(5)
createTagBody(2, {->
printHtmlPart(6)
expressionOut.print(tabStatus)
printHtmlPart(7)
})
invokeTag('javascript','g',21,[:],2)
printHtmlPart(8)
invokeTag('render','g',27,['template':("/applicationManagement/leftTabs"),'model':([formType:formType])],-1)
printHtmlPart(9)
createTagBody(2, {->
printHtmlPart(10)
expressionOut.print(csrfPreventionSalt)
printHtmlPart(11)
invokeTag('textArea','g',64,['class':("width"),'txtmaxword100':("1"),'placeHolder':("Provide details in 500 words"),'name':("detailsOfIndividualOrOrganisation"),'value':(appForm?.detailsOfIndividualOrOrganisation),'req':("1")],-1)
printHtmlPart(12)
invokeTag('textArea','g',76,['class':("width"),'txtmaxword100':("1"),'placeHolder':("Provide details in 500 words"),'name':("useofResearchResults"),'value':(appForm?.useofResearchResults),'req':("1")],-1)
printHtmlPart(13)
invokeTag('textArea','g',93,['class':("width"),'txtmaxword100':("1"),'placeHolder':("Provide details in 500 words"),'name':("benefitsToTheIndividualOrOrganization"),'value':(appForm?.benefitsToTheIndividualOrOrganization),'req':("1")],-1)
printHtmlPart(14)
invokeTag('textArea','g',106,['class':("width"),'txtmaxword100':("1"),'name':("benefitsToTheApplicant"),'placeHolder':("Provide details in 500 words"),'value':(appForm?.benefitsToTheApplicant),'req':("1")],-1)
printHtmlPart(15)
if(true && (!appForm?.isAgreementOrMou)) {
printHtmlPart(16)
}
else {
printHtmlPart(17)
if(true && (appForm?.isAgreementOrMou == 'true')) {
printHtmlPart(18)
}
else {
printHtmlPart(19)
}
printHtmlPart(20)
if(true && (appForm?.isAgreementOrMou == 'false')) {
printHtmlPart(21)
}
else {
printHtmlPart(22)
}
printHtmlPart(23)
}
printHtmlPart(24)
invokeTag('textArea','g',162,['class':("width reqc txtmaxword100"),'rows':("5"),'PlaceHolder':("Provide details in 500 words"),'name':("collaborationDetails"),'value':(appForm?.collaborationDetails)],-1)
printHtmlPart(25)
if(true && (appForm?.mouFile)) {
printHtmlPart(26)
if(true && (flash.message)) {
printHtmlPart(27)
expressionOut.print(flash.message)
printHtmlPart(28)
}
else {
printHtmlPart(29)
createTagBody(5, {->
printHtmlPart(30)
expressionOut.print(appForm?.mouFileName)
printHtmlPart(29)
})
invokeTag('link','g',182,['controller':("form2"),'action':("showDc"),'id':(appForm?.id),'target':("_blank"),'params':([filename: "mouFileName", dataName: "mouFileName",csrfPreventionSalt:"${csrfPreventionSalt}"])],5)
printHtmlPart(31)
}
printHtmlPart(32)
}
else {
printHtmlPart(33)
if(true && (flash.message)) {
printHtmlPart(27)
expressionOut.print(flash.message)
printHtmlPart(28)
}
printHtmlPart(32)
}
printHtmlPart(34)
invokeTag('hiddenField','g',195,['name':("appFormId"),'value':(appForm?.id)],-1)
printHtmlPart(23)
invokeTag('hiddenField','g',196,['name':("formType"),'value':(formType)],-1)
printHtmlPart(35)
})
invokeTag('uploadForm','g',203,['action':("savePart4"),'class':("form-horizontal"),'autocomplete':("off"),'role':("form")],2)
printHtmlPart(36)
createClosureForHtmlPart(37, 2)
invokeTag('link','g',211,['controller':("form2"),'action':("part3"),'params':([appFormId:appForm?.id,formType:formType,csrfPreventionSalt:"${csrfPreventionSalt}"]),'class':("btn btn-primary pull-left")],2)
printHtmlPart(38)
createClosureForHtmlPart(39, 2)
invokeTag('link','g',219,['controller':("applicationManagement"),'action':("form1Part5"),'params':([appFormId:appForm?.id,formType:formType,csrfPreventionSalt:"${csrfPreventionSalt}"]),'class':("btn btn-primary pull-right")],2)
printHtmlPart(40)
})
invokeTag('captureBody','sitemesh',224,[:],1)
printHtmlPart(41)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1571036688000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
