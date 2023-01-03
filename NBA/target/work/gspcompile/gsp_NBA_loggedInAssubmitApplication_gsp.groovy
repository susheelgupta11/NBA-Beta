import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_NBA_loggedInAssubmitApplication_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/loggedInAs/submitApplication.gsp" }
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
printHtmlPart(1)
createTagBody(1, {->
printHtmlPart(4)
createClosureForHtmlPart(5, 2)
invokeTag('link','g',29,['controller':("applicationManagement"),'action':("selectIndividualOrCompany"),'class':("form-link-btn"),'params':([formType:"Form1",currentUser:currentUser]),'data-toggle':("tooltip"),'title':("Click here to apply")],2)
printHtmlPart(6)
createClosureForHtmlPart(7, 2)
invokeTag('link','g',47,['controller':("applicationManagement"),'action':("selectIndividualOrCompany"),'class':("form-link-btn"),'params':([formType:"Form2",currentUser:currentUser]),'data-toggle':("tooltip"),'title':("Click here to apply")],2)
printHtmlPart(8)
createClosureForHtmlPart(9, 2)
invokeTag('link','g',62,['controller':("applicationManagement"),'action':("selectIndividualOrCompany"),'class':("form-link-btn"),'params':([formType:"Form3",currentUser:currentUser]),'data-toggle':("tooltip"),'title':("Click here to apply")],2)
printHtmlPart(10)
createClosureForHtmlPart(11, 2)
invokeTag('link','g',75,['controller':("applicationManagement"),'action':("selectIndividualOrCompany"),'class':("form-link-btn"),'params':([formType:"Form4",currentUser:currentUser]),'data-toggle':("tooltip"),'title':("Click here to apply")],2)
printHtmlPart(12)
createClosureForHtmlPart(13, 2)
invokeTag('link','g',88,['controller':("formB"),'action':("researcherOrGovermentInst"),'class':("form-link-btn"),'params':([formType:"FormB",currentUser:currentUser,csrfPreventionSalt:"${csrfPreventionSalt}"]),'data-toggle':("tooltip"),'title':("Click here to apply")],2)
printHtmlPart(14)
createClosureForHtmlPart(15, 2)
invokeTag('link','g',102,['controller':("applicationManagement"),'action':("depositionOfMicroOrganism"),'class':("form-link-btn"),'params':([formType:"FormC",currentUser:currentUser]),'data-toggle':("tooltip"),'title':("Click here to apply")],2)
printHtmlPart(16)
})
invokeTag('captureBody','sitemesh',121,[:],1)
printHtmlPart(17)
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
