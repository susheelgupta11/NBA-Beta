import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_NBA_applicant_form1Periodic_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/applicant/_form1Periodic.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',4,['gsp_sm_xmlClosingForEmptyTag':("/"),'http-equiv':("Content-Type"),'content':("text/html; charset=ISO-8859-1")],-1)
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',5,['gsp_sm_xmlClosingForEmptyTag':("/"),'name':("layout"),'content':("main")],-1)
printHtmlPart(1)
createTagBody(2, {->
createClosureForHtmlPart(2, 3)
invokeTag('captureTitle','sitemesh',6,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',6,[:],2)
printHtmlPart(1)
})
invokeTag('captureHead','sitemesh',7,[:],1)
printHtmlPart(1)
createTagBody(1, {->
printHtmlPart(3)
expressionOut.print(periodicReportInstance?.applicationNumber)
printHtmlPart(4)
expressionOut.print(periodicReportInstance?.applicantName)
printHtmlPart(5)
expressionOut.print(periodicReportInstance?.agreementSignDt)
printHtmlPart(6)
expressionOut.print(periodicReportInstance?.whetherAccessedBioRes)
printHtmlPart(7)
expressionOut.print(periodicReportInstance?.whenBiologicalResearch)
printHtmlPart(8)
expressionOut.print(periodicReportInstance?.reserchCarriedOut)
printHtmlPart(9)
expressionOut.print(periodicReportInstance?.briefResearchCarried)
printHtmlPart(10)
expressionOut.print(periodicReportInstance?.haveYouPublished)
printHtmlPart(11)
expressionOut.print(periodicReportInstance?.haveAppliedPatent)
printHtmlPart(12)
expressionOut.print(periodicReportInstance?.haveTransferredResults)
printHtmlPart(13)
expressionOut.print(periodicReportInstance?.haveTransferredBiological)
printHtmlPart(14)
if(true && (periodicReportInstance)) {
printHtmlPart(15)
for( file in (periodicReportInstance?.periodicFiles) ) {
printHtmlPart(16)
expressionOut.print(file?.fileName)
printHtmlPart(17)
}
printHtmlPart(18)
}
printHtmlPart(19)
})
invokeTag('captureBody','sitemesh',101,[:],1)
printHtmlPart(20)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1649653693511L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
