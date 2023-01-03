import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_NBA_form3part2_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/form3/part2.gsp" }
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
invokeTag('captureHead','sitemesh',42,[:],1)
printHtmlPart(4)
createTagBody(1, {->
printHtmlPart(1)
createTagBody(2, {->
printHtmlPart(5)
expressionOut.print(tabStatus)
printHtmlPart(6)
expressionOut.print(appForm?.isApprovalOfNbaObtainedForm3)
printHtmlPart(7)
})
invokeTag('javascript','g',49,[:],2)
printHtmlPart(8)
invokeTag('render','g',56,['template':("/applicationManagement/leftTabs"),'model':([formType:formType,appFormId:appFormId])],-1)
printHtmlPart(9)
createTagBody(2, {->
printHtmlPart(10)
expressionOut.print(csrfPreventionSalt)
printHtmlPart(11)
expressionOut.print(appForm?.titleOfIPR)
printHtmlPart(12)
invokeTag('textArea','g',110,['class':("width ctrl1"),'name':("abstractOfIPR"),'txtreq1':("1"),'txtmaxword200':("1"),'value':(appForm?.abstractOfIPR)],-1)
printHtmlPart(13)
for( countryKeyValue in (countryMap) ) {
printHtmlPart(14)
if(true && (countryKeyValue?.value)) {
printHtmlPart(15)
invokeTag('checkBox','g',127,['name':("detailsOfTerritories"),'class':("territories ctrl1"),'onclick':("GelAllcheckedvalue(this)"),'chkreq1':("1"),'checked':("true"),'value':(countryKeyValue?.key?.country)],-1)
printHtmlPart(16)
expressionOut.print(countryKeyValue?.key?.country)
printHtmlPart(17)
}
else {
printHtmlPart(15)
invokeTag('checkBox','g',134,['name':("detailsOfTerritories"),'class':("territories ctrl1"),'chkreq1':("1"),'onclick':("GelAllcheckedvalue(this)"),'value':(countryKeyValue?.key?.country),'checked':("false")],-1)
printHtmlPart(16)
expressionOut.print(countryKeyValue?.key?.country)
printHtmlPart(18)
}
printHtmlPart(19)
}
printHtmlPart(20)
expressionOut.print(msg)
printHtmlPart(21)
for( countryKeyValue in (countryMap) ) {
printHtmlPart(14)
if(true && (countryKeyValue?.value)) {
printHtmlPart(22)
expressionOut.print(countryKeyValue?.key?.country)
printHtmlPart(18)
}
printHtmlPart(23)
}
printHtmlPart(24)
invokeTag('hiddenField','g',154,['name':("appFormId"),'value':(appForm?.id)],-1)
printHtmlPart(25)
invokeTag('hiddenField','g',155,['name':("formType"),'value':(formType)],-1)
printHtmlPart(26)
})
invokeTag('form','g',157,['name':("iprDetailsPart2"),'id':("iprDetails"),'class':("form-horizontal"),'role':("form"),'autocomplete':("off"),'url':([controller:'form3',action:'savePart2'])],2)
printHtmlPart(27)
invokeTag('render','g',168,['template':("iprDetailsForm"),'model':([appForm:appForm,formType:formType,ipr:ipr,listOfStatuses:listOfStatuses,csrfPreventionSalt:"${csrfPreventionSalt}"])],-1)
printHtmlPart(28)
if(true && (listOfIprDetails)) {
printHtmlPart(29)
invokeTag('render','g',177,['template':("iprDetailsGrid"),'model':([listOfIprDetails:listOfIprDetails,appForm:appForm,formType:formType])],-1)
printHtmlPart(30)
}
printHtmlPart(31)
createTagBody(2, {->
printHtmlPart(32)
expressionOut.print(csrfPreventionSalt)
printHtmlPart(33)
for( resource in (natureOfReources) ) {
printHtmlPart(34)
expressionOut.print(resource)
printHtmlPart(35)
expressionOut.print(resource)
printHtmlPart(36)
}
printHtmlPart(37)
expressionOut.print(bioResourceInst?.commonName)
printHtmlPart(38)
invokeTag('select','g',281,['name':("bioResource"),'from':(resources),'value':(""),'onchange':("hideshowother(this,'other')"),'class':("width controlclass  Associate dsblcontrol1"),'noSelection':(['':'-Select-'])],-1)
printHtmlPart(39)
invokeTag('hiddenField','g',299,['name':("appFormId"),'value':(appForm?.id)],-1)
printHtmlPart(40)
invokeTag('hiddenField','g',300,['name':("formType"),'value':(formType)],-1)
printHtmlPart(41)
})
invokeTag('formRemote','g',304,['name':("biologicalResources"),'class':("form-horizontal"),'role':("form"),'onComplete':("loadPage()"),'autocomplete':("off"),'url':([controller:'applicationManagement',action:'saveBiologicalResources']),'update':("updateBioResources"),'onSuccess':("ClearAllFields()")],2)
printHtmlPart(42)
if(true && (listOfBioResources)) {
printHtmlPart(29)
invokeTag('render','g',314,['template':("/applicationManagement/biologicalResourcesGrid"),'model':([listOfBioResources:listOfBioResources])],-1)
printHtmlPart(30)
}
printHtmlPart(43)
if(true && (appForm?.individualProfiles?.size() > 0 && appForm?.individualProfiles?.getAt(0)?.nationality == 'Non Indian' || 
					appForm?.individualProfiles?.getAt(0)?.nationality == 'Non-Resident Indian' || appForm?.companyProfiles?.getAt(0)?.nationality == 'notRegisteredInIndia' ||
					 appForm?.companyProfiles?.getAt(0)?.nationality == 'registeredInIndia')) {
printHtmlPart(44)
createTagBody(3, {->
printHtmlPart(32)
expressionOut.print(csrfPreventionSalt)
printHtmlPart(45)
if(true && (!appForm?.isApprovalOfNbaObtainedForm3)) {
printHtmlPart(46)
}
else {
printHtmlPart(47)
if(true && (appForm.isApprovalOfNbaObtainedForm3 == 'true')) {
printHtmlPart(48)
}
else {
printHtmlPart(49)
}
printHtmlPart(50)
if(true && (appForm.isApprovalOfNbaObtainedForm3 == 'false')) {
printHtmlPart(51)
}
else {
printHtmlPart(52)
}
printHtmlPart(14)
}
printHtmlPart(53)
expressionOut.print(appForm?.applicationNo)
printHtmlPart(54)
expressionOut.print(appForm?.dateOfApproval?.format('dd/MM/yyyy'))
printHtmlPart(55)
if(true && (appForm?.nbaApprovalFile)) {
printHtmlPart(56)
if(true && (flash.message)) {
printHtmlPart(57)
expressionOut.print(flash.message)
printHtmlPart(58)
}
else {
printHtmlPart(47)
createTagBody(6, {->
printHtmlPart(59)
expressionOut.print(appForm?.nbaApprovalFileName)
printHtmlPart(47)
})
invokeTag('link','g',422,['controller':("form3"),'action':("showDc"),'id':(appForm?.id),'target':("_blank"),'params':([filename: "nbaApprovalFileName", dataName: "nbaApprovalFileName",csrfPreventionSalt:"${csrfPreventionSalt}"])],6)
printHtmlPart(14)
}
printHtmlPart(23)
}
else {
printHtmlPart(56)
if(true && (flash.message)) {
printHtmlPart(57)
expressionOut.print(flash.message)
printHtmlPart(58)
}
printHtmlPart(23)
}
printHtmlPart(60)
invokeTag('textArea','g',438,['class':("width"),'id':("approvalNotObtained"),'name':("reasonOFNotObtainedApproval"),'txtreq1':("1"),'txtmaxword500':("1"),'value':(appForm?.reasonOFNotObtainedApproval)],-1)
printHtmlPart(61)
invokeTag('hiddenField','g',445,['name':("appFormId"),'value':(appForm?.id)],-1)
printHtmlPart(14)
invokeTag('hiddenField','g',448,['name':("formType"),'value':(formType)],-1)
printHtmlPart(62)
})
invokeTag('uploadForm','g',455,['action':("saveNbaApprovalDetails"),'autocomplete':("off"),'class':("form-horizontal"),'role':("form")],3)
printHtmlPart(63)
}
printHtmlPart(64)
if(true && (appForm?.individualProfiles?.size() > 0)) {
printHtmlPart(30)
createClosureForHtmlPart(65, 3)
invokeTag('link','g',459,['controller':("applicationManagement"),'action':("individualProfile"),'params':([appFormId:appForm?.id,formType:formType,csrfPreventionSalt:"${csrfPreventionSalt}"]),'class':("""btn btn-primary
									""")],3)
printHtmlPart(64)
}
else {
printHtmlPart(30)
createClosureForHtmlPart(65, 3)
invokeTag('link','g',467,['controller':("applicationManagement"),'action':("companyProfile"),'params':([appFormId:appForm?.id,formType:formType,csrfPreventionSalt:"${csrfPreventionSalt}"]),'class':("""btn btn-primary
									""")],3)
printHtmlPart(64)
}
printHtmlPart(64)
createClosureForHtmlPart(66, 2)
invokeTag('link','g',478,['controller':("form3"),'action':("part3"),'params':([appFormId:appForm?.id,formType:formType,csrfPreventionSalt:"${csrfPreventionSalt}"]),'class':("btn btn-primary pull-right")],2)
printHtmlPart(67)
})
invokeTag('captureBody','sitemesh',482,[:],1)
printHtmlPart(68)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1537268164000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
