import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_NBA_checklist_form3Review_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/checklist/_form3Review.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
expressionOut.print(formDetails?.appNumber)
printHtmlPart(1)
invokeTag('textField','g',20,['name':("appnumber"),'class':("remark"),'value':(formRemkInstance?.onlineAppNumberRmk)],-1)
printHtmlPart(2)
invokeTag('textField','g',27,['name':("refNumber"),'class':("remark"),'value':(formRemkInstance?.nbaRefNumber)],-1)
printHtmlPart(3)
invokeTag('textField','g',29,['name':("nbaRefNumberRemark"),'class':("remark"),'value':(formRemkInstance?.nbaRefNumberRemark)],-1)
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
invokeTag('textField','g',48,['name':("appltcatg"),'class':("remark"),'value':(formRemkInstance?.applicantCatgRmk)],-1)
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
printHtmlPart(13)
expressionOut.print(individualProfile?.address1)
printHtmlPart(13)
expressionOut.print(individualProfile?.address2)
printHtmlPart(13)
expressionOut.print(individualProfile?.address3)
printHtmlPart(13)
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
printHtmlPart(13)
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
printHtmlPart(14)
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
printHtmlPart(14)
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
printHtmlPart(14)
}
printHtmlPart(3)
invokeTag('textField','g',104,['name':("appltname"),'class':("remark"),'value':(formRemkInstance?.applicantNameContRmk)],-1)
printHtmlPart(15)
if(true && (formDetails?.companyProfiles)) {
printHtmlPart(16)
for( contactPersonDitals in (formDetails?.companyProfiles) ) {
printHtmlPart(16)
expressionOut.print(contactPersonDitals?.title)
printHtmlPart(17)
expressionOut.print(contactPersonDitals?.firstName)
printHtmlPart(17)
expressionOut.print(contactPersonDitals?.middleName)
printHtmlPart(17)
expressionOut.print(contactPersonDitals?.lastName)
printHtmlPart(18)
expressionOut.print(contactPersonDitals?.designation)
printHtmlPart(19)
expressionOut.print(contactPersonDitals?.personMobile)
printHtmlPart(20)
expressionOut.print(contactPersonDitals?.personEmail)
printHtmlPart(21)
}
printHtmlPart(22)
}
else {
printHtmlPart(23)
}
printHtmlPart(24)
invokeTag('textField','g',125,['name':("nameandComp"),'class':("remark"),'value':(formRemkInstance?.authPersonContRmk)],-1)
printHtmlPart(25)
if(true && (formDetails?.agentProfile)) {
printHtmlPart(14)
expressionOut.print(formDetails?.agentProfile?.title)
printHtmlPart(26)
expressionOut.print(formDetails?.agentProfile?.firstName)
printHtmlPart(14)
expressionOut.print(formDetails?.agentProfile?.middleName)
printHtmlPart(26)
expressionOut.print(formDetails?.agentProfile?.lastName)
printHtmlPart(27)
expressionOut.print(formDetails?.agentProfile?.address1)
printHtmlPart(26)
expressionOut.print(formDetails?.agentProfile?.address2)
printHtmlPart(14)
expressionOut.print(formDetails?.agentProfile?.address3)
printHtmlPart(28)
expressionOut.print(formDetails?.agentProfile?.city)
printHtmlPart(14)
}
else {
printHtmlPart(23)
}
printHtmlPart(29)
invokeTag('textField','g',144,['name':("agent"),'class':("remark"),'value':(formRemkInstance?.attorneyInIndiaContRmk)],-1)
printHtmlPart(30)
invokeTag('textField','g',155,['name':("formCatg"),'class':("remark"),'value':(formRemkInstance?.appFormCatgRmk)],-1)
printHtmlPart(31)
if(true && (formRemkInstance?.idAndAddress == true)) {
printHtmlPart(32)
invokeTag('radio','g',163,['name':("whrIdProofMtc"),'value':("true"),'checked':("true"),'id':("wheatherYes")],-1)
printHtmlPart(33)
invokeTag('radio','g',163,['name':("whrIdProofMtc"),'value':("false"),'id':("wheatherNo")],-1)
printHtmlPart(34)
}
else if(true && (formRemkInstance?.idAndAddress == false)) {
printHtmlPart(35)
invokeTag('radio','g',166,['name':("whrIdProofMtc"),'value':("true"),'id':("wheatherYes")],-1)
printHtmlPart(33)
invokeTag('radio','g',166,['name':("whrIdProofMtc"),'checked':("true"),'value':("false"),'id':("wheatherNo")],-1)
printHtmlPart(36)
}
else if(true && (formRemkInstance?.idAndAddress == '' || formRemkInstance?.idAndAddress == null)) {
printHtmlPart(37)
invokeTag('radio','g',170,['name':("whrIdProofMtc"),'value':("true"),'id':("wheatherYes")],-1)
printHtmlPart(33)
invokeTag('radio','g',170,['name':("whrIdProofMtc"),'value':("false"),'id':("wheatherNo")],-1)
printHtmlPart(36)
}
printHtmlPart(38)
invokeTag('textField','g',174,['name':("whrIdProof"),'class':("remark"),'value':(formRemkInstance?.idAndAddressRemark)],-1)
printHtmlPart(39)
if(true && (formRemkInstance?.checklistBioresorces)) {
printHtmlPart(6)
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
printHtmlPart(42)
expressionOut.print(bioRemarks?.bioRemarks)
printHtmlPart(43)
j++
}
}
printHtmlPart(6)
}
else if(true && (formDetails?.biologicalResources)) {
printHtmlPart(44)
loop:{
int i = 0
for( resource in (formDetails?.biologicalResources) ) {
printHtmlPart(45)
expressionOut.print(i+1)
printHtmlPart(46)
invokeTag('hiddenField','g',214,['name':("chkname"),'value':(resource?.accessIntention?:'NA')],-1)
printHtmlPart(47)
expressionOut.print(resource?.accessIntention?:'NA')
printHtmlPart(48)
invokeTag('hiddenField','g',218,['name':("chkcommonName"),'value':(resource?.commonName?:'NA')],-1)
printHtmlPart(49)
expressionOut.print(resource?.commonName?:'NA')
printHtmlPart(46)
invokeTag('hiddenField','g',222,['name':("chkscientificName"),'value':(resource?.scientificName?:'NA')],-1)
printHtmlPart(49)
expressionOut.print(resource?.scientificName?:'NA')
printHtmlPart(46)
invokeTag('hiddenField','g',226,['name':("chknature"),'value':(resource?.nature?:'NA')],-1)
printHtmlPart(49)
expressionOut.print(resource?.nature?:'NA')
printHtmlPart(46)
invokeTag('hiddenField','g',230,['name':("chkbiologicalResource"),'value':(resource?.biologicalResource?:'NA')],-1)
printHtmlPart(47)
expressionOut.print(resource?.biologicalResource?:'NA')
printHtmlPart(50)
invokeTag('textField','g',235,['name':("resremk"),'class':("remark"),'value':(formRemkInstance?.biologicalResRmk)],-1)
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
printHtmlPart(42)
expressionOut.print(location?.locationRemark)
printHtmlPart(54)
k++
}
}
printHtmlPart(6)
}
else if(true && (formDetails?.biologicalResources?.locations)) {
printHtmlPart(44)
loop:{
int i = 0
for( giolocation in (formDetails?.biologicalResources?.locations) ) {
printHtmlPart(47)
loop:{
int j = 0
for( gioloc in (giolocation) ) {
printHtmlPart(55)
expressionOut.print(i+1)
printHtmlPart(56)
invokeTag('hiddenField','g',285,['name':("locscientificName"),'value':(gioloc?.bioResource?.scientificName?:'NA')],-1)
printHtmlPart(57)
expressionOut.print(gioloc?.bioResource?.scientificName?:'NA')
printHtmlPart(58)
invokeTag('hiddenField','g',289,['name':("locsource"),'value':(gioloc?.source?:'NA')],-1)
printHtmlPart(57)
expressionOut.print(gioloc?.source?:'NA')
printHtmlPart(58)
invokeTag('hiddenField','g',293,['name':("locvillage"),'value':(gioloc?.village?:'NA')],-1)
printHtmlPart(49)
expressionOut.print(gioloc?.village?:'NA')
printHtmlPart(58)
invokeTag('hiddenField','g',297,['name':("loctown"),'value':(gioloc?.town?:'NA')],-1)
printHtmlPart(49)
expressionOut.print(gioloc?.town?:'NA')
printHtmlPart(59)
invokeTag('hiddenField','g',301,['name':("locdistrict"),'value':(gioloc?.district?:'NA')],-1)
printHtmlPart(49)
expressionOut.print(gioloc?.district?:'NA')
printHtmlPart(59)
invokeTag('hiddenField','g',305,['name':("locstate"),'value':(gioloc?.state?:'NA')],-1)
printHtmlPart(49)
expressionOut.print(gioloc?.state?:'NA')
printHtmlPart(60)
invokeTag('hiddenField','g',308,['name':("loctraderName"),'value':(gioloc?.traderName)],-1)
printHtmlPart(49)
expressionOut.print(gioloc?.traderName?:'NA')
printHtmlPart(58)
invokeTag('hiddenField','g',312,['name':("loctraderContactDetails"),'value':(gioloc?.traderContactDetails?:'NA')],-1)
printHtmlPart(49)
expressionOut.print(gioloc?.traderContactDetails?:'NA')
printHtmlPart(61)
invokeTag('textField','g',318,['name':("locRmk"),'class':("remark"),'value':(formRemkInstance?.locationRmk)],-1)
printHtmlPart(62)
j++
}
}
printHtmlPart(63)
i++
}
}
printHtmlPart(64)
}
printHtmlPart(65)
createClosureForHtmlPart(66, 1)
invokeTag('link','g',335,['controller':("checklist"),'action':("getNtcData"),'target':("_blank"),'params':([csrfPreventionSalt:csrfPreventionSalt])],1)
printHtmlPart(67)
if(true && (rare)) {
printHtmlPart(6)
loop:{
int i = 0
for( ntc in (rare) ) {
printHtmlPart(68)
expressionOut.print(i+1)
printHtmlPart(69)
expressionOut.print(ntc?.bio_resource)
printHtmlPart(69)
expressionOut.print(ntc?.status)
printHtmlPart(69)
expressionOut.print(ntc?.part)
printHtmlPart(69)
invokeTag('textField','g',352,['name':("ntc"),'class':("remark"),'value':(formRemkInstance?.listedInRmk)],-1)
printHtmlPart(70)
i++
}
}
printHtmlPart(6)
}
else {
printHtmlPart(71)
invokeTag('textField','g',358,['name':("ntc"),'class':("remark"),'value':(formRemkInstance?.listedInRmk)],-1)
printHtmlPart(70)
}
printHtmlPart(72)
expressionOut.print(formDetails?.detailsOfInstitute)
printHtmlPart(3)
invokeTag('textField','g',370,['name':("instOrganisation"),'class':("remark"),'value':(formRemkInstance?.instOrganisation)],-1)
printHtmlPart(73)
expressionOut.print(formDetails?.benefitsToTheApplicant)
printHtmlPart(3)
invokeTag('textField','g',381,['name':("commTheInvention"),'class':("remark"),'value':(formRemkInstance?.commTheInvention)],-1)
printHtmlPart(74)
if(true && (formRemkInstance?.technicalInformation == '' || formRemkInstance?.technicalInformation == null)) {
printHtmlPart(75)
invokeTag('radio','g',391,['value':("true"),'name':("reqTechInfo")],-1)
printHtmlPart(76)
invokeTag('radio','g',391,['value':("false"),'name':("reqTechInfo")],-1)
printHtmlPart(77)
}
else if(true && (formRemkInstance?.technicalInformation == true)) {
printHtmlPart(75)
invokeTag('radio','g',395,['value':("true"),'checked':("true"),'name':("reqTechInfo")],-1)
printHtmlPart(76)
invokeTag('radio','g',395,['value':("false"),'name':("reqTechInfo")],-1)
printHtmlPart(78)
}
else if(true && (formRemkInstance?.technicalInformation == false)) {
printHtmlPart(75)
invokeTag('radio','g',398,['value':("true"),'name':("reqTechInfo")],-1)
printHtmlPart(76)
invokeTag('radio','g',398,['value':("false"),'checked':("true"),'name':("reqTechInfo")],-1)
printHtmlPart(78)
}
printHtmlPart(79)
invokeTag('textField','g',402,['name':("techInfo"),'class':("remark"),'value':(formRemkInstance?.technicalInformationRmk)],-1)
printHtmlPart(80)
expressionOut.print(formRemkInstance?.sbbBmc)
printHtmlPart(81)
if(true && (formRemkInstance?.sbbBmc == '' || formRemkInstance?.sbbBmc == null)) {
printHtmlPart(82)
invokeTag('radio','g',411,['value':("true"),'name':("sbbMbs"),'onclick':("locationSelect(this)")],-1)
printHtmlPart(83)
invokeTag('radio','g',412,['value':("false"),'name':("sbbMbs"),'onclick':("locationSelect(this)")],-1)
printHtmlPart(84)
}
else if(true && (formRemkInstance?.sbbBmc == true)) {
printHtmlPart(82)
invokeTag('radio','g',418,['value':("true"),'checked':("true"),'name':("sbbMbs"),'onclick':("locationSelect(this)")],-1)
printHtmlPart(76)
invokeTag('radio','g',418,['value':("false"),'name':("sbbMbs"),'onclick':("locationSelect(this)")],-1)
printHtmlPart(34)
}
else if(true && (formRemkInstance?.sbbBmc == false)) {
printHtmlPart(82)
invokeTag('radio','g',422,['value':("true"),'name':("sbbMbs"),'onclick':("locationSelect(this)")],-1)
printHtmlPart(83)
invokeTag('radio','g',423,['checked':("true"),'value':("false"),'name':("sbbMbs"),'onclick':("locationSelect(this)")],-1)
printHtmlPart(34)
}
printHtmlPart(85)
invokeTag('textField','g',426,['class':("remark"),'name':("sbb"),'value':(formRemkInstance?.sbbBmcRmk)],-1)
printHtmlPart(86)
invokeTag('select','g',441,['name':("gioState"),'id':("mySelect"),'open multiple class':("form-control"),'from':(listOfStates),'optionKey':("state"),'optionValue':({it.state}),'value':(formRemkInstance?.gioLocation)],-1)
printHtmlPart(87)
loop:{
int i = 0
for( a in (formRemkInstance?.gioLocation) ) {
printHtmlPart(88)
expressionOut.print(a)
printHtmlPart(89)
i++
}
}
printHtmlPart(90)
invokeTag('textArea','g',458,['style':("width: 100%;  display:none;"),'class':("form-control"),'name':("ques"),'value':(formRemkInstance?.question)],-1)
printHtmlPart(91)
if(true && (formRemkInstance == null || formRemkInstance == '')) {
printHtmlPart(92)
}
else {
printHtmlPart(93)
}
printHtmlPart(94)
if(true && (formRemkInstance != null || formRemkInstance != '')) {
printHtmlPart(95)
loop:{
int k = 0
for( quesAnswer in (formRemkInstance?.questionAnswers) ) {
printHtmlPart(96)
expressionOut.print(k+1)
printHtmlPart(97)
expressionOut.print(k+1)
printHtmlPart(98)
expressionOut.print(k+18)
printHtmlPart(99)
invokeTag('textArea','g',472,['name':("quesValues${k+1}"),'id':("qut${k+1}"),'value':(quesAnswer?.question),'rows':("3"),'cols':("45")],-1)
printHtmlPart(100)
invokeTag('textArea','g',473,['name':("ansValues${k+1}"),'id':("qes${k+1}"),'value':(quesAnswer?.answer),'rows':("3"),'cols':("45")],-1)
printHtmlPart(101)
expressionOut.print(k+1)
printHtmlPart(102)
expressionOut.print(quesAnswer?.id)
printHtmlPart(103)
expressionOut.print(k+1)
printHtmlPart(102)
expressionOut.print(quesAnswer?.id)
printHtmlPart(104)
k++
}
}
printHtmlPart(105)
}
printHtmlPart(106)
invokeTag('textArea','g',479,['name':("quesValues"),'class':("ques"),'style':("width:100%")],-1)
printHtmlPart(107)
invokeTag('textArea','g',484,['name':("ansValues"),'class':("ans"),'style':("width:100%")],-1)
printHtmlPart(108)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1669364586719L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
