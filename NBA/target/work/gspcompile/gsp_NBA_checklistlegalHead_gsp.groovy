import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_NBA_checklistlegalHead_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/checklist/legalHead.gsp" }
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
if(true && (formRemkInstance?.threeTwocheck == false)) {
printHtmlPart(5)
createClosureForHtmlPart(6, 3)
invokeTag('javascript','g',25,[:],3)
printHtmlPart(7)
}
printHtmlPart(7)
if(true && (formRemkInstance?.sevncheck == false)) {
printHtmlPart(5)
createClosureForHtmlPart(8, 3)
invokeTag('javascript','g',30,[:],3)
printHtmlPart(7)
}
printHtmlPart(9)
if(true && (message)) {
printHtmlPart(10)
expressionOut.print(message)
printHtmlPart(11)
}
printHtmlPart(12)
createTagBody(2, {->
printHtmlPart(13)
if(true && (subForm == "1")) {
printHtmlPart(14)
invokeTag('render','g',42,['template':("f1legalReview")],-1)
printHtmlPart(13)
}
else if(true && (subForm == "2")) {
printHtmlPart(14)
invokeTag('render','g',45,['template':("f2legalReview")],-1)
printHtmlPart(13)
}
else if(true && (subForm == "3")) {
printHtmlPart(14)
invokeTag('render','g',48,['template':("f3legalReview")],-1)
printHtmlPart(13)
}
else if(true && (subForm == "4")) {
printHtmlPart(14)
invokeTag('render','g',51,['template':("f4legalReview")],-1)
printHtmlPart(13)
}
else if(true && (subForm == "B")) {
printHtmlPart(14)
invokeTag('render','g',54,['template':("fBlegalReview")],-1)
printHtmlPart(13)
}
printHtmlPart(15)
invokeTag('hiddenField','g',57,['name':("formTpe"),'value':(subForm)],-1)
printHtmlPart(13)
invokeTag('hiddenField','g',58,['name':("frmId"),'value':(formDetails?.id)],-1)
printHtmlPart(13)
invokeTag('hiddenField','g',59,['name':("listId"),'value':(formId)],-1)
printHtmlPart(13)
invokeTag('hiddenField','g',61,['name':("checkInstance"),'value':(formRemkInstance?.id)],-1)
printHtmlPart(13)
invokeTag('hiddenField','g',63,['name':("csrfPreventionSalt"),'value':(csrfPreventionSalt)],-1)
printHtmlPart(13)
invokeTag('hiddenField','g',64,['name':("select"),'id':("setAllSelect"),'value':("")],-1)
printHtmlPart(13)
invokeTag('hiddenField','g',65,['name':("counterVal"),'id':("setCounter"),'value':("")],-1)
printHtmlPart(16)
})
invokeTag('form','g',68,['controller':("checklist"),'action':("legalFormRemarkSave")],2)
printHtmlPart(17)
invokeTag('render','g',72,['template':("/rightPane/matchdata")],-1)
printHtmlPart(18)
})
invokeTag('captureBody','sitemesh',94,[:],1)
printHtmlPart(19)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1620648582724L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
