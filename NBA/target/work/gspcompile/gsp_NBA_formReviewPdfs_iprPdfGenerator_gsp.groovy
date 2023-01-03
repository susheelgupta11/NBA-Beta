
import org.nba.common.Country


import org.nba.application.FormCategory

import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_NBA_formReviewPdfs_iprPdfGenerator_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/formReviewPdfs/_iprPdfGenerator.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(0)
printHtmlPart(1)
createTagBody(1, {->
printHtmlPart(0)
invokeTag('captureMeta','sitemesh',23,['gsp_sm_xmlClosingForEmptyTag':("/"),'http-equiv':("Content-Type"),'content':("text/html; charset=ISO-8859-1")],-1)
printHtmlPart(2)
createTagBody(2, {->
createClosureForHtmlPart(3, 3)
invokeTag('captureTitle','sitemesh',25,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',25,[:],2)
printHtmlPart(4)
})
invokeTag('captureHead','sitemesh',34,[:],1)
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(5)
if(true && (formDetails?.category?.category == FormCategory.Category.Form_1)) {
printHtmlPart(6)
}
printHtmlPart(7)
if(true && (formDetails?.category?.category == FormCategory.Category.Form_2)) {
printHtmlPart(8)
}
printHtmlPart(7)
if(true && (formDetails?.category?.category == FormCategory.Category.Form_3)) {
printHtmlPart(9)
}
printHtmlPart(7)
if(true && (formDetails?.category?.category == FormCategory.Category.Form_4)) {
printHtmlPart(10)
}
printHtmlPart(7)
if(true && (formDetails?.category?.category == FormCategory.Category.Form_B)) {
printHtmlPart(11)
}
printHtmlPart(12)
if(true && (formDetails?.category?.category == FormCategory.Category.Form_1)) {
printHtmlPart(13)
}
else if(true && (formDetails?.category?.category == FormCategory.Category.Form_2)) {
printHtmlPart(14)
}
else if(true && (formDetails?.category?.category == FormCategory.Category.Form_3)) {
printHtmlPart(15)
}
else if(true && (formDetails?.category?.category == FormCategory.Category.Form_4)) {
printHtmlPart(16)
}
else if(true && (formDetails?.category?.category == FormCategory.Category.Form_B)) {
printHtmlPart(17)
}
else if(true && (formDetails?.category?.category == FormCategory.Category.Form_C)) {
printHtmlPart(18)
}
printHtmlPart(19)
expressionOut.print(formDetails?.submittedOn)
printHtmlPart(20)
expressionOut.print(formDetails?.appNumber)
printHtmlPart(21)
expressionOut.print(formDetails?.titleOfIPR)
printHtmlPart(22)
expressionOut.print(formDetails?.abstractOfIPR)
printHtmlPart(23)
if(true && ("  ${formDetails?.isIPApplicationFiled == 'true'}")) {
printHtmlPart(24)
}
else {
printHtmlPart(25)
}
printHtmlPart(26)
if(true && (formDetails?.iprDetails)) {
printHtmlPart(27)
loop:{
int i = 0
for( iprDetls in (formDetails?.iprDetails) ) {
printHtmlPart(28)
expressionOut.print(i+1 ?:'NA')
printHtmlPart(29)
expressionOut.print(Country.get(iprDetls?.country)?.country)
expressionOut.print(country)
printHtmlPart(30)
expressionOut.print(iprDetls?.patentApplicationNo ?:'NA')
printHtmlPart(29)
invokeTag('formatDate','g',191,['date':(iprDetls?.patentApplicationDate),'format':("dd/MM/yyyy")],-1)
printHtmlPart(30)
expressionOut.print(iprDetls?.status ?:'NA')
printHtmlPart(30)
expressionOut.print(iprDetls?.patentNo)
printHtmlPart(31)
expressionOut.print(iprDetls?.patentDate?.format('dd/MM/yyyy'))
printHtmlPart(30)
expressionOut.print(iprDetls?.reasons ?:'NA')
printHtmlPart(30)
expressionOut.print(iprRemarkInstance?.patentDtsRmk)
printHtmlPart(32)
i++
}
}
printHtmlPart(33)
}
printHtmlPart(34)
if(true && (iprRemarkInstance?.foreignPetentChk == true)) {
printHtmlPart(35)
}
printHtmlPart(36)
if(true && (iprRemarkInstance?.foreignPetentChk == false)) {
printHtmlPart(37)
expressionOut.print(iprRemarkInstance?.foreignPatentRemark)
printHtmlPart(38)
}
printHtmlPart(39)
if(true && (iprRemarkInstance?.foreignPetentChk == true)) {
printHtmlPart(40)
if(true && (iprRemarkInstance?.iprForignPetents)) {
printHtmlPart(41)
loop:{
int k = 0
for( iprForignPetent in (iprRemarkInstance?.iprForignPetents) ) {
printHtmlPart(42)
expressionOut.print(iprForignPetent?.serialNumber)
printHtmlPart(43)
expressionOut.print(iprForignPetent?.countryTerritoryName)
printHtmlPart(43)
expressionOut.print(iprForignPetent?.patentApplicationNum)
printHtmlPart(43)
expressionOut.print(iprForignPetent?.datePatent)
printHtmlPart(43)
expressionOut.print(iprForignPetent?.statusPatent)
printHtmlPart(43)
expressionOut.print(iprForignPetent?.patentNumAndDateIfGranted)
printHtmlPart(43)
expressionOut.print(iprForignPetent?.remarksPetent)
printHtmlPart(44)
k++
}
}
printHtmlPart(45)
}
printHtmlPart(46)
}
printHtmlPart(47)
if(true && (iprRemarkInstance?.mtcWithPatentAppChk == true)) {
printHtmlPart(48)
}
printHtmlPart(36)
if(true && (iprRemarkInstance?.mtcWithPatentAppChk == false)) {
printHtmlPart(49)
expressionOut.print(iprRemarkInstance?.mtcWithPatentAppRmk)
printHtmlPart(50)
}
printHtmlPart(51)
if(true && (iprRemarkInstance?.bioresourceMtcChk == true)) {
printHtmlPart(52)
}
printHtmlPart(36)
if(true && (iprRemarkInstance?.bioresourceMtcChk == false)) {
printHtmlPart(53)
expressionOut.print(iprRemarkInstance?.bioresourceMtcRmk)
printHtmlPart(50)
}
printHtmlPart(54)
if(true && (iprRemarkInstance?.dtsCommercializationChk == true)) {
printHtmlPart(55)
}
printHtmlPart(36)
if(true && (iprRemarkInstance?.dtsCommercializationChk == false)) {
printHtmlPart(56)
expressionOut.print(iprRemarkInstance?.detailsCommercialRmk)
printHtmlPart(50)
}
printHtmlPart(39)
if(true && (iprRemarkInstance?.dtsCommercializationChk == true)) {
printHtmlPart(57)
expressionOut.print(iprRemarkInstance?.country)
printHtmlPart(58)
expressionOut.print(iprRemarkInstance?.financialYr)
printHtmlPart(58)
expressionOut.print(iprRemarkInstance?.amount)
printHtmlPart(58)
expressionOut.print(iprRemarkInstance?.remarksA)
printHtmlPart(59)
}
printHtmlPart(60)
expressionOut.print(iprRemarkInstance?.questionRequired)
printHtmlPart(61)
if(true && (iprRemarkInstance?.questionAnswers)) {
printHtmlPart(62)
loop:{
int i = 0
for( quesAns in (iprRemarkInstance?.questionAnswers) ) {
printHtmlPart(63)
expressionOut.print(quesAns?.question)
printHtmlPart(64)
expressionOut.print(quesAns?.answer)
printHtmlPart(65)
i++
}
}
printHtmlPart(66)
}
printHtmlPart(67)
})
invokeTag('captureBody','sitemesh',375,[:],1)
printHtmlPart(68)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1671616387915L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
