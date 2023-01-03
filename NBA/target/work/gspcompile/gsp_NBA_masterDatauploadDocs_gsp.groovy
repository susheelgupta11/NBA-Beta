import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_NBA_masterDatauploadDocs_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/masterData/uploadDocs.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',3,['gsp_sm_xmlClosingForEmptyTag':("/"),'name':("layout"),'content':("loggedInUser")],-1)
printHtmlPart(2)
createTagBody(2, {->
printHtmlPart(3)
expressionOut.print(listOfdocs)
printHtmlPart(4)
})
invokeTag('javascript','g',7,[:],2)
printHtmlPart(5)
})
invokeTag('captureHead','sitemesh',13,[:],1)
printHtmlPart(1)
createTagBody(1, {->
printHtmlPart(6)
invokeTag('render','g',17,['template':("/manageContent/AdminLeftTab")],-1)
printHtmlPart(7)

int i=1

printHtmlPart(8)
for( document in (listOfdocs?.sort{it.id}) ) {
printHtmlPart(9)
createTagBody(3, {->
printHtmlPart(10)
expressionOut.print(document?.docName)
printHtmlPart(11)
if(true && (document?.document)) {
printHtmlPart(12)
invokeTag('hiddenField','g',37,['name':("docId"),'value':(document?.id)],-1)
printHtmlPart(13)
if(true && (formatMessage && document?.id?.toString() == docId)) {
printHtmlPart(14)
expressionOut.print(flash.message)
printHtmlPart(15)
}
else {
printHtmlPart(16)
createTagBody(6, {->
printHtmlPart(17)
expressionOut.print(document?.docName)
printHtmlPart(18)
})
invokeTag('link','g',52,['controller':("testData"),'action':("viewDoc"),'id':(document?.id),'target':("_blank"),'params':([filename: "docName", dataName: "docFormat",csrfPreventionSalt:"${csrfPreventionSalt}"])],6)
printHtmlPart(19)
}
printHtmlPart(20)
}
else {
printHtmlPart(21)
expressionOut.print(flash.message)
printHtmlPart(22)
invokeTag('hiddenField','g',63,['name':("docId"),'value':(document?.id)],-1)
printHtmlPart(23)
}
printHtmlPart(24)
invokeTag('submitButton','g',67,['class':("btn btn-primary ProjectInViewMode ButtonMargin ButtonPadding"),'name':("update"),'value':("SAVE"),'id':("btnSave")],-1)
printHtmlPart(25)
})
invokeTag('uploadForm','g',68,['action':("addDocument"),'autocomplete':("off")],3)
printHtmlPart(26)
}
printHtmlPart(27)
createClosureForHtmlPart(28, 2)
invokeTag('link','g',75,['controller':("loggedInAs"),'action':("inbox"),'class':("btn btn-primary")],2)
printHtmlPart(29)
})
invokeTag('captureBody','sitemesh',76,[:],1)
printHtmlPart(30)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1544686654000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
