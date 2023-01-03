
import org.nba.application.FormCategory

import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_NBA_agenda_formAgenda_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/agenda/_formAgenda.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
if(true && (formDetails?.individualProfiles)) {
printHtmlPart(1)
for( individualProfile in (formDetails?.individualProfiles) ) {
printHtmlPart(2)
invokeTag('set','g',6,['var':("name"),'value':("${individualProfile?.title ?:''} ${individualProfile?.firstName ?:''} ${individualProfile?.middleName?: ''} ${individualProfile?.lastName ?:''}")],-1)
printHtmlPart(3)
invokeTag('set','g',7,['value':("${individualProfile?.address1 ?:''} ${individualProfile?.address2 ?:''} ${individualProfile?.address3 ?:''} ${individualProfile?.city ?:''}"),'var':("address")],-1)
printHtmlPart(4)
}
printHtmlPart(5)
}
else if(true && (formDetails?.companyProfiles)) {
printHtmlPart(1)
loop:{
int k = 0
for( company in (formDetails?.companyProfiles) ) {
printHtmlPart(1)
invokeTag('set','g',12,['var':("name"),'value':("	${company?.entityName?:''}")],-1)
printHtmlPart(1)
invokeTag('set','g',13,['value':("${company?.address1 ?:''} ${company?.address2 ?:''} ${company?.address3 ?:''} ${company?.city ?:''}"),'var':("address")],-1)
printHtmlPart(6)
k++
}
}
printHtmlPart(5)
}
else if(true && (formDetails?.indianResearcher)) {
printHtmlPart(1)
for( researcher in (formDetails?.indianResearcher) ) {
printHtmlPart(7)
invokeTag('set','g',22,['var':("name"),'value':("""	${researcher?.title?:''}
					${researcher?.firstName?:''}
					${researcher?.middleName?: ''}
					${researcher?.lastName?: ''}""")],-1)
printHtmlPart(8)
invokeTag('set','g',27,['value':("""${researcher?.address1?:''}
					${researcher?.address2?:''}
					${researcher?.address3?:''}
					${researcher?.presentCity?:''}"""),'var':("address")],-1)
printHtmlPart(9)
}
printHtmlPart(5)
}
else if(true && (formDetails?.depostionOfMicroOrganism)) {
printHtmlPart(1)
for( depost in (formDetails?.depostionOfMicroOrganism) ) {
printHtmlPart(1)
invokeTag('set','g',32,['var':("name"),'value':("	${depost?.nameOfDepositor?:''}")],-1)
printHtmlPart(10)
invokeTag('set','g',36,['value':("""${depost?.address1?:''}
					${depost?.address2?:''}
					${depost?.address3?:''}
					${depost?.city?:''}"""),'var':("address")],-1)
printHtmlPart(11)
}
printHtmlPart(5)
}
else if(true && (formDetails?.indianGovtInst)) {
printHtmlPart(1)
for( govt in (formDetails?.indianGovtInst) ) {
printHtmlPart(1)
invokeTag('set','g',40,['var':("name"),'value':("	${govt?.govtInstName?:''}")],-1)
printHtmlPart(12)
invokeTag('set','g',45,['value':("""${govt?.address1?:''}
					${govt?.address2?:''}
					${govt?.address3?:''}
					${govt?.presentCity?:''}"""),'var':("address")],-1)
printHtmlPart(1)
}
printHtmlPart(5)
}
printHtmlPart(13)
invokeTag('hiddenField','g',49,['name':("name"),'value':(name)],-1)
printHtmlPart(5)
invokeTag('hiddenField','g',50,['name':("address"),'value':(address)],-1)
printHtmlPart(14)
if(true && (agendaInstance?.recommendationByNba)) {
printHtmlPart(15)
createClosureForHtmlPart(16, 2)
invokeTag('javascript','g',59,[:],2)
printHtmlPart(17)
}
printHtmlPart(18)
if(true && (agendaInstance)) {
printHtmlPart(19)
expressionOut.print(agendaInstance?.meetingName)
printHtmlPart(19)
}
else {
printHtmlPart(20)
invokeTag('select','g',70,['name':("meetingName"),'from':(meetingName),'noSelection':(['':'Choose a Meeting']),'onchange':("recomSts(this.value);"),'required':("required")],-1)
printHtmlPart(19)
}
printHtmlPart(21)
if(true && (agendaInstance)) {
printHtmlPart(19)
expressionOut.print(agendaInstance?.meetingNum)
printHtmlPart(19)
}
else {
printHtmlPart(22)
expressionOut.print(agendaInstance?.meetingNum)
printHtmlPart(23)
}
printHtmlPart(24)
if(true && (agendaInstance)) {
printHtmlPart(25)
expressionOut.print(agendaInstance?.fromDate)
printHtmlPart(26)
expressionOut.print(agendaInstance?.toDate)
printHtmlPart(19)
}
else {
printHtmlPart(27)
expressionOut.print(agendaInstance?.fromDate)
printHtmlPart(28)
expressionOut.print(agendaInstance?.toDate)
printHtmlPart(29)
}
printHtmlPart(30)
expressionOut.print(agendaInstance?.dynamicMeetNum)
printHtmlPart(31)
expressionOut.print(formDetails?.appNumber)
printHtmlPart(32)
invokeTag('textField','g',134,['name':("refNo"),'value':(techChecklist?.nbaRefNumber)],-1)
printHtmlPart(33)
invokeTag('textArea','g',141,['name':("nameAndAddress"),'value':("${name} ${address}"),'cols':("30")],-1)
printHtmlPart(34)
if(true && (formDetails?.category?.category == FormCategory?.Category?.Form_1)) {
printHtmlPart(35)
invokeTag('textField','g',151,['name':("formType"),'value':("Form I")],-1)
printHtmlPart(36)
invokeTag('set','g',152,['value':("10,000 /-"),'var':("fee")],-1)
printHtmlPart(36)
}
else if(true && (formDetails?.category?.category == FormCategory?.Category?.Form_2)) {
printHtmlPart(37)
invokeTag('textField','g',155,['name':("formType"),'value':("Form II")],-1)
printHtmlPart(37)
invokeTag('set','g',156,['value':("5,000 /-"),'var':("fee")],-1)
printHtmlPart(37)
}
else if(true && (formDetails?.category?.category == FormCategory?.Category?.Form_3)) {
printHtmlPart(37)
invokeTag('textField','g',160,['name':("formType"),'value':("Form III")],-1)
printHtmlPart(37)
invokeTag('set','g',161,['value':("500 /-"),'var':("fee")],-1)
printHtmlPart(37)
}
else if(true && (formDetails?.category?.category == FormCategory?.Category?.Form_4)) {
printHtmlPart(37)
invokeTag('textField','g',164,['name':("formType"),'value':("Form IV")],-1)
printHtmlPart(37)
invokeTag('set','g',165,['value':("10,000 /-"),'var':("fee")],-1)
printHtmlPart(37)
}
else if(true && (formDetails?.category?.category == FormCategory?.Category?.Form_B)) {
printHtmlPart(37)
invokeTag('textField','g',168,['name':("formType"),'value':("Form B")],-1)
printHtmlPart(37)
}
printHtmlPart(38)
if(true && (legalChecklist?.orderChk == 'true')) {
printHtmlPart(39)
invokeTag('set','g',180,['value':("Yes"),'var':("pre")],-1)
printHtmlPart(39)
}
else if(true && (legalChecklist?.orderChk == 'needAditionalInfo')) {
printHtmlPart(39)
invokeTag('set','g',183,['value':("Need Additional Info"),'var':("pre")],-1)
printHtmlPart(39)
}
else {
printHtmlPart(39)
invokeTag('set','g',186,['value':("No"),'var':("pre")],-1)
printHtmlPart(39)
}
printHtmlPart(39)
invokeTag('textField','g',188,['name':("prescribedApplication"),'value':(pre)],-1)
printHtmlPart(40)
if(true && (techChecklist?.technicalInformation == true)) {
printHtmlPart(37)
invokeTag('set','g',198,['value':("Yes"),'var':("wherter")],-1)
printHtmlPart(37)
}
else {
invokeTag('set','g',200,['value':("No"),'var':("wherter")],-1)
}
printHtmlPart(41)
expressionOut.print(wherter)
printHtmlPart(42)
if(true && (legalChecklist?.threeTwocheck == true)) {
printHtmlPart(39)
invokeTag('textField','g',212,['name':("individualOrEntity"),'value':("Yes")],-1)
printHtmlPart(39)
}
else if(true && (legalChecklist?.threeTwocheck == false)) {
printHtmlPart(39)
invokeTag('textField','g',215,['name':("individualOrEntity"),'value':("No")],-1)
printHtmlPart(39)
}
else {
printHtmlPart(39)
invokeTag('textField','g',218,['name':("individualOrEntity"),'value':("NA")],-1)
printHtmlPart(39)
}
printHtmlPart(43)
invokeTag('textField','g',229,['name':("applicationFee"),'value':(fee)],-1)
printHtmlPart(44)
if(true && (formDetails?.category?.category == FormCategory?.Category?.Form_1)) {
printHtmlPart(45)
}
printHtmlPart(46)
if(true && (formDetails?.biologicalResources)) {
printHtmlPart(39)
loop:{
int b = 0
for( bioRes in (formDetails?.biologicalResources) ) {
printHtmlPart(47)
expressionOut.print(b+1)
printHtmlPart(48)
expressionOut.print(bioRes?.nature ?: 'NA')
printHtmlPart(49)
expressionOut.print(bioRes?.commonName ?: 'NA')
printHtmlPart(48)
expressionOut.print(bioRes?.scientificName ?: 'NA')
printHtmlPart(48)
expressionOut.print(bioRes?.biologicalResource?: 'NA')
printHtmlPart(50)
if(true && (formDetails?.category?.category == FormCategory?.Category?.Form_1)) {
printHtmlPart(51)
expressionOut.print(bioRes?.quantity?: 'NA')
printHtmlPart(52)
expressionOut.print(bioRes?.qtyUnit?: 'NA')
printHtmlPart(53)
}
printHtmlPart(54)
b++
}
}
printHtmlPart(55)
}
printHtmlPart(56)
if(true && (formDetails?.biologicalResources?.locations)) {
printHtmlPart(39)
loop:{
int p = 0
for( bioRes in (formDetails?.biologicalResources?.locations) ) {
printHtmlPart(57)
loop:{
int o = 0
for( gioloc in (bioRes) ) {
printHtmlPart(58)
expressionOut.print(p+o+1)
printHtmlPart(48)
expressionOut.print(gioloc?.bioResource?.scientificName?:'NA')
printHtmlPart(48)
expressionOut.print(gioloc?.source?:'NA')
printHtmlPart(59)
if(true && (gioloc?.source == 'Wild' || 'Cultivated' == gioloc?.source)) {
printHtmlPart(51)
expressionOut.print(gioloc?.village ?: 'NA')
printHtmlPart(60)
expressionOut.print(gioloc?.town ?: 'NA')
printHtmlPart(60)
expressionOut.print(gioloc?.district ?: 'NA')
printHtmlPart(60)
expressionOut.print(gioloc?.state ?: 'NA')
printHtmlPart(50)
}
else {
printHtmlPart(61)
expressionOut.print(gioloc?.traderName?:'NA')
printHtmlPart(62)
expressionOut.print(gioloc?.traderContactDetails?:'NA')
printHtmlPart(63)
}
printHtmlPart(54)
o++
}
}
printHtmlPart(55)
p++
}
}
printHtmlPart(55)
}
printHtmlPart(64)
if(true && (techChecklist?.sbbBmc == true)) {
printHtmlPart(39)
invokeTag('set','g',314,['value':("Yes"),'var':("sbb")],-1)
printHtmlPart(39)
}
else {
printHtmlPart(39)
invokeTag('set','g',317,['value':("No"),'var':("sbb")],-1)
printHtmlPart(39)
}
printHtmlPart(39)
invokeTag('textField','g',320,['name':("sbbbmc"),'value':(sbb),'style':("width:100%")],-1)
printHtmlPart(65)
invokeTag('textArea','g',329,['name':("recommendationSbb"),'value':(agendaInstance?.recommendationSbb),'style':("width:100%")],-1)
printHtmlPart(66)
if(true && (formDetails?.category?.category == FormCategory?.Category?.Form_1)) {
printHtmlPart(67)
invokeTag('textArea','g',344,['name':("thirdpartyPurpose"),'value':(techChecklist?.assoKnowledgeRmk),'style':("width:100%")],-1)
printHtmlPart(68)
}
else if(true && (formDetails?.category?.category == FormCategory?.Category?.Form_2)) {
printHtmlPart(68)
invokeTag('textArea','g',348,['name':("thirdpartyPurpose"),'value':("Transfer of Research Results"),'style':("width:100%")],-1)
printHtmlPart(68)
}
else if(true && (formDetails?.category?.category == FormCategory?.Category?.Form_3)) {
printHtmlPart(69)
invokeTag('textArea','g',352,['name':("thirdpartyPurpose"),'value':("Intellectual Property Rights (IPR)"),'style':("width:100%")],-1)
printHtmlPart(68)
}
else if(true && (formDetails?.category?.category == FormCategory?.Category?.Form_4)) {
printHtmlPart(69)
invokeTag('textArea','g',356,['name':("thirdpartyPurpose"),'value':("Third Party Transfer"),'style':("width:100%")],-1)
printHtmlPart(68)
}
printHtmlPart(70)
invokeTag('textField','g',368,['name':("approvalNBA"),'style':("width:100%"),'value':(agendaInstance?.approvalNBA)],-1)
printHtmlPart(71)
invokeTag('textField','g',378,['name':("receiptTimeTaken"),'style':("width:100%"),'value':(agendaInstance?.receiptTimeTaken)],-1)
printHtmlPart(72)
invokeTag('textField','g',388,['name':("inordinateDelay"),'style':("width:100%"),'value':(agendaInstance?.inordinateDelay)],-1)
printHtmlPart(73)
if(true && (rare)) {
printHtmlPart(1)
loop:{
int i = 0
for( ntc in (rare) ) {
printHtmlPart(74)
expressionOut.print(i+1)
printHtmlPart(75)
expressionOut.print(ntc?.bio_resource)
printHtmlPart(75)
expressionOut.print(ntc?.status)
printHtmlPart(76)
i++
}
}
printHtmlPart(1)
}
else {
printHtmlPart(77)
}
printHtmlPart(78)
invokeTag('textField','g',434,['name':("alreadyExpEC"),'style':("width:100%"),'value':(agendaInstance?.alreadyExpEC)],-1)
printHtmlPart(79)
invokeTag('textField','g',444,['name':("actiontaken"),'style':("width:100%"),'value':(agendaInstance?.actiontaken)],-1)
printHtmlPart(80)
expressionOut.print(agendaInstance?.remarkByNba)
printHtmlPart(81)
expressionOut.print(agendaInstance?.recommendationByNba)
printHtmlPart(82)
if(true && (agendaInstance?.signature)) {
printHtmlPart(83)
for( sign in (agendaInstance?.signature) ) {
printHtmlPart(84)
expressionOut.print(sign?.agendaActionBy)
printHtmlPart(85)
expressionOut.print(sign?.agendaAction)
printHtmlPart(86)
expressionOut.print(sign?.agendaActionRole)
printHtmlPart(87)
invokeTag('formatDate','g',495,['format':("dd/MM/yyyy hh:mm aa"),'date':(sign?.agendaActionDate)],-1)
printHtmlPart(88)
}
printHtmlPart(89)
}
printHtmlPart(90)
if(true && (agendaInstance)) {
printHtmlPart(91)
createClosureForHtmlPart(92, 2)
invokeTag('link','g',508,['controller':("agenda"),'class':("btn btn-success"),'action':("printableAgenda"),'target':("_blank"),'style':("margin: 10px;"),'params':([printId:agendaInstance?.id,formId:formDetails?.id, csrfPreventionSalt:csrfPreventionSalt])],2)
printHtmlPart(93)
}
printHtmlPart(94)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1648697662825L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
