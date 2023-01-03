import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_NBA_manageContentfaqs_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/manageContent/faqs.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',4,['gsp_sm_xmlClosingForEmptyTag':("/"),'name':("layout"),'content':("loggedInUser")],-1)
printHtmlPart(2)
createTagBody(2, {->
printHtmlPart(3)
expressionOut.print(faqS)
printHtmlPart(4)
})
invokeTag('javascript','g',12,[:],2)
printHtmlPart(5)
})
invokeTag('captureHead','sitemesh',15,[:],1)
printHtmlPart(6)
createTagBody(1, {->
printHtmlPart(7)
invokeTag('render','g',103,['template':("AdminLeftTab")],-1)
printHtmlPart(8)
createTagBody(2, {->
printHtmlPart(9)
expressionOut.print(csrfPreventionSalt)
printHtmlPart(10)
createClosureForHtmlPart(11, 3)
invokeTag('textArea','g',116,['id':("edit"),'autocomplete':("off"),'name':("faqs"),'value':(faqS?.faq),'style':("margin-top: 30px;")],3)
printHtmlPart(12)
expressionOut.print(faqS?.id)
printHtmlPart(13)
createClosureForHtmlPart(14, 3)
invokeTag('link','g',124,['controller':("loggedInAs"),'action':("inbox")],3)
printHtmlPart(15)
})
invokeTag('form','g',124,['controller':("manageContent"),'action':("saveFaqs")],2)
printHtmlPart(16)
})
invokeTag('captureBody','sitemesh',124,[:],1)
printHtmlPart(17)
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
