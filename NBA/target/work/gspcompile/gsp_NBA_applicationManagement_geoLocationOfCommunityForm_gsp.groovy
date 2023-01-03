import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_NBA_applicationManagement_geoLocationOfCommunityForm_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/applicationManagement/_geoLocationOfCommunityForm.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
createTagBody(1, {->
printHtmlPart(0)
expressionOut.print(csrfPreventionSalt)
printHtmlPart(1)
if(true && (formType == 'Form3')) {
printHtmlPart(2)
}
else if(true && (formType == 'Form2')) {
printHtmlPart(3)
}
else {
printHtmlPart(4)
}
printHtmlPart(5)
if(true && (geoLocation?.consentObtained == 'Community')) {
printHtmlPart(6)
invokeTag('radio','g',34,['class':("isConsentObtained radio col-sm-1 community"),'name':("isConsentObtained"),'onclick':("AddValidationGeographical(this)"),'checked':("checked"),'value':("Community")],-1)
printHtmlPart(7)
expressionOut.print(geoLocation?.consentObtained)
printHtmlPart(8)
}
else {
printHtmlPart(6)
invokeTag('radio','g',41,['class':("isConsentObtained radio col-sm-1 community"),'name':("isConsentObtained"),'onclick':("AddValidationGeographical(this)"),'id':("communityConsentObtained"),'value':("Community")],-1)
printHtmlPart(9)
}
printHtmlPart(10)
if(true && (geoLocation?.consentObtained == 'Individual')) {
printHtmlPart(11)
invokeTag('radio','g',47,['class':("isConsentObtained radio col-sm-1 individual"),'name':("isConsentObtained"),'checked':("checked"),'onclick':("AddValidationGeographical(this)"),'value':("Individual")],-1)
printHtmlPart(12)
expressionOut.print(geoLocation?.consentObtained)
printHtmlPart(13)
}
else {
printHtmlPart(11)
invokeTag('radio','g',53,['class':("isConsentObtained radio col-sm-1 individual"),'name':("isConsentObtained"),'id':("individualConsentObtained"),'onclick':("AddValidationGeographical(this)"),'value':("Individual")],-1)
printHtmlPart(14)
}
printHtmlPart(15)
if(true && (geoLocation?.consentObtained == 'No')) {
printHtmlPart(11)
invokeTag('radio','g',61,['class':("isConsentObtained radio col-sm-1"),'name':("isConsentObtained"),'checked':("checked"),'onclick':("AddValidationGeographical(this)"),'value':("No")],-1)
printHtmlPart(16)
expressionOut.print(geoLocation?.consentObtained)
printHtmlPart(17)
}
else if(true && (appForm?.isNoForTraditional == 'No')) {
printHtmlPart(11)
invokeTag('radio','g',67,['class':("isConsentObtained radio col-sm-1"),'name':("isConsentObtained"),'checked':("checked"),'onclick':("AddValidationGeographical(this)"),'value':("No")],-1)
printHtmlPart(16)
expressionOut.print(appForm.isNoForTraditional)
printHtmlPart(17)
}
else {
printHtmlPart(11)
invokeTag('radio','g',73,['class':("isConsentObtained radio col-sm-1 GeoNo"),'name':("isConsentObtained"),'id':("noConsentObtained"),'onclick':("AddValidationGeographical(this)"),'value':("No")],-1)
printHtmlPart(18)
}
printHtmlPart(19)
if(true && (!geoLocation)) {
printHtmlPart(20)
expressionOut.print(geoLocation?.communityKnowledge)
printHtmlPart(21)
}
else if(true && (geoLocation?.consentObtained)) {
printHtmlPart(22)
if(true && (geoLocation?.consentObtained == 'Community')) {
printHtmlPart(23)
if(true && (formType == 'Form3')) {
printHtmlPart(24)
}
else {
printHtmlPart(25)
}
printHtmlPart(26)
expressionOut.print(geoLocation?.communityKnowledge)
printHtmlPart(27)
}
else if(true && (geoLocation?.consentObtained == 'Individual')) {
printHtmlPart(28)
expressionOut.print(geoLocation?.communityKnowledge)
printHtmlPart(27)
}
printHtmlPart(29)
}
else {
printHtmlPart(30)
expressionOut.print(geoLocation?.communityKnowledge)
printHtmlPart(31)
}
printHtmlPart(32)
expressionOut.print(geoLocation?.village)
printHtmlPart(33)
expressionOut.print(geoLocation?.town)
printHtmlPart(34)
expressionOut.print(geoLocation?.district)
printHtmlPart(35)
invokeTag('select','g',169,['class':("width controlreq"),'from':(listOfStates),'optionKey':("id"),'optionValue':("state"),'name':("state"),'value':(geoLocation?.state),'noSelection':(['':'Select State'])],-1)
printHtmlPart(36)
if(true && (formType != 'Form1')) {
printHtmlPart(37)
invokeTag('hiddenField','g',173,['name':("geoLocationId"),'value':(geoLocation?.id)],-1)
printHtmlPart(22)
invokeTag('hiddenField','g',174,['name':("appFormId"),'value':(appForm?.id)],-1)
printHtmlPart(38)
}
printHtmlPart(39)
if(true && (formType == 'Form1')) {
printHtmlPart(40)
invokeTag('hiddenField','g',185,['name':("geoLocationId"),'value':(geoLocation?.id)],-1)
printHtmlPart(22)
invokeTag('hiddenField','g',187,['name':("appFormId"),'value':(appForm?.id)],-1)
printHtmlPart(22)
invokeTag('hiddenField','g',188,['id':("isNoForTraditional"),'name':("isNoForTraditional")],-1)
printHtmlPart(41)
}
printHtmlPart(42)
})
invokeTag('formRemote','g',197,['name':("communityGeoLocation546"),'class':("form-horizontal"),'role':("form"),'autocomplete':("off"),'url':([controller:'applicationManagement',action:'saveGeoLocationOfCommunity']),'update':("updateCommunityLocations"),'onSuccess':("ClearAllFields()"),'onComplete':("loadPage()")],1)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1666335518964L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
