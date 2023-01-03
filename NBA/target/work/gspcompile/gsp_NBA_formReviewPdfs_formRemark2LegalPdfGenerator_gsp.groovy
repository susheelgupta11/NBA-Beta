import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_NBA_formReviewPdfs_formRemark2LegalPdfGenerator_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/formReviewPdfs/_formRemark2LegalPdfGenerator.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
createTagBody(2, {->
createClosureForHtmlPart(2, 3)
invokeTag('captureTitle','sitemesh',20,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',22,[:],2)
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
if(true && (formDetails?.companyProfiles)) {
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
else {
printHtmlPart(27)
}
printHtmlPart(28)
expressionOut.print(formRemkInstance?.attorneyInIndiaContRmk)
printHtmlPart(29)
expressionOut.print(formRemkInstance?.appFormCatgRmk)
printHtmlPart(30)
if(true && (formRemkInstance?.threeTwocheck == '' || formRemkInstance?.threeTwocheck == null)) {
printHtmlPart(31)
}
printHtmlPart(32)
if(true && (formRemkInstance?.threeTwocheck == false)) {
printHtmlPart(33)
}
printHtmlPart(15)
if(true && (formRemkInstance?.threeTwocheck == true)) {
printHtmlPart(34)
}
printHtmlPart(35)
expressionOut.print(formRemkInstance?.threeTwoRemark)
printHtmlPart(36)
if(true && (formRemkInstance?.sevncheck == '' || formRemkInstance?.sevncheck == null)) {
printHtmlPart(37)
}
printHtmlPart(38)
if(true && (formRemkInstance?.sevncheck == false)) {
printHtmlPart(39)
}
printHtmlPart(40)
if(true && (formRemkInstance?.sevncheck == true)) {
printHtmlPart(34)
}
printHtmlPart(35)
expressionOut.print(formRemkInstance?.sevnRemark)
printHtmlPart(41)
if(true && (formRemkInstance?.priorApprovalOfNBA == '' || formRemkInstance?.priorApprovalOfNBA == null)) {
printHtmlPart(42)
}
printHtmlPart(43)
if(true && (formRemkInstance?.priorApprovalOfNBA == "true")) {
printHtmlPart(44)
}
printHtmlPart(43)
if(true && (formRemkInstance?.priorApprovalOfNBA == "false")) {
printHtmlPart(45)
}
printHtmlPart(43)
if(true && (formRemkInstance?.priorApprovalOfNBA == "notAvailable")) {
printHtmlPart(46)
}
printHtmlPart(47)
expressionOut.print(formRemkInstance?.priorApprovalOfNBARmk)
printHtmlPart(48)
if(true && (formRemkInstance?.letterBoardChk == '' || formRemkInstance?.letterBoardChk == null)) {
printHtmlPart(49)
}
printHtmlPart(43)
if(true && (formRemkInstance?.letterBoardChk == "true")) {
printHtmlPart(44)
}
printHtmlPart(43)
if(true && (formRemkInstance?.letterBoardChk == "false")) {
printHtmlPart(45)
}
printHtmlPart(43)
if(true && (formRemkInstance?.letterBoardChk == "notAvailable")) {
printHtmlPart(50)
}
printHtmlPart(51)
expressionOut.print(formRemkInstance?.letterBoardRemark)
printHtmlPart(52)
if(true && (formRemkInstance?.holdingPatternChk == '' || formRemkInstance?.holdingPatternChk == null)) {
printHtmlPart(53)
}
printHtmlPart(43)
if(true && (formRemkInstance?.holdingPatternChk == "true")) {
printHtmlPart(54)
}
printHtmlPart(43)
if(true && (formRemkInstance?.holdingPatternChk == "false")) {
printHtmlPart(45)
}
printHtmlPart(43)
if(true && (formRemkInstance?.holdingPatternChk == "notAvailable")) {
printHtmlPart(50)
}
printHtmlPart(55)
expressionOut.print(formRemkInstance?.holdingPatternRemark)
printHtmlPart(56)
expressionOut.print(formDetails?.resultsOfResearch)
printHtmlPart(57)
expressionOut.print(formRemkInstance?.detailsResearchRmk)
printHtmlPart(58)
expressionOut.print(formDetails?.briefDescription)
printHtmlPart(59)
expressionOut.print(formRemkInstance?.briefDetailOfResearchRmk)
printHtmlPart(60)
if(true && (formRemkInstance?.isLegalIssueRmk == '' || formRemkInstance?.isLegalIssueRmk == null)) {
printHtmlPart(61)
}
printHtmlPart(62)
if(true && (formRemkInstance?.isLegalIssueRmk == true)) {
printHtmlPart(63)
}
printHtmlPart(64)
if(true && (formRemkInstance?.isLegalIssueRmk == false)) {
printHtmlPart(65)
}
printHtmlPart(66)
expressionOut.print(formRemkInstance?.isLegalIssueRmk)
printHtmlPart(67)
if(true && (formRemkInstance?.twoMChk == '' || formRemkInstance?.twoMChk == null)) {
printHtmlPart(68)
}
printHtmlPart(69)
if(true && (formRemkInstance?.twoMChk == true)) {
printHtmlPart(70)
}
printHtmlPart(69)
if(true && (formRemkInstance?.twoMChk == false)) {
printHtmlPart(71)
}
printHtmlPart(72)
expressionOut.print(formRemkInstance?.twoMChkRemark)
printHtmlPart(73)
if(true && (formRemkInstance?.orderChk == '' || formRemkInstance?.orderChk == null)) {
printHtmlPart(53)
}
printHtmlPart(74)
if(true && (formRemkInstance?.orderChk == 'true')) {
printHtmlPart(75)
}
printHtmlPart(74)
if(true && (formRemkInstance?.orderChk == 'false')) {
printHtmlPart(76)
}
printHtmlPart(77)
expressionOut.print(formRemkInstance?.orderRemark)
printHtmlPart(78)
expressionOut.print(formRemkInstance?.splObservation)
printHtmlPart(79)
if(true && (formRemkInstance?.violationChk == '' || formRemkInstance?.violationChk == null)) {
printHtmlPart(53)
}
printHtmlPart(69)
if(true && (formRemkInstance?.violationChk == true)) {
printHtmlPart(75)
}
printHtmlPart(64)
if(true && (formRemkInstance?.violationChk == false)) {
printHtmlPart(33)
}
printHtmlPart(35)
expressionOut.print(formRemkInstance?.violationRemark)
printHtmlPart(80)
expressionOut.print(formRemkInstance?.violationSelect)
printHtmlPart(81)
expressionOut.print(formRemkInstance?.question)
printHtmlPart(82)
if(true && (formRemkInstance != null || formRemkInstance != '')) {
printHtmlPart(83)
loop:{
int k = 0
for( quesAnswer in (formRemkInstance?.questionAnswers) ) {
printHtmlPart(84)
expressionOut.print(k+20)
printHtmlPart(85)
expressionOut.print(quesAnswer?.question)
printHtmlPart(86)
expressionOut.print(quesAnswer?.answer)
printHtmlPart(87)
k++
}
}
printHtmlPart(88)
}
printHtmlPart(89)
})
invokeTag('captureBody','sitemesh',430,[:],1)
printHtmlPart(90)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1671616363999L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
