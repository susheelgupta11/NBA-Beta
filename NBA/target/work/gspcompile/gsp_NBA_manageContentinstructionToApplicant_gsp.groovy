import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_NBA_manageContentinstructionToApplicant_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/manageContent/instructionToApplicant.gsp" }
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
expressionOut.print(instructions)
printHtmlPart(4)
})
invokeTag('javascript','g',16,[:],2)
printHtmlPart(5)
})
invokeTag('captureHead','sitemesh',19,[:],1)
printHtmlPart(6)
createTagBody(1, {->
printHtmlPart(7)
invokeTag('render','g',107,['template':("AdminLeftTab")],-1)
printHtmlPart(8)
createTagBody(2, {->
printHtmlPart(9)
createClosureForHtmlPart(10, 3)
invokeTag('textArea','g',120,['id':("edit"),'autocomplete':("off"),'name':("instructionToApplicant"),'value':(instructions?.instructions),'style':("margin-top: 30px;")],3)
printHtmlPart(11)
expressionOut.print(instructions?.id)
printHtmlPart(12)
expressionOut.print(csrfPreventionSalt)
printHtmlPart(13)
createClosureForHtmlPart(14, 3)
invokeTag('link','g',129,['controller':("loggedInAs"),'action':("inbox")],3)
printHtmlPart(15)
})
invokeTag('form','g',129,['controller':("manageContent"),'action':("saveInstructionToApplicant")],2)
printHtmlPart(16)
})
invokeTag('captureBody','sitemesh',129,[:],1)
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
