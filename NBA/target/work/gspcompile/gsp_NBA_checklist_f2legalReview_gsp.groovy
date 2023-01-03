import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_NBA_checklist_f2legalReview_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/checklist/_f2legalReview.gsp" }
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
invokeTag('textField','g',30,['class':("remark"),'name':("refNumber"),'value':(nbaReferenceNum)],-1)
printHtmlPart(4)
}
else {
printHtmlPart(5)
invokeTag('textField','g',34,['class':("remark"),'name':("refNumber"),'value':(formRemkInstance?.nbaRefNumber)],-1)
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
invokeTag('textField','g',53,['class':("remark"),'name':("appltcatg"),'value':(formRemkInstance?.applicantCatgRmk)],-1)
printHtmlPart(15)
if(true && (formDetails?.individualProfiles)) {
printHtmlPart(10)
for( individualProfile in (formDetails?.individualProfiles) ) {
printHtmlPart(16)
expressionOut.print(individualProfile?.title)
printHtmlPart(17)
expressionOut.print(individualProfile?.firstName)
printHtmlPart(17)
expressionOut.print(individualProfile?.middleName)
printHtmlPart(17)
expressionOut.print(individualProfile?.lastName)
printHtmlPart(18)
expressionOut.print(individualProfile?.address1)
printHtmlPart(17)
expressionOut.print(individualProfile?.address2)
printHtmlPart(17)
expressionOut.print(individualProfile?.address3)
printHtmlPart(18)
expressionOut.print(individualProfile?.city)
printHtmlPart(10)
}
printHtmlPart(19)
}
else if(true && (formDetails?.companyProfiles)) {
printHtmlPart(10)
loop:{
int k = 0
for( company in (formDetails?.companyProfiles) ) {
printHtmlPart(17)
expressionOut.print(company?.entityName)
printHtmlPart(10)
k++
}
}
printHtmlPart(19)
}
else if(true && (formDetails?.indianResearcher)) {
printHtmlPart(10)
for( researcher in (formDetails?.indianResearcher) ) {
printHtmlPart(16)
expressionOut.print(researcher?.title)
printHtmlPart(17)
expressionOut.print(researcher?.firstName)
printHtmlPart(17)
expressionOut.print(researcher?.middleName)
printHtmlPart(17)
expressionOut.print(researcher?.lastName)
printHtmlPart(18)
expressionOut.print(researcher?.address1)
printHtmlPart(17)
expressionOut.print(researcher?.address2)
printHtmlPart(17)
expressionOut.print(researcher?.address3)
printHtmlPart(18)
expressionOut.print(researcher?.presentCity)
printHtmlPart(10)
}
printHtmlPart(19)
}
else if(true && (formDetails?.depostionOfMicroOrganism)) {
printHtmlPart(10)
for( depost in (formDetails?.depostionOfMicroOrganism) ) {
printHtmlPart(17)
expressionOut.print(depost?.nameOfDepositor)
printHtmlPart(18)
expressionOut.print(depost?.address1)
printHtmlPart(17)
expressionOut.print(depost?.address2)
printHtmlPart(17)
expressionOut.print(depost?.address3)
printHtmlPart(18)
expressionOut.print(depost?.city)
printHtmlPart(10)
}
printHtmlPart(19)
}
else if(true && (formDetails?.indianGovtInst)) {
printHtmlPart(10)
for( govt in (formDetails?.indianGovtInst) ) {
printHtmlPart(17)
expressionOut.print(govt?.govtInstName)
printHtmlPart(18)
expressionOut.print(govt?.address1)
printHtmlPart(17)
expressionOut.print(govt?.address2)
printHtmlPart(17)
expressionOut.print(govt?.address3)
printHtmlPart(18)
expressionOut.print(govt?.presentCity)
printHtmlPart(10)
}
printHtmlPart(19)
}
printHtmlPart(14)
invokeTag('textField','g',109,['class':("remark"),'name':("appltname"),'value':(formRemkInstance?.applicantNameContRmk)],-1)
printHtmlPart(20)
if(true && (formDetails?.companyProfiles)) {
printHtmlPart(19)
for( company in (formDetails?.companyProfiles) ) {
printHtmlPart(19)
expressionOut.print(company?.title)
printHtmlPart(21)
expressionOut.print(company?.firstName)
printHtmlPart(21)
expressionOut.print(company?.middleName)
printHtmlPart(21)
expressionOut.print(company?.lastName)
printHtmlPart(22)
expressionOut.print(company?.personMobile)
printHtmlPart(23)
expressionOut.print(company?.personEmail)
printHtmlPart(19)
}
printHtmlPart(19)
}
else {
printHtmlPart(24)
}
printHtmlPart(1)
invokeTag('textField','g',128,['class':("remark"),'name':("nameandComp"),'value':(formRemkInstance?.authPersonContRmk)],-1)
printHtmlPart(25)
if(true && (formDetails?.agentProfile)) {
printHtmlPart(19)
expressionOut.print(formDetails?.agentProfile?.title)
printHtmlPart(21)
expressionOut.print(formDetails?.agentProfile?.firstName)
printHtmlPart(19)
expressionOut.print(formDetails?.agentProfile?.middleName)
printHtmlPart(21)
expressionOut.print(formDetails?.agentProfile?.lastName)
printHtmlPart(19)
expressionOut.print(formDetails?.agentProfile?.address1)
printHtmlPart(21)
expressionOut.print(formDetails?.agentProfile?.address2)
printHtmlPart(19)
expressionOut.print(formDetails?.agentProfile?.address3)
printHtmlPart(21)
expressionOut.print(formDetails?.agentProfile?.city)
printHtmlPart(19)
}
else {
printHtmlPart(26)
}
printHtmlPart(27)
invokeTag('textField','g',147,['class':("remark"),'name':("agent"),'value':(formRemkInstance?.attorneyInIndiaContRmk)],-1)
printHtmlPart(28)
invokeTag('textField','g',159,['class':("remark"),'name':("formCatg"),'value':(formRemkInstance?.appFormCatgRmk)],-1)
printHtmlPart(29)
if(true && (formRemkInstance?.threeTwocheck == '' || formRemkInstance?.threeTwocheck == null)) {
printHtmlPart(30)
invokeTag('radio','g',172,['name':("threeTwocheck"),'id':("yesthreeTwo"),'onclick':("hideText();"),'value':("true")],-1)
printHtmlPart(31)
invokeTag('radio','g',174,['name':("threeTwocheck"),'id':("nothreeTwo"),'onclick':("showText();"),'value':("false")],-1)
printHtmlPart(32)
}
printHtmlPart(33)
if(true && (formRemkInstance?.threeTwocheck == false)) {
printHtmlPart(30)
invokeTag('radio','g',179,['name':("threeTwocheck"),'id':("yesthreeTwo"),'onclick':("hideText();"),'value':("true")],-1)
printHtmlPart(31)
invokeTag('radio','g',181,['name':("threeTwocheck"),'id':("nothreeTwo"),'onclick':("showText();"),'value':("false"),'checked':("true")],-1)
printHtmlPart(32)
}
printHtmlPart(10)
if(true && (formRemkInstance?.threeTwocheck == true)) {
printHtmlPart(34)
invokeTag('radio','g',186,['name':("threeTwocheck"),'id':("yesthreeTwo"),'onclick':("hideText();"),'value':("true"),'checked':("true")],-1)
printHtmlPart(31)
invokeTag('radio','g',187,['name':("threeTwocheck"),'id':("nothreeTwo"),'onclick':("showText();"),'value':("false")],-1)
printHtmlPart(35)
}
printHtmlPart(36)
invokeTag('textField','g',192,['class':("remark"),'name':("threeTwoRemark"),'id':("remarkthreeTwo"),'value':(formRemkInstance?.threeTwoRemark),'style':("display: none;")],-1)
printHtmlPart(37)
if(true && (formRemkInstance?.sevncheck == '' || formRemkInstance?.sevncheck == null)) {
printHtmlPart(38)
invokeTag('radio','g',205,['name':("sevncheck"),'id':("yessevn"),'onclick':("hide();"),'value':("true")],-1)
printHtmlPart(31)
invokeTag('radio','g',207,['name':("sevncheck"),'id':("nosevn"),'onclick':("show();"),'value':("false")],-1)
printHtmlPart(35)
}
printHtmlPart(39)
if(true && (formRemkInstance?.sevncheck == false)) {
printHtmlPart(38)
invokeTag('radio','g',211,['name':("sevncheck"),'id':("yessevn"),'onclick':("hide();"),'value':("true")],-1)
printHtmlPart(31)
invokeTag('radio','g',212,['name':("sevncheck"),'id':("nosevn"),'onclick':("show();"),'value':("false"),'checked':("true")],-1)
printHtmlPart(35)
}
printHtmlPart(40)
if(true && (formRemkInstance?.sevncheck == true)) {
printHtmlPart(41)
invokeTag('radio','g',217,['name':("sevncheck"),'id':("yessevn"),'onclick':("hide();"),'value':("true"),'checked':("true")],-1)
printHtmlPart(31)
invokeTag('radio','g',218,['name':("sevncheck"),'id':("nosevn"),'onclick':("show();"),'value':("false")],-1)
printHtmlPart(35)
}
printHtmlPart(36)
invokeTag('textField','g',222,['class':("remark"),'name':("sevnRemark"),'id':("remarksevn"),'value':(formRemkInstance?.sevnRemark),'style':("display: none;")],-1)
printHtmlPart(42)
if(true && (formRemkInstance?.priorApprovalOfNBA == '' || formRemkInstance?.priorApprovalOfNBA == null)) {
printHtmlPart(38)
invokeTag('radio','g',233,['name':("priorApprovalOfNBA"),'value':("true")],-1)
printHtmlPart(31)
invokeTag('radio','g',233,['name':("priorApprovalOfNBA"),'value':("false")],-1)
printHtmlPart(43)
invokeTag('radio','g',234,['name':("priorApprovalOfNBA"),'value':("notAvailable")],-1)
printHtmlPart(44)
}
printHtmlPart(45)
if(true && (formRemkInstance?.priorApprovalOfNBA == "true")) {
printHtmlPart(38)
invokeTag('radio','g',236,['name':("priorApprovalOfNBA"),'value':("true"),'checked':("true")],-1)
printHtmlPart(46)
invokeTag('radio','g',236,['name':("priorApprovalOfNBA"),'value':("false")],-1)
printHtmlPart(43)
invokeTag('radio','g',237,['name':("priorApprovalOfNBA"),'value':("notAvailable")],-1)
printHtmlPart(44)
}
printHtmlPart(45)
if(true && (formRemkInstance?.priorApprovalOfNBA == "false")) {
printHtmlPart(38)
invokeTag('radio','g',241,['name':("priorApprovalOfNBA"),'value':("true")],-1)
printHtmlPart(47)
invokeTag('radio','g',242,['name':("priorApprovalOfNBA"),'value':("false"),'checked':("true")],-1)
printHtmlPart(43)
invokeTag('radio','g',243,['name':("priorApprovalOfNBA"),'value':("notAvailable")],-1)
printHtmlPart(44)
}
printHtmlPart(45)
if(true && (formRemkInstance?.priorApprovalOfNBA == "notAvailable")) {
printHtmlPart(38)
invokeTag('radio','g',247,['name':("priorApprovalOfNBA"),'value':("true")],-1)
printHtmlPart(47)
invokeTag('radio','g',248,['name':("priorApprovalOfNBA"),'value':("false")],-1)
printHtmlPart(43)
invokeTag('radio','g',249,['name':("priorApprovalOfNBA"),'value':("notAvailable"),'checked':("true")],-1)
printHtmlPart(44)
}
printHtmlPart(48)
invokeTag('textField','g',253,['class':("remark"),'name':("priorApprovalOfNBARmk"),'value':(formRemkInstance?.priorApprovalOfNBARmk)],-1)
printHtmlPart(49)
if(true && (formRemkInstance?.letterBoardChk == '' || formRemkInstance?.letterBoardChk == null)) {
printHtmlPart(50)
invokeTag('radio','g',263,['name':("letterBoardChk"),'value':("true")],-1)
printHtmlPart(31)
invokeTag('radio','g',264,['name':("letterBoardChk"),'value':("false")],-1)
printHtmlPart(43)
invokeTag('radio','g',264,['name':("letterBoardChk"),'value':("notAvailable")],-1)
printHtmlPart(44)
}
printHtmlPart(45)
if(true && (formRemkInstance?.letterBoardChk == "true")) {
printHtmlPart(50)
invokeTag('radio','g',266,['name':("letterBoardChk"),'value':("true"),'checked':("true")],-1)
printHtmlPart(46)
invokeTag('radio','g',267,['name':("letterBoardChk"),'value':("false")],-1)
printHtmlPart(43)
invokeTag('radio','g',267,['name':("letterBoardChk"),'value':("notAvailable")],-1)
printHtmlPart(44)
}
printHtmlPart(45)
if(true && (formRemkInstance?.letterBoardChk == "false")) {
printHtmlPart(50)
invokeTag('radio','g',271,['name':("letterBoardChk"),'value':("true")],-1)
printHtmlPart(47)
invokeTag('radio','g',272,['name':("letterBoardChk"),'value':("false"),'checked':("true")],-1)
printHtmlPart(43)
invokeTag('radio','g',273,['name':("letterBoardChk"),'value':("notAvailable")],-1)
printHtmlPart(44)
}
printHtmlPart(45)
if(true && (formRemkInstance?.letterBoardChk == "notAvailable")) {
printHtmlPart(50)
invokeTag('radio','g',277,['name':("letterBoardChk"),'value':("true")],-1)
printHtmlPart(47)
invokeTag('radio','g',278,['name':("letterBoardChk"),'value':("false")],-1)
printHtmlPart(43)
invokeTag('radio','g',279,['name':("letterBoardChk"),'value':("notAvailable"),'checked':("true")],-1)
printHtmlPart(44)
}
printHtmlPart(51)
invokeTag('textField','g',283,['class':("remark"),'name':("letterBoardRemark"),'value':(formRemkInstance?.letterBoardRemark)],-1)
printHtmlPart(52)
if(true && (formRemkInstance?.holdingPatternChk == '' || formRemkInstance?.holdingPatternChk == null)) {
printHtmlPart(53)
invokeTag('radio','g',294,['name':("holdingPatternChk"),'value':("true")],-1)
printHtmlPart(46)
invokeTag('radio','g',294,['name':("holdingPatternChk"),'value':("false")],-1)
printHtmlPart(43)
invokeTag('radio','g',294,['name':("holdingPatternChk"),'value':("notAvailable")],-1)
printHtmlPart(44)
}
printHtmlPart(45)
if(true && (formRemkInstance?.holdingPatternChk == "true")) {
printHtmlPart(53)
invokeTag('radio','g',296,['name':("holdingPatternChk"),'value':("true"),'checked':("true")],-1)
printHtmlPart(46)
invokeTag('radio','g',298,['name':("holdingPatternChk"),'value':("false")],-1)
printHtmlPart(43)
invokeTag('radio','g',299,['name':("holdingPatternChk"),'value':("notAvailable")],-1)
printHtmlPart(44)
}
printHtmlPart(45)
if(true && (formRemkInstance?.holdingPatternChk == "false")) {
printHtmlPart(53)
invokeTag('radio','g',303,['name':("holdingPatternChk"),'value':("true")],-1)
printHtmlPart(46)
invokeTag('radio','g',305,['name':("holdingPatternChk"),'value':("false"),'checked':("true")],-1)
printHtmlPart(43)
invokeTag('radio','g',306,['name':("holdingPatternChk"),'value':("notAvailable")],-1)
printHtmlPart(44)
}
printHtmlPart(45)
if(true && (formRemkInstance?.holdingPatternChk == "notAvailable")) {
printHtmlPart(53)
invokeTag('radio','g',310,['name':("holdingPatternChk"),'value':("true")],-1)
printHtmlPart(46)
invokeTag('radio','g',312,['name':("holdingPatternChk"),'value':("false")],-1)
printHtmlPart(43)
invokeTag('radio','g',313,['name':("holdingPatternChk"),'value':("notAvailable"),'checked':("true")],-1)
printHtmlPart(44)
}
printHtmlPart(54)
invokeTag('textField','g',317,['class':("remark"),'name':("holdingPatternRemark"),'value':(formRemkInstance?.holdingPatternRemark)],-1)
printHtmlPart(55)
expressionOut.print(formDetails?.resultsOfResearch)
printHtmlPart(56)
invokeTag('textField','g',329,['class':("remark"),'name':("detailsResearchRmk"),'value':(formRemkInstance?.detailsResearchRmk)],-1)
printHtmlPart(57)
expressionOut.print(formDetails?.briefDescription)
printHtmlPart(58)
invokeTag('textField','g',341,['class':("remark"),'name':("briefDetailOfResearchRmk"),'value':(formRemkInstance?.briefDetailOfResearchRmk)],-1)
printHtmlPart(59)
if(true && (formRemkInstance?.isLegalIssueRmk == '' || formRemkInstance?.isLegalIssueRmk == null)) {
printHtmlPart(50)
invokeTag('radio','g',349,['name':("isLegalIssueRmk"),'value':("true")],-1)
printHtmlPart(46)
invokeTag('radio','g',349,['name':("isLegalIssueRmk"),'value':("false")],-1)
printHtmlPart(60)
}
printHtmlPart(61)
if(true && (formRemkInstance?.isLegalIssueRmk == true)) {
printHtmlPart(50)
invokeTag('radio','g',352,['name':("isLegalIssueRmk"),'value':("true"),'checked':("true")],-1)
printHtmlPart(46)
invokeTag('radio','g',352,['name':("isLegalIssueRmk"),'value':("false")],-1)
printHtmlPart(62)
}
printHtmlPart(63)
if(true && (formRemkInstance?.isLegalIssueRmk == false)) {
printHtmlPart(50)
invokeTag('radio','g',354,['name':("isLegalIssueRmk"),'value':("true")],-1)
printHtmlPart(46)
invokeTag('radio','g',356,['name':("isLegalIssueRmk"),'value':("false"),'checked':("true")],-1)
printHtmlPart(60)
}
printHtmlPart(64)
invokeTag('textField','g',359,['class':("remark"),'name':("isLegalIssueRemark"),'value':(formRemkInstance?.isLegalIssueRmk)],-1)
printHtmlPart(65)
if(true && (formRemkInstance?.twoMChk == '' || formRemkInstance?.twoMChk == null)) {
printHtmlPart(50)
invokeTag('radio','g',369,['name':("twoMChk"),'value':("true")],-1)
printHtmlPart(46)
invokeTag('radio','g',370,['name':("twoMChk"),'value':("false")],-1)
printHtmlPart(66)
}
printHtmlPart(63)
if(true && (formRemkInstance?.twoMChk == true)) {
printHtmlPart(50)
invokeTag('radio','g',371,['name':("twoMChk"),'value':("true"),'checked':("true")],-1)
printHtmlPart(46)
invokeTag('radio','g',372,['name':("twoMChk"),'value':("false")],-1)
printHtmlPart(66)
}
printHtmlPart(63)
if(true && (formRemkInstance?.twoMChk == false)) {
printHtmlPart(50)
invokeTag('radio','g',373,['name':("twoMChk"),'value':("true")],-1)
printHtmlPart(46)
invokeTag('radio','g',376,['name':("twoMChk"),'value':("false"),'checked':("true")],-1)
printHtmlPart(66)
}
printHtmlPart(67)
invokeTag('textField','g',381,['class':("remark"),'name':("twoMChkRemark"),'value':(formRemkInstance?.twoMChkRemark)],-1)
printHtmlPart(68)
if(true && (formRemkInstance?.orderChk == '' || formRemkInstance?.orderChk == null)) {
printHtmlPart(50)
invokeTag('radio','g',394,['name':("orderChk"),'value':("true")],-1)
printHtmlPart(47)
invokeTag('radio','g',396,['name':("orderChk"),'value':("false")],-1)
printHtmlPart(69)
}
printHtmlPart(70)
if(true && (formRemkInstance?.orderChk == "true")) {
printHtmlPart(50)
invokeTag('radio','g',398,['name':("orderChk"),'value':("true"),'checked':("true")],-1)
printHtmlPart(47)
invokeTag('radio','g',399,['name':("orderChk"),'value':("false")],-1)
printHtmlPart(69)
}
printHtmlPart(70)
if(true && (formRemkInstance?.orderChk == "false")) {
printHtmlPart(50)
invokeTag('radio','g',400,['name':("orderChk"),'value':("true")],-1)
printHtmlPart(47)
invokeTag('radio','g',402,['name':("orderChk"),'value':("false"),'checked':("true")],-1)
printHtmlPart(69)
}
printHtmlPart(71)
invokeTag('textField','g',405,['class':("remark"),'name':("orderRemark"),'value':(formRemkInstance?.orderRemark)],-1)
printHtmlPart(72)
invokeTag('textField','g',415,['class':("remark"),'name':("splObservation"),'value':(formRemkInstance?.splObservation)],-1)
printHtmlPart(73)
if(true && (formRemkInstance?.violationChk == '' || formRemkInstance?.violationChk == null)) {
printHtmlPart(74)
invokeTag('radio','g',432,['name':("violationChk"),'onclick':("trshow('yes');"),'value':("true")],-1)
printHtmlPart(75)
invokeTag('radio','g',432,['name':("violationChk"),'onclick':("trshow('no');"),'value':("false")],-1)
printHtmlPart(76)
}
printHtmlPart(63)
if(true && (formRemkInstance?.violationChk == true)) {
printHtmlPart(74)
invokeTag('radio','g',434,['name':("violationChk"),'value':("true"),'checked':("true")],-1)
printHtmlPart(75)
invokeTag('radio','g',435,['name':("violationChk"),'value':("false")],-1)
printHtmlPart(76)
}
printHtmlPart(63)
if(true && (formRemkInstance?.violationChk == false)) {
printHtmlPart(74)
invokeTag('radio','g',436,['name':("violationChk"),'value':("true")],-1)
printHtmlPart(75)
invokeTag('radio','g',439,['name':("violationChk"),'value':("false"),'checked':("true")],-1)
printHtmlPart(76)
}
printHtmlPart(77)
invokeTag('textField','g',440,['class':("remark"),'name':("violationRemark"),'value':(formRemkInstance?.violationRemark)],-1)
printHtmlPart(78)
invokeTag('select','g',450,['name':("sectionData"),'from':(vioSection),'value':(formRemkInstance?.violationSelect),'id':("pickSec")],-1)
printHtmlPart(79)
if(true && (formRemkInstance?.violationSelect)) {
printHtmlPart(33)
createClosureForHtmlPart(80, 2)
invokeTag('javascript','g',455,[:],2)
printHtmlPart(81)
}
printHtmlPart(7)
invokeTag('textArea','g',456,['class':("remark"),'name':("violationSelect"),'value':(formRemkInstance?.violationSelect),'id':("showSectionVal"),'style':("display: none;")],-1)
printHtmlPart(82)
invokeTag('textArea','g',467,['class':("remark"),'name':("additional"),'style':(" display:none;"),'value':(formRemkInstance?.additional)],-1)
printHtmlPart(83)
if(true && (formRemkInstance == null || formRemkInstance == '')) {
printHtmlPart(84)
}
printHtmlPart(85)
if(true && (formRemkInstance != null || formRemkInstance != '')) {
printHtmlPart(86)
loop:{
int k = 0
for( quesAnswer in (formRemkInstance?.questionAnswers) ) {
printHtmlPart(87)
expressionOut.print(k+1)
printHtmlPart(88)
expressionOut.print(k+1)
printHtmlPart(89)
expressionOut.print(k+20)
printHtmlPart(90)
invokeTag('textArea','g',481,['class':("remark"),'name':("quesValues${k+1}"),'id':("qut${k+1}"),'value':(quesAnswer?.question),'rows':("3"),'cols':("45")],-1)
printHtmlPart(91)
invokeTag('textArea','g',487,['class':("remark"),'name':("ansValues${k+1}"),'id':("qes${k+1}"),'value':(quesAnswer?.answer),'rows':("3"),'cols':("45")],-1)
printHtmlPart(92)
expressionOut.print(k+1)
printHtmlPart(93)
expressionOut.print(quesAnswer?.id)
printHtmlPart(94)
expressionOut.print(k+1)
printHtmlPart(93)
expressionOut.print(quesAnswer?.id)
printHtmlPart(95)
k++
}
}
printHtmlPart(86)
}
printHtmlPart(96)
invokeTag('textArea','g',496,['name':("quesValues"),'class':("ques"),'style':("width:100%")],-1)
printHtmlPart(97)
invokeTag('textArea','g',497,['name':("ansValues"),'class':("ans"),'style':("width:100%")],-1)
printHtmlPart(98)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1645634364629L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
