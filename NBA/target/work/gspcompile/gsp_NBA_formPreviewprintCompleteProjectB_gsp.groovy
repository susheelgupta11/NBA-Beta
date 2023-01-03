
import org.nba.common.State

import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_NBA_formPreviewprintCompleteProjectB_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/formPreview/printCompleteProjectB.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(1)
createTagBody(1, {->
printHtmlPart(0)
invokeTag('captureMeta','sitemesh',5,['gsp_sm_xmlClosingForEmptyTag':("/"),'http-equiv':("Content-Type"),'content':("text/html; charset=UTF-8")],-1)
printHtmlPart(0)
invokeTag('captureMeta','sitemesh',6,['gsp_sm_xmlClosingForEmptyTag':("/"),'name':("layout"),'content':("projectPreview")],-1)
printHtmlPart(0)
createTagBody(2, {->
createClosureForHtmlPart(2, 3)
invokeTag('captureTitle','sitemesh',7,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',7,[:],2)
printHtmlPart(3)
})
invokeTag('captureHead','sitemesh',26,[:],1)
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(4)
expressionOut.print(appForm?.appNumber)
printHtmlPart(5)
expressionOut.print(appForm?.submittedOn)
printHtmlPart(6)
if(true && (listOfIndianResearcher)) {
printHtmlPart(7)

int num= 1

printHtmlPart(8)

char alph = 65

printHtmlPart(8)
for( profile in (listOfIndianResearcher) ) {
printHtmlPart(9)
expressionOut.print(alph)
printHtmlPart(10)
expressionOut.print(num)
printHtmlPart(11)

num++

printHtmlPart(12)

alph++

printHtmlPart(13)
expressionOut.print(profile?.title)
printHtmlPart(14)
expressionOut.print(profile?.firstName)
printHtmlPart(14)
expressionOut.print(profile?.middleName)
printHtmlPart(14)
expressionOut.print(profile?.lastName)
printHtmlPart(15)
expressionOut.print(profile?.nationality)
printHtmlPart(16)
expressionOut.print(profile?.address1)
printHtmlPart(17)
expressionOut.print(profile?.address2)
printHtmlPart(14)
expressionOut.print(profile?.address3)
printHtmlPart(14)
expressionOut.print(profile?.city)
printHtmlPart(18)
expressionOut.print(profile?.pincode)
printHtmlPart(17)
expressionOut.print(profile?.province)
printHtmlPart(14)
expressionOut.print(profile?.country?.country)
printHtmlPart(19)
expressionOut.print(profile?.mobile)
printHtmlPart(20)
expressionOut.print(profile?.phone)
printHtmlPart(21)
expressionOut.print(profile?.email)
printHtmlPart(22)
if(true && (profile.samePresentAddress == 'No')) {
printHtmlPart(23)
expressionOut.print(profile?.presentAddress1)
printHtmlPart(17)
expressionOut.print(profile?.presentAddress2)
printHtmlPart(14)
expressionOut.print(profile?.presentAddress3)
expressionOut.print(profile?.presentCity)
printHtmlPart(24)
expressionOut.print(profile?.presentPincode)
printHtmlPart(17)
expressionOut.print(profile?.presentProvince)
printHtmlPart(14)
expressionOut.print(profile?.presentCountry?.country)
printHtmlPart(25)
expressionOut.print(profile?.presentMobile)
printHtmlPart(26)
expressionOut.print(profile?.presentPhone)
printHtmlPart(27)
}
else if(true && (profile?.samePresentAddress == 'Yes')) {
printHtmlPart(28)
expressionOut.print(profile?.address1)
printHtmlPart(17)
expressionOut.print(profile?.address2)
printHtmlPart(14)
expressionOut.print(profile?.address3)
printHtmlPart(14)
expressionOut.print(profile?.city)
printHtmlPart(29)
expressionOut.print(profile?.pincode)
printHtmlPart(17)
expressionOut.print(profile?.province)
printHtmlPart(14)
expressionOut.print(profile?.country?.country)
printHtmlPart(25)
expressionOut.print(profile?.mobile)
printHtmlPart(26)
expressionOut.print(profile?.phone)
printHtmlPart(30)
}
printHtmlPart(31)
if(true && (profile.addressproofLetterFileName != null)) {
printHtmlPart(32)
expressionOut.print(profile?.addressproofNo)
printHtmlPart(33)
expressionOut.print(profile?.addressproofSelect)
printHtmlPart(34)
}
printHtmlPart(8)
}
printHtmlPart(35)
}
printHtmlPart(36)
if(true && (listOfIndianGovtInst)) {
printHtmlPart(37)

int num= 1

printHtmlPart(38)

char alph = 65

printHtmlPart(38)
for( profile in (listOfIndianGovtInst) ) {
printHtmlPart(39)
expressionOut.print(alph)
printHtmlPart(40)
expressionOut.print(num)
printHtmlPart(41)

num++

printHtmlPart(42)

alph++

printHtmlPart(43)
expressionOut.print(profile?.govtInstName)
printHtmlPart(44)
expressionOut.print(profile?.address1)
printHtmlPart(17)
expressionOut.print(profile?.address2)
printHtmlPart(14)
expressionOut.print(profile?.address3)
printHtmlPart(45)
expressionOut.print(profile?.city)
printHtmlPart(14)
expressionOut.print(profile?.country?.country)
printHtmlPart(46)
expressionOut.print(profile?.phone)
printHtmlPart(47)
expressionOut.print(profile?.email)
printHtmlPart(48)
if(true && (profile.samePresentAddress == 'No')) {
printHtmlPart(49)
expressionOut.print(profile?.presentAddress1)
printHtmlPart(17)
expressionOut.print(profile?.presentAddress1)
printHtmlPart(14)
expressionOut.print(profile?.presentAddress1)
printHtmlPart(50)
expressionOut.print(profile?.presentCity)
printHtmlPart(14)
expressionOut.print(profile?.presentCountry?.country)
printHtmlPart(51)
expressionOut.print(profile?.presentPhone)
printHtmlPart(52)
}
printHtmlPart(53)
if(true && (profile.addressproofLetterFileName != null)) {
printHtmlPart(54)
expressionOut.print(profile?.addressproofSelect)
printHtmlPart(55)
expressionOut.print(profile?.addressproofNo)
printHtmlPart(56)
}
printHtmlPart(38)
}
printHtmlPart(57)
}
printHtmlPart(58)
expressionOut.print(entity1?.name)
printHtmlPart(59)
expressionOut.print(entity1?.address1)
printHtmlPart(17)
expressionOut.print(entity1?.address2)
printHtmlPart(14)
expressionOut.print(entity1?.address3)
printHtmlPart(14)
expressionOut.print(entity1?.city)
printHtmlPart(60)
expressionOut.print(entity1?.pincode)
printHtmlPart(17)
expressionOut.print(entity1?.state)
printHtmlPart(14)
expressionOut.print(entity1?.country)
printHtmlPart(20)
expressionOut.print(entity1?.phone)
printHtmlPart(61)
expressionOut.print(entity1?.fax)
printHtmlPart(21)
expressionOut.print(entity1?.email)
printHtmlPart(62)

num= 1

printHtmlPart(8)

alph = 65

printHtmlPart(63)
if(true && (entity2?.name || entity2?.supervisorDesignation)) {
printHtmlPart(64)
expressionOut.print(entity2?.name)
printHtmlPart(65)
expressionOut.print(entity2?.supervisorDesignation)
printHtmlPart(66)
}
else if(true && (entity2?.headOfInstName || entity2?.headOfInstDesignation)) {
printHtmlPart(67)
expressionOut.print(entity2?.headOfInstName)
printHtmlPart(68)
expressionOut.print(entity2?.headOfInstDesignation)
printHtmlPart(66)
}
printHtmlPart(69)
expressionOut.print(entity2?.address1)
printHtmlPart(17)
expressionOut.print(entity2?.address2)
printHtmlPart(14)
expressionOut.print(entity2?.address3)
printHtmlPart(14)
expressionOut.print(entity2?.city)
printHtmlPart(70)
expressionOut.print(entity2?.pincode)
printHtmlPart(17)
expressionOut.print(entity2?.state)
printHtmlPart(14)
expressionOut.print(entity2?.country)
printHtmlPart(71)
expressionOut.print(entity2?.phone)
printHtmlPart(72)
expressionOut.print(entity2?.email)
printHtmlPart(73)

num= 1

printHtmlPart(8)

alph = 65

printHtmlPart(74)
if(true && (entity3?.contactDetailsOfInstOrOrganization == 'whoShallGuideOutsideIndia')) {
printHtmlPart(75)
}
else if(true && (entity3?.contactDetailsOfInstOrOrganization == 'whoShallRcvTheBioResource')) {
printHtmlPart(76)
}
printHtmlPart(77)
expressionOut.print(entity3?.name)
printHtmlPart(59)
expressionOut.print(entity3?.address1)
printHtmlPart(17)
expressionOut.print(entity3?.address2)
printHtmlPart(14)
expressionOut.print(entity3?.address3)
printHtmlPart(14)
expressionOut.print(entity3?.city)
printHtmlPart(78)
expressionOut.print(entity3?.pincode)
printHtmlPart(79)
expressionOut.print(entity3?.state)
printHtmlPart(14)
expressionOut.print(entity3?.country)
printHtmlPart(20)
expressionOut.print(entity3?.phone)
printHtmlPart(21)
expressionOut.print(entity3?.email)
printHtmlPart(80)

num= 1

printHtmlPart(8)

alph = 65

printHtmlPart(81)
if(true && (entity4?.category == 'contactDetails1')) {
printHtmlPart(82)
}
else if(true && (entity4?.category == 'contactDetails2')) {
printHtmlPart(83)
}
else if(true && (entity4?.category == 'contactDetails3')) {
printHtmlPart(84)
}
printHtmlPart(85)
expressionOut.print(entity4?.name)
printHtmlPart(59)
expressionOut.print(entity4?.address1)
printHtmlPart(17)
expressionOut.print(entity4?.address2)
printHtmlPart(14)
expressionOut.print(entity4?.address3)
printHtmlPart(86)
expressionOut.print(entity4?.city)
printHtmlPart(14)
expressionOut.print(entity4?.state)
printHtmlPart(14)
expressionOut.print(entity4?.country)
printHtmlPart(19)
expressionOut.print(entity4?.mobile)
printHtmlPart(20)
expressionOut.print(entity4?.phone)
printHtmlPart(21)
expressionOut.print(entity4?.email)
printHtmlPart(87)

num= 1

printHtmlPart(8)

alph = 65

printHtmlPart(88)
if(true && (listOfFundingAgency)) {
printHtmlPart(89)

int i=1

printHtmlPart(89)
for( agency in (listOfFundingAgency) ) {
printHtmlPart(90)
out.print(i)
printHtmlPart(91)

i++

printHtmlPart(92)
expressionOut.print(agency?.institutionOrganizationName)
printHtmlPart(93)
expressionOut.print(agency?.address1)
printHtmlPart(17)
expressionOut.print(agency?.address2)
printHtmlPart(14)
expressionOut.print(agency?.address3)
printHtmlPart(14)
expressionOut.print(agency?.city)
printHtmlPart(94)
expressionOut.print(agency?.state)
printHtmlPart(17)
expressionOut.print(agency?.country?.country)
printHtmlPart(95)
expressionOut.print(agency?.phone)
printHtmlPart(96)
expressionOut.print(agency?.email)
printHtmlPart(97)
if(true && ("${agency?.sanctionOrderMoUcopyFileName} ")) {
printHtmlPart(98)
}
else {
printHtmlPart(99)
}
printHtmlPart(100)
}
printHtmlPart(101)
}
else {
printHtmlPart(102)
}
printHtmlPart(103)

num= 1

printHtmlPart(8)

alph = 65

printHtmlPart(104)
expressionOut.print(appForm?.briefDescription)
printHtmlPart(105)

num= 1

printHtmlPart(8)

alph = 65

printHtmlPart(106)
if(true && (formType == 'Form1' || formType == 'FormB')) {
printHtmlPart(107)
}
printHtmlPart(108)
if(true && (listOfBioResources)) {
printHtmlPart(89)

int i=1

printHtmlPart(89)
for( bioResource in (listOfBioResources) ) {
printHtmlPart(90)
out.print(i)
printHtmlPart(91)

i++

printHtmlPart(92)
expressionOut.print(bioResource?.accessIntention)
printHtmlPart(109)
if(true && (bioResource?.accessIntention == 'Carried along for the research' || bioResource?.accessIntention == 'Sent for the Research')) {
printHtmlPart(110)
expressionOut.print(bioResource?.commonName)
printHtmlPart(111)
expressionOut.print(bioResource?.scientificName)
printHtmlPart(111)
expressionOut.print(bioResource?.nature)
printHtmlPart(111)
expressionOut.print(bioResource?.biologicalResource)
printHtmlPart(111)
expressionOut.print(bioResource?.quantity)
printHtmlPart(14)
expressionOut.print(bioResource?.qtyUnit)
printHtmlPart(112)
}
else {
printHtmlPart(113)
}
printHtmlPart(114)
}
printHtmlPart(101)
}
else {
printHtmlPart(115)
}
printHtmlPart(116)

num= 1

printHtmlPart(8)

alph = 65

printHtmlPart(117)
expressionOut.print(appForm?.researchDurationFrom?.format('dd/MM/yyyy'))
printHtmlPart(118)
expressionOut.print(appForm?.researchDurationTo?.format('dd/MM/yyyy'))
printHtmlPart(119)
if(true && (appForm?.typeOfExercise == 'multipleTime')) {
printHtmlPart(120)
}
else {
printHtmlPart(121)
}
printHtmlPart(122)
if(true && (appForm?.typeOfExercise == 'multipleTime')) {
printHtmlPart(123)
expressionOut.print(appForm?.numOfTimesOfSending)
printHtmlPart(124)
expressionOut.print(appForm?.reasonsForSending)
printHtmlPart(125)
}
printHtmlPart(126)

num= 1

printHtmlPart(8)

alph = 65

printHtmlPart(127)
if(true && (listOfLocations)) {
printHtmlPart(42)

int i=1

printHtmlPart(42)
for( location in (listOfLocations) ) {
printHtmlPart(128)
out.print(i)
printHtmlPart(129)

i++

printHtmlPart(130)
expressionOut.print(location?.bioResource?.scientificName)
printHtmlPart(131)
expressionOut.print(location?.source)
printHtmlPart(132)
if(true && (location?.village)) {
printHtmlPart(133)
expressionOut.print(location?.village)
printHtmlPart(134)
}
else {
printHtmlPart(135)
}
printHtmlPart(136)
if(true && (location?.town)) {
printHtmlPart(137)
expressionOut.print(location?.town)
printHtmlPart(134)
}
else {
printHtmlPart(135)
}
printHtmlPart(138)
if(true && (location?.district)) {
printHtmlPart(133)
expressionOut.print(location?.district)
printHtmlPart(134)
}
else {
printHtmlPart(135)
}
printHtmlPart(138)
if(true && (location?.state)) {
printHtmlPart(137)
expressionOut.print(location?.state)
printHtmlPart(134)
}
else {
printHtmlPart(135)
}
printHtmlPart(138)
if(true && (location?.traderName)) {
printHtmlPart(133)
expressionOut.print(location?.traderName)
printHtmlPart(134)
}
else {
printHtmlPart(135)
}
printHtmlPart(138)
if(true && (location?.traderContactDetails)) {
printHtmlPart(137)
expressionOut.print(location?.traderContactDetails)
printHtmlPart(134)
}
else {
printHtmlPart(135)
}
printHtmlPart(139)
}
printHtmlPart(101)
}
else {
printHtmlPart(140)
}
printHtmlPart(141)

num= 1

printHtmlPart(8)

alph = 65

printHtmlPart(104)
expressionOut.print(appForm?.emergencyDetails)
printHtmlPart(142)
})
invokeTag('captureBody','sitemesh',983,[:],1)
printHtmlPart(143)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1537268168000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
