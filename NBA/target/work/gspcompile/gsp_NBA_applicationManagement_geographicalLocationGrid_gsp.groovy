import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_NBA_applicationManagement_geographicalLocationGrid_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/applicationManagement/_geographicalLocationGrid.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
if(true && (listOfLocations)) {
printHtmlPart(1)

int i=1

printHtmlPart(1)
for( location in (listOfLocations) ) {
printHtmlPart(2)
out.print(i)
printHtmlPart(3)

i++

printHtmlPart(4)
expressionOut.print(location?.bioResource?.scientificName)
printHtmlPart(5)
expressionOut.print(location?.source)
printHtmlPart(6)
if(true && (location?.village)) {
printHtmlPart(7)
expressionOut.print(location?.village)
printHtmlPart(8)
}
else {
printHtmlPart(9)
}
printHtmlPart(10)
if(true && (location?.town)) {
printHtmlPart(11)
expressionOut.print(location?.town)
printHtmlPart(8)
}
else {
printHtmlPart(9)
}
printHtmlPart(12)
if(true && (location?.district)) {
printHtmlPart(7)
expressionOut.print(location?.district)
printHtmlPart(8)
}
else {
printHtmlPart(9)
}
printHtmlPart(12)
if(true && (location?.state)) {
printHtmlPart(11)
expressionOut.print(location?.state)
printHtmlPart(8)
}
else {
printHtmlPart(9)
}
printHtmlPart(12)
if(true && (location?.traderName)) {
printHtmlPart(7)
expressionOut.print(location?.traderName)
printHtmlPart(8)
}
else {
printHtmlPart(9)
}
printHtmlPart(12)
if(true && (location?.traderContactDetails)) {
printHtmlPart(11)
expressionOut.print(location?.traderContactDetails)
printHtmlPart(8)
}
else {
printHtmlPart(9)
}
printHtmlPart(13)
createClosureForHtmlPart(14, 3)
invokeTag('remoteLink','g',82,['controller':("applicationManagement"),'onSuccess':("ReadonlyRecode_Edit()"),'action':("editGeoLocation"),'update':("geographicalLocationForm"),'params':([locationId:location?.id,formType:formType,appFormId:appForm?.id,csrfPreventionSalt:"${csrfPreventionSalt}"])],3)
printHtmlPart(15)
createClosureForHtmlPart(16, 3)
invokeTag('remoteLink','g',87,['controller':("applicationManagement"),'action':("deleteGeoLocation"),'update':("updateGeoLocation"),'onSuccess':("loadPage()"),'params':([locationId:location?.id,formType:formType,appFormId:appForm?.id,csrfPreventionSalt:"${csrfPreventionSalt}"])],3)
printHtmlPart(17)
}
printHtmlPart(18)
}
else {
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
