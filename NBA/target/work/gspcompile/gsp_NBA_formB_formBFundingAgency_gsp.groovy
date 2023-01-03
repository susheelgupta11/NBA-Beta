import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_NBA_formB_formBFundingAgency_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/formB/_formBFundingAgency.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
expressionOut.print(fundingAgencyObj?.institutionOrganizationName)
printHtmlPart(2)
expressionOut.print(fundingAgencyObj?.address1)
printHtmlPart(3)
expressionOut.print(fundingAgencyObj?.address2)
printHtmlPart(4)
expressionOut.print(fundingAgencyObj?.address3)
printHtmlPart(5)
invokeTag('select','g',86,['name':("countryId"),'from':(listOfCountries),'optionKey':("id"),'optionValue':("country"),'value':(fundingAgencyObj?.country?.id),'class':("width country controlreqired"),'noSelection':(['':'-Select-']),'req1':("1")],-1)
printHtmlPart(6)
expressionOut.print(fundingAgencyObj?.state)
printHtmlPart(7)
expressionOut.print(fundingAgencyObj?.city)
printHtmlPart(8)
expressionOut.print(fundingAgencyObj?.phone)
printHtmlPart(9)
expressionOut.print(fundingAgencyObj?.email)
printHtmlPart(10)
createTagBody(2, {->
printHtmlPart(11)
expressionOut.print(fundingAgencyObj?.sanctionOrderMoUcopyFileName)
printHtmlPart(12)
})
invokeTag('link','g',138,['controller':("applicationManagement"),'action':("showUndertakingFile"),'id':(fundingAgencyObj?.id),'target':("_blank"),'params':([filename: "sanctionOrderMoUcopy",appFormId:"${appForm?.id}",csrfPreventionSalt:"${csrfPreventionSalt}"])],2)
printHtmlPart(13)
invokeTag('hiddenField','g',141,['name':("csrfPreventionSalt"),'value':(csrfPreventionSalt)],-1)
printHtmlPart(14)
invokeTag('hiddenField','g',142,['name':("type"),'value':("funding")],-1)
printHtmlPart(14)
invokeTag('hiddenField','g',143,['name':("part"),'value':("part3")],-1)
printHtmlPart(14)
invokeTag('hiddenField','g',144,['name':("formType"),'value':(formType)],-1)
printHtmlPart(12)
invokeTag('hiddenField','g',146,['name':("appFormId"),'value':(appForm?.id)],-1)
printHtmlPart(12)
invokeTag('hiddenField','g',146,['name':("agencyId"),'value':(fundingAgencyObj?.id)],-1)
printHtmlPart(15)
})
invokeTag('uploadForm','g',154,['name':("supervisorForm"),'class':("form-horizontal"),'role':("form"),'autocomplete':("off"),'action':("saveFundingAgency"),'controller':("formB")],1)
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
