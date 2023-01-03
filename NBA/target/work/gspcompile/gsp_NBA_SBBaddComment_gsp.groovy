
import org.nba.review.AddNote


import java.text.SimpleDateFormat


import java.util.Date

import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_NBA_SBBaddComment_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/SBB/addComment.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(0)
printHtmlPart(1)
createTagBody(1, {->
printHtmlPart(0)
invokeTag('captureMeta','sitemesh',6,['gsp_sm_xmlClosingForEmptyTag':("/"),'name':("layout"),'content':("sbb")],-1)
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
printHtmlPart(4)
})
invokeTag('captureHead','sitemesh',11,[:],1)
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(5)
if(true && (submittedDate != '' && submittedDate != null)) {
printHtmlPart(6)
invokeTag('set','g',22,['var':("sdf"),'value':(new SimpleDateFormat('yyyy-MM-dd'))],-1)
printHtmlPart(6)
invokeTag('set','g',22,['var':("sdf1"),'value':(new SimpleDateFormat('dd/MM/yyyy'))],-1)
printHtmlPart(6)
invokeTag('set','g',23,['var':("date"),'value':(sdf.parse(submittedDate))],-1)
printHtmlPart(6)
invokeTag('set','g',25,['var':("reqFormat"),'value':(sdf1.format(date))],-1)
printHtmlPart(7)
}
printHtmlPart(8)
expressionOut.print(applicationNum)
printHtmlPart(9)
expressionOut.print(reqFormat)
printHtmlPart(10)
if(true && (message)) {
printHtmlPart(11)
expressionOut.print(message)
printHtmlPart(12)
}
printHtmlPart(13)
invokeTag('textArea','g',71,['name':("comments"),'id':("editor1"),'required':("required")],-1)
printHtmlPart(14)
invokeTag('render','g',82,['template':("/dashboard/commentBox")],-1)
printHtmlPart(15)
createTagBody(2, {->
printHtmlPart(16)
invokeTag('hiddenField','g',95,['name':("applicationInstance"),'value':(formDetails?.id)],-1)
printHtmlPart(16)
invokeTag('hiddenField','g',98,['name':("csrfPreventionSalt"),'value':(csrfPreventionSalt)],-1)
printHtmlPart(17)
invokeTag('render','g',100,['template':("/dashboard/addnotes")],-1)
printHtmlPart(18)
})
invokeTag('form','g',100,['controller':("SBB"),'action':("saveComment"),'enctype':("multipart/form-data"),'method':("post"),'onsubmit':("return getData()")],2)
printHtmlPart(19)
invokeTag('render','g',105,['template':("/SBB/rightPannel")],-1)
printHtmlPart(20)
})
invokeTag('captureBody','sitemesh',151,[:],1)
printHtmlPart(21)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1605257424000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
