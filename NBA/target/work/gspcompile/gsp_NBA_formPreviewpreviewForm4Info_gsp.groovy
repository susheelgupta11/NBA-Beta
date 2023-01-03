
import org.nba.common.State

import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_NBA_formPreviewpreviewForm4Info_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/formPreview/previewForm4Info.gsp" }
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

int num = 1

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
expressionOut.print(profile?.idProofSelect)
printHtmlPart(26)
expressionOut.print(profile?.idNum)
printHtmlPart(27)
expressionOut.print(profile?.idProofSelect)
printHtmlPart(28)
createClosureForHtmlPart(29, 3)
invokeTag('link','g',148,['controller':("applicationManagement"),'action':("showIndividualDc"),'id':(profile?.id),'target':("_blank"),'params':([filename: "idProof", dataName: "idProof",csrfPreventionSalt:"${csrfPreventionSalt}"])],3)
printHtmlPart(30)
expressionOut.print(profile?.passportNum)
printHtmlPart(31)
createClosureForHtmlPart(29, 3)
invokeTag('link','g',164,['controller':("applicationManagement"),'action':("showIndividualDc"),'id':(profile?.id),'target':("_blank"),'params':([filename: "passportCopy", dataName: "passportCopy",csrfPreventionSalt:"${csrfPreventionSalt}"])],3)
printHtmlPart(32)
expressionOut.print(profile?.authorizationNo)
printHtmlPart(33)
if(true && (profile?.authorizationLetter)) {
printHtmlPart(34)
createClosureForHtmlPart(35, 4)
invokeTag('link','g',182,['controller':("applicationManagement"),'action':("showIndividualDc"),'id':(profile?.id),'target':("_blank"),'params':([filename: "authorizationLetter", dataName: "authorizationLetter",csrfPreventionSalt:"${csrfPreventionSalt}"])],4)
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

printHtmlPart(42)

char y = 65

printHtmlPart(42)
for( companyProfile1 in (listOfCompanyData) ) {
printHtmlPart(43)
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
printHtmlPart(12)
expressionOut.print(companyProfile1?.address2)
printHtmlPart(12)
expressionOut.print(companyProfile1?.address3)
printHtmlPart(12)
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
createClosureForHtmlPart(63, 4)
invokeTag('link','g',303,['controller':("applicationManagement"),'action':("showDc"),'id':(companyProfile1?.id),'target':("_blank"),'class':("fumargin"),'params':([filename: "registrationDocName", dataName: "registrationDoc",csrfPreventionSalt:"${csrfPreventionSalt}"])],4)
printHtmlPart(54)
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
printHtmlPart(69)
expressionOut.print(companyProfile1?.mobile)
printHtmlPart(54)
}
printHtmlPart(70)
expressionOut.print(companyProfile1?.personEmail)
printHtmlPart(71)
expressionOut.print(companyProfile1?.idNum)
printHtmlPart(72)
expressionOut.print(companyProfile1?.authRepresentativeIdSelect)
printHtmlPart(73)
if(true && (companyProfile1?.passportCopy)) {
printHtmlPart(74)
createClosureForHtmlPart(75, 4)
invokeTag('link','g',367,['controller':("applicationManagement"),'action':("showDc"),'id':(companyProfile1?.id),'target':("_blank"),'params':([filename: "passportCopy", dataName: "passportCopy",csrfPreventionSalt:"${csrfPreventionSalt}"])],4)
printHtmlPart(76)
}
else {
printHtmlPart(77)
}
printHtmlPart(78)
if(true && (companyProfile1?.authorizationLetter)) {
printHtmlPart(74)
createClosureForHtmlPart(79, 4)
invokeTag('link','g',383,['controller':("applicationManagement"),'action':("showDc"),'class':("fumargin"),'id':(companyProfile1?.id),'target':("_blank"),'params':([filename: "authorizationLetterFileName", dataName: "authorizationLetterFileName",csrfPreventionSalt:"${csrfPreventionSalt}"])],4)
printHtmlPart(76)
}
else {
printHtmlPart(77)
}
printHtmlPart(80)
}
printHtmlPart(42)
}
printHtmlPart(81)
if(true && (listOfCompanyData?.size() != 0)) {
printHtmlPart(82)
}
else {
printHtmlPart(83)
}
printHtmlPart(84)
if(true && (agentProfile != null)) {
printHtmlPart(85)
}
else {
printHtmlPart(86)
}
printHtmlPart(87)
if(true && (agentProfile != null)) {
printHtmlPart(88)
expressionOut.print(agentProfile?.profile)
printHtmlPart(89)
expressionOut.print(agentProfile?.title)
printHtmlPart(12)
expressionOut.print(agentProfile?.firstName)
printHtmlPart(12)
expressionOut.print(agentProfile?.middleName)
printHtmlPart(12)
expressionOut.print(agentProfile?.lastName)
printHtmlPart(90)
expressionOut.print(agentProfile?.address1)
printHtmlPart(12)
expressionOut.print(agentProfile?.address2)
printHtmlPart(12)
expressionOut.print(agentProfile?.address3)
printHtmlPart(91)
expressionOut.print(State.findById(agentProfile?.province)?.state)
printHtmlPart(92)
expressionOut.print(agentProfile?.city)
printHtmlPart(93)
expressionOut.print(agentProfile?.pincode)
printHtmlPart(94)
expressionOut.print(agentProfile?.mobile)
printHtmlPart(95)
expressionOut.print(agentProfile?.email)
printHtmlPart(96)
if(true && (agentProfile?.authorizationLetter)) {
printHtmlPart(97)
createClosureForHtmlPart(98, 3)
invokeTag('link','g',447,['controller':("applicationManagement"),'action':("showAgentDc"),'id':(agentProfile?.id),'target':("_blank"),'params':([filename: "authorizationLetter", dataName: "authorizationLetter",csrfPreventionSalt:"${csrfPreventionSalt}"])],3)
printHtmlPart(99)
}
else {
printHtmlPart(100)
}
printHtmlPart(101)
expressionOut.print(agentProfile?.photoIdSelect)
printHtmlPart(102)
expressionOut.print(agentProfile?.photoIdNum)
printHtmlPart(103)
expressionOut.print(agentProfile?.photoIdSelect)
printHtmlPart(104)
if(true && (agentProfile?.passportCopy)) {
printHtmlPart(76)
createClosureForHtmlPart(98, 3)
invokeTag('link','g',470,['controller':("applicationManagement"),'class':("fumargin"),'action':("showAgentDc"),'id':(agentProfile?.id),'target':("_blank"),'params':([filename: "passportCopyFileName", dataName: "passportCopyFileName",csrfPreventionSalt:"${csrfPreventionSalt}"])],3)
printHtmlPart(99)
}
else {
printHtmlPart(100)
}
printHtmlPart(105)
}
printHtmlPart(106)
if(true && (appForm?.transaction?.isPaymentMade != true)) {
printHtmlPart(107)
if(true && (listOfCompanyData)) {
printHtmlPart(108)
createClosureForHtmlPart(109, 3)
invokeTag('link','g',492,['controller':("applicationManagement"),'action':("companyProfile"),'params':([appFormId: appForm?.id, formType: formType,csrfPreventionSalt:"${csrfPreventionSalt}"]),'class':("btn  btn-primary pull-right"),'method':("POST")],3)
printHtmlPart(110)
}
else if(true && (listofFormData)) {
printHtmlPart(108)
createClosureForHtmlPart(109, 3)
invokeTag('link','g',501,['controller':("applicationManagement"),'action':("individualProfile"),'params':([appFormId: appForm?.id, formType: formType,csrfPreventionSalt:"${csrfPreventionSalt}"]),'class':("btn  btn-primary pull-right"),'method':("POST")],3)
printHtmlPart(110)
}
printHtmlPart(43)
}
printHtmlPart(111)
if(true && (listOfBioResources?.size() > 0)) {
printHtmlPart(112)

int i = 1

printHtmlPart(113)
for( bioResource in (listOfBioResources) ) {
printHtmlPart(114)
out.print(i)
printHtmlPart(115)

i++

printHtmlPart(116)
expressionOut.print(bioResource?.accessIntention)
printHtmlPart(117)
expressionOut.print(bioResource?.commonName)
printHtmlPart(118)
expressionOut.print(bioResource?.scientificName)
printHtmlPart(119)
expressionOut.print(bioResource?.nature)
printHtmlPart(119)
expressionOut.print(bioResource?.biologicalResource)
printHtmlPart(120)
}
printHtmlPart(121)
}
printHtmlPart(122)
createTagBody(1, {->
printHtmlPart(123)
expressionOut.print(appForm?.nbaApprovalFileName)
printHtmlPart(10)
})
invokeTag('link','g',582,['controller':("form4"),'action':("showDc"),'id':(appForm?.id),'target':("_blank"),'params':([filename: "nbaApprovalFileName", dataName: "nbaApprovalFileName", nbaApprovalPart2:"part2",csrfPreventionSalt:"${csrfPreventionSalt}"])],1)
printHtmlPart(124)
expressionOut.print(appForm?.applicationNo)
printHtmlPart(125)
expressionOut.print(appForm?.dateOfApproval?.format('dd/MM/yyyy'))
printHtmlPart(126)
if(true && (appForm?.isbenefitSharingDetailImplemented == 'true')) {
printHtmlPart(127)
}
else {
printHtmlPart(128)
}
printHtmlPart(129)
if(true && (appForm?.isbenefitSharingDetailImplemented == 'true')) {
printHtmlPart(130)
expressionOut.print(appForm?.benefitMechanism)
printHtmlPart(131)
}
printHtmlPart(132)
if(true && (appForm?.transaction?.isPaymentMade != true)) {
printHtmlPart(133)
createClosureForHtmlPart(134, 2)
invokeTag('link','g',629,['controller':("form4"),'action':("part2"),'params':([appFormId: appForm?.id, formType: formType,csrfPreventionSalt:"${csrfPreventionSalt}"]),'class':("btn  btn-primary text-center pull-right"),'method':("POST")],2)
printHtmlPart(135)
}
printHtmlPart(136)
if(true && (listOfThirdParty?.size() > 0)) {
printHtmlPart(137)
if(true && (listOfThirdParty)) {
printHtmlPart(138)

int k = 1

printHtmlPart(138)
for( thirdPartyInst in (listOfThirdParty) ) {
printHtmlPart(139)
out.print(k)
printHtmlPart(140)

k++

printHtmlPart(141)
expressionOut.print(thirdPartyInst?.name)
printHtmlPart(142)
expressionOut.print(thirdPartyInst?.addressForComm)
printHtmlPart(142)
expressionOut.print(thirdPartyInst?.state)
printHtmlPart(142)
expressionOut.print(thirdPartyInst?.pincode)
printHtmlPart(142)
expressionOut.print(thirdPartyInst?.country)
printHtmlPart(142)
expressionOut.print(thirdPartyInst?.phone)
printHtmlPart(142)
expressionOut.print(thirdPartyInst?.fax)
printHtmlPart(142)
expressionOut.print(thirdPartyInst?.website)
printHtmlPart(142)
expressionOut.print(thirdPartyInst?.email)
printHtmlPart(143)
}
printHtmlPart(69)
}
printHtmlPart(144)
}
printHtmlPart(145)
expressionOut.print(appForm?.thirdPartyTransferPurpose)
printHtmlPart(146)
expressionOut.print(appForm?.benefitsToTheThirdParty)
printHtmlPart(147)
if(true && (appForm?.isAgreementBwApplicantAndThirdParty == 'true')) {
printHtmlPart(148)
}
else if(true && (appForm?.isAgreementBwApplicantAndThirdParty == 'false')) {
printHtmlPart(149)
}
else {
printHtmlPart(150)
}
printHtmlPart(151)
if(true && (appForm?.isAgreementBwApplicantAndThirdParty == 'true')) {
printHtmlPart(152)
createClosureForHtmlPart(153, 2)
invokeTag('link','g',762,['controller':("form4"),'action':("showDc"),'id':(appForm?.id),'target':("_blank"),'params':([filename: "nbaApprovalFileName", dataName: "nbaApprovalFileName", nbaApprovalPart3:"part3",csrfPreventionSalt:"${csrfPreventionSalt}"])],2)
printHtmlPart(154)
}
printHtmlPart(155)
expressionOut.print(appForm?.benefitsOutOfThirdPartyTransfer)
printHtmlPart(156)
expressionOut.print(appForm?.mechanismOutOfThirdPartyTransfer)
printHtmlPart(157)
expressionOut.print(appForm?.otherRelevantInfo)
printHtmlPart(158)
if(true && (appForm?.transaction?.isPaymentMade != true)) {
printHtmlPart(159)
createClosureForHtmlPart(160, 2)
invokeTag('link','g',815,['controller':("form4"),'action':("part3"),'params':([appFormId: appForm?.id, formType: formType,csrfPreventionSalt:"${csrfPreventionSalt}"]),'class':("btn  btn-primary text-center pull-right"),'method':("POST")],2)
printHtmlPart(161)
}
printHtmlPart(162)
if(true && (appForm?.isDeclarationDigitallySigned == 'true')) {
printHtmlPart(163)
}
else {
printHtmlPart(164)
}
printHtmlPart(165)
if(true && (appForm?.submitCheck == true)) {
printHtmlPart(166)
}
else {
printHtmlPart(167)
}
printHtmlPart(168)
if(true && (appForm?.transaction?.isPaymentMade == true)) {
printHtmlPart(169)
expressionOut.print(appForm?.transaction?.transactionId)
printHtmlPart(170)
expressionOut.print(appForm?.transaction?.paymentRefNo)
printHtmlPart(171)
createClosureForHtmlPart(172, 2)
invokeTag('link','g',878,['controller':("applicationManagement"),'action':("showIndividualDc"),'id':(appForm?.transaction?.id),'target':("_blank"),'params':([filename: "paymentReceipt", dataName: "paymentReceipt", appFormId: appForm?.id,csrfPreventionSalt:"${csrfPreventionSalt}"])],2)
printHtmlPart(173)
}
printHtmlPart(174)
createClosureForHtmlPart(175, 1)
invokeTag('link','g',885,['controller':("FormPreview"),'class':("btn btn-primary"),'action':("printCompleateProject4"),'target':("_blank"),'params':([id:appForm?.id,csrfPreventionSalt:"${csrfPreventionSalt}"])],1)
printHtmlPart(12)
createClosureForHtmlPart(176, 1)
invokeTag('link','g',891,['controller':("PDF"),'class':("btn btn-primary"),'action':("index"),'params':([projectId:appForm?.id,csrfPreventionSalt:"${csrfPreventionSalt}"])],1)
printHtmlPart(177)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1582543254000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
