
import org.nba.common.State

import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_NBA_formPreviewprintCompleateProject_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/formPreview/printCompleateProject.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(1)
createTagBody(1, {->
printHtmlPart(0)
invokeTag('captureMeta','sitemesh',5,['gsp_sm_xmlClosingForEmptyTag':("/"),'http-equiv':("Content-Type"),'content':("text/html; charset=UTF-8")],-1)
printHtmlPart(0)
invokeTag('captureMeta','sitemesh',6,['gsp_sm_xmlClosingForEmptyTag':("/"),'name':("layout"),'content':("projectPreview")],-1)
printHtmlPart(0)
createTagBody(2, {->
createClosureForHtmlPart(2, 3)
invokeTag('captureTitle','sitemesh',7,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',7,[:],2)
printHtmlPart(3)
})
invokeTag('captureHead','sitemesh',26,[:],1)
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(4)
if(true && (appForm?.transaction?.isPaymentMade == true)) {
printHtmlPart(5)
expressionOut.print(appForm?.appNumber)
printHtmlPart(6)
expressionOut.print(appForm?.submittedOn)
printHtmlPart(7)
}
printHtmlPart(8)
if(true && (listofFormData.size() != 0)) {
printHtmlPart(9)

int num= 1

printHtmlPart(10)

char alph = 65

printHtmlPart(10)
for( profile in (listofFormData) ) {
printHtmlPart(11)
expressionOut.print(alph)
printHtmlPart(12)
expressionOut.print(num)
printHtmlPart(13)

num++

printHtmlPart(14)

alph++

printHtmlPart(15)
expressionOut.print(profile?.title)
printHtmlPart(16)
expressionOut.print(profile?.firstName)
printHtmlPart(16)
expressionOut.print(profile?.middleName)
printHtmlPart(16)
expressionOut.print(profile?.lastName)
printHtmlPart(17)
if(true && (profile?.nationality == 'Non Indian')) {
printHtmlPart(18)
expressionOut.print(profile?.nationality)
printHtmlPart(19)
expressionOut.print(profile?.country?.country)
printHtmlPart(20)
}
else {
printHtmlPart(21)
expressionOut.print(profile?.nationality)
printHtmlPart(20)
}
printHtmlPart(22)
expressionOut.print(profile?.profile)
printHtmlPart(23)
expressionOut.print(profile?.address1)
printHtmlPart(24)
expressionOut.print(profile?.address2)
printHtmlPart(24)
expressionOut.print(profile?.address3)
printHtmlPart(25)
expressionOut.print(profile?.city)
printHtmlPart(26)
expressionOut.print(profile?.country?.country)
printHtmlPart(27)
expressionOut.print(profile?.mobile)
printHtmlPart(28)
expressionOut.print(profile?.phone)
printHtmlPart(29)
expressionOut.print(profile?.email)
printHtmlPart(30)
expressionOut.print(profile?.idProofSelect ? profile?.idProofSelect : 'Id Proof')
printHtmlPart(31)
expressionOut.print(profile?.idNum ? profile?.idNum  : 'N/A')
printHtmlPart(32)
expressionOut.print(profile?.passportNum ? profile?.passportNum : 'N/A')
printHtmlPart(33)
if(true && (profile?.authorizationLetter)) {
printHtmlPart(34)
}
else {
printHtmlPart(35)
}
printHtmlPart(36)
if(true && (profile?.authorizationNo)) {
printHtmlPart(37)
expressionOut.print(profile?.authorizationNo)
printHtmlPart(38)
}
else {
printHtmlPart(39)
}
printHtmlPart(40)
}
printHtmlPart(41)
}
printHtmlPart(42)
if(true && (listOfCompanyData?.size() != 0)) {
printHtmlPart(43)
}
printHtmlPart(44)

int x = 1

printHtmlPart(45)

char y = 65

printHtmlPart(10)
for( companyProfile1 in (listOfCompanyData) ) {
printHtmlPart(10)
if(true && (listOfCompanyData?.size() != 0)) {
printHtmlPart(46)
expressionOut.print(y)
printHtmlPart(47)
expressionOut.print(x)
printHtmlPart(48)

x++

printHtmlPart(49)

y++

printHtmlPart(50)
expressionOut.print(companyProfile1?.entityName)
printHtmlPart(51)
expressionOut.print(companyProfile1?.entityType)
printHtmlPart(52)
if(true && (companyProfile1?.nationality == 'notRegisteredInIndia')) {
printHtmlPart(53)
}
else {
printHtmlPart(54)
}
printHtmlPart(55)
expressionOut.print(companyProfile1?.address1)
printHtmlPart(16)
expressionOut.print(companyProfile1?.address2)
printHtmlPart(26)
expressionOut.print(companyProfile1?.address3)
printHtmlPart(16)
expressionOut.print(companyProfile1?.city)
printHtmlPart(16)
expressionOut.print(companyProfile1?.country?.id)
printHtmlPart(56)
expressionOut.print(companyProfile1?.pincode)
printHtmlPart(57)
expressionOut.print(companyProfile1?.mobile)
printHtmlPart(58)
expressionOut.print(companyProfile1?.phone)
printHtmlPart(59)
expressionOut.print(companyProfile1?.email)
printHtmlPart(60)
expressionOut.print(companyProfile1?.website)
printHtmlPart(61)
expressionOut.print(companyProfile1?.businessNature)
printHtmlPart(62)
if(true && (companyProfile1?.registrationDoc)) {
printHtmlPart(63)
}
else {
printHtmlPart(64)
}
printHtmlPart(65)
expressionOut.print(companyProfile1?.title)
printHtmlPart(16)
expressionOut.print(companyProfile1?.firstName)
printHtmlPart(56)
expressionOut.print(companyProfile1?.middleName)
printHtmlPart(16)
expressionOut.print(companyProfile1?.lastName)
printHtmlPart(66)
expressionOut.print(companyProfile1?.designation)
printHtmlPart(67)
if(true && (!companyProfile1)) {
printHtmlPart(68)
}
else if(true && (companyProfile1?.mobile?.contains('-'))) {
printHtmlPart(69)
expressionOut.print(companyProfile1?.mobile)
printHtmlPart(70)
}
printHtmlPart(71)
expressionOut.print(companyProfile1?.personEmail)
printHtmlPart(72)
expressionOut.print(companyProfile1?.authRepresentativeIdSelect ? companyProfile1?.authRepresentativeIdSelect : 'Id Proof')
printHtmlPart(70)
if(true && (companyProfile1?.passportCopy)) {
printHtmlPart(73)
expressionOut.print(companyProfile1?.idNum ? companyProfile1?.idNum : 'N/A')
printHtmlPart(74)
}
else {
printHtmlPart(64)
}
printHtmlPart(75)
if(true && (companyProfile1?.authorizationLetter)) {
printHtmlPart(76)
}
else {
printHtmlPart(77)
}
printHtmlPart(78)
}
printHtmlPart(14)
}
printHtmlPart(79)
if(true && (listOfCompanyData?.size() != 0)) {
printHtmlPart(80)
}
else {
printHtmlPart(81)
}
printHtmlPart(82)
if(true && (agentProfile != null)) {
printHtmlPart(83)
}
else {
printHtmlPart(84)
}
printHtmlPart(85)
if(true && (agentProfile != null)) {
printHtmlPart(86)
expressionOut.print(agentProfile?.profile)
printHtmlPart(87)
expressionOut.print(agentProfile?.title)
printHtmlPart(16)
expressionOut.print(agentProfile?.firstName)
printHtmlPart(16)
expressionOut.print(agentProfile?.middleName)
printHtmlPart(16)
expressionOut.print(agentProfile?.lastName)
printHtmlPart(88)
expressionOut.print(agentProfile?.address1)
printHtmlPart(16)
expressionOut.print(agentProfile?.address2)
printHtmlPart(16)
expressionOut.print(agentProfile?.address3)
printHtmlPart(89)
expressionOut.print(State.findById(agentProfile?.province)?.state)
printHtmlPart(90)
expressionOut.print(agentProfile?.city)
printHtmlPart(91)
expressionOut.print(agentProfile?.pincode)
printHtmlPart(92)
expressionOut.print(agentProfile?.mobile)
printHtmlPart(93)
expressionOut.print(agentProfile?.email)
printHtmlPart(94)
if(true && (agentProfile?.authorizationLetter)) {
printHtmlPart(95)
}
else {
printHtmlPart(96)
}
printHtmlPart(97)
if(true && (agentProfile?.passportCopy)) {
printHtmlPart(26)
expressionOut.print(agentProfile?.photoIdSelect ? agentProfile?.photoIdSelect : 'Photo Id Proof')
printHtmlPart(49)
}
else {
printHtmlPart(98)
}
printHtmlPart(99)
}
printHtmlPart(100)
if(true && (listOfBioResources)) {
printHtmlPart(101)

int i=1

printHtmlPart(26)
for( bioResource in (listOfBioResources) ) {
printHtmlPart(102)
out.print(i)
printHtmlPart(103)

i++

printHtmlPart(104)
expressionOut.print(bioResource?.accessIntention)
printHtmlPart(105)
expressionOut.print(bioResource?.commonName)
printHtmlPart(106)
expressionOut.print(bioResource?.scientificName)
printHtmlPart(107)
expressionOut.print(bioResource?.nature)
printHtmlPart(106)
expressionOut.print(bioResource?.quantity)
printHtmlPart(16)
expressionOut.print(bioResource?.qtyUnit)
printHtmlPart(106)
expressionOut.print(bioResource?.biologicalResource)
printHtmlPart(106)
expressionOut.print(bioResource?.fromTime?.format('dd/MM/yyyy'))
printHtmlPart(108)
expressionOut.print(bioResource?.toTime?.format('dd/MM/yyyy'))
printHtmlPart(106)
expressionOut.print(bioResource?.traditionalUse)
printHtmlPart(109)
}
printHtmlPart(110)
}
printHtmlPart(111)
if(true && (listOfLocations)) {
printHtmlPart(112)
if(true && (listOfLocations)) {
printHtmlPart(69)

int k=1

printHtmlPart(69)
for( location in (listOfLocations) ) {
printHtmlPart(113)
out.print(k)
printHtmlPart(114)

k++

printHtmlPart(115)
expressionOut.print(location?.bioResource?.scientificName)
printHtmlPart(116)
expressionOut.print(location?.source)
printHtmlPart(117)
if(true && (location?.village)) {
printHtmlPart(118)
expressionOut.print(location?.village)
printHtmlPart(119)
}
else {
printHtmlPart(120)
}
printHtmlPart(121)
if(true && (location?.town)) {
printHtmlPart(118)
expressionOut.print(location?.town)
printHtmlPart(119)
}
else {
printHtmlPart(120)
}
printHtmlPart(122)
if(true && (location?.district)) {
printHtmlPart(118)
expressionOut.print(location?.district)
printHtmlPart(119)
}
else {
printHtmlPart(120)
}
printHtmlPart(122)
if(true && (location?.state)) {
printHtmlPart(118)
expressionOut.print(location?.state)
printHtmlPart(119)
}
else {
printHtmlPart(120)
}
printHtmlPart(122)
if(true && (location?.traderName)) {
printHtmlPart(118)
expressionOut.print(location?.traderName)
printHtmlPart(119)
}
else {
printHtmlPart(120)
}
printHtmlPart(122)
if(true && (location?.traderContactDetails)) {
printHtmlPart(118)
expressionOut.print(location?.traderContactDetails)
printHtmlPart(119)
}
else {
printHtmlPart(120)
}
printHtmlPart(123)
}
printHtmlPart(70)
}
printHtmlPart(124)
}
printHtmlPart(125)
expressionOut.print(appForm?.nature)
printHtmlPart(126)
if(true && (appForm?.nature != 'No')) {
printHtmlPart(127)
expressionOut.print(appForm?.traditionalKnowledgeDesc)
printHtmlPart(126)
}
printHtmlPart(128)
if(true && (appForm?.nature == 'No')) {
printHtmlPart(129)
expressionOut.print(appForm?.nature)
printHtmlPart(126)
}
printHtmlPart(130)
if(true && (appForm?.nature != 'No')) {
printHtmlPart(131)
if(true && (listOfCommunityLocations)) {
printHtmlPart(70)

int a=1

printHtmlPart(70)
for( location in (listOfCommunityLocations) ) {
printHtmlPart(132)
out.print(a)
printHtmlPart(133)

a++

printHtmlPart(134)
expressionOut.print(location?.communityKnowledge)
printHtmlPart(135)
expressionOut.print(location?.village)
printHtmlPart(136)
expressionOut.print(location?.town)
printHtmlPart(137)
expressionOut.print(location?.district)
printHtmlPart(136)
expressionOut.print(State?.findById(location?.state)?.state)
printHtmlPart(138)
}
printHtmlPart(139)
}
printHtmlPart(140)
}
printHtmlPart(44)
if(true && (appForm?.selfAuthorizedPerson)) {
printHtmlPart(141)
}
else {
printHtmlPart(142)
}
printHtmlPart(45)
if(true && (!appForm?.selfAuthorizedPerson)) {
printHtmlPart(143)

int b=1

printHtmlPart(10)
for( profile in (listOfContactPerson) ) {
printHtmlPart(144)
out.print(b)
printHtmlPart(145)

b++

printHtmlPart(146)
expressionOut.print(profile?.nameOfContactPerson)
printHtmlPart(147)
expressionOut.print(profile?.addressOfContactPerson)
printHtmlPart(148)
expressionOut.print(profile?.mobileOfContactPerson)
printHtmlPart(148)
expressionOut.print(profile?.emailOfContactPerson)
printHtmlPart(149)
}
printHtmlPart(150)
}
printHtmlPart(151)
expressionOut.print(appForm?.purposeOfProposal)
printHtmlPart(152)
expressionOut.print(appForm?.briefDescription)
printHtmlPart(153)
if(true && (appForm?.isRisky == 'true')) {
printHtmlPart(154)
}
else {
printHtmlPart(155)
}
printHtmlPart(156)
if(true && (appForm?.isRisky == 'true')) {
printHtmlPart(157)
expressionOut.print(appForm?.riskInvolved)
printHtmlPart(158)
}
printHtmlPart(159)
if(true && (appForm?.instituteParticipation == 'true')) {
printHtmlPart(160)
}
else {
printHtmlPart(155)
}
printHtmlPart(161)
if(true && (appForm?.instituteParticipation == 'true')) {
printHtmlPart(162)
expressionOut.print(appForm?.detailsOfInstitute)
printHtmlPart(10)
}
else {
printHtmlPart(163)
}
printHtmlPart(164)
if(true && (appForm?.letterOfintent)) {
printHtmlPart(165)
}
else {
printHtmlPart(166)
}
printHtmlPart(167)
for( mapKeyValue in (quesAnswerMap) ) {
printHtmlPart(168)
expressionOut.print(mapKeyValue?.getKey()?.questionNo)
printHtmlPart(169)
expressionOut.print(mapKeyValue?.getKey()?.question)
printHtmlPart(170)
if(true && (mapKeyValue?.getValue()?.answer)) {
printHtmlPart(171)
expressionOut.print(mapKeyValue?.getValue()?.answer)
printHtmlPart(172)
}
else {
printHtmlPart(173)
}
printHtmlPart(174)
}
printHtmlPart(175)
if(true && (appForm?.isBenefitSharing?.equals('true'))) {
printHtmlPart(176)
}
else if(true && (appForm?.isBenefitSharing?.equals('false'))) {
printHtmlPart(177)
}
else {
printHtmlPart(178)
}
printHtmlPart(179)
if(true && (appForm?.isBenefitSharing?.equals('true'))) {
printHtmlPart(180)
if(true && (appForm?.sharingDoc)) {
printHtmlPart(63)
}
else {
printHtmlPart(181)
}
printHtmlPart(182)
}
printHtmlPart(183)
if(true && (appForm?.companyProfiles?.size() != 0)) {
printHtmlPart(184)
if(true && (appForm?.payBenefitSharing == 'Monetary')) {
printHtmlPart(185)
}
else if(true && (appForm?.payBenefitSharing == 'Non-Monetary')) {
printHtmlPart(186)
}
else {
printHtmlPart(187)
}
printHtmlPart(188)
if(true && (appForm?.isMonetary == 'purchasePrice')) {
printHtmlPart(189)
}
else if(true && (appForm?.isMonetary == 'exFactorySale')) {
printHtmlPart(190)
}
else {
printHtmlPart(187)
}
printHtmlPart(191)
}
printHtmlPart(192)
if(true && (appForm?.otherInfo)) {
printHtmlPart(171)
expressionOut.print(appForm?.otherInfo)
printHtmlPart(172)
}
else {
printHtmlPart(173)
}
printHtmlPart(193)
if(true && (appForm?.isTradingPurpose?.equals('true'))) {
printHtmlPart(194)
if(true && (listOfBioResources)) {
printHtmlPart(69)

int i=1

printHtmlPart(69)
for( bioResource in (listOfBioResources) ) {
printHtmlPart(195)
out.print(i)
printHtmlPart(114)

i++

printHtmlPart(115)
expressionOut.print(bioResource?.accessIntention)
printHtmlPart(196)
if(true && (bioResource?.accessIntention == 'Biological Resources' || bioResource?.accessIntention == 'Biological Resources & Traditional Knowledge' || bioResource?.accessIntention == 'Associated Knowledge')) {
printHtmlPart(197)
expressionOut.print(bioResource?.commonName)
printHtmlPart(198)
expressionOut.print(bioResource?.scientificName)
printHtmlPart(198)
expressionOut.print(bioResource?.nature)
printHtmlPart(198)
expressionOut.print(bioResource?.biologicalResource)
printHtmlPart(199)
}
else {
printHtmlPart(200)
}
printHtmlPart(201)
if(true && (bioResource?.accessIntention == 'Biological Resources' || bioResource?.accessIntention == 'Biological Resources & Traditional Knowledge' || bioResource?.accessIntention == 'Associated Knowledge')) {
printHtmlPart(202)
expressionOut.print(bioResource?.quantity)
printHtmlPart(16)
expressionOut.print(bioResource?.qtyUnit)
printHtmlPart(203)
}
else {
printHtmlPart(204)
}
printHtmlPart(205)
expressionOut.print(bioResource?.ratePerUnit)
printHtmlPart(206)
expressionOut.print(bioResource?.stateBiodeversityBoard)
printHtmlPart(207)
expressionOut.print(bioResource?.prospectiveBuyers)
printHtmlPart(208)
}
}
else {
printHtmlPart(209)
}
printHtmlPart(210)
if(true && (appForm?.conditionOfAbs == true)) {
printHtmlPart(211)
}
printHtmlPart(212)
if(true && (appForm?.approvalOfNba == true)) {
printHtmlPart(213)
}
printHtmlPart(10)
if(true && (appForm?.recordsWithTheNba == true)) {
printHtmlPart(214)
}
printHtmlPart(10)
if(true && (appForm?.infromationTrue == true)) {
printHtmlPart(215)
}
printHtmlPart(216)
}
printHtmlPart(217)
if(true && (appForm?.isDeclarationDigitallySigned == 'true')) {
printHtmlPart(218)
}
else {
printHtmlPart(219)
}
printHtmlPart(220)
if(true && (appForm?.submitCheck == true)) {
printHtmlPart(221)
}
else {
printHtmlPart(222)
}
printHtmlPart(223)
if(true && (appForm?.transaction?.isPaymentMade == true)) {
printHtmlPart(224)
expressionOut.print(appForm?.transaction?.transactionId)
printHtmlPart(225)
expressionOut.print(appForm?.transaction?.paymentRefNo)
printHtmlPart(226)
}
printHtmlPart(227)
})
invokeTag('captureBody','sitemesh',1266,[:],1)
printHtmlPart(228)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1541053708000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
