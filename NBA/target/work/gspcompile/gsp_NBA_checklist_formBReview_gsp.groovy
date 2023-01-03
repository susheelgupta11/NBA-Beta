import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_NBA_checklist_formBReview_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/checklist/_formBReview.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
invokeTag('textField','g',24,['name':("formCatg"),'value':(formRemkInstance?.appFormCatgRmk),'class':("remark")],-1)
printHtmlPart(1)
if(true && (formDetails?.individualProfiles)) {
printHtmlPart(2)
for( individualProfile in (formDetails?.individualProfiles) ) {
printHtmlPart(3)
expressionOut.print(individualProfile?.title)
printHtmlPart(4)
expressionOut.print(individualProfile?.firstName)
printHtmlPart(4)
expressionOut.print(individualProfile?.middleName)
printHtmlPart(4)
expressionOut.print(individualProfile?.lastName)
printHtmlPart(5)
expressionOut.print(individualProfile?.address1)
printHtmlPart(5)
expressionOut.print(individualProfile?.address2)
printHtmlPart(5)
expressionOut.print(individualProfile?.address3)
printHtmlPart(5)
expressionOut.print(individualProfile?.city)
printHtmlPart(4)
invokeTag('set','g',43,['value':(individualProfile?.nationality),'var':("nationality")],-1)
printHtmlPart(6)
}
printHtmlPart(7)
}
else if(true && (formDetails?.companyProfiles)) {
printHtmlPart(2)
loop:{
int k = 0
for( company in (formDetails?.companyProfiles) ) {
printHtmlPart(4)
expressionOut.print(company?.entityName)
printHtmlPart(4)
invokeTag('set','g',49,['value':(company?.nationality),'var':("nationality")],-1)
printHtmlPart(6)
k++
}
}
printHtmlPart(7)
}
else if(true && (formDetails?.indianResearcher)) {
printHtmlPart(2)
for( researcher in (formDetails?.indianResearcher) ) {
printHtmlPart(3)
expressionOut.print(researcher?.title)
printHtmlPart(4)
expressionOut.print(researcher?.firstName)
printHtmlPart(4)
expressionOut.print(researcher?.middleName)
printHtmlPart(4)
expressionOut.print(researcher?.lastName)
printHtmlPart(5)
expressionOut.print(researcher?.address1)
printHtmlPart(5)
expressionOut.print(researcher?.address2)
printHtmlPart(5)
expressionOut.print(researcher?.address3)
printHtmlPart(5)
expressionOut.print(researcher?.presentCity)
printHtmlPart(2)
invokeTag('set','g',62,['value':(researcher?.nationality),'var':("nationality")],-1)
printHtmlPart(6)
}
printHtmlPart(7)
}
else if(true && (formDetails?.depostionOfMicroOrganism)) {
printHtmlPart(2)
for( depost in (formDetails?.depostionOfMicroOrganism) ) {
printHtmlPart(4)
expressionOut.print(depost?.nameOfDepositor)
printHtmlPart(5)
expressionOut.print(depost?.address1)
printHtmlPart(4)
expressionOut.print(depost?.address2)
printHtmlPart(4)
expressionOut.print(depost?.address3)
printHtmlPart(5)
expressionOut.print(depost?.city)
printHtmlPart(8)
invokeTag('set','g',71,['value':(depost?.nationality),'var':("nationality")],-1)
printHtmlPart(6)
}
printHtmlPart(7)
}
else if(true && (formDetails?.indianGovtInst)) {
printHtmlPart(2)
for( govt in (formDetails?.indianGovtInst) ) {
printHtmlPart(4)
expressionOut.print(govt?.govtInstName)
printHtmlPart(5)
expressionOut.print(govt?.address1)
printHtmlPart(4)
expressionOut.print(govt?.address2)
printHtmlPart(5)
expressionOut.print(govt?.address3)
printHtmlPart(5)
expressionOut.print(govt?.presentCity)
printHtmlPart(8)
invokeTag('set','g',80,['value':("Indian"),'var':("nationality")],-1)
printHtmlPart(2)
}
printHtmlPart(7)
}
printHtmlPart(9)
invokeTag('textField','g',84,['name':("appltname"),'value':(formRemkInstance?.applicantNameContRmk),'class':("remark")],-1)
printHtmlPart(10)
expressionOut.print(nationality)
printHtmlPart(11)
invokeTag('textField','g',96,['name':("appltnationality"),'value':(formRemkInstance?.appltnationality),'class':("remark")],-1)
printHtmlPart(12)
if(true && (formRemkInstance?.prescribedApplication == true)) {
printHtmlPart(13)
invokeTag('radio','g',104,['name':("prescribedApplication"),'value':("true"),'checked':("true"),'id':("wheatherYes")],-1)
printHtmlPart(14)
invokeTag('radio','g',105,['name':("prescribedApplication"),'value':("false"),'id':("wheatherNo")],-1)
printHtmlPart(15)
}
else if(true && (formRemkInstance?.prescribedApplication == false)) {
printHtmlPart(13)
invokeTag('radio','g',109,['name':("prescribedApplication"),'value':("true"),'id':("wheatherYes")],-1)
printHtmlPart(14)
invokeTag('radio','g',110,['name':("prescribedApplication"),'checked':("true"),'value':("false"),'id':("wheatherNo")],-1)
printHtmlPart(16)
}
else if(true && (formRemkInstance?.prescribedApplication == '' || formRemkInstance?.prescribedApplication == null)) {
printHtmlPart(13)
invokeTag('radio','g',116,['name':("prescribedApplication"),'value':("true"),'id':("wheatherYes")],-1)
printHtmlPart(14)
invokeTag('radio','g',117,['name':("prescribedApplication"),'value':("false"),'id':("wheatherNo")],-1)
printHtmlPart(16)
}
printHtmlPart(17)
invokeTag('textField','g',121,['name':("whetherPrescriedRmk"),'value':(formRemkInstance?.whetherPrescriedRmk),'class':("remark")],-1)
printHtmlPart(18)
if(true && (formRemkInstance?.columnFilled == true)) {
printHtmlPart(19)
invokeTag('radio','g',130,['name':("columnFilled"),'value':("true"),'checked':("true"),'id':("columnFilledYes")],-1)
printHtmlPart(14)
invokeTag('radio','g',131,['name':("columnFilled"),'value':("false"),'id':("columnFilledNo")],-1)
printHtmlPart(15)
}
else if(true && (formRemkInstance?.columnFilled == false)) {
printHtmlPart(13)
invokeTag('radio','g',135,['name':("columnFilled"),'value':("true"),'id':("columnFilledYes")],-1)
printHtmlPart(14)
invokeTag('radio','g',136,['name':("columnFilled"),'checked':("true"),'value':("false"),'id':("columnFilledNo")],-1)
printHtmlPart(16)
}
else if(true && (formRemkInstance?.columnFilled == '' || formRemkInstance?.columnFilled == null)) {
printHtmlPart(13)
invokeTag('radio','g',142,['name':("columnFilled"),'value':("true"),'id':("columnFilledYes")],-1)
printHtmlPart(14)
invokeTag('radio','g',143,['name':("columnFilled"),'value':("false"),'id':("columnFilledNo")],-1)
printHtmlPart(15)
}
printHtmlPart(17)
invokeTag('textField','g',146,['name':("columnFilledRmk"),'value':(formRemkInstance?.columnFilledRmk),'class':("remark")],-1)
printHtmlPart(20)
if(true && (formRemkInstance?.idAndAddress == true)) {
printHtmlPart(13)
invokeTag('radio','g',154,['name':("whrIdProofMtc"),'value':("true"),'checked':("true"),'id':("wheatherYes")],-1)
printHtmlPart(14)
invokeTag('radio','g',155,['name':("whrIdProofMtc"),'value':("false"),'id':("wheatherNo")],-1)
printHtmlPart(15)
}
else if(true && (formRemkInstance?.idAndAddress == false)) {
printHtmlPart(13)
invokeTag('radio','g',159,['name':("whrIdProofMtc"),'value':("true"),'id':("wheatherYes")],-1)
printHtmlPart(14)
invokeTag('radio','g',160,['name':("whrIdProofMtc"),'checked':("true"),'value':("false"),'id':("wheatherNo")],-1)
printHtmlPart(16)
}
else if(true && (formRemkInstance?.idAndAddress == '' || formRemkInstance?.idAndAddress == null)) {
printHtmlPart(13)
invokeTag('radio','g',166,['name':("whrIdProofMtc"),'value':("true"),'id':("wheatherYes")],-1)
printHtmlPart(14)
invokeTag('radio','g',167,['name':("whrIdProofMtc"),'value':("false"),'id':("wheatherNo")],-1)
printHtmlPart(16)
}
printHtmlPart(21)
invokeTag('textField','g',171,['name':("whrIdProof"),'value':(formRemkInstance?.idAndAddressRemark),'class':("remark")],-1)
printHtmlPart(22)
expressionOut.print(indianInst?.name)
printHtmlPart(23)
expressionOut.print(indianInst?.address1)
printHtmlPart(24)
expressionOut.print(indianInst?.address2)
printHtmlPart(25)
expressionOut.print(indianInst?.address3)
printHtmlPart(25)
expressionOut.print(indianInst?.city)
printHtmlPart(26)
expressionOut.print(indianInst?.pincode)
printHtmlPart(24)
expressionOut.print(indianInst?.state)
printHtmlPart(25)
expressionOut.print(indianInst?.country)
printHtmlPart(27)
expressionOut.print(indianInst?.phone)
printHtmlPart(28)
expressionOut.print(indianInst?.fax)
printHtmlPart(29)
expressionOut.print(indianInst?.email)
printHtmlPart(30)
invokeTag('textField','g',189,['name':("indinstitueRemk"),'value':(formRemkInstance?.indinstitueRemk),'class':("remark")],-1)
printHtmlPart(31)
expressionOut.print(superVisor?.headOfInstName)
printHtmlPart(32)
expressionOut.print(superVisor?.address1)
printHtmlPart(24)
expressionOut.print(superVisor?.address2)
printHtmlPart(25)
expressionOut.print(superVisor?.address3)
printHtmlPart(25)
expressionOut.print(superVisor?.city)
printHtmlPart(26)
expressionOut.print(superVisor?.pincode)
printHtmlPart(24)
expressionOut.print(superVisor?.state)
printHtmlPart(25)
expressionOut.print(superVisor?.country)
printHtmlPart(27)
expressionOut.print(superVisor?.phone)
printHtmlPart(28)
expressionOut.print(superVisor?.fax)
printHtmlPart(29)
expressionOut.print(superVisor?.email)
printHtmlPart(33)
invokeTag('textField','g',204,['name':("headSuperRemk"),'value':(formRemkInstance?.headSuperRemk),'class':("remark")],-1)
printHtmlPart(34)
expressionOut.print(guidingIns?.name)
printHtmlPart(35)
expressionOut.print(guidingIns?.address1)
printHtmlPart(24)
expressionOut.print(guidingIns?.address2)
printHtmlPart(25)
expressionOut.print(guidingIns?.address3)
printHtmlPart(25)
expressionOut.print(guidingIns?.city)
printHtmlPart(26)
expressionOut.print(guidingIns?.pincode)
printHtmlPart(24)
expressionOut.print(guidingIns?.state)
printHtmlPart(25)
expressionOut.print(guidingIns?.country)
printHtmlPart(27)
expressionOut.print(guidingIns?.phone)
printHtmlPart(28)
expressionOut.print(guidingIns?.fax)
printHtmlPart(29)
expressionOut.print(guidingIns?.email)
printHtmlPart(36)
invokeTag('textField','g',221,['name':("indinstitueGuideRemk"),'value':(formRemkInstance?.indinstitueGuideRemk),'class':("remark")],-1)
printHtmlPart(37)
expressionOut.print(guidingSup?.name)
printHtmlPart(35)
expressionOut.print(guidingSup?.address1)
printHtmlPart(24)
expressionOut.print(guidingSup?.address2)
printHtmlPart(25)
expressionOut.print(guidingSup?.address3)
printHtmlPart(25)
expressionOut.print(guidingSup?.city)
printHtmlPart(26)
expressionOut.print(guidingSup?.pincode)
printHtmlPart(24)
expressionOut.print(guidingSup?.state)
printHtmlPart(25)
expressionOut.print(guidingSup?.country)
printHtmlPart(27)
expressionOut.print(guidingSup?.phone)
printHtmlPart(28)
expressionOut.print(guidingSup?.fax)
printHtmlPart(29)
expressionOut.print(guidingSup?.email)
printHtmlPart(38)
invokeTag('textField','g',236,['name':("indinstSuperRemk"),'value':(formRemkInstance?.indinstSuperRemk),'class':("remark")],-1)
printHtmlPart(39)
if(true && (formDetails?.biologicalResources)) {
printHtmlPart(40)
loop:{
int i = 0
for( resource in (formDetails?.biologicalResources) ) {
printHtmlPart(41)
expressionOut.print(i+1)
printHtmlPart(42)
expressionOut.print(resource?.accessIntention?:'NA')
printHtmlPart(42)
expressionOut.print(resource?.commonName?:'NA')
printHtmlPart(42)
expressionOut.print(resource?.scientificName?:'NA')
printHtmlPart(42)
expressionOut.print(resource?.nature?:'NA')
printHtmlPart(42)
expressionOut.print(resource?.biologicalResource?:'NA')
printHtmlPart(42)
expressionOut.print(resource?.quantity)
printHtmlPart(25)
expressionOut.print(resource?.qtyUnit)
printHtmlPart(42)
expressionOut.print(resource?.fromTime)
printHtmlPart(43)
expressionOut.print(resource?.toTime)
printHtmlPart(44)
invokeTag('textField','g',286,['name':("resremk"),'class':("remark"),'value':(formRemkInstance?.biologicalResRmk)],-1)
printHtmlPart(45)
i++
}
}
printHtmlPart(46)
}
printHtmlPart(47)
expressionOut.print(formDetails?.researchDurationFrom?.format('dd/MM/yyyy'))
printHtmlPart(48)
expressionOut.print(formDetails?.researchDurationTo?.format('dd/MM/yyyy'))
printHtmlPart(49)
if(true && (appForm?.typeOfExercise == 'multipleTime')) {
printHtmlPart(50)
}
else {
printHtmlPart(51)
}
printHtmlPart(52)
if(true && (appForm?.typeOfExercise == 'multipleTime')) {
printHtmlPart(53)
expressionOut.print(appForm?.numOfTimesOfSending)
printHtmlPart(54)
expressionOut.print(appForm?.reasonsForSending)
printHtmlPart(55)
}
printHtmlPart(56)
if(true && (formRemkInstance?.checklistLocations)) {
printHtmlPart(2)
loop:{
int k = 0
for( location in (formRemkInstance?.checklistLocations) ) {
printHtmlPart(57)
expressionOut.print(k+1)
printHtmlPart(58)
expressionOut.print(location?.locscientificName)
printHtmlPart(58)
expressionOut.print(location?.locsource)
printHtmlPart(58)
expressionOut.print(location?.locvillage)
printHtmlPart(58)
expressionOut.print(location?.loctown)
printHtmlPart(58)
expressionOut.print(location?.locdistrict)
printHtmlPart(58)
expressionOut.print(location?.locstate)
printHtmlPart(58)
expressionOut.print(location?.loctraderName)
printHtmlPart(58)
expressionOut.print(location?.loctraderContactDetails)
printHtmlPart(59)
expressionOut.print(location?.locationRemark)
printHtmlPart(60)
k++
}
}
printHtmlPart(2)
}
else if(true && (formDetails?.biologicalResources?.locations)) {
printHtmlPart(40)
loop:{
int i = 0
for( giolocation in (formDetails?.biologicalResources?.locations) ) {
printHtmlPart(61)
loop:{
int j = 0
for( gioloc in (giolocation) ) {
printHtmlPart(62)
expressionOut.print(i+1)
printHtmlPart(63)
invokeTag('hiddenField','g',398,['name':("locscientificName"),'value':(gioloc?.bioResource?.scientificName?:'NA')],-1)
printHtmlPart(64)
expressionOut.print(gioloc?.bioResource?.scientificName?:'NA')
printHtmlPart(65)
invokeTag('hiddenField','g',402,['name':("locsource"),'value':(gioloc?.source?:'NA')],-1)
printHtmlPart(64)
expressionOut.print(gioloc?.source?:'NA')
printHtmlPart(65)
invokeTag('hiddenField','g',406,['name':("locvillage"),'value':(gioloc?.village?:'NA')],-1)
printHtmlPart(66)
expressionOut.print(gioloc?.village?:'NA')
printHtmlPart(65)
invokeTag('hiddenField','g',410,['name':("loctown"),'value':(gioloc?.town?:'NA')],-1)
printHtmlPart(66)
expressionOut.print(gioloc?.town?:'NA')
printHtmlPart(67)
invokeTag('hiddenField','g',414,['name':("locdistrict"),'value':(gioloc?.district?:'NA')],-1)
printHtmlPart(66)
expressionOut.print(gioloc?.district?:'NA')
printHtmlPart(67)
invokeTag('hiddenField','g',418,['name':("locstate"),'value':(gioloc?.state?:'NA')],-1)
printHtmlPart(66)
expressionOut.print(gioloc?.state?:'NA')
printHtmlPart(68)
invokeTag('hiddenField','g',421,['name':("loctraderName"),'value':(gioloc?.traderName)],-1)
printHtmlPart(66)
expressionOut.print(gioloc?.traderName?:'NA')
printHtmlPart(65)
invokeTag('hiddenField','g',425,['name':("loctraderContactDetails"),'value':(gioloc?.traderContactDetails?:'NA')],-1)
printHtmlPart(66)
expressionOut.print(gioloc?.traderContactDetails?:'NA')
printHtmlPart(69)
invokeTag('textField','g',431,['name':("locRmk"),'class':("remark"),'value':(formRemkInstance?.locationRmk)],-1)
printHtmlPart(70)
j++
}
}
printHtmlPart(8)
i++
}
}
printHtmlPart(46)
}
printHtmlPart(71)
if(true && (formDetails?.formBFundingAgency)) {
printHtmlPart(72)
for( fund in (formDetails?.formBFundingAgency) ) {
printHtmlPart(72)
expressionOut.print(fund?.institutionOrganizationName)
printHtmlPart(72)
}
printHtmlPart(72)
}
printHtmlPart(38)
invokeTag('textField','g',454,['name':("fundingRemk"),'value':(formRemkInstance?.fundingRemk),'class':("remark")],-1)
printHtmlPart(73)
expressionOut.print(formDetails?.emergencyDetails)
printHtmlPart(9)
invokeTag('textField','g',462,['name':("emergencyRemk"),'value':(formRemkInstance?.emergencyRemk),'class':("remark")],-1)
printHtmlPart(74)
if(true && (formRemkInstance?.signedUndertaking == '' || formRemkInstance?.signedUndertaking == null)) {
printHtmlPart(13)
invokeTag('radio','g',504,['value':("true"),'name':("signedUndertaking")],-1)
printHtmlPart(75)
invokeTag('radio','g',505,['value':("false"),'name':("signedUndertaking")],-1)
printHtmlPart(16)
}
else if(true && (formRemkInstance?.signedUndertaking == true)) {
printHtmlPart(13)
invokeTag('radio','g',510,['value':("true"),'checked':("true"),'name':("signedUndertaking")],-1)
printHtmlPart(76)
invokeTag('radio','g',510,['value':("false"),'name':("signedUndertaking")],-1)
printHtmlPart(77)
}
else if(true && (formRemkInstance?.signedUndertaking == false)) {
printHtmlPart(13)
invokeTag('radio','g',514,['value':("true"),'name':("signedUndertaking")],-1)
printHtmlPart(75)
invokeTag('radio','g',515,['value':("false"),'checked':("true"),'name':("signedUndertaking")],-1)
printHtmlPart(15)
}
printHtmlPart(21)
invokeTag('textField','g',518,['name':("signedUndertakingRmk"),'value':(formRemkInstance?.signedUndertakingRmk),'class':("remark")],-1)
printHtmlPart(78)
if(true && (formRemkInstance?.technicalInformation == '' || formRemkInstance?.technicalInformation == null)) {
printHtmlPart(13)
invokeTag('radio','g',528,['value':("true"),'name':("reqTechInfo")],-1)
printHtmlPart(75)
invokeTag('radio','g',529,['value':("false"),'name':("reqTechInfo")],-1)
printHtmlPart(16)
}
else if(true && (formRemkInstance?.technicalInformation == true)) {
printHtmlPart(13)
invokeTag('radio','g',534,['value':("true"),'checked':("true"),'name':("reqTechInfo")],-1)
printHtmlPart(76)
invokeTag('radio','g',534,['value':("false"),'name':("reqTechInfo")],-1)
printHtmlPart(77)
}
else if(true && (formRemkInstance?.technicalInformation == false)) {
printHtmlPart(13)
invokeTag('radio','g',538,['value':("true"),'name':("reqTechInfo")],-1)
printHtmlPart(75)
invokeTag('radio','g',539,['value':("false"),'checked':("true"),'name':("reqTechInfo")],-1)
printHtmlPart(15)
}
printHtmlPart(21)
invokeTag('textField','g',542,['name':("techInfo"),'value':(formRemkInstance?.technicalInformationRmk),'class':("remark")],-1)
printHtmlPart(79)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1668072903156L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
