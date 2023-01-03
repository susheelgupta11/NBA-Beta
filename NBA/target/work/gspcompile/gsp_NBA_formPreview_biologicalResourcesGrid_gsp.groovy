import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_NBA_formPreview_biologicalResourcesGrid_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/formPreview/_biologicalResourcesGrid.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
if(true && (formType != 'Form3' && formType != 'Form2')) {
printHtmlPart(1)
}
printHtmlPart(2)
if(true && (formType != 'Form4')) {
printHtmlPart(3)
}
printHtmlPart(2)
if(true && (formType != 'Form3' && formType !='Form4' && formType != 'Form2')) {
printHtmlPart(4)
}
printHtmlPart(5)
if(true && (listOfBioResources)) {
printHtmlPart(6)

int i=1

printHtmlPart(6)
for( bioResource in (listOfBioResources) ) {
printHtmlPart(7)
out.print(i)
printHtmlPart(8)

i++

printHtmlPart(9)
expressionOut.print(bioResource?.commonName)
printHtmlPart(10)
expressionOut.print(bioResource?.scientificName)
printHtmlPart(10)
expressionOut.print(bioResource?.nature)
printHtmlPart(10)
expressionOut.print(bioResource?.biologicalResource)
printHtmlPart(8)
if(true && (formType != 'Form3' &&  formType != 'Form2')) {
printHtmlPart(9)
expressionOut.print(bioResource?.quantity)
printHtmlPart(11)
expressionOut.print(bioResource?.qtyUnit)
printHtmlPart(12)
}
printHtmlPart(13)
if(true && (formType != 'Form3' && formType != 'Form4' && formType != 'Form2')) {
printHtmlPart(9)
expressionOut.print(bioResource?.fromTime?.format('dd/MM/yyyy'))
printHtmlPart(14)
expressionOut.print(bioResource?.toTime?.format('dd/MM/yyyy'))
printHtmlPart(10)
expressionOut.print(bioResource?.traditionalUse)
printHtmlPart(8)
}
printHtmlPart(15)
}
printHtmlPart(16)
}
else {
printHtmlPart(17)
}
printHtmlPart(18)
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
