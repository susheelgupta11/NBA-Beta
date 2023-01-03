import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_NBA_formReviewPdfs_formRemark1LegalPdfGenerator_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/formReviewPdfs/_formRemark1LegalPdfGenerator.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',23,['gsp_sm_xmlClosingForEmptyTag':("/"),'http-equiv':("Content-Type"),'content':("text/html; charset=ISO-8859-1")],-1)
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',24,['gsp_sm_xmlClosingForEmptyTag':("/"),'name':("layout"),'content':("main")],-1)
printHtmlPart(1)
createTagBody(2, {->
createClosureForHtmlPart(2, 3)
invokeTag('captureTitle','sitemesh',25,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',25,[:],2)
printHtmlPart(3)
})
invokeTag('captureHead','sitemesh',34,[:],1)
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
printHtmlPart(12)
expressionOut.print(formRemkInstance?.applicantCatgRmk)
printHtmlPart(13)
if(true && (formDetails?.individualProfiles)) {
printHtmlPart(14)
for( individualProfile in (formDetails?.individualProfiles) ) {
printHtmlPart(15)
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
printHtmlPart(14)
}
printHtmlPart(17)
}
else if(true && (formDetails?.companyProfiles)) {
printHtmlPart(14)
loop:{
int k = 0
for( company in (formDetails?.companyProfiles) ) {
printHtmlPart(16)
expressionOut.print(company?.entityName)
printHtmlPart(14)
k++
}
}
printHtmlPart(17)
}
else if(true && (formDetails?.indianResearcher)) {
printHtmlPart(14)
for( researcher in (formDetails?.indianResearcher) ) {
printHtmlPart(15)
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
printHtmlPart(14)
}
printHtmlPart(17)
}
else if(true && (formDetails?.depostionOfMicroOrganism)) {
printHtmlPart(14)
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
printHtmlPart(14)
}
printHtmlPart(17)
}
else if(true && (formDetails?.indianGovtInst)) {
printHtmlPart(14)
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
printHtmlPart(14)
}
printHtmlPart(17)
}
printHtmlPart(7)
expressionOut.print(formRemkInstance?.applicantNameContRmk)
printHtmlPart(18)
if(true && (formDetails?.companyProfiles)) {
printHtmlPart(17)
for( company in (formDetails?.companyProfiles) ) {
printHtmlPart(17)
expressionOut.print(company?.title)
printHtmlPart(19)
expressionOut.print(company?.firstName)
printHtmlPart(19)
expressionOut.print(company?.middleName)
printHtmlPart(19)
expressionOut.print(company?.lastName)
printHtmlPart(20)
expressionOut.print(company?.designation)
printHtmlPart(21)
expressionOut.print(company?.personMobile)
printHtmlPart(22)
expressionOut.print(company?.personEmail)
printHtmlPart(17)
}
printHtmlPart(17)
}
else {
printHtmlPart(23)
}
printHtmlPart(24)
expressionOut.print(formRemkInstance?.authPersonContRmk)
printHtmlPart(25)
if(true && (formDetails?.agentProfile)) {
printHtmlPart(17)
expressionOut.print(formDetails?.agentProfile?.title)
printHtmlPart(19)
expressionOut.print(formDetails?.agentProfile?.firstName)
printHtmlPart(17)
expressionOut.print(formDetails?.agentProfile?.middleName)
printHtmlPart(19)
expressionOut.print(formDetails?.agentProfile?.lastName)
printHtmlPart(17)
expressionOut.print(formDetails?.agentProfile?.address1)
printHtmlPart(19)
expressionOut.print(formDetails?.agentProfile?.address2)
printHtmlPart(17)
expressionOut.print(formDetails?.agentProfile?.address3)
printHtmlPart(19)
expressionOut.print(formDetails?.agentProfile?.city)
printHtmlPart(17)
}
else {
printHtmlPart(23)
}
printHtmlPart(7)
expressionOut.print(formRemkInstance?.attorneyInIndiaContRmk)
printHtmlPart(26)
expressionOut.print(formRemkInstance?.appFormCatgRmk)
printHtmlPart(27)
if(true && (formRemkInstance?.threeTwocheck == true)) {
printHtmlPart(28)
}
printHtmlPart(29)
if(true && (formRemkInstance?.threeTwocheck == false)) {
printHtmlPart(30)
}
printHtmlPart(12)
expressionOut.print(formRemkInstance?.threeTwoRemark)
printHtmlPart(31)
if(true && (formRemkInstance?.sevncheck == true)) {
printHtmlPart(32)
}
printHtmlPart(33)
if(true && (formRemkInstance?.sevncheck == false)) {
printHtmlPart(30)
}
printHtmlPart(12)
expressionOut.print(formRemkInstance?.sevnRemark)
printHtmlPart(34)
if(true && (formRemkInstance?.letterBoardChk == "true")) {
printHtmlPart(35)
}
printHtmlPart(36)
if(true && (formRemkInstance?.letterBoardChk == "false")) {
printHtmlPart(37)
}
else if(true && (formRemkInstance?.letterBoardChk == 'notAvailable')) {
printHtmlPart(38)
}
printHtmlPart(12)
expressionOut.print(formRemkInstance?.letterBoardRemark)
printHtmlPart(39)
if(true && (formRemkInstance?.holdingPatternChk == "true")) {
printHtmlPart(32)
}
printHtmlPart(33)
if(true && (formRemkInstance?.holdingPatternChk == "false")) {
printHtmlPart(37)
}
else if(true && (formRemkInstance?.holdingPatternChk =="notAvailable")) {
printHtmlPart(40)
}
printHtmlPart(41)
expressionOut.print(formRemkInstance?.holdingPatternRemark)
printHtmlPart(42)
if(true && (formDetails?.biologicalResources)) {
printHtmlPart(43)
loop:{
int i = 0
for( resource in (formDetails?.biologicalResources) ) {
printHtmlPart(44)
expressionOut.print(i+1)
printHtmlPart(45)
expressionOut.print(resource?.accessIntention)
printHtmlPart(45)
expressionOut.print(resource?.commonName)
printHtmlPart(45)
expressionOut.print(resource?.scientificName)
printHtmlPart(45)
expressionOut.print(resource?.nature)
printHtmlPart(45)
expressionOut.print(resource?.biologicalResource)
printHtmlPart(45)
expressionOut.print(resource?.quantity)
printHtmlPart(46)
expressionOut.print(resource?.qtyUnit)
printHtmlPart(47)
invokeTag('formatDate','g',268,['format':("dd/MM/yyyy"),'date':(resource?.fromTime)],-1)
printHtmlPart(48)
invokeTag('formatDate','g',271,['format':("dd/MM/yyyy"),'date':(resource?.toTime)],-1)
printHtmlPart(49)
expressionOut.print(formRemkInstance?.biologicalResRmk)
printHtmlPart(50)
i++
}
}
printHtmlPart(51)
}
printHtmlPart(52)
if(true && (formDetails?.selfAuthorizedPerson)) {
printHtmlPart(53)
}
printHtmlPart(54)
if(true && (!formDetails?.selfAuthorizedPerson)) {
printHtmlPart(55)
loop:{
int m = 0
for( profile in (allDataforMatching?.listOfContactPerson) ) {
printHtmlPart(56)
expressionOut.print(m+1)
printHtmlPart(57)
expressionOut.print(profile?.nameOfContactPerson?:'NA')
printHtmlPart(58)
expressionOut.print(profile?.addressOfContactPerson?:'NA')
printHtmlPart(59)
expressionOut.print(profile?.mobileOfContactPerson?:'NA')
printHtmlPart(59)
expressionOut.print(profile?.emailOfContactPerson?:'NA')
printHtmlPart(60)
invokeTag('textField','g',314,['class':("remark"),'name':("makingSelection"),'value':(formRemkInstance?.makingSelection)],-1)
printHtmlPart(61)
m++
}
}
printHtmlPart(14)
}
printHtmlPart(62)
expressionOut.print(formDetails?.purposeOfProposal)
printHtmlPart(7)
expressionOut.print(formRemkInstance?.intendedPurpose)
printHtmlPart(63)
if(true && (formRemkInstance?.twoMChk == true)) {
printHtmlPart(32)
}
printHtmlPart(33)
if(true && (formRemkInstance?.twoMChk == false)) {
printHtmlPart(64)
}
printHtmlPart(7)
expressionOut.print(formRemkInstance?.twoMRemark)
printHtmlPart(65)
if(true && (formRemkInstance?.twoFChk == true)) {
printHtmlPart(66)
}
printHtmlPart(29)
if(true && (formRemkInstance?.twoFChk == false)) {
printHtmlPart(67)
}
printHtmlPart(12)
expressionOut.print(formRemkInstance?.twoFRemark)
printHtmlPart(68)
if(true && (formRemkInstance?.twoDChk == true)) {
printHtmlPart(69)
}
printHtmlPart(70)
if(true && (formRemkInstance?.twoDChk == false)) {
printHtmlPart(67)
}
printHtmlPart(12)
expressionOut.print(formRemkInstance?.twoDRemark)
printHtmlPart(71)
if(true && (formRemkInstance?.vettingChk == "true")) {
printHtmlPart(32)
}
printHtmlPart(33)
if(true && (formRemkInstance?.vettingChk == "false")) {
printHtmlPart(72)
}
printHtmlPart(12)
expressionOut.print(formRemkInstance?.vettingRemark)
printHtmlPart(73)
if(true && (formRemkInstance?.orderChk == "true")) {
printHtmlPart(32)
}
printHtmlPart(33)
if(true && (formRemkInstance?.orderChk == "false")) {
printHtmlPart(72)
}
printHtmlPart(12)
expressionOut.print(formRemkInstance?.orderRemark)
printHtmlPart(74)
expressionOut.print(formDetails?.briefDescription)
printHtmlPart(7)
expressionOut.print(formRemkInstance?.nbaApprovalRmk)
printHtmlPart(75)
if(true && (formRemkInstance?.violationChk == true)) {
printHtmlPart(32)
}
printHtmlPart(33)
if(true && (formRemkInstance?.violationChk == false)) {
printHtmlPart(30)
}
printHtmlPart(12)
expressionOut.print(formRemkInstance?.violationRemark)
printHtmlPart(76)
if(true && (formRemkInstance?.violationChk == true)) {
printHtmlPart(77)
expressionOut.print(formRemkInstance?.violationSelect)
printHtmlPart(78)
expressionOut.print(formRemkInstance?.violationRemark)
printHtmlPart(79)
}
printHtmlPart(80)
expressionOut.print(formRemkInstance?.additional)
printHtmlPart(81)
expressionOut.print(formRemkInstance?.additionalReview)
printHtmlPart(82)
expressionOut.print(formRemkInstance?.question)
printHtmlPart(83)
if(true && (formRemkInstance != null || formRemkInstance != '')) {
printHtmlPart(84)
loop:{
int k = 0
for( quesAnswer in (formRemkInstance?.questionAnswers) ) {
printHtmlPart(85)
expressionOut.print(k+21)
printHtmlPart(86)
expressionOut.print(quesAnswer?.question)
printHtmlPart(87)
expressionOut.print(quesAnswer?.answer)
printHtmlPart(88)
k++
}
}
printHtmlPart(89)
}
printHtmlPart(90)
})
invokeTag('captureBody','sitemesh',453,[:],1)
printHtmlPart(91)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1671616235208L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
