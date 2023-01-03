
import org.nba.common.*

import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_NBA_rightPane_form3ForMatchingData_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/rightPane/_form3ForMatchingData.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)

char alpha = 65

printHtmlPart(1)
if(true && (allDataforMatching?.individualDetailsForMatch.size()>0)) {
printHtmlPart(1)
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
if(true && (individualProfile?.nationality == 'Non Indian')) {
printHtmlPart(7)
expressionOut.print(individualProfile?.nationality)
printHtmlPart(8)
expressionOut.print(individualProfile?.country?.country)
printHtmlPart(9)
}
else {
printHtmlPart(10)
expressionOut.print(individualProfile?.nationality)
printHtmlPart(9)
}
printHtmlPart(11)
expressionOut.print(individualProfile?.profile)
printHtmlPart(12)
expressionOut.print(individualProfile?.address1)
printHtmlPart(5)
expressionOut.print(individualProfile?.address2)
printHtmlPart(5)
expressionOut.print(individualProfile?.address3)
printHtmlPart(13)
expressionOut.print(individualProfile?.city)
printHtmlPart(5)
expressionOut.print(individualProfile?.pincode)
printHtmlPart(14)
expressionOut.print(individualProfile?.country?.name)
printHtmlPart(15)
expressionOut.print(individualProfile?.mobile)
printHtmlPart(16)
expressionOut.print(individualProfile?.phone)
printHtmlPart(17)
expressionOut.print(individualProfile?.email)
printHtmlPart(18)
expressionOut.print(individualProfile?.idProofFileName)
printHtmlPart(19)
createClosureForHtmlPart(20, 3)
invokeTag('link','g',63,['controller':("applicationManagement"),'action':("showIndividualDc"),'id':(individualProfile?.id),'target':("_blank"),'params':([filename: 'idProof', dataName: 'idProof',csrfPreventionSalt:'${csrfPreventionSalt}'])],3)
printHtmlPart(21)
expressionOut.print(individualProfile?.idNum)
printHtmlPart(22)
if(true && (individualProfile?.authorizationLetterFileName)) {
printHtmlPart(23)
expressionOut.print(individualProfile?.authorizationLetterFileName)
printHtmlPart(19)
createClosureForHtmlPart(24, 4)
invokeTag('link','g',79,['controller':("applicationManagement"),'action':("showIndividualDc"),'id':(individualProfile?.id),'target':("_blank"),'params':([filename: 'passportCopy', dataName: 'passportCopy',csrfPreventionSalt:'${csrfPreventionSalt}'])],4)
printHtmlPart(25)
expressionOut.print(individualProfile?.authorizationNo)
printHtmlPart(13)
}
else {
printHtmlPart(26)
}
printHtmlPart(27)
if(true && (individualProfile?.passportCopyFileName)) {
printHtmlPart(19)
expressionOut.print(individualProfile?.passportCopyFileName)
printHtmlPart(19)
createClosureForHtmlPart(28, 4)
invokeTag('link','g',101,['controller':("applicationManagement"),'action':("showIndividualDc"),'id':(individualProfile?.id),'target':("_blank"),'params':([filename: 'passportCopy', dataName: 'passportCopy',csrfPreventionSalt:'${csrfPreventionSalt}'])],4)
printHtmlPart(29)
expressionOut.print(individualProfile?.passportNum)
printHtmlPart(13)
}
else {
printHtmlPart(26)
}
printHtmlPart(30)
i++
}
}
printHtmlPart(31)
}
printHtmlPart(32)
if(true && (allDataforMatching?.companyDetailsForMatch.size() > 0)) {
printHtmlPart(31)
loop:{
int j = 0
for( company in (allDataforMatching?.companyDetailsForMatch) ) {
printHtmlPart(33)
expressionOut.print(alpha)
printHtmlPart(34)
expressionOut.print(j+1)
printHtmlPart(35)
expressionOut.print(company?.entityName)
printHtmlPart(36)
expressionOut.print(company?.entityType)
printHtmlPart(37)
if(true && (company?.nationality == 'notRegisteredInIndia')) {
printHtmlPart(38)
}
else if(true && (company?.nationality == 'noNonIndianParticipation')) {
printHtmlPart(39)
}
else {
printHtmlPart(40)
}
printHtmlPart(41)
expressionOut.print(company?.address1)
printHtmlPart(5)
expressionOut.print(company?.address2)
printHtmlPart(5)
expressionOut.print(company?.address3)
printHtmlPart(5)
expressionOut.print(company?.city)
printHtmlPart(42)
expressionOut.print(company?.pincode)
printHtmlPart(43)
expressionOut.print(company?.country?.name)
printHtmlPart(44)
expressionOut.print(company?.mobile)
printHtmlPart(45)
expressionOut.print(company?.phone)
printHtmlPart(46)
expressionOut.print(company?.email)
printHtmlPart(47)
expressionOut.print(company?.website)
printHtmlPart(48)
expressionOut.print(company?.businessNature)
printHtmlPart(49)
if(true && (allDataforMatching?.companyDetailsForMatch?.registrationDoc)) {
printHtmlPart(50)
expressionOut.print(company?.registrationDocName)
printHtmlPart(50)
createClosureForHtmlPart(24, 4)
invokeTag('link','g',197,['controller':("applicationManagement"),'action':("showDc"),'id':(company?.id),'target':("_blank"),'class':("fumargin"),'params':([filename: 'registrationDocName', dataName: 'registrationDoc',csrfPreventionSalt:'${csrfPreventionSalt}'])],4)
printHtmlPart(42)
}
else {
printHtmlPart(51)
}
printHtmlPart(52)
expressionOut.print(company?.title)
printHtmlPart(5)
expressionOut.print(company?.firstName)
printHtmlPart(5)
expressionOut.print(company?.middleName)
printHtmlPart(5)
expressionOut.print(company?.lastName)
printHtmlPart(53)
expressionOut.print(company?.designation)
printHtmlPart(54)
expressionOut.print(company?.personMobile)
printHtmlPart(55)
expressionOut.print(company?.personEmail)
printHtmlPart(56)
expressionOut.print(company?.idNum)
printHtmlPart(57)
if(true && (allDataforMatching?.companyDetailsForMatch?.passportCopy)) {
printHtmlPart(58)
createTagBody(4, {->
printHtmlPart(59)
expressionOut.print(company?.passportCopyFileName)
printHtmlPart(58)
})
invokeTag('link','g',242,['controller':("applicationManagement"),'action':("showDc"),'id':(company?.id),'target':("_blank"),'params':([filename: 'passportCopy', dataName: 'passportCopy',csrfPreventionSalt:'${csrfPreventionSalt}'])],4)
printHtmlPart(60)
}
else {
printHtmlPart(61)
}
printHtmlPart(62)
createClosureForHtmlPart(63, 3)
invokeTag('link','g',255,['controller':("applicationManagement"),'action':("showDc"),'id':(company?.id),'target':("_blank"),'params':([filename: 'passportCopy', dataName: 'passportCopy',csrfPreventionSalt:'${csrfPreventionSalt}'])],3)
printHtmlPart(64)
j++
}
}
printHtmlPart(1)
}
printHtmlPart(31)
invokeTag('render','g',257,['template':("/rightPane/agentProfileMatching")],-1)
printHtmlPart(65)
invokeTag('set','g',258,['var':("listOfIPRDetails"),'value':(allDataforMatching?.listOfIPRDetails)],-1)
printHtmlPart(66)
expressionOut.print(formDetails?.titleOfIPR)
printHtmlPart(67)
expressionOut.print(formDetails?.abstractOfIPR)
printHtmlPart(68)
loop:{
int i = 0
for( countries in (formDetails?.detailsOfTerritories) ) {
printHtmlPart(69)
if(true && (formDetails?.detailsOfTerritories?.size() - i == 1)) {
printHtmlPart(70)
expressionOut.print(countries?.country)
printHtmlPart(71)
}
else {
printHtmlPart(72)
expressionOut.print(countries?.country)
printHtmlPart(73)
}
printHtmlPart(74)
i++
}
}
printHtmlPart(75)
if(true && (formDetails?.isIPApplicationFiled == 'true')) {
printHtmlPart(76)
}
else {
printHtmlPart(77)
}
printHtmlPart(78)
if(true && (formDetails?.isIPApplicationFiled == 'true')) {
printHtmlPart(79)

i=1

printHtmlPart(60)
for( ipr in (listOfIPRDetails) ) {
printHtmlPart(80)
out.print(i)
printHtmlPart(81)

i++

printHtmlPart(82)
expressionOut.print(Country.get(ipr?.country)?.country)
printHtmlPart(83)
expressionOut.print(ipr?.patentApplicationNo)
printHtmlPart(83)
expressionOut.print(ipr?.patentApplicationDate?.format('dd/MM/yyyy'))
printHtmlPart(83)
expressionOut.print(ipr?.status)
printHtmlPart(83)
expressionOut.print(ipr?.patentNo)
printHtmlPart(5)
expressionOut.print(ipr?.patentDate?.format('dd/MM/yyyy'))
printHtmlPart(84)
if(true && (ipr?.reasons)) {
printHtmlPart(85)
expressionOut.print(ipr?.reasons)
printHtmlPart(86)
}
else {
printHtmlPart(87)
}
printHtmlPart(88)
}
printHtmlPart(89)
}
printHtmlPart(90)
if(true && (formDetails?.biologicalResources)) {
printHtmlPart(91)

int i=1

printHtmlPart(60)
for( bioResource in (formDetails?.biologicalResources) ) {
printHtmlPart(92)
out.print(i)
printHtmlPart(81)

i++

printHtmlPart(93)
expressionOut.print(bioResource?.accessIntention)
printHtmlPart(94)
expressionOut.print(bioResource?.commonName)
printHtmlPart(95)
expressionOut.print(bioResource?.scientificName)
printHtmlPart(96)
expressionOut.print(bioResource?.nature)
printHtmlPart(97)
expressionOut.print(bioResource?.biologicalResource)
printHtmlPart(98)
}
printHtmlPart(99)
}
printHtmlPart(100)
if(true && (formDetails?.individualProfiles?.getAt(0)?.nationality == 'Non Indian' || formDetails?.individualProfiles?.getAt(0)?.nationality == 'Non-Resident Indian' 
					 || formDetails?.companyProfiles?.getAt(0)?.nationality == 'registeredInIndia' || formDetails?.companyProfiles?.getAt(0)?.nationality == 'noNonIndianParticipation')) {
printHtmlPart(101)
if(true && (formDetails.isApprovalOfNbaObtainedForm3 == 'true')) {
printHtmlPart(102)
}
else {
printHtmlPart(103)
}
printHtmlPart(104)
if(true && (formDetails.isApprovalOfNbaObtainedForm3 == 'false')) {
printHtmlPart(105)
if(true && (formDetails?.reasonOFNotObtainedApproval)) {
printHtmlPart(106)
expressionOut.print(formDetails?.reasonOFNotObtainedApproval)
printHtmlPart(107)
}
else {
printHtmlPart(108)
}
printHtmlPart(109)
}
else if(true && (formDetails.isApprovalOfNbaObtainedForm3 == 'true')) {
printHtmlPart(110)
if(true && (formDetails?.applicationNo)) {
printHtmlPart(111)
expressionOut.print(formDetails?.applicationNo)
printHtmlPart(112)
}
else {
printHtmlPart(113)
}
printHtmlPart(114)
if(true && (formDetails?.isApprovalOfNbaObtainedForm3 == 'true')) {
printHtmlPart(111)
expressionOut.print(formDetails?.dateOfApproval?.format('dd/MM/yyyy'))
printHtmlPart(112)
}
else {
printHtmlPart(113)
}
printHtmlPart(115)
if(true && (formDetails?.nbaApprovalFile && formDetails?.isApprovalOfNbaObtainedForm3 == 'true')) {
printHtmlPart(116)
createClosureForHtmlPart(117, 4)
invokeTag('link','g',498,['controller':("form3"),'action':("showDc"),'id':(formDetails?.id),'target':("_blank"),'params':([filename: "nbaApprovalFileName", dataName: "nbaApprovalFileName",csrfPreventionSalt:"${csrfPreventionSalt}"])],4)
printHtmlPart(50)
}
else {
printHtmlPart(118)
}
printHtmlPart(104)
}
printHtmlPart(119)
}
printHtmlPart(120)
if(true && (formDetails?.biologicalResources?.locations)) {
printHtmlPart(121)
if(true && (formDetails?.biologicalResources?.locations)) {
printHtmlPart(86)
loop:{
int l = 0
for( giolocation in (formDetails?.biologicalResources?.locations) ) {
printHtmlPart(85)
loop:{
int m = 0
for( gioloct in (giolocation) ) {
printHtmlPart(122)
loop:{
int n = 0
for( gioloc in (gioloct) ) {
printHtmlPart(123)
expressionOut.print(l+1)
printHtmlPart(124)
expressionOut.print(gioloc?.bioResource?.scientificName?:'NA')
printHtmlPart(125)
expressionOut.print(gioloc?.source?:'NA')
printHtmlPart(126)
expressionOut.print(gioloc?.village?:'NA')
printHtmlPart(127)
expressionOut.print(gioloc?.town?: 'NA')
printHtmlPart(127)
expressionOut.print(gioloc?.district?:'NA')
printHtmlPart(127)
expressionOut.print(gioloc?.state?:'NA')
printHtmlPart(127)
expressionOut.print(gioloc?.traderName?:'NA')
printHtmlPart(127)
expressionOut.print(gioloc?.traderContactDetails?:'NA')
printHtmlPart(128)
n++
}
}
printHtmlPart(85)
m++
}
}
printHtmlPart(86)
l++
}
}
printHtmlPart(59)
}
printHtmlPart(129)
}
printHtmlPart(130)
if(true && (formDetails?.isBioObtainedOutsideIndia == 'true')) {
printHtmlPart(131)
}
else if(true && (formDetails?.isBioObtainedOutsideIndia == 'false')) {
printHtmlPart(132)
}
else {
printHtmlPart(133)
}
printHtmlPart(134)
if(true && (formDetails?.isBioObtainedOutsideIndia == 'true')) {
printHtmlPart(50)
expressionOut.print(formDetails?.traditionalKnowledgeDesc)
printHtmlPart(135)
}
else if(true && (formDetails?.isBioObtainedOutsideIndia == 'false')) {
printHtmlPart(136)
}
else {
printHtmlPart(135)
}
printHtmlPart(137)
if(true && (formDetails?.isBioObtainedOutsideIndia == 'false')) {
printHtmlPart(118)
}
else if(true && (formDetails?.isApprovalOfCountryObtained == 'true')) {
printHtmlPart(76)
}
else if(true && (formDetails?.isApprovalOfCountryObtained == 'false')) {
printHtmlPart(77)
}
printHtmlPart(138)
if(true && (formDetails?.isApprovalOfCountryObtained == 'false')) {
printHtmlPart(139)
if(true && (formDetails?.reasonOfDisapproval)) {
printHtmlPart(116)
expressionOut.print(formDetails?.reasonOfDisapproval)
printHtmlPart(50)
}
else {
printHtmlPart(118)
}
printHtmlPart(140)
}
printHtmlPart(141)
if(true && (formDetails?.isTraditionalKnowledgeApplicable == 'Applicable')) {
printHtmlPart(142)
}
else if(true && (formDetails?.isTraditionalKnowledgeApplicable == 'Not applicable')) {
printHtmlPart(143)
}
else {
printHtmlPart(144)
}
printHtmlPart(145)
if(true && (formDetails?.isTraditionalKnowledgeApplicable == 'Applicable')) {
printHtmlPart(146)
expressionOut.print(formDetails?.traditionalKnowledgeUsedInInvention)
printHtmlPart(147)
}
printHtmlPart(148)
if(true && (formDetails?.isTraditionalKnowledgeApplicable != 'Applicable' || !listOfCommunityLocations)) {
printHtmlPart(149)
}
else {
printHtmlPart(150)
}
printHtmlPart(151)
if(true && (formDetails?.isTraditionalKnowledgeApplicable == 'Applicable')) {
printHtmlPart(13)
if(true && (listOfCommunityLocations)) {
printHtmlPart(152)

int a=1

printHtmlPart(58)
for( location in (listOfCommunityLocations) ) {
printHtmlPart(153)
out.print(a)
printHtmlPart(154)

a++

printHtmlPart(155)
expressionOut.print(location?.communityKnowledge)
printHtmlPart(156)
expressionOut.print(location?.village)
printHtmlPart(156)
expressionOut.print(location?.town)
printHtmlPart(157)
expressionOut.print(location?.district)
printHtmlPart(156)
expressionOut.print(State?.findById(location?.state)?.state)
printHtmlPart(158)
}
printHtmlPart(159)
}
printHtmlPart(19)
}
printHtmlPart(160)
expressionOut.print(formDetails?.detailsOfInstitute)
printHtmlPart(161)
expressionOut.print(formDetails?.benefitsToTheApplicant)
printHtmlPart(162)
if(true && (formDetails?.isDeclarationDigitallySigned == 'true')) {
printHtmlPart(163)
}
else {
printHtmlPart(164)
}
printHtmlPart(165)
if(true && (formDetails?.submitCheck == true)) {
printHtmlPart(166)
}
else {
printHtmlPart(167)
}
printHtmlPart(168)
if(true && (formDetails?.transaction?.isPaymentMade == true)) {
printHtmlPart(169)
expressionOut.print(formDetails?.transaction?.transactionId)
printHtmlPart(170)
expressionOut.print(formDetails?.transaction?.paymentRefNo)
printHtmlPart(171)
createClosureForHtmlPart(172, 2)
invokeTag('link','g',865,['controller':("applicationManagement"),'action':("showIndividualDc"),'id':(formDetails?.transaction?.id),'target':("_blank"),'params':([filename: "paymentReceipt", dataName: "paymentReceipt", appFormId: formDetails?.id,csrfPreventionSalt:"${csrfPreventionSalt}"])],2)
printHtmlPart(173)
}
printHtmlPart(1)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1610008150887L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
