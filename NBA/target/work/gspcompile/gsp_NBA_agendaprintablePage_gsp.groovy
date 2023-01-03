
import org.nba.application.FormCategory

import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_NBA_agendaprintablePage_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/agenda/printablePage.gsp" }
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
invokeTag('captureMeta','sitemesh',6,['gsp_sm_xmlClosingForEmptyTag':("/"),'name':("layout"),'content':("projectPreview")],-1)
printHtmlPart(0)
createTagBody(2, {->
invokeTag('captureTitle','sitemesh',7,[:],-1)
})
invokeTag('wrapTitleTag','sitemesh',7,[:],2)
printHtmlPart(2)
})
invokeTag('captureHead','sitemesh',18,[:],1)
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(0)
if(true && (formDetails?.individualProfiles)) {
printHtmlPart(3)
for( individualProfile in (formDetails?.individualProfiles) ) {
printHtmlPart(0)
invokeTag('set','g',24,['var':("name"),'value':("${individualProfile?.title ?:''} ${individualProfile?.firstName ?:''} ${individualProfile?.middleName?: ''} ${individualProfile?.lastName ?:''}")],-1)
printHtmlPart(4)
invokeTag('set','g',25,['value':("${individualProfile?.address1 ?:''} ${individualProfile?.address2 ?:''} ${individualProfile?.address3 ?:''} ${individualProfile?.city ?:''}"),'var':("address")],-1)
printHtmlPart(5)
}
printHtmlPart(6)
}
else if(true && (formDetails?.companyProfiles)) {
printHtmlPart(3)
loop:{
int k = 0
for( company in (formDetails?.companyProfiles) ) {
printHtmlPart(3)
invokeTag('set','g',30,['var':("name"),'value':("	${company?.entityName}")],-1)
printHtmlPart(3)
k++
}
}
printHtmlPart(6)
}
else if(true && (formDetails?.indianResearcher)) {
printHtmlPart(3)
for( researcher in (formDetails?.indianResearcher) ) {
printHtmlPart(7)
invokeTag('set','g',38,['var':("name"),'value':("""	${researcher?.title}
					${researcher?.firstName}
					${researcher?.middleName}
					${researcher?.lastName}""")],-1)
printHtmlPart(8)
invokeTag('set','g',43,['value':("""${researcher?.address1}
					${researcher?.address2}
					${researcher?.address3}
					${researcher?.presentCity}"""),'var':("address")],-1)
printHtmlPart(9)
}
printHtmlPart(6)
}
else if(true && (formDetails?.depostionOfMicroOrganism)) {
printHtmlPart(3)
for( depost in (formDetails?.depostionOfMicroOrganism) ) {
printHtmlPart(3)
invokeTag('set','g',48,['var':("name"),'value':("	${depost?.nameOfDepositor}")],-1)
printHtmlPart(10)
invokeTag('set','g',52,['value':("""${depost?.address1}
					${depost?.address2}
					${depost?.address3}
					${depost?.city}"""),'var':("address")],-1)
printHtmlPart(11)
}
printHtmlPart(6)
}
else if(true && (formDetails?.indianGovtInst)) {
printHtmlPart(3)
for( govt in (formDetails?.indianGovtInst) ) {
printHtmlPart(3)
invokeTag('set','g',56,['var':("name"),'value':("	${govt?.govtInstName}")],-1)
printHtmlPart(12)
invokeTag('set','g',61,['value':("""${govt?.address1}
					${govt?.address2}
					${govt?.address3}
					${govt?.presentCity}"""),'var':("address")],-1)
printHtmlPart(3)
}
printHtmlPart(6)
}
printHtmlPart(13)
invokeTag('hiddenField','g',65,['name':("name"),'value':(name)],-1)
printHtmlPart(6)
invokeTag('hiddenField','g',66,['name':("address"),'value':(address)],-1)
printHtmlPart(14)
expressionOut.print(resource(dir: 'images', file: 'Logo1.jpg'))
printHtmlPart(15)
expressionOut.print(agendaInstance?.meetingName)
printHtmlPart(16)
expressionOut.print(agendaInstance?.meetingNum)
printHtmlPart(17)
expressionOut.print(agendaInstance?.fromDate)
printHtmlPart(18)
expressionOut.print(agendaInstance?.toDate)
printHtmlPart(19)
expressionOut.print(agendaInstance?.dynamicMeetNum)
printHtmlPart(20)
expressionOut.print(formDetails?.appNumber)
printHtmlPart(21)
expressionOut.print(agendaInstance?.refNo)
printHtmlPart(22)
expressionOut.print(name)
printHtmlPart(23)
expressionOut.print(address)
printHtmlPart(24)
if(true && (formDetails?.category?.category == FormCategory?.Category?.Form_1)) {
printHtmlPart(25)
invokeTag('textField','g',143,['name':("formType"),'value':("Form I")],-1)
printHtmlPart(26)
invokeTag('set','g',144,['value':("10,000 /-"),'var':("fee")],-1)
printHtmlPart(26)
}
else if(true && (formDetails?.category?.category == FormCategory?.Category?.Form_2)) {
printHtmlPart(27)
invokeTag('textField','g',147,['name':("formType"),'value':("Form II")],-1)
printHtmlPart(27)
invokeTag('set','g',148,['value':("5,000 /-"),'var':("fee")],-1)
printHtmlPart(27)
}
else if(true && (formDetails?.category?.category == FormCategory?.Category?.Form_3)) {
printHtmlPart(27)
invokeTag('textField','g',152,['name':("formType"),'value':("Form III")],-1)
printHtmlPart(27)
invokeTag('set','g',153,['value':("500 /-"),'var':("fee")],-1)
printHtmlPart(27)
}
else if(true && (formDetails?.category?.category == FormCategory?.Category?.Form_4)) {
printHtmlPart(27)
invokeTag('textField','g',156,['name':("formType"),'value':("Form IV")],-1)
printHtmlPart(27)
invokeTag('set','g',157,['value':("10,000 /-"),'var':("fee")],-1)
printHtmlPart(27)
}
else if(true && (formDetails?.category?.category == FormCategory?.Category?.Form_B)) {
printHtmlPart(27)
invokeTag('textField','g',160,['name':("formType"),'value':("Form B")],-1)
printHtmlPart(27)
}
printHtmlPart(28)
expressionOut.print(agendaInstance?.prescribedApplication)
printHtmlPart(29)
expressionOut.print(agendaInstance?.prescribedApplication)
printHtmlPart(30)
if(true && (formDetails?.individualProfiles)) {
printHtmlPart(31)
}
else if(true && (formDetails?.companyProfiles)) {
printHtmlPart(32)
}
printHtmlPart(33)
expressionOut.print(fee)
printHtmlPart(34)
if(true && (formDetails?.category?.category == FormCategory?.Category?.Form_1)) {
printHtmlPart(35)
}
printHtmlPart(36)
if(true && (formDetails?.biologicalResources)) {
printHtmlPart(37)
loop:{
int b = 0
for( bioRes in (formDetails?.biologicalResources) ) {
printHtmlPart(38)
expressionOut.print(b+1)
printHtmlPart(39)
expressionOut.print(bioRes?.nature ?: 'NA')
printHtmlPart(39)
expressionOut.print(bioRes?.name ?: 'NA')
printHtmlPart(39)
expressionOut.print(bioRes?.commonName ?: 'NA')
printHtmlPart(40)
expressionOut.print(bioRes?.scientificName ?: 'NA')
printHtmlPart(41)
if(true && (formDetails?.category?.category == FormCategory?.Category?.Form_1)) {
printHtmlPart(42)
expressionOut.print(bioRes?.quantity?: 'NA')
printHtmlPart(43)
expressionOut.print(bioRes?.qtyUnit?: 'NA')
printHtmlPart(41)
}
printHtmlPart(44)
b++
}
}
printHtmlPart(45)
}
printHtmlPart(46)
if(true && (formDetails?.biologicalResources?.locations)) {
printHtmlPart(37)
loop:{
int p = 0
for( bioRes in (formDetails?.biologicalResources?.locations) ) {
printHtmlPart(47)
loop:{
int o = 0
for( gioloc in (bioRes) ) {
printHtmlPart(48)
expressionOut.print(p+o+1)
printHtmlPart(39)
expressionOut.print(gioloc?.bioResource?.scientificName?:'NA')
printHtmlPart(39)
expressionOut.print(gioloc?.source?:'NA')
printHtmlPart(49)
if(true && (gioloc?.source == 'Wild' || 'Cultivated' == gioloc?.source)) {
printHtmlPart(42)
expressionOut.print(gioloc?.village ?: 'NA')
printHtmlPart(50)
expressionOut.print(gioloc?.town ?: 'NA')
printHtmlPart(50)
expressionOut.print(gioloc?.district ?: 'NA')
printHtmlPart(50)
expressionOut.print(gioloc?.state ?: 'NA')
printHtmlPart(51)
}
else {
printHtmlPart(52)
expressionOut.print(gioloc?.traderName?:'NA')
printHtmlPart(53)
expressionOut.print(gioloc?.traderContactDetails?:'NA')
printHtmlPart(54)
}
printHtmlPart(55)
o++
}
}
printHtmlPart(45)
p++
}
}
printHtmlPart(45)
}
printHtmlPart(56)
expressionOut.print(agendaInstance?.sbbbmc)
printHtmlPart(57)
expressionOut.print(agendaInstance?.recommendationSbb)
printHtmlPart(58)
if(true && (formDetails?.category?.category == FormCategory?.Category?.Form_1)) {
printHtmlPart(59)
invokeTag('textArea','g',297,['name':("thirdpartyPurpose"),'value':(techChecklist?.assoKnowledgeRmk)],-1)
printHtmlPart(60)
}
else if(true && (formDetails?.category?.category == FormCategory?.Category?.Form_2)) {
printHtmlPart(60)
invokeTag('textArea','g',301,['name':("thirdpartyPurpose"),'value':("Transfer of Research Results")],-1)
printHtmlPart(60)
}
else if(true && (formDetails?.category?.category == FormCategory?.Category?.Form_3)) {
printHtmlPart(61)
invokeTag('textArea','g',305,['name':("thirdpartyPurpose"),'value':("Intellectual Property Rights (IPR)")],-1)
printHtmlPart(60)
}
else if(true && (formDetails?.category?.category == FormCategory?.Category?.Form_4)) {
printHtmlPart(61)
invokeTag('textArea','g',309,['name':("thirdpartyPurpose"),'value':("Third Party Transfer")],-1)
printHtmlPart(60)
}
printHtmlPart(62)
if(true && (formDetails?.approvalOfNba == true)) {
printHtmlPart(63)
}
else {
printHtmlPart(64)
}
printHtmlPart(65)
expressionOut.print(agendaInstance?.receiptTimeTaken)
printHtmlPart(66)
expressionOut.print(agendaInstance?.inordinateDelay)
printHtmlPart(67)
expressionOut.print(agendaInstance?.whetherListNTC)
printHtmlPart(68)
expressionOut.print(agendaInstance?.alreadyExpEC)
printHtmlPart(69)
expressionOut.print(agendaInstance?.actiontaken)
printHtmlPart(70)
expressionOut.print(agendaInstance?.remarkByNba)
printHtmlPart(71)
if(true && (agendaInstance?.recommendationByNba)) {
printHtmlPart(72)
expressionOut.print(agendaInstance?.recommendationByNba)
printHtmlPart(73)
}
printHtmlPart(74)
if(true && (agendaInstance?.signature)) {
printHtmlPart(75)
for( sign in (agendaInstance?.signature) ) {
printHtmlPart(76)
expressionOut.print(sign?.agendaActionBy)
printHtmlPart(77)
expressionOut.print(sign?.agendaAction)
printHtmlPart(78)
expressionOut.print(sign?.agendaActionRole)
printHtmlPart(79)
invokeTag('formatDate','g',415,['format':("dd/MM/yyyy hh:mm aa"),'date':(sign?.agendaActionDate)],-1)
printHtmlPart(80)
}
printHtmlPart(81)
}
printHtmlPart(0)
})
invokeTag('captureBody','sitemesh',421,[:],1)
printHtmlPart(82)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1648429864624L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
