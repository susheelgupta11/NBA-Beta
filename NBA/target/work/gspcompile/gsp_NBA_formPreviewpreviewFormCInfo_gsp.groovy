
import org.nba.common.State

import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_NBA_formPreviewpreviewFormCInfo_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/formPreview/previewFormCInfo.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
if(true && (appForm?.transaction?.isPaymentMade != true)) {
printHtmlPart(1)
expressionOut.print(appForm?.appNumber)
printHtmlPart(2)
expressionOut.print(appForm?.submittedOn)
printHtmlPart(3)
}
printHtmlPart(4)
if(true && (listOfDepositionOfMicroOrganism.size() != 0)) {
printHtmlPart(5)

int num= 1

printHtmlPart(6)

char alph = 65

printHtmlPart(6)
for( profile in (listOfDepositionOfMicroOrganism) ) {
printHtmlPart(7)
expressionOut.print(alph)
printHtmlPart(8)
expressionOut.print(num)
printHtmlPart(9)

num++

printHtmlPart(10)

alph++

printHtmlPart(11)
expressionOut.print(profile?.nameOfDepositor)
printHtmlPart(12)
expressionOut.print(profile?.address1)
printHtmlPart(13)
expressionOut.print(profile?.address2)
printHtmlPart(14)
expressionOut.print(profile?.address3)
printHtmlPart(14)
expressionOut.print(profile?.city)
printHtmlPart(15)
expressionOut.print(profile?.zip)
printHtmlPart(13)
expressionOut.print(profile?.state)
printHtmlPart(13)
expressionOut.print(profile?.country?.country)
printHtmlPart(16)
expressionOut.print(profile?.mobile)
printHtmlPart(17)
expressionOut.print(profile?.phone)
printHtmlPart(18)
expressionOut.print(profile?.email)
printHtmlPart(19)
}
printHtmlPart(20)
}
printHtmlPart(21)

char alph = 97

printHtmlPart(22)

int i=1

printHtmlPart(22)
for( scientist in (listOfScientistName) ) {
printHtmlPart(23)
expressionOut.print(alph)
printHtmlPart(24)
expressionOut.print(i)
printHtmlPart(25)
expressionOut.print(scientist?.scientistName)
printHtmlPart(26)

i++

printHtmlPart(6)

alph++

printHtmlPart(22)
}
printHtmlPart(27)

alph = 97

printHtmlPart(28)
loop:{
int k = 0
for( profile1 in (bioRes) ) {
printHtmlPart(29)
for( profile in (profile1) ) {
printHtmlPart(30)
out.print(alph)
printHtmlPart(31)
expressionOut.print(profile?.bioResource?.scientistName)
printHtmlPart(32)
expressionOut.print(profile?.source)
printHtmlPart(32)
if(true && (profile?.village)) {
printHtmlPart(33)
expressionOut.print(profile?.village)
printHtmlPart(34)
}
else {
printHtmlPart(35)
}
printHtmlPart(32)
if(true && (profile?.town)) {
printHtmlPart(33)
expressionOut.print(profile?.town)
printHtmlPart(34)
}
else {
printHtmlPart(35)
}
printHtmlPart(32)
if(true && (profile?.district)) {
printHtmlPart(33)
expressionOut.print(profile?.district)
printHtmlPart(34)
}
else {
printHtmlPart(36)
}
printHtmlPart(32)
if(true && (profile?.state)) {
printHtmlPart(33)
expressionOut.print(profile?.state)
printHtmlPart(34)
}
else {
printHtmlPart(35)
}
printHtmlPart(32)
if(true && (profile?.traderName)) {
printHtmlPart(33)
expressionOut.print(profile?.traderName)
printHtmlPart(34)
}
else {
printHtmlPart(35)
}
printHtmlPart(32)
if(true && (profile?.traderContactDetails)) {
printHtmlPart(33)
expressionOut.print(profile?.traderContactDetails)
printHtmlPart(34)
}
else {
printHtmlPart(35)
}
printHtmlPart(37)

alph++

printHtmlPart(38)
}
printHtmlPart(22)
k++
}
}
printHtmlPart(39)

int num= 1

printHtmlPart(22)

alph = 65

printHtmlPart(22)
for( profile in (listOfContactDetailsOfRepository) ) {
printHtmlPart(40)
expressionOut.print(alph)
printHtmlPart(41)
expressionOut.print(profile.repostoryType)
printHtmlPart(42)

num++

printHtmlPart(6)

alph++

printHtmlPart(43)
expressionOut.print(profile.repostoryName)
printHtmlPart(44)
expressionOut.print(profile?.address1)
printHtmlPart(13)
expressionOut.print(profile?.address2)
printHtmlPart(14)
expressionOut.print(profile?.address3)
printHtmlPart(14)
expressionOut.print(profile?.city)
printHtmlPart(45)
expressionOut.print(profile.zip)
printHtmlPart(13)
expressionOut.print(profile.state)
printHtmlPart(13)
expressionOut.print(profile?.country?.country)
printHtmlPart(46)
expressionOut.print(profile?.phone)
printHtmlPart(47)
expressionOut.print(profile?.email)
printHtmlPart(48)
}
printHtmlPart(49)
expressionOut.print(applicationform?.depositionPerpose)
printHtmlPart(50)
expressionOut.print(accessionNumber?.accessionNumber)
printHtmlPart(51)
if(true && (applicationform?.undertakingCopyFileName)) {
printHtmlPart(33)
createTagBody(2, {->
printHtmlPart(52)
expressionOut.print(applicationform?.undertakingCopyFileName)
printHtmlPart(33)
})
invokeTag('link','g',299,['controller':("applicationManagement"),'action':("showUndertakingFile"),'id':(applicationform?.id),'target':("_blank"),'params':([filename: "undertakingCopy", dataName: "undertakingCopy",csrfPreventionSalt:"${csrfPreventionSalt}"])],2)
printHtmlPart(34)
}
else {
printHtmlPart(53)
}
printHtmlPart(54)
createClosureForHtmlPart(55, 1)
invokeTag('link','g',320,['controller':("formPreview"),'class':("btn btn-primary"),'action':("printCompleteProjectC"),'target':("_blank"),'params':([id:"${applicationform?.id}",csrfPreventionSalt:"${csrfPreventionSalt}"])],1)
printHtmlPart(56)
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
