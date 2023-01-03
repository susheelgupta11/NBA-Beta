
import org.nba.application.FormCategory

import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_NBA_agenda_dynamicAgendaPdf_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/agenda/_dynamicAgendaPdf.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(1)
printHtmlPart(2)
createTagBody(1, {->
printHtmlPart(3)
invokeTag('captureMeta','sitemesh',12,['gsp_sm_xmlClosingForEmptyTag':("/"),'charset':("utf-8")],-1)
printHtmlPart(3)
createTagBody(2, {->
createClosureForHtmlPart(4, 3)
invokeTag('captureTitle','sitemesh',13,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',13,[:],2)
printHtmlPart(5)
})
invokeTag('captureHead','sitemesh',25,[:],1)
printHtmlPart(6)
createTagBody(1, {->
printHtmlPart(7)
expressionOut.print(agendaInstance?.meetingName)
printHtmlPart(8)
expressionOut.print(agendaInstance?.meetingNum)
printHtmlPart(9)
expressionOut.print(agendaInstance?.fromDate)
printHtmlPart(10)
expressionOut.print(agendaInstance?.toDate)
printHtmlPart(11)
expressionOut.print(agendaInstance?.dynamicMeetNum)
printHtmlPart(12)
expressionOut.print(agendaInstance?.appNumber)
printHtmlPart(13)
expressionOut.print(agendaInstance?.refNo)
printHtmlPart(14)
expressionOut.print(agendaInstance?.name)
printHtmlPart(15)
expressionOut.print(agendaInstance?.address)
printHtmlPart(16)
expressionOut.print(agendaInstance?.formType)
printHtmlPart(17)
expressionOut.print(agendaInstance?.prescribedApplication)
printHtmlPart(18)
if(true && (techChecklist?.technicalInformation == true)) {
printHtmlPart(19)
invokeTag('set','g',126,['value':("Yes"),'var':("wherter")],-1)
printHtmlPart(19)
}
else {
invokeTag('set','g',128,['value':("No"),'var':("wherter")],-1)
}
printHtmlPart(20)
expressionOut.print(wherter)
printHtmlPart(21)
expressionOut.print(agendaInstance?.individualOrEntity)
printHtmlPart(22)
expressionOut.print(agendaInstance?.applicationFee)
printHtmlPart(23)
if(true && (formDetails?.category?.category == FormCategory?.Category?.Form_1)) {
printHtmlPart(24)
}
printHtmlPart(25)
if(true && (formDetails?.biologicalResources)) {
printHtmlPart(26)
loop:{
int b = 0
for( bioRes in (formDetails?.biologicalResources) ) {
printHtmlPart(27)
expressionOut.print(b+1)
printHtmlPart(28)
expressionOut.print(bioRes?.nature ?: 'NA')
printHtmlPart(28)
expressionOut.print(bioRes?.name ?: 'NA')
printHtmlPart(28)
expressionOut.print(bioRes?.commonName ?: 'NA')
printHtmlPart(29)
expressionOut.print(bioRes?.scientificName ?: 'NA')
printHtmlPart(30)
if(true && (formDetails?.category?.category == FormCategory?.Category?.Form_1)) {
printHtmlPart(31)
expressionOut.print(bioRes?.quantity?: 'NA')
printHtmlPart(32)
expressionOut.print(bioRes?.qtyUnit?: 'NA')
printHtmlPart(30)
}
printHtmlPart(33)
b++
}
}
printHtmlPart(34)
}
printHtmlPart(35)
if(true && (formDetails?.biologicalResources?.locations)) {
printHtmlPart(36)
loop:{
int p = 0
for( bioRes in (formDetails?.biologicalResources?.locations) ) {
printHtmlPart(37)
loop:{
int o = 0
for( gioloc in (bioRes) ) {
printHtmlPart(38)
expressionOut.print(p+o+1)
printHtmlPart(28)
expressionOut.print(gioloc?.bioResource?.scientificName?:'NA')
printHtmlPart(28)
expressionOut.print(gioloc?.source?:'NA')
printHtmlPart(39)
if(true && (gioloc?.source == 'Wild' || 'Cultivated' == gioloc?.source)) {
printHtmlPart(31)
expressionOut.print(gioloc?.village ?: 'NA')
printHtmlPart(40)
expressionOut.print(gioloc?.town ?: 'NA')
printHtmlPart(40)
expressionOut.print(gioloc?.district ?: 'NA')
printHtmlPart(40)
expressionOut.print(gioloc?.state ?: 'NA')
printHtmlPart(41)
}
else {
printHtmlPart(42)
expressionOut.print(gioloc?.traderName?:'NA')
printHtmlPart(43)
expressionOut.print(gioloc?.traderContactDetails?:'NA')
printHtmlPart(44)
}
printHtmlPart(33)
o++
}
}
printHtmlPart(34)
p++
}
}
printHtmlPart(34)
}
printHtmlPart(45)
expressionOut.print(agendaInstance?.sbbbmc)
printHtmlPart(46)
expressionOut.print(agendaInstance?.recommendationSbb)
printHtmlPart(47)
if(true && (formDetails?.category?.category == FormCategory?.Category?.Form_1)) {
printHtmlPart(48)
invokeTag('textArea','g',266,['name':("thirdpartyPurpose"),'value':(techChecklist?.assoKnowledgeRmk)],-1)
printHtmlPart(49)
}
else if(true && (formDetails?.category?.category == FormCategory?.Category?.Form_2)) {
printHtmlPart(49)
invokeTag('textArea','g',270,['name':("thirdpartyPurpose"),'value':("Transfer of Research Results")],-1)
printHtmlPart(49)
}
else if(true && (formDetails?.category?.category == FormCategory?.Category?.Form_3)) {
printHtmlPart(49)
invokeTag('textArea','g',274,['name':("thirdpartyPurpose"),'value':("Intellectual Property Rights (IPR)")],-1)
printHtmlPart(49)
}
else if(true && (formDetails?.category?.category == FormCategory?.Category?.Form_4)) {
printHtmlPart(49)
invokeTag('textArea','g',278,['name':("thirdpartyPurpose"),'value':("Third Party Transfer")],-1)
printHtmlPart(49)
}
printHtmlPart(50)
if(true && (formDetails?.approvalOfNba == true)) {
printHtmlPart(51)
}
else {
printHtmlPart(52)
}
printHtmlPart(53)
expressionOut.print(agendaInstance?.receiptTimeTaken)
printHtmlPart(54)
expressionOut.print(agendaInstance?.inordinateDelay)
printHtmlPart(55)
if(true && (rare)) {
printHtmlPart(56)
loop:{
int i = 0
for( ntc in (rare) ) {
printHtmlPart(57)
expressionOut.print(i+1)
printHtmlPart(58)
expressionOut.print(ntc?.bio_resource)
printHtmlPart(58)
expressionOut.print(ntc?.status)
printHtmlPart(59)
i++
}
}
printHtmlPart(56)
}
else {
printHtmlPart(60)
}
printHtmlPart(61)
expressionOut.print(agendaInstance?.alreadyExpEC)
printHtmlPart(62)
expressionOut.print(agendaInstance?.actiontaken)
printHtmlPart(63)
expressionOut.print(agendaInstance?.remarkByNba)
printHtmlPart(64)
if(true && (agendaInstance?.recommendationByNba)) {
printHtmlPart(65)
expressionOut.print(agendaInstance?.recommendationByNba)
printHtmlPart(64)
}
printHtmlPart(66)
if(true && (agendaInstance?.signature)) {
printHtmlPart(67)
for( sign in (agendaInstance?.signature) ) {
printHtmlPart(68)
expressionOut.print(sign?.agendaActionBy)
printHtmlPart(69)
expressionOut.print(sign?.agendaAction)
printHtmlPart(70)
expressionOut.print(sign?.agendaActionRole)
printHtmlPart(71)
invokeTag('formatDate','g',415,['format':("dd/MM/yyyy hh:mm aa"),'date':(sign?.agendaActionDate)],-1)
printHtmlPart(72)
}
printHtmlPart(73)
}
printHtmlPart(74)
})
invokeTag('captureBody','sitemesh',441,[:],1)
printHtmlPart(75)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1671616267201L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
