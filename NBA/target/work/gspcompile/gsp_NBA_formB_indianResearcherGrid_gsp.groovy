import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_NBA_formB_indianResearcherGrid_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/formB/_indianResearcherGrid.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createClosureForHtmlPart(1, 1)
invokeTag('link','g',36,['controller':("applicationManagement"),'post':("true"),'action':("deleteProfile"),'params':([formType:formType,appFormId:appForm?.id,csrfPreventionSalt:"${csrfPreventionSalt}"]),'class':("btn btn-success")],1)
printHtmlPart(2)
if(true && (listOfIndianResearcher?.size() > 0)) {
printHtmlPart(3)
if(true && (listOfIndianResearcher)) {
printHtmlPart(4)
}
printHtmlPart(5)

int i=1

printHtmlPart(6)
for( profile in (listOfIndianResearcher) ) {
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
printHtmlPart(12)
expressionOut.print(profile?.mobile)
printHtmlPart(12)
expressionOut.print(profile?.phone)
printHtmlPart(12)
expressionOut.print(profile?.email)
printHtmlPart(13)

def listttt =  listOfIndianResearcher.size() - 1

printHtmlPart(11)
if(true && (indianResearcher || deleteCalled)) {
printHtmlPart(14)
createClosureForHtmlPart(15, 4)
invokeTag('link','g',92,['controller':("formB"),'action':("editIndianResearcher"),'params':([appFormId:appForm?.id,profileId:profile?.id,formType:formType,csrfPreventionSalt:"${csrfPreventionSalt}"])],4)
printHtmlPart(14)
if(true && (listOfIndianResearcher?.size() == 1)) {
printHtmlPart(16)
createClosureForHtmlPart(17, 5)
invokeTag('link','g',98,['controller':("applicationManagement"),'action':("deleteIndianReasearcherProfile"),'onclick':("return beforeDelete();"),'params':([profileId:profile?.id,formType:formType,appFormId:appForm?.id,csrfPreventionSalt:"${csrfPreventionSalt}"])],5)
printHtmlPart(14)
}
else {
printHtmlPart(16)
createClosureForHtmlPart(17, 5)
invokeTag('link','g',105,['controller':("formB"),'action':("deleteIndianReasearcherProfile"),'params':([profileId:profile?.id,formType:formType,appFormId:appForm?.id,csrfPreventionSalt:"${csrfPreventionSalt}"])],5)
printHtmlPart(14)
}
printHtmlPart(18)
}
else if(true && (!indianResearcher)) {
printHtmlPart(14)
createClosureForHtmlPart(19, 4)
invokeTag('link','g',114,['controller':("formB"),'action':("editIndianResearcher"),'onSuccess':("updateCountry(null,${profile?.nationality})"),'params':([appFormId:appForm?.id,profileId:profile?.id,formType:formType,csrfPreventionSalt:"${csrfPreventionSalt}"])],4)
printHtmlPart(14)
if(true && (listOfIndianResearcher?.size() == 1)) {
printHtmlPart(16)
createClosureForHtmlPart(20, 5)
invokeTag('link','g',120,['controller':("applicationManagement"),'action':("deleteIndianReasearcherProfile"),'onclick':("return beforeDelete();"),'params':([profileId:profile?.id,formType:formType,appFormId:appForm?.id,csrfPreventionSalt:"${csrfPreventionSalt}"])],5)
printHtmlPart(14)
}
else {
printHtmlPart(16)
createClosureForHtmlPart(20, 5)
invokeTag('link','g',127,['controller':("formB"),'action':("deleteIndianReasearcherProfile"),'params':([profileId:profile?.id,formType:formType,appFormId:appForm?.id,csrfPreventionSalt:"${csrfPreventionSalt}"])],5)
printHtmlPart(14)
}
printHtmlPart(21)
}
printHtmlPart(22)

i++

printHtmlPart(23)
}
printHtmlPart(24)
}
printHtmlPart(25)
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
