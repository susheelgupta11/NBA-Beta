import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_NBA_applicationManagement_formCForeignRepositoryGrid_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/applicationManagement/_formCForeignRepositoryGrid.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createClosureForHtmlPart(1, 1)
invokeTag('link','g',36,['controller':("applicationManagement"),'post':("true"),'action':("deleteProfile"),'params':([formType:formType,appFormId:appForm?.id,csrfPreventionSalt:"${csrfPreventionSalt}"]),'class':("btn btn-success")],1)
printHtmlPart(2)
if(true && (listOfContactDetailsOfRepository?.size() > 0)) {
printHtmlPart(3)
if(true && (listOfContactDetailsOfRepository)) {
printHtmlPart(4)
}
printHtmlPart(5)

int i=1

printHtmlPart(6)
for( profile in (listOfContactDetailsOfRepository) ) {
printHtmlPart(7)
out.print(i)
printHtmlPart(8)
expressionOut.print(profile?.repostoryName)
printHtmlPart(9)
expressionOut.print(profile?.address1)
printHtmlPart(10)
expressionOut.print(profile?.address2)
printHtmlPart(10)
expressionOut.print(profile?.address3)
printHtmlPart(10)
expressionOut.print(profile?.city)
printHtmlPart(11)
expressionOut.print(profile?.state)
printHtmlPart(10)
expressionOut.print(profile?.country?.country)
printHtmlPart(12)
expressionOut.print(profile?.mobile)
printHtmlPart(12)
expressionOut.print(profile?.phone)
printHtmlPart(12)
expressionOut.print(profile?.email)
printHtmlPart(13)
createClosureForHtmlPart(14, 3)
invokeTag('link','g',93,['controller':("applicationManagement"),'action':("editDepositionOfMicroOrganism"),'onSuccess':(""),'params':([appFormId:appForm?.id,profileId:profile?.id,formType:formType,csrfPreventionSalt:"${csrfPreventionSalt}"])],3)
printHtmlPart(15)
createClosureForHtmlPart(16, 3)
invokeTag('link','g',98,['controller':("applicationManagement"),'action':("deleteDepositionOfMicroOrganism"),'onclick':("return beforeDelete();"),'params':([profileId:profile?.id,formType:formType,appFormId:appForm?.id,csrfPreventionSalt:"${csrfPreventionSalt}"])],3)
printHtmlPart(17)

i++

printHtmlPart(18)
}
printHtmlPart(19)
}
printHtmlPart(20)
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
