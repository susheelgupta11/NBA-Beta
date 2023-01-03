
import org.nba.application.FormCategory

import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_NBA_loggedInAsbenefitSharingReceived_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/loggedInAs/benefitSharingReceived.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(1)
createTagBody(1, {->
printHtmlPart(2)
invokeTag('captureMeta','sitemesh',6,['gsp_sm_xmlClosingForEmptyTag':("/"),'http-equiv':("Content-Type"),'content':("text/html; charset=ISO-8859-1")],-1)
printHtmlPart(2)
invokeTag('captureMeta','sitemesh',7,['gsp_sm_xmlClosingForEmptyTag':("/"),'name':("layout"),'content':("superAdmin")],-1)
printHtmlPart(2)
createTagBody(2, {->
createClosureForHtmlPart(3, 3)
invokeTag('captureTitle','sitemesh',8,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',8,[:],2)
printHtmlPart(4)
})
invokeTag('captureHead','sitemesh',14,[:],1)
printHtmlPart(2)
createTagBody(1, {->
printHtmlPart(5)
createTagBody(2, {->
printHtmlPart(6)
invokeTag('submitButton','g',51,['value':("Filter"),'name':("Filter")],-1)
printHtmlPart(7)
})
invokeTag('form','g',51,['action':("benefitFilter"),'controller':("loggedInAs"),'method':("POST")],2)
printHtmlPart(8)
if(true && (benefitSharingInstance)) {
printHtmlPart(9)
loop:{
int i = 0
for( benefit in (benefitSharingInstance) ) {
printHtmlPart(10)
expressionOut.print(i+1)
printHtmlPart(11)
expressionOut.print(benefit?.bsName)
printHtmlPart(12)
expressionOut.print(benefit?.appNumber)
printHtmlPart(13)
if(true && (benefit?.applicationForm1?.category?.category == FormCategory.Category.Form_1)) {
printHtmlPart(14)
}
else if(true && (benefit?.applicationForm1?.category?.category == FormCategory.Category.Form_2)) {
printHtmlPart(15)
}
else if(true && (benefit?.applicationForm1?.category?.category == FormCategory.Category.Form_3)) {
printHtmlPart(16)
}
else if(true && (benefit?.applicationForm1?.category?.category == FormCategory.Category.Form_4)) {
printHtmlPart(17)
}
else if(true && (benefit?.applicationForm1?.category?.category == FormCategory.Category.Form_B)) {
printHtmlPart(18)
}
else if(true && (benefit?.applicationForm1?.category?.category == FormCategory.Category.Form_C)) {
printHtmlPart(19)
}
printHtmlPart(20)
expressionOut.print(benefit?.amountIn)
printHtmlPart(21)
expressionOut.print(benefit?.tr5ReceiptNumber)
printHtmlPart(22)
invokeTag('formatDate','g',96,['format':("dd/MM/yyyy"),'date':(benefit?.dateBenefit)],-1)
printHtmlPart(12)
expressionOut.print(benefit?.category)
printHtmlPart(23)
expressionOut.print(benefit?.modeOfPayment)
printHtmlPart(23)
expressionOut.print(benefit?.typeOfSharing)
printHtmlPart(24)
i++
}
}
printHtmlPart(25)
}
printHtmlPart(26)
})
invokeTag('captureBody','sitemesh',99,[:],1)
printHtmlPart(27)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1668753731852L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
