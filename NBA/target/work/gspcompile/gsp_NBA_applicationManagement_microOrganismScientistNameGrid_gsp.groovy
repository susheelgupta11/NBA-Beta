import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_NBA_applicationManagement_microOrganismScientistNameGrid_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/applicationManagement/_microOrganismScientistNameGrid.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createClosureForHtmlPart(1, 1)
invokeTag('link','g',36,['controller':("applicationManagement"),'post':("true"),'action':("deleteProfile"),'params':([formType:formType,appFormId:appForm?.id,csrfPreventionSalt:"${csrfPreventionSalt}"]),'class':("btn btn-success")],1)
printHtmlPart(2)
if(true && (listOfScientistName?.size() > 0)) {
printHtmlPart(3)
if(true && (listOfScientistName)) {
printHtmlPart(4)
}
printHtmlPart(5)

int i=1

printHtmlPart(6)
for( profile in (listOfScientistName) ) {
printHtmlPart(7)
out.print(i)
printHtmlPart(8)
expressionOut.print(profile?.scientistName)
printHtmlPart(9)
if(true && (microOrgaScirntistName || deleteCalled)) {
printHtmlPart(10)
createClosureForHtmlPart(11, 4)
invokeTag('link','g',77,['controller':("applicationManagement"),'action':("editScientistName"),'onSuccess':(""),'params':([appFormId:appFormId,profileId:profile?.id,formType:formType,csrfPreventionSalt:"${csrfPreventionSalt}"])],4)
printHtmlPart(12)
createClosureForHtmlPart(13, 4)
invokeTag('link','g',82,['controller':("applicationManagement"),'action':("deleteScientistName"),'onclick':("return beforeDelete();"),'params':([profileId:profile?.id,formType:formType,appFormId:appFormId,csrfPreventionSalt:"${csrfPreventionSalt}"])],4)
printHtmlPart(10)
}
else if(true && (!microOrgaScirntistName)) {
printHtmlPart(12)
createClosureForHtmlPart(14, 4)
invokeTag('link','g',90,['controller':("applicationManagement"),'action':("editScientistName"),'onSuccess':(""),'params':([appFormId:appFormId,profileId:profile?.id,formType:formType,csrfPreventionSalt:"${csrfPreventionSalt}"])],4)
printHtmlPart(15)
createClosureForHtmlPart(16, 4)
invokeTag('link','g',95,['controller':("applicationManagement"),'action':("deleteScientistName"),'onclick':("return beforeDelete();"),'params':([profileId:profile?.id,formType:formType,appFormId:appFormId,csrfPreventionSalt:"${csrfPreventionSalt}"])],4)
printHtmlPart(12)
}
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
