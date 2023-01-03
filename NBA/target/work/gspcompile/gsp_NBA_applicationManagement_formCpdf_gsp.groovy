
import org.nba.common.State

import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_NBA_applicationManagement_formCpdf_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/applicationManagement/_formCpdf.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(1)
printHtmlPart(2)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',7,['gsp_sm_xmlClosingForEmptyTag':("/"),'http-equiv':("Content-Type"),'content':("text/html; charset=UTF-8")],-1)
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',8,['gsp_sm_xmlClosingForEmptyTag':("/"),'name':("layout"),'content':("main")],-1)
printHtmlPart(1)
createTagBody(2, {->
createClosureForHtmlPart(3, 3)
invokeTag('captureTitle','sitemesh',9,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',9,[:],2)
printHtmlPart(4)
})
invokeTag('captureHead','sitemesh',33,[:],1)
printHtmlPart(1)
createTagBody(1, {->
printHtmlPart(5)
expressionOut.print(resource(dir: 'images', file: 'Logo1.jpg'))
printHtmlPart(6)
if(true && (appForm?.transaction?.isPaymentMade == true)) {
printHtmlPart(7)
expressionOut.print(appForm?.appNumber)
printHtmlPart(8)
expressionOut.print(appForm?.submittedOn)
printHtmlPart(9)
}
printHtmlPart(10)
if(true && (listOfDepositionOfMicroOrganism.size() != 0)) {
printHtmlPart(11)

int num= 1

printHtmlPart(12)

char alph = 65

printHtmlPart(12)
for( profile in (listOfDepositionOfMicroOrganism) ) {
printHtmlPart(13)
expressionOut.print(alph)
printHtmlPart(14)
expressionOut.print(num)
printHtmlPart(15)

num++

printHtmlPart(16)

alph++

printHtmlPart(17)
expressionOut.print(profile?.nameOfDepositor)
printHtmlPart(18)
expressionOut.print(profile?.address1)
printHtmlPart(19)
expressionOut.print(profile?.address2)
printHtmlPart(20)
expressionOut.print(profile?.address3)
printHtmlPart(20)
expressionOut.print(profile?.city)
printHtmlPart(21)
expressionOut.print(profile?.zip)
printHtmlPart(19)
expressionOut.print(profile?.state)
printHtmlPart(19)
expressionOut.print(profile?.country?.country)
printHtmlPart(22)
expressionOut.print(profile?.mobile)
printHtmlPart(23)
expressionOut.print(profile?.phone)
printHtmlPart(24)
expressionOut.print(profile?.email)
printHtmlPart(25)
}
printHtmlPart(26)
}
printHtmlPart(27)

char alph = 97

printHtmlPart(28)

int i=1

printHtmlPart(28)
for( scientist in (listOfScientistName) ) {
printHtmlPart(29)
expressionOut.print(alph)
printHtmlPart(30)
expressionOut.print(i)
printHtmlPart(31)
expressionOut.print(scientist?.scientistName)
printHtmlPart(32)

i++

printHtmlPart(12)

alph++

printHtmlPart(28)
}
printHtmlPart(33)

alph = 97

printHtmlPart(34)
loop:{
int k = 0
for( profile1 in (bioRes) ) {
printHtmlPart(35)
for( profile in (profile1) ) {
printHtmlPart(36)
out.print(alph)
printHtmlPart(37)
expressionOut.print(profile?.bioResource?.scientistName)
printHtmlPart(38)
expressionOut.print(profile?.source)
printHtmlPart(38)
if(true && (profile?.village)) {
printHtmlPart(39)
expressionOut.print(profile?.village)
printHtmlPart(40)
}
else {
printHtmlPart(41)
}
printHtmlPart(38)
if(true && (profile?.town)) {
printHtmlPart(39)
expressionOut.print(profile?.town)
printHtmlPart(40)
}
else {
printHtmlPart(41)
}
printHtmlPart(38)
if(true && (profile?.district)) {
printHtmlPart(39)
expressionOut.print(profile?.district)
printHtmlPart(40)
}
else {
printHtmlPart(42)
}
printHtmlPart(38)
if(true && (profile?.state)) {
printHtmlPart(39)
expressionOut.print(profile?.state)
printHtmlPart(40)
}
else {
printHtmlPart(41)
}
printHtmlPart(38)
if(true && (profile?.traderName)) {
printHtmlPart(39)
expressionOut.print(profile?.traderName)
printHtmlPart(40)
}
else {
printHtmlPart(41)
}
printHtmlPart(38)
if(true && (profile?.traderContactDetails)) {
printHtmlPart(39)
expressionOut.print(profile?.traderContactDetails)
printHtmlPart(40)
}
else {
printHtmlPart(41)
}
printHtmlPart(43)

alph++

printHtmlPart(44)
}
printHtmlPart(28)
k++
}
}
printHtmlPart(45)

int num= 1

printHtmlPart(28)

alph = 65

printHtmlPart(28)
for( profile in (listOfContactDetailsOfRepository) ) {
printHtmlPart(46)
expressionOut.print(alph)
printHtmlPart(47)
expressionOut.print(profile.repostoryType)
printHtmlPart(48)

num++

printHtmlPart(12)

alph++

printHtmlPart(49)
expressionOut.print(profile.repostoryName)
printHtmlPart(50)
expressionOut.print(profile?.address1)
printHtmlPart(19)
expressionOut.print(profile?.address2)
printHtmlPart(20)
expressionOut.print(profile?.address3)
printHtmlPart(20)
expressionOut.print(profile?.city)
printHtmlPart(51)
expressionOut.print(profile.zip)
printHtmlPart(19)
expressionOut.print(profile.state)
printHtmlPart(19)
expressionOut.print(profile?.country?.country)
printHtmlPart(52)
expressionOut.print(profile?.phone)
printHtmlPart(53)
expressionOut.print(profile?.email)
printHtmlPart(54)
}
printHtmlPart(55)
expressionOut.print(applicationform?.depositionPerpose)
printHtmlPart(56)
expressionOut.print(accessionNumber?.accessionNumber)
printHtmlPart(57)
if(true && (applicationform?.undertakingCopyFileName)) {
printHtmlPart(39)
createTagBody(3, {->
printHtmlPart(58)
expressionOut.print(applicationform?.undertakingCopyFileName)
printHtmlPart(39)
})
invokeTag('link','g',332,['controller':("applicationManagement"),'action':("showUndertakingFile"),'id':(applicationform?.id),'target':("_blank"),'params':([filename: "undertakingCopy", dataName: "undertakingCopy",csrfPreventionSalt:"${csrfPreventionSalt}"])],3)
printHtmlPart(40)
}
else {
printHtmlPart(59)
}
printHtmlPart(60)
})
invokeTag('captureBody','sitemesh',342,[:],1)
printHtmlPart(61)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1537268166000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
