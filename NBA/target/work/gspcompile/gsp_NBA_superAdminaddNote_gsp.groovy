
import org.nba.review.AddNote


import java.text.SimpleDateFormat


import java.util.Date

import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_NBA_superAdminaddNote_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/superAdmin/addNote.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(0)
printHtmlPart(1)
createTagBody(1, {->
printHtmlPart(0)
invokeTag('captureMeta','sitemesh',6,['gsp_sm_xmlClosingForEmptyTag':("/"),'name':("layout"),'content':("nbaDashboardLayout")],-1)
printHtmlPart(0)
invokeTag('captureMeta','sitemesh',7,['gsp_sm_xmlClosingForEmptyTag':(""),'charset':("utf-8")],-1)
printHtmlPart(2)
invokeTag('captureMeta','sitemesh',8,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("robots"),'content':("noindex, nofollow")],-1)
printHtmlPart(0)
createTagBody(2, {->
createClosureForHtmlPart(3, 3)
invokeTag('captureTitle','sitemesh',9,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',9,[:],2)
printHtmlPart(0)
})
invokeTag('captureHead','sitemesh',10,[:],1)
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(4)
if(true && (submittedDate != '' && submittedDate != null)) {
printHtmlPart(5)
invokeTag('set','g',20,['var':("sdf"),'value':(new SimpleDateFormat('yyyy-MM-dd'))],-1)
printHtmlPart(5)
invokeTag('set','g',20,['var':("sdf1"),'value':(new SimpleDateFormat('dd/MM/yyyy'))],-1)
printHtmlPart(5)
invokeTag('set','g',21,['var':("date"),'value':(sdf.parse(submittedDate))],-1)
printHtmlPart(5)
invokeTag('set','g',23,['var':("reqFormat"),'value':(sdf1.format(date))],-1)
printHtmlPart(6)
}
printHtmlPart(7)
expressionOut.print(applicationNum)
printHtmlPart(8)
expressionOut.print(reqFormat)
printHtmlPart(9)
createClosureForHtmlPart(10, 2)
invokeTag('textArea','g',51,['name':("comments"),'id':("editor1")],2)
printHtmlPart(11)
invokeTag('render','g',64,['template':("/dashboard/commentBox")],-1)
printHtmlPart(12)
createTagBody(2, {->
printHtmlPart(13)
invokeTag('hiddenField','g',74,['name':("applicationInstance"),'value':(formDetails?.id)],-1)
printHtmlPart(13)
invokeTag('hiddenField','g',76,['name':("csrfPreventionSalt"),'value':(csrfPreventionSalt)],-1)
printHtmlPart(14)
invokeTag('render','g',79,['template':("/dashboard/addnotes")],-1)
printHtmlPart(15)
})
invokeTag('form','g',80,['action':("saveNote"),'enctype':("multipart/form-data"),'method':("post")],2)
printHtmlPart(16)
invokeTag('render','g',83,['template':("/rightPane/matchdata")],-1)
printHtmlPart(17)
})
invokeTag('captureBody','sitemesh',178,[:],1)
printHtmlPart(18)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1605257718000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
