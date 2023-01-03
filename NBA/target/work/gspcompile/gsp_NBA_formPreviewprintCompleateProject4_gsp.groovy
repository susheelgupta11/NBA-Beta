
import org.nba.common.State

import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_NBA_formPreviewprintCompleateProject4_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/formPreview/printCompleateProject4.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',4,['gsp_sm_xmlClosingForEmptyTag':("/"),'http-equiv':("Content-Type"),'content':("text/html; charset=UTF-8")],-1)
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',5,['gsp_sm_xmlClosingForEmptyTag':("/"),'name':("layout"),'content':("projectPreview")],-1)
printHtmlPart(1)
createTagBody(2, {->
invokeTag('captureTitle','sitemesh',6,[:],-1)
})
invokeTag('wrapTitleTag','sitemesh',6,[:],2)
printHtmlPart(2)
})
invokeTag('captureHead','sitemesh',16,[:],1)
printHtmlPart(1)
createTagBody(1, {->
printHtmlPart(3)
if(true && (appForm?.transaction?.isPaymentMade == true)) {
printHtmlPart(4)
expressionOut.print(appForm?.appNumber)
printHtmlPart(5)
expressionOut.print(appForm?.submittedOn)
printHtmlPart(6)
}
printHtmlPart(7)
if(true && (listofFormData.size() != 0)) {
printHtmlPart(8)

int num = 1

printHtmlPart(9)

char alph = 65

printHtmlPart(9)
for( profile in (listofFormData) ) {
printHtmlPart(10)
expressionOut.print(alph)
printHtmlPart(11)
expressionOut.print(num)
printHtmlPart(12)

num++

printHtmlPart(13)

alph++

printHtmlPart(14)
expressionOut.print(profile?.title)
printHtmlPart(15)
expressionOut.print(profile?.firstName)
printHtmlPart(15)
expressionOut.print(profile?.middleName)
printHtmlPart(15)
expressionOut.print(profile?.lastName)
printHtmlPart(16)
if(true && (profile?.nationality == 'Non Indian')) {
printHtmlPart(17)
expressionOut.print(profile?.nationality)
printHtmlPart(18)
expressionOut.print(profile?.country?.country)
printHtmlPart(19)
}
else {
printHtmlPart(17)
expressionOut.print(profile?.nationality)
printHtmlPart(19)
}
printHtmlPart(20)
expressionOut.print(profile?.profile)
printHtmlPart(21)
expressionOut.print(profile?.address1)
printHtmlPart(15)
expressionOut.print(profile?.address2)
printHtmlPart(15)
expressionOut.print(profile?.address3)
printHtmlPart(22)
expressionOut.print(profile?.city)
printHtmlPart(23)
expressionOut.print(profile?.country?.country)
printHtmlPart(24)
expressionOut.print(profile?.mobile)
printHtmlPart(25)
expressionOut.print(profile?.phone)
printHtmlPart(26)
expressionOut.print(profile?.email)
printHtmlPart(27)
expressionOut.print(profile?.idProofSelect ? profile?.idProofSelect : 'Id Proof')
printHtmlPart(28)
expressionOut.print(profile?.idNum ? profile?.idNum  : 'N/A')
printHtmlPart(29)
expressionOut.print(profile?.passportNum ? profile?.passportNum : 'N/A')
printHtmlPart(30)
if(true && (profile?.authorizationLetter)) {
printHtmlPart(31)
}
else {
printHtmlPart(32)
}
printHtmlPart(33)
if(true && (profile?.authorizationNo)) {
printHtmlPart(34)
expressionOut.print(profile?.authorizationNo)
printHtmlPart(35)
}
else {
printHtmlPart(36)
}
printHtmlPart(37)
}
printHtmlPart(38)
}
printHtmlPart(39)
if(true && (listOfCompanyData?.size() != 0)) {
printHtmlPart(40)
}
printHtmlPart(41)

int x = 1

printHtmlPart(41)

char y = 65

printHtmlPart(41)
for( companyProfile1 in (listOfCompanyData) ) {
printHtmlPart(9)
if(true && (listOfCompanyData?.size() != 0)) {
printHtmlPart(10)
expressionOut.print(y)
printHtmlPart(42)
expressionOut.print(x)
printHtmlPart(12)

x++

printHtmlPart(13)

y++

printHtmlPart(43)
expressionOut.print(companyProfile1?.entityName)
printHtmlPart(44)
expressionOut.print(companyProfile1?.entityType)
printHtmlPart(45)
if(true && (companyProfile1?.nationality == 'notRegisteredInIndia')) {
printHtmlPart(46)
}
else {
printHtmlPart(47)
}
printHtmlPart(48)
expressionOut.print(companyProfile1?.address1)
printHtmlPart(15)
expressionOut.print(companyProfile1?.address2)
printHtmlPart(15)
expressionOut.print(companyProfile1?.address3)
printHtmlPart(15)
expressionOut.print(companyProfile1?.city)
printHtmlPart(49)
expressionOut.print(companyProfile1?.country?.id)
printHtmlPart(50)
expressionOut.print(companyProfile1?.pincode)
printHtmlPart(51)
expressionOut.print(companyProfile1?.mobile)
printHtmlPart(52)
expressionOut.print(companyProfile1?.phone)
printHtmlPart(53)
expressionOut.print(companyProfile1?.email)
printHtmlPart(54)
expressionOut.print(companyProfile1?.website)
printHtmlPart(55)
expressionOut.print(companyProfile1?.businessNature)
printHtmlPart(56)
if(true && (companyProfile1?.registrationDoc)) {
printHtmlPart(57)
}
else {
printHtmlPart(58)
}
printHtmlPart(59)
expressionOut.print(companyProfile1?.title)
printHtmlPart(15)
expressionOut.print(companyProfile1?.firstName)
printHtmlPart(15)
expressionOut.print(companyProfile1?.middleName)
printHtmlPart(15)
expressionOut.print(companyProfile1?.lastName)
printHtmlPart(60)
expressionOut.print(companyProfile1?.designation)
printHtmlPart(61)
if(true && (!companyProfile1)) {
printHtmlPart(62)
}
else if(true && (companyProfile1?.mobile?.contains('-'))) {
printHtmlPart(63)
expressionOut.print(companyProfile1?.mobile)
printHtmlPart(49)
}
printHtmlPart(64)
expressionOut.print(companyProfile1?.personEmail)
printHtmlPart(65)
if(true && (companyProfile1?.passportCopy)) {
printHtmlPart(66)
expressionOut.print(companyProfile1?.authRepresentativeIdSelect ? companyProfile1?.authRepresentativeIdSelect : 'Id Proof')
printHtmlPart(67)
expressionOut.print(companyProfile1?.idNum ? companyProfile1?.idNum : 'N/A')
printHtmlPart(68)
}
else {
printHtmlPart(58)
}
printHtmlPart(69)
if(true && (companyProfile1?.authorizationLetter)) {
printHtmlPart(70)
}
else {
printHtmlPart(71)
}
printHtmlPart(72)
}
printHtmlPart(41)
}
printHtmlPart(73)
if(true && (listOfCompanyData?.size() != 0)) {
printHtmlPart(74)
}
else {
printHtmlPart(75)
}
printHtmlPart(76)
if(true && (agentProfile != null)) {
printHtmlPart(77)
}
else {
printHtmlPart(78)
}
printHtmlPart(79)
if(true && (agentProfile != null)) {
printHtmlPart(80)
expressionOut.print(agentProfile?.profile)
printHtmlPart(81)
expressionOut.print(agentProfile?.title)
printHtmlPart(15)
expressionOut.print(agentProfile?.firstName)
printHtmlPart(15)
expressionOut.print(agentProfile?.middleName)
printHtmlPart(15)
expressionOut.print(agentProfile?.lastName)
printHtmlPart(82)
expressionOut.print(agentProfile?.address1)
printHtmlPart(15)
expressionOut.print(agentProfile?.address2)
printHtmlPart(15)
expressionOut.print(agentProfile?.address3)
printHtmlPart(83)
expressionOut.print(State.findById(agentProfile?.province)?.state)
printHtmlPart(84)
expressionOut.print(agentProfile?.city)
printHtmlPart(85)
expressionOut.print(agentProfile?.pincode)
printHtmlPart(86)
expressionOut.print(agentProfile?.mobile)
printHtmlPart(87)
expressionOut.print(agentProfile?.email)
printHtmlPart(88)
if(true && (agentProfile?.authorizationLetter)) {
printHtmlPart(89)
}
else {
printHtmlPart(90)
}
printHtmlPart(91)
if(true && (agentProfile?.passportCopy)) {
printHtmlPart(92)
expressionOut.print(agentProfile?.photoIdSelect ? agentProfile?.photoIdSelect : 'Photo Id Proof')
printHtmlPart(93)
}
else {
printHtmlPart(94)
}
printHtmlPart(95)
}
printHtmlPart(96)

int i = 1

printHtmlPart(97)
for( bioResource in (listOfBioResources) ) {
printHtmlPart(98)
out.print(i)
printHtmlPart(99)

i++

printHtmlPart(100)
expressionOut.print(bioResource?.accessIntention)
printHtmlPart(101)
expressionOut.print(bioResource?.commonName)
printHtmlPart(102)
expressionOut.print(bioResource?.scientificName)
printHtmlPart(103)
expressionOut.print(bioResource?.nature)
printHtmlPart(103)
expressionOut.print(bioResource?.biologicalResource)
printHtmlPart(104)
}
printHtmlPart(105)
expressionOut.print(appForm?.applicationNo)
printHtmlPart(106)
expressionOut.print(appForm?.dateOfApproval?.format('dd/MM/yyyy'))
printHtmlPart(107)
if(true && (appForm?.isbenefitSharingDetailImplemented == 'true')) {
printHtmlPart(108)
}
else {
printHtmlPart(109)
}
printHtmlPart(110)
if(true && (appForm?.isbenefitSharingDetailImplemented == 'true')) {
printHtmlPart(111)
expressionOut.print(appForm?.benefitMechanism)
printHtmlPart(112)
}
printHtmlPart(113)
if(true && (listOfThirdParty)) {
printHtmlPart(114)

int k = 1

printHtmlPart(114)
for( thirdPartyInst in (listOfThirdParty) ) {
printHtmlPart(115)
out.print(k)
printHtmlPart(116)

k++

printHtmlPart(117)
expressionOut.print(thirdPartyInst?.name)
printHtmlPart(118)
expressionOut.print(thirdPartyInst?.addressForComm)
printHtmlPart(118)
expressionOut.print(thirdPartyInst?.state)
printHtmlPart(118)
expressionOut.print(thirdPartyInst?.pincode)
printHtmlPart(118)
expressionOut.print(thirdPartyInst?.country)
printHtmlPart(118)
expressionOut.print(thirdPartyInst?.phone)
printHtmlPart(118)
expressionOut.print(thirdPartyInst?.fax)
printHtmlPart(118)
expressionOut.print(thirdPartyInst?.website)
printHtmlPart(118)
expressionOut.print(thirdPartyInst?.email)
printHtmlPart(119)
}
printHtmlPart(63)
}
printHtmlPart(120)
expressionOut.print(appForm?.thirdPartyTransferPurpose)
printHtmlPart(121)
expressionOut.print(appForm?.benefitsToTheThirdParty)
printHtmlPart(122)
if(true && (appForm.isAgreementBwApplicantAndThirdParty == 'true')) {
printHtmlPart(123)
}
else {
printHtmlPart(124)
}
printHtmlPart(125)
if(true && (appForm.isAgreementBwApplicantAndThirdParty == 'true')) {
printHtmlPart(126)
}
printHtmlPart(127)
expressionOut.print(appForm?.benefitsOutOfThirdPartyTransfer)
printHtmlPart(128)
expressionOut.print(appForm?.mechanismOutOfThirdPartyTransfer)
printHtmlPart(129)
expressionOut.print(appForm?.otherRelevantInfo)
printHtmlPart(130)
if(true && (appForm?.isDeclarationDigitallySigned == 'true')) {
printHtmlPart(131)
}
else {
printHtmlPart(132)
}
printHtmlPart(133)
if(true && (appForm?.submitCheck == true)) {
printHtmlPart(134)
}
else {
printHtmlPart(135)
}
printHtmlPart(136)
if(true && (appForm?.transaction?.isPaymentMade == true)) {
printHtmlPart(137)
expressionOut.print(appForm?.transaction?.transactionId)
printHtmlPart(138)
expressionOut.print(appForm?.transaction?.paymentRefNo)
printHtmlPart(139)
}
printHtmlPart(140)
})
invokeTag('captureBody','sitemesh',730,[:],1)
printHtmlPart(141)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1537268168000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
