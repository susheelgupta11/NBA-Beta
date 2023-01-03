import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_NBA_checklist_f3legalReview_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/checklist/_f3legalReview.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
expressionOut.print(formDetails?.appNumber)
printHtmlPart(1)
invokeTag('textField','g',20,['class':("remark"),'name':("onlineAppNumberRmk"),'value':(formRemkInstance?.onlineAppNumberRmk)],-1)
printHtmlPart(2)
if(true && (nbaReferenceNum)) {
printHtmlPart(3)
invokeTag('textField','g',27,['class':("remark"),'name':("refNumber"),'value':(nbaReferenceNum)],-1)
printHtmlPart(4)
}
else {
printHtmlPart(5)
invokeTag('textField','g',30,['class':("remark"),'name':("refNumber"),'value':(formRemkInstance?.nbaRefNumber)],-1)
printHtmlPart(4)
}
printHtmlPart(6)
invokeTag('textField','g',33,['class':("remark"),'name':("nbaRefNumberRemark"),'value':(formRemkInstance?.nbaRefNumberRemark)],-1)
printHtmlPart(7)
if(true && (formDetails?.individualProfiles)) {
printHtmlPart(8)
}
else if(true && (formDetails?.companyProfiles)) {
printHtmlPart(9)
for( ct in (formDetails?.companyProfiles) ) {
printHtmlPart(9)
expressionOut.print(ct?.entityType)
printHtmlPart(9)
}
printHtmlPart(9)
}
else if(true && (formDetails?.indianGovtInst)) {
printHtmlPart(10)
}
else if(true && (formDetails?.depostionOfMicroOrganism)) {
printHtmlPart(11)
}
else if(true && (formDetails?.indianResearcher)) {
printHtmlPart(12)
}
printHtmlPart(13)
invokeTag('textField','g',51,['class':("remark"),'name':("appltcatg"),'value':(formRemkInstance?.applicantCatgRmk)],-1)
printHtmlPart(14)
if(true && (formDetails?.individualProfiles)) {
printHtmlPart(9)
for( individualProfile in (formDetails?.individualProfiles) ) {
printHtmlPart(15)
expressionOut.print(individualProfile?.title)
printHtmlPart(16)
expressionOut.print(individualProfile?.firstName)
printHtmlPart(16)
expressionOut.print(individualProfile?.middleName)
printHtmlPart(16)
expressionOut.print(individualProfile?.lastName)
printHtmlPart(17)
expressionOut.print(individualProfile?.address1)
printHtmlPart(16)
expressionOut.print(individualProfile?.address2)
printHtmlPart(16)
expressionOut.print(individualProfile?.address3)
printHtmlPart(17)
expressionOut.print(individualProfile?.city)
printHtmlPart(9)
}
printHtmlPart(18)
}
else if(true && (formDetails?.companyProfiles)) {
printHtmlPart(9)
loop:{
int k = 0
for( company in (formDetails?.companyProfiles) ) {
printHtmlPart(16)
expressionOut.print(company?.entityName)
printHtmlPart(9)
k++
}
}
printHtmlPart(18)
}
else if(true && (formDetails?.indianResearcher)) {
printHtmlPart(9)
for( researcher in (formDetails?.indianResearcher) ) {
printHtmlPart(15)
expressionOut.print(researcher?.title)
printHtmlPart(16)
expressionOut.print(researcher?.firstName)
printHtmlPart(16)
expressionOut.print(researcher?.middleName)
printHtmlPart(16)
expressionOut.print(researcher?.lastName)
printHtmlPart(17)
expressionOut.print(researcher?.address1)
printHtmlPart(16)
expressionOut.print(researcher?.address2)
printHtmlPart(16)
expressionOut.print(researcher?.address3)
printHtmlPart(17)
expressionOut.print(researcher?.presentCity)
printHtmlPart(9)
}
printHtmlPart(18)
}
else if(true && (formDetails?.depostionOfMicroOrganism)) {
printHtmlPart(9)
for( depost in (formDetails?.depostionOfMicroOrganism) ) {
printHtmlPart(16)
expressionOut.print(depost?.nameOfDepositor)
printHtmlPart(17)
expressionOut.print(depost?.address1)
printHtmlPart(16)
expressionOut.print(depost?.address2)
printHtmlPart(16)
expressionOut.print(depost?.address3)
printHtmlPart(17)
expressionOut.print(depost?.city)
printHtmlPart(9)
}
printHtmlPart(18)
}
else if(true && (formDetails?.indianGovtInst)) {
printHtmlPart(9)
for( govt in (formDetails?.indianGovtInst) ) {
printHtmlPart(16)
expressionOut.print(govt?.govtInstName)
printHtmlPart(17)
expressionOut.print(govt?.address1)
printHtmlPart(16)
expressionOut.print(govt?.address2)
printHtmlPart(16)
expressionOut.print(govt?.address3)
printHtmlPart(17)
expressionOut.print(govt?.presentCity)
printHtmlPart(9)
}
printHtmlPart(18)
}
printHtmlPart(1)
invokeTag('textField','g',106,['class':("remark"),'name':("appltname"),'value':(formRemkInstance?.applicantNameContRmk)],-1)
printHtmlPart(19)
if(true && (formDetails?.companyProfiles)) {
printHtmlPart(18)
for( company in (formDetails?.companyProfiles) ) {
printHtmlPart(18)
expressionOut.print(company?.title)
printHtmlPart(20)
expressionOut.print(company?.firstName)
printHtmlPart(20)
expressionOut.print(company?.middleName)
printHtmlPart(20)
expressionOut.print(company?.lastName)
printHtmlPart(21)
expressionOut.print(company?.personMobile)
printHtmlPart(22)
expressionOut.print(company?.personEmail)
printHtmlPart(18)
}
printHtmlPart(18)
}
else {
printHtmlPart(23)
}
printHtmlPart(24)
invokeTag('textField','g',123,['class':("remark"),'name':("nameandComp"),'value':(formRemkInstance?.authPersonContRmk)],-1)
printHtmlPart(25)
if(true && (formDetails?.agentProfile)) {
printHtmlPart(18)
expressionOut.print(formDetails?.agentProfile?.title)
printHtmlPart(20)
expressionOut.print(formDetails?.agentProfile?.firstName)
printHtmlPart(18)
expressionOut.print(formDetails?.agentProfile?.middleName)
printHtmlPart(20)
expressionOut.print(formDetails?.agentProfile?.lastName)
printHtmlPart(26)
expressionOut.print(formDetails?.agentProfile?.address1)
printHtmlPart(20)
expressionOut.print(formDetails?.agentProfile?.address2)
printHtmlPart(18)
expressionOut.print(formDetails?.agentProfile?.address3)
printHtmlPart(27)
expressionOut.print(formDetails?.agentProfile?.city)
printHtmlPart(18)
}
else {
printHtmlPart(23)
}
printHtmlPart(1)
invokeTag('textField','g',141,['class':("remark"),'name':("agent"),'value':(formRemkInstance?.attorneyInIndiaContRmk)],-1)
printHtmlPart(28)
invokeTag('textField','g',150,['class':("remark"),'name':("formCatg"),'value':(formRemkInstance?.appFormCatgRmk)],-1)
printHtmlPart(29)
if(true && (formRemkInstance?.threeTwocheck == '' || formRemkInstance?.threeTwocheck == null)) {
printHtmlPart(30)
invokeTag('radio','g',159,['name':("threeTwocheck"),'id':("yesthreeTwo"),'onclick':("hideText();"),'value':("true")],-1)
printHtmlPart(31)
invokeTag('radio','g',160,['name':("threeTwocheck"),'id':("nothreeTwo"),'onclick':("showText();"),'value':("false")],-1)
printHtmlPart(32)
}
printHtmlPart(33)
if(true && (formRemkInstance?.threeTwocheck == false)) {
printHtmlPart(30)
invokeTag('radio','g',164,['name':("threeTwocheck"),'id':("yesthreeTwo"),'onclick':("hideText();"),'value':("true")],-1)
printHtmlPart(31)
invokeTag('radio','g',165,['name':("threeTwocheck"),'id':("nothreeTwo"),'onclick':("showText();"),'value':("false"),'checked':("true")],-1)
printHtmlPart(32)
}
printHtmlPart(9)
if(true && (formRemkInstance?.threeTwocheck == true)) {
printHtmlPart(34)
invokeTag('radio','g',171,['name':("threeTwocheck"),'id':("yesthreeTwo"),'onclick':("hideText();"),'value':("true"),'checked':("true")],-1)
printHtmlPart(31)
invokeTag('radio','g',172,['name':("threeTwocheck"),'id':("nothreeTwo"),'onclick':("showText();"),'value':("false")],-1)
printHtmlPart(35)
}
printHtmlPart(36)
invokeTag('textField','g',177,['class':("remark"),'name':("threeTwoRemark"),'id':("remarkthreeTwo"),'value':(formRemkInstance?.threeTwoRemark),'style':("display: none;")],-1)
printHtmlPart(37)
if(true && (formRemkInstance?.sevncheck == '' || formRemkInstance?.sevncheck == null)) {
printHtmlPart(38)
invokeTag('radio','g',186,['name':("sevncheck"),'id':("yessevn"),'onclick':("hide();"),'value':("true")],-1)
printHtmlPart(31)
invokeTag('radio','g',187,['name':("sevncheck"),'id':("nosevn"),'onclick':("show();"),'value':("false")],-1)
printHtmlPart(35)
}
printHtmlPart(39)
if(true && (formRemkInstance?.sevncheck == false)) {
printHtmlPart(38)
invokeTag('radio','g',190,['name':("sevncheck"),'id':("yessevn"),'onclick':("hide();"),'value':("true")],-1)
printHtmlPart(31)
invokeTag('radio','g',191,['name':("sevncheck"),'id':("nosevn"),'onclick':("show();"),'value':("false"),'checked':("true")],-1)
printHtmlPart(35)
}
printHtmlPart(40)
if(true && (formRemkInstance?.sevncheck == true)) {
printHtmlPart(41)
invokeTag('radio','g',196,['name':("sevncheck"),'id':("yessevn"),'onclick':("hide();"),'value':("true"),'checked':("true")],-1)
printHtmlPart(31)
invokeTag('radio','g',197,['name':("sevncheck"),'id':("nosevn"),'onclick':("show();"),'value':("false")],-1)
printHtmlPart(35)
}
printHtmlPart(42)
invokeTag('textField','g',202,['class':("remark"),'name':("sevnRemark"),'id':("remarksevn"),'value':(formRemkInstance?.sevnRemark),'style':("display: none;")],-1)
printHtmlPart(43)
if(true && (formRemkInstance?.letterBoardChk == '' || formRemkInstance?.letterBoardChk == null)) {
printHtmlPart(38)
invokeTag('radio','g',211,['name':("letterBoardChk"),'value':("true")],-1)
printHtmlPart(31)
invokeTag('radio','g',211,['name':("letterBoardChk"),'value':("false")],-1)
printHtmlPart(44)
invokeTag('radio','g',212,['name':("letterBoardChk"),'value':("notAvailable")],-1)
printHtmlPart(45)
}
printHtmlPart(46)
if(true && (formRemkInstance?.letterBoardChk == "true")) {
printHtmlPart(38)
invokeTag('radio','g',213,['name':("letterBoardChk"),'value':("true"),'checked':("true")],-1)
printHtmlPart(47)
invokeTag('radio','g',214,['name':("letterBoardChk"),'value':("false")],-1)
printHtmlPart(44)
invokeTag('radio','g',214,['name':("letterBoardChk"),'value':("notAvailable")],-1)
printHtmlPart(45)
}
printHtmlPart(46)
if(true && (formRemkInstance?.letterBoardChk == "false")) {
printHtmlPart(38)
invokeTag('radio','g',219,['name':("letterBoardChk"),'value':("true")],-1)
printHtmlPart(48)
invokeTag('radio','g',219,['name':("letterBoardChk"),'value':("false"),'checked':("true")],-1)
printHtmlPart(44)
invokeTag('radio','g',220,['name':("letterBoardChk"),'value':("notAvailable")],-1)
printHtmlPart(45)
}
printHtmlPart(46)
if(true && (formRemkInstance?.letterBoardChk == "notAvailable")) {
printHtmlPart(38)
invokeTag('radio','g',225,['name':("letterBoardChk"),'value':("true")],-1)
printHtmlPart(48)
invokeTag('radio','g',225,['name':("letterBoardChk"),'value':("false")],-1)
printHtmlPart(44)
invokeTag('radio','g',227,['name':("letterBoardChk"),'value':("notAvailable"),'checked':("true")],-1)
printHtmlPart(45)
}
printHtmlPart(42)
invokeTag('textField','g',231,['class':("remark"),'name':("letterBoardRemark"),'value':(formRemkInstance?.letterBoardRemark)],-1)
printHtmlPart(49)
if(true && (formRemkInstance?.holdingPatternChk == '' || formRemkInstance?.holdingPatternChk == null)) {
printHtmlPart(50)
invokeTag('radio','g',240,['name':("holdingPatternChk"),'value':("true")],-1)
printHtmlPart(47)
invokeTag('radio','g',240,['name':("holdingPatternChk"),'value':("false")],-1)
printHtmlPart(44)
invokeTag('radio','g',241,['name':("holdingPatternChk"),'value':("notAvailable")],-1)
printHtmlPart(45)
}
printHtmlPart(46)
if(true && (formRemkInstance?.holdingPatternChk == "true")) {
printHtmlPart(50)
invokeTag('radio','g',244,['name':("holdingPatternChk"),'value':("true"),'checked':("true")],-1)
printHtmlPart(47)
invokeTag('radio','g',245,['name':("holdingPatternChk"),'value':("false")],-1)
printHtmlPart(44)
invokeTag('radio','g',246,['name':("holdingPatternChk"),'value':("notAvailable")],-1)
printHtmlPart(45)
}
printHtmlPart(46)
if(true && (formRemkInstance?.holdingPatternChk == "false")) {
printHtmlPart(50)
invokeTag('radio','g',251,['name':("holdingPatternChk"),'value':("true")],-1)
printHtmlPart(47)
invokeTag('radio','g',252,['name':("holdingPatternChk"),'value':("false"),'checked':("true")],-1)
printHtmlPart(44)
invokeTag('radio','g',253,['name':("holdingPatternChk"),'value':("notAvailable")],-1)
printHtmlPart(45)
}
printHtmlPart(46)
if(true && (formRemkInstance?.holdingPatternChk == "notAvailable")) {
printHtmlPart(50)
invokeTag('radio','g',258,['name':("holdingPatternChk"),'value':("true")],-1)
printHtmlPart(47)
invokeTag('radio','g',259,['name':("holdingPatternChk"),'value':("false")],-1)
printHtmlPart(44)
invokeTag('radio','g',260,['name':("holdingPatternChk"),'value':("notAvailable"),'checked':("true")],-1)
printHtmlPart(45)
}
printHtmlPart(51)
invokeTag('textField','g',264,['class':("remark"),'name':("holdingPatternRemark"),'value':(formRemkInstance?.holdingPatternRemark)],-1)
printHtmlPart(52)
if(true && (formDetails?.iprDetails)) {
printHtmlPart(53)
for( datePatent in (formDetails?.iprDetails) ) {
printHtmlPart(54)
invokeTag('formatDate','g',276,['format':("dd/MM/yyyy"),'date':(datePatent?.patentApplicationDate)],-1)
printHtmlPart(55)
}
printHtmlPart(56)
}
printHtmlPart(42)
invokeTag('textField','g',281,['class':("remark"),'name':("patentDateRmk"),'value':(formRemkInstance?.patentDateRmk)],-1)
printHtmlPart(57)
if(true && (formDetails.isApprovalOfNbaObtainedForm3 == 'true')) {
printHtmlPart(58)
expressionOut.print(formDetails?.applicationNo)
printHtmlPart(59)
expressionOut.print(formDetails?.dateOfApproval?.format('dd/MM/yyyy'))
printHtmlPart(60)
createClosureForHtmlPart(61, 2)
invokeTag('link','g',299,['controller':("form3"),'action':("showDc"),'id':(formDetails?.id),'target':("_blank"),'params':([filename: "nbaApprovalFileName", dataName: "nbaApprovalFileName",csrfPreventionSalt:"${csrfPreventionSalt}"])],2)
printHtmlPart(62)
}
else {
printHtmlPart(63)
}
printHtmlPart(64)
invokeTag('textField','g',302,['class':("remark"),'name':("priorApprovalOfNBARmk"),'value':(formRemkInstance?.priorApprovalOfNBARmk)],-1)
printHtmlPart(65)
if(true && (formRemkInstance?.patentAlreadyChk == '' || formRemkInstance?.patentAlreadyChk == null)) {
printHtmlPart(30)
invokeTag('radio','g',318,['name':("patentAlreadyChk"),'value':("true")],-1)
printHtmlPart(31)
invokeTag('radio','g',318,['name':("patentAlreadyChk"),'value':("false")],-1)
printHtmlPart(66)
invokeTag('radio','g',319,['name':("patentAlreadyChk"),'value':("needAditionalInfo")],-1)
printHtmlPart(67)
}
printHtmlPart(33)
if(true && (formRemkInstance?.patentAlreadyChk  == 'false')) {
printHtmlPart(30)
invokeTag('radio','g',324,['name':("patentAlreadyChk"),'value':("true")],-1)
printHtmlPart(47)
invokeTag('radio','g',325,['name':("patentAlreadyChk"),'value':("false"),'checked':("true")],-1)
printHtmlPart(68)
invokeTag('radio','g',326,['name':("patentAlreadyChk"),'value':("needAditionalInfo")],-1)
printHtmlPart(69)
}
printHtmlPart(9)
if(true && (formRemkInstance?.patentAlreadyChk  == 'true')) {
printHtmlPart(34)
invokeTag('radio','g',331,['name':("patentAlreadyChk"),'value':("true"),'checked':("true")],-1)
printHtmlPart(47)
invokeTag('radio','g',332,['name':("patentAlreadyChk"),'value':("false")],-1)
printHtmlPart(70)
invokeTag('radio','g',333,['name':("patentAlreadyChk"),'value':("needAditionalInfo")],-1)
printHtmlPart(71)
}
printHtmlPart(9)
if(true && (formRemkInstance?.patentAlreadyChk  == 'needAditionalInfo')) {
printHtmlPart(72)
invokeTag('radio','g',338,['name':("patentAlreadyChk"),'value':("true")],-1)
printHtmlPart(73)
invokeTag('radio','g',339,['name':("patentAlreadyChk"),'value':("false")],-1)
printHtmlPart(74)
invokeTag('radio','g',340,['name':("patentAlreadyChk"),'value':("needAditionalInfo"),'checked':("true")],-1)
printHtmlPart(75)
}
printHtmlPart(76)
invokeTag('textField','g',343,['name':("patentAlreadyRemk"),'value':(formRemkInstance?.patentAlreadyRemk)],-1)
printHtmlPart(77)
if(true && (formRemkInstance?.vettingChk == '' || formRemkInstance?.vettingChk == null)) {
printHtmlPart(38)
invokeTag('radio','g',354,['name':("vettingChk"),'value':("true")],-1)
printHtmlPart(31)
invokeTag('radio','g',355,['name':("vettingChk"),'value':("false")],-1)
printHtmlPart(78)
invokeTag('radio','g',355,['name':("vettingChk"),'value':("needAditionalInfo")],-1)
printHtmlPart(79)
}
printHtmlPart(80)
if(true && (formRemkInstance?.vettingChk == "true")) {
printHtmlPart(38)
invokeTag('radio','g',358,['name':("vettingChk"),'value':("true"),'checked':("true")],-1)
printHtmlPart(31)
invokeTag('radio','g',358,['name':("vettingChk"),'value':("false")],-1)
printHtmlPart(78)
invokeTag('radio','g',358,['name':("vettingChk"),'value':("needAditionalInfo")],-1)
printHtmlPart(79)
}
printHtmlPart(80)
if(true && (formRemkInstance?.vettingChk == "false")) {
printHtmlPart(38)
invokeTag('radio','g',363,['name':("vettingChk"),'value':("true")],-1)
printHtmlPart(31)
invokeTag('radio','g',363,['name':("vettingChk"),'value':("false"),'checked':("true")],-1)
printHtmlPart(78)
invokeTag('radio','g',364,['name':("vettingChk"),'value':("needAditionalInfo")],-1)
printHtmlPart(79)
}
printHtmlPart(80)
if(true && (formRemkInstance?.vettingChk == "needAditionalInfo")) {
printHtmlPart(81)
invokeTag('radio','g',368,['name':("vettingChk"),'value':("true")],-1)
printHtmlPart(31)
invokeTag('radio','g',368,['name':("vettingChk"),'value':("false")],-1)
printHtmlPart(78)
invokeTag('radio','g',369,['name':("vettingChk"),'value':("needAditionalInfo"),'checked':("true")],-1)
printHtmlPart(79)
}
printHtmlPart(82)
invokeTag('textField','g',373,['class':("remark"),'name':("vettingRemark"),'value':(formRemkInstance?.vettingRemark)],-1)
printHtmlPart(83)
if(true && (formRemkInstance?.orderChk == '' || formRemkInstance?.orderChk == null)) {
printHtmlPart(84)
invokeTag('radio','g',382,['name':("orderChk"),'value':("true")],-1)
printHtmlPart(48)
invokeTag('radio','g',383,['name':("orderChk"),'value':("false")],-1)
printHtmlPart(85)
invokeTag('radio','g',383,['name':("orderChk"),'value':("needAditionalInfo")],-1)
printHtmlPart(86)
}
printHtmlPart(80)
if(true && (formRemkInstance?.orderChk == "true")) {
printHtmlPart(38)
invokeTag('radio','g',385,['name':("orderChk"),'value':("true"),'checked':("true")],-1)
printHtmlPart(48)
invokeTag('radio','g',386,['name':("orderChk"),'value':("false")],-1)
printHtmlPart(78)
invokeTag('radio','g',387,['name':("orderChk"),'value':("needAditionalInfo")],-1)
printHtmlPart(87)
}
printHtmlPart(80)
if(true && (formRemkInstance?.orderChk == "false")) {
printHtmlPart(38)
invokeTag('radio','g',390,['name':("orderChk"),'value':("true")],-1)
printHtmlPart(48)
invokeTag('radio','g',391,['name':("orderChk"),'value':("false"),'checked':("true")],-1)
printHtmlPart(78)
invokeTag('radio','g',392,['name':("orderChk"),'value':("needAditionalInfo")],-1)
printHtmlPart(87)
}
printHtmlPart(80)
if(true && (formRemkInstance?.orderChk == "needAditionalInfo")) {
printHtmlPart(88)
invokeTag('radio','g',396,['name':("orderChk"),'value':("true")],-1)
printHtmlPart(48)
invokeTag('radio','g',396,['name':("orderChk"),'value':("false")],-1)
printHtmlPart(78)
invokeTag('radio','g',398,['name':("orderChk"),'value':("needAditionalInfo"),'checked':("true")],-1)
printHtmlPart(87)
}
printHtmlPart(89)
invokeTag('textField','g',400,['class':("remark"),'name':("orderRemark"),'value':(formRemkInstance?.orderRemark)],-1)
printHtmlPart(90)
invokeTag('textField','g',410,['class':("remark"),'name':("splObservation"),'value':(formRemkInstance?.splObservation)],-1)
printHtmlPart(91)
invokeTag('textField','g',412,['name':("splObservationRmk"),'value':(formRemkInstance?.splObservationRmk)],-1)
printHtmlPart(92)
if(true && (formRemkInstance?.violationChk == '' || formRemkInstance?.violationChk == null)) {
printHtmlPart(38)
invokeTag('radio','g',423,['name':("violationChk"),'onclick':("trshow('yes');"),'value':("true")],-1)
printHtmlPart(93)
invokeTag('radio','g',423,['name':("violationChk"),'onclick':("trshow('no');"),'value':("false")],-1)
printHtmlPart(94)
}
printHtmlPart(95)
if(true && (formRemkInstance?.violationChk == true)) {
printHtmlPart(18)
createClosureForHtmlPart(96, 2)
invokeTag('javascript','g',425,[:],2)
printHtmlPart(97)
invokeTag('radio','g',426,['name':("violationChk"),'value':("true"),'checked':("true")],-1)
printHtmlPart(93)
invokeTag('radio','g',427,['name':("violationChk"),'value':("false")],-1)
printHtmlPart(98)
}
printHtmlPart(95)
if(true && (formRemkInstance?.violationChk == false)) {
printHtmlPart(38)
invokeTag('radio','g',433,['name':("violationChk"),'value':("true")],-1)
printHtmlPart(93)
invokeTag('radio','g',434,['name':("violationChk"),'value':("false"),'checked':("true")],-1)
printHtmlPart(99)
}
printHtmlPart(100)
invokeTag('textField','g',436,['class':("remark"),'name':("violationRemark"),'value':(formRemkInstance?.violationRemark)],-1)
printHtmlPart(101)
invokeTag('select','g',447,['name':("sectionData"),'from':(vioSection),'value':(formRemkInstance?.violationSelect),'id':("pickSec")],-1)
printHtmlPart(102)
if(true && (formRemkInstance?.violationSelect)) {
printHtmlPart(33)
createClosureForHtmlPart(103, 2)
invokeTag('javascript','g',452,[:],2)
printHtmlPart(104)
}
printHtmlPart(105)
invokeTag('textArea','g',457,['class':("remark"),'name':(" violationSelect"),'value':(formRemkInstance?.violationSelect),'id':("showSectionVal"),'style':("display: none;"),'rows':("2"),'cols':("25")],-1)
printHtmlPart(106)
invokeTag('textArea','g',469,['class':("remark"),'style':(" display:none;"),'name':("additional"),'value':(formRemkInstance?.additional)],-1)
printHtmlPart(107)
if(true && (formRemkInstance == null || formRemkInstance == '')) {
printHtmlPart(108)
}
else {
printHtmlPart(109)
}
printHtmlPart(110)
if(true && (formRemkInstance != null || formRemkInstance != '')) {
printHtmlPart(111)
loop:{
int k = 0
for( quesAnswer in (formRemkInstance?.questionAnswers) ) {
printHtmlPart(112)
expressionOut.print(k+1)
printHtmlPart(113)
expressionOut.print(k+1)
printHtmlPart(114)
expressionOut.print(k+20)
printHtmlPart(115)
invokeTag('textArea','g',480,['class':("remark"),'name':("quesValues${k+1}"),'id':("qut${k+1}"),'value':(quesAnswer?.question),'rows':("3"),'cols':("40")],-1)
printHtmlPart(116)
invokeTag('textArea','g',486,['class':("remark"),'name':("ansValues${k+1}"),'id':("qes${k+1}"),'value':(quesAnswer?.answer),'rows':("3"),'cols':("40")],-1)
printHtmlPart(117)
expressionOut.print(k+1)
printHtmlPart(118)
expressionOut.print(quesAnswer?.id)
printHtmlPart(119)
expressionOut.print(k+1)
printHtmlPart(118)
expressionOut.print(quesAnswer?.id)
printHtmlPart(120)
k++
}
}
printHtmlPart(111)
}
printHtmlPart(121)
invokeTag('textArea','g',495,['name':("quesValues"),'class':("ques"),'style':("width:100%")],-1)
printHtmlPart(122)
invokeTag('textArea','g',496,['name':("ansValues"),'class':("ans"),'style':("width:100%")],-1)
printHtmlPart(123)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1645087596039L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
