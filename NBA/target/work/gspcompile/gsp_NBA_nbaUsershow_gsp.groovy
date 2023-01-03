import org.nba.user.NbaUser
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_NBA_nbaUsershow_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/nbaUser/show.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(1)
createTagBody(1, {->
printHtmlPart(0)
invokeTag('captureMeta','sitemesh',6,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("superAdmin")],-1)
printHtmlPart(2)
createTagBody(2, {->
createClosureForHtmlPart(3, 3)
invokeTag('captureTitle','sitemesh',8,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',8,[:],2)
printHtmlPart(0)
})
invokeTag('captureHead','sitemesh',9,[:],1)
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(4)
if(true && (nbaUserInstance?.name)) {
printHtmlPart(5)
invokeTag('message','g',20,['code':("nbaUser.name.label"),'default':("Name")],-1)
printHtmlPart(6)
invokeTag('fieldValue','g',22,['bean':(nbaUserInstance),'field':("name")],-1)
printHtmlPart(7)
}
printHtmlPart(8)
if(true && (nbaUserInstance?.username)) {
printHtmlPart(9)
invokeTag('message','g',28,['code':("nbaUser.username.label"),'default':("Username")],-1)
printHtmlPart(10)
invokeTag('fieldValue','g',30,['bean':(nbaUserInstance),'field':("username")],-1)
printHtmlPart(7)
}
printHtmlPart(11)
if(true && (nbaUserInstance?.accountExpired)) {
printHtmlPart(12)
invokeTag('message','g',42,['code':("nbaUser.accountExpired.label"),'default':("Account Expired")],-1)
printHtmlPart(13)
invokeTag('formatBoolean','g',45,['boolean':(nbaUserInstance?.accountExpired)],-1)
printHtmlPart(7)
}
printHtmlPart(8)
if(true && (nbaUserInstance?.accountLocked)) {
printHtmlPart(14)
invokeTag('message','g',51,['code':("nbaUser.accountLocked.label"),'default':("Account Locked")],-1)
printHtmlPart(15)
invokeTag('formatBoolean','g',53,['boolean':(nbaUserInstance?.accountLocked)],-1)
printHtmlPart(7)
}
printHtmlPart(8)
if(true && (nbaUserInstance?.dateOfBirth)) {
printHtmlPart(16)
invokeTag('message','g',59,['code':("nbaUser.dateOfBirth.label"),'default':("Date Of Birth")],-1)
printHtmlPart(17)
invokeTag('formatDate','g',61,['date':(nbaUserInstance?.dateOfBirth)],-1)
printHtmlPart(7)
}
printHtmlPart(8)
if(true && (nbaUserInstance?.email)) {
printHtmlPart(18)
invokeTag('message','g',67,['code':("nbaUser.email.label"),'default':("Email")],-1)
printHtmlPart(19)
invokeTag('fieldValue','g',69,['bean':(nbaUserInstance),'field':("email")],-1)
printHtmlPart(7)
}
printHtmlPart(8)
if(true && (nbaUserInstance?.enabled)) {
printHtmlPart(20)
invokeTag('message','g',75,['code':("nbaUser.enabled.label"),'default':("Enabled")],-1)
printHtmlPart(21)
invokeTag('formatBoolean','g',77,['boolean':(nbaUserInstance?.enabled)],-1)
printHtmlPart(7)
}
printHtmlPart(8)
if(true && (nbaUserInstance?.mobile)) {
printHtmlPart(22)
invokeTag('message','g',83,['code':("nbaUser.mobile.label"),'default':("Mobile")],-1)
printHtmlPart(23)
invokeTag('fieldValue','g',85,['bean':(nbaUserInstance),'field':("mobile")],-1)
printHtmlPart(7)
}
printHtmlPart(8)
if(true && (nbaUserInstance?.passwordExpired)) {
printHtmlPart(24)
invokeTag('message','g',91,['code':("nbaUser.passwordExpired.label"),'default':("Password Expired")],-1)
printHtmlPart(25)
invokeTag('formatBoolean','g',95,['boolean':(nbaUserInstance?.passwordExpired)],-1)
printHtmlPart(7)
}
printHtmlPart(8)
if(true && (nbaUserInstance?.phone)) {
printHtmlPart(26)
invokeTag('message','g',101,['code':("nbaUser.phone.label"),'default':("Phone")],-1)
printHtmlPart(27)
invokeTag('fieldValue','g',103,['bean':(nbaUserInstance),'field':("phone")],-1)
printHtmlPart(7)
}
printHtmlPart(28)
createTagBody(2, {->
printHtmlPart(29)
createTagBody(3, {->
printHtmlPart(30)
invokeTag('message','g',113,['code':("default.button.edit.label"),'default':("Edit"),'style':("margin-left: 12px;")],-1)
printHtmlPart(31)
})
invokeTag('link','g',116,['class':("btn btn-primary pull-left"),'action':("edit"),'resource':(nbaUserInstance)],3)
printHtmlPart(32)
invokeTag('actionSubmit','g',120,['class':("btn btn-primary pull-left"),'action':("delete"),'value':(message(code: 'default.button.delete.label', default: 'Delete')),'onclick':("return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');"),'style':(" margin-left: 12px;")],-1)
printHtmlPart(33)
invokeTag('hiddenField','g',124,['name':("csrfPreventionSalt"),'value':(csrfPreventionSalt)],-1)
printHtmlPart(34)
})
invokeTag('form','g',125,['url':([resource:nbaUserInstance, action:'delete']),'method':("DELETE")],2)
printHtmlPart(35)
})
invokeTag('captureBody','sitemesh',129,[:],1)
printHtmlPart(36)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1543210560000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
