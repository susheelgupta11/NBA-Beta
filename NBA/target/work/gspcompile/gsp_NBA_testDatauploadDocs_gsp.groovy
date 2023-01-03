import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_NBA_testDatauploadDocs_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/testData/uploadDocs.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)

int i=1

printHtmlPart(1)
for( document in (listOfdocs) ) {
printHtmlPart(2)
createTagBody(2, {->
printHtmlPart(3)
expressionOut.print(document?.docName)
printHtmlPart(4)
if(true && (document?.document)) {
printHtmlPart(5)
createTagBody(4, {->
printHtmlPart(6)
expressionOut.print(document?.docName)
printHtmlPart(5)
})
invokeTag('link','g',18,['controller':("testData"),'action':("viewDoc"),'id':(document?.id),'target':("_blank"),'params':([filename: 'docName', dataName: 'docFormat',csrfPreventionSalt:'${csrfPreventionSalt}'])],4)
printHtmlPart(7)
}
else {
printHtmlPart(8)
invokeTag('hiddenField','g',24,['name':("docId"),'value':(document?.id)],-1)
printHtmlPart(7)
}
printHtmlPart(9)
if(true && (!document?.document)) {
printHtmlPart(6)
invokeTag('submitButton','g',29,['class':("btn btn-primary ProjectInViewMode ButtonMargin ButtonPadding"),'name':("update"),'value':("SAVE"),'id':("btnSave")],-1)
printHtmlPart(5)
}
printHtmlPart(10)
})
invokeTag('uploadForm','g',31,['action':("addDocument"),'autocomplete':("off")],2)
printHtmlPart(11)
}
printHtmlPart(12)
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
