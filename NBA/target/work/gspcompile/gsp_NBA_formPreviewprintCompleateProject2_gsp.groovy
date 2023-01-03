
import org.nba.common.State

import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_NBA_formPreviewprintCompleateProject2_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/formPreview/printCompleateProject2.gsp" }
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
invokeTag('captureHead','sitemesh',15,[:],1)
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

int num= 1

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
printHtmlPart(20)
expressionOut.print(profile?.nationality)
printHtmlPart(19)
}
printHtmlPart(21)
expressionOut.print(profile?.profile)
printHtmlPart(22)
expressionOut.print(profile?.address1)
printHtmlPart(15)
expressionOut.print(profile?.address2)
printHtmlPart(15)
expressionOut.print(profile?.address3)
printHtmlPart(23)
expressionOut.print(profile?.city)
printHtmlPart(24)
expressionOut.print(profile?.country?.country)
printHtmlPart(25)
expressionOut.print(profile?.mobile)
printHtmlPart(26)
expressionOut.print(profile?.phone)
printHtmlPart(27)
expressionOut.print(profile?.email)
printHtmlPart(28)
expressionOut.print(profile?.idProofSelect ? profile?.idProofSelect : 'Id Proof')
printHtmlPart(29)
expressionOut.print(profile?.idNum ? profile?.idNum  : 'N/A')
printHtmlPart(30)
expressionOut.print(profile?.passportNum ? profile?.passportNum : 'N/A')
printHtmlPart(31)
if(true && (profile?.authorizationLetter)) {
printHtmlPart(32)
}
else {
printHtmlPart(33)
}
printHtmlPart(34)
if(true && (profile?.authorizationNo)) {
printHtmlPart(35)
expressionOut.print(profile?.authorizationNo)
printHtmlPart(36)
}
else {
printHtmlPart(37)
}
printHtmlPart(38)
}
printHtmlPart(39)
}
printHtmlPart(40)
if(true && (listOfCompanyData?.size() != 0)) {
printHtmlPart(41)
}
printHtmlPart(42)

int x = 1

printHtmlPart(43)

char y = 65

printHtmlPart(9)
for( companyProfile1 in (listOfCompanyData) ) {
printHtmlPart(9)
if(true && (listOfCompanyData?.size() != 0)) {
printHtmlPart(44)
expressionOut.print(y)
printHtmlPart(45)
expressionOut.print(x)
printHtmlPart(46)

x++

printHtmlPart(47)

y++

printHtmlPart(48)
expressionOut.print(companyProfile1?.entityName)
printHtmlPart(49)
expressionOut.print(companyProfile1?.entityType)
printHtmlPart(50)
if(true && (companyProfile1?.nationality == 'notRegisteredInIndia')) {
printHtmlPart(51)
}
else {
printHtmlPart(52)
}
printHtmlPart(53)
expressionOut.print(companyProfile1?.address1)
printHtmlPart(15)
expressionOut.print(companyProfile1?.address2)
printHtmlPart(15)
expressionOut.print(companyProfile1?.address3)
printHtmlPart(15)
expressionOut.print(companyProfile1?.city)
printHtmlPart(54)
expressionOut.print(companyProfile1?.country?.id)
printHtmlPart(55)
expressionOut.print(companyProfile1?.pincode)
printHtmlPart(56)
expressionOut.print(companyProfile1?.mobile)
printHtmlPart(57)
expressionOut.print(companyProfile1?.phone)
printHtmlPart(58)
expressionOut.print(companyProfile1?.email)
printHtmlPart(59)
expressionOut.print(companyProfile1?.website)
printHtmlPart(60)
expressionOut.print(companyProfile1?.businessNature)
printHtmlPart(61)
if(true && (companyProfile1?.registrationDoc)) {
printHtmlPart(62)
}
else {
printHtmlPart(63)
}
printHtmlPart(64)
expressionOut.print(companyProfile1?.title)
printHtmlPart(15)
expressionOut.print(companyProfile1?.firstName)
printHtmlPart(15)
expressionOut.print(companyProfile1?.middleName)
printHtmlPart(15)
expressionOut.print(companyProfile1?.lastName)
printHtmlPart(65)
expressionOut.print(companyProfile1?.designation)
printHtmlPart(66)
if(true && (!companyProfile1)) {
printHtmlPart(67)
}
else if(true && (companyProfile1?.mobile?.contains('-'))) {
printHtmlPart(68)
expressionOut.print(companyProfile1?.mobile)
printHtmlPart(69)
}
printHtmlPart(70)
expressionOut.print(companyProfile1?.personEmail)
printHtmlPart(71)
if(true && (companyProfile1?.passportCopy)) {
printHtmlPart(72)
expressionOut.print(companyProfile1?.authRepresentativeIdSelect ? companyProfile1?.authRepresentativeIdSelect : 'Id Proof')
printHtmlPart(73)
expressionOut.print(companyProfile1?.idNum ? companyProfile1?.idNum : 'N/A')
printHtmlPart(74)
}
else {
printHtmlPart(63)
}
printHtmlPart(75)
if(true && (companyProfile1?.authorizationLetter)) {
printHtmlPart(76)
}
else {
printHtmlPart(63)
}
printHtmlPart(77)
}
printHtmlPart(13)
}
printHtmlPart(78)
if(true && (listOfCompanyData?.size() != 0)) {
printHtmlPart(79)
}
else {
printHtmlPart(80)
}
printHtmlPart(81)
if(true && (agentProfile != null)) {
printHtmlPart(82)
}
else {
printHtmlPart(83)
}
printHtmlPart(84)
if(true && (agentProfile != null)) {
printHtmlPart(85)
expressionOut.print(agentProfile?.profile)
printHtmlPart(86)
expressionOut.print(agentProfile?.title)
printHtmlPart(15)
expressionOut.print(agentProfile?.firstName)
printHtmlPart(15)
expressionOut.print(agentProfile?.middleName)
printHtmlPart(15)
expressionOut.print(agentProfile?.lastName)
printHtmlPart(87)
expressionOut.print(agentProfile?.address1)
printHtmlPart(15)
expressionOut.print(agentProfile?.address2)
printHtmlPart(15)
expressionOut.print(agentProfile?.address3)
printHtmlPart(88)
expressionOut.print(State.findById(agentProfile?.province)?.state)
printHtmlPart(89)
expressionOut.print(agentProfile?.city)
printHtmlPart(90)
expressionOut.print(agentProfile?.pincode)
printHtmlPart(91)
expressionOut.print(agentProfile?.mobile)
printHtmlPart(92)
expressionOut.print(agentProfile?.email)
printHtmlPart(93)
if(true && (agentProfile?.authorizationLetter)) {
printHtmlPart(94)
}
else {
printHtmlPart(95)
}
printHtmlPart(96)
if(true && (agentProfile?.passportCopy)) {
printHtmlPart(97)
expressionOut.print(agentProfile?.photoIdSelect ? agentProfile?.photoIdSelect : 'Photo Id Proof')
printHtmlPart(98)
}
else {
printHtmlPart(99)
}
printHtmlPart(100)
}
printHtmlPart(101)
expressionOut.print(appForm?.briefDescription)
printHtmlPart(102)
expressionOut.print(appForm?.resultsOfResearch)
printHtmlPart(103)
if(true && (listOfBioResources)) {
printHtmlPart(104)
}
else {
printHtmlPart(105)
}
printHtmlPart(106)
if(true && (listOfBioResources)) {
printHtmlPart(107)

int i=1

printHtmlPart(69)
for( bioResource in (listOfBioResources) ) {
printHtmlPart(108)
out.print(i)
printHtmlPart(109)

i++

printHtmlPart(110)
expressionOut.print(bioResource?.accessIntention)
printHtmlPart(111)
expressionOut.print(bioResource?.commonName)
printHtmlPart(112)
expressionOut.print(bioResource?.scientificName)
printHtmlPart(113)
expressionOut.print(bioResource?.nature)
printHtmlPart(114)
expressionOut.print(bioResource?.biologicalResource)
printHtmlPart(115)
}
printHtmlPart(116)
}
printHtmlPart(117)
if(true && (listOfLocations)) {
printHtmlPart(118)
}
else {
printHtmlPart(119)
}
printHtmlPart(120)
if(true && (listOfLocations)) {
printHtmlPart(121)
if(true && (listOfLocations)) {
printHtmlPart(122)

int k=1

printHtmlPart(122)
for( location in (listOfLocations) ) {
printHtmlPart(123)
out.print(k)
printHtmlPart(124)

k++

printHtmlPart(125)
expressionOut.print(location?.bioResource?.scientificName)
printHtmlPart(126)
expressionOut.print(location?.source)
printHtmlPart(127)
if(true && (location?.village)) {
printHtmlPart(128)
expressionOut.print(location?.village)
printHtmlPart(129)
}
else {
printHtmlPart(130)
}
printHtmlPart(131)
if(true && (location?.town)) {
printHtmlPart(128)
expressionOut.print(location?.town)
printHtmlPart(129)
}
else {
printHtmlPart(130)
}
printHtmlPart(132)
if(true && (location?.district)) {
printHtmlPart(128)
expressionOut.print(location?.district)
printHtmlPart(129)
}
else {
printHtmlPart(130)
}
printHtmlPart(132)
if(true && (location?.state)) {
printHtmlPart(128)
expressionOut.print(location?.state)
printHtmlPart(129)
}
else {
printHtmlPart(130)
}
printHtmlPart(132)
if(true && (location?.traderName)) {
printHtmlPart(128)
expressionOut.print(location?.traderName)
printHtmlPart(129)
}
else {
printHtmlPart(130)
}
printHtmlPart(132)
if(true && (location?.traderContactDetails)) {
printHtmlPart(128)
expressionOut.print(location?.traderContactDetails)
printHtmlPart(129)
}
else {
printHtmlPart(130)
}
printHtmlPart(133)
}
printHtmlPart(68)
}
printHtmlPart(134)
}
printHtmlPart(135)
if(true && (appForm?.individualProfiles?.size() > 0 && appForm?.individualProfiles?.getAt(0)?.nationality == 'Non Indian' || appForm?.individualProfiles?.getAt(0)?.nationality == 'Non-Resident Indian')) {
printHtmlPart(136)
if(true && (appForm.isApprovalOfNbaObtained == 'true')) {
printHtmlPart(137)
}
else {
printHtmlPart(138)
}
printHtmlPart(139)
if(true && (appForm?.nbaApprovalFile)) {
printHtmlPart(140)
}
else {
printHtmlPart(67)
}
printHtmlPart(141)
}
printHtmlPart(142)
if(true && (appForm.isNoForTraditional == 'No')) {
printHtmlPart(143)
expressionOut.print(appForm.isNoForTraditional)
printHtmlPart(144)
}
printHtmlPart(42)
if(true && (appForm.isNoForTraditional != 'No')) {
printHtmlPart(145)
expressionOut.print(appForm?.nature)
printHtmlPart(146)
}
printHtmlPart(147)
if(true && (appForm.isNoForTraditional != 'No')) {
printHtmlPart(148)
expressionOut.print(appForm?.traditionalKnowledgeDesc)
printHtmlPart(149)
}
printHtmlPart(150)
if(true && (appForm.isNoForTraditional == 'No' || listOfCommunityLocations?.size() == 0)) {
printHtmlPart(151)
}
printHtmlPart(152)
if(true && (listOfCommunityLocations)) {
printHtmlPart(153)
if(true && (listOfCommunityLocations)) {
printHtmlPart(68)

int a=1

printHtmlPart(68)
for( location in (listOfCommunityLocations) ) {
printHtmlPart(154)
out.print(a)
printHtmlPart(155)

a++

printHtmlPart(156)
expressionOut.print(location?.communityKnowledge)
printHtmlPart(157)
expressionOut.print(location?.village)
printHtmlPart(158)
expressionOut.print(location?.town)
printHtmlPart(159)
expressionOut.print(location?.district)
printHtmlPart(158)
expressionOut.print(State?.findById(location?.state)?.state)
printHtmlPart(160)
}
printHtmlPart(42)
}
printHtmlPart(161)
}
printHtmlPart(162)
if(true && (appForm?.detailsOfInstitute)) {
printHtmlPart(163)
expressionOut.print(appForm?.detailsOfInstitute)
printHtmlPart(164)
}
else {
printHtmlPart(165)
}
printHtmlPart(166)
if(true && (appForm?.bonafideLetter || appForm.isResearchParticipation == 'true')) {
printHtmlPart(167)
}
else {
printHtmlPart(168)
}
printHtmlPart(169)
expressionOut.print(appForm?.detailsOfInstitute)
printHtmlPart(170)
expressionOut.print(appForm?.useofResearchResults)
printHtmlPart(171)
if(true && (appForm?.benefitsToTheIndividualOrOrganization)) {
printHtmlPart(172)
expressionOut.print(appForm?.benefitsToTheIndividualOrOrganization)
printHtmlPart(173)
}
else {
printHtmlPart(174)
}
printHtmlPart(175)
if(true && (appForm?.benefitsToTheApplicant)) {
printHtmlPart(172)
expressionOut.print(appForm?.benefitsToTheApplicant)
printHtmlPart(173)
}
else {
printHtmlPart(174)
}
printHtmlPart(176)
if(true && (appForm?.collaborationDetails)) {
printHtmlPart(177)
}
else {
printHtmlPart(178)
}
printHtmlPart(179)
if(true && (appForm?.collaborationDetails)) {
printHtmlPart(180)
if(true && (appForm?.collaborationDetails)) {
printHtmlPart(172)
expressionOut.print(appForm?.collaborationDetails)
printHtmlPart(173)
}
else {
printHtmlPart(181)
}
printHtmlPart(182)
createTagBody(3, {->
printHtmlPart(183)
expressionOut.print(appForm?.mouFileName)
printHtmlPart(68)
})
invokeTag('link','g',910,['controller':("form2"),'action':("showDc"),'id':(appForm?.id),'target':("_blank"),'params':([filename: 'mouFileName', dataName: 'mouFileName'])],3)
printHtmlPart(184)
}
printHtmlPart(185)
if(true && (appForm?.isDeclarationDigitallySigned == 'true')) {
printHtmlPart(186)
}
else {
printHtmlPart(187)
}
printHtmlPart(188)
if(true && (appForm?.submitCheck == true)) {
printHtmlPart(189)
}
else {
printHtmlPart(190)
}
printHtmlPart(191)
if(true && (appForm?.transaction?.isPaymentMade == true)) {
printHtmlPart(192)
expressionOut.print(appForm?.transaction?.transactionId)
printHtmlPart(193)
expressionOut.print(appForm?.transaction?.paymentRefNo)
printHtmlPart(194)
}
printHtmlPart(195)
})
invokeTag('captureBody','sitemesh',997,[:],1)
printHtmlPart(196)
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
