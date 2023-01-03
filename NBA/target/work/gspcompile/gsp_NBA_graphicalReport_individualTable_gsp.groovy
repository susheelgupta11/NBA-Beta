import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_NBA_graphicalReport_individualTable_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/graphicalReport/_individualTable.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
invokeTag('stylesheet','asset',6,['src':("exportTable/fixedHeader.dataTables.min.css")],-1)
printHtmlPart(1)
invokeTag('javascript','asset',7,['src':("exportTable/jquery-3.5.1.js")],-1)
printHtmlPart(2)
invokeTag('javascript','asset',8,['src':("exportTable/jquery.dataTables.min.js")],-1)
printHtmlPart(2)
invokeTag('javascript','asset',8,['src':("exportTable/dataTables.buttons.min.js")],-1)
printHtmlPart(2)
invokeTag('javascript','asset',9,['src':("exportTable/jszip.min.js")],-1)
printHtmlPart(2)
invokeTag('javascript','asset',10,['src':("exportTable/pdfmake.min.js")],-1)
printHtmlPart(2)
invokeTag('javascript','asset',10,['src':("exportTable/vfs_fonts.js")],-1)
printHtmlPart(2)
invokeTag('javascript','asset',11,['src':("exportTable/buttons.html5.min.js")],-1)
printHtmlPart(2)
invokeTag('javascript','asset',13,['src':("exportTable/buttons.print.min.js")],-1)
printHtmlPart(2)
invokeTag('javascript','asset',14,['src':("exportTable/dataTables.fixedHeader.min.js")],-1)
printHtmlPart(3)
if(true && (ondeskApplication)) {
printHtmlPart(4)
loop:{
int i = 0
for( ind in (ondeskApplication) ) {
printHtmlPart(5)
expressionOut.print(i+1)
printHtmlPart(6)
expressionOut.print(ind?.application?.appNumber)
printHtmlPart(7)
invokeTag('formatDate','g',82,['format':("dd/MM/yyyy"),'date':(ind?.changedOn)],-1)
printHtmlPart(8)
expressionOut.print(ind?.statusUpdate?:'N/A')
printHtmlPart(9)
invokeTag('formatDate','g',88,['format':("dd/MM/yyyy"),'date':(ind?.forwardedDate)],-1)
printHtmlPart(10)
expressionOut.print(ind?.currentDesk?:'Initial User')
printHtmlPart(10)
expressionOut.print(ind?.actionFor?:'N/A')
printHtmlPart(11)
i++
}
}
printHtmlPart(12)
}
printHtmlPart(13)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1641988789057L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
