
import org.nba.common.State

import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_NBA_applicationManagement_geographicalLocationForm_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/applicationManagement/_geographicalLocationForm.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
expressionOut.print(csrfPreventionSalt)
printHtmlPart(2)
if(true && (formType == 'Form2')) {
printHtmlPart(3)
}
else {
printHtmlPart(4)
if(true && (formType == 'Form3')) {
printHtmlPart(5)
}
else {
printHtmlPart(6)
}
printHtmlPart(7)
}
printHtmlPart(8)
invokeTag('select','g',36,['id':("foucuscontrol1"),'name':("name"),'value':(geoLocation?.bioResource?.id),'from':(newList),'optionKey':("id"),'optionValue':("scientificName"),'class':("width controlclass1"),'req1':("1"),'noSelection':(['':'-Select-'])],-1)
printHtmlPart(9)
invokeTag('select','g',47,['id':("sourcesAccess"),'name':("source"),'from':(accessSources),'onchange':("ReadonlyRecord(this)"),'value':(geoLocation?.source),'class':("width sourcesAccess controlclass1"),'req1':("1"),'noSelection':(['':'-Select-'])],-1)
printHtmlPart(10)
expressionOut.print(geoLocation?.village)
printHtmlPart(11)
expressionOut.print(geoLocation?.town)
printHtmlPart(12)
expressionOut.print(geoLocation?.district)
printHtmlPart(13)
invokeTag('select','g',91,['name':("state"),'from':(listOfStates),'optionKey':("id"),'optionValue':("state"),'value':(State.findByState(geoLocation?.state)?.id),'class':("width controlclass1 readcontrol dsblcontrol"),'noSelection':(['':'Select State'])],-1)
printHtmlPart(14)
expressionOut.print(geoLocation?.traderName)
printHtmlPart(15)
expressionOut.print(geoLocation?.traderContactDetails)
printHtmlPart(16)
invokeTag('hiddenField','g',118,['name':("geoLocationId"),'value':(geoLocation?.id)],-1)
printHtmlPart(17)
invokeTag('hiddenField','g',119,['name':("appFormId"),'value':(appForm?.id)],-1)
printHtmlPart(18)
})
invokeTag('formRemote','g',123,['name':("geoLocation1234"),'class':("form-horizontal"),'role':("form"),'autocomplete':("off"),'url':([controller:'applicationManagement',action:'saveGeoLocation']),'update':("updateGeoLocation"),'onSuccess':("ClearAllFields()"),'onComplete':("loadPage()")],1)
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
