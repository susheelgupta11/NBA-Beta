import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_NBA_formPreview_geographicalLocationForm_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/formPreview/_geographicalLocationForm.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
createTagBody(1, {->
printHtmlPart(0)
for( geoLocation in (listOfLocations) ) {
printHtmlPart(1)
expressionOut.print(geoLocation?.bioResource?.scientificName)
printHtmlPart(2)
expressionOut.print(geoLocation?.source)
printHtmlPart(3)
expressionOut.print(geoLocation?.village)
printHtmlPart(4)
expressionOut.print(geoLocation?.town)
printHtmlPart(5)
expressionOut.print(geoLocation?.district)
printHtmlPart(6)
expressionOut.print(geoLocation?.state)
printHtmlPart(7)
expressionOut.print(geoLocation?.traderName)
printHtmlPart(8)
expressionOut.print(geoLocation?.traderContactDetails)
printHtmlPart(9)
}
printHtmlPart(10)
})
invokeTag('formRemote','g',1,['name':("geoLocation"),'id':("geoLocation"),'class':("form-horizontal"),'role':("form"),'url':([controller:'applicationManagement',action:'saveGeoLocation']),'update':("addEditForm1Part2"),'onSuccess':("ClearAllFields()"),'onComplete':("loadPage()")],1)
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
