import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_NBA_applicationManagement_formCMicroorganism_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/applicationManagement/_formCMicroorganism.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
expressionOut.print(csrfPreventionSalt)
printHtmlPart(2)
invokeTag('select','g',25,['name':("scientistName"),'id':("foucuscontrol1"),'from':(listOfScientistName?.scientistName),'class':(" stateddl width controlreq"),'value':(geoLocationlist1?.bioResource?.scientistName),'noSelection':(['':'-Select-']),'req1':("1")],-1)
printHtmlPart(3)
invokeTag('select','g',35,['id':("sourcesAccess"),'name':("source"),'from':(accessSources),'onchange':("ReadonlyRecordFormC(this)"),'value':(geoLocationlist1?.source),'class':("width sourcesAccess controlreq controlclass1"),'req1':("1"),'noSelection':(['':'-Select-'])],-1)
printHtmlPart(4)
if(true && (geoLocationlist1?.village)) {
printHtmlPart(5)
expressionOut.print(geoLocationlist1?.village)
printHtmlPart(6)
}
else {
printHtmlPart(7)
}
printHtmlPart(8)
if(true && (geoLocationlist1?.town)) {
printHtmlPart(9)
expressionOut.print(geoLocationlist1?.town)
printHtmlPart(10)
}
else {
printHtmlPart(11)
}
printHtmlPart(12)
if(true && (geoLocationlist1?.district)) {
printHtmlPart(13)
expressionOut.print(geoLocationlist1?.district)
printHtmlPart(14)
}
else {
printHtmlPart(15)
}
printHtmlPart(16)
invokeTag('select','g',82,['name':("state"),'from':(statesList?.state),'class':(" stateddl width controlreq ctrolreqddl readcontrol controlclass1 dsblcontrol"),'req1':("1"),'value':(geoLocationlist1?.state),'noSelection':(['':'Select State'])],-1)
printHtmlPart(17)
expressionOut.print(geoLocationlist1?.traderName)
printHtmlPart(18)
expressionOut.print(geoLocationlist1?.traderContactDetails)
printHtmlPart(19)
invokeTag('hiddenField','g',108,['name':("profileId"),'value':(geoLocationlist1?.id)],-1)
printHtmlPart(20)
invokeTag('hiddenField','g',109,['name':("formType"),'value':(formType)],-1)
printHtmlPart(20)
invokeTag('hiddenField','g',110,['name':("appFormId"),'value':(appForm)],-1)
printHtmlPart(21)
})
invokeTag('formRemote','g',115,['name':("biologicalResources"),'class':("form-horizontal"),'role':("form"),'autocomplete':("off"),'url':([controller:'applicationManagement',action:'submitGeolocationMicroOrganism']),'update':("formCMicroOrganismGeo"),'onComplete':("loadPage()")],1)
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
