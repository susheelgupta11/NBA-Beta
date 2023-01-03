
import org.nba.common.Country

import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_NBA_form3_iprDetailsForm_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/form3/_iprDetailsForm.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
expressionOut.print(csrfPreventionSalt)
printHtmlPart(2)
if(true && (!appForm)) {
printHtmlPart(3)
}
else {
printHtmlPart(4)
if(true && (appForm?.isIPApplicationFiled == 'true')) {
printHtmlPart(5)
}
else {
printHtmlPart(6)
}
printHtmlPart(7)
if(true && (appForm?.isIPApplicationFiled == 'false')) {
printHtmlPart(8)
}
else {
printHtmlPart(9)
}
printHtmlPart(10)
}
printHtmlPart(11)
invokeTag('select','g',70,['name':("country"),'from':(listOfcountries),'optionKey':("id"),'optionValue':("country"),'value':(ipr?.country),'class':("width  country req ctrl1"),'noSelection':(['':'-Select-'])],-1)
printHtmlPart(12)
expressionOut.print(ipr?.patentApplicationNo)
printHtmlPart(13)
expressionOut.print(ipr?.patentApplicationDate?.format('dd/MM/yyyy'))
printHtmlPart(14)
if(true && (ipr?.status?.contains('-'))) {
printHtmlPart(15)
invokeTag('select','g',101,['name':("status"),'from':(listOfStatuses),'onChange':("showStatusForForm3Part2(this,null)"),'value':(ipr?.status?.split('-')[0]),'class':("width  country req ctrl1"),'noSelection':(['':'-Select-']),'id':("statusChange")],-1)
printHtmlPart(16)
}
else {
printHtmlPart(15)
invokeTag('select','g',106,['name':("status"),'from':(listOfStatuses),'onChange':("showStatusForForm3Part2(this,null)"),'value':(ipr?.status),'class':("width country req ctrl1"),'noSelection':(['':'-Select-']),'id':("statusChange")],-1)
printHtmlPart(16)
}
printHtmlPart(17)
expressionOut.print(ipr?.patentNo)
printHtmlPart(18)
expressionOut.print(ipr?.patentDate?.format('dd/MM/yyyy'))
printHtmlPart(19)
if(true && (ipr?.status?.contains('-'))) {
printHtmlPart(20)
createClosureForHtmlPart(15, 3)
invokeTag('textArea','g',136,['name':("otherStatus"),'class':("width"),'value':(ipr?.status?.split('-')[1]),'rows':("3")],3)
printHtmlPart(21)
}
else {
printHtmlPart(20)
invokeTag('textArea','g',144,['name':("otherStatus"),'class':("width"),'value':(""),'rows':("3")],-1)
printHtmlPart(21)
}
printHtmlPart(22)
invokeTag('textArea','g',155,['name':("reasons"),'class':("width"),'value':(ipr?.reasons)],-1)
printHtmlPart(23)
invokeTag('hiddenField','g',159,['name':("appFormId"),'value':(appForm?.id)],-1)
printHtmlPart(24)
invokeTag('hiddenField','g',161,['name':("formType"),'value':(formType)],-1)
printHtmlPart(24)
invokeTag('hiddenField','g',162,['name':("iprId"),'value':(ipr?.id)],-1)
printHtmlPart(25)
})
invokeTag('formRemote','g',174,['name':("iprDetails"),'id':("iprDetails"),'class':("form-horizontal"),'autocomplete':("off"),'role':("form"),'url':([controller:'form3',action:'saveIprDetails']),'update':("updateIprDetails"),'onSuccess':("loadPage()")],1)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1537268164000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
