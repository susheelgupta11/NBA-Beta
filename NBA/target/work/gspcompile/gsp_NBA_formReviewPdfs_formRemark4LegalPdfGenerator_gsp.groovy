import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_NBA_formReviewPdfs_formRemark4LegalPdfGenerator_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/formReviewPdfs/_formRemark4LegalPdfGenerator.gsp" }
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
invokeTag('captureHead','sitemesh',26,[:],1)
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
printHtmlPart(7)
expressionOut.print(formRemkInstance?.nbaRefNumberRemark)
printHtmlPart(9)
if(true && (formDetails?.individualProfiles)) {
printHtmlPart(10)
}
else if(true && (formDetails?.companyProfiles)) {
printHtmlPart(11)
}
printHtmlPart(7)
expressionOut.print(formRemkInstance?.applicantCatgRmk)
printHtmlPart(12)
if(true && (formDetails?.individualProfiles)) {
printHtmlPart(13)
for( individualProfile in (formDetails?.individualProfiles) ) {
printHtmlPart(14)
expressionOut.print(individualProfile?.title)
printHtmlPart(15)
expressionOut.print(individualProfile?.firstName)
printHtmlPart(15)
expressionOut.print(individualProfile?.middleName)
printHtmlPart(15)
expressionOut.print(individualProfile?.lastName)
printHtmlPart(15)
expressionOut.print(individualProfile?.address1)
printHtmlPart(15)
expressionOut.print(individualProfile?.address2)
printHtmlPart(15)
expressionOut.print(individualProfile?.address3)
printHtmlPart(15)
expressionOut.print(individualProfile?.city)
printHtmlPart(13)
}
printHtmlPart(16)
}
else if(true && (formDetails?.companyProfiles)) {
printHtmlPart(13)
loop:{
int k = 0
for( company in (formDetails?.companyProfiles) ) {
printHtmlPart(15)
expressionOut.print(company?.entityName)
printHtmlPart(13)
k++
}
}
printHtmlPart(16)
}
else if(true && (formDetails?.indianResearcher)) {
printHtmlPart(13)
for( researcher in (formDetails?.indianResearcher) ) {
printHtmlPart(14)
expressionOut.print(researcher?.title)
printHtmlPart(15)
expressionOut.print(researcher?.firstName)
printHtmlPart(15)
expressionOut.print(researcher?.middleName)
printHtmlPart(15)
expressionOut.print(researcher?.lastName)
printHtmlPart(15)
expressionOut.print(researcher?.address1)
printHtmlPart(15)
expressionOut.print(researcher?.address2)
printHtmlPart(15)
expressionOut.print(researcher?.address3)
printHtmlPart(15)
expressionOut.print(researcher?.presentCity)
printHtmlPart(13)
}
printHtmlPart(16)
}
else if(true && (formDetails?.depostionOfMicroOrganism)) {
printHtmlPart(13)
for( depost in (formDetails?.depostionOfMicroOrganism) ) {
printHtmlPart(15)
expressionOut.print(depost?.nameOfDepositor)
printHtmlPart(15)
expressionOut.print(depost?.address1)
printHtmlPart(15)
expressionOut.print(depost?.address2)
printHtmlPart(15)
expressionOut.print(depost?.address3)
printHtmlPart(15)
expressionOut.print(depost?.city)
printHtmlPart(13)
}
printHtmlPart(16)
}
else if(true && (formDetails?.indianGovtInst)) {
printHtmlPart(13)
for( govt in (formDetails?.indianGovtInst) ) {
printHtmlPart(15)
expressionOut.print(govt?.govtInstName)
printHtmlPart(15)
expressionOut.print(govt?.address1)
printHtmlPart(15)
expressionOut.print(govt?.address2)
printHtmlPart(15)
expressionOut.print(govt?.address3)
printHtmlPart(15)
expressionOut.print(govt?.presentCity)
printHtmlPart(13)
}
printHtmlPart(16)
}
printHtmlPart(7)
expressionOut.print(formRemkInstance?.applicantNameContRmk)
printHtmlPart(17)
if(true && (formDetails?.companyProfiles)) {
printHtmlPart(16)
for( company in (formDetails?.companyProfiles) ) {
printHtmlPart(16)
expressionOut.print(company?.title)
printHtmlPart(18)
expressionOut.print(company?.firstName)
printHtmlPart(18)
expressionOut.print(company?.middleName)
printHtmlPart(18)
expressionOut.print(company?.lastName)
printHtmlPart(19)
expressionOut.print(company?.personMobile)
printHtmlPart(20)
expressionOut.print(company?.personEmail)
printHtmlPart(16)
}
printHtmlPart(16)
}
else {
printHtmlPart(21)
}
printHtmlPart(7)
expressionOut.print(formRemkInstance?.authPersonContRmk)
printHtmlPart(22)
if(true && (formDetails?.agentProfile)) {
printHtmlPart(16)
expressionOut.print(formDetails?.agentProfile?.title)
printHtmlPart(18)
expressionOut.print(formDetails?.agentProfile?.firstName)
printHtmlPart(16)
expressionOut.print(formDetails?.agentProfile?.middleName)
printHtmlPart(18)
expressionOut.print(formDetails?.agentProfile?.lastName)
printHtmlPart(23)
expressionOut.print(formDetails?.agentProfile?.address1)
printHtmlPart(18)
expressionOut.print(formDetails?.agentProfile?.address2)
printHtmlPart(16)
expressionOut.print(formDetails?.agentProfile?.address3)
printHtmlPart(24)
expressionOut.print(formDetails?.agentProfile?.city)
printHtmlPart(16)
}
else {
printHtmlPart(25)
}
printHtmlPart(26)
expressionOut.print(formRemkInstance?.attorneyInIndiaContRmk)
printHtmlPart(27)
expressionOut.print(formRemkInstance?.appFormCatgRmk)
printHtmlPart(28)
if(true && (formRemkInstance?.threeTwocheck == '' || formRemkInstance?.threeTwocheck == null)) {
printHtmlPart(29)
}
printHtmlPart(30)
if(true && (formRemkInstance?.threeTwocheck == false)) {
printHtmlPart(31)
}
printHtmlPart(13)
if(true && (formRemkInstance?.threeTwocheck == true)) {
printHtmlPart(32)
}
printHtmlPart(33)
expressionOut.print(formRemkInstance?.threeTwoRemark)
printHtmlPart(34)
if(true && (formRemkInstance?.sevncheck == '' || formRemkInstance?.sevncheck == null)) {
printHtmlPart(35)
}
printHtmlPart(36)
if(true && (formRemkInstance?.sevncheck == false)) {
printHtmlPart(37)
}
printHtmlPart(38)
if(true && (formRemkInstance?.sevncheck == true)) {
printHtmlPart(32)
}
printHtmlPart(39)
expressionOut.print(formRemkInstance?.sevnRemark)
printHtmlPart(40)
if(true && (formRemkInstance?.letterBoardChk == '' || formRemkInstance?.letterBoardChk == null)) {
printHtmlPart(41)
}
printHtmlPart(42)
if(true && (formRemkInstance?.letterBoardChk == "true")) {
printHtmlPart(43)
}
printHtmlPart(42)
if(true && (formRemkInstance?.letterBoardChk == "false")) {
printHtmlPart(44)
}
printHtmlPart(42)
if(true && (formRemkInstance?.letterBoardChk == "notAvailable")) {
printHtmlPart(45)
}
printHtmlPart(46)
expressionOut.print(formRemkInstance?.letterBoardRemark)
printHtmlPart(47)
if(true && (formRemkInstance?.holdingPatternChk == '' || formRemkInstance?.holdingPatternChk == null)) {
printHtmlPart(41)
}
printHtmlPart(42)
if(true && (formRemkInstance?.holdingPatternChk == "true")) {
printHtmlPart(43)
}
printHtmlPart(42)
if(true && (formRemkInstance?.holdingPatternChk == "false")) {
printHtmlPart(37)
}
printHtmlPart(42)
if(true && (formRemkInstance?.holdingPatternChk == "notAvailable")) {
printHtmlPart(45)
}
printHtmlPart(46)
expressionOut.print(formRemkInstance?.holdingPatternRemark)
printHtmlPart(48)
if(true && (formRemkInstance?.priorApprovalOfNBA == '' || formRemkInstance?.priorApprovalOfNBA == null)) {
printHtmlPart(49)
}
printHtmlPart(42)
if(true && (formRemkInstance?.priorApprovalOfNBA == "true")) {
printHtmlPart(50)
}
printHtmlPart(42)
if(true && (formRemkInstance?.priorApprovalOfNBA == "false")) {
printHtmlPart(44)
}
printHtmlPart(42)
if(true && (formRemkInstance?.priorApprovalOfNBA == "notAvailable")) {
printHtmlPart(45)
}
printHtmlPart(33)
expressionOut.print(formRemkInstance?.priorApprovalOfNBARmk)
printHtmlPart(51)
expressionOut.print(formRemkInstance?.purposeForTransBioResRmk)
printHtmlPart(52)
expressionOut.print(formDetails?.thirdPartyTransferPurpose)
printHtmlPart(7)
expressionOut.print(formRemkInstance?.dateOfTransBioResRmk)
printHtmlPart(53)
if(true && (formRemkInstance?.twoDChk == '' || formRemkInstance?.twoDChk == null)) {
printHtmlPart(35)
}
printHtmlPart(54)
if(true && (formRemkInstance?.twoDChk == true)) {
printHtmlPart(55)
}
printHtmlPart(54)
if(true && (formRemkInstance?.twoDChk == false)) {
printHtmlPart(56)
}
printHtmlPart(57)
expressionOut.print(formRemkInstance?.twoDRemark)
printHtmlPart(58)
if(true && (formRemkInstance?.vettingChk == '' || formRemkInstance?.vettingChk == null)) {
printHtmlPart(59)
}
printHtmlPart(60)
if(true && (formRemkInstance?.vettingChk == "true")) {
printHtmlPart(61)
}
printHtmlPart(60)
if(true && (formRemkInstance?.vettingChk == "false")) {
printHtmlPart(62)
}
printHtmlPart(63)
expressionOut.print(formRemkInstance?.vettingRemark)
printHtmlPart(64)
if(true && (formRemkInstance?.orderChk == '' || formRemkInstance?.orderChk == null)) {
printHtmlPart(41)
}
printHtmlPart(60)
if(true && (formRemkInstance?.orderChk == "true")) {
printHtmlPart(43)
}
printHtmlPart(60)
if(true && (formRemkInstance?.orderChk == "false")) {
printHtmlPart(65)
}
printHtmlPart(66)
expressionOut.print(formRemkInstance?.orderRemark)
printHtmlPart(67)
expressionOut.print(formRemkInstance?.splObservation)
printHtmlPart(68)
if(true && (formDetails?.thirdParty)) {
printHtmlPart(69)
loop:{
int i = 0
for( thirdParty in (formDetails?.thirdParty) ) {
printHtmlPart(70)
expressionOut.print(i+1)
printHtmlPart(71)
expressionOut.print(thirdParty?.name?.toString()?.replaceAll("\\<.*?>",""))
printHtmlPart(71)
expressionOut.print(thirdParty?.addressForComm?.toString()?.replaceAll("\\<.*?>",""))
expressionOut.print(thirdParty?.state?.toString()?.replaceAll("\\<.*?>",""))
printHtmlPart(72)
expressionOut.print(thirdParty?.pincode)
printHtmlPart(73)
expressionOut.print(thirdParty?.country)
printHtmlPart(74)
expressionOut.print(thirdParty?.phone)
printHtmlPart(75)
expressionOut.print(thirdParty?.email)
printHtmlPart(76)
expressionOut.print(thirdParty?.website)
printHtmlPart(77)
i++
}
}
printHtmlPart(78)
}
printHtmlPart(79)
if(true && (formRemkInstance?.violationChk == '' || formRemkInstance?.violationChk == null)) {
printHtmlPart(41)
}
printHtmlPart(54)
if(true && (formRemkInstance?.violationChk == true)) {
printHtmlPart(80)
}
printHtmlPart(54)
if(true && (formRemkInstance?.violationChk == false)) {
printHtmlPart(37)
}
printHtmlPart(81)
expressionOut.print(formRemkInstance?.violationRemark)
printHtmlPart(82)
expressionOut.print(formRemkInstance?.violationSelect)
printHtmlPart(83)
expressionOut.print(formRemkInstance?.additional)
printHtmlPart(84)
if(true && (formRemkInstance != null || formRemkInstance != '')) {
printHtmlPart(85)
loop:{
int k = 0
for( quesAnswer in (formRemkInstance?.questionAnswers) ) {
printHtmlPart(86)
expressionOut.print(k+22)
printHtmlPart(87)
expressionOut.print(quesAnswer?.question)
printHtmlPart(88)
expressionOut.print(quesAnswer?.answer)
printHtmlPart(89)
k++
}
}
printHtmlPart(85)
}
printHtmlPart(90)
})
invokeTag('captureBody','sitemesh',443,[:],1)
printHtmlPart(91)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1671616434718L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
