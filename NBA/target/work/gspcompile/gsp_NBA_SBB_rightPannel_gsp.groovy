
import org.nba.common.State


import org.nba.application.FormCategory

import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_NBA_SBB_rightPannel_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/SBB/_rightPannel.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(1)
expressionOut.print(formDetails?.category?.category)
printHtmlPart(2)
if(true && (formDetails?.category?.category == FormCategory.Category.Form_1)) {
printHtmlPart(3)
}
else if(true && (formDetails?.category?.category == FormCategory.Category.Form_2)) {
printHtmlPart(4)
}
else if(true && (formDetails?.category?.category == FormCategory.Category.Form_3)) {
printHtmlPart(5)
}
else if(true && (formDetails?.category?.category == FormCategory.Category.Form_4)) {
printHtmlPart(6)
}
else if(true && (formDetails?.category?.category == FormCategory.Category.Form_B)) {
printHtmlPart(7)
}
else if(true && (formDetails?.category?.category == FormCategory.Category.Form_C)) {
printHtmlPart(8)
}
printHtmlPart(9)
expressionOut.print(submittedDate)
printHtmlPart(10)
expressionOut.print(applicationNum)
printHtmlPart(11)
if(true && (formDetails?.individualProfiles)) {
printHtmlPart(12)
}
else if(true && (formDetails?.companyProfiles)) {
printHtmlPart(13)
}
else if(true && (formDetails?.depostionOfMicroOrganism)) {
printHtmlPart(14)
}
else if(true && (formDetails?.govtInstitutes)) {
printHtmlPart(15)
}
else if(true && (formDetails?.indianResearcher)) {
printHtmlPart(16)
}
printHtmlPart(17)
if(true && (formDetails?.category?.category == FormCategory.Category.Form_1 && allDataforMatching?.individualDetailsForMatch?.size()>0)) {
printHtmlPart(18)
invokeTag('render','g',139,['template':("/dashboard/form1ForMatchingData")],-1)
printHtmlPart(19)
}
else if(true && (formDetails?.category?.category == FormCategory.Category.Form_1 && allDataforMatching?.companyDetailsForMatch?.size()>0)) {
printHtmlPart(20)
invokeTag('render','g',144,['template':("/dashboard/form1ForMatchingData")],-1)
printHtmlPart(19)
}
else if(true && (formDetails?.category?.category == FormCategory.Category.Form_2 && allDataforMatching?.individualDetailsForMatch?.size()>0)) {
printHtmlPart(21)
invokeTag('render','g',149,['template':("/dashboard/form2ForMatchingData")],-1)
printHtmlPart(19)
}
else if(true && (formDetails?.category?.category == FormCategory.Category.Form_2 && allDataforMatching?.companyDetailsForMatch?.size()>0)) {
printHtmlPart(22)
invokeTag('render','g',154,['template':("/dashboard/form2ForMatchingData")],-1)
printHtmlPart(19)
}
else if(true && (formDetails?.category?.category == FormCategory.Category.Form_3 && allDataforMatching?.individualDetailsForMatch?.size()>0)) {
printHtmlPart(22)
invokeTag('render','g',159,['template':("/dashboard/form3ForMatchingData")],-1)
printHtmlPart(19)
}
else if(true && (formDetails?.category?.category == FormCategory.Category.Form_3 && allDataforMatching?.companyDetailsForMatch?.size()>0)) {
printHtmlPart(22)
invokeTag('render','g',164,['template':("/dashboard/form3ForMatchingData")],-1)
printHtmlPart(19)
}
else if(true && (formDetails?.category?.category == FormCategory.Category.Form_4 && allDataforMatching?.individualDetailsForMatch?.size()>0)) {
printHtmlPart(22)
invokeTag('render','g',169,['template':("/dashboard/form4ForMatchingData")],-1)
printHtmlPart(19)
}
else if(true && (formDetails?.category?.category == FormCategory.Category.Form_4 && allDataforMatching?.companyDetailsForMatch?.size()>0)) {
printHtmlPart(22)
invokeTag('render','g',174,['template':("/dashboard/form4ForMatchingData")],-1)
printHtmlPart(19)
}
else if(true && (formDetails?.category?.category == FormCategory.Category.Form_B && allDataforMatching?.indianResearcher?.size() >0)) {
printHtmlPart(22)
invokeTag('render','g',179,['template':("/dashboard/formBForMatchingData")],-1)
printHtmlPart(19)
}
else if(true && (formDetails?.category?.category == FormCategory.Category.Form_B && allDataforMatching?.listOfIndianGovtInst?.size() >0)) {
printHtmlPart(21)
invokeTag('render','g',185,['template':("/dashboard/formBForMatchingData")],-1)
printHtmlPart(19)
}
else if(true && (formDetails?.category?.category == FormCategory.Category.Form_C && allDataforMatching?.depostionOfMicroOrganism?.size()>0)) {
printHtmlPart(22)
invokeTag('render','g',191,['template':("/dashboard/formCForMatchingData")],-1)
printHtmlPart(19)
}
printHtmlPart(23)
invokeTag('render','g',196,['template':("/rightPane/agentProfileMatching")],-1)
printHtmlPart(24)
if(true && (formDetails?.biologicalResources)) {
printHtmlPart(25)
loop:{
int j = 0
for( bioResorce in (formDetails?.biologicalResources) ) {
printHtmlPart(26)
loop:{
int k = 0
for( bioRes in (bioResorce) ) {
printHtmlPart(27)
expressionOut.print(j+1)
printHtmlPart(28)
expressionOut.print(bioRes?.name?:'NA')
printHtmlPart(28)
expressionOut.print(bioRes?.commonName?:'NA')
printHtmlPart(28)
expressionOut.print(bioRes?.scientificName?:'NA')
printHtmlPart(28)
expressionOut.print(bioRes?.nature?:'NA')
printHtmlPart(28)
expressionOut.print(bioRes?.biologicalResource?:'NA')
printHtmlPart(28)
expressionOut.print(bioRes?.quantity?:'NA')
printHtmlPart(29)
expressionOut.print(bioRes?.qtyUnit?:'NA')
printHtmlPart(30)
expressionOut.print(bioRes?.fromTime?: 'NA')
printHtmlPart(31)
expressionOut.print(bioRes?.toTime?:'NA')
printHtmlPart(28)
expressionOut.print(bioRes?.traditionalUse?:'NA')
printHtmlPart(32)
k++
}
}
printHtmlPart(25)
j++
}
}
printHtmlPart(33)
}
printHtmlPart(34)
if(true && (formDetails?.biologicalResources?.locations)) {
printHtmlPart(25)
loop:{
int l = 0
for( giolocation in (formDetails?.biologicalResources?.locations) ) {
printHtmlPart(26)
loop:{
int m = 0
for( gioloct in (giolocation) ) {
printHtmlPart(35)
loop:{
int n = 0
for( gioloc in (gioloct) ) {
printHtmlPart(36)
expressionOut.print(l+1)
printHtmlPart(37)
expressionOut.print(gioloc?.bioResource?.scientificName?:'NA')
printHtmlPart(38)
expressionOut.print(gioloc?.source?:'NA')
printHtmlPart(39)
expressionOut.print(gioloc?.village?:'NA')
printHtmlPart(40)
expressionOut.print(gioloc?.town?: 'NA')
printHtmlPart(40)
expressionOut.print(gioloc?.district?:'NA')
printHtmlPart(40)
expressionOut.print(gioloc?.state?:'NA')
printHtmlPart(40)
expressionOut.print(gioloc?.traderName?:'NA')
printHtmlPart(40)
expressionOut.print(gioloc?.traderContactDetails?:'NA')
printHtmlPart(41)
n++
}
}
printHtmlPart(26)
m++
}
}
printHtmlPart(25)
l++
}
}
printHtmlPart(33)
}
printHtmlPart(42)
expressionOut.print(formDetails?.category?.category)
printHtmlPart(43)
if(true && (formDetails?.category?.category == FormCategory.Category.Form_1)) {
printHtmlPart(3)
}
else if(true && (formDetails?.category?.category == FormCategory.Category.Form_2)) {
printHtmlPart(4)
}
else if(true && (formDetails?.category?.category == FormCategory.Category.Form_3)) {
printHtmlPart(5)
}
else if(true && (formDetails?.category?.category == FormCategory.Category.Form_4)) {
printHtmlPart(6)
}
else if(true && (formDetails?.category?.category == FormCategory.Category.Form_B)) {
printHtmlPart(44)
}
else if(true && (formDetails?.category?.category == FormCategory.Category.Form_C)) {
printHtmlPart(8)
}
printHtmlPart(9)
expressionOut.print(submittedDate)
printHtmlPart(10)
expressionOut.print(applicationNum)
printHtmlPart(45)

int counter = 0

printHtmlPart(19)
if(true && (formDetails?.sbbConsents)) {
printHtmlPart(19)
loop:{
int i = 0
for( pdfFle in (formDetails?.sbbConsents) ) {
printHtmlPart(20)
if(true && (pdfFle?.fileName || pdfFle?.filePath)) {
printHtmlPart(46)
expressionOut.print(counter = counter+1)
printHtmlPart(47)
if(true && (pdfFle?.consentCreatedDate)) {
printHtmlPart(48)
invokeTag('formatDate','g',425,['format':("dd/MM/yyyy"),'date':(pdfFle?.consentCreatedDate)],-1)
printHtmlPart(49)
}
else {
printHtmlPart(50)
}
printHtmlPart(51)
expressionOut.print(pdfFle?.fileName?:'NA')
printHtmlPart(52)
createClosureForHtmlPart(53, 4)
invokeTag('link','g',437,['controller':("SBB"),'action':("sbbFileShows"),'target':("_blank"),'params':([showId:pdfFle?.id,csrfPreventionSalt:csrfPreventionSalt])],4)
printHtmlPart(54)
}
printHtmlPart(55)
i++
}
}
printHtmlPart(18)
}
printHtmlPart(56)
if(true && (formDetails?.clientLetters)) {
printHtmlPart(56)
for( act in (formDetails?.clientLetters) ) {
printHtmlPart(56)
for( dynamic in (act?.pdfFileAttachments) ) {
printHtmlPart(57)
if(true && (dynamic?.pdfName || dynamic?.attachedUrl)) {
printHtmlPart(58)
expressionOut.print(counter = counter+1)
printHtmlPart(59)
invokeTag('formatDate','g',451,['format':("dd/MM/yyyy"),'date':(dynamic?.attachedDate)],-1)
printHtmlPart(60)
expressionOut.print(dynamic?.pdfName)
printHtmlPart(61)
createClosureForHtmlPart(53, 5)
invokeTag('link','g',460,['controller':("SBB"),'action':("dynamicLetterShow"),'target':("_blank"),'params':([dynamicId:dynamic?.id,csrfPreventionSalt:csrfPreventionSalt])],5)
printHtmlPart(54)
}
printHtmlPart(33)
}
printHtmlPart(62)
}
printHtmlPart(63)
}
printHtmlPart(64)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1603715348000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
