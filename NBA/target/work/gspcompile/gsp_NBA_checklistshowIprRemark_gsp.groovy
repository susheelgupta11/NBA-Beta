
import org.nba.common.Country

import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_NBA_checklistshowIprRemark_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/checklist/showIprRemark.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(1)
createTagBody(1, {->
printHtmlPart(0)
invokeTag('captureMeta','sitemesh',5,['gsp_sm_xmlClosingForEmptyTag':("/"),'http-equiv':("Content-Type"),'content':("text/html; charset=ISO-8859-1")],-1)
printHtmlPart(0)
invokeTag('captureMeta','sitemesh',6,['gsp_sm_xmlClosingForEmptyTag':("/"),'name':("layout"),'content':("dashPage")],-1)
printHtmlPart(0)
createTagBody(2, {->
createClosureForHtmlPart(2, 3)
invokeTag('captureTitle','sitemesh',7,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',7,[:],2)
printHtmlPart(3)
})
invokeTag('captureHead','sitemesh',11,[:],1)
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(4)
if(true && (message)) {
printHtmlPart(5)
expressionOut.print(message)
printHtmlPart(6)
}
printHtmlPart(7)
expressionOut.print(formDetails?.appNumber)
printHtmlPart(8)
expressionOut.print(formDetails?.submittedOn)
printHtmlPart(9)
createTagBody(2, {->
printHtmlPart(10)
expressionOut.print(formDetails?.titleOfIPR)
printHtmlPart(11)
expressionOut.print(formDetails?.abstractOfIPR)
printHtmlPart(12)
if(true && ("  ${formDetails?.isIPApplicationFiled == 'true'}")) {
printHtmlPart(13)
}
else {
printHtmlPart(14)
}
printHtmlPart(15)
if(true && (formDetails?.iprDetails)) {
printHtmlPart(16)
loop:{
int i = 0
for( iprDetls in (formDetails?.iprDetails) ) {
printHtmlPart(17)
expressionOut.print(i+1 ?:'NA')
printHtmlPart(18)
expressionOut.print(Country.get(iprDetls?.country)?.country)
expressionOut.print(country)
printHtmlPart(18)
expressionOut.print(iprDetls?.patentApplicationNo ?:'NA')
printHtmlPart(19)
invokeTag('formatDate','g',97,['date':(iprDetls?.patentApplicationDate),'format':("dd/MM/yyyy")],-1)
printHtmlPart(18)
expressionOut.print(iprDetls?.status ?:'NA')
printHtmlPart(18)
expressionOut.print(iprDetls?.patentNo)
printHtmlPart(20)
expressionOut.print(iprDetls?.patentDate?.format('dd/MM/yyyy'))
printHtmlPart(18)
expressionOut.print(iprDetls?.reasons ?:'NA')
printHtmlPart(18)
invokeTag('textField','g',101,['name':("patentDtsRmk"),'value':(iprRemarkInstance?.patentDtsRmk)],-1)
printHtmlPart(21)
i++
}
}
printHtmlPart(16)
}
printHtmlPart(22)
if(true && (iprRemarkInstance?.foreignPetentChk == true)) {
printHtmlPart(16)
invokeTag('radio','g',120,['name':("foreignPetentChk"),'value':("true"),'checked':("true"),'id':("yesForeign"),'onclick':("openTable()")],-1)
printHtmlPart(23)
invokeTag('radio','g',121,['name':("foreignPetentChk"),'disabled':("true"),'disabled value':("false"),'id':("noForeign"),'onclick':("openRemark()")],-1)
printHtmlPart(24)
createClosureForHtmlPart(25, 4)
invokeTag('javascript','g',123,[:],4)
printHtmlPart(26)
}
printHtmlPart(27)
if(true && (iprRemarkInstance?.foreignPetentChk == false)) {
printHtmlPart(16)
invokeTag('radio','g',128,['name':("foreignPetentChk"),'disabled':("true"),'disabled value':("true"),'id':("yesForeign"),'onclick':("openTable()")],-1)
printHtmlPart(23)
invokeTag('radio','g',129,['name':("foreignPetentChk"),'value':("false"),'checked':("true"),'id':("noForeign"),'onclick':("openRemark()")],-1)
printHtmlPart(24)
createClosureForHtmlPart(28, 4)
invokeTag('javascript','g',131,[:],4)
printHtmlPart(26)
}
printHtmlPart(29)
invokeTag('textField','g',137,['name':("foreignPatentRemark"),'class':("remark"),'id':("forePetRmk"),'value':(iprRemarkInstance?.foreignPatentRemark),'style':("display: none;")],-1)
printHtmlPart(30)
if(true && (iprRemarkInstance?.iprForignPetents)) {
printHtmlPart(16)
loop:{
int k = 0
for( iprForignPetent in (iprRemarkInstance?.iprForignPetents) ) {
printHtmlPart(31)
expressionOut.print(k+1)
printHtmlPart(32)
expressionOut.print(k+1)
printHtmlPart(33)
expressionOut.print(iprForignPetent?.serialNumber)
printHtmlPart(34)
expressionOut.print(k+1)
printHtmlPart(35)
expressionOut.print(iprForignPetent?.countryTerritoryName)
printHtmlPart(36)
expressionOut.print(k+1)
printHtmlPart(37)
expressionOut.print(iprForignPetent?.patentApplicationNum)
printHtmlPart(38)
expressionOut.print(k+1)
printHtmlPart(39)
expressionOut.print(iprForignPetent?.datePatent)
printHtmlPart(40)
expressionOut.print(k+1)
printHtmlPart(41)
expressionOut.print(iprForignPetent?.statusPatent)
printHtmlPart(42)
expressionOut.print(k+1)
printHtmlPart(43)
expressionOut.print(iprForignPetent?.patentNumAndDateIfGranted)
printHtmlPart(44)
expressionOut.print(k+1)
printHtmlPart(45)
expressionOut.print(iprForignPetent?.remarksPetent)
printHtmlPart(46)
expressionOut.print(iprForignPetent?.id)
printHtmlPart(47)
expressionOut.print(k+1)
printHtmlPart(48)
expressionOut.print(iprForignPetent?.id)
printHtmlPart(49)
expressionOut.print(k+1)
printHtmlPart(50)
k++
}
}
printHtmlPart(16)
}
else {
printHtmlPart(51)
}
printHtmlPart(52)
if(true && (iprRemarkInstance?.mtcWithPatentAppChk == true)) {
printHtmlPart(53)
invokeTag('radio','g',198,['name':("mtcWithPatentAppChk"),'checked':("true"),'onclick':("hidePatentMtc()"),'value':("true"),'id':("mtcyes")],-1)
printHtmlPart(54)
invokeTag('radio','g',199,['name':("mtcWithPatentAppChk"),'disabled':("true"),'id':("mtcno"),'onclick':("showPatentMtc()"),'value':("false")],-1)
printHtmlPart(55)
createClosureForHtmlPart(56, 4)
invokeTag('javascript','g',202,[:],4)
printHtmlPart(26)
}
printHtmlPart(53)
if(true && (iprRemarkInstance?.mtcWithPatentAppChk == false)) {
printHtmlPart(53)
invokeTag('radio','g',208,['name':("mtcWithPatentAppChk"),'disabled':("true"),'onclick':("hidePatentMtc()"),'value':("true"),'id':("mtcyes")],-1)
printHtmlPart(54)
invokeTag('radio','g',209,['name':("mtcWithPatentAppChk"),'checked':("true"),'id':("mtcno"),'onclick':("showPatentMtc()"),'value':("false")],-1)
printHtmlPart(55)
createClosureForHtmlPart(57, 4)
invokeTag('javascript','g',212,[:],4)
printHtmlPart(26)
}
printHtmlPart(58)
invokeTag('textField','g',217,['name':("mtcWithPatentAppRmk"),'id':("mtcRmk"),'value':(iprRemarkInstance?.mtcWithPatentAppRmk),'style':("display:none;")],-1)
printHtmlPart(59)
if(true && (iprRemarkInstance?.bioresourceMtcChk == true)) {
printHtmlPart(60)
invokeTag('radio','g',227,['name':("bioresourceMtcChk"),'checked':("true"),'id':("bioresMtcYes"),'onclick':("bioMtcHide();"),'value':("true")],-1)
printHtmlPart(61)
invokeTag('radio','g',228,['name':("bioresourceMtcChk"),'disabled':("true"),'value':("false"),'id':("bioresMtcNo"),'onclick':("bioMtcShow();")],-1)
printHtmlPart(24)
createClosureForHtmlPart(62, 4)
invokeTag('javascript','g',230,[:],4)
printHtmlPart(26)
}
printHtmlPart(63)
if(true && (iprRemarkInstance?.bioresourceMtcChk == false)) {
printHtmlPart(60)
invokeTag('radio','g',235,['name':("bioresourceMtcChk"),'disabled':("true"),'id':("bioresMtcYes"),'onclick':("bioMtcHide();"),'value':("true")],-1)
printHtmlPart(61)
invokeTag('radio','g',236,['name':("bioresourceMtcChk"),'checked':("true"),'value':("false"),'id':("bioresMtcNo"),'onclick':("bioMtcShow();")],-1)
printHtmlPart(24)
createClosureForHtmlPart(64, 4)
invokeTag('javascript','g',238,[:],4)
printHtmlPart(26)
}
printHtmlPart(65)
invokeTag('textField','g',243,['name':("bioresourceMtcRmk"),'id':("bioMtcRemk"),'value':(iprRemarkInstance?.bioresourceMtcRmk),'style':("display:none;")],-1)
printHtmlPart(66)
if(true && (iprRemarkInstance?.dtsCommercializationChk == true)) {
printHtmlPart(26)
invokeTag('radio','g',255,['name':("dtsCommercializationChk"),'checked':("true"),'onclick':("dtsCommTable()"),'value':("true")],-1)
printHtmlPart(67)
invokeTag('radio','g',257,['name':("dtsCommercializationChk"),'disabled':("true"),'onclick':("dtsCommShow()"),'value':("false")],-1)
printHtmlPart(68)
createClosureForHtmlPart(69, 4)
invokeTag('javascript','g',260,[:],4)
printHtmlPart(26)
}
printHtmlPart(63)
if(true && (iprRemarkInstance?.dtsCommercializationChk == false)) {
printHtmlPart(26)
invokeTag('radio','g',265,['name':("dtsCommercializationChk"),'disabled':("true"),'onclick':("dtsCommTable()"),'value':("true")],-1)
printHtmlPart(67)
invokeTag('radio','g',267,['name':("dtsCommercializationChk"),'checked':("true"),'onclick':("dtsCommShow()"),'value':("false")],-1)
printHtmlPart(68)
createClosureForHtmlPart(70, 4)
invokeTag('javascript','g',270,[:],4)
printHtmlPart(26)
}
printHtmlPart(71)
invokeTag('textField','g',276,['name':("detailsCommercialRmk"),'id':("dtsComzation"),'value':(iprRemarkInstance?.detailsCommercialRmk),'style':("display:none")],-1)
printHtmlPart(72)
invokeTag('textField','g',289,['name':("country"),'value':(iprRemarkInstance?.country)],-1)
printHtmlPart(73)
invokeTag('textField','g',290,['name':("financialYr"),'value':(iprRemarkInstance?.financialYr)],-1)
printHtmlPart(73)
invokeTag('textField','g',291,['name':("amount"),'value':(iprRemarkInstance?.amount)],-1)
printHtmlPart(73)
invokeTag('textField','g',292,['name':("remarksA"),'value':(iprRemarkInstance?.remarksA)],-1)
printHtmlPart(74)
if(true && (iprRemarkInstance?.questionAnswers)) {
printHtmlPart(75)
loop:{
int i = 0
for( quesAns in (iprRemarkInstance?.questionAnswers) ) {
printHtmlPart(76)
expressionOut.print(i+1)
printHtmlPart(77)
expressionOut.print(i+10)
printHtmlPart(78)
invokeTag('textArea','g',313,['name':("questionIPR"),'id':("ques${i+1}"),'style':("width:350px;"),'class':("form-control"),'value':(quesAns?.question)],-1)
printHtmlPart(79)
invokeTag('textArea','g',319,['name':("answerIPR"),'id':("answ${i+1}"),'style':("width:350px;"),'class':("form-control"),'value':(quesAns?.answer)],-1)
printHtmlPart(80)
expressionOut.print(i+1)
printHtmlPart(81)
expressionOut.print(quesAns?.id)
printHtmlPart(82)
expressionOut.print(i+1)
printHtmlPart(81)
expressionOut.print(quesAns?.id)
printHtmlPart(83)
i++
}
}
printHtmlPart(75)
}
printHtmlPart(84)
createClosureForHtmlPart(85, 3)
invokeTag('link','g',333,['class':("btn btn-primary pull-right"),'style':("margin-right: 12px;"),'controller':("checklist"),'action':("iprChecklist"),'target':("_blank"),'params':([id:iprRemarkInstance?.id,instance:formDetails?.id,csrfPreventionSalt:csrfPreventionSalt])],3)
printHtmlPart(86)
invokeTag('hiddenField','g',334,['name':("csrfPreventionSalt"),'value':(csrfPreventionSalt)],-1)
printHtmlPart(87)
invokeTag('hiddenField','g',334,['name':("formId"),'value':(formDetails?.id)],-1)
printHtmlPart(87)
invokeTag('hiddenField','g',334,['name':("iprInstance"),'value':(iprRemarkInstance?.id)],-1)
printHtmlPart(87)
})
invokeTag('form','g',335,['action':("saveIprReviewDetails"),'controller':("checklist")],2)
printHtmlPart(88)
invokeTag('render','g',339,['template':("/rightPane/matchdata")],-1)
printHtmlPart(89)
})
invokeTag('captureBody','sitemesh',339,[:],1)
printHtmlPart(90)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1645533920321L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
