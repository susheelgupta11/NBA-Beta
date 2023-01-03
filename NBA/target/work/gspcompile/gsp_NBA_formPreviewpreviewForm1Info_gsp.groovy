
import org.nba.common.State

import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_NBA_formPreviewpreviewForm1Info_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/formPreview/previewForm1Info.gsp" }
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
printHtmlPart(14)
expressionOut.print(profile?.nationality)
printHtmlPart(16)
}
printHtmlPart(17)
expressionOut.print(profile?.profile)
printHtmlPart(18)
expressionOut.print(profile?.address1)
printHtmlPart(19)
expressionOut.print(profile?.address2)
printHtmlPart(12)
expressionOut.print(profile?.address3)
printHtmlPart(12)
expressionOut.print(profile?.city)
printHtmlPart(20)
expressionOut.print(profile?.country?.country)
printHtmlPart(21)
expressionOut.print(profile?.mobile)
printHtmlPart(22)
expressionOut.print(profile?.phone)
printHtmlPart(23)
expressionOut.print(profile?.email)
printHtmlPart(24)
expressionOut.print(profile?.idNum)
printHtmlPart(25)
expressionOut.print(profile?.idProofSelect)
printHtmlPart(26)
createClosureForHtmlPart(27, 3)
invokeTag('link','g',163,['controller':("applicationManagement"),'action':("showIndividualDc"),'id':(profile?.id),'target':("_blank"),'params':([filename: "idProof", dataName: "idProof",csrfPreventionSalt:"${csrfPreventionSalt}"])],3)
printHtmlPart(28)
expressionOut.print(profile?.passportNum)
printHtmlPart(29)
createClosureForHtmlPart(27, 3)
invokeTag('link','g',179,['controller':("applicationManagement"),'action':("showIndividualDc"),'id':(profile?.id),'target':("_blank"),'params':([filename: "passportCopy", dataName: "passportCopy",csrfPreventionSalt:"${csrfPreventionSalt}"])],3)
printHtmlPart(30)
expressionOut.print(profile?.authorizationNo)
printHtmlPart(31)
if(true && (profile?.authorizationLetter)) {
printHtmlPart(32)
createClosureForHtmlPart(27, 4)
invokeTag('link','g',197,['controller':("applicationManagement"),'action':("showIndividualDc"),'id':(profile?.id),'target':("_blank"),'params':([filename: "authorizationLetter", dataName: "authorizationLetter",csrfPreventionSalt:"${csrfPreventionSalt}"])],4)
printHtmlPart(20)
}
else {
printHtmlPart(33)
}
printHtmlPart(34)
}
printHtmlPart(35)
}
printHtmlPart(36)
if(true && (listOfCompanyData?.size() != 0)) {
printHtmlPart(37)
}
printHtmlPart(38)

int x = 1

printHtmlPart(39)

char y = 65

printHtmlPart(6)
for( companyProfile1 in (listOfCompanyData) ) {
printHtmlPart(6)
if(true && (listOfCompanyData?.size() != 0)) {
printHtmlPart(40)
expressionOut.print(y)
printHtmlPart(41)
expressionOut.print(x)
printHtmlPart(42)

x++

printHtmlPart(43)

y++

printHtmlPart(44)
expressionOut.print(companyProfile1?.entityName)
printHtmlPart(45)
expressionOut.print(companyProfile1?.entityType)
printHtmlPart(46)
if(true && (companyProfile1?.nationality == 'notRegisteredInIndia')) {
printHtmlPart(47)
}
else {
printHtmlPart(48)
}
printHtmlPart(49)
expressionOut.print(companyProfile1?.address1)
printHtmlPart(12)
expressionOut.print(companyProfile1?.address2)
printHtmlPart(20)
expressionOut.print(companyProfile1?.address3)
printHtmlPart(12)
expressionOut.print(companyProfile1?.city)
printHtmlPart(12)
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
createClosureForHtmlPart(58, 4)
invokeTag('link','g',335,['controller':("applicationManagement"),'action':("showDc"),'id':(companyProfile1?.id),'target':("_blank"),'class':("fumargin"),'params':([filename: "registrationDocName", dataName: "registrationDoc",csrfPreventionSalt:"${csrfPreventionSalt}"])],4)
printHtmlPart(59)
}
else {
printHtmlPart(60)
}
printHtmlPart(61)
expressionOut.print(companyProfile1?.title)
printHtmlPart(12)
expressionOut.print(companyProfile1?.firstName)
printHtmlPart(50)
expressionOut.print(companyProfile1?.middleName)
printHtmlPart(12)
expressionOut.print(companyProfile1?.lastName)
printHtmlPart(62)
expressionOut.print(companyProfile1?.designation)
printHtmlPart(63)
if(true && (!companyProfile1)) {
printHtmlPart(64)
}
else if(true && (companyProfile1?.mobile?.contains('-'))) {
printHtmlPart(57)
expressionOut.print(companyProfile1?.mobile)
printHtmlPart(59)
}
printHtmlPart(65)
expressionOut.print(companyProfile1?.personEmail)
printHtmlPart(66)
expressionOut.print(companyProfile1?.idNum)
printHtmlPart(67)
expressionOut.print(companyProfile1?.authRepresentativeIdSelect)
printHtmlPart(68)
if(true && (companyProfile1?.passportCopy)) {
printHtmlPart(69)
createClosureForHtmlPart(70, 4)
invokeTag('link','g',408,['controller':("applicationManagement"),'action':("showDc"),'id':(companyProfile1?.id),'target':("_blank"),'params':([filename: "passportCopy", dataName: "passportCopy",csrfPreventionSalt:"${csrfPreventionSalt}"])],4)
printHtmlPart(71)
}
else {
printHtmlPart(72)
}
printHtmlPart(73)
if(true && (companyProfile1?.authorizationLetter)) {
printHtmlPart(69)
createClosureForHtmlPart(74, 4)
invokeTag('link','g',426,['controller':("applicationManagement"),'action':("showDc"),'class':("fumargin"),'id':(companyProfile1?.id),'target':("_blank"),'params':([filename: "authorizationLetterFileName", dataName: "authorizationLetterFileName",csrfPreventionSalt:"${csrfPreventionSalt}"])],4)
printHtmlPart(71)
}
else {
printHtmlPart(72)
}
printHtmlPart(75)
}
printHtmlPart(10)
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
expressionOut.print(agentProfile?.profile)
printHtmlPart(84)
expressionOut.print(agentProfile?.title)
printHtmlPart(12)
expressionOut.print(agentProfile?.firstName)
printHtmlPart(12)
expressionOut.print(agentProfile?.middleName)
printHtmlPart(12)
expressionOut.print(agentProfile?.lastName)
printHtmlPart(85)
expressionOut.print(agentProfile?.address1)
printHtmlPart(12)
expressionOut.print(agentProfile?.address2)
printHtmlPart(12)
expressionOut.print(agentProfile?.address3)
printHtmlPart(86)
expressionOut.print(State.findById(agentProfile?.province)?.state)
printHtmlPart(87)
expressionOut.print(agentProfile?.city)
printHtmlPart(88)
expressionOut.print(agentProfile?.pincode)
printHtmlPart(89)
expressionOut.print(agentProfile?.mobile)
printHtmlPart(90)
expressionOut.print(agentProfile?.email)
printHtmlPart(91)
if(true && (agentProfile?.authorizationLetter)) {
printHtmlPart(92)
createClosureForHtmlPart(93, 3)
invokeTag('link','g',494,['controller':("applicationManagement"),'action':("showAgentDc"),'id':(agentProfile?.id),'target':("_blank"),'params':([filename: "authorizationLetter", dataName: "authorizationLetter",csrfPreventionSalt:"${csrfPreventionSalt}"])],3)
printHtmlPart(57)
}
else {
printHtmlPart(94)
}
printHtmlPart(95)
expressionOut.print(agentProfile?.photoIdSelect)
printHtmlPart(96)
expressionOut.print(agentProfile?.photoIdNum)
printHtmlPart(97)
expressionOut.print(agentProfile?.photoIdSelect)
printHtmlPart(98)
if(true && (agentProfile?.passportCopy)) {
printHtmlPart(57)
createClosureForHtmlPart(99, 3)
invokeTag('link','g',517,['controller':("applicationManagement"),'class':("fumargin"),'action':("showAgentDc"),'id':(agentProfile?.id),'target':("_blank"),'params':([filename: "passportCopyFileName", dataName: "passportCopyFileName",csrfPreventionSalt:"${csrfPreventionSalt}"])],3)
printHtmlPart(57)
}
else {
printHtmlPart(94)
}
printHtmlPart(100)
}
printHtmlPart(101)
if(true && (appForm?.transaction?.isPaymentMade != true)) {
printHtmlPart(102)
if(true && (listOfCompanyData)) {
printHtmlPart(103)
createClosureForHtmlPart(104, 3)
invokeTag('link','g',536,['controller':("applicationManagement"),'action':("companyProfile"),'params':([appFormId:appForm?.id,formType:formType,csrfPreventionSalt:"${csrfPreventionSalt}"]),'class':("btn  btn-primary pull-right"),'method':("POST")],3)
printHtmlPart(105)
}
else if(true && (listofFormData)) {
printHtmlPart(106)
createClosureForHtmlPart(104, 3)
invokeTag('link','g',544,['controller':("applicationManagement"),'action':("individualProfile"),'params':([appFormId:appForm?.id,formType:formType,csrfPreventionSalt:"${csrfPreventionSalt}"]),'class':("btn  btn-primary pull-right"),'method':("POST")],3)
printHtmlPart(107)
}
printHtmlPart(39)
}
printHtmlPart(108)
if(true && (listOfBioResources)) {
printHtmlPart(109)

int i=1

printHtmlPart(20)
for( bioResource in (listOfBioResources) ) {
printHtmlPart(110)
out.print(i)
printHtmlPart(111)

i++

printHtmlPart(112)
expressionOut.print(bioResource?.accessIntention)
printHtmlPart(113)
expressionOut.print(bioResource?.commonName)
printHtmlPart(114)
expressionOut.print(bioResource?.scientificName)
printHtmlPart(115)
expressionOut.print(bioResource?.nature)
printHtmlPart(114)
expressionOut.print(bioResource?.biologicalResource)
printHtmlPart(114)
expressionOut.print(bioResource?.quantity)
printHtmlPart(12)
expressionOut.print(bioResource?.qtyUnit)
printHtmlPart(114)
expressionOut.print(bioResource?.fromTime?.format('dd/MM/yyyy'))
printHtmlPart(116)
expressionOut.print(bioResource?.toTime?.format('dd/MM/yyyy'))
printHtmlPart(114)
expressionOut.print(bioResource?.traditionalUse)
printHtmlPart(117)
}
printHtmlPart(118)
}
printHtmlPart(119)
if(true && (listOfLocations)) {
printHtmlPart(120)
if(true && (listOfLocations)) {
printHtmlPart(57)

int k=1

printHtmlPart(57)
for( location in (listOfLocations) ) {
printHtmlPart(121)
out.print(k)
printHtmlPart(122)

k++

printHtmlPart(123)
expressionOut.print(location?.bioResource?.scientificName)
printHtmlPart(124)
expressionOut.print(location?.source)
printHtmlPart(125)
if(true && (location?.village)) {
printHtmlPart(126)
expressionOut.print(location?.village)
printHtmlPart(127)
}
else {
printHtmlPart(128)
}
printHtmlPart(129)
if(true && (location?.town)) {
printHtmlPart(126)
expressionOut.print(location?.town)
printHtmlPart(127)
}
else {
printHtmlPart(128)
}
printHtmlPart(130)
if(true && (location?.district)) {
printHtmlPart(126)
expressionOut.print(location?.district)
printHtmlPart(127)
}
else {
printHtmlPart(128)
}
printHtmlPart(130)
if(true && (location?.state)) {
printHtmlPart(126)
expressionOut.print(location?.state)
printHtmlPart(127)
}
else {
printHtmlPart(128)
}
printHtmlPart(130)
if(true && (location?.traderName)) {
printHtmlPart(126)
expressionOut.print(location?.traderName)
printHtmlPart(127)
}
else {
printHtmlPart(128)
}
printHtmlPart(130)
if(true && (location?.traderContactDetails)) {
printHtmlPart(126)
expressionOut.print(location?.traderContactDetails)
printHtmlPart(127)
}
else {
printHtmlPart(128)
}
printHtmlPart(131)
}
printHtmlPart(59)
}
printHtmlPart(132)
}
printHtmlPart(133)
if(true && (appForm?.transaction?.isPaymentMade != true)) {
printHtmlPart(134)
createClosureForHtmlPart(135, 2)
invokeTag('link','g',732,['controller':("applicationManagement"),'action':("form1Part2"),'params':([appFormId:appForm?.id,formType:formType,csrfPreventionSalt:"${csrfPreventionSalt}"]),'class':("btn  btn-primary text-center pull-right"),'method':("POST")],2)
printHtmlPart(136)
}
printHtmlPart(137)
expressionOut.print(appForm?.nature)
printHtmlPart(136)
if(true && (appForm?.nature != 'No')) {
printHtmlPart(138)
expressionOut.print(appForm?.traditionalKnowledgeDesc)
printHtmlPart(136)
}
printHtmlPart(139)
if(true && (appForm?.nature == 'No')) {
printHtmlPart(140)
expressionOut.print(appForm?.nature)
printHtmlPart(136)
}
printHtmlPart(141)
if(true && (appForm?.nature != 'No')) {
printHtmlPart(142)
if(true && (listOfCommunityLocations)) {
printHtmlPart(143)
if(true && (listOfCommunityLocations)) {
printHtmlPart(59)

int a=1

printHtmlPart(59)
for( location in (listOfCommunityLocations) ) {
printHtmlPart(144)
out.print(a)
printHtmlPart(145)

a++

printHtmlPart(146)
expressionOut.print(location?.communityKnowledge)
printHtmlPart(147)
expressionOut.print(location?.village)
printHtmlPart(148)
expressionOut.print(location?.town)
printHtmlPart(149)
expressionOut.print(location?.district)
printHtmlPart(148)
expressionOut.print(State?.findById(location?.state)?.state)
printHtmlPart(150)
}
printHtmlPart(151)
}
printHtmlPart(152)
}
printHtmlPart(153)
}
printHtmlPart(154)
if(true && (appForm?.selfAuthorizedPerson)) {
printHtmlPart(155)
}
else {
printHtmlPart(156)
}
printHtmlPart(157)
if(true && (!appForm?.selfAuthorizedPerson)) {
printHtmlPart(39)
if(true && (listOfContactPerson)) {
printHtmlPart(158)

int b=1

printHtmlPart(6)
for( profile in (listOfContactPerson) ) {
printHtmlPart(159)
out.print(b)
printHtmlPart(160)

b++

printHtmlPart(161)
expressionOut.print(profile?.nameOfContactPerson)
printHtmlPart(162)
expressionOut.print(profile?.addressOfContactPerson)
printHtmlPart(163)
expressionOut.print(profile?.mobileOfContactPerson)
printHtmlPart(163)
expressionOut.print(profile?.emailOfContactPerson)
printHtmlPart(164)
}
printHtmlPart(165)
}
printHtmlPart(39)
}
printHtmlPart(166)
expressionOut.print(appForm?.purposeOfProposal)
printHtmlPart(167)
expressionOut.print(appForm?.briefDescription)
printHtmlPart(168)
if(true && (appForm?.isRisky == 'true')) {
printHtmlPart(169)
}
else {
printHtmlPart(170)
}
printHtmlPart(171)
if(true && (appForm?.isRisky == 'true')) {
printHtmlPart(172)
expressionOut.print(appForm?.riskInvolved)
printHtmlPart(173)
}
printHtmlPart(174)
if(true && (appForm?.transaction?.isPaymentMade != true)) {
printHtmlPart(134)
createClosureForHtmlPart(175, 2)
invokeTag('link','g',955,['controller':("applicationManagement"),'action':("form1Part3"),'params':([appFormId:appForm?.id,formType:formType,csrfPreventionSalt:"${csrfPreventionSalt}"]),'class':("btn  btn-primary pull-right"),'method':("POST")],2)
printHtmlPart(136)
}
printHtmlPart(176)
if(true && (appForm?.instituteParticipation == 'true')) {
printHtmlPart(177)
}
else {
printHtmlPart(170)
}
printHtmlPart(178)
if(true && (appForm?.instituteParticipation == 'true')) {
printHtmlPart(179)
expressionOut.print(appForm?.detailsOfInstitute)
printHtmlPart(6)
}
else {
printHtmlPart(180)
}
printHtmlPart(181)
if(true && (appForm?.letterOfintent)) {
printHtmlPart(71)
createTagBody(2, {->
printHtmlPart(69)
expressionOut.print(appForm?.letterOfIntentName)
printHtmlPart(71)
})
invokeTag('link','g',1022,['controller':("applicationManagement"),'action':("showAppDc"),'id':(appForm?.id),'target':("_blank"),'params':([filename: "letterOfIntentName", dataName: "letterOfIntentName",csrfPreventionSalt:"${csrfPreventionSalt}"])],2)
printHtmlPart(182)
}
else {
printHtmlPart(183)
}
printHtmlPart(184)
for( mapKeyValue in (quesAnswerMap) ) {
printHtmlPart(185)
expressionOut.print(mapKeyValue?.getKey()?.questionNo)
printHtmlPart(186)
expressionOut.print(mapKeyValue?.getKey()?.question)
printHtmlPart(187)
if(true && (mapKeyValue?.getValue()?.answer)) {
printHtmlPart(188)
expressionOut.print(mapKeyValue?.getValue()?.answer)
printHtmlPart(189)
}
else {
printHtmlPart(190)
}
printHtmlPart(191)
}
printHtmlPart(192)
if(true && (appForm?.isBenefitSharing?.equals('true'))) {
printHtmlPart(193)
}
else if(true && (appForm?.isBenefitSharing?.equals('false'))) {
printHtmlPart(194)
}
else {
printHtmlPart(195)
}
printHtmlPart(196)
if(true && (appForm?.isBenefitSharing?.equals('true'))) {
printHtmlPart(197)
if(true && (appForm?.sharingDoc)) {
printHtmlPart(71)
createTagBody(3, {->
printHtmlPart(69)
expressionOut.print(appForm?.sharingDocName)
printHtmlPart(71)
})
invokeTag('link','g',1093,['controller':("applicationManagement"),'action':("showAppDc"),'id':(appForm?.id),'target':("_blank"),'params':([filename: "sharingDocName", dataName: "sharingDocName",csrfPreventionSalt:"${csrfPreventionSalt}"])],3)
printHtmlPart(57)
}
else {
printHtmlPart(128)
}
printHtmlPart(198)
}
printHtmlPart(199)
if(true && (appForm?.companyProfiles?.size() != 0)) {
printHtmlPart(200)
if(true && (appForm?.payBenefitSharing == 'Monetary')) {
printHtmlPart(201)
}
else if(true && (appForm?.payBenefitSharing == 'Non-Monetary')) {
printHtmlPart(202)
}
else {
printHtmlPart(203)
}
printHtmlPart(204)
if(true && (appForm?.isMonetary == 'purchasePrice')) {
printHtmlPart(205)
}
else if(true && (appForm?.isMonetary == 'exFactorySale')) {
printHtmlPart(206)
}
else {
printHtmlPart(203)
}
printHtmlPart(207)
}
printHtmlPart(208)
if(true && (appForm?.otherInfo)) {
printHtmlPart(188)
expressionOut.print(appForm?.otherInfo)
printHtmlPart(189)
}
else {
printHtmlPart(190)
}
printHtmlPart(209)
if(true && (appForm?.isTradingPurpose?.equals('true'))) {
printHtmlPart(210)
if(true && (listOfBioResources)) {
printHtmlPart(57)

int i=1

printHtmlPart(57)
for( bioResource in (listOfBioResources) ) {
printHtmlPart(211)
out.print(i)
printHtmlPart(122)

i++

printHtmlPart(123)
expressionOut.print(bioResource?.accessIntention)
printHtmlPart(212)
if(true && (bioResource?.accessIntention == 'Biological Resources' || bioResource?.accessIntention == 'Biological Resources & Traditional Knowledge' || bioResource?.accessIntention == 'Associated Knowledge')) {
printHtmlPart(213)
expressionOut.print(bioResource?.commonName)
printHtmlPart(214)
expressionOut.print(bioResource?.scientificName)
printHtmlPart(214)
expressionOut.print(bioResource?.nature)
printHtmlPart(214)
expressionOut.print(bioResource?.biologicalResource)
printHtmlPart(215)
}
else {
printHtmlPart(216)
}
printHtmlPart(217)
if(true && (bioResource?.accessIntention == 'Biological Resources' || bioResource?.accessIntention == 'Biological Resources & Traditional Knowledge' || bioResource?.accessIntention == 'Associated Knowledge')) {
printHtmlPart(218)
expressionOut.print(bioResource?.quantity)
printHtmlPart(12)
expressionOut.print(bioResource?.qtyUnit)
printHtmlPart(219)
}
else {
printHtmlPart(220)
}
printHtmlPart(221)
expressionOut.print(bioResource?.ratePerUnit)
printHtmlPart(222)
expressionOut.print(bioResource?.stateBiodeversityBoard)
printHtmlPart(223)
expressionOut.print(bioResource?.prospectiveBuyers)
printHtmlPart(224)
}
}
else {
printHtmlPart(225)
}
printHtmlPart(226)
if(true && (appForm?.conditionOfAbs == true)) {
printHtmlPart(227)
}
printHtmlPart(6)
if(true && (appForm?.infromationTrue == true)) {
printHtmlPart(228)
}
else {
printHtmlPart(229)
}
printHtmlPart(230)
if(true && (appForm?.approvalOfNba == true)) {
printHtmlPart(231)
}
printHtmlPart(6)
if(true && (appForm?.recordsWithTheNba == true)) {
printHtmlPart(232)
}
printHtmlPart(6)
if(true && (appForm?.infromationTrue == true)) {
printHtmlPart(233)
}
printHtmlPart(234)
}
printHtmlPart(235)
if(true && (appForm?.transaction?.isPaymentMade != true)) {
printHtmlPart(236)
createClosureForHtmlPart(237, 2)
invokeTag('link','g',1330,['controller':("applicationManagement"),'action':("form1Part4"),'params':([appFormId:appForm?.id,formType:formType,csrfPreventionSalt:"${csrfPreventionSalt}"]),'class':("btn  btn-primary pull-right"),'method':("POST")],2)
printHtmlPart(136)
}
printHtmlPart(238)
if(true && (appForm?.isDeclarationDigitallySigned == 'true')) {
printHtmlPart(239)
}
else {
printHtmlPart(240)
}
printHtmlPart(241)
if(true && (appForm?.submitCheck == true)) {
printHtmlPart(242)
}
else {
printHtmlPart(243)
}
printHtmlPart(244)
if(true && (appForm?.transaction?.isPaymentMade == true)) {
printHtmlPart(245)
expressionOut.print(appForm?.transaction?.transactionId)
printHtmlPart(246)
expressionOut.print(appForm?.transaction?.paymentRefNo)
printHtmlPart(247)
createClosureForHtmlPart(248, 2)
invokeTag('link','g',1435,['controller':("applicationManagement"),'action':("showIndividualDc"),'id':(appForm?.transaction?.id),'target':("_blank"),'params':([filename: "paymentReceipt", dataName: "paymentReceipt", appFormId: appForm?.id,csrfPreventionSalt:"${csrfPreventionSalt}"])],2)
printHtmlPart(249)
}
printHtmlPart(250)
createClosureForHtmlPart(251, 1)
invokeTag('link','g',1450,['controller':("FormPreview"),'class':("btn btn-primary"),'action':("printCompleateProject"),'target':("_blank"),'params':([id:appForm?.id,csrfPreventionSalt:"${csrfPreventionSalt}"])],1)
printHtmlPart(12)
createClosureForHtmlPart(252, 1)
invokeTag('link','g',1455,['controller':("PDF"),'class':("btn btn-primary"),'action':("index"),'params':([projectId:appForm?.id,csrfPreventionSalt:"${csrfPreventionSalt}"])],1)
printHtmlPart(253)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1603125870000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
