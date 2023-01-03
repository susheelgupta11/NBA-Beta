import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_NBA_form3part5_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/form3/part5.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',6,['gsp_sm_xmlClosingForEmptyTag':("/"),'name':("layout"),'content':("loggedInUser")],-1)
printHtmlPart(2)
createTagBody(2, {->
createClosureForHtmlPart(3, 3)
invokeTag('captureTitle','sitemesh',8,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',8,[:],2)
printHtmlPart(2)
})
invokeTag('captureHead','sitemesh',10,[:],1)
printHtmlPart(4)
createTagBody(1, {->
printHtmlPart(5)
createClosureForHtmlPart(6, 2)
invokeTag('link','g',32,['controller':("applicationManagement"),'post':("true"),'action':("changeAppStatus"),'params':([appFormId:appForm?.id,formType:formType]),'class':("btn btn-success")],2)
printHtmlPart(7)
invokeTag('render','g',46,['template':("/applicationManagement/leftTabs"),'model':([formType:formType])],-1)
printHtmlPart(8)
if(true && (declarationForm?.document)) {
printHtmlPart(9)
createTagBody(3, {->
printHtmlPart(10)
expressionOut.print(declarationForm?.docName)
printHtmlPart(9)
})
invokeTag('link','g',84,['controller':("applicationManagement"),'action':("showDeclarationForm"),'id':(declarationForm?.id),'target':("_blank"),'params':([filename: 'declarationFormName', dataName: 'declarationFormName'])],3)
printHtmlPart(11)
}
printHtmlPart(12)
createTagBody(2, {->
printHtmlPart(13)
expressionOut.print(csrfPreventionSalt)
printHtmlPart(14)
if(true && (appForm?.declarationForm)) {
printHtmlPart(9)
createTagBody(4, {->
printHtmlPart(10)
expressionOut.print(appForm?.declarationFormName)
printHtmlPart(9)
})
invokeTag('link','g',102,['controller':("applicationManagement"),'action':("showSignedDeclarationForm"),'id':(appForm?.id),'target':("_blank"),'params':([filename: 'declarationFormName', dataName: 'declarationFormName'])],4)
printHtmlPart(11)
}
printHtmlPart(15)
invokeTag('hiddenField','g',110,['name':("appFormId"),'value':(appForm?.id)],-1)
printHtmlPart(16)
invokeTag('hiddenField','g',111,['name':("formType"),'value':(formType)],-1)
printHtmlPart(17)
})
invokeTag('uploadForm','g',118,['class':("form-horizontal"),'role':("form"),'autocomplete':("off"),'action':("saveForm1Part5")],2)
printHtmlPart(18)
})
invokeTag('captureBody','sitemesh',124,[:],1)
printHtmlPart(19)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1537268164000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
