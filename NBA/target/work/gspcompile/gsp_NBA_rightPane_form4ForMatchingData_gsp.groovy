
import org.nba.common.*

import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_NBA_rightPane_form4ForMatchingData_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/rightPane/_form4ForMatchingData.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)

char alpha = 65

printHtmlPart(0)
if(true && (allDataforMatching?.individualDetailsForMatch.size()>0)) {
printHtmlPart(0)
loop:{
int i = 0
for( individualProfile in (allDataforMatching?.individualDetailsForMatch) ) {
printHtmlPart(1)
expressionOut.print(alpha)
printHtmlPart(2)
expressionOut.print(i+1)
printHtmlPart(3)
expressionOut.print(individualProfile?.title)
printHtmlPart(4)
expressionOut.print(individualProfile?.firstName)
printHtmlPart(4)
expressionOut.print(individualProfile?.middleName)
printHtmlPart(4)
expressionOut.print(individualProfile?.lastName)
printHtmlPart(5)
if(true && (profile?.nationality == 'Non Indian')) {
printHtmlPart(6)
expressionOut.print(individualProfile?.nationality)
printHtmlPart(7)
expressionOut.print(individualProfile?.country?.country)
printHtmlPart(8)
}
else {
printHtmlPart(9)
expressionOut.print(individualProfile?.nationality)
printHtmlPart(8)
}
printHtmlPart(10)
expressionOut.print(individualProfile?.profile)
printHtmlPart(11)
expressionOut.print(individualProfile?.address1)
printHtmlPart(4)
expressionOut.print(individualProfile?.address2)
printHtmlPart(4)
expressionOut.print(individualProfile?.address3)
printHtmlPart(12)
expressionOut.print(individualProfile?.city)
printHtmlPart(4)
expressionOut.print(individualProfile?.pincode)
printHtmlPart(13)
expressionOut.print(individualProfile?.country?.name)
printHtmlPart(14)
expressionOut.print(individualProfile?.mobile)
printHtmlPart(15)
expressionOut.print(individualProfile?.phone)
printHtmlPart(16)
expressionOut.print(individualProfile?.email)
printHtmlPart(17)
expressionOut.print(individualProfile?.idProofFileName)
printHtmlPart(18)
createClosureForHtmlPart(19, 3)
invokeTag('link','g',62,['controller':("applicationManagement"),'action':("showIndividualDc"),'id':(individualProfile?.id),'target':("_blank"),'params':([filename: 'idProof', dataName: 'idProof',csrfPreventionSalt:'${csrfPreventionSalt}'])],3)
printHtmlPart(20)
expressionOut.print(individualProfile?.idNum)
printHtmlPart(21)
if(true && (individualProfile?.authorizationLetterFileName)) {
printHtmlPart(22)
expressionOut.print(individualProfile?.authorizationLetterFileName)
printHtmlPart(18)
createClosureForHtmlPart(23, 4)
invokeTag('link','g',78,['controller':("applicationManagement"),'action':("showIndividualDc"),'id':(individualProfile?.id),'target':("_blank"),'params':([filename: 'passportCopy', dataName: 'passportCopy',csrfPreventionSalt:'${csrfPreventionSalt}'])],4)
printHtmlPart(24)
expressionOut.print(individualProfile?.authorizationNo)
printHtmlPart(12)
}
else {
printHtmlPart(25)
}
printHtmlPart(26)
if(true && (individualProfile?.passportCopyFileName)) {
printHtmlPart(18)
expressionOut.print(individualProfile?.passportCopyFileName)
printHtmlPart(18)
createClosureForHtmlPart(27, 4)
invokeTag('link','g',100,['controller':("applicationManagement"),'action':("showIndividualDc"),'id':(individualProfile?.id),'target':("_blank"),'params':([filename: 'passportCopy', dataName: 'passportCopy',csrfPreventionSalt:'${csrfPreventionSalt}'])],4)
printHtmlPart(28)
expressionOut.print(individualProfile?.passportNum)
printHtmlPart(12)
}
else {
printHtmlPart(25)
}
printHtmlPart(29)
i++
}
}
printHtmlPart(30)
}
printHtmlPart(31)
if(true && (allDataforMatching?.companyDetailsForMatch.size() > 0)) {
printHtmlPart(30)
loop:{
int j = 0
for( company in (allDataforMatching?.companyDetailsForMatch) ) {
printHtmlPart(32)
expressionOut.print(alpha)
printHtmlPart(33)
expressionOut.print(j+1)
printHtmlPart(34)
expressionOut.print(company?.entityName)
printHtmlPart(35)
expressionOut.print(company?.entityType)
printHtmlPart(36)
if(true && (company?.nationality == 'notRegisteredInIndia')) {
printHtmlPart(37)
}
else if(true && (company?.nationality == 'noNonIndianParticipation')) {
printHtmlPart(38)
}
else {
printHtmlPart(39)
}
printHtmlPart(40)
expressionOut.print(company?.address1)
printHtmlPart(4)
expressionOut.print(company?.address2)
printHtmlPart(4)
expressionOut.print(company?.address3)
printHtmlPart(4)
expressionOut.print(company?.city)
printHtmlPart(41)
expressionOut.print(company?.pincode)
printHtmlPart(42)
expressionOut.print(company?.country?.name)
printHtmlPart(43)
expressionOut.print(company?.mobile)
printHtmlPart(44)
expressionOut.print(company?.phone)
printHtmlPart(45)
expressionOut.print(company?.email)
printHtmlPart(46)
expressionOut.print(company?.website)
printHtmlPart(47)
expressionOut.print(company?.businessNature)
printHtmlPart(48)
if(true && (allDataforMatching?.companyDetailsForMatch?.registrationDoc)) {
printHtmlPart(49)
expressionOut.print(company?.registrationDocName)
printHtmlPart(49)
createClosureForHtmlPart(23, 4)
invokeTag('link','g',197,['controller':("applicationManagement"),'action':("showDc"),'id':(company?.id),'target':("_blank"),'class':("fumargin"),'params':([filename: 'registrationDocName', dataName: 'registrationDoc',csrfPreventionSalt:'${csrfPreventionSalt}'])],4)
printHtmlPart(41)
}
else {
printHtmlPart(50)
}
printHtmlPart(51)
expressionOut.print(company?.title)
printHtmlPart(4)
expressionOut.print(company?.firstName)
printHtmlPart(4)
expressionOut.print(company?.middleName)
printHtmlPart(4)
expressionOut.print(company?.lastName)
printHtmlPart(52)
expressionOut.print(company?.designation)
printHtmlPart(53)
expressionOut.print(company?.personMobile)
printHtmlPart(54)
expressionOut.print(company?.personEmail)
printHtmlPart(55)
expressionOut.print(company?.idNum)
printHtmlPart(56)
expressionOut.print(company?.authRepresentativeIdSelect)
printHtmlPart(57)
if(true && (allDataforMatching?.company?.passportCopy)) {
printHtmlPart(58)
createClosureForHtmlPart(59, 4)
invokeTag('link','g',242,['controller':("applicationManagement"),'action':("showDc"),'id':(company?.id),'target':("_blank"),'params':([filename: 'passportCopy', dataName: 'passportCopy',csrfPreventionSalt:'${csrfPreventionSalt}'])],4)
printHtmlPart(60)
}
else {
printHtmlPart(61)
}
printHtmlPart(62)
if(true && (companyProfile1?.authorizationLetter)) {
createClosureForHtmlPart(63, 4)
invokeTag('link','g',257,['controller':("applicationManagement"),'action':("showDc"),'id':(company?.id),'target':("_blank"),'params':([filename: 'authorizationLetterFileName', dataName: 'authorizationLetterFileName',csrfPreventionSalt:'${csrfPreventionSalt}'])],4)
printHtmlPart(64)
}
else {
printHtmlPart(65)
}
printHtmlPart(66)
j++
}
}
printHtmlPart(0)
}
printHtmlPart(31)
invokeTag('render','g',262,['template':("/rightPane/agentProfileMatching")],-1)
printHtmlPart(67)
if(true && (formDetails?.biologicalResources)) {
printHtmlPart(68)

int i=1

printHtmlPart(60)
for( bioResource in (formDetails?.biologicalResources) ) {
printHtmlPart(69)
out.print(i)
printHtmlPart(70)

i++

printHtmlPart(71)
expressionOut.print(bioResource?.accessIntention)
printHtmlPart(72)
expressionOut.print(bioResource?.commonName)
printHtmlPart(73)
expressionOut.print(bioResource?.scientificName)
printHtmlPart(74)
expressionOut.print(bioResource?.nature)
printHtmlPart(73)
expressionOut.print(bioResource?.biologicalResource)
printHtmlPart(75)
}
printHtmlPart(76)
}
printHtmlPart(77)
createTagBody(1, {->
printHtmlPart(64)
expressionOut.print(formDetails?.nbaApprovalFileName)
printHtmlPart(49)
})
invokeTag('link','g',343,['controller':("form4"),'action':("showDc"),'id':(formDetails?.id),'target':("_blank"),'params':([filename: "nbaApprovalFileName", dataName: "nbaApprovalFileName", nbaApprovalPart2:"part2",csrfPreventionSalt:"${csrfPreventionSalt}"])],1)
printHtmlPart(78)
expressionOut.print(formDetails?.applicationNo)
printHtmlPart(79)
expressionOut.print(formDetails?.dateOfApproval?.format('dd/MM/yyyy'))
printHtmlPart(80)
if(true && (formDetails?.isbenefitSharingDetailImplemented == 'true')) {
printHtmlPart(81)
}
else {
printHtmlPart(82)
}
printHtmlPart(83)
if(true && (formDetails?.isbenefitSharingDetailImplemented == 'true')) {
printHtmlPart(84)
expressionOut.print(formDetails?.benefitMechanism)
printHtmlPart(85)
}
printHtmlPart(86)
if(true && (allDataforMatching?.listOfThirdParty?.size() > 0)) {
printHtmlPart(87)
if(true && (allDataforMatching?.listOfThirdParty)) {
printHtmlPart(88)

int k = 1

printHtmlPart(88)
for( thirdPartyInst in (allDataforMatching?.listOfThirdParty) ) {
printHtmlPart(89)
out.print(k)
printHtmlPart(90)

k++

printHtmlPart(91)
expressionOut.print(thirdPartyInst?.name)
printHtmlPart(92)
expressionOut.print(thirdPartyInst?.addressForComm)
printHtmlPart(92)
expressionOut.print(thirdPartyInst?.state)
printHtmlPart(92)
expressionOut.print(thirdPartyInst?.pincode)
printHtmlPart(92)
expressionOut.print(thirdPartyInst?.country)
printHtmlPart(92)
expressionOut.print(thirdPartyInst?.phone)
printHtmlPart(92)
expressionOut.print(thirdPartyInst?.fax)
printHtmlPart(92)
expressionOut.print(thirdPartyInst?.website)
printHtmlPart(92)
expressionOut.print(thirdPartyInst?.email)
printHtmlPart(93)
}
printHtmlPart(94)
}
printHtmlPart(95)
}
printHtmlPart(96)
expressionOut.print(formDetails?.thirdPartyTransferPurpose)
printHtmlPart(97)
expressionOut.print(formDetails?.benefitsToTheThirdParty)
printHtmlPart(98)
if(true && (formDetails?.isAgreementBwApplicantAndThirdParty == 'true')) {
printHtmlPart(99)
}
else if(true && (formDetails?.isAgreementBwApplicantAndThirdParty == 'false')) {
printHtmlPart(100)
}
else {
printHtmlPart(101)
}
printHtmlPart(102)
if(true && (formDetails?.isAgreementBwApplicantAndThirdParty == 'true')) {
printHtmlPart(103)
createClosureForHtmlPart(104, 2)
invokeTag('link','g',521,['controller':("form4"),'action':("showDc"),'id':(formDetails?.id),'target':("_blank"),'params':([filename: "nbaApprovalFileName", dataName: "nbaApprovalFileName", nbaApprovalPart3:"part3",csrfPreventionSalt:"${csrfPreventionSalt}"])],2)
printHtmlPart(105)
}
printHtmlPart(106)
expressionOut.print(formDetails?.benefitsOutOfThirdPartyTransfer)
printHtmlPart(107)
expressionOut.print(formDetails?.mechanismOutOfThirdPartyTransfer)
printHtmlPart(108)
expressionOut.print(formDetails?.otherRelevantInfo)
printHtmlPart(109)
if(true && (formDetails?.isDeclarationDigitallySigned == 'true')) {
printHtmlPart(110)
}
else {
printHtmlPart(111)
}
printHtmlPart(112)
if(true && (formDetails?.submitCheck == true)) {
printHtmlPart(113)
}
else {
printHtmlPart(114)
}
printHtmlPart(115)
if(true && (formDetails?.transaction?.isPaymentMade == true)) {
printHtmlPart(116)
expressionOut.print(formDetails?.transaction?.transactionId)
printHtmlPart(117)
expressionOut.print(formDetails?.transaction?.paymentRefNo)
printHtmlPart(118)
createClosureForHtmlPart(119, 2)
invokeTag('link','g',632,['controller':("applicationManagement"),'action':("showIndividualDc"),'id':(formDetails?.transaction?.id),'target':("_blank"),'params':([filename: "paymentReceipt", dataName: "paymentReceipt", appFormId: formDetails?.id,csrfPreventionSalt:"${csrfPreventionSalt}"])],2)
printHtmlPart(120)
}
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1610009183045L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
