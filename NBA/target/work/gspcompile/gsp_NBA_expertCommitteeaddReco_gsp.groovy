import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_NBA_expertCommitteeaddReco_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/expertCommittee/addReco.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',4,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("expertMember")],-1)
printHtmlPart(2)
createTagBody(2, {->
createClosureForHtmlPart(3, 3)
invokeTag('captureTitle','sitemesh',6,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',6,[:],2)
printHtmlPart(4)
})
invokeTag('captureHead','sitemesh',7,[:],1)
printHtmlPart(5)
createTagBody(1, {->
printHtmlPart(6)
if(true && (message)) {
printHtmlPart(7)
expressionOut.print(message)
printHtmlPart(8)
}
printHtmlPart(9)
createTagBody(2, {->
printHtmlPart(10)
invokeTag('select','g',42,['class':("form-control"),'id':("meetingName"),'name':("meetingNameReco"),'from':(meetingDpDn),'noSelection':(['':'Choose a Meeting']),'required':("required")],-1)
printHtmlPart(11)
invokeTag('select','g',50,['class':("form-control"),'id':("meetingNumber"),'name':("meetingNumberReco"),'from':(recoDetails),'noSelection':(['':'Select Meeting Number']),'required':("required")],-1)
printHtmlPart(12)
createTagBody(3, {->
printHtmlPart(13)
expressionOut.print(it.radio)
printHtmlPart(14)
expressionOut.print(it.label)
printHtmlPart(15)
})
invokeTag('radioGroup','g',60,['name':("purposeReco"),'value':(abc ?.purpose),'labels':(['Placed','Ratified']),'values':(['Placed','Ratified'])],3)
printHtmlPart(16)
createTagBody(3, {->
printHtmlPart(13)
expressionOut.print(it.radio)
printHtmlPart(14)
expressionOut.print(it.label)
printHtmlPart(15)
})
invokeTag('radioGroup','g',96,['name':("checkReco"),'value':(abc?.checkReco),'labels':(['Recommendation','Not']),'values':(['Recommendation','Not'])],3)
printHtmlPart(17)
invokeTag('hiddenField','g',99,['name':("csrfPreventionSalt"),'value':(csrfPreventionSalt)],-1)
printHtmlPart(18)
invokeTag('textField','g',104,['name':("selectedApp"),'id':("selectedApp"),'value':(""),'style':("display:none")],-1)
printHtmlPart(19)
invokeTag('submitButton','g',105,['name':("Submit"),'class':("btn btn-primary")],-1)
printHtmlPart(20)
})
invokeTag('form','g',108,['action':("saveRecommDetails"),'style':("padding-right: 4em; margin:2em;"),'enctype':("multipart/form-data"),'method':("POST")],2)
printHtmlPart(21)
expressionOut.print(request.contextPath)
printHtmlPart(22)
})
invokeTag('captureBody','sitemesh',168,[:],1)
printHtmlPart(23)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1617546487527L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
