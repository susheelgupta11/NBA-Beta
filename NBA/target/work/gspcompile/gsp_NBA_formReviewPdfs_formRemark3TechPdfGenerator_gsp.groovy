import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_NBA_formReviewPdfs_formRemark3TechPdfGenerator_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/formReviewPdfs/_formRemark3TechPdfGenerator.gsp" }
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
if(true && (formDetails?.companyProfiles)) {
printHtmlPart(21)
for( contactPersonDitals in (formDetails?.companyProfiles) ) {
printHtmlPart(21)
expressionOut.print(contactPersonDitals?.title)
printHtmlPart(22)
expressionOut.print(contactPersonDitals?.firstName)
printHtmlPart(22)
expressionOut.print(contactPersonDitals?.middleName)
printHtmlPart(22)
expressionOut.print(contactPersonDitals?.lastName)
printHtmlPart(23)
expressionOut.print(contactPersonDitals?.designation)
printHtmlPart(24)
expressionOut.print(contactPersonDitals?.personMobile)
printHtmlPart(25)
expressionOut.print(contactPersonDitals?.personEmail)
printHtmlPart(26)
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
printHtmlPart(18)
expressionOut.print(formDetails?.agentProfile?.title)
printHtmlPart(31)
expressionOut.print(formDetails?.agentProfile?.firstName)
printHtmlPart(18)
expressionOut.print(formDetails?.agentProfile?.middleName)
printHtmlPart(31)
expressionOut.print(formDetails?.agentProfile?.lastName)
printHtmlPart(32)
expressionOut.print(formDetails?.agentProfile?.address1)
printHtmlPart(31)
expressionOut.print(formDetails?.agentProfile?.address2)
printHtmlPart(18)
expressionOut.print(formDetails?.agentProfile?.address3)
printHtmlPart(33)
expressionOut.print(formDetails?.agentProfile?.city)
printHtmlPart(18)
}
else {
printHtmlPart(28)
}
printHtmlPart(29)
expressionOut.print(formRemkInstance?.attorneyInIndiaContRmk)
printHtmlPart(34)
expressionOut.print(formRemkInstance?.appFormCatgRmk)
printHtmlPart(35)
if(true && (formRemkInstance?.idAndAddress == true)) {
printHtmlPart(36)
}
else if(true && (formRemkInstance?.idAndAddress == false)) {
printHtmlPart(37)
}
else if(true && (formRemkInstance?.idAndAddress == '' || formRemkInstance?.idAndAddress == null)) {
printHtmlPart(38)
}
printHtmlPart(39)
expressionOut.print(formRemkInstance?.idAndAddressRemark)
printHtmlPart(40)
if(true && (formRemkInstance?.checklistBioresorces)) {
printHtmlPart(15)
loop:{
int j = 0
for( bioRemarks in (formRemkInstance?.checklistBioresorces) ) {
printHtmlPart(41)
expressionOut.print(j+1)
printHtmlPart(42)
expressionOut.print(bioRemarks?.chkname)
printHtmlPart(42)
expressionOut.print(bioRemarks?.chkcommonName)
printHtmlPart(42)
expressionOut.print(bioRemarks?.chkscientificName)
printHtmlPart(42)
expressionOut.print(bioRemarks?.chknature)
printHtmlPart(42)
expressionOut.print(bioRemarks?.chkbiologicalResource)
printHtmlPart(43)
expressionOut.print(bioRemarks?.bioRemarks)
printHtmlPart(44)
j++
}
}
printHtmlPart(15)
}
else {
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
invokeTag('textField','g',253,['name':("resremk"),'class':("remark"),'value':(formRemkInstance?.biologicalResRmk)],-1)
printHtmlPart(49)
i++
}
}
printHtmlPart(50)
}
printHtmlPart(51)
if(true && (formRemkInstance?.checklistLocations)) {
printHtmlPart(15)
loop:{
int k = 0
for( location in (formRemkInstance?.checklistLocations) ) {
printHtmlPart(41)
expressionOut.print(k+1)
printHtmlPart(42)
expressionOut.print(location?.locscientificName)
printHtmlPart(42)
expressionOut.print(location?.locsource)
printHtmlPart(42)
expressionOut.print(location?.locvillage)
printHtmlPart(42)
expressionOut.print(location?.loctown)
printHtmlPart(42)
expressionOut.print(location?.locdistrict)
printHtmlPart(42)
expressionOut.print(location?.locstate)
printHtmlPart(42)
expressionOut.print(location?.loctraderName)
printHtmlPart(42)
expressionOut.print(location?.loctraderContactDetails)
printHtmlPart(43)
expressionOut.print(location?.locationRemark)
printHtmlPart(52)
k++
}
}
printHtmlPart(15)
}
else if(true && (formDetails?.biologicalResources?.locations)) {
printHtmlPart(53)
loop:{
int i = 0
for( giolocation in (formDetails?.biologicalResources?.locations) ) {
printHtmlPart(54)
loop:{
int j = 0
for( gioloc in (giolocation) ) {
printHtmlPart(55)
expressionOut.print(i+1)
printHtmlPart(56)
invokeTag('hiddenField','g',308,['name':("locscientificName"),'value':(gioloc?.bioResource?.scientificName?:'NA')],-1)
printHtmlPart(57)
expressionOut.print(gioloc?.bioResource?.scientificName?:'NA')
printHtmlPart(58)
invokeTag('hiddenField','g',312,['name':("locsource"),'value':(gioloc?.source?:'NA')],-1)
printHtmlPart(57)
expressionOut.print(gioloc?.source?:'NA')
printHtmlPart(58)
invokeTag('hiddenField','g',316,['name':("locvillage"),'value':(gioloc?.village?:'NA')],-1)
printHtmlPart(59)
expressionOut.print(gioloc?.village?:'NA')
printHtmlPart(58)
invokeTag('hiddenField','g',320,['name':("loctown"),'value':(gioloc?.town?:'NA')],-1)
printHtmlPart(59)
expressionOut.print(gioloc?.town?:'NA')
printHtmlPart(60)
invokeTag('hiddenField','g',324,['name':("locdistrict"),'value':(gioloc?.district?:'NA')],-1)
printHtmlPart(59)
expressionOut.print(gioloc?.district?:'NA')
printHtmlPart(60)
invokeTag('hiddenField','g',328,['name':("locstate"),'value':(gioloc?.state?:'NA')],-1)
printHtmlPart(59)
expressionOut.print(gioloc?.state?:'NA')
printHtmlPart(61)
invokeTag('hiddenField','g',332,['name':("loctraderName"),'value':(gioloc?.traderName)],-1)
printHtmlPart(59)
expressionOut.print(gioloc?.traderName?:'NA')
printHtmlPart(58)
invokeTag('hiddenField','g',335,['name':("loctraderContactDetails"),'value':(gioloc?.traderContactDetails?:'NA')],-1)
printHtmlPart(59)
expressionOut.print(gioloc?.traderContactDetails?:'NA')
printHtmlPart(62)
invokeTag('textField','g',340,['name':("locRmk"),'class':("remark"),'value':(formRemkInstance?.locationRmk)],-1)
printHtmlPart(63)
j++
}
}
printHtmlPart(45)
i++
}
}
printHtmlPart(64)
}
printHtmlPart(65)
if(true && (rare)) {
printHtmlPart(15)
loop:{
int i = 0
for( ntc in (rare) ) {
printHtmlPart(66)
expressionOut.print(i+1)
printHtmlPart(67)
expressionOut.print(ntc?.bio_resource)
printHtmlPart(67)
expressionOut.print(ntc?.status)
printHtmlPart(67)
expressionOut.print(ntc?.part)
printHtmlPart(67)
invokeTag('textField','g',378,['name':("ntc"),'class':("remark"),'value':(formRemkInstance?.listedInRmk)],-1)
printHtmlPart(68)
i++
}
}
printHtmlPart(15)
}
else {
printHtmlPart(69)
}
printHtmlPart(70)
expressionOut.print(formDetails?.detailsOfInstitute)
printHtmlPart(29)
expressionOut.print(formRemkInstance?.instOrganisation)
printHtmlPart(71)
expressionOut.print(formDetails?.benefitsToTheApplicant)
printHtmlPart(29)
expressionOut.print(formRemkInstance?.commTheInvention)
printHtmlPart(72)
if(true && (formRemkInstance?.technicalInformation == '' || formRemkInstance?.technicalInformation == null)) {
printHtmlPart(73)
}
else if(true && (formRemkInstance?.technicalInformation == true)) {
printHtmlPart(74)
}
else if(true && (formRemkInstance?.technicalInformation == false)) {
printHtmlPart(75)
}
printHtmlPart(76)
expressionOut.print(formRemkInstance?.technicalInformationRmk)
printHtmlPart(77)
if(true && (formRemkInstance?.sbbBmc == '' || formRemkInstance?.sbbBmc == null)) {
printHtmlPart(78)
}
else if(true && (formRemkInstance?.sbbBmc == true)) {
printHtmlPart(79)
}
else if(true && (formRemkInstance?.sbbBmc == false)) {
printHtmlPart(80)
}
printHtmlPart(39)
expressionOut.print(formRemkInstance?.sbbBmcRmk)
printHtmlPart(81)
loop:{
int i = 0
for( a in (formRemkInstance?.gioLocation) ) {
printHtmlPart(82)
expressionOut.print(a)
printHtmlPart(83)
i++
}
}
printHtmlPart(84)
expressionOut.print(formRemkInstance?.question)
printHtmlPart(85)
if(true && (formRemkInstance != null || formRemkInstance != '')) {
printHtmlPart(86)
loop:{
int k = 0
for( quesAnswer in (formRemkInstance?.questionAnswers) ) {
printHtmlPart(87)
expressionOut.print(k+18)
printHtmlPart(88)
expressionOut.print(quesAnswer?.question)
printHtmlPart(89)
expressionOut.print(quesAnswer?.answer)
printHtmlPart(90)
k++
}
}
printHtmlPart(1)
}
printHtmlPart(91)
})
invokeTag('captureBody','sitemesh',468,[:],1)
printHtmlPart(92)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1668662465665L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
