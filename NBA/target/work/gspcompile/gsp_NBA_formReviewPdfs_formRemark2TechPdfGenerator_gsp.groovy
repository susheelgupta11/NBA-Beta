import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_NBA_formReviewPdfs_formRemark2TechPdfGenerator_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/formReviewPdfs/_formRemark2TechPdfGenerator.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
createTagBody(2, {->
createClosureForHtmlPart(2, 3)
invokeTag('captureTitle','sitemesh',23,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',23,[:],2)
printHtmlPart(3)
})
invokeTag('captureHead','sitemesh',32,[:],1)
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
printHtmlPart(14)
expressionOut.print(formRemkInstance?.applicantCatgRmk)
printHtmlPart(15)
if(true && (formDetails?.individualProfiles)) {
printHtmlPart(16)
for( individualProfile in (formDetails?.individualProfiles) ) {
printHtmlPart(17)
expressionOut.print(individualProfile?.title)
printHtmlPart(18)
expressionOut.print(individualProfile?.firstName)
printHtmlPart(18)
expressionOut.print(individualProfile?.middleName)
printHtmlPart(18)
expressionOut.print(individualProfile?.lastName)
printHtmlPart(18)
expressionOut.print(individualProfile?.address1)
printHtmlPart(18)
expressionOut.print(individualProfile?.address2)
printHtmlPart(18)
expressionOut.print(individualProfile?.address3)
printHtmlPart(18)
expressionOut.print(individualProfile?.city)
printHtmlPart(16)
}
printHtmlPart(19)
}
else if(true && (formDetails?.companyProfiles)) {
printHtmlPart(16)
loop:{
int k = 0
for( company in (formDetails?.companyProfiles) ) {
printHtmlPart(18)
expressionOut.print(company?.entityName)
printHtmlPart(16)
k++
}
}
printHtmlPart(19)
}
else if(true && (formDetails?.indianResearcher)) {
printHtmlPart(16)
for( researcher in (formDetails?.indianResearcher) ) {
printHtmlPart(17)
expressionOut.print(researcher?.title)
printHtmlPart(18)
expressionOut.print(researcher?.firstName)
printHtmlPart(18)
expressionOut.print(researcher?.middleName)
printHtmlPart(18)
expressionOut.print(researcher?.lastName)
printHtmlPart(18)
expressionOut.print(researcher?.address1)
printHtmlPart(18)
expressionOut.print(researcher?.address2)
printHtmlPart(18)
expressionOut.print(researcher?.address3)
printHtmlPart(18)
expressionOut.print(researcher?.presentCity)
printHtmlPart(16)
}
printHtmlPart(19)
}
else if(true && (formDetails?.depostionOfMicroOrganism)) {
printHtmlPart(16)
for( depost in (formDetails?.depostionOfMicroOrganism) ) {
printHtmlPart(18)
expressionOut.print(depost?.nameOfDepositor)
printHtmlPart(18)
expressionOut.print(depost?.address1)
printHtmlPart(18)
expressionOut.print(depost?.address2)
printHtmlPart(18)
expressionOut.print(depost?.address3)
printHtmlPart(18)
expressionOut.print(depost?.city)
printHtmlPart(16)
}
printHtmlPart(19)
}
else if(true && (formDetails?.indianGovtInst)) {
printHtmlPart(16)
for( govt in (formDetails?.indianGovtInst) ) {
printHtmlPart(18)
expressionOut.print(govt?.govtInstName)
printHtmlPart(18)
expressionOut.print(govt?.address1)
printHtmlPart(18)
expressionOut.print(govt?.address2)
printHtmlPart(18)
expressionOut.print(govt?.address3)
printHtmlPart(18)
expressionOut.print(govt?.presentCity)
printHtmlPart(16)
}
printHtmlPart(19)
}
printHtmlPart(20)
expressionOut.print(formRemkInstance?.applicantNameContRmk)
printHtmlPart(21)
if(true && (formDetails?.companyProfiles)) {
printHtmlPart(22)
for( authPerson in (formDetails?.companyProfiles) ) {
printHtmlPart(22)
expressionOut.print(authPerson?.title)
printHtmlPart(23)
expressionOut.print(authPerson?.firstName)
printHtmlPart(23)
expressionOut.print(authPerson?.middleName)
printHtmlPart(23)
expressionOut.print(authPerson?.lastName)
printHtmlPart(24)
expressionOut.print(authPerson?.designation)
printHtmlPart(25)
expressionOut.print(authPerson?.personMobile)
printHtmlPart(26)
expressionOut.print(authPerson?.personEmail)
}
printHtmlPart(27)
}
else {
printHtmlPart(28)
}
printHtmlPart(29)
expressionOut.print(formRemkInstance?.authPersonContRmk)
printHtmlPart(30)
if(true && (formDetails?.agentProfile)) {
printHtmlPart(31)
expressionOut.print(formDetails?.agentProfile?.title)
printHtmlPart(27)
expressionOut.print(formDetails?.agentProfile?.firstName)
printHtmlPart(19)
expressionOut.print(formDetails?.agentProfile?.middleName)
printHtmlPart(27)
expressionOut.print(formDetails?.agentProfile?.lastName)
printHtmlPart(32)
expressionOut.print(formDetails?.agentProfile?.address1)
printHtmlPart(27)
expressionOut.print(formDetails?.agentProfile?.address2)
printHtmlPart(19)
expressionOut.print(formDetails?.agentProfile?.address3)
printHtmlPart(33)
expressionOut.print(formDetails?.agentProfile?.city)
printHtmlPart(19)
}
else {
printHtmlPart(28)
}
printHtmlPart(34)
expressionOut.print(formRemkInstance?.attorneyInIndiaContRmk)
printHtmlPart(35)
expressionOut.print(formRemkInstance?.appFormCatgRmk)
printHtmlPart(36)
if(true && (formRemkInstance?.idAndAddress == true)) {
printHtmlPart(37)
}
else if(true && (formRemkInstance?.idAndAddress == false)) {
printHtmlPart(38)
}
else if(true && (formRemkInstance?.idAndAddress == '' || formRemkInstance?.idAndAddress == null)) {
printHtmlPart(39)
}
printHtmlPart(40)
expressionOut.print(formRemkInstance?.idAndAddressRemark)
printHtmlPart(41)
expressionOut.print(formDetails?.briefDescription)
printHtmlPart(42)
expressionOut.print(formRemkInstance?.resConducted)
printHtmlPart(43)
expressionOut.print(formDetails?.resultsOfResearch)
printHtmlPart(42)
expressionOut.print(formRemkInstance?.resOfReserch)
printHtmlPart(44)
if(true && (formDetails?.biologicalResources)) {
printHtmlPart(45)
loop:{
int i = 0
for( resource in (formDetails?.biologicalResources) ) {
printHtmlPart(46)
expressionOut.print(i+1)
printHtmlPart(47)
expressionOut.print(resource?.name?:'NA')
printHtmlPart(47)
expressionOut.print(resource?.commonName?:'NA')
printHtmlPart(47)
expressionOut.print(resource?.scientificName?:'NA')
printHtmlPart(47)
expressionOut.print(resource?.nature?:'NA')
printHtmlPart(47)
expressionOut.print(resource?.biologicalResource?:'NA')
printHtmlPart(48)
expressionOut.print(formRemkInstance?.biologicalResRmk)
printHtmlPart(49)
i++
}
}
printHtmlPart(50)
}
printHtmlPart(51)
if(true && (formRemkInstance?.checklistLocations)) {
printHtmlPart(16)
loop:{
int k = 0
for( location in (formRemkInstance?.checklistLocations) ) {
printHtmlPart(52)
expressionOut.print(k+1)
printHtmlPart(53)
expressionOut.print(location?.locscientificName)
printHtmlPart(53)
expressionOut.print(location?.locsource)
printHtmlPart(53)
expressionOut.print(location?.locvillage)
printHtmlPart(53)
expressionOut.print(location?.loctown)
printHtmlPart(53)
expressionOut.print(location?.locdistrict)
printHtmlPart(53)
expressionOut.print(location?.locstate)
printHtmlPart(53)
expressionOut.print(location?.loctraderName)
printHtmlPart(53)
expressionOut.print(location?.loctraderContactDetails)
printHtmlPart(54)
expressionOut.print(location?.locationRemark)
printHtmlPart(55)
k++
}
}
printHtmlPart(16)
}
else if(true && (formDetails?.biologicalResources?.locations)) {
printHtmlPart(56)
loop:{
int i = 0
for( giolocation in (formDetails?.biologicalResources?.locations) ) {
printHtmlPart(57)
loop:{
int j = 0
for( gioloc in (giolocation) ) {
printHtmlPart(58)
expressionOut.print(i+1)
printHtmlPart(59)
invokeTag('hiddenField','g',336,['name':("locscientificName"),'value':(gioloc?.bioResource?.scientificName?:'NA')],-1)
printHtmlPart(60)
expressionOut.print(gioloc?.bioResource?.scientificName?:'NA')
printHtmlPart(61)
invokeTag('hiddenField','g',340,['name':("locsource"),'value':(gioloc?.source?:'NA')],-1)
printHtmlPart(60)
expressionOut.print(gioloc?.source?:'NA')
printHtmlPart(61)
invokeTag('hiddenField','g',344,['name':("locvillage"),'value':(gioloc?.village?:'NA')],-1)
printHtmlPart(62)
expressionOut.print(gioloc?.village?:'NA')
printHtmlPart(61)
invokeTag('hiddenField','g',348,['name':("loctown"),'value':(gioloc?.town?:'NA')],-1)
printHtmlPart(62)
expressionOut.print(gioloc?.town?:'NA')
printHtmlPart(63)
invokeTag('hiddenField','g',352,['name':("locdistrict"),'value':(gioloc?.district?:'NA')],-1)
printHtmlPart(62)
expressionOut.print(gioloc?.district?:'NA')
printHtmlPart(63)
invokeTag('hiddenField','g',356,['name':("locstate"),'value':(gioloc?.state?:'NA')],-1)
printHtmlPart(62)
expressionOut.print(gioloc?.state?:'NA')
printHtmlPart(64)
invokeTag('hiddenField','g',359,['name':("loctraderName"),'value':(gioloc?.traderName)],-1)
printHtmlPart(62)
expressionOut.print(gioloc?.traderName?:'NA')
printHtmlPart(61)
invokeTag('hiddenField','g',363,['name':("loctraderContactDetails"),'value':(gioloc?.traderContactDetails?:'NA')],-1)
printHtmlPart(62)
expressionOut.print(gioloc?.traderContactDetails?:'NA')
printHtmlPart(65)
invokeTag('textField','g',369,['name':("locRmk"),'class':("remark"),'value':(formRemkInstance?.locationRmk)],-1)
printHtmlPart(66)
j++
}
}
printHtmlPart(67)
i++
}
}
printHtmlPart(68)
}
printHtmlPart(69)
if(true && (formDetails?.individualProfiles)) {
printHtmlPart(19)
expressionOut.print(formDetails?.nature)
printHtmlPart(70)
if(true && (formDetails?.nature != 'No')) {
printHtmlPart(71)
expressionOut.print(formDetails?.traditionalKnowledgeDesc)
printHtmlPart(19)
}
printHtmlPart(19)
}
printHtmlPart(19)
if(true && (formDetails?.companyProfiles)) {
printHtmlPart(19)
expressionOut.print(formDetails?.isNoForTraditional)
printHtmlPart(19)
if(true && (formDetails?.isNoForTraditional != 'No')) {
printHtmlPart(72)
expressionOut.print(formDetails?.traditionalKnowledgeDesc)
printHtmlPart(19)
}
printHtmlPart(73)
}
printHtmlPart(42)
expressionOut.print(formRemkInstance?.oralRemark)
printHtmlPart(74)
if(true && (formDetails?.locations)) {
printHtmlPart(16)
for( location in (formDetails?.locations) ) {
printHtmlPart(75)
expressionOut.print(location?.consentObtained)
printHtmlPart(76)
expressionOut.print(location?.village)
printHtmlPart(18)
expressionOut.print(location?.town)
printHtmlPart(18)
expressionOut.print(location?.district)
printHtmlPart(16)
}
printHtmlPart(19)
}
else {
printHtmlPart(28)
}
printHtmlPart(42)
expressionOut.print(formRemkInstance?.giolocCommunityRmk)
printHtmlPart(77)
if(true && (formDetails?.locations?.consentObtained != 'No')) {
printHtmlPart(16)
for( consent in (formDetails?.locations) ) {
printHtmlPart(16)
expressionOut.print(consent?.consentObtained)
printHtmlPart(78)
expressionOut.print(consent?.communityKnowledge)
printHtmlPart(18)
expressionOut.print(consent?.village)
printHtmlPart(18)
expressionOut.print(consent?.town)
printHtmlPart(18)
expressionOut.print(consent?.district)
printHtmlPart(18)
expressionOut.print(consent?.state)
printHtmlPart(16)
}
printHtmlPart(19)
}
printHtmlPart(79)
if(true && (formDetails?.isNoForTraditional == 'No')) {
printHtmlPart(80)
}
printHtmlPart(9)
expressionOut.print(formRemkInstance?.consObtained)
printHtmlPart(81)
expressionOut.print(formDetails?.detailsOfInstitute)
printHtmlPart(42)
expressionOut.print(formRemkInstance?.instOrganisation)
printHtmlPart(82)
expressionOut.print(formDetails?.detailsOfIndividualOrOrganisation)
printHtmlPart(83)
expressionOut.print(formDetails?.useofResearchResults)
printHtmlPart(42)
expressionOut.print(formRemkInstance?.intendedUseOfResearch)
printHtmlPart(84)
expressionOut.print(formDetails?.benefitsToTheIndividualOrOrganization)
printHtmlPart(42)
expressionOut.print(formRemkInstance?.biotechnological)
printHtmlPart(85)
expressionOut.print(formDetails?.benefitsToTheApplicant)
printHtmlPart(86)
expressionOut.print(formRemkInstance?.seekApproval)
printHtmlPart(87)
if(true && (formRemkInstance?.technicalInformation == '' || formRemkInstance?.technicalInformation == null)) {
printHtmlPart(88)
}
else if(true && (formRemkInstance?.technicalInformation == true)) {
printHtmlPart(89)
}
else if(true && (formRemkInstance?.technicalInformation == false)) {
printHtmlPart(90)
}
printHtmlPart(91)
if(true && (formRemkInstance?.sbbBmc == '' || formRemkInstance?.sbbBmc == null)) {
printHtmlPart(92)
}
else if(true && (formRemkInstance?.sbbBmc == true)) {
printHtmlPart(93)
}
else if(true && (formRemkInstance?.sbbBmc == false)) {
printHtmlPart(94)
}
printHtmlPart(95)
expressionOut.print(formRemkInstance?.sbbBmcRmk)
printHtmlPart(96)
loop:{
int i = 0
for( a in (formRemkInstance?.gioLocation) ) {
printHtmlPart(97)
expressionOut.print(a)
printHtmlPart(98)
i++
}
}
printHtmlPart(99)
expressionOut.print(formRemkInstance?.question)
printHtmlPart(100)
if(true && (formRemkInstance != null || formRemkInstance != '')) {
printHtmlPart(101)
loop:{
int k = 0
for( quesAnswer in (formRemkInstance?.questionAnswers) ) {
printHtmlPart(102)
expressionOut.print(k+22)
printHtmlPart(103)
expressionOut.print(quesAnswer?.question)
printHtmlPart(104)
expressionOut.print(quesAnswer?.answer)
printHtmlPart(105)
k++
}
}
printHtmlPart(1)
}
printHtmlPart(106)
})
invokeTag('captureBody','sitemesh',576,[:],1)
printHtmlPart(107)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1671616379328L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
