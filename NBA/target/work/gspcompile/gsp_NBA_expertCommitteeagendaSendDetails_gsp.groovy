
import org.nba.application.FormCategory

import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_NBA_expertCommitteeagendaSendDetails_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/expertCommittee/agendaSendDetails.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(1)
createTagBody(1, {->
printHtmlPart(0)
invokeTag('captureMeta','sitemesh',5,['gsp_sm_xmlClosingForEmptyTag':("/"),'http-equiv':("Content-Type"),'content':("text/html; charset=ISO-8859-1")],-1)
printHtmlPart(0)
invokeTag('captureMeta','sitemesh',6,['gsp_sm_xmlClosingForEmptyTag':("/"),'name':("layout"),'content':("expertMember")],-1)
printHtmlPart(0)
createTagBody(2, {->
createClosureForHtmlPart(2, 3)
invokeTag('captureTitle','sitemesh',7,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',7,[:],2)
printHtmlPart(3)
})
invokeTag('captureHead','sitemesh',9,[:],1)
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(4)
loop:{
int i = 0
for( ecd in (agendaDetails) ) {
printHtmlPart(5)
expressionOut.print(ecd?.dynamicMeetNum)
printHtmlPart(6)
expressionOut.print(ecd?.name)
printHtmlPart(7)
expressionOut.print(ecd?.appNumber)
printHtmlPart(8)
expressionOut.print(ecd?.formType)
printHtmlPart(9)
invokeTag('set','g',42,['value':("previewForm${ecd?.formType?.substring(5)}Info"),'var':("dyaction")],-1)
printHtmlPart(10)
invokeTag('formatDate','g',45,['format':("dd/MM/yyyy"),'date':(ecd?.sendDate)],-1)
printHtmlPart(11)
createClosureForHtmlPart(12, 3)
invokeTag('link','g',49,['action':("pdfAgendaDownload"),'controller':("expertCommittee"),'params':([downId:ecd?.id, csrfPreventionSalt:csrfPreventionSalt]),'target':("_blank")],3)
printHtmlPart(13)
createClosureForHtmlPart(14, 3)
invokeTag('remoteLink','g',57,['action':(dyaction),'controller':("FormPreview"),'title':("View Application"),'id':(ecd?.applicationForm1?.id),'params':([fromLogin:"true",appFormId:ecd?.applicationForm1?.id,csrfPreventionSalt:"${csrfPreventionSalt}"]),'data-target':("#app-modal"),'data-toggle':("modal"),'update':("nin")],3)
printHtmlPart(15)
if(true && (ecd?.recoStatus)) {
printHtmlPart(16)
createClosureForHtmlPart(17, 4)
invokeTag('link','g',64,['action':("recomDownload"),'controller':("expertCommittee"),'params':([downId:ecd?.id, csrfPreventionSalt:csrfPreventionSalt]),'target':("_blank")],4)
printHtmlPart(18)
}
else {
printHtmlPart(19)
createTagBody(4, {->
printHtmlPart(20)
invokeTag('hiddenField','g',95,['name':("agenId"),'value':(ecd.id)],-1)
printHtmlPart(20)
invokeTag('hiddenField','g',98,['name':("csrfPreventionSalt"),'value':(csrfPreventionSalt)],-1)
printHtmlPart(21)
invokeTag('textField','g',107,['name':("whetherTraditional"),'required':("true")],-1)
printHtmlPart(22)
invokeTag('textField','g',113,['name':("screeningBiores"),'required':("true")],-1)
printHtmlPart(23)
invokeTag('textField','g',119,['name':("rareEndemic"),'required':("true")],-1)
printHtmlPart(24)
invokeTag('textField','g',125,['name':("wildlifeAct"),'required':("true")],-1)
printHtmlPart(25)
invokeTag('textField','g',131,['name':("restricted"),'required':("true")],-1)
printHtmlPart(26)
invokeTag('textField','g',138,['name':("originalFile"),'required':("true")],-1)
printHtmlPart(27)
invokeTag('textField','g',146,['name':("proposal")],-1)
printHtmlPart(28)
invokeTag('textField','g',149,['name':("anyOther")],-1)
printHtmlPart(29)
})
invokeTag('form','g',167,['controller':("expertCommittee"),'action':("saveRecommendation"),'method':("POST")],4)
printHtmlPart(30)
}
printHtmlPart(31)
i++
}
}
printHtmlPart(32)
invokeTag('render','g',178,['template':("/common/dashRightComm")],-1)
printHtmlPart(33)
})
invokeTag('captureBody','sitemesh',221,[:],1)
printHtmlPart(34)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1623183263478L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
