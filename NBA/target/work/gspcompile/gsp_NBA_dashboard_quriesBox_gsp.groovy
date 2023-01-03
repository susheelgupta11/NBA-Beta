import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_NBA_dashboard_quriesBox_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/dashboard/_quriesBox.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
loop:{
int i = 0
for( quriesTb in (dropDnValues?.quriesTabList) ) {
printHtmlPart(1)
invokeTag('checkBox','g',13,['name':("quriesTb${i+1}"),'value':(quriesTb),'id':("qurie${i+1}"),'class':("territories ctrl1"),'onclick':("getAllValue(this)"),'checked':("false")],-1)
printHtmlPart(2)
expressionOut.print(quriesTb)
printHtmlPart(3)
i++
}
}
printHtmlPart(4)
loop:{
int j = 0
for( noteTb in (dropDnValues?.noteTabList) ) {
printHtmlPart(1)
invokeTag('checkBox','g',29,['name':("noteTab${j+1}"),'value':(noteTb),'id':("note${j+1}"),'class':("territories ctrl1"),'onclick':("getAllValue(this)"),'checked':("false")],-1)
printHtmlPart(2)
expressionOut.print(noteTb)
printHtmlPart(3)
j++
}
}
printHtmlPart(5)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1588593156000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
