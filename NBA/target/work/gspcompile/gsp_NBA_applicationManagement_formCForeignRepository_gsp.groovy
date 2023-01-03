import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_NBA_applicationManagement_formCForeignRepository_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/applicationManagement/_formCForeignRepository.gsp" }
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
invokeTag('javascript','g',40,[:],1)
printHtmlPart(5)
createTagBody(1, {->
printHtmlPart(6)
expressionOut.print(csrfPreventionSalt)
printHtmlPart(7)
invokeTag('set','g',48,['var':("RepostoryType"),'value':("ForeignReposatory")],-1)
printHtmlPart(5)

String RepostoryType="ForeignReposatory"

printHtmlPart(8)
expressionOut.print(foreignRepo?.repostoryName)
printHtmlPart(9)
expressionOut.print(foreignRepo?.address1)
printHtmlPart(10)
expressionOut.print(foreignRepo?.address2)
printHtmlPart(11)
expressionOut.print(foreignRepo?.address3)
printHtmlPart(12)
invokeTag('select','g',125,['name':("countryId"),'from':(listOfForeignCountries),'optionKey':("id"),'optionValue':("country"),'value':(foreignRepo?.country?.id),'class':("width country ctlwidth"),'noSelection':(['':'-Select-']),'req1':("1"),'onchange':(remoteFunction (controller: 'applicationManagement',action: 'fetchStates',
							params: "'countryId='+this.value+'&csrfPreventionSalt=${csrfPreventionSalt}'+'&formType=${formType}'+'&part=Part3'",update: 'updateStates',onComplete: 'updateCountryCodes1(this)'))],-1)
printHtmlPart(13)
expressionOut.print(foreignRepo?.state)
printHtmlPart(14)
expressionOut.print(foreignRepo?.city)
printHtmlPart(15)
expressionOut.print(foreignRepo?.zip)
printHtmlPart(16)
if(true && (foreignRepo?.phone?.contains('-'))) {
printHtmlPart(17)
expressionOut.print(foreignRepo?.phone?.split('-')[0])
printHtmlPart(18)
}
else {
printHtmlPart(19)
}
printHtmlPart(20)
if(true && (foreignRepo?.phone?.contains('-'))) {
printHtmlPart(21)
expressionOut.print(foreignRepo?.phone?.split('-')[1])
printHtmlPart(22)
}
else {
printHtmlPart(23)
}
printHtmlPart(24)
expressionOut.print(foreignRepo?.email)
printHtmlPart(25)
invokeTag('hiddenField','g',199,['name':("profileId"),'value':(foreignRepo?.id)],-1)
printHtmlPart(26)
invokeTag('hiddenField','g',200,['name':("formType"),'value':(formType)],-1)
printHtmlPart(26)
invokeTag('hiddenField','g',200,['name':("appFormId"),'value':(appForm)],-1)
printHtmlPart(26)
invokeTag('hiddenField','g',207,['name':("csrfPreventionSalt"),'value':(csrfPreventionSalt)],-1)
printHtmlPart(27)
})
invokeTag('formRemote','g',210,['name':("foreignReposatory"),'class':("form-horizontal"),'role':("form"),'autocomplete':("off"),'url':([controller:'applicationManagement',action:'submitContactDetailsOfReposatory']),'onComplete':("loadPage()")],1)
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
