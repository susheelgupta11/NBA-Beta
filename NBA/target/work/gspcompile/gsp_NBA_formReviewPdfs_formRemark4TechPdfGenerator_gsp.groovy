import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_NBA_formReviewPdfs_formRemark4TechPdfGenerator_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/formReviewPdfs/_formRemark4TechPdfGenerator.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',22,['gsp_sm_xmlClosingForEmptyTag':("/"),'http-equiv':("Content-Type"),'content':("text/html; charset=ISO-8859-1")],-1)
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',23,['gsp_sm_xmlClosingForEmptyTag':("/"),'name':("layout"),'content':("main")],-1)
printHtmlPart(1)
createTagBody(2, {->
createClosureForHtmlPart(2, 3)
invokeTag('captureTitle','sitemesh',24,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',24,[:],2)
printHtmlPart(3)
})
invokeTag('captureHead','sitemesh',33,[:],1)
printHtmlPart(1)
createTagBody(1, {->
printHtmlPart(4)
expressionOut.print(formDetails?.submittedOn)
printHtmlPart(5)
expressionOut.print(formDetails?.appNumber)
printHtmlPart(6)
expressionOut.print(formDetails?.appNumber)
printHtmlPart(7)
expressionOut.print(formRemkInstance?.onlineAppNumberRmk)
printHtmlPart(8)
expressionOut.print(formRemkInstance?.nbaRefNumber)
printHtmlPart(9)
expressionOut.print(formRemkInstance?.nbaRefNumberRemark)
printHtmlPart(10)
if(true && (formDetails?.individualProfiles)) {
printHtmlPart(11)
}
else if(true && (formDetails?.companyProfiles)) {
printHtmlPart(12)
}
else if(true && (formDetails?.indianGovtInst)) {
printHtmlPart(13)
}
else if(true && (formDetails?.depostionOfMicroOrganism)) {
}
printHtmlPart(9)
expressionOut.print(formRemkInstance?.applicantCatgRmk)
printHtmlPart(14)
if(true && (formDetails?.individualProfiles)) {
printHtmlPart(15)
for( individualProfile in (formDetails?.individualProfiles) ) {
printHtmlPart(16)
expressionOut.print(individualProfile?.title)
printHtmlPart(17)
expressionOut.print(individualProfile?.firstName)
printHtmlPart(17)
expressionOut.print(individualProfile?.middleName)
printHtmlPart(17)
expressionOut.print(individualProfile?.lastName)
printHtmlPart(17)
expressionOut.print(individualProfile?.address1)
printHtmlPart(17)
expressionOut.print(individualProfile?.address2)
printHtmlPart(17)
expressionOut.print(individualProfile?.address3)
printHtmlPart(17)
expressionOut.print(individualProfile?.city)
printHtmlPart(15)
}
printHtmlPart(18)
}
else if(true && (formDetails?.companyProfiles)) {
printHtmlPart(15)
loop:{
int k = 0
for( company in (formDetails?.companyProfiles) ) {
printHtmlPart(17)
expressionOut.print(company?.entityName)
printHtmlPart(15)
k++
}
}
printHtmlPart(18)
}
else if(true && (formDetails?.indianResearcher)) {
printHtmlPart(15)
for( researcher in (formDetails?.indianResearcher) ) {
printHtmlPart(16)
expressionOut.print(researcher?.title)
printHtmlPart(17)
expressionOut.print(researcher?.firstName)
printHtmlPart(17)
expressionOut.print(researcher?.middleName)
printHtmlPart(17)
expressionOut.print(researcher?.lastName)
printHtmlPart(17)
expressionOut.print(researcher?.address1)
printHtmlPart(17)
expressionOut.print(researcher?.address2)
printHtmlPart(17)
expressionOut.print(researcher?.address3)
printHtmlPart(17)
expressionOut.print(researcher?.presentCity)
printHtmlPart(15)
}
printHtmlPart(18)
}
else if(true && (formDetails?.depostionOfMicroOrganism)) {
printHtmlPart(15)
for( depost in (formDetails?.depostionOfMicroOrganism) ) {
printHtmlPart(17)
expressionOut.print(depost?.nameOfDepositor)
printHtmlPart(17)
expressionOut.print(depost?.address1)
printHtmlPart(17)
expressionOut.print(depost?.address2)
printHtmlPart(17)
expressionOut.print(depost?.address3)
printHtmlPart(17)
expressionOut.print(depost?.city)
printHtmlPart(15)
}
printHtmlPart(18)
}
else if(true && (formDetails?.indianGovtInst)) {
printHtmlPart(15)
for( govt in (formDetails?.indianGovtInst) ) {
printHtmlPart(17)
expressionOut.print(govt?.govtInstName)
printHtmlPart(17)
expressionOut.print(govt?.address1)
printHtmlPart(17)
expressionOut.print(govt?.address2)
printHtmlPart(17)
expressionOut.print(govt?.address3)
printHtmlPart(17)
expressionOut.print(govt?.presentCity)
printHtmlPart(15)
}
printHtmlPart(18)
}
printHtmlPart(19)
expressionOut.print(formRemkInstance?.applicantNameContRmk)
printHtmlPart(20)
if(true && (formDetails?.agentProfile)) {
printHtmlPart(18)
expressionOut.print(formDetails?.agentProfile?.title)
printHtmlPart(21)
expressionOut.print(formDetails?.agentProfile?.firstName)
printHtmlPart(18)
expressionOut.print(formDetails?.agentProfile?.middleName)
printHtmlPart(21)
expressionOut.print(formDetails?.agentProfile?.lastName)
printHtmlPart(18)
expressionOut.print(formDetails?.agentProfile?.address1)
printHtmlPart(21)
expressionOut.print(formDetails?.agentProfile?.address2)
printHtmlPart(18)
expressionOut.print(formDetails?.agentProfile?.address3)
printHtmlPart(21)
expressionOut.print(formDetails?.agentProfile?.city)
printHtmlPart(18)
}
else if(true && (formDetails?.companyProfiles)) {
printHtmlPart(18)
for( company in (formDetails?.companyProfiles) ) {
printHtmlPart(18)
expressionOut.print(company?.title)
printHtmlPart(21)
expressionOut.print(company?.firstName)
printHtmlPart(21)
expressionOut.print(company?.middleName)
printHtmlPart(21)
expressionOut.print(company?.lastName)
printHtmlPart(22)
expressionOut.print(company?.personMobile)
printHtmlPart(23)
expressionOut.print(company?.personEmail)
printHtmlPart(18)
}
printHtmlPart(18)
}
else {
printHtmlPart(24)
}
printHtmlPart(25)
expressionOut.print(formRemkInstance?.authPersonContRmk)
printHtmlPart(26)
if(true && (formDetails?.agentProfile)) {
printHtmlPart(27)
expressionOut.print(formDetails?.agentProfile?.title)
printHtmlPart(21)
expressionOut.print(formDetails?.agentProfile?.firstName)
printHtmlPart(18)
expressionOut.print(formDetails?.agentProfile?.middleName)
printHtmlPart(21)
expressionOut.print(formDetails?.agentProfile?.lastName)
printHtmlPart(18)
expressionOut.print(formDetails?.agentProfile?.address1)
printHtmlPart(21)
expressionOut.print(formDetails?.agentProfile?.address2)
printHtmlPart(18)
expressionOut.print(formDetails?.agentProfile?.address3)
printHtmlPart(21)
expressionOut.print(formDetails?.agentProfile?.city)
printHtmlPart(28)
}
else {
printHtmlPart(29)
}
printHtmlPart(9)
expressionOut.print(formRemkInstance?.attorneyInIndiaContRmk)
printHtmlPart(30)
expressionOut.print(formRemkInstance?.appFormCatgRmk)
printHtmlPart(31)
if(true && (formRemkInstance?.idAndAddress == '' || formRemkInstance?.idAndAddress == null)) {
printHtmlPart(32)
}
else if(true && (formRemkInstance?.idAndAddress == true)) {
printHtmlPart(33)
}
else if(true && (formRemkInstance?.idAndAddress == false)) {
printHtmlPart(34)
}
printHtmlPart(35)
expressionOut.print(formRemkInstance?.idAndAddressRemark)
printHtmlPart(36)
if(true && (formRemkInstance?.serialNo == '' || formRemkInstance?.serialNo == null)) {
printHtmlPart(37)
}
else if(true && (formRemkInstance?.serialNo == true)) {
printHtmlPart(38)
}
else if(true && (formRemkInstance?.serialNo == false)) {
printHtmlPart(38)
}
printHtmlPart(39)
expressionOut.print(formRemkInstance?.serialNumRemk)
printHtmlPart(40)
if(true && (formDetails?.biologicalResources)) {
printHtmlPart(41)
loop:{
int i = 0
for( resource in (formDetails?.biologicalResources) ) {
printHtmlPart(42)
expressionOut.print(i+1)
printHtmlPart(43)
expressionOut.print(resource?.accessIntention?:'NA')
printHtmlPart(43)
expressionOut.print(resource?.commonName?:'NA')
printHtmlPart(43)
expressionOut.print(resource?.scientificName?:'NA')
printHtmlPart(43)
expressionOut.print(resource?.nature?:'NA')
printHtmlPart(43)
expressionOut.print(resource?.biologicalResource?:'NA')
printHtmlPart(44)
expressionOut.print(formRemkInstance?.biologicalResRmk)
printHtmlPart(45)
i++
}
}
printHtmlPart(46)
}
printHtmlPart(47)
if(true && (formRemkInstance?.attachedCopyCheck == '' || formRemkInstance?.attachedCopyCheck == null)) {
printHtmlPart(48)
}
else if(true && (formRemkInstance?.attachedCopyCheck == true)) {
printHtmlPart(38)
}
else if(true && (formRemkInstance?.attachedCopyCheck == false)) {
printHtmlPart(49)
}
printHtmlPart(50)
expressionOut.print(formRemkInstance?.attachedCopy)
printHtmlPart(51)
expressionOut.print(formDetails?.appNumber)
printHtmlPart(52)
invokeTag('formatDate','g',314,['format':("dd/MM/yyyy"),'date':(formDetails?.dateOfApproval)],-1)
printHtmlPart(9)
expressionOut.print(formRemkInstance?.dateOfApprovl)
printHtmlPart(53)
expressionOut.print(formDetails?.isbenefitSharingDetailImplemented)
printHtmlPart(54)
expressionOut.print(formDetails?.benefitMechanism)
printHtmlPart(9)
expressionOut.print(formRemkInstance?.benefitSharingAld)
printHtmlPart(55)
if(true && (formDetails?.thirdParty)) {
printHtmlPart(15)
loop:{
int q = 0
for( thirdParty in (formDetails?.thirdParty) ) {
printHtmlPart(56)
expressionOut.print(q+1)
printHtmlPart(57)
expressionOut.print(thirdParty?.name)
printHtmlPart(58)
expressionOut.print(thirdParty?.addressForComm)
printHtmlPart(59)
expressionOut.print(thirdParty?.state)
printHtmlPart(60)
expressionOut.print(pincode)
printHtmlPart(61)
expressionOut.print(thirdParty?.country)
printHtmlPart(62)
expressionOut.print(thirdParty?.phone)
printHtmlPart(63)
expressionOut.print(thirdParty?.fax)
printHtmlPart(64)
expressionOut.print(thirdParty?.website)
printHtmlPart(65)
expressionOut.print(thirdParty?.email)
printHtmlPart(66)
expressionOut.print(formRemkInstance?.thirdParty)
printHtmlPart(67)
q++
}
}
printHtmlPart(15)
}
printHtmlPart(68)
expressionOut.print(formDetails?.thirdPartyTransferPurpose)
printHtmlPart(9)
expressionOut.print(formRemkInstance?.thirdPartyTransfer)
printHtmlPart(69)
expressionOut.print(formDetails?.benefitsToTheThirdParty)
printHtmlPart(70)
expressionOut.print(formRemkInstance?.detailsOfEconomic)
printHtmlPart(71)
if(true && (formDetails?.isAgreementBwApplicantAndThirdParty== 'true')) {
printHtmlPart(72)
}
else if(true && (formDetails?.isAgreementBwApplicantAndThirdParty== 'false')) {
printHtmlPart(24)
}
printHtmlPart(7)
expressionOut.print(formRemkInstance?.detailsAnyAgreement)
printHtmlPart(73)
if(true && (formDetails?.isAgreementBwApplicantAndThirdParty == 'true')) {
printHtmlPart(72)
}
else if(true && (formDetails?.isAgreementBwApplicantAndThirdParty == 'false')) {
printHtmlPart(24)
}
printHtmlPart(74)
expressionOut.print(formRemkInstance?.agreement)
printHtmlPart(75)
expressionOut.print(formDetails?.benefitsOutOfThirdPartyTransfer)
printHtmlPart(76)
expressionOut.print(formDetails?.mechanismOutOfThirdPartyTransfer)
printHtmlPart(77)
expressionOut.print(formRemkInstance?.proposedMechanism)
printHtmlPart(78)
expressionOut.print(formDetails?.otherRelevantInfo)
printHtmlPart(77)
expressionOut.print(formRemkInstance?.anyOther)
printHtmlPart(79)
expressionOut.print(formRemkInstance?.question)
printHtmlPart(80)
if(true && (formRemkInstance != null || formRemkInstance != '')) {
printHtmlPart(81)
loop:{
int k = 0
for( quesAnswer in (formRemkInstance?.questionAnswers) ) {
printHtmlPart(82)
expressionOut.print(k+21)
printHtmlPart(83)
expressionOut.print(quesAnswer?.question)
printHtmlPart(84)
expressionOut.print(quesAnswer?.answer)
printHtmlPart(85)
k++
}
}
printHtmlPart(81)
}
printHtmlPart(86)
})
invokeTag('captureBody','sitemesh',443,[:],1)
printHtmlPart(87)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1671616466204L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
