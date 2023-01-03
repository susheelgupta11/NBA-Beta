import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_NBA_formB_formBFundingAgencyGrid_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/formB/_formBFundingAgencyGrid.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)

int i=1

printHtmlPart(1)
for( agency in (listOfFundingAgency) ) {
printHtmlPart(2)
out.print(i)
printHtmlPart(3)

i++

printHtmlPart(4)
expressionOut.print(agency?.institutionOrganizationName)
printHtmlPart(5)
expressionOut.print(agency?.address1)
printHtmlPart(6)
expressionOut.print(agency?.address2)
printHtmlPart(7)
expressionOut.print(agency?.address3)
printHtmlPart(7)
expressionOut.print(agency?.city)
printHtmlPart(8)
expressionOut.print(agency?.state)
printHtmlPart(6)
expressionOut.print(agency?.country?.country)
printHtmlPart(9)
expressionOut.print(agency?.phone)
printHtmlPart(10)
expressionOut.print(agency?.email)
printHtmlPart(11)
createClosureForHtmlPart(12, 2)
invokeTag('link','g',35,['controller':("formB"),'action':("formBPart3"),'params':([appFormId:appForm?.id,agencyId:agency?.id,formType:formType,csrfPreventionSalt:"${csrfPreventionSalt}"])],2)
printHtmlPart(13)
createClosureForHtmlPart(14, 2)
invokeTag('link','g',41,['controller':("formB"),'action':("deleteFundingAgency"),'params':([appFormId:appForm?.id,agencyId:agency?.id,formType:formType,csrfPreventionSalt:"${csrfPreventionSalt}"])],2)
printHtmlPart(15)
}
printHtmlPart(16)
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
