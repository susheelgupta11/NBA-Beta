
import org.nba.common.*

import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_NBA_rightPane_form2ForMatchingData_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/rightPane/_form2ForMatchingData.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
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
invokeTag('link','g',57,['controller':("applicationManagement"),'action':("showIndividualDc"),'id':(individualProfile?.id),'target':("_blank"),'params':([filename: 'idProof', dataName: 'idProof',csrfPreventionSalt:csrfPreventionSalt])],3)
printHtmlPart(17)
expressionOut.print(individualProfile?.idNum)
printHtmlPart(18)
if(true && (individualProfile?.authorizationLetterFileName)) {
printHtmlPart(19)
expressionOut.print(individualProfile?.authorizationLetterFileName)
printHtmlPart(15)
createClosureForHtmlPart(20, 4)
invokeTag('link','g',73,['controller':("applicationManagement"),'action':("showIndividualDc"),'id':(individualProfile?.id),'target':("_blank"),'params':([filename: 'passportCopy', dataName: 'passportCopy',csrfPreventionSalt:csrfPreventionSalt])],4)
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
invokeTag('link','g',95,['controller':("applicationManagement"),'action':("showIndividualDc"),'id':(individualProfile?.id),'target':("_blank"),'params':([filename: 'passportCopy', dataName: 'passportCopy',csrfPreventionSalt:csrfPreventionSalt])],4)
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
printHtmlPart(5)
expressionOut.print(company?.province)
printHtmlPart(5)
expressionOut.print(company?.country?.name)
printHtmlPart(39)
expressionOut.print(company?.mobile)
printHtmlPart(40)
expressionOut.print(company?.phone)
printHtmlPart(41)
expressionOut.print(company?.email)
printHtmlPart(42)
expressionOut.print(company?.website)
printHtmlPart(43)
expressionOut.print(company?.businessNature)
printHtmlPart(44)
if(true && (allDataforMatching?.companyDetailsForMatch?.registrationDoc)) {
printHtmlPart(45)
expressionOut.print(company?.registrationDocName)
printHtmlPart(45)
createClosureForHtmlPart(20, 4)
invokeTag('link','g',190,['controller':("applicationManagement"),'action':("showDc"),'id':(company?.id),'target':("_blank"),'class':("fumargin"),'params':([filename: 'registrationDocName', dataName: 'registrationDoc',csrfPreventionSalt:csrfPreventionSalt])],4)
printHtmlPart(38)
}
else {
printHtmlPart(46)
}
printHtmlPart(47)
expressionOut.print(company?.title)
printHtmlPart(5)
expressionOut.print(company?.firstName)
printHtmlPart(5)
expressionOut.print(company?.middleName)
printHtmlPart(5)
expressionOut.print(company?.lastName)
printHtmlPart(48)
expressionOut.print(company?.designation)
printHtmlPart(49)
expressionOut.print(company?.personMobile)
printHtmlPart(50)
expressionOut.print(company?.personEmail)
printHtmlPart(51)
expressionOut.print(company?.idNum)
printHtmlPart(52)
if(true && (allDataforMatching?.companyDetailsForMatch?.passportCopy)) {
printHtmlPart(53)
createTagBody(4, {->
printHtmlPart(54)
expressionOut.print(company?.passportCopyFileName)
printHtmlPart(53)
})
invokeTag('link','g',235,['controller':("applicationManagement"),'action':("showDc"),'id':(company?.id),'target':("_blank"),'params':([filename: 'passportCopy', dataName: 'passportCopy',csrfPreventionSalt:csrfPreventionSalt])],4)
printHtmlPart(55)
}
else {
printHtmlPart(56)
}
printHtmlPart(57)
createClosureForHtmlPart(58, 3)
invokeTag('link','g',247,['controller':("applicationManagement"),'action':("showDc"),'id':(company?.id),'target':("_blank"),'params':([filename: 'passportCopy', dataName: 'passportCopy',csrfPreventionSalt:csrfPreventionSalt])],3)
printHtmlPart(59)
j++
}
}
printHtmlPart(0)
}
printHtmlPart(1)
invokeTag('render','g',249,['template':("/rightPane/agentProfileMatching")],-1)
printHtmlPart(60)
expressionOut.print(formDetails?.briefDescription)
printHtmlPart(61)
expressionOut.print(formDetails?.resultsOfResearch)
printHtmlPart(62)
invokeTag('render','g',272,['template':("/rightPane/bioResourceAndLocationDetails")],-1)
printHtmlPart(63)
if(true && (formDetails?.individualProfiles?.size() > 0 && formDetails?.individualProfiles?.getAt(0)?.nationality == 'Non Indian' || formDetails?.individualProfiles?.getAt(0)?.nationality == 'Non-Resident Indian')) {
printHtmlPart(64)
if(true && (formDetails.isApprovalOfNbaObtained == 'true')) {
printHtmlPart(65)
}
else {
printHtmlPart(66)
}
printHtmlPart(67)
if(true && (formDetails?.nbaApprovalFile)) {
printHtmlPart(68)
createClosureForHtmlPart(69, 3)
invokeTag('link','g',305,['controller':("form2"),'action':("showDc"),'id':(formDetails?.id),'target':("_blank"),'params':([filename: "nbaApprovalFileName", dataName: "nbaApprovalFileName",csrfPreventionSalt:"${csrfPreventionSalt}"])],3)
printHtmlPart(45)
}
else {
printHtmlPart(70)
}
printHtmlPart(71)
}
printHtmlPart(72)
if(true && (formDetails?.isNoForTraditional == 'No')) {
printHtmlPart(73)
expressionOut.print(formDetails?.isNoForTraditional)
printHtmlPart(74)
}
printHtmlPart(15)
if(true && (formDetails?.isNoForTraditional != 'No')) {
printHtmlPart(75)
expressionOut.print(formDetails?.nature)
printHtmlPart(76)
}
printHtmlPart(77)
if(true && (formDetails?.isNoForTraditional != 'No')) {
printHtmlPart(78)
expressionOut.print(formDetails?.traditionalKnowledgeDesc)
printHtmlPart(79)
}
printHtmlPart(80)
if(true && (formDetails?.isNoForTraditional == 'No' || allDataforMatching?.listOfCommunityLocations ?.size() == 0)) {
printHtmlPart(81)
}
printHtmlPart(82)
if(true && (allDataforMatching?.listOfCommunityLocations)) {
printHtmlPart(83)
if(true && (allDataforMatching?.listOfCommunityLocations)) {
printHtmlPart(53)

int a=1

printHtmlPart(53)
for( location in (allDataforMatching?.listOfCommunityLocations) ) {
printHtmlPart(84)
out.print(a)
printHtmlPart(85)

a++

printHtmlPart(86)
expressionOut.print(location?.communityKnowledge)
printHtmlPart(87)
expressionOut.print(location?.village)
printHtmlPart(88)
expressionOut.print(location?.town)
printHtmlPart(89)
expressionOut.print(location?.district)
printHtmlPart(88)
expressionOut.print(State?.findById(location?.state)?.state)
printHtmlPart(90)
}
printHtmlPart(15)
}
printHtmlPart(91)
}
printHtmlPart(92)
if(true && (formDetails?.detailsOfInstitute)) {
printHtmlPart(93)
expressionOut.print(formDetails?.detailsOfInstitute)
printHtmlPart(94)
}
else {
printHtmlPart(95)
}
printHtmlPart(96)
if(true && (formDetails?.bonafideLetter || formDetails.isResearchParticipation == 'true')) {
printHtmlPart(97)
createTagBody(2, {->
printHtmlPart(98)
expressionOut.print(formDetails?.bonafideLetterName)
printHtmlPart(99)
})
invokeTag('link','g',450,['controller':("form2"),'action':("showDc"),'id':(formDetails?.id),'target':("_blank"),'params':([filename: "bonafideLetterName", dataName: "bonafideLetterName",csrfPreventionSalt:"${csrfPreventionSalt}"])],2)
printHtmlPart(100)
}
else {
printHtmlPart(101)
}
printHtmlPart(102)
expressionOut.print(formDetails?.detailsOfInstitute)
printHtmlPart(103)
expressionOut.print(formDetails?.useofResearchResults)
printHtmlPart(104)
if(true && (formDetails?.benefitsToTheIndividualOrOrganization)) {
printHtmlPart(105)
expressionOut.print(formDetails?.benefitsToTheIndividualOrOrganization)
printHtmlPart(106)
}
else {
printHtmlPart(107)
}
printHtmlPart(108)
if(true && (formDetails?.benefitsToTheApplicant)) {
printHtmlPart(105)
expressionOut.print(formDetails?.benefitsToTheApplicant)
printHtmlPart(106)
}
else {
printHtmlPart(107)
}
printHtmlPart(109)
if(true && (formDetails?.collaborationDetails)) {
printHtmlPart(110)
}
else {
printHtmlPart(111)
}
printHtmlPart(112)
if(true && (formDetails?.collaborationDetails)) {
printHtmlPart(113)
if(true && (formDetails?.collaborationDetails)) {
printHtmlPart(105)
expressionOut.print(formDetails?.collaborationDetails)
printHtmlPart(106)
}
else {
printHtmlPart(114)
}
printHtmlPart(115)
createTagBody(2, {->
printHtmlPart(54)
expressionOut.print(formDetails?.mouFileName)
printHtmlPart(53)
})
invokeTag('link','g',559,['controller':("form2"),'action':("showDc"),'id':(formDetails?.id),'target':("_blank"),'params':([filename: "mouFileName", dataName: "mouFileName",csrfPreventionSalt:"${csrfPreventionSalt}"])],2)
printHtmlPart(116)
}
printHtmlPart(117)
invokeTag('render','g',564,['template':("/rightPane/part5")],-1)
printHtmlPart(0)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1645149348558L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
