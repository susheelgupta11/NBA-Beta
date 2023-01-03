
import org.nba.common.*

import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_NBA_formPreviewpreviewForm2Info_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/formPreview/previewForm2Info.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
if(true && (appForm?.transaction?.isPaymentMade == true)) {
printHtmlPart(1)
expressionOut.print(appForm?.appNumber)
printHtmlPart(2)
expressionOut.print(appForm?.submittedOn)
printHtmlPart(3)
}
printHtmlPart(4)
if(true && (listofFormData.size() != 0)) {
printHtmlPart(5)

int num= 1

printHtmlPart(6)

char alph = 65

printHtmlPart(6)
for( profile in (listofFormData) ) {
printHtmlPart(7)
expressionOut.print(alph)
printHtmlPart(8)
expressionOut.print(num)
printHtmlPart(9)

num++

printHtmlPart(10)

alph++

printHtmlPart(11)
expressionOut.print(profile?.title)
printHtmlPart(12)
expressionOut.print(profile?.firstName)
printHtmlPart(12)
expressionOut.print(profile?.middleName)
printHtmlPart(12)
expressionOut.print(profile?.lastName)
printHtmlPart(13)
if(true && (profile?.nationality == 'Non Indian')) {
printHtmlPart(14)
expressionOut.print(profile?.nationality)
printHtmlPart(15)
expressionOut.print(profile?.country?.country)
printHtmlPart(16)
}
else {
printHtmlPart(17)
expressionOut.print(profile?.nationality)
printHtmlPart(16)
}
printHtmlPart(18)
expressionOut.print(profile?.profile)
printHtmlPart(19)
expressionOut.print(profile?.address1)
printHtmlPart(12)
expressionOut.print(profile?.address2)
printHtmlPart(12)
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
expressionOut.print(profile?.idNum)
printHtmlPart(26)
expressionOut.print(profile?.idProofSelect)
printHtmlPart(27)
createClosureForHtmlPart(28, 3)
invokeTag('link','g',156,['controller':("applicationManagement"),'action':("showIndividualDc"),'id':(profile?.id),'target':("_blank"),'params':([filename: "idProof", dataName: "idProof",csrfPreventionSalt:"${csrfPreventionSalt}"])],3)
printHtmlPart(29)
expressionOut.print(profile?.passportNum)
printHtmlPart(30)
createClosureForHtmlPart(28, 3)
invokeTag('link','g',172,['controller':("applicationManagement"),'action':("showIndividualDc"),'id':(profile?.id),'target':("_blank"),'params':([filename: "passportCopy", dataName: "passportCopy",csrfPreventionSalt:"${csrfPreventionSalt}"])],3)
printHtmlPart(31)
expressionOut.print(profile?.authorizationNo)
printHtmlPart(32)
if(true && (profile?.authorizationLetter)) {
printHtmlPart(33)
createClosureForHtmlPart(34, 4)
invokeTag('link','g',190,['controller':("applicationManagement"),'action':("showIndividualDc"),'id':(profile?.id),'target':("_blank"),'params':([filename: "authorizationLetter", dataName: "authorizationLetter",csrfPreventionSalt:"${csrfPreventionSalt}"])],4)
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

printHtmlPart(42)

char y = 65

printHtmlPart(6)
for( companyProfile1 in (listOfCompanyData) ) {
printHtmlPart(6)
if(true && (listOfCompanyData?.size() != 0)) {
printHtmlPart(43)
expressionOut.print(y)
printHtmlPart(44)
expressionOut.print(x)
printHtmlPart(45)

x++

printHtmlPart(46)

y++

printHtmlPart(47)
expressionOut.print(companyProfile1?.entityName)
printHtmlPart(48)
expressionOut.print(companyProfile1?.entityType)
printHtmlPart(49)
if(true && (companyProfile1?.nationality == 'notRegisteredInIndia')) {
printHtmlPart(50)
}
else {
printHtmlPart(51)
}
printHtmlPart(52)
expressionOut.print(companyProfile1?.address1)
printHtmlPart(12)
expressionOut.print(companyProfile1?.address2)
printHtmlPart(12)
expressionOut.print(companyProfile1?.address3)
printHtmlPart(12)
expressionOut.print(companyProfile1?.city)
printHtmlPart(53)
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
createClosureForHtmlPart(62, 4)
invokeTag('link','g',322,['controller':("applicationManagement"),'action':("showDc"),'id':(companyProfile1?.id),'target':("_blank"),'class':("fumargin"),'params':([filename: "registrationDocName", dataName: "registrationDoc",csrfPreventionSalt:"${csrfPreventionSalt}"])],4)
printHtmlPart(63)
}
else {
printHtmlPart(64)
}
printHtmlPart(65)
expressionOut.print(companyProfile1?.title)
printHtmlPart(12)
expressionOut.print(companyProfile1?.firstName)
printHtmlPart(12)
expressionOut.print(companyProfile1?.middleName)
printHtmlPart(12)
expressionOut.print(companyProfile1?.lastName)
printHtmlPart(66)
expressionOut.print(companyProfile1?.designation)
printHtmlPart(67)
if(true && (!companyProfile1)) {
printHtmlPart(68)
}
else if(true && (companyProfile1?.mobile?.contains('-'))) {
printHtmlPart(35)
expressionOut.print(companyProfile1?.mobile)
printHtmlPart(63)
}
printHtmlPart(69)
expressionOut.print(companyProfile1?.personEmail)
printHtmlPart(70)
expressionOut.print(companyProfile1?.idNum)
printHtmlPart(71)
expressionOut.print(companyProfile1?.authRepresentativeIdSelect)
printHtmlPart(72)
if(true && (companyProfile1?.passportCopy)) {
printHtmlPart(73)
createClosureForHtmlPart(74, 4)
invokeTag('link','g',390,['controller':("applicationManagement"),'action':("showDc"),'id':(companyProfile1?.id),'target':("_blank"),'params':([filename: "passportCopy", dataName: "passportCopy",csrfPreventionSalt:"${csrfPreventionSalt}"])],4)
printHtmlPart(75)
}
else {
printHtmlPart(76)
}
printHtmlPart(77)
if(true && (companyProfile1?.authorizationLetter)) {
printHtmlPart(73)
createClosureForHtmlPart(78, 4)
invokeTag('link','g',408,['controller':("applicationManagement"),'action':("showDc"),'class':("fumargin"),'id':(companyProfile1?.id),'target':("_blank"),'params':([filename: "authorizationLetterFileName", dataName: "authorizationLetterFileName",csrfPreventionSalt:"${csrfPreventionSalt}"])],4)
printHtmlPart(75)
}
else {
printHtmlPart(76)
}
printHtmlPart(79)
}
printHtmlPart(10)
}
printHtmlPart(80)
if(true && (listOfCompanyData?.size() != 0)) {
printHtmlPart(81)
}
else {
printHtmlPart(82)
}
printHtmlPart(83)
if(true && (agentProfile != null)) {
printHtmlPart(84)
}
else {
printHtmlPart(85)
}
printHtmlPart(86)
if(true && (agentProfile != null)) {
printHtmlPart(87)
expressionOut.print(agentProfile?.profile)
printHtmlPart(88)
expressionOut.print(agentProfile?.title)
printHtmlPart(12)
expressionOut.print(agentProfile?.firstName)
printHtmlPart(12)
expressionOut.print(agentProfile?.middleName)
printHtmlPart(12)
expressionOut.print(agentProfile?.lastName)
printHtmlPart(89)
expressionOut.print(agentProfile?.address1)
printHtmlPart(12)
expressionOut.print(agentProfile?.address2)
printHtmlPart(12)
expressionOut.print(agentProfile?.address3)
printHtmlPart(90)
expressionOut.print(State.findById(agentProfile?.province)?.state)
printHtmlPart(91)
expressionOut.print(agentProfile?.city)
printHtmlPart(92)
expressionOut.print(agentProfile?.pincode)
printHtmlPart(93)
expressionOut.print(agentProfile?.mobile)
printHtmlPart(94)
expressionOut.print(agentProfile?.email)
printHtmlPart(95)
if(true && (agentProfile?.authorizationLetter)) {
printHtmlPart(96)
createClosureForHtmlPart(34, 3)
invokeTag('link','g',477,['controller':("applicationManagement"),'action':("showAgentDc"),'id':(agentProfile?.id),'target':("_blank"),'params':([filename: "authorizationLetter", dataName: "authorizationLetter",csrfPreventionSalt:"${csrfPreventionSalt}"])],3)
printHtmlPart(97)
}
else {
printHtmlPart(98)
}
printHtmlPart(99)
expressionOut.print(agentProfile?.photoIdSelect)
printHtmlPart(100)
expressionOut.print(agentProfile?.photoIdNum)
printHtmlPart(101)
expressionOut.print(agentProfile?.photoIdSelect)
printHtmlPart(102)
if(true && (agentProfile?.passportCopy)) {
printHtmlPart(97)
createClosureForHtmlPart(103, 3)
invokeTag('link','g',500,['controller':("applicationManagement"),'class':("fumargin"),'action':("showAgentDc"),'id':(agentProfile?.id),'target':("_blank"),'params':([filename: "passportCopyFileName", dataName: "passportCopyFileName",csrfPreventionSalt:"${csrfPreventionSalt}"])],3)
printHtmlPart(97)
}
else {
printHtmlPart(98)
}
printHtmlPart(104)
}
printHtmlPart(105)
if(true && (appForm?.transaction?.isPaymentMade != true)) {
printHtmlPart(41)
if(true && (listOfCompanyData)) {
printHtmlPart(106)
createClosureForHtmlPart(107, 3)
invokeTag('link','g',520,['controller':("applicationManagement"),'action':("companyProfile"),'params':([appFormId:appForm?.id,formType:formType,csrfPreventionSalt:"${csrfPreventionSalt}"]),'class':("btn  btn-primary pull-right"),'method':("POST")],3)
printHtmlPart(108)
}
else if(true && (listofFormData)) {
printHtmlPart(109)
createClosureForHtmlPart(107, 3)
invokeTag('link','g',528,['controller':("applicationManagement"),'action':("individualProfile"),'params':([appFormId:appForm?.id,formType:formType,csrfPreventionSalt:"${csrfPreventionSalt}"]),'class':("btn  btn-primary pull-right"),'method':("POST")],3)
printHtmlPart(110)
}
printHtmlPart(41)
}
printHtmlPart(111)
expressionOut.print(appForm?.briefDescription)
printHtmlPart(112)
expressionOut.print(appForm?.resultsOfResearch)
printHtmlPart(113)
if(true && (listOfBioResources)) {
printHtmlPart(114)
}
else {
printHtmlPart(115)
}
printHtmlPart(116)
if(true && (listOfBioResources)) {
printHtmlPart(117)

int i=1

printHtmlPart(63)
for( bioResource in (listOfBioResources) ) {
printHtmlPart(118)
out.print(i)
printHtmlPart(119)

i++

printHtmlPart(120)
expressionOut.print(bioResource?.accessIntention)
printHtmlPart(121)
expressionOut.print(bioResource?.commonName)
printHtmlPart(122)
expressionOut.print(bioResource?.scientificName)
printHtmlPart(123)
expressionOut.print(bioResource?.nature)
printHtmlPart(124)
expressionOut.print(bioResource?.biologicalResource)
printHtmlPart(125)
}
printHtmlPart(126)
}
printHtmlPart(127)
if(true && (listOfLocations)) {
printHtmlPart(128)
}
else {
printHtmlPart(129)
}
printHtmlPart(130)
if(true && (listOfLocations)) {
printHtmlPart(131)
if(true && (listOfLocations)) {
printHtmlPart(73)

int k=1

printHtmlPart(73)
for( location in (listOfLocations) ) {
printHtmlPart(132)
out.print(k)
printHtmlPart(133)

k++

printHtmlPart(134)
expressionOut.print(location?.bioResource?.scientificName)
printHtmlPart(135)
expressionOut.print(location?.source)
printHtmlPart(136)
if(true && (location?.village)) {
printHtmlPart(137)
expressionOut.print(location?.village)
printHtmlPart(138)
}
else {
printHtmlPart(139)
}
printHtmlPart(140)
if(true && (location?.town)) {
printHtmlPart(137)
expressionOut.print(location?.town)
printHtmlPart(138)
}
else {
printHtmlPart(139)
}
printHtmlPart(141)
if(true && (location?.district)) {
printHtmlPart(137)
expressionOut.print(location?.district)
printHtmlPart(138)
}
else {
printHtmlPart(139)
}
printHtmlPart(141)
if(true && (location?.state)) {
printHtmlPart(137)
expressionOut.print(location?.state)
printHtmlPart(138)
}
else {
printHtmlPart(139)
}
printHtmlPart(141)
if(true && (location?.traderName)) {
printHtmlPart(137)
expressionOut.print(location?.traderName)
printHtmlPart(138)
}
else {
printHtmlPart(139)
}
printHtmlPart(141)
if(true && (location?.traderContactDetails)) {
printHtmlPart(137)
expressionOut.print(location?.traderContactDetails)
printHtmlPart(138)
}
else {
printHtmlPart(139)
}
printHtmlPart(142)
}
printHtmlPart(35)
}
printHtmlPart(143)
}
printHtmlPart(144)
if(true && (appForm?.individualProfiles?.size() > 0 && appForm?.individualProfiles?.getAt(0)?.nationality == 'Non Indian' || appForm?.individualProfiles?.getAt(0)?.nationality == 'Non-Resident Indian')) {
printHtmlPart(145)
if(true && (appForm.isApprovalOfNbaObtained == 'true')) {
printHtmlPart(146)
}
else {
printHtmlPart(147)
}
printHtmlPart(148)
if(true && (appForm?.nbaApprovalFile)) {
printHtmlPart(46)
createClosureForHtmlPart(149, 3)
invokeTag('link','g',771,['controller':("form2"),'action':("showDc"),'id':(appForm?.id),'target':("_blank"),'params':([filename: "nbaApprovalFileName", dataName: "nbaApprovalFileName",csrfPreventionSalt:"${csrfPreventionSalt}"])],3)
printHtmlPart(10)
}
else {
printHtmlPart(68)
}
printHtmlPart(150)
}
printHtmlPart(144)
if(true && (appForm?.transaction?.isPaymentMade != true)) {
printHtmlPart(151)
createClosureForHtmlPart(152, 2)
invokeTag('link','g',785,['controller':("form2"),'action':("part2"),'params':([appFormId:appForm?.id,formType:formType,csrfPreventionSalt:"${csrfPreventionSalt}"]),'class':("btn  btn-primary text-center pull-right"),'method':("POST")],2)
printHtmlPart(153)
}
printHtmlPart(154)
if(true && (appForm?.isNoForTraditional == 'No')) {
printHtmlPart(155)
expressionOut.print(appForm?.isNoForTraditional)
printHtmlPart(156)
}
printHtmlPart(41)
if(true && (appForm?.isNoForTraditional != 'No')) {
printHtmlPart(157)
expressionOut.print(appForm?.nature)
printHtmlPart(158)
}
printHtmlPart(159)
if(true && (appForm?.isNoForTraditional != 'No')) {
printHtmlPart(160)
expressionOut.print(appForm?.traditionalKnowledgeDesc)
printHtmlPart(161)
}
printHtmlPart(162)
if(true && (appForm?.isNoForTraditional == 'No' || listOfCommunityLocations?.size() == 0)) {
printHtmlPart(163)
}
printHtmlPart(164)
if(true && (listOfCommunityLocations)) {
printHtmlPart(165)
if(true && (listOfCommunityLocations)) {
printHtmlPart(35)

int a=1

printHtmlPart(35)
for( location in (listOfCommunityLocations) ) {
printHtmlPart(166)
out.print(a)
printHtmlPart(167)

a++

printHtmlPart(168)
expressionOut.print(location?.communityKnowledge)
printHtmlPart(169)
expressionOut.print(location?.village)
printHtmlPart(170)
expressionOut.print(location?.town)
printHtmlPart(171)
expressionOut.print(location?.district)
printHtmlPart(170)
expressionOut.print(State?.findById(location?.state)?.state)
printHtmlPart(172)
}
printHtmlPart(41)
}
printHtmlPart(173)
}
printHtmlPart(174)
if(true && (appForm?.detailsOfInstitute)) {
printHtmlPart(175)
expressionOut.print(appForm?.detailsOfInstitute)
printHtmlPart(176)
}
else {
printHtmlPart(177)
}
printHtmlPart(178)
if(true && (appForm?.bonafideLetter || appForm.isResearchParticipation == 'true')) {
printHtmlPart(75)
createTagBody(2, {->
printHtmlPart(138)
expressionOut.print(appForm?.bonafideLetterName)
printHtmlPart(73)
})
invokeTag('link','g',945,['controller':("form2"),'action':("showDc"),'id':(appForm?.id),'target':("_blank"),'params':([filename: "bonafideLetterName", dataName: "bonafideLetterName",csrfPreventionSalt:"${csrfPreventionSalt}"])],2)
printHtmlPart(179)
}
else {
printHtmlPart(180)
}
printHtmlPart(181)
if(true && (appForm?.transaction?.isPaymentMade != true)) {
printHtmlPart(182)
createClosureForHtmlPart(183, 2)
invokeTag('link','g',962,['controller':("form2"),'action':("part3"),'params':([appFormId:appForm?.id,formType:formType,csrfPreventionSalt:"${csrfPreventionSalt}"]),'class':("btn  btn-primary pull-right"),'method':("POST")],2)
printHtmlPart(156)
}
printHtmlPart(184)
expressionOut.print(appForm?.detailsOfInstitute)
printHtmlPart(185)
expressionOut.print(appForm?.useofResearchResults)
printHtmlPart(186)
if(true && (appForm?.benefitsToTheIndividualOrOrganization)) {
printHtmlPart(187)
expressionOut.print(appForm?.benefitsToTheIndividualOrOrganization)
printHtmlPart(188)
}
else {
printHtmlPart(189)
}
printHtmlPart(190)
if(true && (appForm?.benefitsToTheApplicant)) {
printHtmlPart(187)
expressionOut.print(appForm?.benefitsToTheApplicant)
printHtmlPart(188)
}
else {
printHtmlPart(189)
}
printHtmlPart(191)
if(true && (appForm?.collaborationDetails)) {
printHtmlPart(192)
}
else {
printHtmlPart(193)
}
printHtmlPart(194)
if(true && (appForm?.collaborationDetails)) {
printHtmlPart(195)
if(true && (appForm?.collaborationDetails)) {
printHtmlPart(187)
expressionOut.print(appForm?.collaborationDetails)
printHtmlPart(188)
}
else {
printHtmlPart(196)
}
printHtmlPart(197)
createTagBody(2, {->
printHtmlPart(97)
expressionOut.print(appForm?.mouFileName)
printHtmlPart(35)
})
invokeTag('link','g',1059,['controller':("form2"),'action':("showDc"),'id':(appForm?.id),'target':("_blank"),'params':([filename: "mouFileName", dataName: "mouFileName",csrfPreventionSalt:"${csrfPreventionSalt}"])],2)
printHtmlPart(198)
}
printHtmlPart(199)
if(true && (appForm?.transaction?.isPaymentMade != true)) {
printHtmlPart(182)
createClosureForHtmlPart(200, 2)
invokeTag('link','g',1075,['controller':("form2"),'action':("part4"),'params':([appFormId:appForm?.id,formType:formType,csrfPreventionSalt:"${csrfPreventionSalt}"]),'class':("btn  btn-primary pull-right"),'method':("POST")],2)
printHtmlPart(201)
}
printHtmlPart(202)
if(true && (appForm?.isDeclarationDigitallySigned == 'true')) {
printHtmlPart(203)
}
else {
printHtmlPart(204)
}
printHtmlPart(205)
if(true && (appForm?.submitCheck == true)) {
printHtmlPart(206)
}
else {
printHtmlPart(207)
}
printHtmlPart(208)
if(true && (appForm?.transaction?.isPaymentMade == true)) {
printHtmlPart(209)
expressionOut.print(appForm?.transaction?.transactionId)
printHtmlPart(210)
expressionOut.print(appForm?.transaction?.paymentRefNo)
printHtmlPart(211)
createClosureForHtmlPart(212, 2)
invokeTag('link','g',1169,['controller':("applicationManagement"),'action':("showIndividualDc"),'id':(appForm?.transaction?.id),'target':("_blank"),'params':([filename: "paymentReceipt", dataName: "paymentReceipt", appFormId: appForm?.id,csrfPreventionSalt:"${csrfPreventionSalt}"])],2)
printHtmlPart(213)
}
printHtmlPart(214)
createClosureForHtmlPart(215, 1)
invokeTag('link','g',1176,['controller':("FormPreview"),'class':("btn btn-primary"),'action':("printCompleateProject2"),'target':("_blank"),'params':([id:appForm?.id ,csrfPreventionSalt:"${csrfPreventionSalt}"])],1)
printHtmlPart(12)
createClosureForHtmlPart(216, 1)
invokeTag('link','g',1183,['controller':("PDF"),'class':("btn btn-primary"),'action':("index"),'params':([projectId:appForm?.id,csrfPreventionSalt:"${csrfPreventionSalt}"])],1)
printHtmlPart(217)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1582543498000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
