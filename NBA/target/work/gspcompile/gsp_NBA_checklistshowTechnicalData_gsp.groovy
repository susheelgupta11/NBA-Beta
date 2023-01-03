import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_NBA_checklistshowTechnicalData_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/checklist/showTechnicalData.gsp" }
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
invokeTag('captureHead','sitemesh',12,[:],1)
printHtmlPart(1)
createTagBody(1, {->
printHtmlPart(4)
if(true && (message)) {
printHtmlPart(5)
expressionOut.print(message)
printHtmlPart(6)
}
printHtmlPart(7)
createTagBody(2, {->
printHtmlPart(8)
if(true && (subForm == "1")) {
printHtmlPart(9)
invokeTag('render','g',31,['template':("form1Review")],-1)
printHtmlPart(8)
}
printHtmlPart(8)
if(true && (subForm == "2")) {
printHtmlPart(9)
invokeTag('render','g',34,['template':("form2Review")],-1)
printHtmlPart(8)
}
printHtmlPart(8)
if(true && (subForm == "3")) {
printHtmlPart(9)
invokeTag('render','g',37,['template':("form3Review")],-1)
printHtmlPart(8)
}
printHtmlPart(8)
if(true && (subForm == "4")) {
printHtmlPart(9)
invokeTag('render','g',40,['template':("form4Review")],-1)
printHtmlPart(8)
}
printHtmlPart(8)
if(true && (subForm == "B")) {
printHtmlPart(9)
invokeTag('render','g',43,['template':("formBReview")],-1)
printHtmlPart(8)
}
printHtmlPart(8)
invokeTag('hiddenField','g',45,['name':("formTpe"),'value':(subForm)],-1)
printHtmlPart(8)
invokeTag('hiddenField','g',47,['name':("frmId"),'value':(formDetails?.id)],-1)
printHtmlPart(8)
invokeTag('hiddenField','g',48,['name':("listId"),'value':(formDetails?.id)],-1)
printHtmlPart(8)
invokeTag('hiddenField','g',49,['name':("checkInstance"),'value':(formRemkInstance?.id)],-1)
printHtmlPart(8)
invokeTag('hiddenField','g',50,['name':("formType"),'value':(formType)],-1)
printHtmlPart(8)
invokeTag('hiddenField','g',51,['name':("csrfPreventionSalt"),'value':(csrfPreventionSalt)],-1)
printHtmlPart(10)
createClosureForHtmlPart(11, 3)
invokeTag('link','g',59,['class':("btn btn-primary pull-right"),'action':("technicalCheckList"),'target':("_blank"),'params':([remark:formRemkInstance?.id,instance:formDetails?.id,csrfPreventionSalt:csrfPreventionSalt]),'style':("margin-right: 15px;")],3)
printHtmlPart(12)
})
invokeTag('form','g',60,['controller':("checklist"),'action':("techFormRemarkSave")],2)
printHtmlPart(13)
invokeTag('render','g',63,['template':("/rightPane/matchdata")],-1)
printHtmlPart(14)
})
invokeTag('captureBody','sitemesh',65,[:],1)
printHtmlPart(15)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1670223250160L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
