
import org.nba.common.*

import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_NBA_formPreviewprintCompleateProject3_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/formPreview/printCompleateProject3.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',5,['gsp_sm_xmlClosingForEmptyTag':("/"),'http-equiv':("Content-Type"),'content':("text/html; charset=UTF-8")],-1)
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',6,['gsp_sm_xmlClosingForEmptyTag':("/"),'name':("layout"),'content':("projectPreview")],-1)
printHtmlPart(1)
createTagBody(2, {->
invokeTag('captureTitle','sitemesh',7,[:],-1)
})
invokeTag('wrapTitleTag','sitemesh',7,[:],2)
printHtmlPart(2)
})
invokeTag('captureHead','sitemesh',17,[:],1)
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
if(true && (profile?.idProofSelect)) {
printHtmlPart(15)
expressionOut.print(profile?.idProofSelect)
printHtmlPart(28)
}
else {
printHtmlPart(29)
}
printHtmlPart(30)
expressionOut.print(profile?.idNum ? profile?.idNum  : 'N/A')
printHtmlPart(31)
expressionOut.print(profile?.passportNum ? profile?.passportNum : 'N/A')
printHtmlPart(32)
if(true && (profile?.authorizationLetter)) {
printHtmlPart(33)
}
else {
printHtmlPart(34)
}
printHtmlPart(35)
if(true && (profile?.authorizationNo)) {
printHtmlPart(36)
expressionOut.print(profile?.authorizationNo)
printHtmlPart(37)
}
else {
printHtmlPart(38)
}
printHtmlPart(39)
}
printHtmlPart(40)
}
printHtmlPart(41)
if(true && (listOfCompanyData?.size() != 0)) {
printHtmlPart(42)
}
printHtmlPart(43)

int x = 1

printHtmlPart(43)

char y = 65

printHtmlPart(43)
for( companyProfile1 in (listOfCompanyData) ) {
printHtmlPart(9)
if(true && (listOfCompanyData?.size() != 0)) {
printHtmlPart(10)
expressionOut.print(y)
printHtmlPart(44)
expressionOut.print(x)
printHtmlPart(45)

x++

printHtmlPart(13)

y++

printHtmlPart(46)
expressionOut.print(companyProfile1?.entityName)
printHtmlPart(47)
expressionOut.print(companyProfile1?.entityType)
printHtmlPart(48)
if(true && (companyProfile1?.nationality == 'notRegisteredInIndia')) {
printHtmlPart(49)
}
else if(true && (companyProfile1?.nationality == 'noNonIndianParticipation')) {
printHtmlPart(50)
}
else {
printHtmlPart(51)
}
printHtmlPart(52)
expressionOut.print(companyProfile1?.address1)
printHtmlPart(15)
expressionOut.print(companyProfile1?.address2)
printHtmlPart(15)
expressionOut.print(companyProfile1?.address3)
printHtmlPart(53)
expressionOut.print(companyProfile1?.city)
printHtmlPart(15)
expressionOut.print(companyProfile1?.country?.id)
printHtmlPart(54)
expressionOut.print(companyProfile1?.pincode)
printHtmlPart(55)
expressionOut.print(companyProfile1?.mobile)
printHtmlPart(56)
expressionOut.print(companyProfile1?.phone)
printHtmlPart(57)
expressionOut.print(companyProfile1?.email)
printHtmlPart(58)
expressionOut.print(companyProfile1?.website)
printHtmlPart(59)
expressionOut.print(companyProfile1?.businessNature)
printHtmlPart(60)
if(true && (companyProfile1?.registrationDoc)) {
printHtmlPart(61)
}
else {
printHtmlPart(62)
}
printHtmlPart(63)
expressionOut.print(companyProfile1?.title)
printHtmlPart(15)
expressionOut.print(companyProfile1?.firstName)
printHtmlPart(15)
expressionOut.print(companyProfile1?.middleName)
printHtmlPart(53)
expressionOut.print(companyProfile1?.lastName)
printHtmlPart(64)
expressionOut.print(companyProfile1?.designation)
printHtmlPart(65)
if(true && (!companyProfile1)) {
printHtmlPart(66)
}
else if(true && (companyProfile1?.mobile?.contains('-'))) {
printHtmlPart(67)
expressionOut.print(companyProfile1?.mobile)
printHtmlPart(53)
}
printHtmlPart(68)
expressionOut.print(companyProfile1?.personEmail)
printHtmlPart(69)
if(true && (companyProfile1?.passportCopy)) {
printHtmlPart(70)
expressionOut.print(companyProfile1?.authRepresentativeIdSelect ? companyProfile1?.authRepresentativeIdSelect : 'Id Proof')
printHtmlPart(71)
expressionOut.print(companyProfile1?.idNum ? companyProfile1?.idNum : 'N/A')
printHtmlPart(72)
}
else {
printHtmlPart(62)
}
printHtmlPart(73)
if(true && (companyProfile1?.authorizationLetter)) {
printHtmlPart(74)
}
else {
printHtmlPart(62)
}
printHtmlPart(75)
}
printHtmlPart(43)
}
printHtmlPart(76)
if(true && (listOfCompanyData?.size() != 0)) {
printHtmlPart(77)
}
else {
printHtmlPart(78)
}
printHtmlPart(79)
if(true && (agentProfile != null)) {
printHtmlPart(80)
}
else {
printHtmlPart(81)
}
printHtmlPart(82)
if(true && (agentProfile != null)) {
printHtmlPart(83)
if(true && (agentProfile?.profile?.contains('-'))) {
printHtmlPart(84)
expressionOut.print(agentProfile?.profile?.split('-')[1])
printHtmlPart(67)
}
else {
printHtmlPart(84)
expressionOut.print(agentProfile?.profile)
printHtmlPart(67)
}
printHtmlPart(85)
expressionOut.print(agentProfile?.title)
printHtmlPart(15)
expressionOut.print(agentProfile?.firstName)
printHtmlPart(67)
expressionOut.print(agentProfile?.middleName)
printHtmlPart(15)
expressionOut.print(agentProfile?.lastName)
printHtmlPart(86)
expressionOut.print(agentProfile?.address1)
printHtmlPart(15)
expressionOut.print(agentProfile?.address2)
printHtmlPart(67)
expressionOut.print(agentProfile?.address3)
printHtmlPart(87)
expressionOut.print(State.findById(agentProfile?.province)?.state)
printHtmlPart(88)
expressionOut.print(agentProfile?.city)
printHtmlPart(89)
expressionOut.print(agentProfile?.pincode)
printHtmlPart(90)
expressionOut.print(agentProfile?.mobile)
printHtmlPart(91)
expressionOut.print(agentProfile?.email)
printHtmlPart(92)
if(true && (agentProfile?.authorizationLetter)) {
printHtmlPart(93)
}
else {
printHtmlPart(94)
}
printHtmlPart(95)
if(true && (agentProfile?.passportCopy)) {
printHtmlPart(96)
expressionOut.print(agentProfile?.photoIdSelect ? agentProfile?.photoIdSelect : 'Photo Id Proof')
printHtmlPart(97)
}
else {
printHtmlPart(98)
}
printHtmlPart(99)
}
printHtmlPart(100)
expressionOut.print(appForm?.titleOfIPR)
printHtmlPart(101)
expressionOut.print(appForm?.abstractOfIPR)
printHtmlPart(102)
loop:{
int i = 0
for( countries in (appForm?.detailsOfTerritories) ) {
printHtmlPart(103)
if(true && (appForm?.detailsOfTerritories?.size() - i == 1)) {
printHtmlPart(104)
expressionOut.print(countries?.country)
printHtmlPart(105)
}
else {
printHtmlPart(106)
expressionOut.print(countries?.country)
printHtmlPart(107)
}
printHtmlPart(108)
i++
}
}
printHtmlPart(109)
if(true && (appForm?.isIPApplicationFiled == 'true')) {
printHtmlPart(110)
}
else {
printHtmlPart(111)
}
printHtmlPart(112)
if(true && (appForm?.isIPApplicationFiled == 'true')) {
printHtmlPart(113)

i=1

printHtmlPart(114)
for( ipr in (listOfIPRDetails) ) {
printHtmlPart(115)
out.print(i)
printHtmlPart(116)
expressionOut.print(Country.get(ipr?.country)?.country)
printHtmlPart(117)
expressionOut.print(ipr?.patentApplicationNo)
printHtmlPart(117)
expressionOut.print(ipr?.patentApplicationDate?.format('dd/MM/yyyy'))
printHtmlPart(117)
expressionOut.print(ipr?.status)
printHtmlPart(117)
expressionOut.print(ipr?.patentNo)
printHtmlPart(15)
expressionOut.print(ipr?.patentDate?.format('dd/MM/yyyy'))
printHtmlPart(118)
if(true && (ipr?.reasons)) {
printHtmlPart(119)
expressionOut.print(ipr?.reasons)
printHtmlPart(84)
}
else {
printHtmlPart(120)
}
printHtmlPart(121)
}
printHtmlPart(122)
}
printHtmlPart(123)
if(true && (listOfBioResources)) {
printHtmlPart(124)

int i=1

printHtmlPart(114)
for( bioResource in (listOfBioResources) ) {
printHtmlPart(125)
out.print(i)
printHtmlPart(126)

i++

printHtmlPart(127)
expressionOut.print(bioResource?.accessIntention)
printHtmlPart(128)
expressionOut.print(bioResource?.commonName)
printHtmlPart(129)
expressionOut.print(bioResource?.scientificName)
printHtmlPart(130)
expressionOut.print(bioResource?.nature)
printHtmlPart(131)
expressionOut.print(bioResource?.biologicalResource)
printHtmlPart(132)
}
printHtmlPart(133)
}
printHtmlPart(134)
if(true && (appForm?.individualProfiles?.getAt(0)?.nationality == 'Non Indian' || appForm?.individualProfiles?.getAt(0)?.nationality == 'Non-Resident Indian' 
					 || appForm?.companyProfiles?.getAt(0)?.nationality == 'registeredInIndia' || appForm?.companyProfiles?.getAt(0)?.nationality == 'noNonIndianParticipation')) {
printHtmlPart(135)
if(true && (appForm.isApprovalOfNbaObtainedForm3 == 'true')) {
printHtmlPart(136)
}
else {
printHtmlPart(137)
}
printHtmlPart(138)
if(true && (appForm.isApprovalOfNbaObtainedForm3 == 'false')) {
printHtmlPart(139)
if(true && (appForm?.reasonOFNotObtainedApproval)) {
printHtmlPart(140)
expressionOut.print(appForm?.reasonOFNotObtainedApproval)
printHtmlPart(141)
}
else {
printHtmlPart(142)
}
printHtmlPart(143)
}
else if(true && (appForm.isApprovalOfNbaObtainedForm3 == 'true')) {
printHtmlPart(144)
if(true && (appForm?.applicationNo)) {
printHtmlPart(145)
expressionOut.print(appForm?.applicationNo)
printHtmlPart(146)
}
else {
printHtmlPart(147)
}
printHtmlPart(148)
if(true && (appForm?.isApprovalOfNbaObtainedForm3 == 'true')) {
printHtmlPart(145)
expressionOut.print(appForm?.dateOfApproval?.format('dd/MM/yyyy'))
printHtmlPart(146)
}
else {
printHtmlPart(147)
}
printHtmlPart(149)
if(true && (appForm?.nbaApprovalFile && appForm?.isApprovalOfNbaObtainedForm3 == 'true')) {
printHtmlPart(13)
createClosureForHtmlPart(150, 5)
invokeTag('link','g',669,['controller':("form3"),'action':("showDc"),'id':(appForm?.id),'target':("_blank"),'params':([filename: "nbaApprovalFileName", dataName: "nbaApprovalFileName",csrfPreventionSalt:"${csrfPreventionSalt}"])],5)
printHtmlPart(9)
}
else {
printHtmlPart(66)
}
printHtmlPart(151)
}
printHtmlPart(152)
}
printHtmlPart(153)
if(true && (listOfLocations)) {
printHtmlPart(154)
if(true && (listOfLocations)) {
printHtmlPart(119)

int k=1

printHtmlPart(119)
for( location in (listOfLocations) ) {
printHtmlPart(155)
out.print(k)
printHtmlPart(156)

k++

printHtmlPart(157)
expressionOut.print(location?.bioResource?.scientificName)
printHtmlPart(158)
expressionOut.print(location?.source)
printHtmlPart(159)
if(true && (location?.village)) {
printHtmlPart(160)
expressionOut.print(location?.village)
printHtmlPart(161)
}
else {
printHtmlPart(162)
}
printHtmlPart(163)
if(true && (location?.town)) {
printHtmlPart(160)
expressionOut.print(location?.town)
printHtmlPart(161)
}
else {
printHtmlPart(162)
}
printHtmlPart(164)
if(true && (location?.district)) {
printHtmlPart(160)
expressionOut.print(location?.district)
printHtmlPart(161)
}
else {
printHtmlPart(162)
}
printHtmlPart(164)
if(true && (location?.state)) {
printHtmlPart(160)
expressionOut.print(location?.state)
printHtmlPart(161)
}
else {
printHtmlPart(162)
}
printHtmlPart(164)
if(true && (location?.traderName)) {
printHtmlPart(160)
expressionOut.print(location?.traderName)
printHtmlPart(161)
}
else {
printHtmlPart(162)
}
printHtmlPart(164)
if(true && (location?.traderContactDetails)) {
printHtmlPart(160)
expressionOut.print(location?.traderContactDetails)
printHtmlPart(161)
}
else {
printHtmlPart(162)
}
printHtmlPart(165)
}
printHtmlPart(84)
}
printHtmlPart(166)
}
printHtmlPart(167)
if(true && (appForm?.isBioObtainedOutsideIndia == 'true')) {
printHtmlPart(168)
}
else if(true && (appForm?.isBioObtainedOutsideIndia == 'false')) {
printHtmlPart(169)
}
else {
printHtmlPart(170)
}
printHtmlPart(171)
if(true && (appForm?.isBioObtainedOutsideIndia == 'true')) {
printHtmlPart(9)
expressionOut.print(appForm?.traditionalKnowledgeDesc)
printHtmlPart(172)
}
else if(true && (appForm?.isBioObtainedOutsideIndia == 'false')) {
printHtmlPart(173)
}
else {
printHtmlPart(172)
}
printHtmlPart(174)
if(true && (appForm?.isBioObtainedOutsideIndia == 'false')) {
printHtmlPart(66)
}
else if(true && (appForm?.isApprovalOfCountryObtained == 'true')) {
printHtmlPart(110)
}
else if(true && (appForm?.isApprovalOfCountryObtained == 'false')) {
printHtmlPart(111)
}
printHtmlPart(175)
if(true && (appForm?.isApprovalOfCountryObtained == 'false')) {
printHtmlPart(176)
expressionOut.print(appForm?.reasonOfDisapproval)
printHtmlPart(151)
}
printHtmlPart(177)
if(true && (appForm?.isTraditionalKnowledgeApplicable == 'Applicable')) {
printHtmlPart(178)
}
else if(true && (appForm?.isTraditionalKnowledgeApplicable == 'Not applicable')) {
printHtmlPart(179)
}
else {
printHtmlPart(180)
}
printHtmlPart(181)
if(true && (appForm?.isTraditionalKnowledgeApplicable == 'Applicable')) {
printHtmlPart(182)
expressionOut.print(appForm?.traditionalKnowledgeUsedInInvention)
printHtmlPart(183)
if(true && (appForm?.isNoForTraditional == 'No')) {
printHtmlPart(184)
}
else {
printHtmlPart(185)
}
printHtmlPart(186)
if(true && (appForm?.isNoForTraditional != 'No')) {
printHtmlPart(187)
if(true && (listOfCommunityLocations)) {
printHtmlPart(53)

int a=1

printHtmlPart(53)
for( location in (listOfCommunityLocations) ) {
printHtmlPart(188)
out.print(a)
printHtmlPart(189)

a++

printHtmlPart(190)
expressionOut.print(location?.communityKnowledge)
printHtmlPart(191)
expressionOut.print(location?.village)
printHtmlPart(191)
expressionOut.print(location?.town)
printHtmlPart(192)
expressionOut.print(location?.district)
printHtmlPart(191)
expressionOut.print(State?.findById(location?.state)?.state)
printHtmlPart(193)
}
printHtmlPart(114)
}
printHtmlPart(194)
}
printHtmlPart(195)
}
printHtmlPart(196)
expressionOut.print(appForm?.detailsOfInstitute)
printHtmlPart(197)
expressionOut.print(appForm?.benefitsToTheApplicant)
printHtmlPart(198)
if(true && (appForm?.isDeclarationDigitallySigned == 'true')) {
printHtmlPart(199)
}
else {
printHtmlPart(200)
}
printHtmlPart(201)
if(true && (appForm?.submitCheck == true)) {
printHtmlPart(202)
}
else {
printHtmlPart(203)
}
printHtmlPart(204)
if(true && (appForm?.transaction?.isPaymentMade == true)) {
printHtmlPart(205)
expressionOut.print(appForm?.transaction?.transactionId)
printHtmlPart(206)
expressionOut.print(appForm?.transaction?.paymentRefNo)
printHtmlPart(207)
}
printHtmlPart(208)
})
invokeTag('captureBody','sitemesh',1042,[:],1)
printHtmlPart(209)
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
