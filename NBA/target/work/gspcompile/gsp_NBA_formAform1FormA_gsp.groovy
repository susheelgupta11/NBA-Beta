import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_NBA_formAform1FormA_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/formA/form1FormA.gsp" }
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
invokeTag('captureHead','sitemesh',21,[:],1)
printHtmlPart(4)
createTagBody(1, {->
printHtmlPart(5)
createTagBody(2, {->
printHtmlPart(6)
expressionOut.print(tabStatus)
printHtmlPart(7)
})
invokeTag('javascript','g',26,[:],2)
printHtmlPart(8)
invokeTag('render','g',33,['template':("/applicationManagement/leftTabs"),'model':([formType:formType,appForm:appForm])],-1)
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
invokeTag('hiddenField','g',138,['name':("appFormId"),'value':(appForm?.id)],-1)
printHtmlPart(29)
invokeTag('hiddenField','g',140,['name':("bioResourceInstID"),'value':(bioResource?.id)],-1)
printHtmlPart(29)
if(true && (formType == 'Form1')) {
printHtmlPart(30)
if(true && (bioResource?.id == bioResourceEditId?.id)) {
printHtmlPart(31)
expressionOut.print(bioResource?.ratePerUnit)
printHtmlPart(32)
}
else if(true && (bioResource?.ratePerUnit != '' && bioResource?.ratePerUnit != null)) {
expressionOut.print(bioResource?.ratePerUnit)
}
else {
printHtmlPart(33)
}
printHtmlPart(34)
if(true && (bioResource?.id == bioResourceEditId?.id)) {
printHtmlPart(35)
invokeTag('select','g',162,['name':("stateBiodeversityBoard"),'from':(listOfStates?.state),'class':(" stateddl width ctlwidth"),'value':(bioResource?.stateBiodeversityBoard),'noSelection':(['':'Select State'])],-1)
printHtmlPart(36)
}
else if(true && (bioResource?.stateBiodeversityBoard != '' && bioResource?.stateBiodeversityBoard != null)) {
printHtmlPart(37)
expressionOut.print(bioResource?.stateBiodeversityBoard)
printHtmlPart(37)
}
else {
printHtmlPart(37)
invokeTag('select','g',170,['name':("stateBiodeversityBoard"),'from':(listOfStates?.state),'class':(" stateddl width ctlwidth"),'value':(""),'noSelection':(['':'Select State'])],-1)
printHtmlPart(38)
}
printHtmlPart(39)
if(true && (bioResource?.id == bioResourceEditId?.id)) {
printHtmlPart(40)
expressionOut.print(bioResource?.prospectiveBuyers)
printHtmlPart(32)
}
else if(true && (bioResource?.prospectiveBuyers != '' && bioResource?.prospectiveBuyers != null)) {
expressionOut.print(bioResource?.prospectiveBuyers)
}
else {
printHtmlPart(41)
}
printHtmlPart(42)
}
printHtmlPart(43)
createClosureForHtmlPart(44, 5)
invokeTag('link','g',189,['controller':("formA"),'action':("editBioProfile"),'params':([bioResource:bioResource?.id,formType:formType,appFormID:appForm?.id,csrfPreventionSalt:"${csrfPreventionSalt}"])],5)
printHtmlPart(45)
})
invokeTag('formRemote','g',194,['name':("biologicalResources"),'class':("form-horizontal"),'role':("form"),'autocomplete':("off"),'url':([controller:"formA",action:"saveBioProfile"]),'onComplete':("loadPage()")],4)
printHtmlPart(46)
}
printHtmlPart(47)
}
else {
printHtmlPart(48)
}
printHtmlPart(49)
createTagBody(2, {->
printHtmlPart(50)
if(true && (appForm?.benefitSharingProofFile)) {
printHtmlPart(51)
if(true && (flash.message)) {
printHtmlPart(52)
expressionOut.print(flash.message)
printHtmlPart(53)
}
else {
printHtmlPart(26)
createTagBody(5, {->
printHtmlPart(29)
expressionOut.print(appForm?.benefitSharingProofFilename)
printHtmlPart(26)
})
invokeTag('link','g',233,['action':("showAppDc"),'id':(appForm?.id),'target':("_blank"),'params':([filename: "benefitSharingProof", dataName: "benefitSharingProof",csrfPreventionSalt:"${csrfPreventionSalt}"])],5)
printHtmlPart(54)
}
printHtmlPart(10)
}
else {
printHtmlPart(51)
if(true && (flash.message)) {
printHtmlPart(52)
expressionOut.print(flash.message)
printHtmlPart(53)
}
printHtmlPart(10)
}
printHtmlPart(10)
invokeTag('hiddenField','g',241,['name':("appFormId"),'value':(appForm?.id)],-1)
printHtmlPart(55)
expressionOut.print(csrfPreventionSalt)
printHtmlPart(56)
expressionOut.print(formType)
printHtmlPart(57)
})
invokeTag('uploadForm','g',248,['action':("uploadBenefitSharingProof")],2)
printHtmlPart(58)
invokeTag('render','g',253,['template':("formAUndertaking"),'model':([formType:formType,appFormId:appForm])],-1)
printHtmlPart(59)
createClosureForHtmlPart(60, 2)
invokeTag('link','g',259,['controller':("applicationManagement"),'action':("form1Part4"),'onclick':("checkRadio_checked()"),'params':([appFormId:appForm?.id,formType:formType,csrfPreventionSalt:"${csrfPreventionSalt}"]),'class':("btn btn-primary  "),'method':("POST")],2)
printHtmlPart(61)
if(true && (appForm?.isDeclarationDigitallySigned == 'true' || appForm?.isDeclarationDigitallySigned == 'notDigital')) {
printHtmlPart(62)
createClosureForHtmlPart(63, 3)
invokeTag('link','g',275,['controller':("applicationManagement"),'action':("form1Part5"),'class':("btn btn-primary pull-right"),'params':([appFormId:appForm?.id,formType:formType,declaration:"declaration" ,csrfPreventionSalt:"${csrfPreventionSalt}"])],3)
printHtmlPart(61)
}
else {
printHtmlPart(64)
createClosureForHtmlPart(63, 3)
invokeTag('link','g',279,['controller':("applicationManagement"),'action':("form1Part5"),'class':("btn btn-primary pull-right"),'params':([appFormId:appForm?.id,formType:formType,csrfPreventionSalt:"${csrfPreventionSalt}"])],3)
printHtmlPart(61)
}
printHtmlPart(65)
})
invokeTag('captureBody','sitemesh',281,[:],1)
printHtmlPart(66)
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
