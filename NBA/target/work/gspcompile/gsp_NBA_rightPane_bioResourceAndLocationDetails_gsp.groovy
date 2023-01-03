
import org.nba.application.FormCategory

import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_NBA_rightPane_bioResourceAndLocationDetails_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/rightPane/_bioResourceAndLocationDetails.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
if(true && (formDetails?.biologicalResources)) {
printHtmlPart(1)
if(true && (formDetails?.category?.category == FormCategory.Category.Form_1)) {
printHtmlPart(2)
}
printHtmlPart(3)

int i=1

printHtmlPart(4)
for( bioResource in (formDetails?.biologicalResources) ) {
printHtmlPart(5)
out.print(i)
printHtmlPart(6)

i++

printHtmlPart(7)
expressionOut.print(bioResource?.accessIntention)
printHtmlPart(8)
expressionOut.print(bioResource?.commonName)
printHtmlPart(9)
expressionOut.print(bioResource?.scientificName)
printHtmlPart(10)
expressionOut.print(bioResource?.nature)
printHtmlPart(9)
expressionOut.print(bioResource?.biologicalResource)
printHtmlPart(11)
if(true && (formDetails?.category?.category == FormCategory.Category.Form_1)) {
printHtmlPart(12)
expressionOut.print(bioResource?.quantity)
printHtmlPart(13)
expressionOut.print(bioResource?.qtyUnit)
printHtmlPart(9)
expressionOut.print(bioResource?.fromTime?.format('dd/MM/yyyy'))
printHtmlPart(14)
expressionOut.print(bioResource?.toTime?.format('dd/MM/yyyy'))
printHtmlPart(9)
expressionOut.print(bioResource?.traditionalUse)
printHtmlPart(11)
}
printHtmlPart(15)
}
printHtmlPart(16)
}
printHtmlPart(17)
if(true && (formDetails?.biologicalResources?.locations)) {
printHtmlPart(18)
if(true && (formDetails?.biologicalResources?.locations)) {
printHtmlPart(19)
loop:{
int l = 0
for( giolocation in (formDetails?.biologicalResources?.locations) ) {
printHtmlPart(20)
loop:{
int m = 0
for( gioloct in (giolocation) ) {
printHtmlPart(21)
loop:{
int n = 0
for( gioloc in (gioloct) ) {
printHtmlPart(22)
expressionOut.print(l+1)
printHtmlPart(23)
expressionOut.print(gioloc?.bioResource?.scientificName?:'NA')
printHtmlPart(24)
expressionOut.print(gioloc?.source?:'NA')
printHtmlPart(25)
expressionOut.print(gioloc?.village?:'NA')
printHtmlPart(26)
expressionOut.print(gioloc?.town?: 'NA')
printHtmlPart(26)
expressionOut.print(gioloc?.district?:'NA')
printHtmlPart(26)
expressionOut.print(gioloc?.state?:'NA')
printHtmlPart(26)
expressionOut.print(gioloc?.traderName?:'NA')
printHtmlPart(26)
expressionOut.print(gioloc?.traderContactDetails?:'NA')
printHtmlPart(27)
n++
}
}
printHtmlPart(20)
m++
}
}
printHtmlPart(19)
l++
}
}
printHtmlPart(28)
}
printHtmlPart(29)
}
printHtmlPart(30)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1639992513541L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
