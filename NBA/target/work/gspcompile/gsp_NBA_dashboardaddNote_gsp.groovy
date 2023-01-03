
import org.nba.review.AddNote


import java.text.SimpleDateFormat


import java.util.Date

import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_NBA_dashboardaddNote_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/dashboard/addNote.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(0)
printHtmlPart(1)
createTagBody(1, {->
printHtmlPart(0)
invokeTag('captureMeta','sitemesh',6,['gsp_sm_xmlClosingForEmptyTag':("/"),'name':("layout"),'content':("dashPage")],-1)
printHtmlPart(2)
createTagBody(2, {->
createClosureForHtmlPart(3, 3)
invokeTag('captureTitle','sitemesh',7,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',8,[:],2)
printHtmlPart(4)
})
invokeTag('captureHead','sitemesh',8,[:],1)
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(5)
if(true && (submittedDate != '' && submittedDate != null)) {
printHtmlPart(6)
invokeTag('set','g',16,['var':("sdf"),'value':(new SimpleDateFormat('yyyy-MM-dd'))],-1)
printHtmlPart(6)
invokeTag('set','g',20,['var':("sdf1"),'value':(new SimpleDateFormat('dd/MM/yyyy'))],-1)
printHtmlPart(6)
invokeTag('set','g',21,['var':("date"),'value':(sdf.parse(submittedDate))],-1)
printHtmlPart(6)
invokeTag('set','g',22,['var':("reqFormat"),'value':(sdf1.format(date))],-1)
printHtmlPart(7)
}
printHtmlPart(8)
invokeTag('textArea','g',37,['name':("comments"),'id':("editor1"),'required':("required")],-1)
printHtmlPart(9)
invokeTag('render','g',50,['template':("commentBox")],-1)
printHtmlPart(10)
createTagBody(2, {->
printHtmlPart(11)
invokeTag('hiddenField','g',63,['name':("applicationInstance"),'value':(formDetails?.id)],-1)
printHtmlPart(11)
invokeTag('hiddenField','g',63,['name':("csrfPreventionSalt"),'value':(csrfPreventionSalt)],-1)
printHtmlPart(12)
invokeTag('hiddenField','g',67,['name':("linkOfficer"),'value':(linkOfficer)],-1)
printHtmlPart(13)
invokeTag('render','g',68,['template':("/dashboard/addnotes")],-1)
printHtmlPart(14)
})
invokeTag('form','g',69,['controller':("dashboard"),'action':("saveNote"),'enctype':("multipart/form-data"),'method':("post"),'onsubmit':("return getData()")],2)
printHtmlPart(15)
invokeTag('render','g',71,['template':("/rightPane/matchdata")],-1)
printHtmlPart(16)
})
invokeTag('captureBody','sitemesh',72,[:],1)
printHtmlPart(17)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1645626838814L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
