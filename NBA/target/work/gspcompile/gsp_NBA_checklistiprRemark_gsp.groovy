
import org.nba.common.Country

import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_NBA_checklistiprRemark_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/checklist/iprRemark.gsp" }
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
createTagBody(2, {->
printHtmlPart(8)
expressionOut.print(formDetails?.titleOfIPR)
printHtmlPart(9)
expressionOut.print(formDetails?.abstractOfIPR)
printHtmlPart(10)
if(true && ("  ${formDetails?.isIPApplicationFiled == 'true'}")) {
printHtmlPart(11)
}
else {
printHtmlPart(12)
}
printHtmlPart(13)
if(true && (formDetails?.iprDetails)) {
printHtmlPart(14)
loop:{
int i = 0
for( iprDetls in (formDetails?.iprDetails) ) {
printHtmlPart(15)
expressionOut.print(i+1 ?:'NA')
printHtmlPart(16)
expressionOut.print(Country.get(iprDetls?.country)?.country)
expressionOut.print(country)
printHtmlPart(17)
expressionOut.print(iprDetls?.patentApplicationNo ?:'NA')
printHtmlPart(17)
invokeTag('formatDate','g',91,['date':(iprDetls?.patentApplicationDate),'format':("dd/MM/yyyy")],-1)
printHtmlPart(17)
expressionOut.print(iprDetls?.status ?:'NA')
printHtmlPart(17)
expressionOut.print(iprDetls?.patentNo ?:'NA')
printHtmlPart(18)
expressionOut.print(iprDetls?.patentDate?.format('dd/MM/yyyy'))
printHtmlPart(17)
expressionOut.print(iprDetls?.reasons ?:'NA')
printHtmlPart(17)
invokeTag('textField','g',97,['name':("patentDtsRmk"),'value':(iprRemarkInstance?.patentDtsRmk)],-1)
printHtmlPart(19)
i++
}
}
printHtmlPart(14)
}
printHtmlPart(20)
invokeTag('radio','g',110,['name':("foreignPetentChk"),'value':("true"),'id':("yesForeign"),'onclick':("openTable()")],-1)
printHtmlPart(21)
invokeTag('radio','g',114,['name':("foreignPetentChk"),'value':("false"),'id':("noForeign"),'onclick':("openRemark()")],-1)
printHtmlPart(22)
invokeTag('textField','g',118,['name':("foreignPatentRemark"),'id':("forePetRmk"),'value':(iprRemarkInstance?.foreignPatentRemark),'style':("display: none;"),'class':("remark")],-1)
printHtmlPart(23)
invokeTag('radio','g',152,['name':("mtcWithPatentAppChk"),'onclick':("hidePatentMtc()"),'value':("true"),'id':("mtcyes")],-1)
printHtmlPart(24)
invokeTag('radio','g',156,['name':("mtcWithPatentAppChk"),'id':("mtcno"),'onclick':("showPatentMtc()"),'value':("false")],-1)
printHtmlPart(25)
invokeTag('textField','g',161,['name':("mtcWithPatentAppRmk"),'id':("mtcRmk"),'class':("remark"),'value':(iprRemarkInstance?.mtcWithPatentAppRmk),'style':("display:none;")],-1)
printHtmlPart(26)
invokeTag('radio','g',165,['name':("bioresourceMtcChk"),'id':("bioresMtcYes"),'onclick':("bioMtcHide();"),'value':("true")],-1)
printHtmlPart(27)
invokeTag('radio','g',166,['name':("bioresourceMtcChk"),'value':("false"),'id':("bioresMtcNo"),'onclick':("bioMtcShow();")],-1)
printHtmlPart(28)
invokeTag('textField','g',171,['class':("remark"),'name':("bioresourceMtcRmk"),'id':("bioMtcRemk"),'value':(iprRemarkInstance?.bioresourceMtcRmk),'style':("display:none;")],-1)
printHtmlPart(29)
invokeTag('radio','g',175,['name':("dtsCommercializationChk"),'onclick':("dtsCommTable()"),'value':("true")],-1)
printHtmlPart(30)
invokeTag('radio','g',180,['name':("dtsCommercializationChk"),'onclick':("dtsCommShow()"),'value':("false")],-1)
printHtmlPart(31)
invokeTag('textField','g',184,['name':("detailsCommercialRmk"),'class':("remark"),'id':("dtsComzation"),'value':(iprRemarkInstance?.detailsCommercialRmk),'style':("display:none")],-1)
printHtmlPart(32)
invokeTag('textField','g',195,['name':("country"),'value':(iprRemarkInstance?.country)],-1)
printHtmlPart(33)
invokeTag('textField','g',198,['name':("financialYr"),'value':(iprRemarkInstance?.financialYr)],-1)
printHtmlPart(33)
invokeTag('textField','g',200,['name':("amount"),'value':(iprRemarkInstance?.amount)],-1)
printHtmlPart(33)
invokeTag('textField','g',202,['name':("remarksA"),'value':(iprRemarkInstance?.remarksA)],-1)
printHtmlPart(34)
invokeTag('textArea','g',217,['name':("quesValues"),'class':("ques"),'style':("width:100%")],-1)
printHtmlPart(35)
invokeTag('textArea','g',219,['name':("ansValues"),'class':("ans"),'style':("width:100%")],-1)
printHtmlPart(36)
invokeTag('hiddenField','g',229,['name':("csrfPreventionSalt"),'value':(csrfPreventionSalt)],-1)
printHtmlPart(37)
invokeTag('hiddenField','g',230,['name':("formId"),'value':(formDetails?.id)],-1)
printHtmlPart(37)
invokeTag('hiddenField','g',230,['name':("iprInstance"),'value':(iprRemarkInstance?.id)],-1)
printHtmlPart(37)
invokeTag('hiddenField','g',236,['name':("counterVal"),'id':("setCounter"),'value':("")],-1)
printHtmlPart(37)
})
invokeTag('form','g',237,['action':("saveIprReviewDetails"),'controller':("checklist")],2)
printHtmlPart(38)
invokeTag('render','g',240,['template':("/rightPane/matchdata")],-1)
printHtmlPart(39)
})
invokeTag('captureBody','sitemesh',248,[:],1)
printHtmlPart(40)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1646932743534L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
