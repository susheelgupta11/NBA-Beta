import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_NBA_applicationManagement_companyProfile_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/applicationManagement/_companyProfile.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
expressionOut.print(csrfPreventionSalt)
printHtmlPart(2)
expressionOut.print(flash.message)
printHtmlPart(3)
expressionOut.print(companyProfile1?.entityName)
printHtmlPart(4)
for( entityType in (entityTypes) ) {
printHtmlPart(5)
if(true && (companyProfile1?.entityType == entityType)) {
printHtmlPart(6)
invokeTag('radio','g',67,['name':("entityType"),'value':(entityType),'req1':("1"),'class':("ctlwidth leftflot"),'checked':("checked"),'required':("required")],-1)
printHtmlPart(7)
expressionOut.print(entityType)
printHtmlPart(8)
}
else {
printHtmlPart(9)
invokeTag('radio','g',72,['name':("entityType"),'value':(entityType),'req1':("1"),'class':("ctlwidth leftflot"),'required':("required")],-1)
printHtmlPart(10)
expressionOut.print(entityType)
printHtmlPart(8)
}
printHtmlPart(11)
}
printHtmlPart(12)
if(true && (!companyProfile1)) {
printHtmlPart(13)
invokeTag('radio','g',91,['name':("status"),'class':("leftflot"),'value':("notRegisteredInIndia"),'required':("required")],-1)
printHtmlPart(14)
invokeTag('radio','g',94,['name':("status"),'class':("leftflot"),'value':("registeredInIndia"),'required':("required")],-1)
printHtmlPart(15)
if(true && (formType == 'Form3' || formType == 'Form2')) {
printHtmlPart(16)
invokeTag('radio','g',99,['name':("status"),'class':("leftflot"),'value':("noNonIndianParticipation"),'required':("required")],-1)
printHtmlPart(17)
}
printHtmlPart(18)
}
else if(true && (companyProfile1)) {
printHtmlPart(19)
if(true && (companyProfile1?.nationality == 'notRegisteredInIndia')) {
printHtmlPart(20)
if(true && (formType == 'Form3' || formType == 'Form2')) {
printHtmlPart(21)
}
printHtmlPart(19)
}
else if(true && (companyProfile1?.nationality == 'registeredInIndia')) {
printHtmlPart(22)
if(true && (formType == 'Form3' || formType == 'Form2')) {
printHtmlPart(23)
}
printHtmlPart(24)
}
else if(true && (companyProfile1?.nationality == 'noNonIndianParticipation')) {
printHtmlPart(25)
if(true && (formType == 'Form3')) {
printHtmlPart(26)
}
printHtmlPart(24)
}
printHtmlPart(18)
}
printHtmlPart(27)
expressionOut.print(companyProfile1?.address1)
printHtmlPart(28)
expressionOut.print(companyProfile1?.address2)
printHtmlPart(29)
expressionOut.print(companyProfile1?.address3)
printHtmlPart(30)
invokeTag('select','g',195,['name':("countryId"),'from':(listOfCountries),'optionKey':("id"),'optionValue':("country"),'value':(companyProfile1?.country?.id),'class':("width country ctlwidth"),'noSelection':(['':'-Select-']),'req1':("1"),'onchange':(remoteFunction (controller: 'applicationManagement',action: 'fetchStates',
							params: "'countryId='+this.value+'&csrfPreventionSalt=${csrfPreventionSalt}'",update: 'updateStates',onComplete: 'updateCountryCodes(this)'))],-1)
printHtmlPart(31)
expressionOut.print(companyProfile1?.city)
printHtmlPart(32)
expressionOut.print(companyProfile1?.pincode)
printHtmlPart(33)
if(true && (!companyProfile1)) {
printHtmlPart(34)
}
else if(true && (companyProfile1?.mobile?.contains('-'))) {
printHtmlPart(35)
expressionOut.print(companyProfile1?.mobile?.split('-')[0])
printHtmlPart(36)
}
printHtmlPart(37)
if(true && (!companyProfile1)) {
printHtmlPart(38)
}
else if(true && (companyProfile1?.mobile?.contains('-'))) {
printHtmlPart(39)
expressionOut.print(companyProfile1?.mobile?.split('-')[1])
printHtmlPart(40)
}
printHtmlPart(41)
if(true && (!companyProfile1)) {
printHtmlPart(42)
}
else if(true && (companyProfile1?.phone?.contains('-'))) {
printHtmlPart(43)
expressionOut.print(companyProfile1?.phone?.split('-')[0])
printHtmlPart(40)
}
printHtmlPart(37)
if(true && (!companyProfile1)) {
printHtmlPart(44)
}
else if(true && (companyProfile1?.phone?.contains('-'))) {
printHtmlPart(45)
expressionOut.print(companyProfile1?.phone?.split('-')[1])
printHtmlPart(40)
}
printHtmlPart(46)
expressionOut.print(companyProfile1?.email)
printHtmlPart(47)
expressionOut.print(companyProfile1?.website)
printHtmlPart(48)
if(true && (companyProfile1?.businessNature?.contains('-'))) {
printHtmlPart(24)
invokeTag('select','g',334,['name':("businessNature"),'id':("profileId"),'from':(listOfNature),'onchange':("hideshowother(this,'otherProfile')"),'value':(companyProfile1?.businessNature?.split('-')[0]),'class':("width ctlwidth"),'noSelection':(['':'-Select-']),'req1':("1")],-1)
printHtmlPart(19)
}
else {
printHtmlPart(49)
invokeTag('select','g',339,['name':("businessNature"),'id':("profileId"),'from':(listOfNature),'onchange':("hideshowother(this,'otherProfile')"),'value':(companyProfile1?.businessNature),'class':("width ctlwidth"),'noSelection':(['':'-Select-']),'req1':("1")],-1)
printHtmlPart(19)
}
printHtmlPart(50)
if(true && (companyProfile1?.businessNature?.contains('-'))) {
printHtmlPart(51)
expressionOut.print(companyProfile1?.businessNature?.split('-')[1])
printHtmlPart(52)
}
else {
printHtmlPart(53)
}
printHtmlPart(54)
if(true && (companyProfile1?.registrationDoc)) {
printHtmlPart(55)
createTagBody(3, {->
printHtmlPart(9)
expressionOut.print(companyProfile1?.registrationDocName)
printHtmlPart(5)
})
invokeTag('link','g',373,['controller':("applicationManagement"),'action':("showDc"),'id':(companyProfile1?.id),'target':("_blank"),'class':("fumargin"),'params':([filename: "registrationDocName", dataName: "registrationDoc",csrfPreventionSalt:"${csrfPreventionSalt}"])],3)
printHtmlPart(24)
}
else {
printHtmlPart(56)
}
printHtmlPart(57)
invokeTag('select','g',399,['name':("title"),'req1':("1"),'class':("width ctlwidth"),'from':(org.nba.application.CompanyProfile?.TitleName?.values()),'value':(companyProfile1?.title),'noSelection':(['':'-Select title-'])],-1)
printHtmlPart(58)
expressionOut.print(companyProfile1?.firstName)
printHtmlPart(59)
expressionOut.print(companyProfile1?.middleName)
printHtmlPart(60)
expressionOut.print(companyProfile1?.lastName)
printHtmlPart(61)
expressionOut.print(companyProfile1?.designation)
printHtmlPart(62)
if(true && (!companyProfile1)) {
printHtmlPart(63)
}
else if(true && (companyProfile1?.mobile?.contains('-'))) {
printHtmlPart(64)
expressionOut.print(companyProfile1?.personMobile?.split('-')[0])
printHtmlPart(36)
}
printHtmlPart(65)
if(true && (!companyProfile1)) {
printHtmlPart(66)
}
else if(true && (companyProfile1?.mobile?.contains('-'))) {
printHtmlPart(67)
expressionOut.print(companyProfile1?.mobile?.split('-')[1])
printHtmlPart(40)
}
printHtmlPart(68)
expressionOut.print(companyProfile1?.personEmail)
printHtmlPart(69)
if(true && (companyProfile1?.passportCopy)) {
printHtmlPart(70)
invokeTag('select','g',524,['id':("foucuscontrol"),'name':("authRepresentativeIdSelect"),'req1':("1"),'value':(companyProfile1?.authRepresentativeIdSelect),'class':("width controlclass1"),'from':(authRepresentativeId),'noSelection':(['':'-Select Proof-'])],-1)
printHtmlPart(71)
expressionOut.print(companyProfile1?.idNum)
printHtmlPart(72)
createTagBody(3, {->
printHtmlPart(73)
expressionOut.print(companyProfile1?.passportCopyFileName)
printHtmlPart(9)
})
invokeTag('link','g',538,['controller':("applicationManagement"),'action':("showDc"),'id':(companyProfile1?.id),'target':("_blank"),'params':([filename: "passportCopy", dataName: "passportCopy",csrfPreventionSalt:"${csrfPreventionSalt}"])],3)
printHtmlPart(74)
}
else {
printHtmlPart(70)
invokeTag('select','g',547,['id':("foucuscontrol"),'name':("authRepresentativeIdSelect"),'req1':("1"),'class':("width controlclass1"),'from':(authRepresentativeId),'noSelection':(['':'-Select Proof-'])],-1)
printHtmlPart(75)
}
printHtmlPart(76)
if(true && (scheduleAformat?.document)) {
printHtmlPart(5)
createTagBody(3, {->
printHtmlPart(9)
expressionOut.print(scheduleAformat?.docName)
printHtmlPart(5)
})
invokeTag('link','g',573,['controller':("applicationManagement"),'action':("showDeclarationForm"),'id':(scheduleAformat?.id),'target':("_blank"),'params':([filename: "scheduleAformat", dataName: "scheduleAformat",csrfPreventionSalt:"${csrfPreventionSalt}"])],3)
printHtmlPart(24)
}
printHtmlPart(77)
if(true && (companyProfile1?.authorizationLetter)) {
printHtmlPart(78)
createTagBody(3, {->
printHtmlPart(9)
expressionOut.print(companyProfile1?.authorizationLetterFileName)
printHtmlPart(5)
})
invokeTag('link','g',594,['controller':("applicationManagement"),'action':("showDc"),'class':("fumargin"),'id':(companyProfile1?.id),'target':("_blank"),'params':([filename: "authorizationLetterFileName", dataName: "authorizationLetterFileName",csrfPreventionSalt:"${csrfPreventionSalt}"])],3)
printHtmlPart(24)
}
else {
printHtmlPart(79)
}
printHtmlPart(80)
invokeTag('hiddenField','g',608,['name':("profileId"),'value':(companyProfile1?.id)],-1)
printHtmlPart(18)
invokeTag('hiddenField','g',609,['name':("formType"),'value':(formType)],-1)
printHtmlPart(18)
invokeTag('hiddenField','g',610,['name':("appFormId"),'value':(appForm?.id)],-1)
printHtmlPart(81)
})
invokeTag('uploadForm','g',1,['class':("form-horizontal"),'role':("form"),'autocomplete':("off"),'action':("submitCompanyProfile")],1)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1664199212289L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
