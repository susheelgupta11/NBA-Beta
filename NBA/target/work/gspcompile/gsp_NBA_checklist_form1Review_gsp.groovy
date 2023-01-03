import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_NBA_checklist_form1Review_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/checklist/_form1Review.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
expressionOut.print(formDetails?.appNumber)
printHtmlPart(1)
invokeTag('textField','g',22,['class':("remark"),'name':("appnumber"),'value':(formRemkInstance?.onlineAppNumberRmk)],-1)
printHtmlPart(2)
invokeTag('textField','g',29,['class':("remark"),'name':("refNumber"),'value':(formRemkInstance?.nbaRefNumber)],-1)
printHtmlPart(3)
invokeTag('textField','g',32,['class':("remark"),'name':("nbaRefNumberRemark"),'value':(formRemkInstance?.nbaRefNumberRemark)],-1)
printHtmlPart(4)
if(true && (formDetails?.individualProfiles)) {
printHtmlPart(5)
}
else if(true && (formDetails?.companyProfiles)) {
printHtmlPart(6)
for( ct in (formDetails?.companyProfiles) ) {
printHtmlPart(6)
expressionOut.print(ct?.entityType)
printHtmlPart(6)
}
printHtmlPart(6)
}
else if(true && (formDetails?.indianGovtInst)) {
printHtmlPart(7)
}
else if(true && (formDetails?.depostionOfMicroOrganism)) {
printHtmlPart(8)
}
else if(true && (formDetails?.indianResearcher)) {
printHtmlPart(9)
}
printHtmlPart(3)
invokeTag('textField','g',49,['class':("remark"),'name':("appltcatg"),'value':(formRemkInstance?.applicantCatgRmk)],-1)
printHtmlPart(10)
if(true && (formDetails?.individualProfiles)) {
printHtmlPart(6)
for( individualProfile in (formDetails?.individualProfiles) ) {
printHtmlPart(11)
expressionOut.print(individualProfile?.title)
printHtmlPart(12)
expressionOut.print(individualProfile?.firstName)
printHtmlPart(12)
expressionOut.print(individualProfile?.middleName)
printHtmlPart(12)
expressionOut.print(individualProfile?.lastName)
printHtmlPart(13)
expressionOut.print(individualProfile?.address1)
printHtmlPart(12)
expressionOut.print(individualProfile?.address2)
printHtmlPart(12)
expressionOut.print(individualProfile?.address3)
printHtmlPart(12)
expressionOut.print(individualProfile?.city)
printHtmlPart(6)
}
printHtmlPart(14)
}
else if(true && (formDetails?.companyProfiles)) {
printHtmlPart(6)
loop:{
int k = 0
for( company in (formDetails?.companyProfiles) ) {
printHtmlPart(12)
expressionOut.print(company?.entityName)
printHtmlPart(6)
k++
}
}
printHtmlPart(14)
}
else if(true && (formDetails?.indianResearcher)) {
printHtmlPart(6)
for( researcher in (formDetails?.indianResearcher) ) {
printHtmlPart(11)
expressionOut.print(researcher?.title)
printHtmlPart(12)
expressionOut.print(researcher?.firstName)
printHtmlPart(12)
expressionOut.print(researcher?.middleName)
printHtmlPart(12)
expressionOut.print(researcher?.lastName)
printHtmlPart(13)
expressionOut.print(researcher?.address1)
printHtmlPart(12)
expressionOut.print(researcher?.address2)
printHtmlPart(12)
expressionOut.print(researcher?.address3)
printHtmlPart(12)
expressionOut.print(researcher?.presentCity)
printHtmlPart(6)
}
printHtmlPart(14)
}
else if(true && (formDetails?.depostionOfMicroOrganism)) {
printHtmlPart(6)
for( depost in (formDetails?.depostionOfMicroOrganism) ) {
printHtmlPart(12)
expressionOut.print(depost?.nameOfDepositor)
printHtmlPart(13)
expressionOut.print(depost?.address1)
printHtmlPart(12)
expressionOut.print(depost?.address2)
printHtmlPart(12)
expressionOut.print(depost?.address3)
printHtmlPart(12)
expressionOut.print(depost?.city)
printHtmlPart(6)
}
printHtmlPart(14)
}
else if(true && (formDetails?.indianGovtInst)) {
printHtmlPart(6)
for( govt in (formDetails?.indianGovtInst) ) {
printHtmlPart(12)
expressionOut.print(govt?.govtInstName)
printHtmlPart(13)
expressionOut.print(govt?.address1)
printHtmlPart(12)
expressionOut.print(govt?.address2)
printHtmlPart(12)
expressionOut.print(govt?.address3)
printHtmlPart(12)
expressionOut.print(govt?.presentCity)
printHtmlPart(6)
}
printHtmlPart(14)
}
printHtmlPart(3)
invokeTag('textField','g',106,['class':("remark"),'name':("appltname"),'value':(formRemkInstance?.applicantNameContRmk)],-1)
printHtmlPart(15)
if(true && (formDetails?.companyProfiles)) {
printHtmlPart(16)
for( comp in (formDetails?.companyProfiles) ) {
printHtmlPart(16)
expressionOut.print(comp?.title)
printHtmlPart(6)
expressionOut.print(comp?.firstName)
printHtmlPart(6)
expressionOut.print(comp?.middleName)
printHtmlPart(6)
expressionOut.print(comp?.lastName)
printHtmlPart(17)
expressionOut.print(comp?.designation)
printHtmlPart(18)
expressionOut.print(comp?.personMobile)
printHtmlPart(19)
expressionOut.print(comp?.personEmail)
printHtmlPart(16)
}
printHtmlPart(20)
}
else {
printHtmlPart(21)
}
printHtmlPart(3)
invokeTag('textField','g',127,['class':("remark"),'name':("nameandComp"),'value':(formRemkInstance?.authPersonContRmk)],-1)
printHtmlPart(22)
if(true && (formDetails?.agentProfile)) {
printHtmlPart(14)
expressionOut.print(formDetails?.agentProfile?.title)
printHtmlPart(23)
expressionOut.print(formDetails?.agentProfile?.firstName)
printHtmlPart(14)
expressionOut.print(formDetails?.agentProfile?.middleName)
printHtmlPart(23)
expressionOut.print(formDetails?.agentProfile?.lastName)
printHtmlPart(24)
expressionOut.print(formDetails?.agentProfile?.address1)
printHtmlPart(23)
expressionOut.print(formDetails?.agentProfile?.address2)
printHtmlPart(14)
expressionOut.print(formDetails?.agentProfile?.address3)
printHtmlPart(25)
expressionOut.print(formDetails?.agentProfile?.city)
printHtmlPart(14)
}
else {
printHtmlPart(21)
}
printHtmlPart(26)
invokeTag('textField','g',147,['class':("remark"),'name':("agent"),'value':(formRemkInstance?.attorneyInIndiaContRmk)],-1)
printHtmlPart(27)
invokeTag('textField','g',159,['class':("remark"),'name':("formCatg"),'value':(formRemkInstance?.appFormCatgRmk)],-1)
printHtmlPart(28)
if(true && (formRemkInstance?.idAndAddress == true)) {
printHtmlPart(29)
invokeTag('radio','g',169,['name':("whrIdProofMtc"),'value':("true"),'checked':("true"),'id':("wheatherYes")],-1)
printHtmlPart(30)
invokeTag('radio','g',170,['name':("whrIdProofMtc"),'value':("false"),'id':("wheatherNo")],-1)
printHtmlPart(31)
}
else if(true && (formRemkInstance?.idAndAddress == false)) {
printHtmlPart(29)
invokeTag('radio','g',174,['name':("whrIdProofMtc"),'value':("true"),'id':("wheatherYes")],-1)
printHtmlPart(30)
invokeTag('radio','g',175,['name':("whrIdProofMtc"),'checked':("true"),'value':("false"),'id':("wheatherNo")],-1)
printHtmlPart(32)
}
else if(true && (formRemkInstance?.idAndAddress == '' || formRemkInstance?.idAndAddress == null)) {
printHtmlPart(29)
invokeTag('radio','g',181,['name':("whrIdProofMtc"),'value':("true"),'id':("wheatherYes")],-1)
printHtmlPart(30)
invokeTag('radio','g',182,['name':("whrIdProofMtc"),'value':("false"),'id':("wheatherNo")],-1)
printHtmlPart(32)
}
printHtmlPart(33)
invokeTag('textField','g',186,['class':("remark"),'name':("whrIdProof"),'value':(formRemkInstance?.idAndAddressRemark)],-1)
printHtmlPart(34)
if(true && (formRemkInstance?.checklistBioresorces)) {
printHtmlPart(6)
loop:{
int j = 0
for( bioRemarks in (formRemkInstance?.checklistBioresorces) ) {
printHtmlPart(35)
expressionOut.print(j+1)
printHtmlPart(36)
expressionOut.print(bioRemarks?.chkname)
printHtmlPart(36)
expressionOut.print(bioRemarks?.chkcommonName)
printHtmlPart(36)
expressionOut.print(bioRemarks?.chkscientificName)
printHtmlPart(36)
expressionOut.print(bioRemarks?.chknature)
printHtmlPart(36)
expressionOut.print(bioRemarks?.chkbiologicalResource)
printHtmlPart(36)
expressionOut.print(bioRemarks?.chkQuantity)
printHtmlPart(37)
expressionOut.print(bioRemarks?.chkFromtime)
printHtmlPart(38)
expressionOut.print(bioRemarks?.chkTotime)
printHtmlPart(39)
expressionOut.print(bioRemarks?.bioRemarks)
printHtmlPart(40)
j++
}
}
printHtmlPart(6)
}
else if(true && (formDetails?.biologicalResources)) {
printHtmlPart(41)
loop:{
int i = 0
for( resource in (formDetails?.biologicalResources) ) {
printHtmlPart(42)
expressionOut.print(i+1)
printHtmlPart(43)
invokeTag('hiddenField','g',233,['name':("chkname"),'value':(resource?.accessIntention?:'NA')],-1)
printHtmlPart(44)
expressionOut.print(resource?.accessIntention?:'NA')
printHtmlPart(45)
invokeTag('hiddenField','g',237,['name':("chkcommonName"),'value':(resource?.commonName?:'NA')],-1)
printHtmlPart(46)
expressionOut.print(resource?.commonName?:'NA')
printHtmlPart(47)
invokeTag('hiddenField','g',241,['name':("chkscientificName"),'value':(resource?.scientificName?:'NA')],-1)
printHtmlPart(46)
expressionOut.print(resource?.scientificName?:'NA')
printHtmlPart(47)
invokeTag('hiddenField','g',245,['name':("chknature"),'value':(resource?.nature?:'NA')],-1)
printHtmlPart(46)
expressionOut.print(resource?.nature?:'NA')
printHtmlPart(47)
invokeTag('hiddenField','g',249,['name':("chkbiologicalResource"),'value':(resource?.biologicalResource?:'NA')],-1)
printHtmlPart(44)
expressionOut.print(resource?.biologicalResource?:'NA')
printHtmlPart(45)
invokeTag('hiddenField','g',253,['name':("chkQuantity"),'value':(resource?.quantity+ '-'+resource?.qtyUnit)],-1)
printHtmlPart(46)
expressionOut.print(resource?.quantity +'-'+resource?.qtyUnit)
printHtmlPart(48)
invokeTag('formatDate','g',257,['format':("dd/MM/yyyy"),'date':(resource?.fromTime)],-1)
printHtmlPart(46)
invokeTag('hiddenField','g',258,['name':("chkFromtime"),'value':(resource?.fromTime)],-1)
printHtmlPart(49)
invokeTag('formatDate','g',260,['format':("dd/MM/yyyy"),'date':(resource?.toTime)],-1)
printHtmlPart(46)
invokeTag('hiddenField','g',261,['name':("chkTotime"),'value':(resource?.toTime)],-1)
printHtmlPart(50)
invokeTag('textField','g',264,['class':("remark"),'name':("resremk"),'value':(formRemkInstance?.biologicalResRmk)],-1)
printHtmlPart(51)
i++
}
}
printHtmlPart(52)
}
printHtmlPart(53)
if(true && (formRemkInstance?.checklistLocations)) {
printHtmlPart(6)
loop:{
int k = 0
for( location in (formRemkInstance?.checklistLocations) ) {
printHtmlPart(35)
expressionOut.print(k+1)
printHtmlPart(36)
expressionOut.print(location?.locscientificName)
printHtmlPart(36)
expressionOut.print(location?.locsource)
printHtmlPart(36)
expressionOut.print(location?.locvillage)
printHtmlPart(36)
expressionOut.print(location?.loctown)
printHtmlPart(36)
expressionOut.print(location?.locdistrict)
printHtmlPart(36)
expressionOut.print(location?.locstate)
printHtmlPart(36)
expressionOut.print(location?.loctraderName)
printHtmlPart(36)
expressionOut.print(location?.loctraderContactDetails)
printHtmlPart(54)
expressionOut.print(location?.locationRemark)
printHtmlPart(55)
k++
}
}
printHtmlPart(6)
}
else if(true && (formDetails?.biologicalResources?.locations)) {
printHtmlPart(41)
loop:{
int i = 0
for( giolocation in (formDetails?.biologicalResources?.locations) ) {
printHtmlPart(44)
loop:{
int j = 0
for( gioloc in (giolocation) ) {
printHtmlPart(56)
expressionOut.print(i+1)
printHtmlPart(57)
invokeTag('hiddenField','g',317,['name':("locscientificName"),'value':(gioloc?.bioResource?.scientificName?:'NA')],-1)
printHtmlPart(58)
expressionOut.print(gioloc?.bioResource?.scientificName?:'NA')
printHtmlPart(59)
invokeTag('hiddenField','g',321,['name':("locsource"),'value':(gioloc?.source?:'NA')],-1)
printHtmlPart(58)
expressionOut.print(gioloc?.source?:'NA')
printHtmlPart(59)
invokeTag('hiddenField','g',325,['name':("locvillage"),'value':(gioloc?.village?:'NA')],-1)
printHtmlPart(46)
expressionOut.print(gioloc?.village?:'NA')
printHtmlPart(59)
invokeTag('hiddenField','g',329,['name':("loctown"),'value':(gioloc?.town?:'NA')],-1)
printHtmlPart(46)
expressionOut.print(gioloc?.town?:'NA')
printHtmlPart(60)
invokeTag('hiddenField','g',333,['name':("locdistrict"),'value':(gioloc?.district?:'NA')],-1)
printHtmlPart(46)
expressionOut.print(gioloc?.district?:'NA')
printHtmlPart(60)
invokeTag('hiddenField','g',337,['name':("locstate"),'value':(gioloc?.state?:'NA')],-1)
printHtmlPart(46)
expressionOut.print(gioloc?.state?:'NA')
printHtmlPart(61)
invokeTag('hiddenField','g',340,['name':("loctraderName"),'value':(gioloc?.traderName)],-1)
printHtmlPart(46)
expressionOut.print(gioloc?.traderName?:'NA')
printHtmlPart(59)
invokeTag('hiddenField','g',344,['name':("loctraderContactDetails"),'value':(gioloc?.traderContactDetails?:'NA')],-1)
printHtmlPart(46)
expressionOut.print(gioloc?.traderContactDetails?:'NA')
printHtmlPart(62)
invokeTag('textField','g',350,['name':("locRmk"),'class':("remark"),'value':(formRemkInstance?.locationRmk)],-1)
printHtmlPart(63)
j++
}
}
printHtmlPart(64)
i++
}
}
printHtmlPart(52)
}
printHtmlPart(65)
expressionOut.print(formDetails?.nature)
printHtmlPart(66)
if(true && (formDetails?.nature != 'No')) {
printHtmlPart(67)
expressionOut.print(formDetails?.traditionalKnowledgeDesc)
printHtmlPart(16)
}
printHtmlPart(1)
invokeTag('textField','g',375,['class':("remark"),'name':("oralKnow"),'value':(formRemkInstance?.oralRemark)],-1)
printHtmlPart(68)
if(true && (formDetails?.locations)) {
printHtmlPart(6)
for( location in (formDetails?.locations) ) {
printHtmlPart(69)
expressionOut.print(location?.consentObtained)
printHtmlPart(70)
expressionOut.print(location?.village)
printHtmlPart(12)
expressionOut.print(location?.town)
printHtmlPart(12)
expressionOut.print(location?.district)
printHtmlPart(6)
}
printHtmlPart(14)
}
else {
printHtmlPart(71)
}
printHtmlPart(72)
invokeTag('textField','g',399,['class':("remark"),'name':("community"),'value':(formRemkInstance?.giolocCommunityRmk)],-1)
printHtmlPart(73)
if(true && (formDetails?.selfAuthorizedPerson)) {
printHtmlPart(74)
}
else if(true && (!formDetails?.selfAuthorizedPerson)) {
printHtmlPart(75)
if(true && (formRemkInstance?.checklistContacts)) {
printHtmlPart(16)
loop:{
int l = 0
for( cont in (formRemkInstance?.checklistContacts) ) {
printHtmlPart(76)
expressionOut.print(l+1)
printHtmlPart(77)
expressionOut.print(cont?.contName)
printHtmlPart(77)
expressionOut.print(cont?.contAdd)
printHtmlPart(77)
expressionOut.print(cont?.contMobile)
printHtmlPart(77)
expressionOut.print(cont?.contEmail)
printHtmlPart(77)
expressionOut.print(cont?.contRemk)
printHtmlPart(78)
l++
}
}
printHtmlPart(16)
}
else {
printHtmlPart(12)
loop:{
int x = 0
for( contPerson in (formDetails?.contactPersons) ) {
printHtmlPart(79)
expressionOut.print(x+1)
printHtmlPart(80)
expressionOut.print(contPerson?.nameOfContactPerson)
printHtmlPart(44)
invokeTag('hiddenField','g',441,['name':("contName"),'value':(contPerson?.nameOfContactPerson)],-1)
printHtmlPart(80)
expressionOut.print(contPerson?.addressOfContactPerson)
printHtmlPart(44)
invokeTag('hiddenField','g',445,['name':("contAdd"),'value':(contPerson?.addressOfContactPerson)],-1)
printHtmlPart(80)
expressionOut.print(contPerson?.mobileOfContactPerson)
printHtmlPart(44)
invokeTag('hiddenField','g',449,['name':("contMobile"),'value':(contPerson?.mobileOfContactPerson)],-1)
printHtmlPart(80)
expressionOut.print(contPerson?.emailOfContactPerson)
printHtmlPart(44)
invokeTag('hiddenField','g',453,['name':("contEmail"),'value':(contPerson?.emailOfContactPerson)],-1)
printHtmlPart(81)
invokeTag('textField','g',458,['class':("remark"),'name':("personsAuth"),'value':(formRemkInstance?.nameAuthByApplicantRmk)],-1)
printHtmlPart(82)
x++
}
}
printHtmlPart(6)
}
printHtmlPart(83)
}
printHtmlPart(84)
expressionOut.print(formDetails?.purposeOfProposal)
printHtmlPart(85)
invokeTag('textField','g',476,['class':("remark"),'name':("proposed"),'value':(formRemkInstance?.assoKnowledgeRmk)],-1)
printHtmlPart(86)
expressionOut.print(formDetails?.briefDescription)
printHtmlPart(87)
invokeTag('textField','g',489,['class':("remark"),'name':("nbaApprovalRmk"),'value':(formRemkInstance?.nbaApprovalRmk)],-1)
printHtmlPart(88)
createClosureForHtmlPart(89, 1)
invokeTag('link','g',496,['controller':("checklist"),'action':("getNtcData"),'target':("_blank"),'params':([csrfPreventionSalt:csrfPreventionSalt])],1)
printHtmlPart(90)
if(true && (rare)) {
printHtmlPart(6)
loop:{
int i = 0
for( ntc in (rare) ) {
printHtmlPart(91)
expressionOut.print(i+1)
printHtmlPart(92)
expressionOut.print(ntc?.bio_resource)
printHtmlPart(92)
expressionOut.print(ntc?.status)
printHtmlPart(92)
expressionOut.print(ntc?.part)
printHtmlPart(92)
invokeTag('textField','g',514,['name':("ntc"),'class':("remark"),'value':(formRemkInstance?.listedInRmk)],-1)
printHtmlPart(93)
i++
}
}
printHtmlPart(6)
}
else {
printHtmlPart(94)
invokeTag('textField','g',519,['name':("ntc"),'class':("remark"),'value':(formRemkInstance?.listedInRmk)],-1)
printHtmlPart(93)
}
printHtmlPart(95)
if(true && (formDetails?.instituteParticipation == true)) {
printHtmlPart(96)
expressionOut.print(formetails?.detailsOfInstitute)
printHtmlPart(14)
}
else {
printHtmlPart(21)
}
printHtmlPart(97)
invokeTag('textField','g',538,['class':("remark"),'name':("resAndDev"),'value':(formRemkInstance?.dtsOfNationalInstRmk)],-1)
printHtmlPart(98)
if(true && (formDetails?.instituteParticipation == 'true')) {
printHtmlPart(99)
expressionOut.print(formDetails?.detailsOfInstitute)
printHtmlPart(100)
expressionOut.print(formDetails?.letterOfIntentName)
printHtmlPart(14)
}
else {
printHtmlPart(101)
}
printHtmlPart(102)
invokeTag('textField','g',559,['class':("remark"),'name':("carriedOut"),'value':(formRemkInstance?.researchActivitiesRmk)],-1)
printHtmlPart(103)
if(true && (formRemkInstance?.benefitSharing == '' || formRemkInstance?.benefitSharing == null)) {
printHtmlPart(104)
invokeTag('radio','g',569,['value':("true"),'name':("benefitShr")],-1)
printHtmlPart(105)
invokeTag('radio','g',570,['value':("false"),'name':("benefitShr")],-1)
printHtmlPart(106)
}
else if(true && (formRemkInstance?.benefitSharing == true)) {
printHtmlPart(104)
invokeTag('radio','g',574,['value':("true"),'checked':("true"),'name':("benefitShr")],-1)
printHtmlPart(30)
invokeTag('radio','g',575,['value':("false"),'name':("benefitShr")],-1)
printHtmlPart(107)
}
else if(true && (formRemkInstance?.benefitSharing == false)) {
printHtmlPart(104)
invokeTag('radio','g',579,['value':("true"),'name':("benefitShr")],-1)
printHtmlPart(105)
invokeTag('radio','g',580,['value':("false"),'name':("benefitShr"),'checked':("true")],-1)
printHtmlPart(108)
}
printHtmlPart(109)
invokeTag('textField','g',584,['class':("remark"),'name':("bfsh"),'value':(formRemkInstance?.benefitSharingRmk)],-1)
printHtmlPart(110)
if(true && (formRemkInstance?.technicalInformation == '' || formRemkInstance?.technicalInformation == null)) {
printHtmlPart(29)
invokeTag('radio','g',593,['value':("true"),'name':("reqTechInfo")],-1)
printHtmlPart(111)
invokeTag('radio','g',594,['value':("false"),'name':("reqTechInfo")],-1)
printHtmlPart(32)
}
else if(true && (formRemkInstance?.technicalInformation == true)) {
printHtmlPart(29)
invokeTag('radio','g',598,['value':("true"),'checked':("true"),'name':("reqTechInfo")],-1)
printHtmlPart(112)
invokeTag('radio','g',599,['value':("false"),'name':("reqTechInfo")],-1)
printHtmlPart(113)
}
else if(true && (formRemkInstance?.technicalInformation == false)) {
printHtmlPart(29)
invokeTag('radio','g',603,['value':("true"),'name':("reqTechInfo")],-1)
printHtmlPart(111)
invokeTag('radio','g',604,['value':("false"),'checked':("true"),'name':("reqTechInfo")],-1)
printHtmlPart(31)
}
printHtmlPart(114)
invokeTag('textField','g',607,['class':("remark"),'name':("techInfo"),'value':(formRemkInstance?.technicalInformationRmk)],-1)
printHtmlPart(115)
expressionOut.print(formRemkInstance?.sbbBmc)
printHtmlPart(116)
if(true && (formRemkInstance?.sbbBmc == '' || formRemkInstance?.sbbBmc == null)) {
printHtmlPart(29)
invokeTag('radio','g',616,['value':("true"),'name':("sbbMbs"),'onclick':("locationSelect(this)")],-1)
printHtmlPart(111)
invokeTag('radio','g',617,['value':("false"),'name':("sbbMbs"),'onclick':("locationSelect(this)")],-1)
printHtmlPart(32)
}
else if(true && (formRemkInstance?.sbbBmc == true)) {
printHtmlPart(29)
invokeTag('radio','g',623,['value':("true"),'checked':("true"),'name':("sbbMbs"),'onclick':("locationSelect(this)")],-1)
printHtmlPart(112)
invokeTag('radio','g',624,['value':("false"),'name':("sbbMbs"),'onclick':("locationSelect(this)")],-1)
printHtmlPart(31)
}
else if(true && (formRemkInstance?.sbbBmc == false)) {
printHtmlPart(29)
invokeTag('radio','g',627,['value':("true"),'name':("sbbMbs"),'onclick':("locationSelect(this)")],-1)
printHtmlPart(111)
invokeTag('radio','g',628,['checked':("true"),'value':("false"),'name':("sbbMbs"),'onclick':("locationSelect(this)")],-1)
printHtmlPart(31)
}
printHtmlPart(114)
invokeTag('textField','g',631,['class':("remark"),'name':("sbb"),'value':(formRemkInstance?.sbbBmcRmk)],-1)
printHtmlPart(117)
invokeTag('select','g',646,['name':("gioState"),'id':("mySelect"),'open multiple class':("form-control"),'from':(listOfStates),'optionKey':("state"),'optionValue':({it.state}),'value':(formRemkInstance?.gioLocation)],-1)
printHtmlPart(118)
loop:{
int i = 0
for( a in (formRemkInstance?.gioLocation) ) {
printHtmlPart(119)
expressionOut.print(a)
printHtmlPart(120)
i++
}
}
printHtmlPart(121)
invokeTag('textArea','g',666,['style':("width: 100%; display:none;"),'class':("form-control"),'name':("ques"),'value':(formRemkInstance?.question)],-1)
printHtmlPart(122)
if(true && (formRemkInstance == null || formRemkInstance == '')) {
printHtmlPart(123)
}
else {
printHtmlPart(124)
}
printHtmlPart(125)
if(true && (formRemkInstance != null || formRemkInstance != '')) {
printHtmlPart(126)
loop:{
int k = 0
for( quesAnswer in (formRemkInstance?.questionAnswers) ) {
printHtmlPart(127)
expressionOut.print(k+1)
printHtmlPart(128)
expressionOut.print(k+1)
printHtmlPart(129)
expressionOut.print(k+24)
printHtmlPart(130)
invokeTag('textArea','g',680,['name':("quesValues${k+1}"),'id':("qut${k+1}"),'value':(quesAnswer?.question),'rows':("3"),'cols':("45")],-1)
printHtmlPart(131)
invokeTag('textArea','g',683,['name':("ansValues${k+1}"),'id':("qes${k+1}"),'value':(quesAnswer?.answer),'rows':("3"),'cols':("45")],-1)
printHtmlPart(132)
expressionOut.print(k+1)
printHtmlPart(133)
expressionOut.print(quesAnswer?.id)
printHtmlPart(134)
expressionOut.print(k+1)
printHtmlPart(133)
expressionOut.print(quesAnswer?.id)
printHtmlPart(135)
k++
}
}
printHtmlPart(126)
}
printHtmlPart(136)
invokeTag('textArea','g',688,['name':("quesValues"),'class':("ques"),'style':("width:100%")],-1)
printHtmlPart(137)
invokeTag('textArea','g',689,['name':("ansValues"),'class':("ans"),'style':("width:100%")],-1)
printHtmlPart(138)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1669364611869L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
