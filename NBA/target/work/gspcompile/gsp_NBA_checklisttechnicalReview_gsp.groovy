import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_NBA_checklisttechnicalReview_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/checklist/technicalReview.gsp" }
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
printHtmlPart(2)
invokeTag('link','asset',8,['rel':("stylesheet"),'href':("https://cdnjs.cloudflare.com/ajax/libs/bootstrap-multiselect/0.9.13/css/bootstrap-multiselect.css")],-1)
printHtmlPart(1)
invokeTag('link','asset',10,['rel':("stylesheet"),'href':("https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css")],-1)
printHtmlPart(2)
createTagBody(2, {->
createClosureForHtmlPart(3, 3)
invokeTag('captureTitle','sitemesh',12,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',12,[:],2)
printHtmlPart(4)
})
invokeTag('captureHead','sitemesh',45,[:],1)
printHtmlPart(1)
createTagBody(1, {->
printHtmlPart(5)
if(true && (formRemkInstance?.sbbBmc == true)) {
printHtmlPart(6)
createClosureForHtmlPart(7, 3)
invokeTag('javascript','g',52,[:],3)
printHtmlPart(5)
}
else {
printHtmlPart(6)
createClosureForHtmlPart(8, 3)
invokeTag('javascript','g',60,[:],3)
printHtmlPart(5)
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
invokeTag('render','g',83,['template':("form1Review")],-1)
printHtmlPart(13)
}
printHtmlPart(13)
if(true && (subForm == "2")) {
printHtmlPart(14)
invokeTag('render','g',85,['template':("form2Review")],-1)
printHtmlPart(13)
}
printHtmlPart(13)
if(true && (subForm == "3")) {
printHtmlPart(14)
invokeTag('render','g',88,['template':("form3Review")],-1)
printHtmlPart(13)
}
printHtmlPart(13)
if(true && (subForm == "4")) {
printHtmlPart(14)
invokeTag('render','g',91,['template':("form4Review")],-1)
printHtmlPart(13)
}
printHtmlPart(13)
if(true && (subForm == "B")) {
printHtmlPart(14)
invokeTag('render','g',94,['template':("formBReview")],-1)
printHtmlPart(13)
}
printHtmlPart(13)
invokeTag('hiddenField','g',97,['name':("formTpe"),'value':(subForm)],-1)
printHtmlPart(13)
invokeTag('hiddenField','g',98,['name':("frmId"),'value':(formDetails?.id)],-1)
printHtmlPart(13)
invokeTag('hiddenField','g',99,['name':("listId"),'value':(formId)],-1)
printHtmlPart(13)
invokeTag('hiddenField','g',101,['name':("checkInstance"),'value':(formRemkInstance?.id)],-1)
printHtmlPart(13)
invokeTag('hiddenField','g',102,['name':("formType"),'value':(formType)],-1)
printHtmlPart(13)
invokeTag('hiddenField','g',104,['name':("counterVal"),'id':("setCounter"),'value':("")],-1)
printHtmlPart(13)
invokeTag('hiddenField','g',105,['name':("csrfPreventionSalt"),'value':(csrfPreventionSalt)],-1)
printHtmlPart(15)
invokeTag('hiddenField','g',107,['name':("bioResourceNumber"),'value':(formDetails?.biologicalResources.size())],-1)
printHtmlPart(16)
invokeTag('set','g',110,['var':("loctionGio"),'value':(formDetails?.biologicalResources?.locations?.flatten())],-1)
printHtmlPart(17)
invokeTag('hiddenField','g',112,['name':("locationNumber"),'value':(loctionGio.size())],-1)
printHtmlPart(13)
invokeTag('hiddenField','g',116,['name':("contactNumber"),'value':(formDetails?.contactPersons.size())],-1)
printHtmlPart(18)
})
invokeTag('form','g',122,['controller':("checklist"),'action':("techFormRemarkSave")],2)
printHtmlPart(19)
invokeTag('render','g',131,['template':("/rightPane/matchdata")],-1)
printHtmlPart(20)
})
invokeTag('captureBody','sitemesh',159,[:],1)
printHtmlPart(21)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1668681774073L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
