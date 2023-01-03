
import org.nba.common.State


import org.nba.common.Country

import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_NBA_formPreviewpreviewForm3Info_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/formPreview/previewForm3Info.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(1)
if(true && (appForm?.transaction?.isPaymentMade == true)) {
printHtmlPart(2)
expressionOut.print(appForm?.appNumber)
printHtmlPart(3)
expressionOut.print(appForm?.submittedOn)
printHtmlPart(4)
}
printHtmlPart(5)
if(true && (listofFormData?.size() != 0)) {
printHtmlPart(6)

int num= 1

printHtmlPart(7)

char alph = 65

printHtmlPart(7)
for( profile in (listofFormData) ) {
printHtmlPart(8)
expressionOut.print(alph)
printHtmlPart(9)
expressionOut.print(num)
printHtmlPart(10)

num++

printHtmlPart(11)

alph++

printHtmlPart(12)
expressionOut.print(profile?.title)
printHtmlPart(13)
expressionOut.print(profile?.firstName)
printHtmlPart(13)
expressionOut.print(profile?.middleName)
printHtmlPart(13)
expressionOut.print(profile?.lastName)
printHtmlPart(14)
if(true && (profile?.nationality == 'Non Indian')) {
printHtmlPart(15)
expressionOut.print(profile?.nationality)
printHtmlPart(16)
expressionOut.print(profile?.country?.country)
printHtmlPart(17)
}
else {
printHtmlPart(15)
expressionOut.print(profile?.nationality)
printHtmlPart(17)
}
printHtmlPart(18)
expressionOut.print(profile?.profile)
printHtmlPart(19)
expressionOut.print(profile?.address1)
printHtmlPart(13)
expressionOut.print(profile?.address2)
printHtmlPart(13)
expressionOut.print(profile?.address3)
printHtmlPart(20)
expressionOut.print(profile?.city)
printHtmlPart(21)
expressionOut.print(profile?.country?.country)
printHtmlPart(22)
expressionOut.print(profile?.mobile)
printHtmlPart(23)
expressionOut.print(profile?.phone)
printHtmlPart(24)
expressionOut.print(profile?.email)
printHtmlPart(25)
expressionOut.print(profile?.idProofSelect)
printHtmlPart(26)
expressionOut.print(profile?.idNum)
printHtmlPart(27)
expressionOut.print(profile?.idProofSelect)
printHtmlPart(28)
createClosureForHtmlPart(29, 3)
invokeTag('link','g',159,['controller':("applicationManagement"),'action':("showIndividualDc"),'id':(profile?.id),'target':("_blank"),'params':([filename: "idProof", dataName: "idProof",csrfPreventionSalt:"${csrfPreventionSalt}"])],3)
printHtmlPart(30)
expressionOut.print(profile?.passportNum)
printHtmlPart(31)
createClosureForHtmlPart(29, 3)
invokeTag('link','g',175,['controller':("applicationManagement"),'action':("showIndividualDc"),'id':(profile?.id),'target':("_blank"),'params':([filename: "passportCopy", dataName: "passportCopy",csrfPreventionSalt:"${csrfPreventionSalt}"])],3)
printHtmlPart(32)
expressionOut.print(profile?.authorizationNo)
printHtmlPart(33)
if(true && (profile?.authorizationLetter)) {
printHtmlPart(34)
createClosureForHtmlPart(35, 4)
invokeTag('link','g',193,['controller':("applicationManagement"),'action':("showIndividualDc"),'id':(profile?.id),'target':("_blank"),'params':([filename: "authorizationLetter", dataName: "authorizationLetter",csrfPreventionSalt:"${csrfPreventionSalt}"])],4)
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

printHtmlPart(7)
for( companyProfile1 in (listOfCompanyData) ) {
printHtmlPart(7)
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
else if(true && (companyProfile1?.nationality == 'noNonIndianParticipation')) {
printHtmlPart(52)
}
else {
printHtmlPart(53)
}
printHtmlPart(54)
expressionOut.print(companyProfile1?.address1)
printHtmlPart(13)
expressionOut.print(companyProfile1?.address2)
printHtmlPart(13)
expressionOut.print(companyProfile1?.address3)
printHtmlPart(13)
expressionOut.print(companyProfile1?.city)
printHtmlPart(55)
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
createClosureForHtmlPart(64, 4)
invokeTag('link','g',326,['controller':("applicationManagement"),'action':("showDc"),'id':(companyProfile1?.id),'target':("_blank"),'class':("fumargin"),'params':([filename: "registrationDocName", dataName: "registrationDoc",csrfPreventionSalt:"${csrfPreventionSalt}"])],4)
printHtmlPart(65)
}
else {
printHtmlPart(66)
}
printHtmlPart(67)
expressionOut.print(companyProfile1?.title)
printHtmlPart(13)
expressionOut.print(companyProfile1?.firstName)
printHtmlPart(13)
expressionOut.print(companyProfile1?.middleName)
printHtmlPart(13)
expressionOut.print(companyProfile1?.lastName)
printHtmlPart(68)
expressionOut.print(companyProfile1?.designation)
printHtmlPart(69)
if(true && (!companyProfile1)) {
printHtmlPart(70)
}
else if(true && (companyProfile1?.mobile?.contains('-'))) {
printHtmlPart(36)
expressionOut.print(companyProfile1?.mobile)
printHtmlPart(65)
}
printHtmlPart(71)
expressionOut.print(companyProfile1?.personEmail)
printHtmlPart(72)
expressionOut.print(companyProfile1?.idNum)
printHtmlPart(73)
expressionOut.print(companyProfile1?.authRepresentativeIdSelect)
printHtmlPart(74)
if(true && (companyProfile1?.passportCopy)) {
printHtmlPart(75)
createClosureForHtmlPart(76, 4)
invokeTag('link','g',394,['controller':("applicationManagement"),'action':("showDc"),'id':(companyProfile1?.id),'target':("_blank"),'params':([filename: "passportCopy", dataName: "passportCopy",csrfPreventionSalt:"${csrfPreventionSalt}"])],4)
printHtmlPart(77)
}
else {
printHtmlPart(78)
}
printHtmlPart(79)
if(true && (companyProfile1?.authorizationLetter)) {
printHtmlPart(75)
createClosureForHtmlPart(80, 4)
invokeTag('link','g',412,['controller':("applicationManagement"),'action':("showDc"),'class':("fumargin"),'id':(companyProfile1?.id),'target':("_blank"),'params':([filename: "authorizationLetterFileName", dataName: "authorizationLetterFileName",csrfPreventionSalt:"${csrfPreventionSalt}"])],4)
printHtmlPart(77)
}
else {
printHtmlPart(78)
}
printHtmlPart(81)
}
printHtmlPart(11)
}
printHtmlPart(82)
if(true && (listOfCompanyData?.size() != 0)) {
printHtmlPart(83)
}
else {
printHtmlPart(84)
}
printHtmlPart(85)
if(true && (agentProfile != null)) {
printHtmlPart(86)
}
else {
printHtmlPart(87)
}
printHtmlPart(88)
if(true && (agentProfile != null)) {
printHtmlPart(89)
if(true && (agentProfile?.profile?.contains("-"))) {
printHtmlPart(90)
if(true && (agentProfile?.profile?.charAt(agentProfile?.profile?.length() -1) == '-')) {
printHtmlPart(91)
expressionOut.print(agentProfile?.profile?.split("-")[0])
printHtmlPart(92)
}
else {
printHtmlPart(93)
expressionOut.print(agentProfile?.profile?.split("-")[1])
printHtmlPart(91)
}
printHtmlPart(94)
}
else {
printHtmlPart(95)
expressionOut.print(agentProfile?.profile)
printHtmlPart(96)
}
printHtmlPart(97)
expressionOut.print(agentProfile?.title)
printHtmlPart(13)
expressionOut.print(agentProfile?.firstName)
printHtmlPart(13)
expressionOut.print(agentProfile?.middleName)
printHtmlPart(13)
expressionOut.print(agentProfile?.lastName)
printHtmlPart(98)
expressionOut.print(agentProfile?.address1)
printHtmlPart(13)
expressionOut.print(agentProfile?.address2)
printHtmlPart(13)
expressionOut.print(agentProfile?.address3)
printHtmlPart(99)
expressionOut.print(State.findById(agentProfile?.province)?.state)
printHtmlPart(100)
expressionOut.print(agentProfile?.city)
printHtmlPart(101)
expressionOut.print(agentProfile?.pincode)
printHtmlPart(102)
expressionOut.print(agentProfile?.mobile)
printHtmlPart(103)
expressionOut.print(agentProfile?.email)
printHtmlPart(104)
if(true && (agentProfile?.authorizationLetter)) {
printHtmlPart(105)
createClosureForHtmlPart(106, 3)
invokeTag('link','g',490,['controller':("applicationManagement"),'action':("showAgentDc"),'id':(agentProfile?.id),'target':("_blank"),'params':([filename: "authorizationLetter", dataName: "authorizationLetter",csrfPreventionSalt:"${csrfPreventionSalt}"])],3)
printHtmlPart(107)
}
else {
printHtmlPart(108)
}
printHtmlPart(109)
expressionOut.print(agentProfile?.photoIdSelect)
printHtmlPart(110)
expressionOut.print(agentProfile?.photoIdNum)
printHtmlPart(111)
expressionOut.print(agentProfile?.photoIdSelect)
printHtmlPart(112)
if(true && (agentProfile?.passportCopy)) {
printHtmlPart(77)
createClosureForHtmlPart(113, 3)
invokeTag('link','g',513,['controller':("applicationManagement"),'class':("fumargin"),'action':("showAgentDc"),'id':(agentProfile?.id),'target':("_blank"),'params':([filename: "passportCopyFileName", dataName: "passportCopyFileName",csrfPreventionSalt:"${csrfPreventionSalt}"])],3)
printHtmlPart(107)
}
else {
printHtmlPart(108)
}
printHtmlPart(114)
}
printHtmlPart(115)
if(true && (appForm?.transaction?.isPaymentMade != true)) {
printHtmlPart(42)
if(true && (listOfCompanyData)) {
printHtmlPart(116)
createClosureForHtmlPart(117, 3)
invokeTag('link','g',533,['controller':("applicationManagement"),'action':("companyProfile"),'params':([appFormId:appForm?.id,formType:formType,csrfPreventionSalt:"${csrfPreventionSalt}"]),'class':("btn  btn-primary pull-right"),'method':("POST")],3)
printHtmlPart(118)
}
else if(true && (listofFormData)) {
printHtmlPart(119)
createClosureForHtmlPart(117, 3)
invokeTag('link','g',541,['controller':("applicationManagement"),'action':("individualProfile"),'params':([appFormId:appForm?.id,formType:formType,csrfPreventionSalt:"${csrfPreventionSalt}"]),'class':("btn  btn-primary pull-right"),'method':("POST")],3)
printHtmlPart(120)
}
printHtmlPart(121)
}
printHtmlPart(122)
expressionOut.print(appForm?.titleOfIPR)
printHtmlPart(123)
expressionOut.print(appForm?.abstractOfIPR)
printHtmlPart(124)
loop:{
int i = 0
for( countries in (appForm?.detailsOfTerritories) ) {
printHtmlPart(125)
if(true && (appForm?.detailsOfTerritories?.size() - i == 1)) {
printHtmlPart(126)
expressionOut.print(countries?.country)
printHtmlPart(127)
}
else {
printHtmlPart(128)
expressionOut.print(countries?.country)
printHtmlPart(129)
}
printHtmlPart(130)
i++
}
}
printHtmlPart(131)
if(true && (appForm?.isIPApplicationFiled == 'true')) {
printHtmlPart(132)
}
else {
printHtmlPart(133)
}
printHtmlPart(134)
if(true && (appForm?.isIPApplicationFiled == 'true')) {
printHtmlPart(135)

i=1

printHtmlPart(65)
for( ipr in (listOfIPRDetails) ) {
printHtmlPart(136)
out.print(i)
printHtmlPart(137)

i++

printHtmlPart(138)
expressionOut.print(Country.get(ipr?.country)?.country)
printHtmlPart(139)
expressionOut.print(ipr?.patentApplicationNo)
printHtmlPart(139)
expressionOut.print(ipr?.patentApplicationDate?.format('dd/MM/yyyy'))
printHtmlPart(139)
expressionOut.print(ipr?.status)
printHtmlPart(139)
expressionOut.print(ipr?.patentNo)
printHtmlPart(13)
expressionOut.print(ipr?.patentDate?.format('dd/MM/yyyy'))
printHtmlPart(140)
if(true && (ipr?.reasons)) {
printHtmlPart(75)
expressionOut.print(ipr?.reasons)
printHtmlPart(77)
}
else {
printHtmlPart(141)
}
printHtmlPart(142)
}
printHtmlPart(143)
}
printHtmlPart(144)
if(true && (listOfBioResources)) {
printHtmlPart(145)

int i=1

printHtmlPart(65)
for( bioResource in (listOfBioResources) ) {
printHtmlPart(146)
out.print(i)
printHtmlPart(137)

i++

printHtmlPart(147)
expressionOut.print(bioResource?.accessIntention)
printHtmlPart(148)
expressionOut.print(bioResource?.commonName)
printHtmlPart(149)
expressionOut.print(bioResource?.scientificName)
printHtmlPart(150)
expressionOut.print(bioResource?.nature)
printHtmlPart(151)
expressionOut.print(bioResource?.biologicalResource)
printHtmlPart(152)
}
printHtmlPart(153)
}
printHtmlPart(154)
if(true && (appForm?.individualProfiles?.getAt(0)?.nationality == 'Non Indian' || appForm?.individualProfiles?.getAt(0)?.nationality == 'Non-Resident Indian' 
					 || appForm?.companyProfiles?.getAt(0)?.nationality == 'registeredInIndia' || appForm?.companyProfiles?.getAt(0)?.nationality == 'noNonIndianParticipation')) {
printHtmlPart(155)
if(true && (appForm.isApprovalOfNbaObtainedForm3 == 'true')) {
printHtmlPart(156)
}
else {
printHtmlPart(157)
}
printHtmlPart(158)
if(true && (appForm.isApprovalOfNbaObtainedForm3 == 'false')) {
printHtmlPart(159)
if(true && (appForm?.reasonOFNotObtainedApproval)) {
printHtmlPart(160)
expressionOut.print(appForm?.reasonOFNotObtainedApproval)
printHtmlPart(161)
}
else {
printHtmlPart(162)
}
printHtmlPart(163)
}
else if(true && (appForm.isApprovalOfNbaObtainedForm3 == 'true')) {
printHtmlPart(164)
if(true && (appForm?.applicationNo)) {
printHtmlPart(165)
expressionOut.print(appForm?.applicationNo)
printHtmlPart(166)
}
else {
printHtmlPart(167)
}
printHtmlPart(168)
if(true && (appForm?.isApprovalOfNbaObtainedForm3 == 'true')) {
printHtmlPart(165)
expressionOut.print(appForm?.dateOfApproval?.format('dd/MM/yyyy'))
printHtmlPart(166)
}
else {
printHtmlPart(167)
}
printHtmlPart(169)
if(true && (appForm?.nbaApprovalFile && appForm?.isApprovalOfNbaObtainedForm3 == 'true')) {
printHtmlPart(47)
createClosureForHtmlPart(170, 4)
invokeTag('link','g',798,['controller':("form3"),'action':("showDc"),'id':(appForm?.id),'target':("_blank"),'params':([filename: "nbaApprovalFileName", dataName: "nbaApprovalFileName",csrfPreventionSalt:"${csrfPreventionSalt}"])],4)
printHtmlPart(11)
}
else {
printHtmlPart(70)
}
printHtmlPart(171)
}
printHtmlPart(172)
}
printHtmlPart(173)
if(true && (appForm?.transaction?.isPaymentMade != true)) {
printHtmlPart(174)
createClosureForHtmlPart(175, 2)
invokeTag('link','g',805,['controller':("applicationManagement"),'action':("form1Part2"),'params':([appFormId:appForm?.id,formType:formType,csrfPreventionSalt:"${csrfPreventionSalt}"]),'class':("btn  btn-primary text-center pull-right"),'method':("POST")],2)
printHtmlPart(176)
}
printHtmlPart(177)
if(true && (listOfLocations)) {
printHtmlPart(178)

int k=1

printHtmlPart(75)
for( location in (listOfLocations) ) {
printHtmlPart(179)
out.print(k)
printHtmlPart(180)

k++

printHtmlPart(181)
expressionOut.print(location?.bioResource?.scientificName)
printHtmlPart(182)
expressionOut.print(location?.source)
printHtmlPart(183)
if(true && (location?.village)) {
printHtmlPart(184)
expressionOut.print(location?.village)
printHtmlPart(185)
}
else {
printHtmlPart(186)
}
printHtmlPart(187)
if(true && (location?.town)) {
printHtmlPart(184)
expressionOut.print(location?.town)
printHtmlPart(185)
}
else {
printHtmlPart(186)
}
printHtmlPart(188)
if(true && (location?.district)) {
printHtmlPart(184)
expressionOut.print(location?.district)
printHtmlPart(185)
}
else {
printHtmlPart(186)
}
printHtmlPart(188)
if(true && (location?.state)) {
printHtmlPart(184)
expressionOut.print(location?.state)
printHtmlPart(185)
}
else {
printHtmlPart(186)
}
printHtmlPart(188)
if(true && (location?.traderName)) {
printHtmlPart(184)
expressionOut.print(location?.traderName)
printHtmlPart(185)
}
else {
printHtmlPart(186)
}
printHtmlPart(188)
if(true && (location?.traderContactDetails)) {
printHtmlPart(184)
expressionOut.print(location?.traderContactDetails)
printHtmlPart(185)
}
else {
printHtmlPart(186)
}
printHtmlPart(189)
}
printHtmlPart(190)
}
printHtmlPart(191)
if(true && (appForm?.isBioObtainedOutsideIndia == 'true')) {
printHtmlPart(192)
}
else if(true && (appForm?.isBioObtainedOutsideIndia == 'false')) {
printHtmlPart(193)
}
else {
printHtmlPart(194)
}
printHtmlPart(195)
if(true && (appForm?.isBioObtainedOutsideIndia == 'true')) {
printHtmlPart(11)
expressionOut.print(appForm?.traditionalKnowledgeDesc)
printHtmlPart(196)
}
else if(true && (appForm?.isBioObtainedOutsideIndia == 'false')) {
printHtmlPart(197)
}
else {
printHtmlPart(196)
}
printHtmlPart(198)
if(true && (appForm?.isBioObtainedOutsideIndia == 'false')) {
printHtmlPart(70)
}
else if(true && (appForm?.isApprovalOfCountryObtained == 'true')) {
printHtmlPart(132)
}
else if(true && (appForm?.isApprovalOfCountryObtained == 'false')) {
printHtmlPart(133)
}
printHtmlPart(199)
if(true && (appForm?.isApprovalOfCountryObtained == 'false')) {
printHtmlPart(200)
if(true && (appForm?.reasonOfDisapproval)) {
printHtmlPart(47)
expressionOut.print(appForm?.reasonOfDisapproval)
printHtmlPart(11)
}
else {
printHtmlPart(70)
}
printHtmlPart(201)
}
printHtmlPart(202)
if(true && (appForm?.isTraditionalKnowledgeApplicable == 'Applicable')) {
printHtmlPart(203)
}
else if(true && (appForm?.isTraditionalKnowledgeApplicable == 'Not applicable')) {
printHtmlPart(204)
}
else {
printHtmlPart(205)
}
printHtmlPart(206)
if(true && (appForm?.isTraditionalKnowledgeApplicable == 'Applicable')) {
printHtmlPart(207)
expressionOut.print(appForm?.traditionalKnowledgeUsedInInvention)
printHtmlPart(208)
}
printHtmlPart(209)
if(true && (appForm?.isTraditionalKnowledgeApplicable != 'Applicable' || !listOfCommunityLocations)) {
printHtmlPart(210)
}
else {
printHtmlPart(211)
}
printHtmlPart(212)
if(true && (appForm?.isTraditionalKnowledgeApplicable == 'Applicable')) {
printHtmlPart(43)
if(true && (listOfCommunityLocations)) {
printHtmlPart(213)

int a=1

printHtmlPart(36)
for( location in (listOfCommunityLocations) ) {
printHtmlPart(214)
out.print(a)
printHtmlPart(215)

a++

printHtmlPart(216)
expressionOut.print(location?.communityKnowledge)
printHtmlPart(217)
expressionOut.print(location?.village)
printHtmlPart(217)
expressionOut.print(location?.town)
printHtmlPart(218)
expressionOut.print(location?.district)
printHtmlPart(217)
expressionOut.print(State?.findById(location?.state)?.state)
printHtmlPart(219)
}
printHtmlPart(220)
}
printHtmlPart(42)
}
printHtmlPart(221)
expressionOut.print(appForm?.detailsOfInstitute)
printHtmlPart(222)
expressionOut.print(appForm?.benefitsToTheApplicant)
printHtmlPart(223)
if(true && (appForm?.transaction?.isPaymentMade != true)) {
printHtmlPart(224)
createClosureForHtmlPart(225, 2)
invokeTag('link','g',1109,['controller':("form3"),'action':("part3"),'params':([appFormId:appForm?.id,formType:formType,csrfPreventionSalt:"${csrfPreventionSalt}"]),'class':("btn  btn-primary pull-right"),'method':("POST")],2)
printHtmlPart(226)
}
printHtmlPart(227)
if(true && (appForm?.isDeclarationDigitallySigned == 'true')) {
printHtmlPart(228)
}
else {
printHtmlPart(229)
}
printHtmlPart(230)
if(true && (appForm?.submitCheck == true)) {
printHtmlPart(231)
}
else {
printHtmlPart(232)
}
printHtmlPart(233)
if(true && (appForm?.transaction?.isPaymentMade == true)) {
printHtmlPart(234)
expressionOut.print(appForm?.transaction?.transactionId)
printHtmlPart(235)
expressionOut.print(appForm?.transaction?.paymentRefNo)
printHtmlPart(236)
createClosureForHtmlPart(237, 2)
invokeTag('link','g',1196,['controller':("applicationManagement"),'action':("showIndividualDc"),'id':(appForm?.transaction?.id),'target':("_blank"),'params':([filename: "paymentReceipt", dataName: "paymentReceipt", appFormId: appForm?.id,csrfPreventionSalt:"${csrfPreventionSalt}"])],2)
printHtmlPart(238)
}
printHtmlPart(239)
createClosureForHtmlPart(240, 1)
invokeTag('link','g',1207,['controller':("FormPreview"),'class':("btn btn-primary"),'action':("printCompleateProject3"),'target':("_blank"),'params':([id:appForm?.id,csrfPreventionSalt:"${csrfPreventionSalt}"])],1)
printHtmlPart(13)
createClosureForHtmlPart(241, 1)
invokeTag('link','g',1212,['controller':("PDF"),'class':("btn btn-primary"),'action':("index"),'params':([projectId:appForm?.id,csrfPreventionSalt:"${csrfPreventionSalt}"])],1)
printHtmlPart(242)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1604042558000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
