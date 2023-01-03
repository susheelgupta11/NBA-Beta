import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_NBA_formReviewPdfs_formRemark1TechPdfGenerator_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/formReviewPdfs/_formRemark1TechPdfGenerator.gsp" }
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
printHtmlPart(7)
expressionOut.print(formRemkInstance?.nbaRefNumberRemark)
printHtmlPart(9)
if(true && (formDetails?.individualProfiles)) {
printHtmlPart(10)
}
else if(true && (formDetails?.companyProfiles)) {
printHtmlPart(11)
}
else if(true && (formDetails?.indianGovtInst)) {
printHtmlPart(12)
}
else if(true && (formDetails?.depostionOfMicroOrganism)) {
printHtmlPart(13)
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
printHtmlPart(19)
expressionOut.print(individualProfile?.address1)
printHtmlPart(18)
expressionOut.print(individualProfile?.address2)
printHtmlPart(18)
expressionOut.print(individualProfile?.address3)
printHtmlPart(18)
expressionOut.print(individualProfile?.city)
printHtmlPart(16)
}
printHtmlPart(20)
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
printHtmlPart(20)
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
printHtmlPart(19)
expressionOut.print(researcher?.address1)
printHtmlPart(18)
expressionOut.print(researcher?.address2)
printHtmlPart(18)
expressionOut.print(researcher?.address3)
printHtmlPart(18)
expressionOut.print(researcher?.presentCity)
printHtmlPart(16)
}
printHtmlPart(20)
}
else if(true && (formDetails?.depostionOfMicroOrganism)) {
printHtmlPart(16)
for( depost in (formDetails?.depostionOfMicroOrganism) ) {
printHtmlPart(18)
expressionOut.print(depost?.nameOfDepositor)
printHtmlPart(19)
expressionOut.print(depost?.address1)
printHtmlPart(18)
expressionOut.print(depost?.address2)
printHtmlPart(18)
expressionOut.print(depost?.address3)
printHtmlPart(18)
expressionOut.print(depost?.city)
printHtmlPart(16)
}
printHtmlPart(20)
}
else if(true && (formDetails?.indianGovtInst)) {
printHtmlPart(16)
for( govt in (formDetails?.indianGovtInst) ) {
printHtmlPart(18)
expressionOut.print(govt?.govtInstName)
printHtmlPart(19)
expressionOut.print(govt?.address1)
printHtmlPart(18)
expressionOut.print(govt?.address2)
printHtmlPart(18)
expressionOut.print(govt?.address3)
printHtmlPart(18)
expressionOut.print(govt?.presentCity)
printHtmlPart(16)
}
printHtmlPart(20)
}
printHtmlPart(14)
expressionOut.print(formRemkInstance?.applicantNameContRmk)
printHtmlPart(21)
if(true && (formDetails?.companyProfiles)) {
printHtmlPart(22)
for( comp in (formDetails?.companyProfiles) ) {
printHtmlPart(23)
expressionOut.print(comp?.title)
printHtmlPart(24)
expressionOut.print(comp?.firstName)
printHtmlPart(24)
expressionOut.print(comp?.middleName)
printHtmlPart(24)
expressionOut.print(comp?.lastName)
printHtmlPart(25)
expressionOut.print(comp?.designation)
printHtmlPart(26)
expressionOut.print(comp?.personMobile)
printHtmlPart(27)
expressionOut.print(comp?.personEmail)
printHtmlPart(28)
}
}
else {
printHtmlPart(29)
}
printHtmlPart(7)
expressionOut.print(formRemkInstance?.authPersonContRmk)
printHtmlPart(30)
expressionOut.print(formDetails?.agentProfile?.title)
printHtmlPart(31)
expressionOut.print(formDetails?.agentProfile?.firstName)
printHtmlPart(20)
expressionOut.print(formDetails?.agentProfile?.middleName)
printHtmlPart(31)
expressionOut.print(formDetails?.agentProfile?.lastName)
printHtmlPart(32)
expressionOut.print(formDetails?.agentProfile?.address1)
printHtmlPart(31)
expressionOut.print(formDetails?.agentProfile?.address2)
printHtmlPart(20)
expressionOut.print(formDetails?.agentProfile?.address3)
printHtmlPart(31)
expressionOut.print(formDetails?.agentProfile?.city)
printHtmlPart(14)
expressionOut.print(formRemkInstance?.attorneyInIndiaContRmk)
printHtmlPart(33)
expressionOut.print(formRemkInstance?.appFormCatgRmk)
printHtmlPart(34)
if(true && (formRemkInstance?.idAndAddress == true)) {
printHtmlPart(35)
}
else if(true && (formRemkInstance?.idAndAddress == false)) {
printHtmlPart(36)
}
else if(true && (formRemkInstance?.idAndAddress == '' || formRemkInstance?.idAndAddress == null)) {
printHtmlPart(37)
}
printHtmlPart(38)
expressionOut.print(formRemkInstance?.idAndAddressRemark)
printHtmlPart(39)
if(true && (formRemkInstance?.checklistBioresorces)) {
printHtmlPart(24)
loop:{
int j = 0
for( bioRemarks in (formRemkInstance?.checklistBioresorces) ) {
printHtmlPart(40)
expressionOut.print(j+1)
printHtmlPart(41)
expressionOut.print(bioRemarks?.chkname)
printHtmlPart(41)
expressionOut.print(bioRemarks?.chkcommonName)
printHtmlPart(41)
expressionOut.print(bioRemarks?.chkscientificName)
printHtmlPart(41)
expressionOut.print(bioRemarks?.chknature)
printHtmlPart(41)
expressionOut.print(bioRemarks?.chkbiologicalResource)
printHtmlPart(41)
expressionOut.print(bioRemarks?.chkQuantity)
printHtmlPart(41)
expressionOut.print(bioRemarks?.chkFromtime)
printHtmlPart(42)
expressionOut.print(bioRemarks?.chkTotime)
printHtmlPart(43)
expressionOut.print(bioRemarks?.bioRemarks)
printHtmlPart(44)
j++
}
}
printHtmlPart(24)
}
else if(true && (formDetails?.biologicalResources)) {
printHtmlPart(45)
loop:{
int i = 0
for( resource in (formDetails?.biologicalResources) ) {
printHtmlPart(46)
expressionOut.print(i+1)
printHtmlPart(47)
invokeTag('hiddenField','g',282,['name':("chkname"),'value':(resource?.name?:'NA')],-1)
printHtmlPart(18)
expressionOut.print(resource?.name?:'NA')
printHtmlPart(48)
invokeTag('hiddenField','g',286,['name':("chkcommonName"),'value':(resource?.commonName?:'NA')],-1)
printHtmlPart(49)
expressionOut.print(resource?.commonName?:'NA')
printHtmlPart(50)
invokeTag('hiddenField','g',290,['name':("chkscientificName"),'value':(resource?.scientificName?:'NA')],-1)
printHtmlPart(49)
expressionOut.print(resource?.scientificName?:'NA')
printHtmlPart(50)
invokeTag('hiddenField','g',294,['name':("chknature"),'value':(resource?.nature?:'NA')],-1)
printHtmlPart(49)
expressionOut.print(resource?.nature?:'NA')
printHtmlPart(50)
invokeTag('hiddenField','g',298,['name':("chkbiologicalResource"),'value':(resource?.biologicalResource?:'NA')],-1)
printHtmlPart(18)
expressionOut.print(resource?.biologicalResource?:'NA')
printHtmlPart(48)
invokeTag('hiddenField','g',302,['name':("chkQuantity"),'value':(resource?.quantity+ '-'+resource?.qtyUnit)],-1)
printHtmlPart(49)
expressionOut.print(resource?.quantity +'-'+resource?.qtyUnit)
printHtmlPart(51)
invokeTag('formatDate','g',306,['format':("dd/MM/yyyy"),'date':(resource?.fromTime)],-1)
printHtmlPart(49)
invokeTag('hiddenField','g',307,['name':("chkFromtime"),'value':(resource?.fromTime)],-1)
printHtmlPart(52)
invokeTag('formatDate','g',309,['format':("dd/MM/yyyy"),'date':(resource?.toTime)],-1)
printHtmlPart(49)
invokeTag('hiddenField','g',310,['name':("chkTotime"),'value':(resource?.toTime)],-1)
printHtmlPart(53)
expressionOut.print(formRemkInstance?.biologicalResRmk)
printHtmlPart(54)
i++
}
}
printHtmlPart(55)
}
printHtmlPart(56)
if(true && (formRemkInstance?.checklistLocations)) {
printHtmlPart(24)
loop:{
int k = 0
for( location in (formRemkInstance?.checklistLocations) ) {
printHtmlPart(40)
expressionOut.print(k+1)
printHtmlPart(41)
expressionOut.print(location?.locscientificName)
printHtmlPart(41)
expressionOut.print(location?.locsource)
printHtmlPart(41)
expressionOut.print(location?.locvillage)
printHtmlPart(41)
expressionOut.print(location?.loctown)
printHtmlPart(41)
expressionOut.print(location?.locdistrict)
printHtmlPart(41)
expressionOut.print(location?.locstate)
printHtmlPart(41)
expressionOut.print(location?.loctraderName)
printHtmlPart(41)
expressionOut.print(location?.loctraderContactDetails)
printHtmlPart(43)
expressionOut.print(location?.locationRemark)
printHtmlPart(57)
k++
}
}
printHtmlPart(24)
}
else if(true && (formDetails?.biologicalResources?.locations)) {
printHtmlPart(45)
loop:{
int i = 0
for( giolocation in (formDetails?.biologicalResources?.locations) ) {
printHtmlPart(18)
loop:{
int j = 0
for( gioloc in (giolocation) ) {
printHtmlPart(58)
expressionOut.print(i+1)
printHtmlPart(59)
invokeTag('hiddenField','g',370,['name':("locscientificName"),'value':(gioloc?.bioResource?.scientificName?:'NA')],-1)
printHtmlPart(60)
expressionOut.print(gioloc?.bioResource?.scientificName?:'NA')
printHtmlPart(61)
invokeTag('hiddenField','g',374,['name':("locsource"),'value':(gioloc?.source?:'NA')],-1)
printHtmlPart(60)
expressionOut.print(gioloc?.source?:'NA')
printHtmlPart(61)
invokeTag('hiddenField','g',378,['name':("locvillage"),'value':(gioloc?.village?:'NA')],-1)
printHtmlPart(49)
expressionOut.print(gioloc?.village?:'NA')
printHtmlPart(61)
invokeTag('hiddenField','g',382,['name':("loctown"),'value':(gioloc?.town?:'NA')],-1)
printHtmlPart(49)
expressionOut.print(gioloc?.town?:'NA')
printHtmlPart(62)
invokeTag('hiddenField','g',386,['name':("locdistrict"),'value':(gioloc?.district?:'NA')],-1)
printHtmlPart(49)
expressionOut.print(gioloc?.district?:'NA')
printHtmlPart(62)
invokeTag('hiddenField','g',390,['name':("locstate"),'value':(gioloc?.state?:'NA')],-1)
printHtmlPart(49)
expressionOut.print(gioloc?.state?:'NA')
printHtmlPart(63)
invokeTag('hiddenField','g',393,['name':("loctraderName"),'value':(gioloc?.traderName)],-1)
printHtmlPart(49)
expressionOut.print(gioloc?.traderName?:'NA')
printHtmlPart(61)
invokeTag('hiddenField','g',397,['name':("loctraderContactDetails"),'value':(gioloc?.traderContactDetails?:'NA')],-1)
printHtmlPart(49)
expressionOut.print(gioloc?.traderContactDetails?:'NA')
printHtmlPart(64)
invokeTag('textField','g',403,['name':("locRmk"),'class':("remark"),'value':(formRemkInstance?.locationRmk)],-1)
printHtmlPart(65)
j++
}
}
printHtmlPart(16)
i++
}
}
printHtmlPart(55)
}
printHtmlPart(66)
expressionOut.print(formDetails?.nature)
printHtmlPart(28)
if(true && (formDetails?.nature != 'No')) {
printHtmlPart(67)
expressionOut.print(formDetails?.traditionalKnowledgeDesc)
printHtmlPart(28)
}
printHtmlPart(68)
expressionOut.print(formRemkInstance?.oralRemark)
printHtmlPart(69)
if(true && (formDetails?.locations)) {
printHtmlPart(70)
for( location in (formDetails?.locations) ) {
printHtmlPart(71)
expressionOut.print(location?.village)
printHtmlPart(20)
expressionOut.print(location?.town)
printHtmlPart(20)
expressionOut.print(location?.district)
printHtmlPart(24)
}
printHtmlPart(72)
}
else {
printHtmlPart(73)
}
printHtmlPart(14)
expressionOut.print(formRemkInstance?.giolocCommunityRmk)
printHtmlPart(74)
if(true && (formDetails?.selfAuthorizedPerson)) {
printHtmlPart(75)
}
else if(true && (!formDetails?.selfAuthorizedPerson)) {
printHtmlPart(76)
if(true && (formRemkInstance?.checklistContacts)) {
printHtmlPart(28)
loop:{
int l = 0
for( cont in (formRemkInstance?.checklistContacts) ) {
printHtmlPart(77)
expressionOut.print(l+1)
printHtmlPart(78)
expressionOut.print(cont?.contName)
printHtmlPart(78)
expressionOut.print(cont?.contAdd)
printHtmlPart(78)
expressionOut.print(cont?.contMobile)
printHtmlPart(78)
expressionOut.print(cont?.contEmail)
printHtmlPart(78)
expressionOut.print(cont?.contRemk)
printHtmlPart(79)
l++
}
}
printHtmlPart(28)
}
else {
printHtmlPart(20)
loop:{
int x = 0
for( contPerson in (formDetails?.contactPersons) ) {
printHtmlPart(80)
expressionOut.print(x+1)
printHtmlPart(81)
expressionOut.print(contPerson?.nameOfContactPerson)
printHtmlPart(18)
invokeTag('hiddenField','g',496,['name':("contName"),'value':(contPerson?.nameOfContactPerson)],-1)
printHtmlPart(81)
expressionOut.print(contPerson?.addressOfContactPerson)
printHtmlPart(18)
invokeTag('hiddenField','g',500,['name':("contAdd"),'value':(contPerson?.addressOfContactPerson)],-1)
printHtmlPart(81)
expressionOut.print(contPerson?.mobileOfContactPerson)
printHtmlPart(18)
invokeTag('hiddenField','g',504,['name':("contMobile"),'value':(contPerson?.mobileOfContactPerson)],-1)
printHtmlPart(81)
expressionOut.print(contPerson?.emailOfContactPerson)
printHtmlPart(18)
invokeTag('hiddenField','g',508,['name':("contEmail"),'value':(contPerson?.emailOfContactPerson)],-1)
printHtmlPart(82)
invokeTag('textField','g',513,['class':("remark"),'name':("personsAuth"),'value':(formRemkInstance?.nameAuthByApplicantRmk)],-1)
printHtmlPart(83)
x++
}
}
printHtmlPart(24)
}
printHtmlPart(84)
}
printHtmlPart(85)
expressionOut.print(formDetails?.purposeOfProposal)
printHtmlPart(14)
expressionOut.print(formRemkInstance?.assoKnowledgeRmk)
printHtmlPart(86)
expressionOut.print(formDetails?.briefDescription)
printHtmlPart(87)
expressionOut.print(formRemkInstance?.nbaApprovalRmk)
printHtmlPart(88)
if(true && (rare)) {
printHtmlPart(24)
loop:{
int i = 0
for( ntc in (rare) ) {
printHtmlPart(89)
expressionOut.print(i+1)
printHtmlPart(90)
expressionOut.print(ntc?.bio_resource)
printHtmlPart(90)
expressionOut.print(ntc?.status)
printHtmlPart(90)
expressionOut.print(ntc?.part)
printHtmlPart(90)
invokeTag('textField','g',582,['name':("ntc"),'class':("remark"),'value':(formRemkInstance?.listedInRmk)],-1)
printHtmlPart(91)
i++
}
}
printHtmlPart(24)
}
else {
printHtmlPart(92)
}
printHtmlPart(93)
if(true && (formDetails?.instituteParticipation == true)) {
printHtmlPart(94)
expressionOut.print(formetails?.detailsOfInstitute)
printHtmlPart(95)
}
else {
printHtmlPart(29)
}
printHtmlPart(14)
expressionOut.print(formRemkInstance?.dtsOfNationalInstRmk)
printHtmlPart(96)
if(true && (formDetails?.instituteParticipation == 'true')) {
printHtmlPart(97)
expressionOut.print(formDetails?.detailsOfInstitute)
printHtmlPart(98)
expressionOut.print(formDetails?.letterOfIntentName)
printHtmlPart(72)
}
else {
printHtmlPart(99)
}
printHtmlPart(100)
expressionOut.print(formRemkInstance?.researchActivitiesRmk)
printHtmlPart(101)
if(true && (formRemkInstance?.benefitSharing == true)) {
printHtmlPart(35)
}
else if(true && (formRemkInstance?.benefitSharing == false)) {
printHtmlPart(36)
}
else if(true && (formRemkInstance?.benefitSharing == '' || formRemkInstance?.benefitSharing == null)) {
printHtmlPart(37)
}
printHtmlPart(38)
expressionOut.print(formRemkInstance?.benefitSharingRmk)
printHtmlPart(102)
if(true && (formRemkInstance?.technicalInformation == '' || formRemkInstance?.technicalInformation == null)) {
printHtmlPart(103)
}
else if(true && (formRemkInstance?.technicalInformation == true)) {
printHtmlPart(104)
}
else if(true && (formRemkInstance?.technicalInformation == false)) {
printHtmlPart(105)
}
printHtmlPart(38)
expressionOut.print(formRemkInstance?.technicalInformationRmk)
printHtmlPart(106)
if(true && (formRemkInstance?.sbbBmc == '' || formRemkInstance?.sbbBmc == null)) {
printHtmlPart(107)
}
else if(true && (formRemkInstance?.sbbBmc == true)) {
printHtmlPart(35)
}
else if(true && (formRemkInstance?.sbbBmc == false)) {
printHtmlPart(108)
}
printHtmlPart(38)
expressionOut.print(formRemkInstance?.sbbBmcRmk)
printHtmlPart(109)
loop:{
int i = 0
for( a in (formRemkInstance?.gioLocation) ) {
printHtmlPart(110)
expressionOut.print(a)
printHtmlPart(111)
i++
}
}
printHtmlPart(112)
expressionOut.print(formRemkInstance?.question)
printHtmlPart(113)
if(true && (formRemkInstance != null || formRemkInstance != '')) {
printHtmlPart(114)
loop:{
int k = 0
for( quesAnswer in (formRemkInstance?.questionAnswers) ) {
printHtmlPart(115)
expressionOut.print(k+24)
printHtmlPart(116)
expressionOut.print(quesAnswer?.question)
printHtmlPart(117)
expressionOut.print(quesAnswer?.answer)
printHtmlPart(118)
k++
}
}
printHtmlPart(114)
}
printHtmlPart(119)
})
invokeTag('captureBody','sitemesh',721,[:],1)
printHtmlPart(120)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1671616331433L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
