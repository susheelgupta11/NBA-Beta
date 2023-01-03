import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_NBA_formB_indianGovtInstGrid_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/formB/_indianGovtInstGrid.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createClosureForHtmlPart(1, 1)
invokeTag('link','g',36,['controller':("applicationManagement"),'post':("true"),'action':("deleteProfile"),'params':([formType:formType,appFormId:appForm?.id,csrfPreventionSalt:"${csrfPreventionSalt}"]),'class':("btn btn-success")],1)
printHtmlPart(2)
if(true && (listOfIndianGovtInst?.size() > 0)) {
printHtmlPart(3)
if(true && (listOfIndianGovtInst)) {
printHtmlPart(4)
}
printHtmlPart(5)

int i=1

printHtmlPart(6)
for( profile in (listOfIndianGovtInst) ) {
printHtmlPart(7)
out.print(i)
printHtmlPart(8)
expressionOut.print(profile?.govtInstName)
printHtmlPart(9)
expressionOut.print(profile?.address1)
printHtmlPart(10)
expressionOut.print(profile?.address2)
printHtmlPart(10)
expressionOut.print(profile?.address3)
printHtmlPart(10)
expressionOut.print(profile?.city)
printHtmlPart(11)
expressionOut.print(profile?.province)
printHtmlPart(10)
expressionOut.print(profile?.country?.country)
printHtmlPart(12)
expressionOut.print(profile?.phone)
printHtmlPart(13)
expressionOut.print(profile?.email)
printHtmlPart(14)

def listttt =  listOfIndianGovtInst.size() - 1

printHtmlPart(11)
if(true && (indianGovtInst || deleteCalled)) {
printHtmlPart(15)
createClosureForHtmlPart(16, 4)
invokeTag('link','g',90,['controller':("formB"),'action':("editIndianGovtInst"),'params':([appFormId:appForm?.id,profileId:profile?.id,formType:formType,csrfPreventionSalt:"${csrfPreventionSalt}"])],4)
printHtmlPart(15)
if(true && (listOfIndianGovtInst?.size() == 1)) {
printHtmlPart(17)
createClosureForHtmlPart(18, 5)
invokeTag('link','g',96,['controller':("formB"),'action':("deleteIndianGovtInst"),'onclick':("return beforeDelete();"),'params':([profileId:profile?.id,formType:formType,appFormId:appForm?.id,csrfPreventionSalt:"${csrfPreventionSalt}"])],5)
printHtmlPart(15)
}
else {
printHtmlPart(17)
createClosureForHtmlPart(18, 5)
invokeTag('link','g',103,['controller':("formB"),'action':("deleteIndianGovtInst"),'params':([profileId:profile?.id,formType:formType,appFormId:appForm?.id,csrfPreventionSalt:"${csrfPreventionSalt}"])],5)
printHtmlPart(15)
}
printHtmlPart(19)
}
else if(true && (!indianGovtInst)) {
printHtmlPart(15)
createClosureForHtmlPart(20, 4)
invokeTag('link','g',112,['controller':("formB"),'action':("editIndianGovtInst"),'onSuccess':(""),'params':([appFormId:appForm?.id,profileId:profile?.id,formType:formType,csrfPreventionSalt:"${csrfPreventionSalt}"])],4)
printHtmlPart(15)
if(true && (listOfIndianGovtInst?.size() == 1)) {
printHtmlPart(17)
createClosureForHtmlPart(21, 5)
invokeTag('link','g',118,['controller':("formB"),'action':("deleteIndianGovtInst"),'onclick':("return beforeDelete();"),'params':([profileId:profile?.id,formType:formType,appFormId:appForm?.id,csrfPreventionSalt:"${csrfPreventionSalt}"])],5)
printHtmlPart(15)
}
else {
printHtmlPart(17)
createClosureForHtmlPart(21, 5)
invokeTag('link','g',125,['controller':("formB"),'action':("deleteIndianGovtInst"),'params':([profileId:profile?.id,formType:formType,appFormId:appForm?.id,csrfPreventionSalt:"${csrfPreventionSalt}"])],5)
printHtmlPart(15)
}
printHtmlPart(22)
}
printHtmlPart(23)

i++

printHtmlPart(24)
}
printHtmlPart(25)
}
printHtmlPart(26)
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
