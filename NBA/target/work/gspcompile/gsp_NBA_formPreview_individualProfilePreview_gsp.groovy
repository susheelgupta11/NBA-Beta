import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_NBA_formPreview_individualProfilePreview_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/formPreview/_individualProfilePreview.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
for( profile in (listofFormData) ) {
printHtmlPart(0)
expressionOut.print(profile?.title)
printHtmlPart(1)
expressionOut.print(profile?.firstName)
printHtmlPart(1)
expressionOut.print(profile?.middleName)
printHtmlPart(1)
expressionOut.print(profile?.lastName)
printHtmlPart(2)
expressionOut.print(profile?.nationality)
printHtmlPart(3)
expressionOut.print(profile?.address1)
printHtmlPart(4)
expressionOut.print(profile?.address2)
printHtmlPart(4)
expressionOut.print(profile?.address3)
printHtmlPart(5)
expressionOut.print(profile?.city)
printHtmlPart(6)
expressionOut.print(profile?.country?.country)
printHtmlPart(7)
expressionOut.print(profile?.pincode)
printHtmlPart(8)
expressionOut.print(profile?.mobile)
printHtmlPart(9)
expressionOut.print(profile?.phone)
printHtmlPart(10)
expressionOut.print(profile?.email)
printHtmlPart(11)
createTagBody(2, {->
printHtmlPart(12)
expressionOut.print(profile?.idProofFileName)
printHtmlPart(13)
})
invokeTag('link','g',103,['controller':("applicationManagement"),'action':("showIndividualDc"),'id':(profile?.id),'target':("_blank"),'params':([filename: 'idProof', dataName: 'idProof',csrfPreventionSalt:'${csrfPreventionSalt}'])],2)
printHtmlPart(14)
createTagBody(2, {->
printHtmlPart(12)
expressionOut.print(profile?.passportCopyFileName)
printHtmlPart(13)
})
invokeTag('link','g',117,['controller':("applicationManagement"),'action':("showIndividualDc"),'id':(profile?.id),'target':("_blank"),'params':([filename: 'passportCopy', dataName: 'passportCopy',csrfPreventionSalt:'${csrfPreventionSalt}'])],2)
printHtmlPart(15)
createTagBody(2, {->
printHtmlPart(12)
expressionOut.print(profile?.authorizationLetterFileName)
printHtmlPart(13)
})
invokeTag('link','g',131,['controller':("applicationManagement"),'action':("showIndividualDc"),'id':(profile?.id),'target':("_blank"),'params':([filename: 'authorizationLetter', dataName: 'authorizationLetter',csrfPreventionSalt:'${csrfPreventionSalt}'])],2)
printHtmlPart(16)
expressionOut.print(profile?.profile)
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
