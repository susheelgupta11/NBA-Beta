
import org.nba.common.State


import org.nba.application.FormCategory

import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_NBA_rightPane_matchdata_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/rightPane/_matchdata.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(1)
if(true && (formDetails?.category?.category == FormCategory.Category.Form_1)) {
printHtmlPart(2)
}
printHtmlPart(3)
if(true && (formDetails?.category?.category == FormCategory.Category.Form_2)) {
printHtmlPart(4)
}
printHtmlPart(3)
if(true && (formDetails?.category?.category == FormCategory.Category.Form_3)) {
printHtmlPart(5)
}
printHtmlPart(3)
if(true && (formDetails?.category?.category == FormCategory.Category.Form_4)) {
printHtmlPart(6)
}
printHtmlPart(3)
if(true && (formDetails?.category?.category == FormCategory.Category.Form_B)) {
printHtmlPart(7)
}
printHtmlPart(8)
if(true && (formDetails?.category?.category == FormCategory.Category.Form_1)) {
printHtmlPart(9)
}
else if(true && (formDetails?.category?.category == FormCategory.Category.Form_2)) {
printHtmlPart(10)
}
else if(true && (formDetails?.category?.category == FormCategory.Category.Form_3)) {
printHtmlPart(11)
}
else if(true && (formDetails?.category?.category == FormCategory.Category.Form_4)) {
printHtmlPart(12)
}
else if(true && (formDetails?.category?.category == FormCategory.Category.Form_B)) {
printHtmlPart(13)
}
else if(true && (formDetails?.category?.category == FormCategory.Category.Form_C)) {
printHtmlPart(14)
}
printHtmlPart(15)
expressionOut.print(formDetails?.submittedOn)
printHtmlPart(16)
expressionOut.print(formDetails?.appNumber)
printHtmlPart(17)
if(true && (formDetails?.individualProfiles)) {
printHtmlPart(18)
}
else if(true && (formDetails?.companyProfiles)) {
printHtmlPart(19)
}
else if(true && (formDetails?.depostionOfMicroOrganism)) {
printHtmlPart(20)
}
else if(true && (formDetails?.govtInstitutes)) {
printHtmlPart(21)
}
else if(true && (formDetails?.indianResearcher)) {
printHtmlPart(22)
}
printHtmlPart(23)
if(true && (formDetails?.category?.category == FormCategory.Category.Form_1 && allDataforMatching?.individualDetailsForMatch?.size()>0)) {
printHtmlPart(24)
invokeTag('render','g',184,['template':("/rightPane/form1ForMatchingData")],-1)
printHtmlPart(3)
}
else if(true && (formDetails?.category?.category == FormCategory.Category.Form_1 && allDataforMatching?.companyDetailsForMatch?.size()>0)) {
printHtmlPart(25)
invokeTag('render','g',189,['template':("/rightPane/form1ForMatchingData")],-1)
printHtmlPart(3)
}
else if(true && (formDetails?.category?.category == FormCategory.Category.Form_2 && allDataforMatching?.individualDetailsForMatch?.size()>0)) {
printHtmlPart(26)
invokeTag('render','g',194,['template':("/rightPane/form2ForMatchingData")],-1)
printHtmlPart(3)
}
else if(true && (formDetails?.category?.category == FormCategory.Category.Form_2 && allDataforMatching?.companyDetailsForMatch?.size()>0)) {
printHtmlPart(27)
invokeTag('render','g',199,['template':("/rightPane/form2ForMatchingData")],-1)
printHtmlPart(3)
}
else if(true && (formDetails?.category?.category == FormCategory.Category.Form_3 && allDataforMatching?.individualDetailsForMatch?.size()>0)) {
printHtmlPart(27)
invokeTag('render','g',204,['template':("/rightPane/form3ForMatchingData")],-1)
printHtmlPart(3)
}
else if(true && (formDetails?.category?.category == FormCategory.Category.Form_3 && allDataforMatching?.companyDetailsForMatch?.size()>0)) {
printHtmlPart(27)
invokeTag('render','g',209,['template':("/rightPane/form3ForMatchingData")],-1)
printHtmlPart(3)
}
else if(true && (formDetails?.category?.category == FormCategory.Category.Form_4 && allDataforMatching?.individualDetailsForMatch?.size()>0)) {
printHtmlPart(27)
invokeTag('render','g',214,['template':("/rightPane/form4ForMatchingData")],-1)
printHtmlPart(3)
}
else if(true && (formDetails?.category?.category == FormCategory.Category.Form_4 && allDataforMatching?.companyDetailsForMatch?.size()>0)) {
printHtmlPart(27)
invokeTag('render','g',219,['template':("/rightPane/form4ForMatchingData")],-1)
printHtmlPart(3)
}
else if(true && (formDetails?.category?.category == FormCategory.Category.Form_B && allDataforMatching?.listOfIndianResearcher?.size() >0)) {
printHtmlPart(27)
invokeTag('render','g',224,['template':("/rightPane/formBForMatchingData")],-1)
printHtmlPart(3)
}
else if(true && (formDetails?.category?.category == FormCategory.Category.Form_B && allDataforMatching?.listOfIndianGovtInst?.size() >0)) {
printHtmlPart(26)
invokeTag('render','g',230,['template':("/rightPane/formBForMatchingData")],-1)
printHtmlPart(3)
}
else if(true && (formDetails?.category?.category == FormCategory.Category.Form_C && allDataforMatching?.depostionOfMicroOrganism?.size()>0)) {
printHtmlPart(27)
invokeTag('render','g',236,['template':("/rightPane/formCForMatchingData")],-1)
printHtmlPart(3)
}
printHtmlPart(28)
if(true && (formDetails?.category?.category == FormCategory.Category.Form_1)) {
printHtmlPart(2)
}
printHtmlPart(3)
if(true && (formDetails?.category?.category == FormCategory.Category.Form_2)) {
printHtmlPart(4)
}
printHtmlPart(3)
if(true && (formDetails?.category?.category == FormCategory.Category.Form_3)) {
printHtmlPart(5)
}
printHtmlPart(3)
if(true && (formDetails?.category?.category == FormCategory.Category.Form_4)) {
printHtmlPart(6)
}
printHtmlPart(3)
if(true && (formDetails?.category?.category == FormCategory.Category.Form_B)) {
printHtmlPart(7)
}
printHtmlPart(29)
if(true && (formDetails?.category?.category == FormCategory.Category.Form_1)) {
printHtmlPart(9)
}
else if(true && (formDetails?.category?.category == FormCategory.Category.Form_2)) {
printHtmlPart(10)
}
else if(true && (formDetails?.category?.category == FormCategory.Category.Form_3)) {
printHtmlPart(11)
}
else if(true && (formDetails?.category?.category == FormCategory.Category.Form_4)) {
printHtmlPart(12)
}
else if(true && (formDetails?.category?.category == FormCategory.Category.Form_B)) {
printHtmlPart(30)
}
else if(true && (formDetails?.category?.category == FormCategory.Category.Form_C)) {
printHtmlPart(14)
}
printHtmlPart(15)
expressionOut.print(formDetails?.submittedOn)
printHtmlPart(16)
expressionOut.print(formDetails?.appNumber)
printHtmlPart(31)

int counter = 0

printHtmlPart(3)
if(true && (allDataforMatching?.addNoteList)) {
printHtmlPart(3)
loop:{
int i = 0
for( noteVar in (allDataforMatching?.addNoteList) ) {
printHtmlPart(24)
if(true && (noteVar.pdfFiles)) {
printHtmlPart(32)
loop:{
int j = 0
for( pdfFle in (noteVar.pdfFiles) ) {
printHtmlPart(33)
expressionOut.print(counter = counter+1)
printHtmlPart(34)
if(true && (pdfFle?.uploadingDate)) {
printHtmlPart(35)
invokeTag('formatDate','g',347,['format':("dd/MM/yyyy"),'date':(pdfFle?.uploadingDate)],-1)
printHtmlPart(36)
}
else {
printHtmlPart(37)
}
printHtmlPart(38)
expressionOut.print(pdfFle?.fileName?:'NA')
printHtmlPart(39)
createClosureForHtmlPart(40, 5)
invokeTag('link','g',359,['controller':("dashboard"),'action':("notingFileShow"),'target':("_blank"),'params':([showId:pdfFle?.id,csrfPreventionSalt:csrfPreventionSalt])],5)
printHtmlPart(41)
j++
}
}
printHtmlPart(24)
}
printHtmlPart(3)
i++
}
}
printHtmlPart(3)
}
printHtmlPart(42)
if(true && (formDetails?.agendas)) {
printHtmlPart(43)
for( dynamic in (formDetails?.agendas) ) {
printHtmlPart(44)
if(true && (dynamic?.agendaPdfName || dynamic?.agendaPdfUrl)) {
printHtmlPart(45)
expressionOut.print(counter = counter+1)
printHtmlPart(46)
invokeTag('formatDate','g',370,['format':("dd-MM-yyyy"),'date':(dynamic?.sendDate)],-1)
printHtmlPart(47)
expressionOut.print(dynamic?.agendaPdfName)
printHtmlPart(48)
createClosureForHtmlPart(40, 4)
invokeTag('link','g',381,['controller':("Agenda"),'action':("dynamicAgendaShowPdf"),'target':("_blank"),'params':([dynamicId:dynamic?.id,csrfPreventionSalt:csrfPreventionSalt])],4)
printHtmlPart(49)
}
printHtmlPart(50)
}
printHtmlPart(51)
}
printHtmlPart(52)
if(true && (formDetails?.manualUploads)) {
printHtmlPart(53)
for( dynamic in (formDetails?.manualUploads) ) {
printHtmlPart(44)
if(true && (dynamic?.fileName || dynamic?.fileUrl)) {
printHtmlPart(45)
expressionOut.print(counter = counter+1)
printHtmlPart(46)
expressionOut.print(dynamic?.date)
printHtmlPart(54)
expressionOut.print(dynamic?.fileName)
printHtmlPart(48)
createClosureForHtmlPart(40, 4)
invokeTag('link','g',402,['controller':("manualUpload"),'action':("manualDocShow"),'target':("_blank"),'params':([dynamicId:dynamic?.id,csrfPreventionSalt:csrfPreventionSalt])],4)
printHtmlPart(49)
}
else if(true && (dynamic?.dyName || dynamic?.dyUrl)) {
printHtmlPart(45)
expressionOut.print(counter = counter+1)
printHtmlPart(46)
expressionOut.print(dynamic?.letterDate)
printHtmlPart(54)
expressionOut.print(dynamic?.dyName)
printHtmlPart(48)
createClosureForHtmlPart(40, 4)
invokeTag('link','g',420,['controller':("manualUpload"),'action':("manualDocShow"),'target':("_blank"),'params':([dynamicId:dynamic?.id,csrfPreventionSalt:csrfPreventionSalt])],4)
printHtmlPart(49)
}
printHtmlPart(50)
}
printHtmlPart(51)
}
printHtmlPart(55)
if(true && (formDetails?.letterCommunications)) {
printHtmlPart(53)
for( dynamic in (formDetails?.letterCommunications) ) {
printHtmlPart(56)
if(true && (dynamic?.bodyPdfName || dynamic?.bodyPdfUrl)) {
printHtmlPart(57)
expressionOut.print(counter = counter+1)
printHtmlPart(58)
invokeTag('formatDate','g',435,['format':("dd-MM-yyyy"),'date':(dynamic?.approvedDate)],-1)
printHtmlPart(59)
expressionOut.print(dynamic?.bodyPdfName)
printHtmlPart(60)
createClosureForHtmlPart(40, 4)
invokeTag('link','g',444,['controller':("letterCommunication"),'action':("dynamicShowPdf"),'target':("_blank"),'params':([dynamicId:dynamic?.id,csrfPreventionSalt:csrfPreventionSalt])],4)
printHtmlPart(61)
}
printHtmlPart(62)
}
printHtmlPart(62)
}
printHtmlPart(63)
if(true && (formDetails?.clientLetters)) {
printHtmlPart(62)
for( replyConsent in (formDetails?.clientLetters) ) {
printHtmlPart(64)
if(true && (replyConsent?.pdfFileAttachments)) {
printHtmlPart(32)
loop:{
int n = 0
for( pdfFle in (replyConsent?.pdfFileAttachments) ) {
printHtmlPart(33)
expressionOut.print(counter = counter+1)
printHtmlPart(34)
if(true && (pdfFle?.attachedDate)) {
printHtmlPart(35)
invokeTag('formatDate','g',458,['format':("dd-MM-yyyy"),'date':(pdfFle?.attachedDate)],-1)
printHtmlPart(36)
}
else {
printHtmlPart(37)
}
printHtmlPart(38)
expressionOut.print(pdfFle?.pdfName?:'NA')
printHtmlPart(65)
createClosureForHtmlPart(40, 5)
invokeTag('link','g',470,['controller':("letterCommunication"),'action':("communicationFileShow"),'target':("_blank"),'params':([showId:pdfFle?.id,csrfPreventionSalt:csrfPreventionSalt])],5)
printHtmlPart(41)
n++
}
}
printHtmlPart(24)
}
printHtmlPart(62)
}
printHtmlPart(62)
}
printHtmlPart(66)
if(true && (allDataforMatching?.communicationList)) {
printHtmlPart(3)
loop:{
int l = 0
for( commuVar in (allDataforMatching?.communicationList) ) {
printHtmlPart(24)
if(true && (commuVar?.pdfFileAttachments)) {
printHtmlPart(32)
loop:{
int n = 0
for( pdfFle in (commuVar?.pdfFileAttachments) ) {
printHtmlPart(33)
expressionOut.print(counter = counter+1)
printHtmlPart(34)
if(true && (pdfFle?.attachedDate)) {
printHtmlPart(35)
invokeTag('formatDate','g',491,['format':("dd-MM-yyyy"),'date':(pdfFle?.attachedDate)],-1)
printHtmlPart(36)
}
else {
printHtmlPart(37)
}
printHtmlPart(38)
expressionOut.print(pdfFle?.pdfName?:'NA')
printHtmlPart(67)
createClosureForHtmlPart(40, 5)
invokeTag('link','g',501,['controller':("letterCommunication"),'action':("communicationFileShow"),'target':("_blank"),'params':([showId:pdfFle?.id,csrfPreventionSalt:csrfPreventionSalt])],5)
printHtmlPart(41)
n++
}
}
printHtmlPart(24)
}
printHtmlPart(3)
l++
}
}
printHtmlPart(68)
}
printHtmlPart(69)
if(true && (formDetails?.periodicreports)) {
printHtmlPart(70)
for( periodicPdf in (formDetails?.periodicreports) ) {
printHtmlPart(71)
if(true && (periodicPdf?.periodicFiles)) {
printHtmlPart(72)
for( peri in (periodicPdf?.periodicFiles) ) {
printHtmlPart(73)
expressionOut.print(counter = counter+1)
printHtmlPart(74)
invokeTag('formatDate','g',522,['format':("dd-MM-yyyy"),'date':(peri?.fileDate)],-1)
printHtmlPart(75)
expressionOut.print(peri?.fileName)
printHtmlPart(76)
createClosureForHtmlPart(40, 5)
invokeTag('link','g',534,['controller':("Applicant"),'action':("showPublishPdf"),'target':("_blank"),'params':([publishId:peri?.id,csrfPreventionSalt:csrfPreventionSalt])],5)
printHtmlPart(77)
}
printHtmlPart(78)
}
printHtmlPart(79)
}
printHtmlPart(70)
}
printHtmlPart(80)
if(true && (formDetails?.periodicreports)) {
printHtmlPart(81)
for( dyPdf in (formDetails?.periodicreports) ) {
printHtmlPart(81)
if(true && (dyPdf?.dyFileName || dyPdf?.dyFileURL)) {
printHtmlPart(82)
expressionOut.print(counter = counter+1)
printHtmlPart(74)
invokeTag('formatDate','g',545,['format':("dd-MM-yyyy"),'date':(dyPdf?.generateDate)],-1)
printHtmlPart(75)
expressionOut.print(dyPdf?.dyFileName)
printHtmlPart(76)
createClosureForHtmlPart(40, 4)
invokeTag('link','g',554,['controller':("Applicant"),'action':("showPeriodicDynamicPdf"),'target':("_blank"),'params':([showId:dyPdf?.id,csrfPreventionSalt:csrfPreventionSalt])],4)
printHtmlPart(83)
}
printHtmlPart(84)
}
printHtmlPart(81)
}
printHtmlPart(85)
if(true && (formDetails?.category?.category == FormCategory.Category.Form_1)) {
printHtmlPart(9)
}
else if(true && (formDetails?.category?.category == FormCategory.Category.Form_2)) {
printHtmlPart(10)
}
else if(true && (formDetails?.category?.category == FormCategory.Category.Form_3)) {
printHtmlPart(11)
}
else if(true && (formDetails?.category?.category == FormCategory.Category.Form_4)) {
printHtmlPart(12)
}
else if(true && (formDetails?.category?.category == FormCategory.Category.Form_B)) {
printHtmlPart(30)
}
else if(true && (formDetails?.category?.category == FormCategory.Category.Form_C)) {
printHtmlPart(14)
}
printHtmlPart(15)
expressionOut.print(formDetails?.submittedOn)
printHtmlPart(16)
expressionOut.print(formDetails?.appNumber)
printHtmlPart(86)
loop:{
int p = 0
for( kmsd in (dropDnValues?.kmsDetails) ) {
printHtmlPart(87)
expressionOut.print(p+1)
printHtmlPart(88)
expressionOut.print(kmsd?.fileName)
printHtmlPart(88)
createClosureForHtmlPart(89, 2)
invokeTag('link','g',633,['action':("showKMS"),'controller':("setMstrData"),'params':([editId:kmsd?.id])],2)
printHtmlPart(90)
p++
}
}
printHtmlPart(91)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1667546268084L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
