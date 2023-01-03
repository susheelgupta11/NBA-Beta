import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_NBA_formPreview_editForm1Part2_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/formPreview/_editForm1Part2.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
createTagBody(1, {->
printHtmlPart(0)
for( bioResource in (listOfBioResources) ) {
printHtmlPart(1)
expressionOut.print(bioResource.nature)
printHtmlPart(2)
expressionOut.print(bioResource?.commonName)
printHtmlPart(3)
expressionOut.print(bioResource?.scientificName)
printHtmlPart(4)
expressionOut.print(bioResource?.biologicalResource)
printHtmlPart(5)
expressionOut.print(bioResource?.quantity)
printHtmlPart(6)
expressionOut.print(bioResource?.qtyUnit)
printHtmlPart(7)
expressionOut.print(bioResource?.traditionalUse)
printHtmlPart(8)
}
printHtmlPart(9)
})
invokeTag('formRemote','g',1,['name':("biologicalResources"),'class':("form-horizontal"),'role':("form"),'url':([controller:'applicationManagement',action:'saveEditForm1Part2']),'update':("updateBioResources"),'onSuccess':("ClearAllFields()"),'onComplete':("loadPage()")],1)
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
