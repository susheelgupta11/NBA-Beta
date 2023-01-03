
import org.nba.common.State

import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_NBA_applicationManagement_geoLocationOfCommunity_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/applicationManagement/_geoLocationOfCommunity.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
if(true && (listOfCommunityLocations)) {
printHtmlPart(1)

int i=1

printHtmlPart(1)
for( location in (listOfCommunityLocations) ) {
printHtmlPart(2)
out.print(i)
printHtmlPart(3)

i++

printHtmlPart(4)
expressionOut.print(location?.communityKnowledge)
printHtmlPart(5)
expressionOut.print(location?.village)
printHtmlPart(6)
expressionOut.print(location?.town)
printHtmlPart(7)
expressionOut.print(location?.district)
printHtmlPart(6)
expressionOut.print(State?.findById(location?.state)?.state)
printHtmlPart(8)
createClosureForHtmlPart(9, 3)
invokeTag('remoteLink','g',43,['controller':("applicationManagement"),'onSuccess':("AddValidationGeographical_edit()"),'action':("form1Part3"),'update':("geoLocationOfCommunityForm"),'params':([locationId:location?.id,formType:formType,appFormId:appForm?.id,csrfPreventionSalt:"${csrfPreventionSalt}"])],3)
printHtmlPart(10)
createClosureForHtmlPart(11, 3)
invokeTag('remoteLink','g',49,['controller':("applicationManagement"),'action':("deleteGeoLocationOfCommunity"),'update':("updateCommunityLocations"),'params':([locationId:location?.id,formType:formType,appFormID:appForm?.id,csrfPreventionSalt:"${csrfPreventionSalt}"])],3)
printHtmlPart(12)
}
printHtmlPart(13)
}
else {
printHtmlPart(14)
}
printHtmlPart(15)
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
