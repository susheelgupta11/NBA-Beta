import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_NBA_applicationManagementform1FormA_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/applicationManagement/form1FormA.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',6,['gsp_sm_xmlClosingForEmptyTag':("/"),'name':("layout"),'content':("loggedInUser")],-1)
printHtmlPart(1)
createTagBody(2, {->
createClosureForHtmlPart(2, 3)
invokeTag('captureTitle','sitemesh',7,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',7,[:],2)
printHtmlPart(3)
})
invokeTag('captureHead','sitemesh',18,[:],1)
printHtmlPart(4)
createTagBody(1, {->
printHtmlPart(5)
createTagBody(2, {->
printHtmlPart(6)
expressionOut.print(tabStatus)
printHtmlPart(7)
})
invokeTag('javascript','g',23,[:],2)
printHtmlPart(8)
invokeTag('render','g',30,['template':("leftTabs"),'model':([formType:formType,appForm:appForm])],-1)
printHtmlPart(9)
if(true && (listOfBioResources)) {
printHtmlPart(10)

int i=1

printHtmlPart(10)
for( bioResource in (listOfBioResources) ) {
printHtmlPart(11)
out.print(i)
printHtmlPart(12)

i++

printHtmlPart(13)
expressionOut.print(bioResource?.accessIntention)
printHtmlPart(14)
if(true && (bioResource?.accessIntention == 'Biological Resources' || bioResource?.accessIntention == 'Biological Resources & Traditional Knowledge' || bioResource?.accessIntention == 'Associated Knowledge')) {
printHtmlPart(15)
expressionOut.print(bioResource?.commonName)
printHtmlPart(16)
expressionOut.print(bioResource?.scientificName)
printHtmlPart(16)
expressionOut.print(bioResource?.nature)
printHtmlPart(16)
expressionOut.print(bioResource?.biologicalResource)
printHtmlPart(17)
}
else {
printHtmlPart(18)
}
printHtmlPart(19)
if(true && (formType == 'Form1' && formType != 'Form4')) {
printHtmlPart(20)
if(true && (bioResource?.accessIntention == 'Biological Resources' || bioResource?.accessIntention == 'Biological Resources & Traditional Knowledge' || bioResource?.accessIntention == 'Associated Knowledge')) {
printHtmlPart(21)
expressionOut.print(bioResource?.quantity)
printHtmlPart(22)
expressionOut.print(bioResource?.qtyUnit)
printHtmlPart(23)
}
else {
printHtmlPart(24)
}
printHtmlPart(25)
}
printHtmlPart(26)
createTagBody(4, {->
printHtmlPart(27)
expressionOut.print(csrfPreventionSalt)
printHtmlPart(28)
invokeTag('hiddenField','g',134,['name':("appFormId"),'value':(appForm?.id)],-1)
printHtmlPart(29)
invokeTag('hiddenField','g',136,['name':("bioResourceInstID"),'value':(bioResource?.id)],-1)
printHtmlPart(29)
if(true && (formType == 'Form1')) {
printHtmlPart(30)
if(true && (bioResource?.id == bioResourceEditId?.id)) {
printHtmlPart(31)
expressionOut.print(bioResource?.ratePerUnit)
printHtmlPart(32)
}
else if(true && (bioResource?.ratePerUnit != '')) {
printHtmlPart(33)
expressionOut.print(bioResource?.ratePerUnit)
printHtmlPart(34)
}
else {
printHtmlPart(35)
}
printHtmlPart(36)
if(true && (bioResource?.id == bioResourceEditId?.id)) {
printHtmlPart(37)
expressionOut.print(bioResource?.stateBiodeversityBoard)
printHtmlPart(32)
}
else if(true && (bioResource?.stateBiodeversityBoard != '')) {
printHtmlPart(33)
expressionOut.print(bioResource?.stateBiodeversityBoard)
printHtmlPart(34)
}
else {
printHtmlPart(38)
}
printHtmlPart(39)
if(true && (bioResource?.id == bioResourceEditId?.id)) {
printHtmlPart(40)
expressionOut.print(bioResource?.prospectiveBuyers)
printHtmlPart(32)
}
else if(true && (bioResource?.prospectiveBuyers != '')) {
printHtmlPart(33)
expressionOut.print(bioResource?.prospectiveBuyers)
printHtmlPart(41)
}
else {
printHtmlPart(42)
}
printHtmlPart(43)
}
printHtmlPart(44)
createClosureForHtmlPart(45, 5)
invokeTag('link','g',184,['controller':("formA"),'action':("editBioProfile"),'params':([bioResource:bioResource?.id,formType:formType,appFormID:appForm?.id,csrfPreventionSalt:"${csrfPreventionSalt}"])],5)
printHtmlPart(46)
})
invokeTag('formRemote','g',186,['name':("biologicalResources"),'class':("form-horizontal"),'role':("form"),'autocomplete':("off"),'url':([controller:"formA",action:"saveBioProfile"]),'onComplete':("loadPage()")],4)
printHtmlPart(47)
}
printHtmlPart(48)
}
else {
printHtmlPart(49)
}
printHtmlPart(50)
invokeTag('render','g',200,['template':("formAUndertaking"),'model':([formType:formType,appFormId:appForm])],-1)
printHtmlPart(51)
createClosureForHtmlPart(52, 2)
invokeTag('link','g',211,['controller':("applicationManagement"),'action':("form1Part3"),'class':("btn btn-primary"),'params':([appFormId:appForm?.id,formType:formType,csrfPreventionSalt:"${csrfPreventionSalt}"])],2)
printHtmlPart(53)
if(true && (appForm?.isDeclarationDigitallySigned == 'true' || appForm?.isDeclarationDigitallySigned == 'notDigital')) {
printHtmlPart(54)
createClosureForHtmlPart(55, 3)
invokeTag('link','g',230,['controller':("applicationManagement"),'action':("form1Part5"),'class':("btn btn-primary pull-right"),'params':([appFormId:appForm?.id,formType:formType,declaration:"declaration" ,csrfPreventionSalt:"${csrfPreventionSalt}"])],3)
printHtmlPart(53)
}
else {
printHtmlPart(54)
createClosureForHtmlPart(55, 3)
invokeTag('link','g',233,['controller':("applicationManagement"),'action':("form1Part5"),'class':("btn btn-primary pull-right"),'params':([appFormId:appForm?.id,formType:formType,csrfPreventionSalt:"${csrfPreventionSalt}"])],3)
printHtmlPart(53)
}
printHtmlPart(56)
})
invokeTag('captureBody','sitemesh',235,[:],1)
printHtmlPart(57)
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
