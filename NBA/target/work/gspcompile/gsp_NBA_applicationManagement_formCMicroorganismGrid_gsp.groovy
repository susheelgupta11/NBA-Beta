import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_NBA_applicationManagement_formCMicroorganismGrid_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/applicationManagement/_formCMicroorganismGrid.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)

int i=1

printHtmlPart(1)
loop:{
int k = 0
for( profile in (locations) ) {
printHtmlPart(2)
out.print(i)
printHtmlPart(3)
expressionOut.print(profile?.bioResource?.scientistName)
printHtmlPart(4)
expressionOut.print(profile?.source)
printHtmlPart(5)
if(true && (profile?.village)) {
printHtmlPart(6)
expressionOut.print(profile?.village)
printHtmlPart(7)
}
else {
printHtmlPart(8)
}
printHtmlPart(9)
if(true && (profile?.town)) {
printHtmlPart(6)
expressionOut.print(profile?.town)
printHtmlPart(7)
}
else {
printHtmlPart(8)
}
printHtmlPart(9)
if(true && (profile?.district)) {
printHtmlPart(6)
expressionOut.print(profile?.district)
printHtmlPart(7)
}
else {
printHtmlPart(8)
}
printHtmlPart(9)
if(true && (profile?.state)) {
printHtmlPart(6)
expressionOut.print(profile?.state)
printHtmlPart(7)
}
else {
printHtmlPart(8)
}
printHtmlPart(9)
if(true && (profile?.traderName)) {
printHtmlPart(6)
expressionOut.print(profile?.traderName)
printHtmlPart(7)
}
else {
printHtmlPart(10)
}
printHtmlPart(9)
if(true && (profile?.traderContactDetails)) {
printHtmlPart(6)
expressionOut.print(profile?.traderContactDetails)
printHtmlPart(7)
}
else {
printHtmlPart(10)
}
printHtmlPart(9)
if(true && (microOrgaScirntistName || deleteCalled)) {
printHtmlPart(6)
createClosureForHtmlPart(11, 3)
invokeTag('link','g',91,['controller':("applicationManagement"),'action':("editGeoMicroOrganism"),'onSuccess':(""),'params':([profileId:profile?.id,bioresourceId:bioresource?.id,formType:formType,appFormId:appFormId,csrfPreventionSalt:"${csrfPreventionSalt}"])],3)
printHtmlPart(6)
createClosureForHtmlPart(12, 3)
invokeTag('link','g',97,['controller':("applicationManagement"),'action':("deleteGeoMicroOrganism"),'onclick':("return beforeDelete();"),'params':([profileId:profile?.id,formType:formType,appFormId:appFormId,csrfPreventionSalt:"${csrfPreventionSalt}"])],3)
printHtmlPart(7)
}
else if(true && (!microOrgaScirntistName)) {
printHtmlPart(6)
createClosureForHtmlPart(13, 3)
invokeTag('link','g',104,['controller':("applicationManagement"),'action':("editGeoMicroOrganism"),'onSuccess':(""),'params':([profileId:profile?.id,bioresourceId:bioresource?.id,formType:formType,appFormId:appFormId,csrfPreventionSalt:"${csrfPreventionSalt}"])],3)
printHtmlPart(6)
createClosureForHtmlPart(14, 3)
invokeTag('link','g',110,['controller':("applicationManagement"),'action':("deleteGeoMicroOrganism"),'onclick':("return beforeDelete();"),'params':([profileId:profile?.id,formType:formType,appFormId:appFormId,csrfPreventionSalt:"${csrfPreventionSalt}"])],3)
printHtmlPart(7)
}
printHtmlPart(15)

i++

printHtmlPart(16)
k++
}
}
printHtmlPart(17)
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
