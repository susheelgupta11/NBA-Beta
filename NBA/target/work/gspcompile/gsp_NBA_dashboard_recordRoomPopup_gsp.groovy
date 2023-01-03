import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_NBA_dashboard_recordRoomPopup_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/dashboard/_recordRoomPopup.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
createTagBody(2, {->
createClosureForHtmlPart(2, 3)
invokeTag('captureTitle','sitemesh',4,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',4,[:],2)
printHtmlPart(3)
invokeTag('javascript','asset',14,['src':("/beta-version/js/jquery.min.js")],-1)
printHtmlPart(4)
})
invokeTag('captureHead','sitemesh',14,[:],1)
printHtmlPart(1)
createTagBody(1, {->
printHtmlPart(5)
createTagBody(2, {->
printHtmlPart(6)
expressionOut.print(formDetails?.appNumber)
printHtmlPart(7)
if(true && (formDetails?.individualProfiles)) {
printHtmlPart(8)
for( individualProfile in (formDetails?.individualProfiles) ) {
printHtmlPart(9)
expressionOut.print(individualProfile?.title)
printHtmlPart(10)
expressionOut.print(individualProfile?.firstName)
printHtmlPart(10)
expressionOut.print(individualProfile?.middleName)
printHtmlPart(10)
expressionOut.print(individualProfile?.lastName)
printHtmlPart(8)
}
printHtmlPart(11)
}
else if(true && (formDetails?.companyProfiles)) {
printHtmlPart(8)
loop:{
int k = 0
for( company in (formDetails?.companyProfiles) ) {
printHtmlPart(10)
expressionOut.print(company?.entityName)
printHtmlPart(8)
k++
}
}
printHtmlPart(11)
}
else if(true && (formDetails?.indianResearcher)) {
printHtmlPart(8)
for( researcher in (formDetails?.indianResearcher) ) {
printHtmlPart(9)
expressionOut.print(researcher?.title)
printHtmlPart(10)
expressionOut.print(researcher?.firstName)
printHtmlPart(10)
expressionOut.print(researcher?.middleName)
printHtmlPart(10)
expressionOut.print(researcher?.lastName)
printHtmlPart(12)
}
printHtmlPart(11)
}
else if(true && (formDetails?.depostionOfMicroOrganism)) {
printHtmlPart(8)
for( depost in (formDetails?.depostionOfMicroOrganism) ) {
printHtmlPart(10)
expressionOut.print(depost?.nameOfDepositor)
printHtmlPart(8)
}
printHtmlPart(11)
}
else if(true && (formDetails?.indianGovtInst)) {
printHtmlPart(8)
for( govt in (formDetails?.indianGovtInst) ) {
printHtmlPart(10)
expressionOut.print(govt?.govtInstName)
printHtmlPart(8)
}
printHtmlPart(11)
}
printHtmlPart(13)
expressionOut.print(formDetails?.appNumber)
printHtmlPart(14)
expressionOut.print(formDetails?.currentStatus?.statusUpdate)
printHtmlPart(15)
invokeTag('select','g',102,['name':("actions"),'class':("form-control"),'from':(actionList),'value':(""),'noSelection':(['':'-Choose Action For Record Room-']),'required':("required")],-1)
printHtmlPart(16)
invokeTag('textArea','g',107,['name':("reason"),'style':("width:100%")],-1)
printHtmlPart(17)
invokeTag('hiddenField','g',111,['name':("appId"),'value':(formDetails?.id)],-1)
printHtmlPart(18)
})
invokeTag('form','g',118,['controller':("dashboard"),'action':("saveRecordRoom"),'id':("reco")],2)
printHtmlPart(19)
invokeTag('stylesheet','asset',128,['src':("beta-version/css/jquery.datetimepicker.min.css")],-1)
printHtmlPart(20)
invokeTag('javascript','asset',130,['src':("beta-version/js/bootstrap.min.js")],-1)
printHtmlPart(20)
invokeTag('javascript','asset',133,['src':("beta-version/js/calander/jquery.datetimepicker.js")],-1)
printHtmlPart(21)
})
invokeTag('captureBody','sitemesh',201,[:],1)
printHtmlPart(22)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1618032194405L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
