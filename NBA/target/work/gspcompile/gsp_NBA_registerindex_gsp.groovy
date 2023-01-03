import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_NBA_registerindex_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/register/index.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',4,['gsp_sm_xmlClosingForEmptyTag':("/"),'name':("layout"),'content':("main")],-1)
printHtmlPart(2)
createTagBody(2, {->
createTagBody(3, {->
invokeTag('message','g',6,['code':("spring.security.ui.register.title")],-1)
})
invokeTag('captureTitle','sitemesh',6,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',6,[:],2)
printHtmlPart(3)
expressionOut.print(session["csrfPreventionSalt"])
printHtmlPart(4)
expressionOut.print(session["csrfPreventionSalt"])
printHtmlPart(5)
})
invokeTag('captureHead','sitemesh',193,[:],1)
printHtmlPart(2)
createTagBody(1, {->
printHtmlPart(1)
createTagBody(2, {->
printHtmlPart(6)
expressionOut.print(createLink(controller:'register',action:'checkUserNameAvailability'))
printHtmlPart(7)
expressionOut.print(createLink(controller:'register',action:'userAvailability'))
printHtmlPart(8)
expressionOut.print(createLink(controller:'register',action:'emailAvailability'))
printHtmlPart(9)
})
invokeTag('javascript','g',200,[:],2)
printHtmlPart(10)
if(true && (flash.message)) {
printHtmlPart(11)
expressionOut.print(flash.message)
printHtmlPart(12)
}
printHtmlPart(13)
createTagBody(2, {->
printHtmlPart(14)
expressionOut.print(csrfPreventionSalt)
printHtmlPart(15)
if(true && (emailSent)) {
printHtmlPart(16)
invokeTag('message','g',224,['code':("spring.security.ui.register.sent")],-1)
printHtmlPart(16)
}
else {
printHtmlPart(17)
invokeTag('textFieldRow','s2ui',242,['name':("name"),'req':("1"),'placeholder':("Enter name (for example - Susheel Gupta) "),'labelCode':("user.name.label"),'class':("  bold "),'bean':(command),'labelCodeDefault':("Name* :"),'value':(command.name),'maxlength':("40")],-1)
printHtmlPart(18)
invokeTag('textFieldRow','s2ui',255,['name':("username"),'data-toggle':("popover"),'id':("usenameCheck"),'placeholder':("Enter username (Minimum 4 alphabets or numbers)"),'data-trigger':("focus"),'data-placement':("top"),'req':("1"),'minlength':("1"),'_maxlength':("1"),'WhiteSpace':("1"),'class':("width"),'data-content':("You can use only alphabets and number "),'labelCode':("user.username.label"),'bean':(command),'labelCodeDefault':("Username* :"),'maxlength':("20"),'value':(command.username)],-1)
printHtmlPart(19)
invokeTag('passwordFieldRow','s2ui',270,['name':("password"),'data-toggle':("popover"),'data-trigger':("focus"),'data-placement':("top"),'class':("password"),'data-content':("Please enter minumum 4 alphabets, one special character(only !@#\$%^& are allowed),one number and one alphabet.Password minimum length is (Minimum 7- Maximum 16))"),'placeholder':("Enter password (for example- abcd@123)"),'labelCode':("user.password.label"),'bean':(command),'labelCodeDefault':("Password* :"),'value':(command.password),'req':("1"),'whiteSpace':("1"),'Passfmt':("1")],-1)
printHtmlPart(20)
invokeTag('passwordFieldRow','s2ui',283,['name':("password2"),'class':("leftpadding confirmpassword"),'data-toggle':("popover"),'data-placement':("top"),'data-trigger':("focus"),'placeholder':("Enter password (for example- abcd@123)"),'data-content':("""Please enter minumum 4 alphabets, one special character,one number and one character.
Password minimum length is (Minimum 7- Maximum 16))"""),'req':("1"),'labelCode':("user.password2.label"),'bean':(command),'labelCodeDefault':("Confirm Password* :"),'value':(command.password2)],-1)
printHtmlPart(20)
invokeTag('textFieldRow','s2ui',293,['name':("email"),'req':("1"),'email':("1"),'placeholder':("Enter email (ex-abc@gmail.com)"),'id':("emailField"),'labelCode':("user.email.label"),'class':("bold "),'bean':(command),'labelCodeDefault':("Email* :"),'value':(command.email)],-1)
printHtmlPart(21)
invokeTag('textFieldRow','s2ui',305,['name':("dateOfBirth"),'placeholder':("Enter date (ex-01/01/2001)"),'data-placement':("top"),'data-toggle':("popover"),'id':("datePicker"),'req':("1"),'dob':("1"),'labelCode':("user.dateOfBirth.label"),'class':("  bold"),'bean':(command),'labelCodeDefault':("Date of Birth* :"),'value':(command.dateOfBirth)],-1)
printHtmlPart(20)
invokeTag('textFieldRow','s2ui',317,['name':("mobile"),'placeholder':("Enter mobile (ex-9999999999)"),'id':("mobileField"),'data-placement':("top"),'data-toggle':("popover"),'mob':("1"),'req':("1"),'data-trigger':("focus"),'data-content':("Enter mobile number"),'labelCode':("user.mobile.label"),'class':("  bold"),'bean':(command),'labelCodeDefault':("Mobile No *:"),'maxlength':("15"),'value':(command.mobile)],-1)
printHtmlPart(20)
invokeTag('textFieldRow','s2ui',328,['placeholder':("Enter number (ex-01141458598)"),'num':("1"),'data-placement':("top"),'data-toggle':("popover"),'data-trigger':("focus"),'req':("1"),'data-content':("Enter number (ex-0121313525)"),'name':("phone"),'labelCode':("user.phone.label"),'class':(" bold "),'bean':(command),'labelCodeDefault':("Phone No* :"),'maxlength':("10"),'value':(command.phone)],-1)
printHtmlPart(22)
createClosureForHtmlPart(23, 4)
invokeTag('link','g',350,['controller':("login"),'action':("auth"),'params':([csrfPreventionSalt:csrfPreventionSalt]),'class':("btn btn-primary")],4)
printHtmlPart(24)
}
printHtmlPart(13)
})
invokeTag('form','g',354,['class':("form-horizontal"),'role':("form"),'action':("register"),'name':("registerForm"),'autocomplete':("off")],2)
printHtmlPart(25)
createTagBody(2, {->
printHtmlPart(26)
expressionOut.print(secc)
printHtmlPart(27)
expressionOut.print(session["csrfPreventionSalt"])
printHtmlPart(28)
})
invokeTag('javascript','g',362,[:],2)
printHtmlPart(1)
})
invokeTag('captureBody','sitemesh',362,[:],1)
printHtmlPart(29)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1667295897873L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
