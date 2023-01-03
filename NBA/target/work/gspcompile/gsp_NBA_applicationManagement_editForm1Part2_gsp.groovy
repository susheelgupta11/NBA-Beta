import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_NBA_applicationManagement_editForm1Part2_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/applicationManagement/_editForm1Part2.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
if(true && (formType == 'Form2')) {
printHtmlPart(1)
}
else if(true && (formType == 'Form4')) {
printHtmlPart(2)
}
else if(true && (formType == 'Form3')) {
printHtmlPart(3)
}
printHtmlPart(4)
createTagBody(1, {->
printHtmlPart(5)
expressionOut.print(csrfPreventionSalt)
printHtmlPart(6)
if(true && (formType == 'Form1')) {
printHtmlPart(7)
}
printHtmlPart(8)
if(true && (!bioResourceInst)) {
printHtmlPart(9)
}
else if(true && (bioResourceInst?.accessIntention)) {
printHtmlPart(10)
if(true && (bioResourceInst?.accessIntention == 'Biological Resources')) {
printHtmlPart(11)
}
else {
printHtmlPart(12)
}
printHtmlPart(13)
if(true && (bioResourceInst?.accessIntention == 'Associated Knowledge')) {
printHtmlPart(14)
}
else {
printHtmlPart(15)
}
printHtmlPart(13)
if(true && (bioResourceInst?.accessIntention == 'Biological Resources & Traditional Knowledge')) {
printHtmlPart(16)
}
else {
printHtmlPart(17)
}
printHtmlPart(18)
}
printHtmlPart(19)
for( resource in (natureOfReources) ) {
printHtmlPart(20)
if(true && (bioResourceInst.nature == resource)) {
printHtmlPart(21)
expressionOut.print(resource)
printHtmlPart(22)
expressionOut.print(resource)
printHtmlPart(23)
}
else {
printHtmlPart(24)
expressionOut.print(resource)
printHtmlPart(25)
expressionOut.print(resource)
printHtmlPart(23)
}
printHtmlPart(26)
}
printHtmlPart(27)
expressionOut.print(bioResourceInst?.commonName)
printHtmlPart(28)
expressionOut.print(bioResourceInst?.scientificName)
printHtmlPart(29)
if(true && (bioResourceInst?.biologicalResource?.contains('-'))) {
printHtmlPart(20)
invokeTag('select','g',194,['name':("bioResource"),'id':("source"),'from':(resources),'onchange':("hideshowother(this,'other')"),'value':(bioResourceInst?.biologicalResource?.split('-')[0]),'class':("width controlclass Associate dsblcontrol1"),'noSelection':(['':'-Select-']),'req1':("1")],-1)
printHtmlPart(26)
}
else {
printHtmlPart(20)
invokeTag('select','g',203,['name':("bioResource"),'id':("source"),'from':(resources),'value':(bioResourceInst?.biologicalResource),'onchange':("hideshowother(this,'other')"),'class':("width controlclass Associate dsblcontrol1"),'noSelection':(['':'-Select-']),'req1':("1")],-1)
printHtmlPart(26)
}
printHtmlPart(30)
if(true && (bioResourceInst?.biologicalResource?.contains('-'))) {
printHtmlPart(31)
expressionOut.print(bioResourceInst?.biologicalResource?.split('-')[1])
printHtmlPart(32)
}
else {
printHtmlPart(33)
}
printHtmlPart(34)
if(true && (formType == 'Form4')) {
printHtmlPart(35)
expressionOut.print(bioResourceInst?.quantity)
printHtmlPart(36)
invokeTag('select','g',243,['name':("qtyUnit"),'from':(quantityList),'value':(bioResourceInst?.qtyUnit),'class':("width ctrl dsblcontrol1"),'noSelection':(['':'-Select-']),'req1':("1")],-1)
printHtmlPart(37)
invokeTag('textArea','g',261,['class':("width ctrl1"),'txtreq1':("1"),'placeHolder':("Provide details in 100 words"),'name':("traditionalKnowledgeDesc"),'value':(bioResourceInst?.bioResouceTraditionalKnowledge)],-1)
printHtmlPart(38)
}
printHtmlPart(39)
if(true && (bioResourceInst?.biologicalResource == "Others")) {
printHtmlPart(40)
expressionOut.print(bioResourceInst?.biologicalResource)
printHtmlPart(41)
}
printHtmlPart(42)
if(true && (formType == 'Form1')) {
printHtmlPart(43)
if(true && (formType == 'Form1')) {
printHtmlPart(44)
}
else {
printHtmlPart(45)
}
printHtmlPart(46)
expressionOut.print(bioResourceInst?.quantity)
printHtmlPart(47)
invokeTag('select','g',302,['name':("qtyUnit"),'from':(quantityList),'value':(bioResourceInst?.qtyUnit),'class':("width controlclass Associate dsblcontrol1"),'noSelection':(['':'-Select-']),'req1':("1")],-1)
printHtmlPart(48)
}
printHtmlPart(49)
if(true && (formType == 'Form1')) {
printHtmlPart(50)
expressionOut.print(bioResourceInst?.fromTime?.format('dd/MM/yyyy'))
printHtmlPart(51)
expressionOut.print(bioResourceInst?.toTime?.format('dd/MM/yyyy'))
printHtmlPart(52)
}
printHtmlPart(39)
if(true && (formType == 'Form1')) {
printHtmlPart(53)
expressionOut.print(bioResourceInst?.traditionalUse)
printHtmlPart(54)
}
printHtmlPart(55)
invokeTag('hiddenField','g',337,['name':("bioResourceInstID"),'value':(bioResourceInst?.id)],-1)
printHtmlPart(56)
invokeTag('hiddenField','g',338,['name':("formType"),'value':(formType)],-1)
printHtmlPart(56)
invokeTag('hiddenField','g',339,['name':("appFormID"),'value':(appFormID)],-1)
printHtmlPart(57)
})
invokeTag('formRemote','g',347,['name':("biologicalResources"),'class':("form-horizontal"),'role':("form"),'autocomplete':("off"),'url':([controller:'applicationManagement',action:'saveEditForm1Part2']),'update':("updateBioResources"),'onSuccess':("ClearAllFields()"),'onComplete':("loadPage()")],1)
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
