
import org.nba.application.FormCategory

import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_NBA_applicant_rightPane_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/applicant/_rightPane.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(1)
if(true && (formDetails?.category?.category == FormCategory.Category.Form_1)) {
printHtmlPart(2)
invokeTag('set','g',13,['value':("previewForm1Info"),'var':("dyaction")],-1)
printHtmlPart(3)
}
else if(true && (formDetails?.category?.category == FormCategory.Category.Form_2)) {
printHtmlPart(4)
invokeTag('set','g',17,['value':("previewForm2Info"),'var':("dyaction")],-1)
printHtmlPart(3)
}
else if(true && (formDetails?.category?.category == FormCategory.Category.Form_3)) {
printHtmlPart(4)
invokeTag('set','g',21,['value':("previewForm3Info"),'var':("dyaction")],-1)
printHtmlPart(3)
}
else if(true && (formDetails?.category?.category == FormCategory.Category.Form_4)) {
printHtmlPart(4)
invokeTag('set','g',25,['value':("previewForm4Info"),'var':("dyaction")],-1)
printHtmlPart(5)
}
else if(true && (formDetails?.category?.category == FormCategory.Category.Form_B)) {
printHtmlPart(4)
invokeTag('set','g',28,['value':("previewFormBInfo"),'var':("dyaction")],-1)
printHtmlPart(5)
}
else if(true && (formDetails?.category?.category == FormCategory.Category.Form_C)) {
printHtmlPart(4)
invokeTag('set','g',31,['value':("previewFormCInfo"),'var':("dyaction")],-1)
printHtmlPart(6)
}
printHtmlPart(7)
createClosureForHtmlPart(8, 1)
invokeTag('remoteLink','g',39,['action':(dyaction),'controller':("FormPreview"),'title':("View Application"),'id':(formDetails?.id),'params':([fromLogin:"true",appFormId:formDetails?.id,csrfPreventionSalt:"${csrfPreventionSalt}"]),'data-target':("#success"),'data-toggle':("modal"),'update':("nin")],1)
printHtmlPart(9)

int counter = 0

printHtmlPart(10)
if(true && (formDetails?.manualUploads)) {
printHtmlPart(11)
for( dynamic in (formDetails?.manualUploads) ) {
printHtmlPart(12)
if(true && (dynamic?.fileName || dynamic?.fileUrl)) {
printHtmlPart(13)
expressionOut.print(counter = counter+1)
printHtmlPart(14)
expressionOut.print(dynamic?.date)
printHtmlPart(15)
expressionOut.print(dynamic?.fileName)
printHtmlPart(16)
createClosureForHtmlPart(17, 4)
invokeTag('link','g',84,['controller':("manualUpload"),'action':("manualDocShow"),'target':("_blank"),'params':([dynamicId:dynamic?.id,csrfPreventionSalt:csrfPreventionSalt])],4)
printHtmlPart(18)
}
else if(true && (dynamic?.dyName || dynamic?.dyUrl)) {
printHtmlPart(13)
expressionOut.print(counter = counter+1)
printHtmlPart(14)
expressionOut.print(dynamic?.letterDate)
printHtmlPart(15)
expressionOut.print(dynamic?.dyName)
printHtmlPart(16)
createClosureForHtmlPart(17, 4)
invokeTag('link','g',102,['controller':("manualUpload"),'action':("manualDocShow"),'target':("_blank"),'params':([dynamicId:dynamic?.id,csrfPreventionSalt:csrfPreventionSalt])],4)
printHtmlPart(18)
}
printHtmlPart(19)
}
printHtmlPart(19)
}
else {
printHtmlPart(20)
}
printHtmlPart(21)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1668145733052L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
