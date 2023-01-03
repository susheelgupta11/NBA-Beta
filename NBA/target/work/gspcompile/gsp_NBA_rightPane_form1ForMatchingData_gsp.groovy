
import org.nba.common.*

import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_NBA_rightPane_form1ForMatchingData_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/rightPane/_form1ForMatchingData.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)

char alpha = 65

printHtmlPart(1)
if(true && (allDataforMatching?.individualDetailsForMatch.size()>0)) {
printHtmlPart(0)
loop:{
int i = 0
for( individualProfile in (allDataforMatching?.individualDetailsForMatch) ) {
printHtmlPart(2)
expressionOut.print(alpha)
printHtmlPart(3)
expressionOut.print(i+1)
printHtmlPart(4)
expressionOut.print(individualProfile?.title)
printHtmlPart(5)
expressionOut.print(individualProfile?.firstName)
printHtmlPart(5)
expressionOut.print(individualProfile?.middleName)
printHtmlPart(5)
expressionOut.print(individualProfile?.lastName)
printHtmlPart(6)
expressionOut.print(individualProfile?.nationality)
printHtmlPart(7)
expressionOut.print(individualProfile?.profile)
printHtmlPart(8)
expressionOut.print(individualProfile?.address1)
printHtmlPart(5)
expressionOut.print(individualProfile?.address2)
printHtmlPart(5)
expressionOut.print(individualProfile?.address3)
printHtmlPart(9)
expressionOut.print(individualProfile?.city)
printHtmlPart(5)
expressionOut.print(individualProfile?.pincode)
printHtmlPart(10)
expressionOut.print(individualProfile?.country?.name)
printHtmlPart(11)
expressionOut.print(individualProfile?.mobile)
printHtmlPart(12)
expressionOut.print(individualProfile?.phone)
printHtmlPart(13)
expressionOut.print(individualProfile?.email)
printHtmlPart(14)
expressionOut.print(individualProfile?.idProofFileName)
printHtmlPart(15)
createClosureForHtmlPart(16, 3)
invokeTag('link','g',56,['controller':("applicationManagement"),'action':("showIndividualDc"),'id':(individualProfile?.id),'target':("_blank"),'params':([filename: "idProof", dataName: "idProof",csrfPreventionSalt:"${csrfPreventionSalt}"])],3)
printHtmlPart(17)
expressionOut.print(individualProfile?.idNum)
printHtmlPart(18)
if(true && (individualProfile?.authorizationLetterFileName)) {
printHtmlPart(19)
expressionOut.print(individualProfile?.authorizationLetterFileName)
printHtmlPart(15)
createClosureForHtmlPart(20, 4)
invokeTag('link','g',72,['controller':("applicationManagement"),'action':("showIndividualDc"),'id':(individualProfile?.id),'target':("_blank"),'params':([filename: "authorizationLetter", dataName: "authorizationLetter",csrfPreventionSalt:"${csrfPreventionSalt}"])],4)
printHtmlPart(21)
expressionOut.print(individualProfile?.authorizationNo)
printHtmlPart(9)
}
else {
printHtmlPart(22)
}
printHtmlPart(23)
if(true && (individualProfile?.passportCopyFileName)) {
printHtmlPart(15)
expressionOut.print(individualProfile?.passportCopyFileName)
printHtmlPart(15)
createClosureForHtmlPart(24, 4)
invokeTag('link','g',94,['controller':("applicationManagement"),'action':("showIndividualDc"),'id':(individualProfile?.id),'target':("_blank"),'params':([filename: "passportCopy", dataName: "passportCopy",csrfPreventionSalt:"${csrfPreventionSalt}"])],4)
printHtmlPart(25)
expressionOut.print(individualProfile?.passportNum)
printHtmlPart(9)
}
else {
printHtmlPart(22)
}
printHtmlPart(26)
i++
}
}
printHtmlPart(27)
}
printHtmlPart(28)
if(true && (allDataforMatching?.companyDetailsForMatch.size() > 0)) {
printHtmlPart(27)
loop:{
int j = 0
for( company in (allDataforMatching?.companyDetailsForMatch) ) {
printHtmlPart(29)
expressionOut.print(alpha)
printHtmlPart(30)
expressionOut.print(j+1)
printHtmlPart(31)
expressionOut.print(company?.entityName)
printHtmlPart(32)
expressionOut.print(company?.entityType)
printHtmlPart(33)
if(true && (company?.nationality == 'notRegisteredInIndia')) {
printHtmlPart(34)
}
else if(true && (company?.nationality == 'noNonIndianParticipation')) {
printHtmlPart(35)
}
else {
printHtmlPart(36)
}
printHtmlPart(37)
expressionOut.print(company?.address1)
printHtmlPart(5)
expressionOut.print(company?.address2)
printHtmlPart(5)
expressionOut.print(company?.address3)
printHtmlPart(5)
expressionOut.print(company?.city)
printHtmlPart(38)
expressionOut.print(company?.pincode)
printHtmlPart(39)
expressionOut.print(company?.province)
printHtmlPart(40)
expressionOut.print(company?.country?.name)
printHtmlPart(41)
expressionOut.print(company?.mobile)
printHtmlPart(42)
expressionOut.print(company?.phone)
printHtmlPart(43)
expressionOut.print(company?.email)
printHtmlPart(44)
expressionOut.print(company?.website)
printHtmlPart(45)
expressionOut.print(company?.businessNature)
printHtmlPart(46)
if(true && (allDataforMatching?.companyDetailsForMatch?.registrationDoc)) {
printHtmlPart(47)
expressionOut.print(company?.registrationDocName)
printHtmlPart(48)
createClosureForHtmlPart(20, 4)
invokeTag('link','g',191,['controller':("applicationManagement"),'action':("showDc"),'id':(company?.id),'target':("_blank"),'class':("fumargin"),'params':([filename: 'registrationDocName', dataName: 'registrationDoc',csrfPreventionSalt:csrfPreventionSalt])],4)
printHtmlPart(38)
}
else {
printHtmlPart(49)
}
printHtmlPart(50)
expressionOut.print(company?.title)
printHtmlPart(5)
expressionOut.print(company?.firstName)
printHtmlPart(5)
expressionOut.print(company?.middleName)
printHtmlPart(5)
expressionOut.print(company?.lastName)
printHtmlPart(51)
expressionOut.print(company?.designation)
printHtmlPart(52)
expressionOut.print(company?.personMobile)
printHtmlPart(53)
expressionOut.print(company?.personEmail)
printHtmlPart(54)
expressionOut.print(company?.idNum)
printHtmlPart(55)
if(true && (allDataforMatching?.companyDetailsForMatch?.passportCopy)) {
printHtmlPart(56)
createTagBody(4, {->
printHtmlPart(57)
expressionOut.print(company?.passportCopyFileName)
printHtmlPart(56)
})
invokeTag('link','g',237,['controller':("applicationManagement"),'action':("showDc"),'id':(company?.id),'target':("_blank"),'params':([filename: 'passportCopy', dataName: 'passportCopy',csrfPreventionSalt:csrfPreventionSalt])],4)
printHtmlPart(58)
}
else {
printHtmlPart(59)
}
printHtmlPart(60)
createClosureForHtmlPart(61, 3)
invokeTag('link','g',249,['controller':("applicationManagement"),'action':("showDc"),'id':(company?.id),'target':("_blank"),'params':([filename: 'passportCopy', dataName: 'passportCopy',csrfPreventionSalt:csrfPreventionSalt])],3)
printHtmlPart(62)
j++
}
}
printHtmlPart(0)
}
printHtmlPart(1)
invokeTag('render','g',251,['template':("/rightPane/agentProfileMatching")],-1)
printHtmlPart(1)
invokeTag('render','g',253,['template':("/rightPane/bioResourceAndLocationDetails")],-1)
printHtmlPart(0)
invokeTag('render','g',255,['template':("/rightPane/part3")],-1)
printHtmlPart(0)
invokeTag('render','g',255,['template':("/rightPane/part4")],-1)
printHtmlPart(0)
invokeTag('render','g',259,['template':("/rightPane/part5")],-1)
printHtmlPart(1)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1620549611562L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
