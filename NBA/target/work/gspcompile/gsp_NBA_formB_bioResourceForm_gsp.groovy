import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_NBA_formB_bioResourceForm_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/formB/_bioResourceForm.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
expressionOut.print(csrfPreventionSalt)
printHtmlPart(2)
if(true && (!bioResource)) {
printHtmlPart(3)
}
else if(true && (bioResource?.accessIntention)) {
printHtmlPart(4)
if(true && (bioResource?.accessIntention == 'Carried along for the research')) {
printHtmlPart(5)
}
else {
printHtmlPart(6)
}
printHtmlPart(7)
if(true && (bioResource?.accessIntention == 'Sent for the Research')) {
printHtmlPart(8)
}
else {
printHtmlPart(9)
}
printHtmlPart(7)
}
printHtmlPart(10)
for( resource in (natureOfReources) ) {
printHtmlPart(11)
if(true && (bioResource?.nature == resource)) {
printHtmlPart(12)
expressionOut.print(resource)
printHtmlPart(13)
expressionOut.print(resource)
printHtmlPart(14)
}
else {
printHtmlPart(15)
expressionOut.print(resource)
printHtmlPart(16)
expressionOut.print(resource)
printHtmlPart(14)
}
printHtmlPart(17)
}
printHtmlPart(18)
expressionOut.print(bioResource?.commonName)
printHtmlPart(19)
expressionOut.print(bioResource?.scientificName)
printHtmlPart(20)
if(true && (bioResource?.biologicalResource?.contains('-'))) {
printHtmlPart(11)
invokeTag('select','g',145,['name':("bioResource"),'id':("source"),'from':(resources),'onchange':("hideshowother(this,'other')"),'value':(bioResource?.biologicalResource?.split('-')[0]),'class':("width controlclass Associate dsblcontrol1"),'noSelection':(['':'-Select-']),'req1':("1")],-1)
printHtmlPart(17)
}
else {
printHtmlPart(11)
invokeTag('select','g',151,['name':("bioResource"),'id':("source"),'from':(resources),'value':(bioResource?.biologicalResource),'onchange':("hideshowother(this,'other')"),'class':("width controlclass Associate dsblcontrol1"),'noSelection':(['':'-Select-']),'req1':("1")],-1)
printHtmlPart(17)
}
printHtmlPart(21)
if(true && (bioResource?.biologicalResource?.contains('-'))) {
printHtmlPart(22)
expressionOut.print(bioResource?.biologicalResource?.split('-')[1])
printHtmlPart(23)
}
else if(true && (bioResource?.biologicalResource != 'Others')) {
printHtmlPart(24)
}
printHtmlPart(25)
expressionOut.print(bioResource?.quantity)
printHtmlPart(26)
invokeTag('select','g',210,['name':("qtyUnit"),'from':(quantityList),'value':(bioResource?.qtyUnit),'class':("width controlclass Associate dsblcontrol1"),'noSelection':(['':'-Select-'])],-1)
printHtmlPart(27)
invokeTag('hiddenField','g',214,['name':("bioResourceId"),'value':(bioResource?.id)],-1)
printHtmlPart(28)
invokeTag('hiddenField','g',215,['name':("appFormId"),'value':(appForm?.id)],-1)
printHtmlPart(28)
invokeTag('hiddenField','g',216,['name':("formType"),'value':(formType)],-1)
printHtmlPart(29)
})
invokeTag('formRemote','g',221,['name':("biologicalResources"),'class':("form-horizontal"),'id':("biologicalResources"),'role':("form"),'autocomplete':("off"),'url':([controller:'formB',action:'bioResourceSubmit']),'update':("updateBioResourceGrid"),'onSuccess':("ClearAllFields()"),'onComplete':("loadPage()")],1)
printHtmlPart(30)
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
