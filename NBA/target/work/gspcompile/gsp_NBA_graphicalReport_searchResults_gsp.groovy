import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_NBA_graphicalReport_searchResults_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/graphicalReport/_searchResults.gsp" }
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
invokeTag('stylesheet','asset',15,['src':("beta-version/css/jquery.datetimepicker.min.css")],-1)
printHtmlPart(4)
invokeTag('javascript','asset',17,['src':("beta-version/js/calander/jquery.datetimepicker.js")],-1)
printHtmlPart(5)
invokeTag('render','g',40,['template':("revenue")],-1)
printHtmlPart(6)
if(true && (searchresults)) {
printHtmlPart(7)
expressionOut.print(totalRevenue.get(0))
printHtmlPart(8)
createTagBody(2, {->
printHtmlPart(9)
invokeTag('submitButton','g',84,['value':("Filter"),'name':("Filter")],-1)
printHtmlPart(2)
})
invokeTag('formRemote','g',84,['name':("filter"),'on404':("alert('not found!')"),'update':("revenue"),'url':([controller: 'graphicalReport', action:'revenueFilter']),'method':("post")],2)
printHtmlPart(10)
loop:{
int i = 0
for( formWise in (searchresults?.result) ) {
printHtmlPart(11)
expressionOut.print(i+1)
printHtmlPart(12)
expressionOut.print(formWise?.applicant_name)
printHtmlPart(12)
expressionOut.print(formWise?.app_number)
printHtmlPart(13)
invokeTag('formatDate','g',136,['format':("dd/MM/yyyy"),'date':(formWise?.changed_on)],-1)
printHtmlPart(12)
expressionOut.print(formWise?.category?:'N/A')
printHtmlPart(12)
expressionOut.print(formWise?.status_update?:'N/A')
printHtmlPart(14)
invokeTag('formatDate','g',142,['format':("dd/MM/yyyy"),'date':(formWise?.forwarded_date)],-1)
printHtmlPart(12)
expressionOut.print(formWise?.current_desk?:'Initial User')
printHtmlPart(12)
expressionOut.print(formWise?.action_for?:'N/A')
printHtmlPart(15)
i++
}
}
printHtmlPart(16)
}
printHtmlPart(17)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1666086079198L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
