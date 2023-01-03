import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_NBA_formPreview_companyProfileGridPreview_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/formPreview/_companyProfileGridPreview.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)

int i=1

printHtmlPart(1)
for( profile in (listOfCompanyData) ) {
printHtmlPart(2)
out.print(i)
printHtmlPart(3)

i++

printHtmlPart(4)
expressionOut.print(profile?.entityName)
printHtmlPart(5)
expressionOut.print(profile?.entityType)
printHtmlPart(5)
expressionOut.print(profile?.address1)
printHtmlPart(6)
expressionOut.print(profile?.address2)
printHtmlPart(6)
expressionOut.print(profile?.address3)
printHtmlPart(6)
expressionOut.print(profile?.city)
printHtmlPart(7)
expressionOut.print(profile?.province)
printHtmlPart(6)
expressionOut.print(profile?.country?.country)
printHtmlPart(5)
expressionOut.print(profile?.mobile)
printHtmlPart(5)
expressionOut.print(profile?.phone)
printHtmlPart(5)
expressionOut.print(profile?.email)
printHtmlPart(5)
expressionOut.print(profile?.website)
printHtmlPart(8)
}
printHtmlPart(9)
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
