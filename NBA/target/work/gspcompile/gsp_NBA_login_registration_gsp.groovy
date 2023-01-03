import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_NBA_login_registration_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/login/_registration.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
expressionOut.print(session["csrfPreventionSalt"])
printHtmlPart(1)
expressionOut.print(session["csrfPreventionSalt"])
printHtmlPart(2)
createTagBody(1, {->
printHtmlPart(3)
expressionOut.print(createLink(controller:'register',action:'checkUserNameAvailability'))
printHtmlPart(4)
expressionOut.print(createLink(controller:'register',action:'userAvailability'))
printHtmlPart(5)
expressionOut.print(createLink(controller:'register',action:'emailAvailability'))
printHtmlPart(6)
})
invokeTag('javascript','g',152,[:],1)
printHtmlPart(7)
createTagBody(1, {->
printHtmlPart(8)
expressionOut.print(csrfPreventionSalt)
printHtmlPart(9)
invokeTag('textFieldRow','s2ui',164,['name':("name"),'req':("1"),'placeholder':("ex- Yatharth Gupta"),'class':(""),'labelCode':("user.name.label"),'bean':(command),'labelCodeDefault':("Name* :"),'value':(command?.name),'required':("required")],-1)
printHtmlPart(10)
invokeTag('textFieldRow','s2ui',178,['name':("username"),'data-toggle':("popover"),'id':("usenameCheck"),'placeholder':("Enter username (Minimum 4 alphabets or numbers)"),'data-trigger':("focus"),'data-placement':("top"),'req':("1"),'minlength':("1"),'_maxlength':("1"),'WhiteSpace':("1"),'class':(""),'data-content':("You can use only alphabets and number "),'labelCode':("user.username.label"),'bean':(command),'labelCodeDefault':("Username* :"),'maxlength':("20"),'value':(command?.username),'required':("required")],-1)
printHtmlPart(11)
invokeTag('passwordFieldRow','s2ui',191,['name':("password"),'data-toggle':("popover"),'data-trigger':("focus"),'data-placement':("top"),'class':("password"),'data-content':("Please enter minumum 4 alphabets, one special character(only !@#\$%^& are allowed),one number and one alphabet.Password minimum length is (Minimum 7- Maximum 16))"),'placeholder':("Enter password (for example- abcd@123)"),'labelCode':("user.password.label"),'bean':(command),'labelCodeDefault':("Password* :"),'value':(command?.password),'req':("1"),'whiteSpace':("1"),'Passfmt':("1"),'required':("required")],-1)
printHtmlPart(12)
invokeTag('passwordFieldRow','s2ui',204,['name':("password2"),'class':("leftpadding confirmpassword"),'data-toggle':("popover"),'data-placement':("top"),'data-trigger':("focus"),'placeholder':("Enter password (for example- abcd@123)"),'data-content':("""Please enter minumum 4 alphabets, one special character,one number and one character.
                                                      Password minimum length is (Minimum 7- Maximum 16))"""),'req':("1"),'labelCode':("user.password2.label"),'bean':(command),'labelCodeDefault':("Confirm Password* :"),'value':(command?.password2),'required':("required")],-1)
printHtmlPart(13)
invokeTag('textFieldRow','s2ui',212,['name':("email"),'req':("1"),'email':("1"),'placeholder':("Enter email (ex-abc@gmail.com)"),'id':("emailField"),'labelCode':("user.email.label"),'class':("bold "),'bean':(command),'labelCodeDefault':("Email* :"),'value':(command?.email),'required':("required")],-1)
printHtmlPart(14)
invokeTag('textFieldRow','s2ui',222,['name':("dateOfBirth"),'placeholder':("Enter date (ex-dd/MM/yyyy)"),'data-placement':("top"),'data-toggle':("popover"),'id':("datetimepicker"),'req':("1"),'dob':("1"),'labelCode':("user.dateOfBirth.label"),'class':("  bold"),'bean':(command),'labelCodeDefault':("Date of Birth* :"),'value':(command?.dateOfBirth),'required':("required")],-1)
printHtmlPart(13)
invokeTag('textFieldRow','s2ui',232,['name':("mobile"),'placeholder':("Enter mobile (ex-9999999999)"),'id':("mobileField"),'data-placement':("top"),'data-toggle':("popover"),'mob':("1"),'data-trigger':("focus"),'data-content':("Enter mobile number"),'labelCode':("user.mobile.label"),'class':("  bold"),'bean':(command),'labelCodeDefault':("Mobile No *:"),'maxlength':("15"),'value':(command?.mobile),'required':("required")],-1)
printHtmlPart(15)
invokeTag('textFieldRow','s2ui',243,['placeholder':("Enter number (ex-01141458598)"),'num':("1"),'data-placement':("top"),'data-toggle':("popover"),'data-trigger':("focus"),'req':("1"),'data-content':("Enter number (ex-0121313525)"),'name':("phone"),'labelCode':("user.phone.label"),'class':(" bold "),'bean':(command),'labelCodeDefault':("Phone No* :"),'maxlength':("10"),'value':(command?.phone),'required':("required")],-1)
printHtmlPart(16)
})
invokeTag('form','g',267,['class':("form-horizontal"),'role':("form"),'controller':("register"),'action':("register"),'name':("registerForm"),'autocomplete':("off")],1)
printHtmlPart(17)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1671522502871L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
