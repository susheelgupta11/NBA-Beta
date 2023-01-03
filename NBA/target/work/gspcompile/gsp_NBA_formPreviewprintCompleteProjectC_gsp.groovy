
import org.nba.common.State

import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_NBA_formPreviewprintCompleteProjectC_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/formPreview/printCompleteProjectC.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',5,['gsp_sm_xmlClosingForEmptyTag':("/"),'http-equiv':("Content-Type"),'content':("text/html; charset=UTF-8")],-1)
printHtmlPart(2)
invokeTag('captureMeta','sitemesh',6,['gsp_sm_xmlClosingForEmptyTag':("/"),'name':("layout"),'content':("projectPreview")],-1)
printHtmlPart(2)
createTagBody(2, {->
createClosureForHtmlPart(3, 3)
invokeTag('captureTitle','sitemesh',7,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',7,[:],2)
printHtmlPart(4)
})
invokeTag('captureHead','sitemesh',25,[:],1)
printHtmlPart(2)
createTagBody(1, {->
printHtmlPart(5)
if(true && (appForm?.transaction?.isPaymentMade != true)) {
printHtmlPart(6)
expressionOut.print(appForm?.appNumber)
printHtmlPart(7)
expressionOut.print(appForm?.submittedOn)
printHtmlPart(8)
}
printHtmlPart(9)
if(true && (listOfDepositionOfMicroOrganism.size() != 0)) {
printHtmlPart(10)

int num= 1

printHtmlPart(11)

char alph = 65

printHtmlPart(11)
for( profile in (listOfDepositionOfMicroOrganism) ) {
printHtmlPart(12)
expressionOut.print(alph)
printHtmlPart(13)
expressionOut.print(num)
printHtmlPart(14)
expressionOut.print(profile?.nameOfDepositor)
printHtmlPart(15)

num++

printHtmlPart(16)

alph++

printHtmlPart(17)
expressionOut.print(profile?.address1)
printHtmlPart(18)
expressionOut.print(profile?.address2)
printHtmlPart(19)
expressionOut.print(profile?.address3)
printHtmlPart(19)
expressionOut.print(profile?.city)
printHtmlPart(20)
expressionOut.print(profile?.zip)
printHtmlPart(18)
expressionOut.print(profile?.state)
printHtmlPart(18)
expressionOut.print(profile?.country?.country)
printHtmlPart(21)
expressionOut.print(profile?.mobile)
printHtmlPart(22)
expressionOut.print(profile?.phone)
printHtmlPart(23)
expressionOut.print(profile?.email)
printHtmlPart(24)
}
printHtmlPart(25)
}
printHtmlPart(26)

char alph = 97

printHtmlPart(27)

int i=1

printHtmlPart(27)
for( scientist in (listOfScientistName) ) {
printHtmlPart(28)
expressionOut.print(alph)
printHtmlPart(29)
expressionOut.print(i)
printHtmlPart(30)
expressionOut.print(scientist?.scientistName)
printHtmlPart(31)

i++

printHtmlPart(11)

alph++

printHtmlPart(27)
}
printHtmlPart(32)

alph = 97

printHtmlPart(33)
loop:{
int k = 0
for( profile1 in (bioRes) ) {
printHtmlPart(34)
for( profile in (profile1) ) {
printHtmlPart(35)
out.print(alph)
printHtmlPart(36)
expressionOut.print(profile?.bioResource?.scientistName)
printHtmlPart(37)
expressionOut.print(profile?.source)
printHtmlPart(37)
if(true && (profile?.village)) {
printHtmlPart(38)
expressionOut.print(profile?.village)
printHtmlPart(39)
}
else {
printHtmlPart(40)
}
printHtmlPart(37)
if(true && (profile?.town)) {
printHtmlPart(38)
expressionOut.print(profile?.town)
printHtmlPart(39)
}
else {
printHtmlPart(40)
}
printHtmlPart(37)
if(true && (profile?.district)) {
printHtmlPart(38)
expressionOut.print(profile?.district)
printHtmlPart(39)
}
else {
printHtmlPart(41)
}
printHtmlPart(37)
if(true && (profile?.state)) {
printHtmlPart(38)
expressionOut.print(profile?.state)
printHtmlPart(39)
}
else {
printHtmlPart(40)
}
printHtmlPart(37)
if(true && (profile?.traderName)) {
printHtmlPart(38)
expressionOut.print(profile?.traderName)
printHtmlPart(39)
}
else {
printHtmlPart(40)
}
printHtmlPart(37)
if(true && (profile?.traderContactDetails)) {
printHtmlPart(38)
expressionOut.print(profile?.traderContactDetails)
printHtmlPart(39)
}
else {
printHtmlPart(40)
}
printHtmlPart(42)

alph++

printHtmlPart(43)
}
printHtmlPart(27)
k++
}
}
printHtmlPart(44)

int num= 1

printHtmlPart(27)

alph = 65

printHtmlPart(27)
for( profile in (listOfContactDetailsOfRepository) ) {
printHtmlPart(45)
expressionOut.print(alph)
printHtmlPart(46)
expressionOut.print(profile.repostoryType)
printHtmlPart(47)

num++

printHtmlPart(11)

alph++

printHtmlPart(48)
expressionOut.print(profile.repostoryName)
printHtmlPart(49)
expressionOut.print(profile?.address1)
printHtmlPart(18)
expressionOut.print(profile?.address2)
printHtmlPart(19)
expressionOut.print(profile?.address3)
printHtmlPart(19)
expressionOut.print(profile?.city)
printHtmlPart(50)
expressionOut.print(profile.zip)
printHtmlPart(18)
expressionOut.print(profile.state)
printHtmlPart(18)
expressionOut.print(profile?.country?.country)
printHtmlPart(51)
expressionOut.print(profile?.phone)
printHtmlPart(52)
expressionOut.print(profile?.email)
printHtmlPart(53)
}
printHtmlPart(54)
expressionOut.print(applicationform?.depositionPerpose)
printHtmlPart(55)
expressionOut.print(accessionNumber?.accessionNumber)
printHtmlPart(56)
if(true && (applicationform?.undertakingCopyFileName)) {
printHtmlPart(57)
}
else {
printHtmlPart(58)
}
printHtmlPart(59)
})
invokeTag('captureBody','sitemesh',366,[:],1)
printHtmlPart(60)
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
