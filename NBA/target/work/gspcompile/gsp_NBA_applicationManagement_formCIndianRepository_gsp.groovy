import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_NBA_applicationManagement_formCIndianRepository_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/applicationManagement/_formCIndianRepository.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
expressionOut.print(tabStatus)
printHtmlPart(2)
expressionOut.print(createLink(controller:'applicationManagement',action:'fetchMobileCode'))
printHtmlPart(3)
expressionOut.print(csrfPreventionSalt)
printHtmlPart(4)
})
invokeTag('javascript','g',38,[:],1)
printHtmlPart(5)
createTagBody(1, {->
printHtmlPart(6)
expressionOut.print(csrfPreventionSalt)
printHtmlPart(7)
expressionOut.print(indianRepo?.repostoryName)
printHtmlPart(8)
expressionOut.print(indianRepo?.address1)
printHtmlPart(9)
expressionOut.print(indianRepo?.address2)
printHtmlPart(10)
expressionOut.print(indianRepo?.address3)
printHtmlPart(11)
invokeTag('select','g',119,['name':("countryId"),'from':(indianCountries),'optionKey':("id"),'optionValue':("country"),'value':(indianRepo?.country?.id),'class':("width country controlreq"),'onchange':(remoteFunction (controller: 'applicationManagement',action: 'fetchStates',
							params: "'countryId='+this.value+'&csrfPreventionSalt=${csrfPreventionSalt}'+'&formType=${formType}'+'&part=Part3'",update: 'updateStates1',onComplete: 'updateCountryCodes(this)'))],-1)
printHtmlPart(12)
invokeTag('select','g',135,['name':("state"),'from':(listOfStates?.state),'req1':("1"),'class':("width controlreq"),'value':(indianRepo?.state),'noSelection':(['':'Select State'])],-1)
printHtmlPart(13)
expressionOut.print(indianRepo?.city)
printHtmlPart(14)
expressionOut.print(indianRepo?.zip)
printHtmlPart(15)
if(true && (indianRepo?.phone?.contains('-'))) {
printHtmlPart(16)
expressionOut.print(indianRepo?.phone?.split('-')[0])
printHtmlPart(17)
}
else {
printHtmlPart(18)
}
printHtmlPart(19)
if(true && (indianRepo?.phone?.contains('-'))) {
printHtmlPart(20)
expressionOut.print(indianRepo?.phone?.split('-')[1])
printHtmlPart(21)
}
else {
printHtmlPart(22)
}
printHtmlPart(23)
expressionOut.print(indianRepo?.email)
printHtmlPart(24)
invokeTag('hiddenField','g',208,['name':("profileId"),'value':(indianRepo?.id)],-1)
printHtmlPart(25)
invokeTag('hiddenField','g',208,['name':("formType"),'value':(formType)],-1)
printHtmlPart(26)
invokeTag('hiddenField','g',209,['name':("appFormId"),'value':(appForm)],-1)
printHtmlPart(27)
})
invokeTag('formRemote','g',217,['name':("indianRepository"),'class':("form-horizontal"),'role':("form"),'autocomplete':("off"),'url':([controller:'applicationManagement',action:'submitContactDetailsOfReposatory']),'onComplete':("loadPage()")],1)
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
