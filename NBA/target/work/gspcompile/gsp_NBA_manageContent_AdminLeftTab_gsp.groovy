import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_NBA_manageContent_AdminLeftTab_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/manageContent/_AdminLeftTab.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)

session.setAttribute("csrfPreventionSalt",csrfPreventionSalt)

printHtmlPart(1)
createTagBody(1, {->
printHtmlPart(2)
invokeTag('hiddenField','g',9,['value':(csrfPreventionSalt),'name':("csrfPreventionSalt")],-1)
printHtmlPart(3)
})
invokeTag('form','g',13,['controller':("manageContent"),'action':("adminEdits")],1)
printHtmlPart(4)
createTagBody(1, {->
printHtmlPart(2)
invokeTag('hiddenField','g',14,['value':(csrfPreventionSalt),'name':("csrfPreventionSalt")],-1)
printHtmlPart(5)
})
invokeTag('form','g',17,['controller':("manageContent"),'action':("latestUpdates")],1)
printHtmlPart(4)
createTagBody(1, {->
printHtmlPart(2)
invokeTag('hiddenField','g',19,['value':(csrfPreventionSalt),'name':("csrfPreventionSalt")],-1)
printHtmlPart(6)
})
invokeTag('form','g',21,['controller':("manageContent"),'action':("instructionToApplicant")],1)
printHtmlPart(7)
createTagBody(1, {->
printHtmlPart(2)
invokeTag('hiddenField','g',24,['value':(csrfPreventionSalt),'name':("csrfPreventionSalt")],-1)
printHtmlPart(8)
})
invokeTag('form','g',24,['controller':("manageContent"),'action':("faqs")],1)
printHtmlPart(9)
createTagBody(1, {->
printHtmlPart(2)
invokeTag('hiddenField','g',27,['value':(csrfPreventionSalt),'name':("csrfPreventionSalt")],-1)
printHtmlPart(10)
})
invokeTag('form','g',28,['controller':("masterData"),'action':("uploadDocs")],1)
printHtmlPart(11)
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
