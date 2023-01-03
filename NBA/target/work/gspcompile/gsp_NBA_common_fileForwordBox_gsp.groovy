import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_NBA_common_fileForwordBox_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/common/_fileForwordBox.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
invokeTag('hiddenField','g',2,['name':("ckeditorData"),'id':("ckData")],-1)
printHtmlPart(1)
invokeTag('select','g',11,['class':("form-control"),'name':("statusUpdate"),'from':(dropDnValues?.statusList),'value':(addNoteInstance?.statusUpdate),'noSelection':(['':'-Update Status-']),'required':("required")],-1)
printHtmlPart(2)
invokeTag('select','g',20,['class':("form-control"),'name':("priorities"),'from':(dropDnValues?.priorityList),'value':(addNoteInstance?.priorities),'noSelection':(['':'-select Priority-'])],-1)
printHtmlPart(3)
invokeTag('select','g',29,['name':("actions"),'class':("form-control"),'from':(dropDnValues?.actionList),'value':(addNoteInstance?.actions),'noSelection':(['':'-Choose Action-']),'required':("required")],-1)
printHtmlPart(4)
invokeTag('select','g',39,['name':("forwardMember"),'class':("form-control"),'from':(dropDnValues?.forwordUsrList),'optionKey':("id"),'optionValue':({it.name +' '+ "[" +it?.nbaRole?.authority +"]"}),'value':(addNoteInstance?.forwardMember),'noSelection':(['':'-Choose Action-']),'required':("required")],-1)
printHtmlPart(5)
createClosureForHtmlPart(6, 1)
invokeTag('link','g',46,['value':("Cancel"),'class':("btn btn-primary pull-right"),'style':("margin-left: 10px;"),'action':("cancelRequest"),'controller':("checklist")],1)
printHtmlPart(7)
invokeTag('submitButton','g',49,['name':("Send"),'value':("Send"),'onclick':("return getData()"),'class':("btn btn-primary pull-right")],-1)
printHtmlPart(8)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1588675740000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
