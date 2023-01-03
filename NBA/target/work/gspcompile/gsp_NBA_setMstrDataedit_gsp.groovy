import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_NBA_setMstrDataedit_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/setMstrData/edit.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createClosureForHtmlPart(1, 1)
invokeTag('captureHead','sitemesh',6,[:],1)
printHtmlPart(2)
createTagBody(1, {->
printHtmlPart(3)
createTagBody(2, {->
printHtmlPart(4)
invokeTag('textArea','g',13,['name':("txtValue"),'value':(value),'style':("width:300px;")],-1)
printHtmlPart(5)
invokeTag('hiddenField','g',18,['name':("type"),'value':(type)],-1)
printHtmlPart(2)
invokeTag('hiddenField','g',19,['name':("index"),'value':(index)],-1)
printHtmlPart(2)
invokeTag('hiddenField','g',20,['name':("csrfPreventionSalt"),'value':(csrfPreventionSalt)],-1)
printHtmlPart(2)
invokeTag('submitButton','g',21,['name':("Update"),'class':("btn btn-primary"),'style':("margin-left:260px;margin-top:15px;")],-1)
printHtmlPart(2)
})
invokeTag('form','g',22,['action':("update")],2)
printHtmlPart(2)
})
invokeTag('captureBody','sitemesh',23,[:],1)
printHtmlPart(6)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1586271536000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
