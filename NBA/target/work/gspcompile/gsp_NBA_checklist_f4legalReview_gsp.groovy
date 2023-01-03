import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_NBA_checklist_f4legalReview_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/checklist/_f4legalReview.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
expressionOut.print(formDetails?.appNumber)
printHtmlPart(1)
invokeTag('textField','g',18,['class':("remark"),'name':("onlineAppNumberRmk"),'value':(formRemkInstance?.onlineAppNumberRmk)],-1)
printHtmlPart(2)
if(true && (nbaReferenceNum)) {
printHtmlPart(3)
invokeTag('textField','g',25,['class':("remark"),'name':("refNumber"),'value':(nbaReferenceNum)],-1)
printHtmlPart(4)
}
else {
printHtmlPart(5)
invokeTag('textField','g',29,['class':("remark"),'name':("refNumber"),'value':(formRemkInstance?.nbaRefNumber)],-1)
printHtmlPart(6)
}
printHtmlPart(7)
invokeTag('textField','g',31,['class':("remark"),'name':("nbaRefNumberRemark"),'value':(formRemkInstance?.nbaRefNumberRemark)],-1)
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
printHtmlPart(1)
invokeTag('textField','g',47,['class':("remark"),'colspan':("4"),'name':("appltcatg"),'value':(formRemkInstance?.applicantCatgRmk)],-1)
printHtmlPart(14)
if(true && (formDetails?.individualProfiles)) {
printHtmlPart(10)
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
printHtmlPart(10)
}
printHtmlPart(18)
}
else if(true && (formDetails?.companyProfiles)) {
printHtmlPart(10)
loop:{
int k = 0
for( company in (formDetails?.companyProfiles) ) {
printHtmlPart(16)
expressionOut.print(company?.entityName)
printHtmlPart(19)
expressionOut.print(company?.address1)
expressionOut.print(company?.address2)
expressionOut.print(company?.address3)
printHtmlPart(20)
expressionOut.print(company?.city)
printHtmlPart(21)
k++
}
}
printHtmlPart(18)
}
else if(true && (formDetails?.indianResearcher)) {
printHtmlPart(10)
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
printHtmlPart(10)
}
printHtmlPart(18)
}
else if(true && (formDetails?.depostionOfMicroOrganism)) {
printHtmlPart(10)
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
printHtmlPart(10)
}
printHtmlPart(18)
}
else if(true && (formDetails?.indianGovtInst)) {
printHtmlPart(10)
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
printHtmlPart(10)
}
printHtmlPart(18)
}
printHtmlPart(1)
invokeTag('textField','g',105,['class':("remark"),'name':("appltname"),'value':(formRemkInstance?.applicantNameContRmk)],-1)
printHtmlPart(22)
if(true && (formDetails?.companyProfiles)) {
printHtmlPart(18)
for( company in (formDetails?.companyProfiles) ) {
printHtmlPart(18)
expressionOut.print(company?.title)
printHtmlPart(23)
expressionOut.print(company?.firstName)
printHtmlPart(23)
expressionOut.print(company?.middleName)
printHtmlPart(23)
expressionOut.print(company?.lastName)
printHtmlPart(24)
expressionOut.print(company?.personMobile)
printHtmlPart(25)
expressionOut.print(company?.personEmail)
printHtmlPart(18)
}
printHtmlPart(18)
}
else {
printHtmlPart(26)
}
printHtmlPart(27)
invokeTag('textField','g',123,['class':("remark"),'name':("nameandComp"),'value':(formRemkInstance?.authPersonContRmk)],-1)
printHtmlPart(28)
if(true && (formDetails?.agentProfile)) {
printHtmlPart(18)
expressionOut.print(formDetails?.agentProfile?.title)
printHtmlPart(23)
expressionOut.print(formDetails?.agentProfile?.firstName)
printHtmlPart(18)
expressionOut.print(formDetails?.agentProfile?.middleName)
printHtmlPart(23)
expressionOut.print(formDetails?.agentProfile?.lastName)
printHtmlPart(29)
expressionOut.print(formDetails?.agentProfile?.address1)
printHtmlPart(23)
expressionOut.print(formDetails?.agentProfile?.address2)
printHtmlPart(18)
expressionOut.print(formDetails?.agentProfile?.address3)
printHtmlPart(30)
expressionOut.print(formDetails?.agentProfile?.city)
printHtmlPart(18)
}
else {
printHtmlPart(31)
}
printHtmlPart(32)
invokeTag('textField','g',142,['class':("remark"),'name':("agent"),'value':(formRemkInstance?.attorneyInIndiaContRmk)],-1)
printHtmlPart(33)
invokeTag('textField','g',154,['class':("remark"),'name':("formCatg"),'value':(formRemkInstance?.appFormCatgRmk)],-1)
printHtmlPart(34)
if(true && (formRemkInstance?.threeTwocheck == '' || formRemkInstance?.threeTwocheck == null)) {
printHtmlPart(35)
invokeTag('radio','g',163,['name':("threeTwocheck"),'id':("yesthreeTwo"),'onclick':("hideText();"),'value':("true")],-1)
printHtmlPart(36)
invokeTag('radio','g',164,['name':("threeTwocheck"),'id':("nothreeTwo"),'onclick':("showText();"),'value':("false")],-1)
printHtmlPart(37)
}
printHtmlPart(38)
if(true && (formRemkInstance?.threeTwocheck == false)) {
printHtmlPart(39)
invokeTag('radio','g',168,['name':("threeTwocheck"),'id':("yesthreeTwo"),'onclick':("hideText();"),'value':("true")],-1)
printHtmlPart(36)
invokeTag('radio','g',169,['name':("threeTwocheck"),'id':("nothreeTwo"),'onclick':("showText();"),'value':("false"),'checked':("true")],-1)
printHtmlPart(37)
}
printHtmlPart(10)
if(true && (formRemkInstance?.threeTwocheck == true)) {
printHtmlPart(40)
invokeTag('radio','g',173,['name':("threeTwocheck"),'id':("yesthreeTwo"),'onclick':("hideText();"),'value':("true"),'checked':("true")],-1)
printHtmlPart(36)
invokeTag('radio','g',174,['name':("threeTwocheck"),'id':("nothreeTwo"),'onclick':("showText();"),'value':("false")],-1)
printHtmlPart(41)
}
printHtmlPart(42)
invokeTag('textField','g',179,['class':("remark"),'name':("threeTwoRemark"),'id':("remarkthreeTwo"),'value':(formRemkInstance?.threeTwoRemark),'style':("display: none;")],-1)
printHtmlPart(43)
if(true && (formRemkInstance?.sevncheck == '' || formRemkInstance?.sevncheck == null)) {
printHtmlPart(5)
invokeTag('radio','g',188,['name':("sevncheck"),'id':("yessevn"),'onclick':("hide();"),'value':("true")],-1)
printHtmlPart(36)
invokeTag('radio','g',189,['name':("sevncheck"),'id':("nosevn"),'onclick':("show();"),'value':("false")],-1)
printHtmlPart(41)
}
printHtmlPart(44)
if(true && (formRemkInstance?.sevncheck == false)) {
printHtmlPart(5)
invokeTag('radio','g',193,['name':("sevncheck"),'id':("yessevn"),'onclick':("hide();"),'value':("true")],-1)
printHtmlPart(36)
invokeTag('radio','g',194,['name':("sevncheck"),'id':("nosevn"),'onclick':("show();"),'value':("false"),'checked':("true")],-1)
printHtmlPart(41)
}
printHtmlPart(45)
if(true && (formRemkInstance?.sevncheck == true)) {
printHtmlPart(46)
invokeTag('radio','g',199,['name':("sevncheck"),'id':("yessevn"),'onclick':("hide();"),'value':("true"),'checked':("true")],-1)
printHtmlPart(36)
invokeTag('radio','g',200,['name':("sevncheck"),'id':("nosevn"),'onclick':("show();"),'value':("false")],-1)
printHtmlPart(41)
}
printHtmlPart(47)
invokeTag('textField','g',205,['class':("remark"),'name':("sevnRemark"),'id':("remarksevn"),'value':(formRemkInstance?.sevnRemark),'style':("display: none;")],-1)
printHtmlPart(48)
if(true && (formRemkInstance?.letterBoardChk == '' || formRemkInstance?.letterBoardChk == null)) {
printHtmlPart(5)
invokeTag('radio','g',214,['name':("letterBoardChk"),'value':("true")],-1)
printHtmlPart(36)
invokeTag('radio','g',215,['name':("letterBoardChk"),'value':("false")],-1)
printHtmlPart(49)
invokeTag('radio','g',216,['name':("letterBoardChk"),'value':("notAvailable")],-1)
printHtmlPart(50)
}
printHtmlPart(51)
if(true && (formRemkInstance?.letterBoardChk == "true")) {
printHtmlPart(5)
invokeTag('radio','g',217,['name':("letterBoardChk"),'value':("true"),'checked':("true")],-1)
printHtmlPart(52)
invokeTag('radio','g',217,['name':("letterBoardChk"),'value':("false")],-1)
printHtmlPart(49)
invokeTag('radio','g',218,['name':("letterBoardChk"),'value':("notAvailable")],-1)
printHtmlPart(50)
}
printHtmlPart(51)
if(true && (formRemkInstance?.letterBoardChk == "false")) {
printHtmlPart(5)
invokeTag('radio','g',222,['name':("letterBoardChk"),'value':("true")],-1)
printHtmlPart(53)
invokeTag('radio','g',223,['name':("letterBoardChk"),'value':("false"),'checked':("true")],-1)
printHtmlPart(49)
invokeTag('radio','g',224,['name':("letterBoardChk"),'value':("notAvailable")],-1)
printHtmlPart(50)
}
printHtmlPart(51)
if(true && (formRemkInstance?.letterBoardChk == "notAvailable")) {
printHtmlPart(5)
invokeTag('radio','g',228,['name':("letterBoardChk"),'value':("true")],-1)
printHtmlPart(53)
invokeTag('radio','g',229,['name':("letterBoardChk"),'value':("false")],-1)
printHtmlPart(49)
invokeTag('radio','g',230,['name':("letterBoardChk"),'value':("notAvailable"),'checked':("true")],-1)
printHtmlPart(50)
}
printHtmlPart(54)
invokeTag('textField','g',234,['class':("remark"),'name':("letterBoardRemark"),'value':(formRemkInstance?.letterBoardRemark)],-1)
printHtmlPart(55)
if(true && (formRemkInstance?.holdingPatternChk == '' || formRemkInstance?.holdingPatternChk == null)) {
printHtmlPart(39)
invokeTag('radio','g',244,['name':("holdingPatternChk"),'value':("true")],-1)
printHtmlPart(52)
invokeTag('radio','g',245,['name':("holdingPatternChk"),'value':("false")],-1)
printHtmlPart(49)
invokeTag('radio','g',246,['name':("holdingPatternChk"),'value':("notAvailable")],-1)
printHtmlPart(50)
}
printHtmlPart(51)
if(true && (formRemkInstance?.holdingPatternChk == "true")) {
printHtmlPart(39)
invokeTag('radio','g',249,['name':("holdingPatternChk"),'value':("true"),'checked':("true")],-1)
printHtmlPart(52)
invokeTag('radio','g',250,['name':("holdingPatternChk"),'value':("false")],-1)
printHtmlPart(49)
invokeTag('radio','g',251,['name':("holdingPatternChk"),'value':("notAvailable")],-1)
printHtmlPart(50)
}
printHtmlPart(51)
if(true && (formRemkInstance?.holdingPatternChk == "false")) {
printHtmlPart(39)
invokeTag('radio','g',255,['name':("holdingPatternChk"),'value':("true")],-1)
printHtmlPart(52)
invokeTag('radio','g',257,['name':("holdingPatternChk"),'value':("false"),'checked':("true")],-1)
printHtmlPart(49)
invokeTag('radio','g',258,['name':("holdingPatternChk"),'value':("notAvailable")],-1)
printHtmlPart(50)
}
printHtmlPart(51)
if(true && (formRemkInstance?.holdingPatternChk == "notAvailable")) {
printHtmlPart(39)
invokeTag('radio','g',263,['name':("holdingPatternChk"),'value':("true")],-1)
printHtmlPart(52)
invokeTag('radio','g',264,['name':("holdingPatternChk"),'value':("false")],-1)
printHtmlPart(49)
invokeTag('radio','g',265,['name':("holdingPatternChk"),'value':("notAvailable"),'checked':("true")],-1)
printHtmlPart(50)
}
printHtmlPart(54)
invokeTag('textField','g',269,['class':("remark"),'name':("holdingPatternRemark"),'value':(formRemkInstance?.holdingPatternRemark)],-1)
printHtmlPart(56)
if(true && (formRemkInstance?.priorApprovalOfNBA == '' || formRemkInstance?.priorApprovalOfNBA == null)) {
printHtmlPart(5)
invokeTag('radio','g',281,['name':("priorApprovalOfNBA"),'value':("true")],-1)
printHtmlPart(36)
invokeTag('radio','g',282,['name':("priorApprovalOfNBA"),'value':("false")],-1)
printHtmlPart(49)
invokeTag('radio','g',283,['name':("priorApprovalOfNBA"),'value':("notAvailable")],-1)
printHtmlPart(50)
}
printHtmlPart(51)
if(true && (formRemkInstance?.priorApprovalOfNBA == "true")) {
printHtmlPart(5)
invokeTag('radio','g',284,['name':("priorApprovalOfNBA"),'value':("true"),'checked':("true")],-1)
printHtmlPart(52)
invokeTag('radio','g',285,['name':("priorApprovalOfNBA"),'value':("false")],-1)
printHtmlPart(49)
invokeTag('radio','g',286,['name':("priorApprovalOfNBA"),'value':("notAvailable")],-1)
printHtmlPart(50)
}
printHtmlPart(51)
if(true && (formRemkInstance?.priorApprovalOfNBA == "false")) {
printHtmlPart(5)
invokeTag('radio','g',289,['name':("priorApprovalOfNBA"),'value':("true")],-1)
printHtmlPart(53)
invokeTag('radio','g',291,['name':("priorApprovalOfNBA"),'value':("false"),'checked':("true")],-1)
printHtmlPart(49)
invokeTag('radio','g',292,['name':("priorApprovalOfNBA"),'value':("notAvailable")],-1)
printHtmlPart(50)
}
printHtmlPart(51)
if(true && (formRemkInstance?.priorApprovalOfNBA == "notAvailable")) {
printHtmlPart(5)
invokeTag('radio','g',296,['name':("priorApprovalOfNBA"),'value':("true")],-1)
printHtmlPart(53)
invokeTag('radio','g',296,['name':("priorApprovalOfNBA"),'value':("false")],-1)
printHtmlPart(49)
invokeTag('radio','g',298,['name':("priorApprovalOfNBA"),'value':("notAvailable"),'checked':("true")],-1)
printHtmlPart(50)
}
printHtmlPart(42)
invokeTag('textField','g',302,['class':("remark"),'name':("priorApprovalOfNBARmk"),'value':(formRemkInstance?.priorApprovalOfNBARmk)],-1)
printHtmlPart(57)
invokeTag('textField','g',312,['class':("remark"),'name':("purposeForTransBioResRmk"),'value':(formRemkInstance?.purposeForTransBioResRmk)],-1)
printHtmlPart(58)
expressionOut.print(formDetails?.thirdPartyTransferPurpose)
printHtmlPart(1)
invokeTag('textField','g',322,['class':("remark"),'name':("dateOfTransBioResRmk"),'value':(formRemkInstance?.dateOfTransBioResRmk)],-1)
printHtmlPart(59)
if(true && (formRemkInstance?.twoDChk == '' || formRemkInstance?.twoDChk == null)) {
printHtmlPart(5)
invokeTag('radio','g',329,['name':("twoDChk"),'value':("true")],-1)
printHtmlPart(36)
invokeTag('radio','g',330,['name':("twoDChk"),'value':("false")],-1)
printHtmlPart(60)
}
printHtmlPart(61)
if(true && (formRemkInstance?.twoDChk == true)) {
printHtmlPart(5)
invokeTag('radio','g',332,['name':("twoDChk"),'value':("true"),'checked':("true")],-1)
printHtmlPart(36)
invokeTag('radio','g',333,['name':("twoDChk"),'value':("false")],-1)
printHtmlPart(60)
}
printHtmlPart(61)
if(true && (formRemkInstance?.twoDChk == false)) {
printHtmlPart(5)
invokeTag('radio','g',337,['name':("twoDChk"),'value':("true")],-1)
printHtmlPart(36)
invokeTag('radio','g',338,['name':("twoDChk"),'value':("false"),'checked':("true")],-1)
printHtmlPart(62)
}
printHtmlPart(63)
invokeTag('textField','g',343,['class':("remark"),'name':("twoDRemark"),'value':(formRemkInstance?.twoDRemark)],-1)
printHtmlPart(64)
if(true && (formRemkInstance?.vettingChk == '' || formRemkInstance?.vettingChk == null)) {
printHtmlPart(39)
invokeTag('radio','g',353,['name':("vettingChk"),'value':("true")],-1)
printHtmlPart(36)
invokeTag('radio','g',353,['name':("vettingChk"),'value':("false")],-1)
printHtmlPart(65)
}
printHtmlPart(66)
if(true && (formRemkInstance?.vettingChk == "true")) {
printHtmlPart(39)
invokeTag('radio','g',358,['name':("vettingChk"),'value':("true"),'checked':("true")],-1)
printHtmlPart(67)
invokeTag('radio','g',359,['name':("vettingChk"),'value':("false")],-1)
printHtmlPart(65)
}
printHtmlPart(66)
if(true && (formRemkInstance?.vettingChk == "false")) {
printHtmlPart(5)
invokeTag('radio','g',364,['name':("vettingChk"),'value':("true")],-1)
printHtmlPart(36)
invokeTag('radio','g',365,['name':("vettingChk"),'value':("false"),'checked':("true")],-1)
printHtmlPart(65)
}
printHtmlPart(68)
invokeTag('textField','g',371,['class':("remark"),'name':("vettingRemark"),'value':(formRemkInstance?.vettingRemark)],-1)
printHtmlPart(69)
if(true && (formRemkInstance?.orderChk == '' || formRemkInstance?.orderChk == null)) {
printHtmlPart(5)
invokeTag('radio','g',381,['name':("orderChk"),'value':("true")],-1)
printHtmlPart(53)
invokeTag('radio','g',381,['name':("orderChk"),'value':("false")],-1)
printHtmlPart(70)
}
printHtmlPart(66)
if(true && (formRemkInstance?.orderChk == "true")) {
printHtmlPart(5)
invokeTag('radio','g',383,['name':("orderChk"),'value':("true"),'checked':("true")],-1)
printHtmlPart(53)
invokeTag('radio','g',384,['name':("orderChk"),'value':("false")],-1)
printHtmlPart(70)
}
printHtmlPart(66)
if(true && (formRemkInstance?.orderChk == "false")) {
printHtmlPart(5)
invokeTag('radio','g',388,['name':("orderChk"),'value':("true")],-1)
printHtmlPart(53)
invokeTag('radio','g',389,['name':("orderChk"),'value':("false"),'checked':("true")],-1)
printHtmlPart(70)
}
printHtmlPart(71)
invokeTag('textField','g',393,['class':("remark"),'name':("orderRemark"),'value':(formRemkInstance?.orderRemark)],-1)
printHtmlPart(72)
invokeTag('textField','g',403,['class':("remark"),'colspan':("4"),'name':("splObservation"),'value':(formRemkInstance?.splObservation)],-1)
printHtmlPart(73)
if(true && (formDetails?.thirdParty)) {
printHtmlPart(74)
loop:{
int i = 0
for( thirdParty in (formDetails?.thirdParty) ) {
printHtmlPart(75)
expressionOut.print(i+1)
printHtmlPart(76)
expressionOut.print(thirdParty?.name)
printHtmlPart(76)
expressionOut.print(thirdParty?.addressForComm)
expressionOut.print(thirdParty?.state)
printHtmlPart(77)
expressionOut.print(thirdParty?.pincode)
printHtmlPart(78)
expressionOut.print(thirdParty?.country)
printHtmlPart(79)
expressionOut.print(thirdParty?.phone)
printHtmlPart(80)
expressionOut.print(thirdParty?.email)
printHtmlPart(81)
expressionOut.print(thirdParty?.website)
printHtmlPart(82)
i++
}
}
printHtmlPart(83)
}
printHtmlPart(84)
if(true && (formRemkInstance?.violationChk == '' || formRemkInstance?.violationChk == null)) {
printHtmlPart(5)
invokeTag('radio','g',441,['name':("violationChk"),'onclick':("trshow('yes');"),'value':("true")],-1)
printHtmlPart(85)
invokeTag('radio','g',442,['name':("violationChk"),'onclick':("trshow('no');"),'value':("false")],-1)
printHtmlPart(86)
}
printHtmlPart(61)
if(true && (formRemkInstance?.violationChk == true)) {
printHtmlPart(5)
invokeTag('radio','g',444,['name':("violationChk"),'value':("true"),'checked':("true")],-1)
printHtmlPart(85)
invokeTag('radio','g',444,['name':("violationChk"),'value':("false")],-1)
printHtmlPart(86)
}
printHtmlPart(61)
if(true && (formRemkInstance?.violationChk == false)) {
printHtmlPart(5)
invokeTag('radio','g',447,['name':("violationChk"),'value':("true")],-1)
printHtmlPart(85)
invokeTag('radio','g',448,['name':("violationChk"),'value':("false"),'checked':("true")],-1)
printHtmlPart(86)
}
printHtmlPart(87)
invokeTag('textField','g',451,['class':("remark"),'colspan':("4"),'name':("violationRemark"),'value':(formRemkInstance?.violationRemark)],-1)
printHtmlPart(88)
invokeTag('select','g',460,['name':("sectionData"),'from':(vioSection),'value':(formRemkInstance?.violationSelect),'id':("pickSec")],-1)
printHtmlPart(89)
if(true && (formRemkInstance?.violationSelect)) {
printHtmlPart(38)
createClosureForHtmlPart(90, 2)
invokeTag('javascript','g',464,[:],2)
printHtmlPart(91)
}
printHtmlPart(92)
invokeTag('textArea','g',468,['class':("remark"),'name':("violationSelect"),'value':(formRemkInstance?.violationSelect),'id':("showSectionVal"),'style':("display: none;")],-1)
printHtmlPart(93)
invokeTag('textArea','g',481,['class':("remark"),'name':("additional"),'style':(" display:none;"),'value':(formRemkInstance?.additional)],-1)
printHtmlPart(94)
if(true && (formRemkInstance == null || formRemkInstance == '')) {
printHtmlPart(95)
}
else {
printHtmlPart(96)
}
printHtmlPart(97)
if(true && (formRemkInstance != null || formRemkInstance != '')) {
printHtmlPart(98)
loop:{
int k = 0
for( quesAnswer in (formRemkInstance?.questionAnswers) ) {
printHtmlPart(99)
expressionOut.print(k+1)
printHtmlPart(100)
expressionOut.print(k+1)
printHtmlPart(101)
expressionOut.print(k+22)
printHtmlPart(102)
invokeTag('textArea','g',490,['class':("remark"),'name':("quesValues${k+1}"),'id':("qut${k+1}"),'value':(quesAnswer?.question),'rows':("3"),'cols':("40")],-1)
printHtmlPart(103)
invokeTag('textArea','g',497,['class':("remark"),'name':("ansValues${k+1}"),'id':("qes${k+1}"),'value':(quesAnswer?.answer),'rows':("3"),'cols':("45")],-1)
printHtmlPart(104)
expressionOut.print(k+1)
printHtmlPart(105)
expressionOut.print(quesAnswer?.id)
printHtmlPart(106)
expressionOut.print(k+1)
printHtmlPart(105)
expressionOut.print(quesAnswer?.id)
printHtmlPart(107)
k++
}
}
printHtmlPart(98)
}
printHtmlPart(108)
invokeTag('textArea','g',505,['name':("quesValues"),'class':("ques"),'style':("width:100%")],-1)
printHtmlPart(109)
invokeTag('textArea','g',506,['name':("ansValues"),'class':("ans"),'style':("width:100%")],-1)
printHtmlPart(110)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1644833471509L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
