//import org.springframework.security.core.session.SessionRegistryImpl;
//import org.springframework.security.web.authentication.session.ConcurrentSessionControlAuthenticationStrategy;
//import org.springframework.security.web.authentication.session.SessionFixationProtectionStrategy;
//import org.springframework.security.web.authentication.session.RegisterSessionAuthenticationStrategy;
//import org.springframework.security.web.authentication.session.CompositeSessionAuthenticationStrategy;
//import com.nba.constant.CustomSessionLogoutHandler
//
//
// Place your Spring DSL code here
beans = {
//
//sessionRegistry(SessionRegistryImpl)
//
//customSessionLogoutHandler(CustomSessionLogoutHandler,ref('sessionRegistry')    )
//
//concurrentSessionControlAuthenticationStrategy(ConcurrentSessionControlAuthenticationStrategy,ref('sessionRegistry')){
//    exceptionIfMaximumExceeded = true
//    maximumSessions = 1
//}
//
//sessionFixationProtectionStrategy(SessionFixationProtectionStrategy){
//    migrateSessionAttributes = true
//    alwaysCreateSession = true
//}
//registerSessionAuthenticationStrategy(RegisterSessionAuthenticationStrategy,ref('sessionRegistry'))
//
//sessionAuthenticationStrategy(CompositeSessionAuthenticationStrategy,[ref('concurrentSessionControlAuthenticationStrategy'),ref('sessionFixationProtectionStrategy'),ref('registerSessionAuthenticationStrategy')])
//
}