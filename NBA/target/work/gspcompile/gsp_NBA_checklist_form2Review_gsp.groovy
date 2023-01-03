import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_NBA_checklist_form2Review_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/checklist/_form2Review.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
expressionOut.print(formDetails?.appNumber)
printHtmlPart(1)
invokeTag('textField','g',24,['name':("appnumber"),'class':("remark"),'value':(formRemkInstance?.onlineAppNumberRmk)],-1)
printHtmlPart(2)
invokeTag('textField','g',31,['name':("refNumber"),'class':("remark"),'value':(formRemkInstance?.nbaRefNumber)],-1)
printHtmlPart(3)
invokeTag('textField','g',33,['name':("nbaRefNumberRemark"),'class':("remark"),'value':(formRemkInstance?.nbaRefNumberRemark)],-1)
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
printHtmlPart(10)
invokeTag('textField','g',50,['name':("appltcatg"),'class':("remark"),'value':(formRemkInstance?.applicantCatgRmk)],-1)
printHtmlPart(11)
if(true && (formDetails?.individualProfiles)) {
printHtmlPart(6)
for( individualProfile in (formDetails?.individualProfiles) ) {
printHtmlPart(12)
expressionOut.print(individualProfile?.title)
printHtmlPart(13)
expressionOut.print(individualProfile?.firstName)
printHtmlPart(13)
expressionOut.print(individualProfile?.middleName)
printHtmlPart(13)
expressionOut.print(individualProfile?.lastName)
printHtmlPart(14)
expressionOut.print(individualProfile?.address1)
printHtmlPart(13)
expressionOut.print(individualProfile?.address2)
printHtmlPart(13)
expressionOut.print(individualProfile?.address3)
printHtmlPart(14)
expressionOut.print(individualProfile?.city)
printHtmlPart(6)
}
printHtmlPart(15)
}
else if(true && (formDetails?.companyProfiles)) {
printHtmlPart(6)
loop:{
int k = 0
for( company in (formDetails?.companyProfiles) ) {
printHtmlPart(13)
expressionOut.print(company?.entityName)
printHtmlPart(6)
k++
}
}
printHtmlPart(15)
}
else if(true && (formDetails?.indianResearcher)) {
printHtmlPart(6)
for( researcher in (formDetails?.indianResearcher) ) {
printHtmlPart(12)
expressionOut.print(researcher?.title)
printHtmlPart(13)
expressionOut.print(researcher?.firstName)
printHtmlPart(13)
expressionOut.print(researcher?.middleName)
printHtmlPart(13)
expressionOut.print(researcher?.lastName)
printHtmlPart(13)
expressionOut.print(researcher?.address1)
printHtmlPart(13)
expressionOut.print(researcher?.address2)
printHtmlPart(13)
expressionOut.print(researcher?.address3)
printHtmlPart(13)
expressionOut.print(researcher?.presentCity)
printHtmlPart(6)
}
printHtmlPart(15)
}
else if(true && (formDetails?.depostionOfMicroOrganism)) {
printHtmlPart(6)
for( depost in (formDetails?.depostionOfMicroOrganism) ) {
printHtmlPart(13)
expressionOut.print(depost?.nameOfDepositor)
printHtmlPart(13)
expressionOut.print(depost?.address1)
printHtmlPart(13)
expressionOut.print(depost?.address2)
printHtmlPart(13)
expressionOut.print(depost?.address3)
printHtmlPart(13)
expressionOut.print(depost?.city)
printHtmlPart(6)
}
printHtmlPart(15)
}
else if(true && (formDetails?.indianGovtInst)) {
printHtmlPart(6)
for( govt in (formDetails?.indianGovtInst) ) {
printHtmlPart(13)
expressionOut.print(govt?.govtInstName)
printHtmlPart(13)
expressionOut.print(govt?.address1)
printHtmlPart(13)
expressionOut.print(govt?.address2)
printHtmlPart(13)
expressionOut.print(govt?.address3)
printHtmlPart(13)
expressionOut.print(govt?.presentCity)
printHtmlPart(6)
}
printHtmlPart(15)
}
printHtmlPart(3)
invokeTag('textField','g',106,['name':("appltname"),'class':("remark"),'value':(formRemkInstance?.applicantNameContRmk)],-1)
printHtmlPart(16)
if(true && (formDetails?.companyProfiles)) {
printHtmlPart(17)
for( authPerson in (formDetails?.companyProfiles) ) {
printHtmlPart(6)
expressionOut.print(authPerson?.title)
printHtmlPart(6)
expressionOut.print(authPerson?.firstName)
printHtmlPart(6)
expressionOut.print(authPerson?.middleName)
printHtmlPart(6)
expressionOut.print(authPerson?.lastName)
printHtmlPart(18)
expressionOut.print(authPerson?.designation)
printHtmlPart(19)
expressionOut.print(authPerson?.personMobile)
printHtmlPart(20)
expressionOut.print(authPerson?.personEmail)
printHtmlPart(17)
}
printHtmlPart(15)
}
else {
printHtmlPart(21)
}
printHtmlPart(3)
invokeTag('textField','g',125,['name':("nameandComp"),'class':("remark"),'value':(formRemkInstance?.authPersonContRmk)],-1)
printHtmlPart(22)
if(true && (formDetails?.agentProfile)) {
printHtmlPart(23)
expressionOut.print(formDetails?.agentProfile?.title)
printHtmlPart(24)
expressionOut.print(formDetails?.agentProfile?.firstName)
printHtmlPart(15)
expressionOut.print(formDetails?.agentProfile?.middleName)
printHtmlPart(24)
expressionOut.print(formDetails?.agentProfile?.lastName)
printHtmlPart(25)
expressionOut.print(formDetails?.agentProfile?.address1)
printHtmlPart(24)
expressionOut.print(formDetails?.agentProfile?.address2)
printHtmlPart(15)
expressionOut.print(formDetails?.agentProfile?.address3)
printHtmlPart(26)
expressionOut.print(formDetails?.agentProfile?.city)
printHtmlPart(15)
}
else {
printHtmlPart(21)
}
printHtmlPart(27)
invokeTag('textField','g',144,['name':("agent"),'class':("remark"),'value':(formRemkInstance?.attorneyInIndiaContRmk)],-1)
printHtmlPart(28)
invokeTag('textField','g',153,['name':("formCatg"),'class':("remark"),'value':(formRemkInstance?.appFormCatgRmk)],-1)
printHtmlPart(29)
if(true && (formRemkInstance?.idAndAddress == true)) {
printHtmlPart(30)
invokeTag('radio','g',162,['name':("whrIdProofMtc"),'value':("true"),'checked':("true"),'id':("wheatherYes")],-1)
printHtmlPart(31)
invokeTag('radio','g',163,['name':("whrIdProofMtc"),'value':("false"),'id':("wheatherNo")],-1)
printHtmlPart(32)
}
else if(true && (formRemkInstance?.idAndAddress == false)) {
printHtmlPart(30)
invokeTag('radio','g',167,['name':("whrIdProofMtc"),'value':("true"),'id':("wheatherYes")],-1)
printHtmlPart(31)
invokeTag('radio','g',168,['name':("whrIdProofMtc"),'checked':("true"),'value':("false"),'id':("wheatherNo")],-1)
printHtmlPart(33)
}
else if(true && (formRemkInstance?.idAndAddress == '' || formRemkInstance?.idAndAddress == null)) {
printHtmlPart(34)
invokeTag('radio','g',174,['name':("whrIdProofMtc"),'value':("true"),'id':("wheatherYes")],-1)
printHtmlPart(31)
invokeTag('radio','g',175,['name':("whrIdProofMtc"),'value':("false"),'id':("wheatherNo")],-1)
printHtmlPart(32)
}
printHtmlPart(35)
invokeTag('textField','g',178,['name':("whrIdProof"),'class':("remark"),'value':(formRemkInstance?.idAndAddressRemark)],-1)
printHtmlPart(36)
expressionOut.print(formDetails?.briefDescription)
printHtmlPart(27)
invokeTag('textField','g',199,['name':("resConducted"),'class':("remark"),'value':(formRemkInstance?.resConducted)],-1)
printHtmlPart(37)
expressionOut.print(formDetails?.resultsOfResearch)
printHtmlPart(27)
invokeTag('textField','g',210,['name':("resOfReserch"),'class':("remark"),'value':(formRemkInstance?.resOfReserch)],-1)
printHtmlPart(38)
if(true && (formRemkInstance?.checklistBioresorces)) {
printHtmlPart(6)
loop:{
int j = 0
for( bioRemarks in (formRemkInstance?.checklistBioresorces) ) {
printHtmlPart(39)
expressionOut.print(j+1)
printHtmlPart(40)
expressionOut.print(bioRemarks?.chkname)
printHtmlPart(40)
expressionOut.print(bioRemarks?.chkcommonName)
printHtmlPart(40)
expressionOut.print(bioRemarks?.chkscientificName)
printHtmlPart(40)
expressionOut.print(bioRemarks?.chknature)
printHtmlPart(40)
expressionOut.print(bioRemarks?.chkbiologicalResource)
printHtmlPart(41)
expressionOut.print(bioRemarks?.bioRemarks)
printHtmlPart(42)
j++
}
}
printHtmlPart(6)
}
else if(true && (formDetails?.biologicalResources)) {
printHtmlPart(43)
loop:{
int i = 0
for( resource in (formDetails?.biologicalResources) ) {
printHtmlPart(44)
expressionOut.print(i+1)
printHtmlPart(45)
invokeTag('hiddenField','g',253,['name':("chkname"),'value':(resource?.accessIntention?:'NA')],-1)
printHtmlPart(46)
expressionOut.print(resource?.accessIntention?:'NA')
printHtmlPart(47)
invokeTag('hiddenField','g',257,['name':("chkcommonName"),'value':(resource?.commonName?:'NA')],-1)
printHtmlPart(48)
expressionOut.print(resource?.commonName?:'NA')
printHtmlPart(45)
invokeTag('hiddenField','g',259,['name':("chkscientificName"),'value':(resource?.scientificName?:'NA')],-1)
printHtmlPart(48)
expressionOut.print(resource?.scientificName?:'NA')
printHtmlPart(45)
invokeTag('hiddenField','g',263,['name':("chknature"),'value':(resource?.nature?:'NA')],-1)
printHtmlPart(48)
expressionOut.print(resource?.nature?:'NA')
printHtmlPart(45)
invokeTag('hiddenField','g',265,['name':("chkbiologicalResource"),'value':(resource?.biologicalResource?:'NA')],-1)
printHtmlPart(46)
expressionOut.print(resource?.biologicalResource?:'NA')
printHtmlPart(49)
invokeTag('textField','g',269,['name':("resremk"),'class':("remark"),'value':(formRemkInstance?.biologicalResRmk)],-1)
printHtmlPart(50)
i++
}
}
printHtmlPart(51)
}
printHtmlPart(52)
if(true && (formRemkInstance?.checklistLocations)) {
printHtmlPart(6)
loop:{
int k = 0
for( location in (formRemkInstance?.checklistLocations) ) {
printHtmlPart(39)
expressionOut.print(k+1)
printHtmlPart(40)
expressionOut.print(location?.locscientificName)
printHtmlPart(40)
expressionOut.print(location?.locsource)
printHtmlPart(40)
expressionOut.print(location?.locvillage)
printHtmlPart(40)
expressionOut.print(location?.loctown)
printHtmlPart(40)
expressionOut.print(location?.locdistrict)
printHtmlPart(40)
expressionOut.print(location?.locstate)
printHtmlPart(40)
expressionOut.print(location?.loctraderName)
printHtmlPart(40)
expressionOut.print(location?.loctraderContactDetails)
printHtmlPart(41)
expressionOut.print(location?.locationRemark)
printHtmlPart(53)
k++
}
}
printHtmlPart(6)
}
else if(true && (formDetails?.biologicalResources?.locations)) {
printHtmlPart(43)
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
invokeTag('hiddenField','g',316,['name':("locscientificName"),'value':(gioloc?.bioResource?.scientificName?:'NA')],-1)
printHtmlPart(57)
expressionOut.print(gioloc?.bioResource?.scientificName?:'NA')
printHtmlPart(58)
invokeTag('hiddenField','g',322,['name':("locsource"),'value':(gioloc?.source?:'NA')],-1)
printHtmlPart(57)
expressionOut.print(gioloc?.source?:'NA')
printHtmlPart(58)
invokeTag('hiddenField','g',325,['name':("locvillage"),'value':(gioloc?.village?:'NA')],-1)
printHtmlPart(59)
expressionOut.print(gioloc?.village?:'NA')
printHtmlPart(58)
invokeTag('hiddenField','g',330,['name':("loctown"),'value':(gioloc?.town?:'NA')],-1)
printHtmlPart(59)
expressionOut.print(gioloc?.town?:'NA')
printHtmlPart(60)
invokeTag('hiddenField','g',331,['name':("locdistrict"),'value':(gioloc?.district?:'NA')],-1)
printHtmlPart(59)
expressionOut.print(gioloc?.district?:'NA')
printHtmlPart(60)
invokeTag('hiddenField','g',335,['name':("locstate"),'value':(gioloc?.state?:'NA')],-1)
printHtmlPart(59)
expressionOut.print(gioloc?.state?:'NA')
printHtmlPart(61)
invokeTag('hiddenField','g',339,['name':("loctraderName"),'value':(gioloc?.traderName)],-1)
printHtmlPart(59)
expressionOut.print(gioloc?.traderName?:'NA')
printHtmlPart(58)
invokeTag('hiddenField','g',345,['name':("loctraderContactDetails"),'value':(gioloc?.traderContactDetails?:'NA')],-1)
printHtmlPart(59)
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
printHtmlPart(65)
}
printHtmlPart(66)
if(true && (formDetails?.individualProfiles)) {
printHtmlPart(15)
expressionOut.print(formDetails?.nature)
printHtmlPart(67)
if(true && (formDetails?.nature != 'No')) {
printHtmlPart(68)
expressionOut.print(formDetails?.traditionalKnowledgeDesc)
printHtmlPart(15)
}
printHtmlPart(15)
}
printHtmlPart(15)
if(true && (formDetails?.companyProfiles)) {
printHtmlPart(15)
expressionOut.print(formDetails?.isNoForTraditional)
printHtmlPart(15)
if(true && (formDetails?.isNoForTraditional != 'No')) {
printHtmlPart(69)
expressionOut.print(formDetails?.traditionalKnowledgeDesc)
printHtmlPart(15)
}
printHtmlPart(70)
}
printHtmlPart(1)
invokeTag('textField','g',382,['name':("oralKnow"),'class':("remark"),'value':(formRemkInstance?.oralRemark)],-1)
printHtmlPart(71)
if(true && (formDetails?.locations)) {
printHtmlPart(6)
for( location in (formDetails?.locations) ) {
printHtmlPart(72)
expressionOut.print(location?.consentObtained)
printHtmlPart(73)
expressionOut.print(location?.village)
printHtmlPart(13)
expressionOut.print(location?.town)
printHtmlPart(13)
expressionOut.print(location?.district)
printHtmlPart(6)
}
printHtmlPart(15)
}
else {
printHtmlPart(21)
}
printHtmlPart(74)
invokeTag('textField','g',405,['name':("community"),'class':("remark"),'value':(formRemkInstance?.giolocCommunityRmk)],-1)
printHtmlPart(75)
if(true && (formDetails?.locations?.consentObtained != 'No')) {
printHtmlPart(6)
for( consent in (formDetails?.locations) ) {
printHtmlPart(6)
expressionOut.print(consent?.consentObtained)
printHtmlPart(76)
expressionOut.print(consent?.communityKnowledge)
printHtmlPart(13)
expressionOut.print(consent?.village)
printHtmlPart(13)
expressionOut.print(consent?.town)
printHtmlPart(13)
expressionOut.print(consent?.district)
printHtmlPart(13)
expressionOut.print(consent?.state)
printHtmlPart(6)
}
printHtmlPart(15)
}
printHtmlPart(77)
if(true && (formDetails?.isNoForTraditional == 'No')) {
printHtmlPart(78)
}
printHtmlPart(74)
invokeTag('textField','g',431,['class':("remark"),'name':("consObtained"),'value':(formRemkInstance?.consObtained)],-1)
printHtmlPart(79)
expressionOut.print(formDetails?.detailsOfInstitute)
printHtmlPart(27)
invokeTag('textField','g',457,['name':("instOrganisation"),'class':("remark"),'value':(formRemkInstance?.instOrganisation)],-1)
printHtmlPart(80)
expressionOut.print(formDetails?.detailsOfIndividualOrOrganisation)
printHtmlPart(81)
invokeTag('textField','g',484,['name':("individualOrg"),'class':("remark"),'value':(formRemkInstance?.individualOrg)],-1)
printHtmlPart(82)
expressionOut.print(formDetails?.useofResearchResults)
printHtmlPart(3)
invokeTag('textField','g',497,['name':("intendedUseOfResearch"),'class':("remark"),'value':(formRemkInstance?.intendedUseOfResearch)],-1)
printHtmlPart(83)
expressionOut.print(formDetails?.benefitsToTheIndividualOrOrganization)
printHtmlPart(3)
invokeTag('textField','g',508,['name':("biotechnological"),'class':("remark"),'value':(formRemkInstance?.biotechnological)],-1)
printHtmlPart(84)
expressionOut.print(formDetails?.benefitsToTheApplicant)
printHtmlPart(3)
invokeTag('textField','g',520,['name':("seekApproval"),'class':("remark"),'value':(formRemkInstance?.seekApproval)],-1)
printHtmlPart(85)
if(true && (formRemkInstance?.technicalInformation == '' || formRemkInstance?.technicalInformation == null)) {
printHtmlPart(34)
invokeTag('radio','g',529,['value':("true"),'name':("reqTechInfo")],-1)
printHtmlPart(86)
invokeTag('radio','g',530,['value':("false"),'name':("reqTechInfo")],-1)
printHtmlPart(33)
}
else if(true && (formRemkInstance?.technicalInformation == true)) {
printHtmlPart(34)
invokeTag('radio','g',535,['value':("true"),'checked':("true"),'name':("reqTechInfo")],-1)
printHtmlPart(87)
invokeTag('radio','g',535,['value':("false"),'name':("reqTechInfo")],-1)
printHtmlPart(88)
}
else if(true && (formRemkInstance?.technicalInformation == false)) {
printHtmlPart(34)
invokeTag('radio','g',539,['value':("true"),'name':("reqTechInfo")],-1)
printHtmlPart(86)
invokeTag('radio','g',539,['value':("false"),'checked':("true"),'name':("reqTechInfo")],-1)
printHtmlPart(32)
}
printHtmlPart(89)
expressionOut.print(formRemkInstance?.sbbBmc)
printHtmlPart(90)
if(true && (formRemkInstance?.sbbBmc == '' || formRemkInstance?.sbbBmc == null)) {
printHtmlPart(34)
invokeTag('radio','g',549,['value':("true"),'name':("sbbMbs"),'onclick':("locationSelect(this)")],-1)
printHtmlPart(86)
invokeTag('radio','g',551,['value':("false"),'name':("sbbMbs"),'onclick':("locationSelect(this)")],-1)
printHtmlPart(33)
}
else if(true && (formRemkInstance?.sbbBmc == true)) {
printHtmlPart(34)
invokeTag('radio','g',557,['value':("true"),'checked':("true"),'name':("sbbMbs"),'onclick':("locationSelect(this)")],-1)
printHtmlPart(87)
invokeTag('radio','g',558,['value':("false"),'name':("sbbMbs"),'onclick':("locationSelect(this)")],-1)
printHtmlPart(32)
}
else if(true && (formRemkInstance?.sbbBmc == false)) {
printHtmlPart(34)
invokeTag('radio','g',562,['value':("true"),'name':("sbbMbs"),'onclick':("locationSelect(this)")],-1)
printHtmlPart(86)
invokeTag('radio','g',563,['checked':("true"),'value':("false"),'name':("sbbMbs"),'onclick':("locationSelect(this)")],-1)
printHtmlPart(32)
}
printHtmlPart(91)
invokeTag('textField','g',567,['class':("remark"),'name':("sbb"),'value':(formRemkInstance?.sbbBmcRmk)],-1)
printHtmlPart(92)
invokeTag('select','g',574,['name':("gioState"),'id':("mySelect"),'open multiple class':("form-control"),'from':(listOfStates),'optionKey':("state"),'optionValue':({it.state}),'value':(formRemkInstance?.gioLocation)],-1)
printHtmlPart(93)
loop:{
int i = 0
for( a in (formRemkInstance?.gioLocation) ) {
printHtmlPart(94)
expressionOut.print(a)
printHtmlPart(95)
i++
}
}
printHtmlPart(96)
invokeTag('textArea','g',591,['style':("width: 100%;  display:none;"),'class':("form-control"),'name':("ques"),'value':(formRemkInstance?.question)],-1)
printHtmlPart(97)
if(true && (formRemkInstance == null || formRemkInstance == '')) {
printHtmlPart(98)
}
else {
printHtmlPart(99)
}
printHtmlPart(100)
if(true && (formRemkInstance != null || formRemkInstance != '')) {
printHtmlPart(17)
loop:{
int k = 0
for( quesAnswer in (formRemkInstance?.questionAnswers) ) {
printHtmlPart(101)
expressionOut.print(k+1)
printHtmlPart(102)
expressionOut.print(k+1)
printHtmlPart(103)
expressionOut.print(k+22)
printHtmlPart(104)
invokeTag('textArea','g',612,['name':("quesValues${k+1}"),'id':("qut${k+1}"),'value':(quesAnswer?.question),'rows':("3"),'cols':("40")],-1)
printHtmlPart(105)
invokeTag('textArea','g',613,['name':("ansValues${k+1}"),'id':("qes${k+1}"),'value':(quesAnswer?.answer),'rows':("3"),'cols':("40")],-1)
printHtmlPart(106)
expressionOut.print(k+1)
printHtmlPart(107)
expressionOut.print(quesAnswer?.id)
printHtmlPart(108)
expressionOut.print(k+1)
printHtmlPart(107)
expressionOut.print(quesAnswer?.id)
printHtmlPart(109)
k++
}
}
printHtmlPart(17)
}
printHtmlPart(110)
invokeTag('textArea','g',627,['name':("quesValues"),'class':("ques"),'style':("width:100%")],-1)
printHtmlPart(111)
invokeTag('textArea','g',628,['name':("ansValues"),'class':("ans"),'style':("width:100%")],-1)
printHtmlPart(112)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1669364600965L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
