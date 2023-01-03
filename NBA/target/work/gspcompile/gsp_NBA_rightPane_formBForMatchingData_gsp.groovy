
import org.nba.common.*

import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_NBA_rightPane_formBForMatchingData_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/rightPane/_formBForMatchingData.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)

char alpha = 65

printHtmlPart(1)
if(true && (allDataforMatching?.listOfIndianResearcher)) {
printHtmlPart(2)
loop:{
int i = 0
for( indianProfile in (allDataforMatching?.listOfIndianResearcher) ) {
printHtmlPart(3)
expressionOut.print(alpha)
printHtmlPart(4)
expressionOut.print(i+1)
printHtmlPart(5)
expressionOut.print(indianProfile?.title)
printHtmlPart(6)
expressionOut.print(indianProfile?.firstName)
printHtmlPart(6)
expressionOut.print(indianProfile?.middleName)
printHtmlPart(7)
expressionOut.print(indianProfile?.lastName)
printHtmlPart(8)
expressionOut.print(indianProfile?.nationality?:'Indian')
printHtmlPart(9)
expressionOut.print(indianProfile?.address1)
printHtmlPart(6)
expressionOut.print(indianProfile?.address2)
printHtmlPart(6)
expressionOut.print(indianProfile?.address3)
printHtmlPart(7)
expressionOut.print(indianProfile?.city)
printHtmlPart(6)
expressionOut.print(indianProfile?.pincode)
printHtmlPart(6)
expressionOut.print(indianProfile?.province)
printHtmlPart(10)
expressionOut.print(indianProfile?.country?.country)
printHtmlPart(11)
expressionOut.print(indianProfile?.mobile)
printHtmlPart(12)
expressionOut.print(indianProfile?.phone)
printHtmlPart(13)
expressionOut.print(indianProfile?.email)
printHtmlPart(14)
if(true && (indianProfile.samePresentAddress == 'No')) {
printHtmlPart(15)
expressionOut.print(indianProfile?.presentAddress1)
printHtmlPart(6)
expressionOut.print(indianProfile?.presentAddress2)
printHtmlPart(6)
expressionOut.print(indianProfile?.presentAddress3)
printHtmlPart(16)
expressionOut.print(indianProfile?.presentCity)
printHtmlPart(6)
expressionOut.print(indianProfile?.presentPincode)
printHtmlPart(6)
expressionOut.print(indianProfile?.presentProvince)
printHtmlPart(17)
expressionOut.print(indianProfile?.presentCountry?.country)
printHtmlPart(11)
expressionOut.print(indianProfile?.presentMobile)
printHtmlPart(18)
expressionOut.print(indianProfile?.presentPhone)
printHtmlPart(19)
}
else if(true && (indianProfile.samePresentAddress == 'Yes')) {
printHtmlPart(20)
expressionOut.print(indianProfile?.address1)
printHtmlPart(6)
expressionOut.print(indianProfile?.address2)
printHtmlPart(6)
expressionOut.print(indianProfile?.address3)
printHtmlPart(16)
expressionOut.print(indianProfile?.city)
printHtmlPart(6)
expressionOut.print(indianProfile?.pincode)
printHtmlPart(6)
expressionOut.print(indianProfile?.province)
printHtmlPart(17)
expressionOut.print(indianProfile?.country?.country)
printHtmlPart(11)
expressionOut.print(indianProfile?.mobile)
printHtmlPart(18)
expressionOut.print(indianProfile?.phone)
printHtmlPart(21)
expressionOut.print(indianProfile?.email)
printHtmlPart(22)
}
printHtmlPart(23)
if(true && (indianProfile?.addressproofLetterFileName != null)) {
printHtmlPart(24)
expressionOut.print(indianProfile?.addressproofNo)
printHtmlPart(25)
expressionOut.print(indianProfile?.addressproofSelect)
printHtmlPart(26)
createClosureForHtmlPart(27, 4)
invokeTag('link','g',97,['controller':("applicationManagement"),'action':("showUndertakingFile"),'id':(indianProfile?.id),'target':("_blank"),'params':([filename: "addressproofLetter",appFormId:"${formDetails?.id}",csrfPreventionSalt:"${csrfPreventionSalt}"])],4)
printHtmlPart(28)
}
printHtmlPart(2)
i++
}
}
printHtmlPart(0)
}
printHtmlPart(29)

char alpha1 = 65

printHtmlPart(0)
if(true && (allDataforMatching?.listOfIndianGovtInst)) {
printHtmlPart(2)
loop:{
int i = 0
for( govtProfile in (allDataforMatching?.listOfIndianGovtInst) ) {
printHtmlPart(30)
expressionOut.print(alpha1)
printHtmlPart(4)
expressionOut.print(i+1)
printHtmlPart(5)
expressionOut.print(govtProfile?.govtInstName)
printHtmlPart(31)
expressionOut.print(govtProfile?.address1)
printHtmlPart(6)
expressionOut.print(govtProfile?.address2)
printHtmlPart(6)
expressionOut.print(govtProfile?.address3)
printHtmlPart(7)
expressionOut.print(govtProfile?.city)
expressionOut.print(govtProfile?.country?.country)
printHtmlPart(32)
expressionOut.print(govtProfile?.phone)
printHtmlPart(13)
expressionOut.print(govtProfile?.email)
printHtmlPart(14)
if(true && (govtProfile.samePresentAddress == 'No')) {
printHtmlPart(33)
expressionOut.print(govtProfile?.presentAddress1)
printHtmlPart(6)
expressionOut.print(govtProfile?.presentAddress2)
printHtmlPart(6)
expressionOut.print(govtProfile?.presentAddress3)
printHtmlPart(16)
expressionOut.print(govtProfile?.presentCity)
printHtmlPart(16)
expressionOut.print(govtProfile?.presentCountry?.country)
printHtmlPart(34)
expressionOut.print(govtProfile?.presentPhone)
printHtmlPart(19)
}
printHtmlPart(35)
if(true && (govtProfile.addressproofLetterFileName != null)) {
printHtmlPart(36)
expressionOut.print(govtProfile?.addressproofSelect)
printHtmlPart(37)
expressionOut.print(govtProfile?.addressproofNo)
printHtmlPart(38)
createTagBody(4, {->
printHtmlPart(39)
expressionOut.print(govtProfile?.addressproofLetterFileName)
printHtmlPart(40)
})
invokeTag('link','g',175,['controller':("applicationManagement"),'action':("showIndividualDc"),'id':(profile?.id),'target':("_blank"),'params':([addressproofLetter:addressproofLetter,csrfPreventionSalt:"${csrfPreventionSalt}"])],4)
printHtmlPart(41)
}
printHtmlPart(2)
i++
}
}
printHtmlPart(0)
}
printHtmlPart(42)
expressionOut.print(allDataforMatching?.entity1?.name)
printHtmlPart(43)
expressionOut.print(allDataforMatching?.entity1?.address1)
printHtmlPart(44)
expressionOut.print(allDataforMatching?.entity1?.address2)
printHtmlPart(6)
expressionOut.print(allDataforMatching?.entity1?.address3)
printHtmlPart(6)
expressionOut.print(allDataforMatching?.entity1?.city)
printHtmlPart(45)
expressionOut.print(allDataforMatching?.entity1?.pincode)
printHtmlPart(44)
expressionOut.print(allDataforMatching?.entity1?.state)
printHtmlPart(6)
expressionOut.print(allDataforMatching?.entity1?.country)
printHtmlPart(46)
expressionOut.print(allDataforMatching?.entity1?.phone)
printHtmlPart(47)
expressionOut.print(allDataforMatching?.entity1?.fax)
printHtmlPart(48)
expressionOut.print(allDataforMatching?.entity1?.email)
printHtmlPart(49)
invokeTag('set','g',224,['var':("entity2"),'value':(allDataforMatching?.entity2)],-1)
printHtmlPart(50)

num= 1

printHtmlPart(51)

alph = 65

printHtmlPart(52)
if(true && (entity2?.name || entity2?.supervisorDesignation)) {
printHtmlPart(53)
expressionOut.print(entity2?.name)
printHtmlPart(54)
expressionOut.print(entity2?.supervisorDesignation)
printHtmlPart(55)
}
else if(true && (entity2?.headOfInstName || entity2?.headOfInstDesignation)) {
printHtmlPart(56)
expressionOut.print(entity2?.headOfInstName)
printHtmlPart(57)
expressionOut.print(entity2?.headOfInstDesignation)
printHtmlPart(55)
}
printHtmlPart(58)
expressionOut.print(entity2?.address1)
printHtmlPart(44)
expressionOut.print(entity2?.address2)
printHtmlPart(6)
expressionOut.print(entity2?.address3)
printHtmlPart(6)
expressionOut.print(entity2?.city)
printHtmlPart(59)
expressionOut.print(entity2?.pincode)
printHtmlPart(44)
expressionOut.print(entity2?.state)
printHtmlPart(6)
expressionOut.print(entity2?.country)
printHtmlPart(60)
expressionOut.print(entity2?.phone)
printHtmlPart(61)
expressionOut.print(entity2?.email)
printHtmlPart(62)
invokeTag('set','g',282,['var':("entity3"),'value':(allDataforMatching?.entity3)],-1)
printHtmlPart(63)

num= 1

printHtmlPart(51)

alph = 65

printHtmlPart(64)
if(true && (entity3?.contactDetailsOfInstOrOrganization == 'whoShallGuideOutsideIndia')) {
printHtmlPart(65)
}
else if(true && (entity3?.contactDetailsOfInstOrOrganization == 'whoShallRcvTheBioResource')) {
printHtmlPart(66)
}
printHtmlPart(67)
expressionOut.print(entity3?.name)
printHtmlPart(43)
expressionOut.print(entity3?.address1)
printHtmlPart(44)
expressionOut.print(entity3?.address2)
printHtmlPart(6)
expressionOut.print(entity3?.address3)
printHtmlPart(6)
expressionOut.print(entity3?.city)
printHtmlPart(68)
expressionOut.print(entity3?.pincode)
printHtmlPart(69)
expressionOut.print(entity3?.state)
printHtmlPart(6)
expressionOut.print(entity3?.country)
printHtmlPart(46)
expressionOut.print(entity3?.phone)
printHtmlPart(48)
expressionOut.print(entity3?.email)
printHtmlPart(70)
invokeTag('set','g',339,['var':("entity4"),'value':(allDataforMatching?.entity4)],-1)
printHtmlPart(71)

num= 1

printHtmlPart(51)

alph = 65

printHtmlPart(72)
if(true && (entity4?.category == 'contactDetails1')) {
printHtmlPart(73)
}
else if(true && (entity4?.category == 'contactDetails2')) {
printHtmlPart(74)
}
else if(true && (entity4?.category == 'contactDetails3')) {
printHtmlPart(75)
}
printHtmlPart(76)
expressionOut.print(entity4?.name)
printHtmlPart(43)
expressionOut.print(entity4?.address1)
printHtmlPart(44)
expressionOut.print(entity4?.address2)
printHtmlPart(6)
expressionOut.print(entity4?.address3)
printHtmlPart(77)
expressionOut.print(entity4?.city)
printHtmlPart(6)
expressionOut.print(entity4?.state)
printHtmlPart(6)
expressionOut.print(entity4?.country)
printHtmlPart(78)
expressionOut.print(entity4?.mobile)
printHtmlPart(46)
expressionOut.print(entity4?.phone)
printHtmlPart(48)
expressionOut.print(entity4?.email)
printHtmlPart(62)
invokeTag('set','g',405,['var':("listOfFundingAgency"),'value':(allDataforMatching?.listOfFundingAgency)],-1)
printHtmlPart(79)

num= 1

printHtmlPart(51)

alph = 65

printHtmlPart(80)
if(true && (listOfFundingAgency)) {
printHtmlPart(81)

int i=1

printHtmlPart(81)
for( agency in (listOfFundingAgency) ) {
printHtmlPart(82)
out.print(i)
printHtmlPart(83)

i++

printHtmlPart(84)
expressionOut.print(agency?.institutionOrganizationName)
printHtmlPart(85)
expressionOut.print(agency?.address1)
printHtmlPart(44)
expressionOut.print(agency?.address2)
printHtmlPart(6)
expressionOut.print(agency?.address3)
printHtmlPart(6)
expressionOut.print(agency?.city)
printHtmlPart(86)
expressionOut.print(agency?.state)
printHtmlPart(44)
expressionOut.print(agency?.country?.country)
printHtmlPart(87)
expressionOut.print(agency?.phone)
printHtmlPart(88)
expressionOut.print(agency?.email)
printHtmlPart(89)
createTagBody(3, {->
printHtmlPart(90)
expressionOut.print(agency?.sanctionOrderMoUcopyFileName)
printHtmlPart(91)
})
invokeTag('link','g',460,['controller':("applicationManagement"),'action':("showUndertakingFile"),'id':(agency?.id),'target':("_blank"),'params':([filename: "sanctionOrderMoUcopy",appFormId:"${formDetails?.id}",csrfPreventionSalt:"${csrfPreventionSalt}"])],3)
printHtmlPart(92)
}
printHtmlPart(93)
}
else {
printHtmlPart(94)
}
printHtmlPart(95)

num= 1

printHtmlPart(51)

alph = 65

printHtmlPart(96)
expressionOut.print(formDetails?.briefDescription)
printHtmlPart(97)
if(true && (formDetails?.biologicalResources)) {
printHtmlPart(98)

int i=1

printHtmlPart(93)
for( bioResource in (formDetails?.biologicalResources) ) {
printHtmlPart(99)
out.print(i)
printHtmlPart(100)

i++

printHtmlPart(101)
expressionOut.print(bioResource?.accessIntention)
printHtmlPart(102)
expressionOut.print(bioResource?.commonName)
printHtmlPart(103)
expressionOut.print(bioResource?.scientificName)
printHtmlPart(104)
expressionOut.print(bioResource?.nature)
printHtmlPart(103)
expressionOut.print(bioResource?.biologicalResource)
printHtmlPart(103)
expressionOut.print(bioResource?.quantity)
printHtmlPart(6)
expressionOut.print(bioResource?.qtyUnit)
printHtmlPart(105)
expressionOut.print(bioResource?.fromTime?.format('dd/MM/yyyy'))
printHtmlPart(106)
expressionOut.print(bioResource?.toTime?.format('dd/MM/yyyy'))
printHtmlPart(103)
expressionOut.print(bioResource?.traditionalUse)
printHtmlPart(107)
}
printHtmlPart(108)
}
printHtmlPart(109)

num= 1

printHtmlPart(51)

alph = 65

printHtmlPart(110)
expressionOut.print(formDetails?.researchDurationFrom?.format('dd/MM/yyyy'))
printHtmlPart(111)
expressionOut.print(formDetails?.researchDurationTo?.format('dd/MM/yyyy'))
printHtmlPart(112)
if(true && (formDetails?.typeOfExercise == 'multipleTime')) {
printHtmlPart(113)
}
else {
printHtmlPart(114)
}
printHtmlPart(115)
if(true && (formDetails?.typeOfExercise == 'multipleTime')) {
printHtmlPart(116)
expressionOut.print(formDetails?.numOfTimesOfSending)
printHtmlPart(117)
expressionOut.print(formDetails?.reasonsForSending)
printHtmlPart(118)
}
printHtmlPart(119)
if(true && (formDetails?.biologicalResources?.locations)) {
printHtmlPart(120)
if(true && (formDetails?.biologicalResources?.locations)) {
printHtmlPart(39)
loop:{
int l = 0
for( giolocation in (formDetails?.biologicalResources?.locations) ) {
printHtmlPart(121)
loop:{
int m = 0
for( gioloct in (giolocation) ) {
printHtmlPart(122)
loop:{
int n = 0
for( gioloc in (gioloct) ) {
printHtmlPart(123)
expressionOut.print(l+1)
printHtmlPart(124)
expressionOut.print(gioloc?.bioResource?.scientificName?:'NA')
printHtmlPart(125)
expressionOut.print(gioloc?.source?:'NA')
printHtmlPart(126)
expressionOut.print(gioloc?.village?:'NA')
printHtmlPart(127)
expressionOut.print(gioloc?.town?: 'NA')
printHtmlPart(127)
expressionOut.print(gioloc?.district?:'NA')
printHtmlPart(127)
expressionOut.print(gioloc?.state?:'NA')
printHtmlPart(127)
expressionOut.print(gioloc?.traderName?:'NA')
printHtmlPart(127)
expressionOut.print(gioloc?.traderContactDetails?:'NA')
printHtmlPart(128)
n++
}
}
printHtmlPart(121)
m++
}
}
printHtmlPart(39)
l++
}
}
printHtmlPart(40)
}
printHtmlPart(129)
}
printHtmlPart(130)

num= 1

printHtmlPart(51)

alph = 65

printHtmlPart(96)
expressionOut.print(formDetails?.emergencyDetails)
printHtmlPart(131)
createTagBody(1, {->
printHtmlPart(81)
expressionOut.print(formDetails?.undertakingCopyFileName)
printHtmlPart(93)
})
invokeTag('link','g',750,['controller':("applicationManagement"),'action':("showUndertakingFile"),'id':(formDetails?.id),'target':("_blank"),'params':([filename: "undertakingCopy", dataName: "undertakingCopy",csrfPreventionSalt:"${csrfPreventionSalt}"])],1)
printHtmlPart(132)
createTagBody(1, {->
printHtmlPart(81)
expressionOut.print(formDetails?.declarationByApplicantOnNationalityCopyFileName)
printHtmlPart(93)
})
invokeTag('link','g',772,['controller':("applicationManagement"),'action':("showUndertakingFile"),'id':(formDetails?.id),'target':("_blank"),'params':([filename: "declarationByApplicantOnNationalityCopy", dataName: "declarationByApplicantOnNationalityCopy",csrfPreventionSalt:"${csrfPreventionSalt}"])],1)
printHtmlPart(133)
createTagBody(1, {->
printHtmlPart(81)
expressionOut.print(formDetails?.declarationBySupervisorCopyFileName)
printHtmlPart(93)
})
invokeTag('link','g',789,['controller':("applicationManagement"),'action':("showUndertakingFile"),'id':(formDetails?.id),'target':("_blank"),'params':([filename: "declarationBySupervisorCopy", dataName: "declarationBySupervisorCopy",csrfPreventionSalt:"${csrfPreventionSalt}"])],1)
printHtmlPart(134)
createTagBody(1, {->
printHtmlPart(81)
expressionOut.print(formDetails?.declarationByRecipientCopyFileName)
printHtmlPart(93)
})
invokeTag('link','g',806,['controller':("applicationManagement"),'action':("showUndertakingFile"),'id':(formDetails?.id),'target':("_blank"),'params':([filename: "declarationByRecipientCopy", dataName: "declarationByRecipientCopy",csrfPreventionSalt:"${csrfPreventionSalt}"])],1)
printHtmlPart(135)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1645111070047L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
