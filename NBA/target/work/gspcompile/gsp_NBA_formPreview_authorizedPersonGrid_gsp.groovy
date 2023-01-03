import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_NBA_formPreview_authorizedPersonGrid_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/formPreview/_authorizedPersonGrid.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)

int i=1

printHtmlPart(1)
for( profile in (listOfContactPerson) ) {
printHtmlPart(2)
out.print(i)
printHtmlPart(3)

i++

printHtmlPart(4)
expressionOut.print(profile?.nameOfContactPerson)
printHtmlPart(5)
expressionOut.print(profile?.addressOfContactPerson)
printHtmlPart(6)
expressionOut.print(profile?.mobileOfContactPerson)
printHtmlPart(6)
expressionOut.print(profile?.emailOfContactPerson)
printHtmlPart(7)
}
printHtmlPart(8)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1537268168000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
