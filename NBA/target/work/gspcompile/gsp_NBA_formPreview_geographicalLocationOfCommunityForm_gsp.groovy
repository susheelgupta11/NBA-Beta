import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_NBA_formPreview_geographicalLocationOfCommunityForm_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/formPreview/_geographicalLocationOfCommunityForm.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
createTagBody(1, {->
printHtmlPart(0)
for( geoLocation in (listOfCommunityLocations) ) {
printHtmlPart(1)
if(true && (geoLocation?.consentObtained == 'Community')) {
printHtmlPart(2)
invokeTag('radio','g',22,['class':("isConsentObtained radio col-sm-1"),'name':("isConsentObtained"),'checked':("checked"),'disabled':("disabled"),'value':("Community")],-1)
printHtmlPart(3)
expressionOut.print(geoLocation?.consentObtained)
printHtmlPart(4)
}
else {
printHtmlPart(2)
invokeTag('radio','g',27,['class':("isConsentObtained radio col-sm-1"),'name':("isConsentObtained"),'disabled':("disabled"),'value':("Community")],-1)
printHtmlPart(5)
}
printHtmlPart(6)
if(true && (geoLocation?.consentObtained == 'Individual')) {
printHtmlPart(7)
invokeTag('radio','g',34,['class':("isConsentObtained radio col-sm-1"),'name':("isConsentObtained"),'checked':("checked"),'disabled':("disabled"),'value':("Individual")],-1)
printHtmlPart(8)
expressionOut.print(geoLocation?.consentObtained)
printHtmlPart(4)
}
else {
printHtmlPart(9)
invokeTag('radio','g',40,['disabled':("disabled"),'class':("isConsentObtained radio col-sm-1"),'name':("isConsentObtained"),'value':("Individual")],-1)
printHtmlPart(10)
}
printHtmlPart(11)
if(true && (geoLocation?.consentObtained == 'No')) {
printHtmlPart(12)
invokeTag('radio','g',47,['disabled':("disabled"),'class':("isConsentObtained radio col-sm-1"),'name':("isConsentObtained"),'checked':("checked"),'value':("No")],-1)
printHtmlPart(13)
expressionOut.print(geoLocation?.consentObtained)
printHtmlPart(14)
}
else {
printHtmlPart(15)
invokeTag('radio','g',52,['disabled':("disabled"),'class':("isConsentObtained radio col-sm-1 GeoNo"),'name':("isConsentObtained"),'value':("No")],-1)
printHtmlPart(16)
}
printHtmlPart(17)
if(true && (!geoLocation)) {
printHtmlPart(18)
expressionOut.print(geoLocation?.communityKnowledge)
printHtmlPart(19)
}
else if(true && (geoLocation?.consentObtained == 'Community')) {
printHtmlPart(18)
expressionOut.print(geoLocation?.communityKnowledge)
printHtmlPart(19)
}
printHtmlPart(20)
if(true && (!geoLocation)) {
printHtmlPart(21)
expressionOut.print(geoLocation?.communityKnowledge)
printHtmlPart(19)
}
else if(true && (geoLocation?.consentObtained == 'Individual')) {
printHtmlPart(21)
expressionOut.print(geoLocation?.communityKnowledge)
printHtmlPart(19)
}
printHtmlPart(22)
expressionOut.print(geoLocation?.village)
printHtmlPart(23)
expressionOut.print(geoLocation?.town)
printHtmlPart(24)
expressionOut.print(geoLocation?.district)
printHtmlPart(25)
expressionOut.print(geoLocation?.state)
printHtmlPart(26)
}
printHtmlPart(27)
})
invokeTag('formRemote','g',136,['name':("communityGeoLocation"),'class':("form-horizontal"),'role':("form"),'url':([controller:'applicationManagement',action:'saveGeoLocationOfCommunity']),'update':("updateCommunityLocations"),'onSuccess':("ClearAllFields()")],1)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1537268168000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
