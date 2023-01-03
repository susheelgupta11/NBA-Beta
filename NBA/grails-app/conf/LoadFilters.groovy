import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import java.security.SecureRandom;
import org.apache.commons.lang.RandomStringUtils;
import java.util.concurrent.TimeUnit;

class LoadFilters {
	
	
		

	def filters = {
		all(controller: '*', action: '*') {
			before = {
				
				Cache<String, Boolean> csrfPreventionSaltCache = (Cache<String, Boolean>) session["csrfPreventionSaltCache"]
				String salt = RandomStringUtils.random(32, 0, 0, true, true, null, new SecureRandom());
				// String uri = request.requestURI
				//String csrfToken = session["csrfPreventionSalt"];
				/*Boolean check = false
				if (uri.contains('dispatch') || uri.contains('login'))
					check = true*/

//                if (!check) {
//				String controller = params.controller
//				String action = params.action
//				println "inside load filter......................................................"
//				println "controllercontroller..................."+controller
//				println "actionaction..........................."+action
				
				
				if (csrfPreventionSaltCache == null) {
					
//				if( (controller == 'login') || (controller == 'login' && action == 'auth' ) ||  (controller == 'login' && action == 'validateUser' ) ){
//					println "inside if login auth validateuse"
//                    csrfPreventionSaltCache = CacheBuilder.newBuilder()
//                            .maximumSize(5000)
//                            .expireAfterWrite(5, TimeUnit.SECONDS)
//                            .build();
//
//					println "inside IF of load filter......................................................"
//
//                    session["csrfPreventionSaltCache"] = csrfPreventionSaltCache
//                    session["csrfPreventionSalt"] = salt
//
//                }
//				else{
//					println "inside else"
					csrfPreventionSaltCache = CacheBuilder.newBuilder()
							.maximumSize(5000)
							.expireAfterWrite(20, TimeUnit.MINUTES)
							.build();

//					println "inside IF of load filter......................................................"

					session["csrfPreventionSaltCache"] = csrfPreventionSaltCache
					session["csrfPreventionSalt"] = salt
					
					
//                }
					
				}
			  //  csrfPreventionSaltCache.invalidateAll()
				//session["csrfPreventionSalt"] = salt
				csrfPreventionSaltCache.put(salt, Boolean.TRUE);
				request.setAttribute("csrfPreventionSalt", salt);
				request.setAttribute("csrfPreventionSaltCache", salt);
//                }
				// Generate the salt and store it in the users cache
//				System.out.println("Load Salt.....@@@@@..." + csrfPreventionSaltCache);
				// Add the salt to the current request so it can be used
				// by the page rendered in this request

//				println "testForCSRF................"+salt
				
				return
			}
			after = { Map model ->
//				println "afterrrrrr"

			}
			afterView = { Exception e ->

			}
		}
	}

}
