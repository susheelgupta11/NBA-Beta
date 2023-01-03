
import org.nba.application.AppStatus


import org.nba.application.FormCategory


import java.text.SimpleDateFormat

import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_NBA_loggedInAsinbox_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/loggedInAs/inbox.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(0)
printHtmlPart(1)
createTagBody(1, {->
printHtmlPart(0)
invokeTag('captureMeta','sitemesh',8,['gsp_sm_xmlClosingForEmptyTag':("/"),'name':("layout"),'content':("superAdmin")],-1)
printHtmlPart(0)
createTagBody(2, {->
createClosureForHtmlPart(2, 3)
invokeTag('captureTitle','sitemesh',9,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',9,[:],2)
printHtmlPart(0)
})
invokeTag('captureHead','sitemesh',10,[:],1)
printHtmlPart(3)
createTagBody(1, {->
printHtmlPart(4)
if(true && (flash?.message)) {
printHtmlPart(5)
expressionOut.print(flash?.message)
printHtmlPart(6)
}
printHtmlPart(0)
createTagBody(2, {->
printHtmlPart(0)
invokeTag('set','g',22,['var':("getAdminRole"),'value':("ADMIN")],-1)
printHtmlPart(0)
})
invokeTag('ifAnyGranted','sec',23,['roles':("ADMIN")],2)
printHtmlPart(7)
if(true && (adminUser)) {
printHtmlPart(8)
}
printHtmlPart(9)
if(true && (applications)) {
printHtmlPart(10)

def i=params?.offset==0?1:params?.offset?.toInteger()+1

printHtmlPart(11)
for( app in (applications) ) {
printHtmlPart(12)
out.print(i)
printHtmlPart(13)

i++

printHtmlPart(14)
expressionOut.print(app.applicant_name)
printHtmlPart(15)
if(true && (app?.category == 'Form_1')) {
printHtmlPart(16)
invokeTag('set','g',58,['value':("previewForm1Info"),'var':("dyaction")],-1)
printHtmlPart(17)
}
else if(true && (app?.category == 'Form_2')) {
printHtmlPart(16)
invokeTag('set','g',61,['value':("previewForm2Info"),'var':("dyaction")],-1)
printHtmlPart(18)
}
else if(true && (app?.category == 'Form_3')) {
printHtmlPart(16)
invokeTag('set','g',65,['value':("previewForm3Info"),'var':("dyaction")],-1)
printHtmlPart(19)
}
else if(true && (app?.category == 'Form_4')) {
printHtmlPart(16)
invokeTag('set','g',69,['value':("previewForm4Info"),'var':("dyaction")],-1)
printHtmlPart(20)
}
else if(true && (app?.category == 'Form_B')) {
printHtmlPart(16)
invokeTag('set','g',72,['value':("previewFormBInfo"),'var':("dyaction")],-1)
printHtmlPart(21)
}
else if(true && (app?.category == 'Form_C')) {
printHtmlPart(16)
invokeTag('set','g',75,['value':("previewFormCInfo"),'var':("dyaction")],-1)
printHtmlPart(22)
}
printHtmlPart(23)
expressionOut.print(app?.app_number)
printHtmlPart(24)
expressionOut.print(app?.status)
printHtmlPart(25)
if(true && (adminUser)) {
printHtmlPart(26)
expressionOut.print(app?.to_char)
printHtmlPart(25)
}
printHtmlPart(27)
createClosureForHtmlPart(28, 4)
invokeTag('remoteLink','g',97,['action':(dyaction),'controller':("FormPreview"),'title':("View Application"),'id':(app?.id),'params':([fromLogin:"true",appFormId:app?.id,csrfPreventionSalt:"${csrfPreventionSalt}"]),'data-target':("#success"),'data-toggle':("modal"),'update':("nin")],4)
printHtmlPart(29)
}
printHtmlPart(30)
}
else {
printHtmlPart(31)
if(true && (!adminUser)) {
printHtmlPart(32)
}
else if(true && (adminUser)) {
printHtmlPart(33)
}
printHtmlPart(34)
}
printHtmlPart(35)
})
invokeTag('captureBody','sitemesh',128,[:],1)
printHtmlPart(36)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1668753623068L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
