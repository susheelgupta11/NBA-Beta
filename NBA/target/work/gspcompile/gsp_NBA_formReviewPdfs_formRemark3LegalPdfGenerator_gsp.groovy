import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_NBA_formReviewPdfs_formRemark3LegalPdfGenerator_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/formReviewPdfs/_formRemark3LegalPdfGenerator.gsp" }
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
invokeTag('captureHead','sitemesh',35,[:],1)
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
printHtmlPart(13)
expressionOut.print(formRemkInstance?.applicantCatgRmk)
printHtmlPart(14)
if(true && (formDetails?.individualProfiles)) {
printHtmlPart(15)
for( individualProfile in (formDetails?.individualProfiles) ) {
printHtmlPart(16)
expressionOut.print(individualProfile?.title)
printHtmlPart(16)
expressionOut.print(individualProfile?.firstName)
printHtmlPart(16)
expressionOut.print(individualProfile?.middleName)
printHtmlPart(16)
expressionOut.print(individualProfile?.lastName)
printHtmlPart(16)
expressionOut.print(individualProfile?.address1)
printHtmlPart(16)
expressionOut.print(individualProfile?.address2)
printHtmlPart(16)
expressionOut.print(individualProfile?.address3)
printHtmlPart(16)
expressionOut.print(individualProfile?.city)
printHtmlPart(15)
}
printHtmlPart(17)
}
else if(true && (formDetails?.companyProfiles)) {
printHtmlPart(15)
loop:{
int k = 0
for( company in (formDetails?.companyProfiles) ) {
printHtmlPart(16)
expressionOut.print(company?.entityName)
printHtmlPart(15)
k++
}
}
printHtmlPart(17)
}
else if(true && (formDetails?.indianResearcher)) {
printHtmlPart(15)
for( researcher in (formDetails?.indianResearcher) ) {
printHtmlPart(18)
expressionOut.print(researcher?.title)
printHtmlPart(16)
expressionOut.print(researcher?.firstName)
printHtmlPart(16)
expressionOut.print(researcher?.middleName)
printHtmlPart(16)
expressionOut.print(researcher?.lastName)
printHtmlPart(16)
expressionOut.print(researcher?.address1)
printHtmlPart(16)
expressionOut.print(researcher?.address2)
printHtmlPart(16)
expressionOut.print(researcher?.address3)
printHtmlPart(16)
expressionOut.print(researcher?.presentCity)
printHtmlPart(15)
}
printHtmlPart(17)
}
else if(true && (formDetails?.depostionOfMicroOrganism)) {
printHtmlPart(15)
for( depost in (formDetails?.depostionOfMicroOrganism) ) {
printHtmlPart(16)
expressionOut.print(depost?.nameOfDepositor)
printHtmlPart(16)
expressionOut.print(depost?.address1)
printHtmlPart(16)
expressionOut.print(depost?.address2)
printHtmlPart(16)
expressionOut.print(depost?.address3)
printHtmlPart(16)
expressionOut.print(depost?.city)
printHtmlPart(15)
}
printHtmlPart(17)
}
else if(true && (formDetails?.indianGovtInst)) {
printHtmlPart(15)
for( govt in (formDetails?.indianGovtInst) ) {
printHtmlPart(16)
expressionOut.print(govt?.govtInstName)
printHtmlPart(16)
expressionOut.print(govt?.address1)
printHtmlPart(16)
expressionOut.print(govt?.address2)
printHtmlPart(16)
expressionOut.print(govt?.address3)
printHtmlPart(16)
expressionOut.print(govt?.presentCity)
printHtmlPart(15)
}
printHtmlPart(17)
}
printHtmlPart(19)
expressionOut.print(formRemkInstance?.applicantNameContRmk)
printHtmlPart(20)
if(true && (formDetails?.companyProfiles)) {
printHtmlPart(17)
for( company in (formDetails?.companyProfiles) ) {
printHtmlPart(17)
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
printHtmlPart(17)
}
printHtmlPart(17)
}
else {
printHtmlPart(24)
}
printHtmlPart(25)
expressionOut.print(formRemkInstance?.authPersonContRmk)
printHtmlPart(26)
if(true && (formDetails?.agentProfile)) {
printHtmlPart(17)
expressionOut.print(formDetails?.agentProfile?.title)
printHtmlPart(21)
expressionOut.print(formDetails?.agentProfile?.firstName)
printHtmlPart(17)
expressionOut.print(formDetails?.agentProfile?.middleName)
printHtmlPart(21)
expressionOut.print(formDetails?.agentProfile?.lastName)
printHtmlPart(27)
expressionOut.print(formDetails?.agentProfile?.address1)
printHtmlPart(21)
expressionOut.print(formDetails?.agentProfile?.address2)
printHtmlPart(17)
expressionOut.print(formDetails?.agentProfile?.address3)
printHtmlPart(28)
expressionOut.print(formDetails?.agentProfile?.city)
printHtmlPart(17)
}
else {
printHtmlPart(24)
}
printHtmlPart(29)
expressionOut.print(formRemkInstance?.attorneyInIndiaContRmk)
printHtmlPart(30)
expressionOut.print(formRemkInstance?.appFormCatgRmk)
printHtmlPart(31)
if(true && (formRemkInstance?.threeTwocheck == '' || formRemkInstance?.threeTwocheck == null)) {
printHtmlPart(32)
}
printHtmlPart(33)
if(true && (formRemkInstance?.threeTwocheck == false)) {
printHtmlPart(34)
}
printHtmlPart(15)
if(true && (formRemkInstance?.threeTwocheck == true)) {
printHtmlPart(35)
}
printHtmlPart(36)
expressionOut.print(formRemkInstance?.threeTwoRemark)
printHtmlPart(37)
if(true && (formRemkInstance?.sevncheck == '' || formRemkInstance?.sevncheck == null)) {
printHtmlPart(38)
}
printHtmlPart(39)
if(true && (formRemkInstance?.sevncheck == false)) {
printHtmlPart(40)
}
printHtmlPart(41)
if(true && (formRemkInstance?.sevncheck == true)) {
printHtmlPart(35)
}
printHtmlPart(42)
expressionOut.print(formRemkInstance?.sevnRemark)
printHtmlPart(43)
if(true && (formRemkInstance?.letterBoardChk == '' || formRemkInstance?.letterBoardChk == null)) {
printHtmlPart(44)
}
printHtmlPart(45)
if(true && (formRemkInstance?.letterBoardChk == "true")) {
printHtmlPart(46)
}
printHtmlPart(45)
if(true && (formRemkInstance?.letterBoardChk == "false")) {
printHtmlPart(47)
}
printHtmlPart(45)
if(true && (formRemkInstance?.letterBoardChk == "notAvailable")) {
printHtmlPart(48)
}
printHtmlPart(42)
expressionOut.print(formRemkInstance?.letterBoardRemark)
printHtmlPart(49)
if(true && (formRemkInstance?.holdingPatternChk == '' || formRemkInstance?.holdingPatternChk == null)) {
printHtmlPart(50)
}
printHtmlPart(45)
if(true && (formRemkInstance?.holdingPatternChk == "true")) {
printHtmlPart(46)
}
printHtmlPart(45)
if(true && (formRemkInstance?.holdingPatternChk == "false")) {
printHtmlPart(47)
}
printHtmlPart(45)
if(true && (formRemkInstance?.holdingPatternChk == "notAvailable")) {
printHtmlPart(48)
}
printHtmlPart(51)
expressionOut.print(formRemkInstance?.holdingPatternRemark)
printHtmlPart(52)
if(true && (formDetails?.iprDetails)) {
printHtmlPart(53)
for( datePatent in (formDetails?.iprDetails) ) {
printHtmlPart(54)
invokeTag('formatDate','g',274,['format':("dd/MM/yyyy"),'date':(datePatent?.patentApplicationDate)],-1)
printHtmlPart(55)
}
printHtmlPart(56)
}
printHtmlPart(42)
expressionOut.print(formRemkInstance?.patentDateRmk)
printHtmlPart(57)
if(true && (formDetails.isApprovalOfNbaObtainedForm3 == 'true')) {
printHtmlPart(58)
expressionOut.print(formDetails?.applicationNo)
printHtmlPart(59)
expressionOut.print(formDetails?.dateOfApproval?.format('dd/MM/yyyy'))
printHtmlPart(60)
createClosureForHtmlPart(61, 3)
invokeTag('link','g',295,['controller':("form3"),'action':("showDc"),'id':(formDetails?.id),'target':("_blank"),'params':([filename: "nbaApprovalFileName", dataName: "nbaApprovalFileName",csrfPreventionSalt:"${csrfPreventionSalt}"])],3)
printHtmlPart(62)
}
else {
printHtmlPart(63)
}
printHtmlPart(64)
expressionOut.print(formRemkInstance?.priorApprovalOfNBARmk)
printHtmlPart(65)
if(true && (formRemkInstance?.patentAlreadyChk == '' || formRemkInstance?.patentAlreadyChk == null)) {
printHtmlPart(66)
}
printHtmlPart(67)
if(true && (formRemkInstance?.patentAlreadyChk  == 'needAditionalInfo')) {
printHtmlPart(68)
}
printHtmlPart(15)
if(true && (formRemkInstance?.patentAlreadyChk  == 'true')) {
printHtmlPart(35)
}
printHtmlPart(69)
if(true && (formRemkInstance?.patentAlreadyChk  == 'false')) {
printHtmlPart(70)
}
printHtmlPart(71)
expressionOut.print(formRemkInstance?.patentAlreadyRemk)
printHtmlPart(72)
if(true && (formRemkInstance?.vettingChk == '' || formRemkInstance?.vettingChk == null)) {
printHtmlPart(73)
}
printHtmlPart(74)
if(true && (formRemkInstance?.vettingChk == 'true')) {
printHtmlPart(75)
}
printHtmlPart(74)
if(true && (formRemkInstance?.vettingChk == 'false')) {
printHtmlPart(76)
}
printHtmlPart(74)
if(true && (formRemkInstance?.vettingChk == 'needAditionalInfo')) {
printHtmlPart(77)
}
printHtmlPart(78)
expressionOut.print(formRemkInstance?.vettingRemark)
printHtmlPart(79)
if(true && (formRemkInstance?.orderChk == '' || formRemkInstance?.orderChk == null)) {
printHtmlPart(73)
}
printHtmlPart(74)
if(true && (formRemkInstance?.orderChk == 'true')) {
printHtmlPart(80)
}
printHtmlPart(74)
if(true && (formRemkInstance?.orderChk == 'false')) {
printHtmlPart(81)
}
printHtmlPart(74)
if(true && (formRemkInstance?.orderChk == 'needAditionalInfo')) {
printHtmlPart(82)
}
printHtmlPart(83)
expressionOut.print(formRemkInstance?.orderRemark)
printHtmlPart(84)
expressionOut.print(formRemkInstance?.splObservation)
printHtmlPart(85)
if(true && (formRemkInstance?.violationChk == '' || formRemkInstance?.violationChk == null)) {
printHtmlPart(73)
}
printHtmlPart(86)
if(true && (formRemkInstance?.violationChk == true)) {
printHtmlPart(80)
}
printHtmlPart(86)
if(true && (formRemkInstance?.violationChk == false)) {
printHtmlPart(81)
}
printHtmlPart(87)
expressionOut.print(formRemkInstance?.violationRemark)
printHtmlPart(88)
expressionOut.print(formRemkInstance?.violationSelect)
printHtmlPart(89)
expressionOut.print(formRemkInstance?.additional)
printHtmlPart(90)
if(true && (formRemkInstance != null || formRemkInstance != '')) {
printHtmlPart(91)
loop:{
int k = 0
for( quesAnswer in (formRemkInstance?.questionAnswers) ) {
printHtmlPart(92)
expressionOut.print(k+20)
printHtmlPart(93)
expressionOut.print(quesAnswer?.question)
printHtmlPart(94)
expressionOut.print(quesAnswer?.answer)
printHtmlPart(95)
k++
}
}
printHtmlPart(91)
}
printHtmlPart(96)
})
invokeTag('captureBody','sitemesh',415,[:],1)
printHtmlPart(97)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1668662533099L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
