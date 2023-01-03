
import org.nba.common.*

import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_NBA_rightPane_formCForMatchingData_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/rightPane/_formCForMatchingData.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)

char alpha = 65

printHtmlPart(0)
if(true && (allDataforMatching?.listOfDepositionOfMicroOrganism.size()>0)) {
printHtmlPart(0)
loop:{
int i = 0
for( profile in (allDataforMatching?.listOfDepositionOfMicroOrganism) ) {
printHtmlPart(1)
expressionOut.print(alpha)
printHtmlPart(2)
expressionOut.print(i+1)
printHtmlPart(3)

alpha++

printHtmlPart(4)
expressionOut.print(profile?.nameOfDepositor)
printHtmlPart(5)
expressionOut.print(profile?.address1)
printHtmlPart(6)
expressionOut.print(profile?.address2)
printHtmlPart(7)
expressionOut.print(profile?.address3)
printHtmlPart(7)
expressionOut.print(profile?.city)
printHtmlPart(8)
expressionOut.print(profile?.zip)
printHtmlPart(6)
expressionOut.print(profile?.state)
printHtmlPart(6)
expressionOut.print(profile?.country?.country)
printHtmlPart(9)
expressionOut.print(profile?.mobile)
printHtmlPart(10)
expressionOut.print(profile?.phone)
printHtmlPart(11)
expressionOut.print(profile?.email)
printHtmlPart(12)

char alphaSmall = 97

printHtmlPart(13)
loop:{
int j = 0
for( scientist in (allDataforMatching?.listOfScientistName) ) {
printHtmlPart(14)
expressionOut.print(alphaSmall)
printHtmlPart(15)
expressionOut.print(j+1)
printHtmlPart(16)
expressionOut.print(scientist?.scientistName)
printHtmlPart(17)

alphaSmall++

printHtmlPart(13)
j++
}
}
printHtmlPart(18)
i++
}
}
printHtmlPart(18)
}
printHtmlPart(19)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1539324922000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
