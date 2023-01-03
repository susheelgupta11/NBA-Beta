
import org.nba.application.IndividualProfile

import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_NBA_applicationManagement_individualProfile_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/applicationManagement/_individualProfile.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
expressionOut.print(createLink(controller:'applicationManagement',action:'fetchMobileCode'))
printHtmlPart(2)
expressionOut.print(createLink(controller:'applicationManagement',action:'fetchCountryCode'))
printHtmlPart(3)
expressionOut.print(createLink(controller:'applicationManagement',action:'fetchcodes'))
printHtmlPart(4)
expressionOut.print(individualProfile?.idProofSelect)
printHtmlPart(5)
expressionOut.print(individualProfile?.country?.country)
printHtmlPart(6)
expressionOut.print(csrfPreventionSalt)
printHtmlPart(7)
})
invokeTag('javascript','g',76,[:],1)
printHtmlPart(8)
createTagBody(1, {->
printHtmlPart(9)
expressionOut.print(csrfPreventionSalt)
printHtmlPart(10)
expressionOut.print(flash.message)
printHtmlPart(11)
invokeTag('select','g',99,['id':("foucuscontrol"),'name':("title"),'req1':("1"),'class':("width controlclass1"),'value':(individualProfile?.title),'from':(IndividualProfile.TitleName.values()),'noSelection':(['':'-Select title-'])],-1)
printHtmlPart(12)
expressionOut.print(individualProfile?.firstName)
printHtmlPart(13)
expressionOut.print(individualProfile?.middleName)
printHtmlPart(14)
expressionOut.print(individualProfile?.lastName)
printHtmlPart(15)
invokeTag('select','g',150,['from':(nationality),'class':("width controlclass1"),'name':("nationality"),'req1':("1"),'id':("nationality"),'value':(individualProfile?.nationality),'onchange':("updateCountry(this)")],-1)
printHtmlPart(16)
if(true && ("")) {
printHtmlPart(17)
}
printHtmlPart(18)
expressionOut.print(individualProfile?.address1)
printHtmlPart(19)
expressionOut.print(individualProfile?.address2)
printHtmlPart(20)
expressionOut.print(individualProfile?.address3)
printHtmlPart(21)
expressionOut.print(individualProfile?.country?.country)
printHtmlPart(22)
invokeTag('select','g',222,['name':("countryId"),'from':(listOfCountries),'optionKey':("id"),'optionValue':("country"),'id':("country"),'value':(individualProfile?.country?.id),'class':("width controlclass1 country"),'noSelection':(['':'-Select-']),'req1':("1"),'onchange':("updateCountryCodes(this)")],-1)
printHtmlPart(23)
invokeTag('select','g',234,['name':("province"),'from':(statesList?.state),'id':("province"),'class':(" width ctrolreqddl"),'value':(""),'noSelection':(['':'Select State'])],-1)
printHtmlPart(24)
expressionOut.print(individualProfile?.province)
printHtmlPart(25)
expressionOut.print(individualProfile?.city)
printHtmlPart(26)
expressionOut.print(individualProfile?.pincode)
printHtmlPart(27)
if(true && (!individualProfile)) {
printHtmlPart(28)
}
else if(true && (individualProfile?.mobile?.contains('-'))) {
printHtmlPart(29)
expressionOut.print(individualProfile?.mobile?.split('-')[0])
printHtmlPart(30)
}
printHtmlPart(31)
if(true && (!individualProfile)) {
printHtmlPart(32)
}
else if(true && (individualProfile?.mobile?.contains('-'))) {
printHtmlPart(33)
expressionOut.print(individualProfile?.mobile?.split('-')[1])
printHtmlPart(30)
}
printHtmlPart(34)
if(true && (!individualProfile)) {
printHtmlPart(35)
}
else if(true && (individualProfile?.phone?.contains('-'))) {
printHtmlPart(36)
expressionOut.print(individualProfile?.phone?.split('-')[0])
printHtmlPart(37)
}
printHtmlPart(38)
if(true && (!individualProfile)) {
printHtmlPart(39)
}
else if(true && (individualProfile?.phone?.contains('-'))) {
printHtmlPart(40)
expressionOut.print(individualProfile?.phone?.split('-')[1])
printHtmlPart(37)
}
printHtmlPart(41)
expressionOut.print(individualProfile?.email)
printHtmlPart(42)
if(true && (individualProfile?.idProof)) {
printHtmlPart(43)
invokeTag('select','g',396,['id':("idProofSelect"),'name':("idProofSelect"),'class':("width controlclass1"),'req1':("1"),'value':(individualProfile?.idProofSelect),'from':(idProofSelect),'noSelection':(['':'-Select Proof-'])],-1)
printHtmlPart(44)
expressionOut.print(individualProfile?.idNum)
printHtmlPart(45)
expressionOut.print(individualProfile?.idProof)
printHtmlPart(46)
createTagBody(3, {->
printHtmlPart(47)
expressionOut.print(individualProfile?.idProofFileName)
printHtmlPart(48)
})
invokeTag('link','g',411,['controller':("applicationManagement"),'action':("showIndividualDc"),'id':(individualProfile?.id),'target':("_blank"),'params':([filename: "idProof", dataName: "idProof",csrfPreventionSalt:"${csrfPreventionSalt}"])],3)
printHtmlPart(49)
}
else {
printHtmlPart(50)
if(true && (idProofIndian)) {
printHtmlPart(51)
invokeTag('select','g',420,['id':("idProofSelect"),'name':("idProofSelect"),'req1':("1"),'class':("width controlclass1"),'from':(idProofIndian),'noSelection':(['':'-Select Proof-'])],-1)
printHtmlPart(49)
}
else {
printHtmlPart(51)
invokeTag('select','g',427,['id':("idProofSelect"),'name':("idProofSelect"),'req1':("1"),'class':("width controlclass1"),'from':(""),'noSelection':(['':'-Select Proof-'])],-1)
printHtmlPart(49)
}
printHtmlPart(52)
}
printHtmlPart(53)
if(true && (individualProfile?.passportCopy)) {
printHtmlPart(54)
invokeTag('select','g',461,['id':("foucuscontrol"),'name':("passportSelect"),'req1':("1"),'class':("width controlclass1"),'value':(individualProfile?.passportSelect),'from':(passportSelect),'noSelection':(['':'-Select Proof-'])],-1)
printHtmlPart(55)
expressionOut.print(individualProfile?.passportNum)
printHtmlPart(56)
expressionOut.print(individualProfile?.passportCopy)
printHtmlPart(46)
createTagBody(3, {->
printHtmlPart(47)
expressionOut.print(individualProfile?.passportCopyFileName)
printHtmlPart(48)
})
invokeTag('link','g',477,['controller':("applicationManagement"),'action':("showIndividualDc"),'id':(individualProfile?.id),'target':("_blank"),'params':([filename: "passportCopy", dataName: "passportCopy",csrfPreventionSalt:"${csrfPreventionSalt}"])],3)
printHtmlPart(57)
}
else {
printHtmlPart(54)
invokeTag('select','g',486,['id':("foucuscontrol"),'name':("passportSelect"),'req1':("1"),'class':("width controlclass1"),'value':(""),'from':(passportSelect),'noSelection':(['':'-Select Proof-'])],-1)
printHtmlPart(58)
}
printHtmlPart(59)
if(true && (individualProfile?.authorizationLetter)) {
printHtmlPart(54)
invokeTag('select','g',517,['id':("foucuscontrol"),'name':("authorizationSelect"),'class':("width controlclass1"),'value':(individualProfile?.authorizationSelect),'from':(authorizationSelect),'noSelection':(['':'-Select Proof-'])],-1)
printHtmlPart(60)
expressionOut.print(individualProfile?.authorizationNo)
printHtmlPart(61)
expressionOut.print(individualProfile?.authorizationLetter)
printHtmlPart(46)
createTagBody(3, {->
printHtmlPart(47)
expressionOut.print(individualProfile?.authorizationLetterFileName)
printHtmlPart(48)
})
invokeTag('link','g',534,['controller':("applicationManagement"),'action':("showIndividualDc"),'id':(individualProfile?.id),'target':("_blank"),'params':([filename: "authorizationLetter", dataName: "authorizationLetter",csrfPreventionSalt:"${csrfPreventionSalt}"])],3)
printHtmlPart(49)
}
else {
printHtmlPart(54)
invokeTag('select','g',542,['id':("foucuscontrol"),'name':("authorizationSelect"),'class':("width controlclass1"),'value':(""),'from':(authorizationSelect),'noSelection':(['':'-Select Proof-'])],-1)
printHtmlPart(62)
}
printHtmlPart(63)
if(true && (individualProfile?.profile?.contains('-'))) {
printHtmlPart(48)
invokeTag('select','g',578,['name':("profile"),'from':(profile),'id':("profileId"),'onchange':("hideshowother(this,'otherProfile')"),'value':(individualProfile?.profile?.split('-')[0]),'class':("width  controlclass1"),'req1':("1")],-1)
printHtmlPart(64)
}
else {
printHtmlPart(48)
invokeTag('select','g',584,['name':("profile"),'from':(profile),'id':("profileId"),'onchange':("hideshowother(this,'otherProfile')"),'value':(individualProfile?.profile),'class':("width  controlclass1"),'req1':("1")],-1)
printHtmlPart(64)
}
printHtmlPart(65)
if(true && (individualProfile?.profile?.contains('-'))) {
printHtmlPart(66)
expressionOut.print(individualProfile?.profile?.split('-')[1])
printHtmlPart(67)
}
else {
printHtmlPart(68)
}
printHtmlPart(69)
invokeTag('hiddenField','g',610,['name':("profileId"),'value':(individualProfile?.id)],-1)
printHtmlPart(70)
invokeTag('hiddenField','g',611,['name':("formType"),'value':(formType)],-1)
printHtmlPart(70)
invokeTag('hiddenField','g',612,['name':("appFormId"),'value':(appForm?.id)],-1)
printHtmlPart(71)
})
invokeTag('uploadForm','g',1,['class':("form-horizontal"),'role':("form"),'autocomplete':("off"),'action':("submitIndividualFormProfile")],1)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1664197760195L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
