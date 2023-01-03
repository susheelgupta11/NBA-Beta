import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_NBA_checklist_f1legalReview_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/checklist/_f1legalReview.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
expressionOut.print(formDetails?.appNumber)
printHtmlPart(1)
invokeTag('textField','g',22,['class':("remark"),'name':("onlineAppNumberRmk"),'value':(formRemkInstance?.onlineAppNumberRmk)],-1)
printHtmlPart(2)
if(true && (nbaReferenceNum)) {
printHtmlPart(3)
invokeTag('textField','g',29,['class':("remark"),'name':("refNumber"),'value':(nbaReferenceNum)],-1)
printHtmlPart(4)
}
else {
printHtmlPart(5)
invokeTag('textField','g',33,['class':("remark"),'name':("refNumber"),'value':(formRemkInstance?.nbaRefNumber)],-1)
printHtmlPart(6)
}
printHtmlPart(7)
invokeTag('textField','g',36,['class':("remark"),'name':("nbaRefNumberRemark"),'value':(formRemkInstance?.nbaRefNumberRemark)],-1)
printHtmlPart(8)
if(true && (formDetails?.individualProfiles)) {
printHtmlPart(9)
}
else if(true && (formDetails?.companyProfiles)) {
printHtmlPart(10)
for( ct in (formDetails?.companyProfiles) ) {
printHtmlPart(10)
expressionOut.print(ct?.entityType)
printHtmlPart(10)
}
printHtmlPart(10)
}
else if(true && (formDetails?.indianGovtInst)) {
printHtmlPart(11)
}
else if(true && (formDetails?.depostionOfMicroOrganism)) {
printHtmlPart(12)
}
else if(true && (formDetails?.indianResearcher)) {
printHtmlPart(13)
}
printHtmlPart(14)
invokeTag('textField','g',54,['class':("remark"),'name':("appltcatg"),'value':(formRemkInstance?.applicantCatgRmk)],-1)
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
printHtmlPart(19)
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
printHtmlPart(19)
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
printHtmlPart(19)
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
printHtmlPart(19)
expressionOut.print(govt?.presentCity)
printHtmlPart(16)
}
printHtmlPart(20)
}
printHtmlPart(21)
invokeTag('textField','g',110,['class':("remark"),'name':("appltname"),'value':(formRemkInstance?.applicantNameContRmk)],-1)
printHtmlPart(22)
if(true && (formDetails?.companyProfiles)) {
printHtmlPart(23)
for( company in (formDetails?.companyProfiles) ) {
printHtmlPart(23)
expressionOut.print(company?.title)
printHtmlPart(24)
expressionOut.print(company?.firstName)
printHtmlPart(24)
expressionOut.print(company?.middleName)
printHtmlPart(24)
expressionOut.print(company?.lastName)
printHtmlPart(25)
expressionOut.print(company?.designation)
printHtmlPart(26)
expressionOut.print(company?.personMobile)
printHtmlPart(27)
expressionOut.print(company?.personEmail)
printHtmlPart(23)
}
printHtmlPart(23)
}
else {
printHtmlPart(28)
}
printHtmlPart(1)
invokeTag('textField','g',130,['class':("remark"),'name':("nameandComp"),'value':(formRemkInstance?.authPersonContRmk)],-1)
printHtmlPart(29)
if(true && (formDetails?.agentProfile)) {
printHtmlPart(23)
expressionOut.print(formDetails?.agentProfile?.title)
printHtmlPart(24)
expressionOut.print(formDetails?.agentProfile?.firstName)
printHtmlPart(23)
expressionOut.print(formDetails?.agentProfile?.middleName)
printHtmlPart(24)
expressionOut.print(formDetails?.agentProfile?.lastName)
printHtmlPart(23)
expressionOut.print(formDetails?.agentProfile?.address1)
printHtmlPart(24)
expressionOut.print(formDetails?.agentProfile?.address2)
printHtmlPart(23)
expressionOut.print(formDetails?.agentProfile?.address3)
printHtmlPart(24)
expressionOut.print(formDetails?.agentProfile?.city)
printHtmlPart(23)
}
else {
printHtmlPart(28)
}
printHtmlPart(30)
invokeTag('textField','g',146,['class':("remark"),'name':("agent"),'value':(formRemkInstance?.attorneyInIndiaContRmk)],-1)
printHtmlPart(31)
invokeTag('textField','g',157,['class':("remark"),'name':("formCatg"),'value':(formRemkInstance?.appFormCatgRmk)],-1)
printHtmlPart(32)
if(true && (formRemkInstance?.threeTwocheck == '' || formRemkInstance?.threeTwocheck == null)) {
printHtmlPart(33)
invokeTag('radio','g',169,['name':("threeTwocheck"),'id':("yesthreeTwo"),'onclick':("hideText();"),'value':("true")],-1)
printHtmlPart(34)
invokeTag('radio','g',170,['name':("threeTwocheck"),'id':("nothreeTwo"),'onclick':("showText();"),'value':("false")],-1)
printHtmlPart(35)
}
printHtmlPart(36)
if(true && (formRemkInstance?.threeTwocheck == false)) {
printHtmlPart(33)
invokeTag('radio','g',175,['name':("threeTwocheck"),'id':("yesthreeTwo"),'onclick':("hideText();"),'value':("true")],-1)
printHtmlPart(34)
invokeTag('radio','g',176,['name':("threeTwocheck"),'id':("nothreeTwo"),'onclick':("showText();"),'value':("false"),'checked':("true")],-1)
printHtmlPart(35)
}
printHtmlPart(16)
if(true && (formRemkInstance?.threeTwocheck == true)) {
printHtmlPart(37)
invokeTag('radio','g',181,['name':("threeTwocheck"),'id':("yesthreeTwo"),'onclick':("hideText();"),'value':("true"),'checked':("true")],-1)
printHtmlPart(34)
invokeTag('radio','g',182,['name':("threeTwocheck"),'id':("nothreeTwo"),'onclick':("showText();"),'value':("false")],-1)
printHtmlPart(38)
}
printHtmlPart(7)
invokeTag('textField','g',186,['class':("remark"),'name':("threeTwoRemark"),'id':("remarkthreeTwo"),'value':(formRemkInstance?.threeTwoRemark),'style':("display: none;")],-1)
printHtmlPart(39)
if(true && (formRemkInstance?.sevncheck == '' || formRemkInstance?.sevncheck == null)) {
printHtmlPart(40)
invokeTag('radio','g',196,['name':("sevncheck"),'id':("yessevn"),'onclick':("hide();"),'value':("true")],-1)
printHtmlPart(34)
invokeTag('radio','g',197,['name':("sevncheck"),'id':("nosevn"),'onclick':("show();"),'value':("false")],-1)
printHtmlPart(38)
}
printHtmlPart(41)
if(true && (formRemkInstance?.sevncheck == false)) {
printHtmlPart(40)
invokeTag('radio','g',202,['name':("sevncheck"),'id':("yessevn"),'onclick':("hide();"),'value':("true")],-1)
printHtmlPart(34)
invokeTag('radio','g',203,['name':("sevncheck"),'id':("nosevn"),'onclick':("show();"),'value':("false"),'checked':("true")],-1)
printHtmlPart(38)
}
printHtmlPart(42)
if(true && (formRemkInstance?.sevncheck == true)) {
printHtmlPart(43)
invokeTag('radio','g',208,['name':("sevncheck"),'id':("yessevn"),'onclick':("hide();"),'value':("true"),'checked':("true")],-1)
printHtmlPart(34)
invokeTag('radio','g',209,['name':("sevncheck"),'id':("nosevn"),'onclick':("show();"),'value':("false")],-1)
printHtmlPart(38)
}
printHtmlPart(7)
invokeTag('textField','g',213,['class':("remark"),'name':("sevnRemark"),'id':("remarksevn"),'value':(formRemkInstance?.sevnRemark),'style':("display: none;")],-1)
printHtmlPart(44)
if(true && (formRemkInstance?.letterBoardChk == '' || formRemkInstance?.letterBoardChk == null)) {
printHtmlPart(40)
invokeTag('radio','g',221,['name':("letterBoardChk"),'value':("true")],-1)
printHtmlPart(34)
invokeTag('radio','g',221,['name':("letterBoardChk"),'value':("false")],-1)
printHtmlPart(45)
invokeTag('radio','g',222,['name':("letterBoardChk"),'value':("notAvailable")],-1)
printHtmlPart(46)
}
printHtmlPart(47)
if(true && (formRemkInstance?.letterBoardChk == "true")) {
printHtmlPart(40)
invokeTag('radio','g',226,['name':("letterBoardChk"),'value':("true"),'checked':("true")],-1)
printHtmlPart(48)
invokeTag('radio','g',227,['name':("letterBoardChk"),'value':("false")],-1)
printHtmlPart(45)
invokeTag('radio','g',228,['name':("letterBoardChk"),'value':("notAvailable")],-1)
printHtmlPart(46)
}
printHtmlPart(47)
if(true && (formRemkInstance?.letterBoardChk == "false")) {
printHtmlPart(40)
invokeTag('radio','g',232,['name':("letterBoardChk"),'value':("true")],-1)
printHtmlPart(49)
invokeTag('radio','g',233,['name':("letterBoardChk"),'value':("false"),'checked':("true")],-1)
printHtmlPart(45)
invokeTag('radio','g',234,['name':("letterBoardChk"),'value':("notAvailable")],-1)
printHtmlPart(46)
}
printHtmlPart(47)
if(true && (formRemkInstance?.letterBoardChk == "notAvailable")) {
printHtmlPart(40)
invokeTag('radio','g',238,['name':("letterBoardChk"),'value':("true")],-1)
printHtmlPart(49)
invokeTag('radio','g',239,['name':("letterBoardChk"),'value':("false")],-1)
printHtmlPart(45)
invokeTag('radio','g',240,['name':("letterBoardChk"),'value':("notAvailable"),'checked':("true")],-1)
printHtmlPart(46)
}
printHtmlPart(50)
invokeTag('textField','g',244,['class':("remark"),'name':("letterBoardRemark"),'value':(formRemkInstance?.letterBoardRemark)],-1)
printHtmlPart(51)
if(true && (formRemkInstance?.holdingPatternChk == '' || formRemkInstance?.holdingPatternChk == null)) {
printHtmlPart(52)
invokeTag('radio','g',253,['name':("holdingPatternChk"),'value':("true")],-1)
printHtmlPart(48)
invokeTag('radio','g',254,['name':("holdingPatternChk"),'value':("false")],-1)
printHtmlPart(45)
invokeTag('radio','g',255,['name':("holdingPatternChk"),'value':("notAvailable")],-1)
printHtmlPart(46)
}
printHtmlPart(47)
if(true && (formRemkInstance?.holdingPatternChk == "true")) {
printHtmlPart(52)
invokeTag('radio','g',260,['name':("holdingPatternChk"),'value':("true"),'checked':("true")],-1)
printHtmlPart(48)
invokeTag('radio','g',261,['name':("holdingPatternChk"),'value':("false")],-1)
printHtmlPart(45)
invokeTag('radio','g',262,['name':("holdingPatternChk"),'value':("notAvailable")],-1)
printHtmlPart(46)
}
printHtmlPart(47)
if(true && (formRemkInstance?.holdingPatternChk == "false")) {
printHtmlPart(52)
invokeTag('radio','g',267,['name':("holdingPatternChk"),'value':("true")],-1)
printHtmlPart(48)
invokeTag('radio','g',268,['name':("holdingPatternChk"),'value':("false"),'checked':("true")],-1)
printHtmlPart(45)
invokeTag('radio','g',269,['name':("holdingPatternChk"),'value':("notAvailable")],-1)
printHtmlPart(46)
}
printHtmlPart(47)
if(true && (formRemkInstance?.holdingPatternChk == "notAvailable")) {
printHtmlPart(52)
invokeTag('radio','g',274,['name':("holdingPatternChk"),'value':("true")],-1)
printHtmlPart(48)
invokeTag('radio','g',275,['name':("holdingPatternChk"),'value':("false")],-1)
printHtmlPart(45)
invokeTag('radio','g',276,['name':("holdingPatternChk"),'value':("notAvailable"),'checked':("true")],-1)
printHtmlPart(46)
}
printHtmlPart(50)
invokeTag('textField','g',280,['class':("remark"),'name':("holdingPatternRemark"),'value':(formRemkInstance?.holdingPatternRemark)],-1)
printHtmlPart(53)
if(true && (formDetails?.biologicalResources)) {
printHtmlPart(54)
loop:{
int i = 0
for( resource in (formDetails?.biologicalResources) ) {
printHtmlPart(55)
expressionOut.print(i+1)
printHtmlPart(56)
expressionOut.print(resource?.accessIntention)
printHtmlPart(56)
expressionOut.print(resource?.commonName)
printHtmlPart(56)
expressionOut.print(resource?.scientificName)
printHtmlPart(56)
expressionOut.print(resource?.nature)
printHtmlPart(56)
expressionOut.print(resource?.biologicalResource)
printHtmlPart(56)
expressionOut.print(resource?.quantity)
printHtmlPart(57)
expressionOut.print(resource?.qtyUnit)
printHtmlPart(58)
invokeTag('formatDate','g',310,['format':("dd/MM/yyyy"),'date':(resource?.fromTime)],-1)
printHtmlPart(59)
invokeTag('formatDate','g',312,['format':("dd/MM/yyyy"),'date':(resource?.toTime)],-1)
printHtmlPart(60)
invokeTag('textField','g',313,['class':("remark"),'name':("resremk"),'value':(formRemkInstance?.biologicalResRmk)],-1)
printHtmlPart(61)
i++
}
}
printHtmlPart(62)
}
printHtmlPart(63)
if(true && (!formDetails?.selfAuthorizedPerson)) {
printHtmlPart(64)
loop:{
int m = 0
for( profile in (allDataforMatching?.listOfContactPerson) ) {
printHtmlPart(65)
expressionOut.print(m+1)
printHtmlPart(66)
expressionOut.print(profile?.nameOfContactPerson?:'NA')
printHtmlPart(67)
expressionOut.print(profile?.addressOfContactPerson?:'NA')
printHtmlPart(68)
expressionOut.print(profile?.mobileOfContactPerson?:'NA')
printHtmlPart(68)
expressionOut.print(profile?.emailOfContactPerson?:'NA')
printHtmlPart(69)
invokeTag('textField','g',353,['class':("remark"),'name':("makingSelection"),'value':(formRemkInstance?.makingSelection)],-1)
printHtmlPart(70)
m++
}
}
printHtmlPart(16)
}
else {
printHtmlPart(71)
}
printHtmlPart(72)
expressionOut.print(formDetails?.purposeOfProposal)
printHtmlPart(73)
invokeTag('textField','g',371,['class':("remark"),'name':("intendedPurpose"),'value':(formRemkInstance?.intendedPurpose)],-1)
printHtmlPart(74)
if(true && (formRemkInstance?.twoMChk == '' || formRemkInstance?.twoMChk == null)) {
printHtmlPart(40)
invokeTag('radio','g',380,['name':("twoMChk"),'value':("true")],-1)
printHtmlPart(48)
invokeTag('radio','g',381,['name':("twoMChk"),'value':("false")],-1)
printHtmlPart(75)
}
printHtmlPart(76)
if(true && (formRemkInstance?.twoMChk == true)) {
printHtmlPart(40)
invokeTag('radio','g',386,['name':("twoMChk"),'value':("true"),'checked':("true")],-1)
printHtmlPart(48)
invokeTag('radio','g',387,['name':("twoMChk"),'value':("false")],-1)
printHtmlPart(75)
}
printHtmlPart(76)
if(true && (formRemkInstance?.twoMChk == false)) {
printHtmlPart(40)
invokeTag('radio','g',392,['name':("twoMChk"),'value':("true")],-1)
printHtmlPart(48)
invokeTag('radio','g',393,['name':("twoMChk"),'value':("false"),'checked':("true")],-1)
printHtmlPart(75)
}
printHtmlPart(77)
invokeTag('textField','g',398,['class':("remark"),'name':("twoMRemark"),'value':(formRemkInstance?.twoMRemark)],-1)
printHtmlPart(78)
if(true && (formRemkInstance?.twoFChk == '' || formRemkInstance?.twoFChk == null)) {
printHtmlPart(79)
invokeTag('radio','g',408,['name':("twoFChk"),'value':("true")],-1)
printHtmlPart(80)
invokeTag('radio','g',409,['name':("twoFChk"),'value':("false")],-1)
printHtmlPart(81)
}
printHtmlPart(82)
if(true && (formRemkInstance?.twoFChk == true)) {
printHtmlPart(79)
invokeTag('radio','g',414,['name':("twoFChk"),'value':("true"),'checked':("true")],-1)
printHtmlPart(83)
invokeTag('radio','g',414,['name':("twoFChk"),'value':("false")],-1)
printHtmlPart(81)
}
printHtmlPart(82)
if(true && (formRemkInstance?.twoFChk == false)) {
printHtmlPart(79)
invokeTag('radio','g',419,['name':("twoFChk"),'value':("true"),'checked':("true")],-1)
printHtmlPart(83)
invokeTag('radio','g',420,['name':("twoFChk"),'value':("false"),'checked':("true")],-1)
printHtmlPart(81)
}
printHtmlPart(84)
invokeTag('textField','g',424,['class':("remark"),'name':("twoFRemark"),'value':(formRemkInstance?.twoFRemark)],-1)
printHtmlPart(85)
if(true && (formRemkInstance?.twoDChk == '' || formRemkInstance?.twoDChk == null)) {
printHtmlPart(40)
invokeTag('radio','g',433,['name':("twoDChk"),'value':("true")],-1)
printHtmlPart(34)
invokeTag('radio','g',433,['name':("twoDChk"),'value':("false")],-1)
printHtmlPart(75)
}
printHtmlPart(76)
if(true && (formRemkInstance?.twoDChk == true)) {
printHtmlPart(40)
invokeTag('radio','g',438,['name':("twoDChk"),'value':("true"),'checked':("true")],-1)
printHtmlPart(34)
invokeTag('radio','g',438,['name':("twoDChk"),'value':("false")],-1)
printHtmlPart(75)
}
printHtmlPart(76)
if(true && (formRemkInstance?.twoDChk == false)) {
printHtmlPart(40)
invokeTag('radio','g',443,['name':("twoDChk"),'value':("true")],-1)
printHtmlPart(34)
invokeTag('radio','g',443,['name':("twoDChk"),'value':("false"),'checked':("true")],-1)
printHtmlPart(75)
}
printHtmlPart(86)
invokeTag('textField','g',449,['class':("remark"),'name':("twoDRemark"),'value':(formRemkInstance?.twoDRemark)],-1)
printHtmlPart(87)
if(true && (formRemkInstance?.vettingChk == '' || formRemkInstance?.vettingChk == null)) {
printHtmlPart(40)
invokeTag('radio','g',459,['name':("vettingChk"),'value':("true")],-1)
printHtmlPart(34)
invokeTag('radio','g',459,['name':("vettingChk"),'value':("false")],-1)
printHtmlPart(88)
}
printHtmlPart(89)
if(true && (formRemkInstance?.vettingChk == "true")) {
printHtmlPart(40)
invokeTag('radio','g',464,['name':("vettingChk"),'value':("true"),'checked':("true")],-1)
printHtmlPart(34)
invokeTag('radio','g',464,['name':("vettingChk"),'value':("false")],-1)
printHtmlPart(88)
}
printHtmlPart(89)
if(true && (formRemkInstance?.vettingChk == "false")) {
printHtmlPart(40)
invokeTag('radio','g',469,['name':("vettingChk"),'value':("true")],-1)
printHtmlPart(34)
invokeTag('radio','g',469,['name':("vettingChk"),'value':("false"),'checked':("true")],-1)
printHtmlPart(88)
}
printHtmlPart(90)
invokeTag('textField','g',475,['class':("remark"),'name':("vettingRemark"),'value':(formRemkInstance?.vettingRemark)],-1)
printHtmlPart(91)
if(true && (formRemkInstance?.orderChk == '' || formRemkInstance?.orderChk == null)) {
printHtmlPart(40)
invokeTag('radio','g',483,['name':("orderChk"),'value':("true")],-1)
printHtmlPart(49)
invokeTag('radio','g',484,['name':("orderChk"),'value':("false")],-1)
printHtmlPart(92)
}
printHtmlPart(89)
if(true && (formRemkInstance?.orderChk == "true")) {
printHtmlPart(40)
invokeTag('radio','g',488,['name':("orderChk"),'value':("true"),'checked':("true")],-1)
printHtmlPart(49)
invokeTag('radio','g',489,['name':("orderChk"),'value':("false")],-1)
printHtmlPart(92)
}
printHtmlPart(89)
if(true && (formRemkInstance?.orderChk == "false")) {
printHtmlPart(40)
invokeTag('radio','g',493,['name':("orderChk"),'value':("true")],-1)
printHtmlPart(49)
invokeTag('radio','g',494,['name':("orderChk"),'value':("false"),'checked':("true")],-1)
printHtmlPart(92)
}
printHtmlPart(93)
invokeTag('textField','g',498,['class':("remark"),'name':("orderRemark"),'value':(formRemkInstance?.orderRemark)],-1)
printHtmlPart(94)
expressionOut.print(formDetails?.briefDescription)
printHtmlPart(73)
invokeTag('textField','g',507,['class':("remark"),'name':("nbaApprovalRmk"),'value':(formRemkInstance?.nbaApprovalRmk)],-1)
printHtmlPart(95)
if(true && (formRemkInstance?.violationChk == '' || formRemkInstance?.violationChk == null)) {
printHtmlPart(40)
invokeTag('radio','g',519,['name':("violationChk"),'onclick':("trshow('yes');"),'value':("true")],-1)
printHtmlPart(96)
invokeTag('radio','g',520,['name':("violationChk"),'onclick':("trshow('no');"),'value':("false")],-1)
printHtmlPart(97)
}
printHtmlPart(76)
if(true && (formRemkInstance?.violationChk == true)) {
printHtmlPart(40)
invokeTag('radio','g',523,['name':("violationChk"),'value':("true"),'checked':("true")],-1)
printHtmlPart(96)
invokeTag('radio','g',524,['name':("violationChk"),'value':("false")],-1)
printHtmlPart(97)
}
printHtmlPart(76)
if(true && (formRemkInstance?.violationChk == false)) {
printHtmlPart(40)
invokeTag('radio','g',527,['name':("violationChk"),'value':("true")],-1)
printHtmlPart(96)
invokeTag('radio','g',528,['name':("violationChk"),'value':("false"),'checked':("true")],-1)
printHtmlPart(97)
}
printHtmlPart(77)
invokeTag('textField','g',531,['class':("remark"),'name':("violationRemark"),'value':(formRemkInstance?.violationRemark)],-1)
printHtmlPart(98)
invokeTag('select','g',539,['name':("sectionData"),'from':(vioSection),'value':(formRemkInstance?.violationSelect),'id':("pickSec")],-1)
printHtmlPart(99)
if(true && (formRemkInstance?.violationSelect)) {
printHtmlPart(89)
createClosureForHtmlPart(100, 2)
invokeTag('javascript','g',547,[:],2)
printHtmlPart(101)
}
printHtmlPart(102)
invokeTag('textArea','g',550,['class':("remark"),'name':("violationSelect"),'value':(formRemkInstance?.violationSelect),'id':("showSectionVal"),'style':("display: none;"),'rows':("3"),'cols':("25")],-1)
printHtmlPart(103)
invokeTag('textArea','g',563,['class':("remark"),'name':("additional"),'style':(" display:none;"),'value':(formRemkInstance?.additional)],-1)
printHtmlPart(104)
if(true && (formRemkInstance == null || formRemkInstance == '')) {
printHtmlPart(105)
}
else {
printHtmlPart(106)
}
printHtmlPart(107)
if(true && (formRemkInstance != null || formRemkInstance != '')) {
printHtmlPart(108)
loop:{
int k = 0
for( quesAnswer in (formRemkInstance?.questionAnswers) ) {
printHtmlPart(109)
expressionOut.print(k+1)
printHtmlPart(110)
expressionOut.print(k+1)
printHtmlPart(111)
expressionOut.print(k+20)
printHtmlPart(112)
invokeTag('textArea','g',578,['class':("remark"),'name':("quesValues${k+1}"),'id':("qut${k+1}"),'value':(quesAnswer?.question),'rows':("3"),'cols':("40")],-1)
printHtmlPart(113)
invokeTag('textArea','g',580,['class':("remark"),'name':("ansValues${k+1}"),'id':("qes${k+1}"),'value':(quesAnswer?.answer),'rows':("3"),'cols':("40")],-1)
printHtmlPart(114)
expressionOut.print(k+1)
printHtmlPart(115)
expressionOut.print(quesAnswer?.id)
printHtmlPart(116)
expressionOut.print(k+1)
printHtmlPart(115)
expressionOut.print(quesAnswer?.id)
printHtmlPart(117)
k++
}
}
printHtmlPart(108)
}
printHtmlPart(118)
invokeTag('textArea','g',585,['name':("quesValues"),'class':("ques"),'style':("width:100%")],-1)
printHtmlPart(119)
invokeTag('textArea','g',591,['name':("ansValues"),'class':("ans"),'style':("width:100%")],-1)
printHtmlPart(120)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1645536534088L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
