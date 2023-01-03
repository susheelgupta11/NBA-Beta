import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_NBA_checklist_form4Review_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/checklist/_form4Review.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
if(true && (formRemkInstance?.serialNo == false)) {
printHtmlPart(0)
createClosureForHtmlPart(1, 2)
invokeTag('javascript','g',4,[:],2)
printHtmlPart(0)
}
printHtmlPart(2)
expressionOut.print(formDetails?.appNumber)
printHtmlPart(3)
invokeTag('textField','g',28,['name':("appnumber"),'class':("remark"),'value':(formRemkInstance?.onlineAppNumberRmk)],-1)
printHtmlPart(4)
invokeTag('textField','g',35,['name':("refNumber"),'class':("remark"),'value':(formRemkInstance?.nbaRefNumber)],-1)
printHtmlPart(5)
invokeTag('textField','g',37,['name':("nbaRefNumberRemark"),'class':("remark"),'value':(formRemkInstance?.nbaRefNumberRemark)],-1)
printHtmlPart(6)
if(true && (formDetails?.individualProfiles)) {
printHtmlPart(7)
}
else if(true && (formDetails?.companyProfiles)) {
printHtmlPart(8)
}
else if(true && (formDetails?.indianGovtInst)) {
printHtmlPart(9)
}
else if(true && (formDetails?.depostionOfMicroOrganism)) {
}
printHtmlPart(5)
invokeTag('textField','g',49,['name':("appltcatg"),'class':("remark"),'value':(formRemkInstance?.applicantCatgRmk)],-1)
printHtmlPart(10)
if(true && (formDetails?.individualProfiles)) {
printHtmlPart(11)
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
printHtmlPart(11)
}
printHtmlPart(14)
}
else if(true && (formDetails?.companyProfiles)) {
printHtmlPart(11)
loop:{
int k = 0
for( company in (formDetails?.companyProfiles) ) {
printHtmlPart(13)
expressionOut.print(company?.entityName)
printHtmlPart(11)
k++
}
}
printHtmlPart(14)
}
else if(true && (formDetails?.indianResearcher)) {
printHtmlPart(11)
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
printHtmlPart(11)
}
printHtmlPart(14)
}
else if(true && (formDetails?.depostionOfMicroOrganism)) {
printHtmlPart(11)
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
printHtmlPart(11)
}
printHtmlPart(14)
}
else if(true && (formDetails?.indianGovtInst)) {
printHtmlPart(11)
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
printHtmlPart(11)
}
printHtmlPart(14)
}
printHtmlPart(5)
invokeTag('textField','g',105,['name':("appltname"),'class':("remark"),'value':(formRemkInstance?.applicantNameContRmk)],-1)
printHtmlPart(15)
if(true && (formDetails?.companyProfiles)) {
printHtmlPart(16)
expressionOut.print(formDetails?.companyProfiles?.title)
printHtmlPart(17)
expressionOut.print(formDetails?.companyProfiles?.firstName)
printHtmlPart(17)
expressionOut.print(formDetails?.companyProfiles?.middleName)
printHtmlPart(17)
expressionOut.print(formDetails?.companyProfiles?.lastName)
printHtmlPart(18)
expressionOut.print(formDetails?.companyProfiles?.designation)
printHtmlPart(19)
expressionOut.print(formDetails?.companyProfiles?.personMobile)
printHtmlPart(20)
expressionOut.print(formDetails?.companyProfiles?.personEmail)
printHtmlPart(21)
}
else {
printHtmlPart(22)
}
printHtmlPart(23)
invokeTag('textField','g',126,['name':("nameandComp"),'class':("remark"),'value':(formRemkInstance?.authPersonContRmk)],-1)
printHtmlPart(24)
if(true && (formDetails?.agentProfile)) {
printHtmlPart(25)
expressionOut.print(formDetails?.agentProfile?.title)
printHtmlPart(26)
expressionOut.print(formDetails?.agentProfile?.firstName)
printHtmlPart(14)
expressionOut.print(formDetails?.agentProfile?.middleName)
printHtmlPart(26)
expressionOut.print(formDetails?.agentProfile?.lastName)
printHtmlPart(14)
expressionOut.print(formDetails?.agentProfile?.address1)
printHtmlPart(26)
expressionOut.print(formDetails?.agentProfile?.address2)
printHtmlPart(14)
expressionOut.print(formDetails?.agentProfile?.address3)
printHtmlPart(26)
expressionOut.print(formDetails?.agentProfile?.city)
printHtmlPart(16)
}
else {
printHtmlPart(27)
}
printHtmlPart(3)
invokeTag('textField','g',146,['name':("agent"),'class':("remark"),'value':(formRemkInstance?.attorneyInIndiaContRmk)],-1)
printHtmlPart(28)
invokeTag('textField','g',157,['name':("formCatg"),'class':("remark"),'value':(formRemkInstance?.appFormCatgRmk)],-1)
printHtmlPart(29)
if(true && (formRemkInstance?.idAndAddress == '' || formRemkInstance?.idAndAddress == null)) {
printHtmlPart(30)
invokeTag('radio','g',165,['name':("whrIdProofMtc"),'value':("true")],-1)
printHtmlPart(31)
invokeTag('radio','g',165,['name':("whrIdProofMtc"),'value':("false")],-1)
printHtmlPart(32)
}
else if(true && (formRemkInstance?.idAndAddress == true)) {
printHtmlPart(33)
invokeTag('radio','g',168,['name':("whrIdProofMtc"),'value':("true"),'checked':("true")],-1)
printHtmlPart(31)
invokeTag('radio','g',168,['name':("whrIdProofMtc"),'value':("false")],-1)
printHtmlPart(32)
}
else if(true && (formRemkInstance?.idAndAddress == false)) {
printHtmlPart(33)
invokeTag('radio','g',172,['name':("whrIdProofMtc"),'value':("true")],-1)
printHtmlPart(31)
invokeTag('radio','g',172,['name':("whrIdProofMtc"),'value':("false"),'checked':("true")],-1)
printHtmlPart(32)
}
printHtmlPart(34)
invokeTag('textField','g',177,['name':("whrIdProof"),'class':("remark"),'value':(formRemkInstance?.idAndAddressRemark)],-1)
printHtmlPart(35)
if(true && (formRemkInstance?.serialNo == '' || formRemkInstance?.serialNo == null)) {
printHtmlPart(36)
invokeTag('radio','g',185,['name':("serialNo"),'onclick':("hideSerialBox()"),'value':("true")],-1)
printHtmlPart(37)
invokeTag('radio','g',185,['onclick':("showSerialBox()"),'name':("serialNo"),'value':("false")],-1)
printHtmlPart(38)
}
else if(true && (formRemkInstance?.serialNo == true)) {
printHtmlPart(39)
invokeTag('radio','g',188,['name':("serialNo"),'onclick':("hideSerialBox()"),'value':("true"),'checked':("true")],-1)
printHtmlPart(37)
invokeTag('radio','g',188,['onclick':("showSerialBox()"),'name':("serialNo"),'value':("false")],-1)
printHtmlPart(38)
}
else if(true && (formRemkInstance?.serialNo == false)) {
printHtmlPart(39)
invokeTag('radio','g',191,['name':("serialNo"),'onclick':("hideSerialBox()"),'value':("true")],-1)
printHtmlPart(37)
invokeTag('radio','g',191,['onclick':("showSerialBox()"),'name':("serialNo"),'value':("false"),'checked':("true")],-1)
printHtmlPart(38)
}
printHtmlPart(40)
invokeTag('textArea','g',195,['name':("serialNumRemk"),'class':("remark"),'id':("serialRemk"),'style':("display: none;"),'value':(formRemkInstance?.serialNumRemk)],-1)
printHtmlPart(41)
if(true && (formRemkInstance?.checklistBioresorces)) {
printHtmlPart(11)
loop:{
int j = 0
for( bioRemarks in (formRemkInstance?.checklistBioresorces) ) {
printHtmlPart(42)
expressionOut.print(j+1)
printHtmlPart(43)
expressionOut.print(bioRemarks?.chkname)
printHtmlPart(43)
expressionOut.print(bioRemarks?.chkcommonName)
printHtmlPart(43)
expressionOut.print(bioRemarks?.chkscientificName)
printHtmlPart(43)
expressionOut.print(bioRemarks?.chknature)
printHtmlPart(43)
expressionOut.print(bioRemarks?.chkbiologicalResource)
printHtmlPart(44)
expressionOut.print(bioRemarks?.bioRemarks)
printHtmlPart(45)
j++
}
}
printHtmlPart(11)
}
else if(true && (formDetails?.biologicalResources)) {
printHtmlPart(46)
loop:{
int i = 0
for( resource in (formDetails?.biologicalResources) ) {
printHtmlPart(47)
expressionOut.print(i+1)
printHtmlPart(48)
invokeTag('hiddenField','g',234,['name':("chkname"),'value':(resource?.accessIntention?:'NA')],-1)
printHtmlPart(49)
expressionOut.print(resource?.accessIntention?:'NA')
printHtmlPart(50)
invokeTag('hiddenField','g',238,['name':("chkcommonName"),'value':(resource?.commonName?:'NA')],-1)
printHtmlPart(51)
expressionOut.print(resource?.commonName?:'NA')
printHtmlPart(48)
invokeTag('hiddenField','g',242,['name':("chkscientificName"),'value':(resource?.scientificName?:'NA')],-1)
printHtmlPart(51)
expressionOut.print(resource?.scientificName?:'NA')
printHtmlPart(48)
invokeTag('hiddenField','g',246,['name':("chknature"),'value':(resource?.nature?:'NA')],-1)
printHtmlPart(51)
expressionOut.print(resource?.nature?:'NA')
printHtmlPart(48)
invokeTag('hiddenField','g',250,['name':("chkbiologicalResource"),'value':(resource?.biologicalResource?:'NA')],-1)
printHtmlPart(49)
expressionOut.print(resource?.biologicalResource?:'NA')
printHtmlPart(52)
invokeTag('textField','g',254,['name':("resremk"),'class':("remark"),'value':(formRemkInstance?.biologicalResRmk)],-1)
printHtmlPart(53)
i++
}
}
printHtmlPart(54)
}
printHtmlPart(55)
if(true && (formRemkInstance?.attachedCopyCheck == '' || formRemkInstance?.attachedCopyCheck == null)) {
printHtmlPart(56)
invokeTag('radio','g',281,['name':("attachedCopyCheck"),'value':("true")],-1)
printHtmlPart(37)
invokeTag('radio','g',282,['name':("attachedCopyCheck"),'value':("false")],-1)
printHtmlPart(57)
}
else if(true && (formRemkInstance?.attachedCopyCheck == true)) {
printHtmlPart(56)
invokeTag('radio','g',285,['name':("attachedCopyCheck"),'checked':("true"),'value':("true")],-1)
printHtmlPart(37)
invokeTag('radio','g',285,['name':("attachedCopyCheck"),'value':("false")],-1)
printHtmlPart(57)
}
else if(true && (formRemkInstance?.attachedCopyCheck == false)) {
printHtmlPart(56)
invokeTag('radio','g',287,['name':("attachedCopyCheck"),'value':("true")],-1)
printHtmlPart(37)
invokeTag('radio','g',288,['name':("attachedCopyCheck"),'checked':("true"),'value':("false")],-1)
printHtmlPart(57)
}
printHtmlPart(58)
invokeTag('textField','g',291,['name':("attachedCopy"),'class':("remark"),'value':(formRemkInstance?.attachedCopy)],-1)
printHtmlPart(59)
expressionOut.print(formDetails?.appNumber)
printHtmlPart(60)
invokeTag('formatDate','g',301,['format':("dd/MM/yyyy"),'date':(formDetails?.dateOfApproval)],-1)
printHtmlPart(3)
invokeTag('textField','g',303,['name':("dateOfApprovl"),'class':("remark"),'value':(formRemkInstance?.dateOfApprovl)],-1)
printHtmlPart(61)
expressionOut.print(formDetails?.isbenefitSharingDetailImplemented)
printHtmlPart(62)
expressionOut.print(formDetails?.benefitMechanism)
printHtmlPart(5)
invokeTag('textField','g',317,['name':("benefitSharingAld"),'class':("remark"),'value':(formRemkInstance?.benefitSharingAld)],-1)
printHtmlPart(63)
if(true && (formDetails?.thirdParty)) {
printHtmlPart(11)
loop:{
int q = 0
for( thirdParty in (formDetails?.thirdParty) ) {
printHtmlPart(42)
expressionOut.print(q+1)
printHtmlPart(64)
expressionOut.print(thirdParty?.name)
printHtmlPart(65)
expressionOut.print(thirdParty?.addressForComm)
printHtmlPart(66)
expressionOut.print(thirdParty?.state)
printHtmlPart(67)
expressionOut.print(pincode)
printHtmlPart(68)
expressionOut.print(thirdParty?.country)
printHtmlPart(69)
expressionOut.print(thirdParty?.phone)
printHtmlPart(70)
expressionOut.print(thirdParty?.fax)
printHtmlPart(71)
expressionOut.print(thirdParty?.website)
printHtmlPart(72)
expressionOut.print(thirdParty?.email)
printHtmlPart(73)
invokeTag('textField','g',343,['name':("thirdParty"),'class':("remark"),'value':(formRemkInstance?.thirdParty)],-1)
printHtmlPart(74)
q++
}
}
printHtmlPart(11)
}
printHtmlPart(75)
expressionOut.print(formDetails?.thirdPartyTransferPurpose)
printHtmlPart(5)
invokeTag('textField','g',357,['name':("thirdPartyTransfer"),'class':("remark"),'value':(formRemkInstance?.thirdPartyTransfer)],-1)
printHtmlPart(76)
expressionOut.print(formDetails?.benefitsToTheThirdParty)
printHtmlPart(5)
invokeTag('textField','g',368,['name':("detailsOfEconomic"),'class':("remark"),'value':(formRemkInstance?.detailsOfEconomic)],-1)
printHtmlPart(77)
if(true && (formDetails?.isAgreementBwApplicantAndThirdParty== 'true')) {
printHtmlPart(78)
}
else if(true && (formDetails?.isAgreementBwApplicantAndThirdParty== 'false')) {
printHtmlPart(27)
}
printHtmlPart(79)
invokeTag('textField','g',390,['name':("detailsAnyAgreement"),'class':("remark"),'value':(formRemkInstance?.detailsAnyAgreement)],-1)
printHtmlPart(80)
if(true && (formDetails?.isAgreementBwApplicantAndThirdParty == 'true')) {
printHtmlPart(37)
}
else if(true && (formDetails?.isAgreementBwApplicantAndThirdParty == 'false')) {
printHtmlPart(22)
}
printHtmlPart(81)
invokeTag('textField','g',405,['name':("agreement"),'class':("remark"),'value':(formRemkInstance?.agreement)],-1)
printHtmlPart(82)
expressionOut.print(formDetails?.benefitsOutOfThirdPartyTransfer)
printHtmlPart(83)
expressionOut.print(formDetails?.mechanismOutOfThirdPartyTransfer)
printHtmlPart(84)
invokeTag('textField','g',426,['name':("proposedMechanism"),'class':("remark"),'value':(formRemkInstance?.proposedMechanism)],-1)
printHtmlPart(85)
expressionOut.print(formDetails?.otherRelevantInfo)
printHtmlPart(5)
invokeTag('textField','g',431,['name':("anyOther"),'class':("remark"),'value':(formRemkInstance?.anyOther)],-1)
printHtmlPart(86)
invokeTag('textArea','g',440,['style':("width: 100%;  display:none;"),'class':("form-control"),'name':("ques"),'value':(formRemkInstance?.question)],-1)
printHtmlPart(87)
if(true && (formRemkInstance == null || formRemkInstance == '')) {
printHtmlPart(88)
}
else {
printHtmlPart(89)
}
printHtmlPart(90)
if(true && (formRemkInstance != null || formRemkInstance != '')) {
printHtmlPart(0)
loop:{
int k = 0
for( quesAnswer in (formRemkInstance?.questionAnswers) ) {
printHtmlPart(91)
expressionOut.print(k+1)
printHtmlPart(92)
expressionOut.print(k+1)
printHtmlPart(93)
expressionOut.print(k+21)
printHtmlPart(94)
invokeTag('textArea','g',457,['name':("quesValues${k+1}"),'id':("qut${k+1}"),'value':(quesAnswer?.question),'rows':("3"),'cols':("40")],-1)
printHtmlPart(95)
invokeTag('textArea','g',459,['name':("ansValues${k+1}"),'id':("qes${k+1}"),'value':(quesAnswer?.answer),'rows':("3"),'cols':("40")],-1)
printHtmlPart(96)
expressionOut.print(k+1)
printHtmlPart(97)
expressionOut.print(quesAnswer?.id)
printHtmlPart(98)
expressionOut.print(k+1)
printHtmlPart(97)
expressionOut.print(quesAnswer?.id)
printHtmlPart(99)
k++
}
}
printHtmlPart(0)
}
printHtmlPart(100)
invokeTag('textArea','g',469,['name':("quesValues"),'class':("ques"),'style':("width:100%")],-1)
printHtmlPart(101)
invokeTag('textArea','g',472,['name':("ansValues"),'class':("ans"),'style':("width:100%")],-1)
printHtmlPart(102)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1645633213275L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
