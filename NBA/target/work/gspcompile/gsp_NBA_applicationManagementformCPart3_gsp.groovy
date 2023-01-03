import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_NBA_applicationManagementformCPart3_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/applicationManagement/formCPart3.gsp" }
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
invokeTag('captureHead','sitemesh',22,[:],1)
printHtmlPart(4)
createTagBody(1, {->
printHtmlPart(5)
createTagBody(2, {->
printHtmlPart(6)
expressionOut.print(tabStatus)
printHtmlPart(7)
})
invokeTag('javascript','g',27,[:],2)
printHtmlPart(8)
invokeTag('render','g',33,['template':("leftTabs"),'model':([formType:formType,appForm:appForm])],-1)
printHtmlPart(9)
invokeTag('render','g',58,['template':("formCForeignRepository"),'model':([appForm:appFormId,formType:formType,foreignRepo:foreignRepo,csrfPreventionSalt:"${csrfPreventionSalt}",
						listOfForeignCountries:listOfForeignCountries,listOfContactDetailsOfRepository:listOfContactDetailsOfRepository,listOfCountries:listOfCountries,listOfStates:listOfStates])],-1)
printHtmlPart(10)
invokeTag('render','g',64,['template':("formCRepository"),'model':([appForm:appFormId,applicationform:applicationform,formType:formType,csrfPreventionSalt:"${csrfPreventionSalt}"])],-1)
printHtmlPart(11)
invokeTag('render','g',70,['template':("formCIndianRepository"),'model':([appForm:appFormId,formType:formType,indianRepo:indianRepo,indianCountries:indianCountries,listOfContactDetailsOfRepository:listOfContactDetailsOfRepository,
						listOfCountries:listOfCountries,listOfStates:listOfStates,csrfPreventionSalt:"${csrfPreventionSalt}"])],-1)
printHtmlPart(12)
createTagBody(2, {->
printHtmlPart(13)
expressionOut.print(indianRepoForAccession?.accessionNumber)
printHtmlPart(14)
invokeTag('hiddenField','g',89,['name':("appFormId"),'value':(appFormId)],-1)
printHtmlPart(15)
invokeTag('hiddenField','g',90,['name':("csrfPreventionSalt"),'value':(csrfPreventionSalt)],-1)
printHtmlPart(15)
invokeTag('hiddenField','g',91,['name':("formType"),'value':(formType)],-1)
printHtmlPart(15)
invokeTag('hiddenField','g',92,['name':("profileId"),'value':(indianRepoForAccession?.id)],-1)
printHtmlPart(16)
})
invokeTag('form','g',97,['action':("submitAccessionNumber")],2)
printHtmlPart(17)
createClosureForHtmlPart(18, 2)
invokeTag('link','g',111,['controller':("applicationManagement"),'action':("formCPart2"),'class':("btn btn-primary"),'params':([appFormId:appFormId,formType:formType,csrfPreventionSalt:"${csrfPreventionSalt}"])],2)
printHtmlPart(19)
createClosureForHtmlPart(20, 2)
invokeTag('link','g',115,['controller':("applicationManagement"),'action':("formCPart4"),'class':("btn  btn-primary pull-right"),'params':([appFormId:appFormId,formType:formType,csrfPreventionSalt:"${csrfPreventionSalt}"])],2)
printHtmlPart(21)
})
invokeTag('captureBody','sitemesh',131,[:],1)
printHtmlPart(22)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1537268166000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
