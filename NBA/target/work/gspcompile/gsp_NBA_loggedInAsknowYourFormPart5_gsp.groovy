import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_NBA_loggedInAsknowYourFormPart5_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/loggedInAs/knowYourFormPart5.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',5,['gsp_sm_xmlClosingForEmptyTag':("/"),'name':("layout"),'content':("loggedInUser")],-1)
printHtmlPart(2)
createTagBody(2, {->
createClosureForHtmlPart(3, 3)
invokeTag('captureTitle','sitemesh',7,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',7,[:],2)
printHtmlPart(1)
})
invokeTag('captureHead','sitemesh',8,[:],1)
printHtmlPart(1)
createTagBody(1, {->
printHtmlPart(4)
if(true && (formNumber == 'form1')) {
printHtmlPart(5)
}
else if(true && (formNumber == 'form2')) {
printHtmlPart(6)
}
else if(true && (formNumber == 'form3')) {
printHtmlPart(7)
}
else if(true && (formNumber == 'form4')) {
printHtmlPart(8)
}
else {
printHtmlPart(9)
}
printHtmlPart(10)
if(true && (formNumber == 'form1')) {
printHtmlPart(11)
}
else if(true && (formNumber == 'form2')) {
printHtmlPart(12)
}
else if(true && (formNumber == 'form3')) {
printHtmlPart(13)
}
else if(true && (formNumber == 'form4')) {
printHtmlPart(14)
}
printHtmlPart(15)
if(true && (formNumber == 'form1' || formNumber == 'form2' || formNumber == 'form3' || formNumber == 'form4')) {
printHtmlPart(16)
expressionOut.print(fee)
printHtmlPart(17)
}
printHtmlPart(18)
createClosureForHtmlPart(19, 2)
invokeTag('link','g',53,['controller':("loggedInAs"),'action':("knowYourFormPart1"),'params':([formType:"Form1",csrfPreventionSalt:"${csrfPreventionSalt}"]),'class':("btn btn-primary pull-left")],2)
printHtmlPart(20)
if(true && (formNumber == 'form1')) {
printHtmlPart(21)
createClosureForHtmlPart(22, 3)
invokeTag('link','g',56,['controller':("applicationManagement"),'action':("selectIndividualOrCompany"),'params':([formType:"Form1",csrfPreventionSalt:"${csrfPreventionSalt}"]),'class':("btn btn-primary pull-right")],3)
printHtmlPart(20)
}
else if(true && (formNumber == 'form2')) {
printHtmlPart(21)
createClosureForHtmlPart(22, 3)
invokeTag('link','g',61,['controller':("applicationManagement"),'action':("selectIndividualOrCompany"),'params':([formType:"Form2",csrfPreventionSalt:"${csrfPreventionSalt}"]),'class':("btn btn-primary pull-right")],3)
printHtmlPart(20)
}
else if(true && (formNumber == 'form3')) {
printHtmlPart(21)
createClosureForHtmlPart(22, 3)
invokeTag('link','g',66,['controller':("applicationManagement"),'action':("selectIndividualOrCompany"),'params':([formType:"Form3",csrfPreventionSalt:"${csrfPreventionSalt}"]),'class':("btn btn-primary pull-right")],3)
printHtmlPart(20)
}
else if(true && (formNumber == 'form4')) {
printHtmlPart(21)
createClosureForHtmlPart(22, 3)
invokeTag('link','g',71,['controller':("applicationManagement"),'action':("selectIndividualOrCompany"),'params':([formType:"Form4",csrfPreventionSalt:"${csrfPreventionSalt}"]),'class':("btn btn-primary pull-right")],3)
printHtmlPart(20)
}
printHtmlPart(23)
})
invokeTag('captureBody','sitemesh',72,[:],1)
printHtmlPart(24)
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
