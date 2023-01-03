
import org.nba.common.State

import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_NBA_formPreviewpreviewFormBInfo_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/formPreview/previewFormBInfo.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
expressionOut.print(appForm?.appNumber)
printHtmlPart(1)
expressionOut.print(appForm?.submittedOn)
printHtmlPart(2)
if(true && (listOfIndianResearcher)) {
printHtmlPart(3)

int num= 1

printHtmlPart(4)

char alph = 65

printHtmlPart(4)
for( profile in (listOfIndianResearcher) ) {
printHtmlPart(5)
expressionOut.print(alph)
printHtmlPart(6)
expressionOut.print(num)
printHtmlPart(7)

num++

printHtmlPart(8)

alph++

printHtmlPart(9)
expressionOut.print(profile?.title)
printHtmlPart(10)
expressionOut.print(profile?.firstName)
printHtmlPart(10)
expressionOut.print(profile?.middleName)
printHtmlPart(10)
expressionOut.print(profile?.lastName)
printHtmlPart(11)
expressionOut.print(profile?.nationality)
printHtmlPart(12)
expressionOut.print(profile?.address1)
printHtmlPart(13)
expressionOut.print(profile?.address2)
printHtmlPart(10)
expressionOut.print(profile?.address3)
printHtmlPart(10)
expressionOut.print(profile?.city)
printHtmlPart(14)
expressionOut.print(profile?.pincode)
printHtmlPart(13)
expressionOut.print(profile?.province)
printHtmlPart(10)
expressionOut.print(profile?.country?.country)
printHtmlPart(15)
expressionOut.print(profile?.mobile)
printHtmlPart(16)
expressionOut.print(profile?.phone)
printHtmlPart(17)
expressionOut.print(profile?.email)
printHtmlPart(18)
if(true && (profile.samePresentAddress == 'No')) {
printHtmlPart(19)
expressionOut.print(profile?.presentAddress1)
printHtmlPart(13)
expressionOut.print(profile?.presentAddress2)
printHtmlPart(10)
expressionOut.print(profile?.presentAddress3)
expressionOut.print(profile?.presentCity)
printHtmlPart(20)
expressionOut.print(profile?.presentPincode)
printHtmlPart(13)
expressionOut.print(profile?.presentProvince)
printHtmlPart(10)
expressionOut.print(profile?.presentCountry?.country)
printHtmlPart(21)
expressionOut.print(profile?.presentMobile)
printHtmlPart(22)
expressionOut.print(profile?.presentPhone)
printHtmlPart(23)
}
else if(true && (profile?.samePresentAddress == 'Yes')) {
printHtmlPart(24)
expressionOut.print(profile?.address1)
printHtmlPart(13)
expressionOut.print(profile?.address2)
printHtmlPart(10)
expressionOut.print(profile?.address3)
printHtmlPart(10)
expressionOut.print(profile?.city)
printHtmlPart(25)
expressionOut.print(profile?.pincode)
printHtmlPart(13)
expressionOut.print(profile?.province)
printHtmlPart(10)
expressionOut.print(profile?.country?.country)
printHtmlPart(21)
expressionOut.print(profile?.mobile)
printHtmlPart(22)
expressionOut.print(profile?.phone)
printHtmlPart(26)
}
printHtmlPart(27)
if(true && (profile.addressproofLetterFileName != null)) {
printHtmlPart(28)
expressionOut.print(profile?.addressproofNo)
printHtmlPart(29)
expressionOut.print(profile?.addressproofSelect)
printHtmlPart(30)
createClosureForHtmlPart(31, 4)
invokeTag('link','g',155,['controller':("applicationManagement"),'action':("showUndertakingFile"),'id':(profile?.id),'target':("_blank"),'params':([filename: "addressproofLetter",appFormId:"${appForm?.id}",csrfPreventionSalt:"${csrfPreventionSalt}"])],4)
printHtmlPart(32)
}
printHtmlPart(4)
}
printHtmlPart(33)
}
printHtmlPart(34)
if(true && (listOfIndianGovtInst)) {
printHtmlPart(35)

int num= 1

printHtmlPart(36)

char alph = 65

printHtmlPart(36)
for( profile in (listOfIndianGovtInst) ) {
printHtmlPart(37)
expressionOut.print(alph)
printHtmlPart(38)
expressionOut.print(num)
printHtmlPart(39)

num++

printHtmlPart(40)

alph++

printHtmlPart(41)
expressionOut.print(profile?.govtInstName)
printHtmlPart(42)
expressionOut.print(profile?.address1)
printHtmlPart(13)
expressionOut.print(profile?.address2)
printHtmlPart(10)
expressionOut.print(profile?.address3)
printHtmlPart(43)
expressionOut.print(profile?.city)
printHtmlPart(10)
expressionOut.print(profile?.country?.country)
printHtmlPart(44)
expressionOut.print(profile?.phone)
printHtmlPart(45)
expressionOut.print(profile?.email)
printHtmlPart(46)
if(true && (profile.samePresentAddress == 'No')) {
printHtmlPart(47)
expressionOut.print(profile?.presentAddress1)
printHtmlPart(13)
expressionOut.print(profile?.presentAddress1)
printHtmlPart(10)
expressionOut.print(profile?.presentAddress1)
printHtmlPart(48)
expressionOut.print(profile?.presentCity)
printHtmlPart(10)
expressionOut.print(profile?.presentCountry?.country)
printHtmlPart(49)
expressionOut.print(profile?.presentPhone)
printHtmlPart(50)
}
printHtmlPart(51)
if(true && (profile.addressproofLetterFileName != null)) {
printHtmlPart(52)
expressionOut.print(profile?.addressproofSelect)
printHtmlPart(53)
expressionOut.print(profile?.addressproofNo)
printHtmlPart(54)
createTagBody(4, {->
printHtmlPart(55)
expressionOut.print(profile?.addressproofLetterFileName)
printHtmlPart(56)
})
invokeTag('link','g',267,['controller':("applicationManagement"),'action':("showIndividualDc"),'id':(profile?.id),'target':("_blank"),'params':([addressproofLetter:addressproofLetter,csrfPreventionSalt:"${csrfPreventionSalt}"])],4)
printHtmlPart(57)
}
printHtmlPart(36)
}
printHtmlPart(58)
}
printHtmlPart(59)
expressionOut.print(entity1?.name)
printHtmlPart(60)
expressionOut.print(entity1?.address1)
printHtmlPart(13)
expressionOut.print(entity1?.address2)
printHtmlPart(10)
expressionOut.print(entity1?.address3)
printHtmlPart(10)
expressionOut.print(entity1?.city)
printHtmlPart(61)
expressionOut.print(entity1?.pincode)
printHtmlPart(13)
expressionOut.print(entity1?.state)
printHtmlPart(10)
expressionOut.print(entity1?.country)
printHtmlPart(16)
expressionOut.print(entity1?.phone)
printHtmlPart(62)
expressionOut.print(entity1?.fax)
printHtmlPart(17)
expressionOut.print(entity1?.email)
printHtmlPart(63)

num= 1

printHtmlPart(4)

alph = 65

printHtmlPart(64)
if(true && (entity2?.name || entity2?.supervisorDesignation)) {
printHtmlPart(65)
expressionOut.print(entity2?.name)
printHtmlPart(66)
expressionOut.print(entity2?.supervisorDesignation)
printHtmlPart(67)
}
else if(true && (entity2?.headOfInstName || entity2?.headOfInstDesignation)) {
printHtmlPart(68)
expressionOut.print(entity2?.headOfInstName)
printHtmlPart(69)
expressionOut.print(entity2?.headOfInstDesignation)
printHtmlPart(67)
}
printHtmlPart(70)
expressionOut.print(entity2?.address1)
printHtmlPart(13)
expressionOut.print(entity2?.address2)
printHtmlPart(10)
expressionOut.print(entity2?.address3)
printHtmlPart(10)
expressionOut.print(entity2?.city)
printHtmlPart(71)
expressionOut.print(entity2?.pincode)
printHtmlPart(13)
expressionOut.print(entity2?.state)
printHtmlPart(10)
expressionOut.print(entity2?.country)
printHtmlPart(72)
expressionOut.print(entity2?.phone)
printHtmlPart(73)
expressionOut.print(entity2?.email)
printHtmlPart(74)

num= 1

printHtmlPart(4)

alph = 65

printHtmlPart(75)
if(true && (entity3?.contactDetailsOfInstOrOrganization == 'whoShallGuideOutsideIndia')) {
printHtmlPart(76)
}
else if(true && (entity3?.contactDetailsOfInstOrOrganization == 'whoShallRcvTheBioResource')) {
printHtmlPart(77)
}
printHtmlPart(78)
expressionOut.print(entity3?.name)
printHtmlPart(60)
expressionOut.print(entity3?.address1)
printHtmlPart(13)
expressionOut.print(entity3?.address2)
printHtmlPart(10)
expressionOut.print(entity3?.address3)
printHtmlPart(10)
expressionOut.print(entity3?.city)
printHtmlPart(79)
expressionOut.print(entity3?.pincode)
printHtmlPart(80)
expressionOut.print(entity3?.state)
printHtmlPart(10)
expressionOut.print(entity3?.country)
printHtmlPart(16)
expressionOut.print(entity3?.phone)
printHtmlPart(17)
expressionOut.print(entity3?.email)
printHtmlPart(81)

num= 1

printHtmlPart(4)

alph = 65

printHtmlPart(82)
if(true && (entity4?.category == 'contactDetails1')) {
printHtmlPart(83)
}
else if(true && (entity4?.category == 'contactDetails2')) {
printHtmlPart(84)
}
else if(true && (entity4?.category == 'contactDetails3')) {
printHtmlPart(85)
}
printHtmlPart(86)
expressionOut.print(entity4?.name)
printHtmlPart(60)
expressionOut.print(entity4?.address1)
printHtmlPart(13)
expressionOut.print(entity4?.address2)
printHtmlPart(10)
expressionOut.print(entity4?.address3)
printHtmlPart(87)
expressionOut.print(entity4?.city)
printHtmlPart(10)
expressionOut.print(entity4?.state)
printHtmlPart(10)
expressionOut.print(entity4?.country)
printHtmlPart(15)
expressionOut.print(entity4?.mobile)
printHtmlPart(16)
expressionOut.print(entity4?.phone)
printHtmlPart(17)
expressionOut.print(entity4?.email)
printHtmlPart(88)

num= 1

printHtmlPart(4)

alph = 65

printHtmlPart(89)
if(true && (listOfFundingAgency)) {
printHtmlPart(90)

int i=1

printHtmlPart(90)
for( agency in (listOfFundingAgency) ) {
printHtmlPart(91)
out.print(i)
printHtmlPart(92)

i++

printHtmlPart(93)
expressionOut.print(agency?.institutionOrganizationName)
printHtmlPart(94)
expressionOut.print(agency?.address1)
printHtmlPart(13)
expressionOut.print(agency?.address2)
printHtmlPart(10)
expressionOut.print(agency?.address3)
printHtmlPart(10)
expressionOut.print(agency?.city)
printHtmlPart(95)
expressionOut.print(agency?.state)
printHtmlPart(13)
expressionOut.print(agency?.country?.country)
printHtmlPart(96)
expressionOut.print(agency?.phone)
printHtmlPart(97)
expressionOut.print(agency?.email)
printHtmlPart(98)
createTagBody(3, {->
printHtmlPart(99)
expressionOut.print(agency?.sanctionOrderMoUcopyFileName)
printHtmlPart(100)
})
invokeTag('link','g',572,['controller':("applicationManagement"),'action':("showUndertakingFile"),'id':(agency?.id),'target':("_blank"),'params':([filename: "sanctionOrderMoUcopy",appFormId:"${appForm?.id}",csrfPreventionSalt:"${csrfPreventionSalt}"])],3)
printHtmlPart(101)
}
printHtmlPart(102)
}
else {
printHtmlPart(103)
}
printHtmlPart(104)

num= 1

printHtmlPart(4)

alph = 65

printHtmlPart(105)
expressionOut.print(appForm?.briefDescription)
printHtmlPart(106)

num= 1

printHtmlPart(4)

alph = 65

printHtmlPart(107)
if(true && (formType == 'Form1' || formType == 'FormB')) {
printHtmlPart(108)
}
printHtmlPart(109)
if(true && (listOfBioResources)) {
printHtmlPart(90)

int i=1

printHtmlPart(90)
for( bioResource in (listOfBioResources) ) {
printHtmlPart(91)
out.print(i)
printHtmlPart(92)

i++

printHtmlPart(93)
expressionOut.print(bioResource?.accessIntention)
printHtmlPart(110)
if(true && (bioResource?.accessIntention == 'Carried along for the research' || bioResource?.accessIntention == 'Sent for the Research')) {
printHtmlPart(111)
expressionOut.print(bioResource?.commonName)
printHtmlPart(112)
expressionOut.print(bioResource?.scientificName)
printHtmlPart(112)
expressionOut.print(bioResource?.nature)
printHtmlPart(112)
expressionOut.print(bioResource?.biologicalResource)
printHtmlPart(112)
expressionOut.print(bioResource?.quantity)
printHtmlPart(10)
expressionOut.print(bioResource?.qtyUnit)
printHtmlPart(113)
}
else {
printHtmlPart(114)
}
printHtmlPart(115)
}
printHtmlPart(102)
}
else {
printHtmlPart(116)
}
printHtmlPart(117)

num= 1

printHtmlPart(4)

alph = 65

printHtmlPart(118)
expressionOut.print(appForm?.researchDurationFrom?.format('dd/MM/yyyy'))
printHtmlPart(119)
expressionOut.print(appForm?.researchDurationTo?.format('dd/MM/yyyy'))
printHtmlPart(120)
if(true && (appForm?.typeOfExercise == 'multipleTime')) {
printHtmlPart(121)
}
else {
printHtmlPart(122)
}
printHtmlPart(123)
if(true && (appForm?.typeOfExercise == 'multipleTime')) {
printHtmlPart(124)
expressionOut.print(appForm?.numOfTimesOfSending)
printHtmlPart(125)
expressionOut.print(appForm?.reasonsForSending)
printHtmlPart(126)
}
printHtmlPart(127)

num= 1

printHtmlPart(4)

alph = 65

printHtmlPart(128)
if(true && (listOfLocations)) {
printHtmlPart(40)

int i=1

printHtmlPart(40)
for( location in (listOfLocations) ) {
printHtmlPart(129)
out.print(i)
printHtmlPart(130)

i++

printHtmlPart(131)
expressionOut.print(location?.bioResource?.scientificName)
printHtmlPart(132)
expressionOut.print(location?.source)
printHtmlPart(133)
if(true && (location?.village)) {
printHtmlPart(55)
expressionOut.print(location?.village)
printHtmlPart(56)
}
else {
printHtmlPart(134)
}
printHtmlPart(135)
if(true && (location?.town)) {
printHtmlPart(136)
expressionOut.print(location?.town)
printHtmlPart(56)
}
else {
printHtmlPart(134)
}
printHtmlPart(137)
if(true && (location?.district)) {
printHtmlPart(55)
expressionOut.print(location?.district)
printHtmlPart(56)
}
else {
printHtmlPart(134)
}
printHtmlPart(137)
if(true && (location?.state)) {
printHtmlPart(136)
expressionOut.print(location?.state)
printHtmlPart(56)
}
else {
printHtmlPart(134)
}
printHtmlPart(137)
if(true && (location?.traderName)) {
printHtmlPart(55)
expressionOut.print(location?.traderName)
printHtmlPart(56)
}
else {
printHtmlPart(134)
}
printHtmlPart(137)
if(true && (location?.traderContactDetails)) {
printHtmlPart(136)
expressionOut.print(location?.traderContactDetails)
printHtmlPart(56)
}
else {
printHtmlPart(134)
}
printHtmlPart(138)
}
printHtmlPart(102)
}
else {
printHtmlPart(139)
}
printHtmlPart(140)

num= 1

printHtmlPart(4)

alph = 65

printHtmlPart(105)
expressionOut.print(appForm?.emergencyDetails)
printHtmlPart(141)
createTagBody(1, {->
printHtmlPart(90)
expressionOut.print(appForm?.undertakingCopyFileName)
printHtmlPart(102)
})
invokeTag('link','g',934,['controller':("applicationManagement"),'action':("showUndertakingFile"),'id':(appForm?.id),'target':("_blank"),'params':([filename: "undertakingCopy", dataName: "undertakingCopy",csrfPreventionSalt:"${csrfPreventionSalt}"])],1)
printHtmlPart(142)
createTagBody(1, {->
printHtmlPart(90)
expressionOut.print(appForm?.declarationByApplicantOnNationalityCopyFileName)
printHtmlPart(102)
})
invokeTag('link','g',961,['controller':("applicationManagement"),'action':("showUndertakingFile"),'id':(appForm?.id),'target':("_blank"),'params':([filename: "declarationByApplicantOnNationalityCopy", dataName: "declarationByApplicantOnNationalityCopy",csrfPreventionSalt:"${csrfPreventionSalt}"])],1)
printHtmlPart(143)
createTagBody(1, {->
printHtmlPart(90)
expressionOut.print(appForm?.declarationBySupervisorCopyFileName)
printHtmlPart(102)
})
invokeTag('link','g',978,['controller':("applicationManagement"),'action':("showUndertakingFile"),'id':(appForm?.id),'target':("_blank"),'params':([filename: "declarationBySupervisorCopy", dataName: "declarationBySupervisorCopy",csrfPreventionSalt:"${csrfPreventionSalt}"])],1)
printHtmlPart(144)
createTagBody(1, {->
printHtmlPart(90)
expressionOut.print(appForm?.declarationByRecipientCopyFileName)
printHtmlPart(102)
})
invokeTag('link','g',995,['controller':("applicationManagement"),'action':("showUndertakingFile"),'id':(appForm?.id),'target':("_blank"),'params':([filename: "declarationByRecipientCopy", dataName: "declarationByRecipientCopy",csrfPreventionSalt:"${csrfPreventionSalt}"])],1)
printHtmlPart(145)
createClosureForHtmlPart(146, 1)
invokeTag('link','g',1011,['controller':("formPreview"),'class':("btn btn-primary"),'action':("printCompleteProjectB"),'target':("_blank"),'params':([id:appForm?.id,csrfPreventionSalt:"${csrfPreventionSalt}"])],1)
printHtmlPart(10)
createClosureForHtmlPart(147, 1)
invokeTag('link','g',1013,['controller':("PDF"),'class':("btn btn-primary"),'action':("index"),'params':([projectId:appForm?.id,formBid:"${entity5?.id}",csrfPreventionSalt:"${csrfPreventionSalt}"])],1)
printHtmlPart(148)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1604013914000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
