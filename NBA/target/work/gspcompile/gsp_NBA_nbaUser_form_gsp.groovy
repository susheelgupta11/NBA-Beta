import org.nba.user.NbaRole
import org.nba.user.NbaUser
import java.text.SimpleDateFormat
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_NBA_nbaUser_form_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/nbaUser/_form.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(0)
printHtmlPart(1)
if(true && (message)) {
printHtmlPart(2)
expressionOut.print(message)
printHtmlPart(3)
}
printHtmlPart(4)
expressionOut.print(nbaUserInstance?.name)
printHtmlPart(5)
expressionOut.print(nbaUserInstance?.username)
printHtmlPart(6)
expressionOut.print(nbaUserInstance?.password)
printHtmlPart(7)
invokeTag('select','g',39,['id':("nbaRole.id"),'name':("nbaRole"),'from':(roleList),'noSelection':(['': '--Select Role--']),'optionValue':("authority"),'optionKey':("id"),'required':(""),'value':(nbaUserInstance?.nbaRole?.id),'class':("many-to-one form-control")],-1)
printHtmlPart(8)
expressionOut.print(nbaUserInstance?.email)
printHtmlPart(9)
expressionOut.print(nbaUserInstance?.mobile)
printHtmlPart(10)
expressionOut.print(nbaUserInstance?.phone)
printHtmlPart(11)
expressionOut.print(nbaUserInstance?.dateOfBirth)
printHtmlPart(12)
invokeTag('javascript','asset',58,['src':("beta-version/js/calander/jquery.datetimepicker.js")],-1)
printHtmlPart(13)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1602390204000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
