import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_NBA_formReviewPdfs_formRemarkBTechPdfGenerator_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/formReviewPdfs/_formRemarkBTechPdfGenerator.gsp" }
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
invokeTag('captureHead','sitemesh',36,[:],1)
printHtmlPart(1)
createTagBody(1, {->
printHtmlPart(4)
expressionOut.print(formDetails?.submittedOn)
printHtmlPart(5)
expressionOut.print(formDetails?.appNumber)
printHtmlPart(6)
expressionOut.print(formRemkInstance?.appFormCatgRmk)
printHtmlPart(7)
if(true && (formDetails?.individualProfiles)) {
printHtmlPart(8)
for( individualProfile in (formDetails?.individualProfiles) ) {
printHtmlPart(9)
expressionOut.print(individualProfile?.title)
printHtmlPart(10)
expressionOut.print(individualProfile?.firstName)
printHtmlPart(10)
expressionOut.print(individualProfile?.middleName)
printHtmlPart(10)
expressionOut.print(individualProfile?.lastName)
printHtmlPart(10)
expressionOut.print(individualProfile?.address1)
printHtmlPart(10)
expressionOut.print(individualProfile?.address2)
printHtmlPart(10)
expressionOut.print(individualProfile?.address3)
printHtmlPart(10)
expressionOut.print(individualProfile?.city)
printHtmlPart(11)
invokeTag('set','g',89,['value':(individualProfile?.nationality),'var':("nationality")],-1)
printHtmlPart(8)
}
printHtmlPart(12)
}
else if(true && (formDetails?.companyProfiles)) {
printHtmlPart(8)
loop:{
int k = 0
for( company in (formDetails?.companyProfiles) ) {
printHtmlPart(10)
expressionOut.print(company?.entityName)
printHtmlPart(10)
invokeTag('set','g',95,['value':(company?.nationality),'var':("nationality")],-1)
printHtmlPart(8)
k++
}
}
printHtmlPart(12)
}
else if(true && (formDetails?.indianResearcher)) {
printHtmlPart(8)
for( researcher in (formDetails?.indianResearcher) ) {
printHtmlPart(9)
expressionOut.print(researcher?.title)
printHtmlPart(10)
expressionOut.print(researcher?.firstName)
printHtmlPart(10)
expressionOut.print(researcher?.middleName)
printHtmlPart(10)
expressionOut.print(researcher?.lastName)
printHtmlPart(10)
expressionOut.print(researcher?.address1)
printHtmlPart(10)
expressionOut.print(researcher?.address2)
printHtmlPart(10)
expressionOut.print(researcher?.address3)
printHtmlPart(10)
expressionOut.print(researcher?.presentCity)
printHtmlPart(11)
invokeTag('set','g',109,['value':(researcher?.nationality),'var':("nationality")],-1)
printHtmlPart(8)
}
printHtmlPart(12)
}
else if(true && (formDetails?.depostionOfMicroOrganism)) {
printHtmlPart(8)
for( depost in (formDetails?.depostionOfMicroOrganism) ) {
printHtmlPart(10)
expressionOut.print(depost?.nameOfDepositor)
printHtmlPart(10)
expressionOut.print(depost?.address1)
printHtmlPart(10)
expressionOut.print(depost?.address2)
printHtmlPart(10)
expressionOut.print(depost?.address3)
printHtmlPart(10)
expressionOut.print(depost?.city)
printHtmlPart(10)
invokeTag('set','g',118,['value':(depost?.nationality),'var':("nationality")],-1)
printHtmlPart(13)
}
printHtmlPart(12)
}
else if(true && (formDetails?.indianGovtInst)) {
printHtmlPart(8)
for( govt in (formDetails?.indianGovtInst) ) {
printHtmlPart(10)
expressionOut.print(govt?.govtInstName)
printHtmlPart(10)
expressionOut.print(govt?.address1)
printHtmlPart(10)
expressionOut.print(govt?.address2)
printHtmlPart(10)
expressionOut.print(govt?.address3)
printHtmlPart(10)
expressionOut.print(govt?.presentCity)
printHtmlPart(11)
invokeTag('set','g',128,['value':("Indian"),'var':("nationality")],-1)
printHtmlPart(8)
}
printHtmlPart(12)
}
printHtmlPart(14)
expressionOut.print(formRemkInstance?.applicantNameContRmk)
printHtmlPart(15)
expressionOut.print(nationality)
printHtmlPart(16)
expressionOut.print(formRemkInstance?.appltnationality)
printHtmlPart(17)
if(true && (formRemkInstance?.prescribedApplication == true)) {
printHtmlPart(18)
}
else if(true && (formRemkInstance?.prescribedApplication == false)) {
printHtmlPart(19)
}
printHtmlPart(20)
expressionOut.print(formRemkInstance?.whetherPrescriedRmk)
printHtmlPart(21)
if(true && (formRemkInstance?.columnFilled == true)) {
printHtmlPart(22)
}
else if(true && (formRemkInstance?.columnFilled == false)) {
printHtmlPart(19)
}
printHtmlPart(23)
expressionOut.print(formRemkInstance?.columnFilledRmk)
printHtmlPart(24)
if(true && (formRemkInstance?.idAndAddress == true)) {
printHtmlPart(25)
}
else if(true && (formRemkInstance?.idAndAddress == false)) {
printHtmlPart(19)
}
printHtmlPart(23)
expressionOut.print(formRemkInstance?.idAndAddressRemark)
printHtmlPart(26)
expressionOut.print(indianInst?.name)
printHtmlPart(27)
expressionOut.print(indianInst?.address1)
printHtmlPart(28)
expressionOut.print(indianInst?.address2)
printHtmlPart(29)
expressionOut.print(indianInst?.address3)
printHtmlPart(29)
expressionOut.print(indianInst?.city)
printHtmlPart(30)
expressionOut.print(indianInst?.pincode)
printHtmlPart(28)
expressionOut.print(indianInst?.state)
printHtmlPart(29)
expressionOut.print(indianInst?.country)
printHtmlPart(31)
expressionOut.print(indianInst?.phone)
printHtmlPart(32)
expressionOut.print(indianInst?.fax)
printHtmlPart(33)
expressionOut.print(indianInst?.email)
printHtmlPart(34)
expressionOut.print(formRemkInstance?.indinstitueRemk)
printHtmlPart(35)
expressionOut.print(superVisor?.headOfInstName)
printHtmlPart(36)
expressionOut.print(superVisor?.address1)
printHtmlPart(28)
expressionOut.print(superVisor?.address2)
printHtmlPart(29)
expressionOut.print(superVisor?.address3)
printHtmlPart(29)
expressionOut.print(superVisor?.city)
printHtmlPart(30)
expressionOut.print(superVisor?.pincode)
printHtmlPart(28)
expressionOut.print(superVisor?.state)
printHtmlPart(29)
expressionOut.print(superVisor?.country)
printHtmlPart(31)
expressionOut.print(superVisor?.phone)
printHtmlPart(32)
expressionOut.print(superVisor?.fax)
printHtmlPart(33)
expressionOut.print(superVisor?.email)
printHtmlPart(34)
expressionOut.print(formRemkInstance?.headSuperRemk)
printHtmlPart(37)
expressionOut.print(guidingIns?.name)
printHtmlPart(38)
expressionOut.print(guidingIns?.address1)
printHtmlPart(28)
expressionOut.print(guidingIns?.address2)
printHtmlPart(29)
expressionOut.print(guidingIns?.address3)
printHtmlPart(29)
expressionOut.print(guidingIns?.city)
printHtmlPart(30)
expressionOut.print(guidingIns?.pincode)
printHtmlPart(28)
expressionOut.print(guidingIns?.state)
printHtmlPart(29)
expressionOut.print(guidingIns?.country)
printHtmlPart(31)
expressionOut.print(guidingIns?.phone)
printHtmlPart(32)
expressionOut.print(guidingIns?.fax)
printHtmlPart(33)
expressionOut.print(guidingIns?.email)
printHtmlPart(39)
expressionOut.print(formRemkInstance?.indinstitueGuideRemk)
printHtmlPart(40)
expressionOut.print(guidingSup?.name)
printHtmlPart(38)
expressionOut.print(guidingSup?.address1)
printHtmlPart(28)
expressionOut.print(guidingSup?.address2)
printHtmlPart(29)
expressionOut.print(guidingSup?.address3)
printHtmlPart(29)
expressionOut.print(guidingSup?.city)
printHtmlPart(30)
expressionOut.print(guidingSup?.pincode)
printHtmlPart(28)
expressionOut.print(guidingSup?.state)
printHtmlPart(29)
expressionOut.print(guidingSup?.country)
printHtmlPart(31)
expressionOut.print(guidingSup?.phone)
printHtmlPart(32)
expressionOut.print(guidingSup?.fax)
printHtmlPart(33)
expressionOut.print(guidingSup?.email)
printHtmlPart(14)
expressionOut.print(formRemkInstance?.indinstSuperRemk)
printHtmlPart(41)
if(true && (formDetails?.biologicalResources)) {
printHtmlPart(42)
loop:{
int i = 0
for( resource in (formDetails?.biologicalResources) ) {
printHtmlPart(43)
expressionOut.print(i+1)
printHtmlPart(44)
expressionOut.print(resource?.accessIntention?:'NA')
printHtmlPart(44)
expressionOut.print(resource?.commonName?:'NA')
printHtmlPart(44)
expressionOut.print(resource?.scientificName?:'NA')
printHtmlPart(44)
expressionOut.print(resource?.nature?:'NA')
printHtmlPart(44)
expressionOut.print(resource?.biologicalResource?:'NA')
printHtmlPart(44)
expressionOut.print(resource?.quantity)
printHtmlPart(29)
expressionOut.print(resource?.qtyUnit)
printHtmlPart(44)
expressionOut.print(resource?.fromTime)
printHtmlPart(45)
expressionOut.print(resource?.toTime)
printHtmlPart(46)
expressionOut.print(formRemkInstance?.biologicalResRmk)
printHtmlPart(47)
i++
}
}
printHtmlPart(48)
}
printHtmlPart(49)
if(true && (formRemkInstance?.checklistLocations)) {
printHtmlPart(8)
loop:{
int k = 0
for( location in (formRemkInstance?.checklistLocations) ) {
printHtmlPart(50)
expressionOut.print(k+1)
printHtmlPart(51)
expressionOut.print(location?.locscientificName)
printHtmlPart(51)
expressionOut.print(location?.locsource)
printHtmlPart(51)
expressionOut.print(location?.locvillage)
printHtmlPart(51)
expressionOut.print(location?.loctown)
printHtmlPart(51)
expressionOut.print(location?.locdistrict)
printHtmlPart(51)
expressionOut.print(location?.locstate)
printHtmlPart(51)
expressionOut.print(location?.loctraderName)
printHtmlPart(51)
expressionOut.print(location?.loctraderContactDetails)
printHtmlPart(52)
expressionOut.print(location?.locationRemark)
printHtmlPart(53)
k++
}
}
printHtmlPart(8)
}
else if(true && (formDetails?.biologicalResources?.locations)) {
printHtmlPart(42)
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
invokeTag('hiddenField','g',348,['name':("locscientificName"),'value':(gioloc?.bioResource?.scientificName?:'NA')],-1)
printHtmlPart(57)
expressionOut.print(gioloc?.bioResource?.scientificName?:'NA')
printHtmlPart(58)
invokeTag('hiddenField','g',352,['name':("locsource"),'value':(gioloc?.source?:'NA')],-1)
printHtmlPart(57)
expressionOut.print(gioloc?.source?:'NA')
printHtmlPart(58)
invokeTag('hiddenField','g',356,['name':("locvillage"),'value':(gioloc?.village?:'NA')],-1)
printHtmlPart(59)
expressionOut.print(gioloc?.village?:'NA')
printHtmlPart(58)
invokeTag('hiddenField','g',360,['name':("loctown"),'value':(gioloc?.town?:'NA')],-1)
printHtmlPart(59)
expressionOut.print(gioloc?.town?:'NA')
printHtmlPart(60)
invokeTag('hiddenField','g',364,['name':("locdistrict"),'value':(gioloc?.district?:'NA')],-1)
printHtmlPart(59)
expressionOut.print(gioloc?.district?:'NA')
printHtmlPart(60)
invokeTag('hiddenField','g',368,['name':("locstate"),'value':(gioloc?.state?:'NA')],-1)
printHtmlPart(59)
expressionOut.print(gioloc?.state?:'NA')
printHtmlPart(61)
invokeTag('hiddenField','g',371,['name':("loctraderName"),'value':(gioloc?.traderName)],-1)
printHtmlPart(59)
expressionOut.print(gioloc?.traderName?:'NA')
printHtmlPart(58)
invokeTag('hiddenField','g',375,['name':("loctraderContactDetails"),'value':(gioloc?.traderContactDetails?:'NA')],-1)
printHtmlPart(59)
expressionOut.print(gioloc?.traderContactDetails?:'NA')
printHtmlPart(62)
invokeTag('textField','g',381,['name':("locRmk"),'class':("remark"),'value':(formRemkInstance?.locationRmk)],-1)
printHtmlPart(63)
j++
}
}
printHtmlPart(64)
i++
}
}
printHtmlPart(48)
}
printHtmlPart(65)
if(true && (formDetails?.formBFundingAgency)) {
printHtmlPart(66)
for( fund in (formDetails?.formBFundingAgency) ) {
printHtmlPart(66)
expressionOut.print(fund?.institutionOrganizationName)
printHtmlPart(66)
}
printHtmlPart(66)
}
printHtmlPart(67)
expressionOut.print(formRemkInstance?.fundingRemk)
printHtmlPart(68)
expressionOut.print(formDetails?.emergencyDetails)
printHtmlPart(69)
expressionOut.print(formRemkInstance?.emergencyRemk)
printHtmlPart(70)
if(true && (formRemkInstance?.signedUndertaking == true)) {
printHtmlPart(71)
}
else if(true && (" ${formRemkInstance?.signedUndertaking == false}")) {
printHtmlPart(72)
}
printHtmlPart(73)
expressionOut.print(formRemkInstance?.signedUndertakingRmk)
printHtmlPart(74)
if(true && (formRemkInstance?.technicalInformation == true)) {
printHtmlPart(71)
}
else if(true && (formRemkInstance?.technicalInformation == false)) {
printHtmlPart(75)
}
printHtmlPart(76)
expressionOut.print(formRemkInstance?.technicalInformationRmk)
printHtmlPart(77)
})
invokeTag('captureBody','sitemesh',450,[:],1)
printHtmlPart(78)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1671616487919L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
