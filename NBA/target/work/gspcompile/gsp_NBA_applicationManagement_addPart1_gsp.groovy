import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_NBA_applicationManagement_addPart1_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/applicationManagement/_addPart1.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
expressionOut.print(csrfPreventionSalt)
printHtmlPart(2)
for( resource in (natureOfReources) ) {
printHtmlPart(3)
expressionOut.print(resource)
printHtmlPart(4)
expressionOut.print(resource)
printHtmlPart(5)
}
printHtmlPart(6)
invokeTag('select','g',97,['name':("bioResource"),'from':(resources),'value':(""),'onchange':("hideshowother(this,'other')"),'class':("width controlclass Associate dsblcontrol1"),'noSelection':(['':'-Select-'])],-1)
printHtmlPart(7)
invokeTag('select','g',126,['name':("qtyUnit"),'from':(quantityList),'value':(""),'class':("width controlclass Associate dsblcontrol1"),'noSelection':(['':'-Select-'])],-1)
printHtmlPart(8)
invokeTag('hiddenField','g',157,['name':("appFormId"),'value':(appForm?.id)],-1)
printHtmlPart(9)
invokeTag('hiddenField','g',158,['name':("formType"),'value':(formType)],-1)
printHtmlPart(10)
})
invokeTag('formRemote','g',164,['name':("biologicalResources"),'class':("form-horizontal"),'role':("form"),'autocomplete':("off"),'url':([controller:'applicationManagement',action:'saveBiologicalResources']),'update':("updateBioResources"),'onSuccess':("ClearAllFields()"),'onComplete':("loadPage()")],1)
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
