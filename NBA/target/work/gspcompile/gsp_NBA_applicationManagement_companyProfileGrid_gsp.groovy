import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_NBA_applicationManagement_companyProfileGrid_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/applicationManagement/_companyProfileGrid.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
if(true && (listOfCompanyProfiles)) {
printHtmlPart(1)
}
printHtmlPart(2)

int i=1

printHtmlPart(3)
for( profile in (listOfCompanyProfiles) ) {
printHtmlPart(4)
out.print(i)
printHtmlPart(5)

i++

printHtmlPart(6)
expressionOut.print(profile?.entityName)
printHtmlPart(7)
expressionOut.print(profile?.entityType)
printHtmlPart(7)
expressionOut.print(profile?.address1)
printHtmlPart(8)
expressionOut.print(profile?.address2)
printHtmlPart(8)
expressionOut.print(profile?.address3)
printHtmlPart(8)
expressionOut.print(profile?.city)
printHtmlPart(9)
expressionOut.print(profile?.province)
printHtmlPart(8)
expressionOut.print(profile?.country?.country)
printHtmlPart(10)
expressionOut.print(profile?.mobile)
printHtmlPart(11)
expressionOut.print(profile?.phone)
printHtmlPart(12)
expressionOut.print(profile?.email)
printHtmlPart(13)
expressionOut.print(profile?.website)
printHtmlPart(14)
expressionOut.print(profile?.businessNature)
printHtmlPart(15)
expressionOut.print(profile?.title)
printHtmlPart(8)
expressionOut.print(profile?.firstName)
printHtmlPart(8)
expressionOut.print(profile?.middleName)
printHtmlPart(8)
expressionOut.print(profile?.lastName)
printHtmlPart(16)
expressionOut.print(profile?.designation)
printHtmlPart(17)
expressionOut.print(profile?.personMobile)
printHtmlPart(18)
expressionOut.print(profile?.personEmail)
printHtmlPart(19)
if(true && (companyProfile1 || deleteCompanyCalled)) {
printHtmlPart(9)
createClosureForHtmlPart(20, 3)
invokeTag('link','g',70,['controller':("applicationManagement"),'action':("editCompanyProfile"),'params':([appFormId:appForm?.id,profileId:profile?.id,formType:formType,csrfPreventionSalt:"${csrfPreventionSalt}"])],3)
printHtmlPart(9)
createClosureForHtmlPart(21, 3)
invokeTag('link','g',74,['controller':("applicationManagement"),'action':("deleteCompanyProfile"),'params':([appFormId:appForm?.id,profileId:profile?.id,formType:formType,csrfPreventionSalt:"${csrfPreventionSalt}"])],3)
printHtmlPart(22)
}
else if(true && (!companyProfile1)) {
printHtmlPart(9)
createClosureForHtmlPart(23, 3)
invokeTag('link','g',83,['controller':("applicationManagement"),'action':("editCompanyProfile"),'params':([appFormId:appForm?.id,profileId:profile?.id,formType:formType,csrfPreventionSalt:"${csrfPreventionSalt}"])],3)
printHtmlPart(9)
createClosureForHtmlPart(24, 3)
invokeTag('link','g',88,['controller':("applicationManagement"),'action':("deleteCompanyProfile"),'params':([appFormId:appForm?.id,profileId:profile?.id,formType:formType,csrfPreventionSalt:"${csrfPreventionSalt}"])],3)
printHtmlPart(25)
}
printHtmlPart(26)
}
printHtmlPart(27)
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
