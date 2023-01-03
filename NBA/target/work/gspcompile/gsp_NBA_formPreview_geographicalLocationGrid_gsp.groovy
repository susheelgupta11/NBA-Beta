import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_NBA_formPreview_geographicalLocationGrid_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/formPreview/_geographicalLocationGrid.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
if(true && (listOfLocations)) {
printHtmlPart(1)

int i=1

printHtmlPart(2)
for( location in (listOfLocations) ) {
printHtmlPart(3)
out.print(i)
printHtmlPart(4)

i++

printHtmlPart(5)
if(true && (location?.bioResource?.scientificName)) {
printHtmlPart(6)
expressionOut.print(location?.bioResource?.scientificName)
printHtmlPart(7)
}
else {
printHtmlPart(8)
}
printHtmlPart(9)
if(true && (location?.source)) {
printHtmlPart(6)
expressionOut.print(location?.source)
printHtmlPart(7)
}
else {
printHtmlPart(8)
}
printHtmlPart(5)
if(true && (location?.village)) {
printHtmlPart(6)
expressionOut.print(location?.village)
printHtmlPart(7)
}
else {
printHtmlPart(8)
}
printHtmlPart(5)
if(true && (location?.town)) {
printHtmlPart(6)
expressionOut.print(location?.town)
printHtmlPart(7)
}
else {
printHtmlPart(8)
}
printHtmlPart(5)
if(true && (location?.district)) {
printHtmlPart(6)
expressionOut.print(location?.district)
printHtmlPart(7)
}
else {
printHtmlPart(8)
}
printHtmlPart(9)
if(true && (location?.state)) {
printHtmlPart(6)
expressionOut.print(location?.state)
printHtmlPart(7)
}
else {
printHtmlPart(8)
}
printHtmlPart(5)
if(true && (location?.traderName)) {
printHtmlPart(6)
expressionOut.print(location?.traderName)
printHtmlPart(7)
}
else {
printHtmlPart(8)
}
printHtmlPart(5)
if(true && (location?.traderContactDetails)) {
printHtmlPart(6)
expressionOut.print(location?.traderContactDetails)
printHtmlPart(7)
}
else {
printHtmlPart(8)
}
printHtmlPart(10)
}
printHtmlPart(11)
}
else {
printHtmlPart(12)
}
printHtmlPart(13)
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
