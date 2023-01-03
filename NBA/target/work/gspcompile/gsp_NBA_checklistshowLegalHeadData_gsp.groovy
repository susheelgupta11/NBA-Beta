import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_NBA_checklistshowLegalHeadData_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/checklist/showLegalHeadData.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',4,['gsp_sm_xmlClosingForEmptyTag':("/"),'http-equiv':("Content-Type"),'content':("text/html; charset=ISO-8859-1")],-1)
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',5,['gsp_sm_xmlClosingForEmptyTag':("/"),'name':("layout"),'content':("dashPage")],-1)
printHtmlPart(1)
createTagBody(2, {->
createClosureForHtmlPart(2, 3)
invokeTag('captureTitle','sitemesh',6,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',6,[:],2)
printHtmlPart(3)
})
invokeTag('captureHead','sitemesh',13,[:],1)
printHtmlPart(1)
createTagBody(1, {->
printHtmlPart(4)
if(true && (formRemkInstance?.violationChk == true)) {
printHtmlPart(1)
createClosureForHtmlPart(5, 3)
invokeTag('javascript','g',21,[:],3)
printHtmlPart(1)
}
printHtmlPart(6)
if(true && (formRemkInstance?.threeTwocheck == false)) {
printHtmlPart(7)
createClosureForHtmlPart(8, 3)
invokeTag('javascript','g',37,[:],3)
printHtmlPart(1)
}
printHtmlPart(1)
if(true && (formRemkInstance?.sevncheck == false)) {
printHtmlPart(1)
createClosureForHtmlPart(9, 3)
invokeTag('javascript','g',42,[:],3)
printHtmlPart(1)
}
printHtmlPart(10)
if(true && (message)) {
printHtmlPart(11)
expressionOut.print(message)
printHtmlPart(12)
}
printHtmlPart(13)
createTagBody(2, {->
printHtmlPart(14)
if(true && (subForm == "1")) {
printHtmlPart(15)
invokeTag('render','g',54,['template':("f1legalReview")],-1)
printHtmlPart(14)
}
else if(true && (subForm == "2")) {
printHtmlPart(15)
invokeTag('render','g',57,['template':("f2legalReview")],-1)
printHtmlPart(14)
}
else if(true && (subForm == "3")) {
printHtmlPart(15)
invokeTag('render','g',60,['template':("f3legalReview")],-1)
printHtmlPart(14)
}
else if(true && (subForm == "4")) {
printHtmlPart(15)
invokeTag('render','g',63,['template':("f4legalReview")],-1)
printHtmlPart(14)
}
else if(true && (subForm == "B")) {
printHtmlPart(15)
invokeTag('render','g',67,['template':("fBlegalReview")],-1)
printHtmlPart(14)
}
printHtmlPart(16)
invokeTag('hiddenField','g',70,['name':("formTpe"),'value':(subForm)],-1)
printHtmlPart(14)
invokeTag('hiddenField','g',71,['name':("frmId"),'value':(formDetails?.id)],-1)
printHtmlPart(14)
invokeTag('hiddenField','g',72,['name':("listId"),'value':(formId)],-1)
printHtmlPart(14)
invokeTag('hiddenField','g',73,['name':("checkInstance"),'value':(formRemkInstance?.id)],-1)
printHtmlPart(17)
invokeTag('hiddenField','g',74,['name':("csrfPreventionSalt"),'value':(csrfPreventionSalt)],-1)
printHtmlPart(18)
invokeTag('hiddenField','g',75,['name':("select"),'id':("setAllSelect"),'value':("")],-1)
printHtmlPart(19)
invokeTag('hiddenField','g',76,['name':("counterVal"),'id':("setCounter"),'value':("")],-1)
printHtmlPart(20)
createClosureForHtmlPart(21, 3)
invokeTag('link','g',84,['controller':("checklist"),'class':("btn btn-primary pull-right"),'action':("legalCheckList"),'target':("_blank"),'params':([remark:formRemkInstance?.id,instance:formDetails?.id,csrfPreventionSalt:csrfPreventionSalt]),'style':("margin-right: 15px;")],3)
printHtmlPart(22)
})
invokeTag('form','g',84,['controller':("checklist"),'action':("legalFormRemarkSave")],2)
printHtmlPart(23)
invokeTag('render','g',90,['template':("/rightPane/matchdata")],-1)
printHtmlPart(24)
})
invokeTag('captureBody','sitemesh',111,[:],1)
printHtmlPart(25)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1645081144995L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
