import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_NBA_applicationManagement_individualProfileGrid_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/applicationManagement/_individualProfileGrid.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createClosureForHtmlPart(1, 1)
invokeTag('link','g',36,['controller':("applicationManagement"),'post':("true"),'action':("deleteProfile"),'params':([formType:formType,appFormId:appForm?.id,csrfPreventionSalt:"${csrfPreventionSalt}"]),'class':("btn btn-success")],1)
printHtmlPart(2)
if(true && (listOfIndividualProfiles?.size() > 0)) {
printHtmlPart(3)
if(true && (listOfIndividualProfiles)) {
printHtmlPart(4)
}
printHtmlPart(5)

int i=1

printHtmlPart(6)
for( profile in (listOfIndividualProfiles) ) {
printHtmlPart(7)
out.print(i)
printHtmlPart(8)
expressionOut.print(profile?.title)
printHtmlPart(9)
expressionOut.print(profile?.firstName)
printHtmlPart(9)
expressionOut.print(profile?.middleName)
printHtmlPart(9)
expressionOut.print(profile?.lastName)
printHtmlPart(10)
expressionOut.print(profile?.profile)
printHtmlPart(10)
expressionOut.print(profile?.address1)
printHtmlPart(9)
expressionOut.print(profile?.address2)
printHtmlPart(9)
expressionOut.print(profile?.address3)
printHtmlPart(9)
expressionOut.print(profile?.city)
printHtmlPart(11)
expressionOut.print(profile?.province)
printHtmlPart(9)
expressionOut.print(profile?.country?.country)
printHtmlPart(10)
expressionOut.print(profile?.mobile)
printHtmlPart(10)
expressionOut.print(profile?.phone)
printHtmlPart(10)
expressionOut.print(profile?.email)
printHtmlPart(12)

def listttt =  listOfIndividualProfiles.size() - 1

printHtmlPart(11)
if(true && (individualProfile || deleteCalled)) {
printHtmlPart(13)
createClosureForHtmlPart(14, 4)
invokeTag('link','g',95,['controller':("applicationManagement"),'action':("editIndividualProfile"),'params':([appFormId:appForm?.id,profileId:profile?.id,formType:formType,csrfPreventionSalt:"${csrfPreventionSalt}"])],4)
printHtmlPart(13)
if(true && (listOfIndividualProfiles?.size() == 1)) {
printHtmlPart(15)
createClosureForHtmlPart(16, 5)
invokeTag('link','g',101,['controller':("applicationManagement"),'action':("deleteProfile"),'onclick':("return beforeDelete();"),'params':([profileId:profile?.id,formType:formType,appFormId:appForm?.id,csrfPreventionSalt:"${csrfPreventionSalt}"])],5)
printHtmlPart(13)
}
else {
printHtmlPart(15)
createClosureForHtmlPart(16, 5)
invokeTag('link','g',108,['controller':("applicationManagement"),'action':("deleteProfile"),'params':([profileId:profile?.id,formType:formType,appFormId:appForm?.id,csrfPreventionSalt:"${csrfPreventionSalt}"])],5)
printHtmlPart(13)
}
printHtmlPart(17)
}
else if(true && (!individualProfile)) {
printHtmlPart(13)
createClosureForHtmlPart(18, 4)
invokeTag('link','g',117,['controller':("applicationManagement"),'action':("editIndividualProfile"),'onSuccess':("updateCountry(null,${profile?.nationality})"),'params':([appFormId:appForm?.id,profileId:profile?.id,formType:formType,csrfPreventionSalt:"${csrfPreventionSalt}"])],4)
printHtmlPart(13)
if(true && (listOfIndividualProfiles?.size() == 1)) {
printHtmlPart(15)
createClosureForHtmlPart(19, 5)
invokeTag('link','g',123,['controller':("applicationManagement"),'action':("deleteProfile"),'onclick':("return beforeDelete();"),'params':([profileId:profile?.id,formType:formType,appFormId:appForm?.id,csrfPreventionSalt:"${csrfPreventionSalt}"])],5)
printHtmlPart(13)
}
else {
printHtmlPart(15)
createClosureForHtmlPart(19, 5)
invokeTag('link','g',130,['controller':("applicationManagement"),'action':("deleteProfile"),'params':([profileId:profile?.id,formType:formType,appFormId:appForm?.id,csrfPreventionSalt:"${csrfPreventionSalt}"])],5)
printHtmlPart(13)
}
printHtmlPart(20)
}
printHtmlPart(21)

i++

printHtmlPart(22)
}
printHtmlPart(23)
}
printHtmlPart(24)
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
