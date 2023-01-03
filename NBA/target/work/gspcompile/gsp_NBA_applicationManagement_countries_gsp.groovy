import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_NBA_applicationManagement_countries_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/applicationManagement/_countries.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
expressionOut.print(createLink(controller:'applicationManagement',action:'fetchMobileCode'))
printHtmlPart(2)
expressionOut.print(csrfPreventionSalt)
printHtmlPart(3)
})
invokeTag('javascript','g',38,[:],1)
printHtmlPart(4)
invokeTag('select','g',44,['name':("countryId"),'from':(listOfCountries),'optionKey':("id"),'optionValue':("country"),'value':(individualProfile?.country?.id),'req1':("1"),'class':("width controlclass1 country"),'noSelection':(['':'-Select-']),'id':("nonIndianCountry"),'onchange':(remoteFunction(controller: 'applicationManagement', action: 'fetchStates',
				  params: "'countryId='+this.value+'&csrfPreventionSalt=${csrfPreventionSalt}'",
				  update: 'updateStates',onComplete: 'updateCountryCodes(this)'))],-1)
printHtmlPart(5)
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
