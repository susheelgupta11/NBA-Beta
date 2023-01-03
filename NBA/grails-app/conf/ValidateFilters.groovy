import com.google.common.cache.Cache
import java.security.InvalidKeyException
import java.security.Key
import java.security.MessageDigest
import java.security.NoSuchAlgorithmException
import javax.crypto.BadPaddingException
import javax.crypto.Cipher
import javax.crypto.IllegalBlockSizeException
import javax.crypto.NoSuchPaddingException
import javax.crypto.spec.IvParameterSpec
import javax.crypto.spec.SecretKeySpec
import java.nio.charset.StandardCharsets
import java.security.DigestException
import java.security.spec.InvalidKeySpecException
import javax.servlet.http.Cookie
import javax.servlet.http.HttpSession


class ValidateFilters {


	def springSecurityService
	def filters = {


		all(controller: '*', action: '*') {
			before = {
				def sec
				println "...........................................inside ValidateFilters"
				def secc = session.getAttribute("secret");
				if(secc)
					sec = secc?.substring(14, 19).reverse()

				//				println "sec is ---"+sec
				String controller = params.controller
				String action = params.action
				def method = request.method
				def currentUser = springSecurityService.currentUser
				def userId = currentUser?.id?.toString()
//				println '*#*##*#*##*#*#*#**#*#*#**#**#*#*#*#**#*#**#*#*#*#**#*#*#**#**#*#**#*#**#*#**#*#* ' + controller
//				println '*#*##*#*##*#*#*#**#*#*#**#**#*#*#*#**#*#**#*#*#*#**#*#*#**#**#*#**#*#**#*#**#*#* ' + action
				
				
				if (controller && (controller?.equalsIgnoreCase('login') || controller?.equalsIgnoreCase('applicationManagement') || action?.equalsIgnoreCase('selectIndividualOrCompany') || (controller?.equalsIgnoreCase('register') && action?.equalsIgnoreCase('resetPassword')) ||
					controller?.equalsIgnoreCase('simpleCaptcha') || controller?.equalsIgnoreCase('assets') || (controller?.equalsIgnoreCase('register') && action?.equalsIgnoreCase('index'))
					|| action?.equalsIgnoreCase('verifyRegistration') || (controller?.equalsIgnoreCase('register') && action?.equalsIgnoreCase('forgotPassword'))  ||
	//				|| action?.equalsIgnoreCase('verifyRegistration') || (controller?.equalsIgnoreCase('register')) || (controller?.equalsIgnoreCase('loggedInAs')) ||
					  (controller?.equalsIgnoreCase('manageContent')) && action?.equalsIgnoreCase('adminEdits') || (controller?.equalsIgnoreCase('register') && action?.equalsIgnoreCase('changePassword'))
					 || (controller?.equalsIgnoreCase('register') && action?.equalsIgnoreCase('userDetail')) || (controller?.equalsIgnoreCase('register') && action?.equalsIgnoreCase('howToApply'))
					 || (controller?.equalsIgnoreCase('register') && action?.equalsIgnoreCase('forgotUsername')) || (controller?.equalsIgnoreCase('register') && action?.equalsIgnoreCase('faq'))
					 || (controller?.equalsIgnoreCase('register') && action?.equalsIgnoreCase('knowYourFormPart1')) || (controller?.equalsIgnoreCase('loggedInAs')) 
					 || (controller?.equalsIgnoreCase('dashboard')) || (controller?.equalsIgnoreCase('checklist'))
					 || (controller?.equalsIgnoreCase('SetMstrData')) || (controller?.equalsIgnoreCase('nbaUser'))|| (controller?.equalsIgnoreCase('ManualUpload'))
				     || (controller?.equalsIgnoreCase('FileMovments')) || (controller?.equalsIgnoreCase('versionManager')) || (controller?.equalsIgnoreCase('IrccApiRequest'))
				     || (controller?.equalsIgnoreCase('Agenda')) || (controller?.equalsIgnoreCase('PeriodicReport')) || (controller?.equalsIgnoreCase('sbbConsent')) || (controller?.equalsIgnoreCase('ExpertCommittee'))
					 || (controller?.equalsIgnoreCase('BenefitSharing'))|| (controller?.equalsIgnoreCase('LetterCommunication'))|| action?.equalsIgnoreCase('getSbbEmailId')|| (controller?.equalsIgnoreCase('SBB'))
					 || (controller?.equalsIgnoreCase('Applicant'))|| (controller?.equalsIgnoreCase('GraphicalReport')) ))
				
				
				 {


					if(controller?.equalsIgnoreCase('register') && action?.equalsIgnoreCase('changePassword')){
//						println "insideeeeeeeeeeeeeeeeeeeeeee"
						return
					}

					String tokenid = request.cookies.find { 'tokenid' == it.name }?.value
//				println "#####idddddddddddddddd" + tokenid
					HttpSession session = request.getSession(true)
					String random=(String)session.getAttribute("token")


					//	if (userId && !userId?.equalsIgnoreCase(id)) {
					if (random && !random?.equalsIgnoreCase(tokenid)) {
						println "fail *****************"
						flash.message = " Inform a scary sysadmin ASAP."

						redirect(controller: 'login', action: 'error')
					}


					if (params.j_password && params.j_password != '') {
						println "###############track .........2........... " + params.j_password
						String secret = (params.j_password)?.substring(0,5)
						//						String encrypetedPassWithSalt = (params.j_password)?.substring(5)

						String encrypetedPassWithSalt = params.j_password
						println "secret  " + secret + "--withoutSecret 2 "+encrypetedPassWithSalt
						//def encrypetedPassWithoutSalt = encrypetedPassWithSalt.replace(session["csrfPreventionSalt"], "")
						def encrypetedPassWithoutSalt = encrypetedPassWithSalt.replace(session["csrfPreventionSalt"], "")

						println "encrypetedPassWithoutSalt " + encrypetedPassWithoutSalt
						if(encrypetedPassWithoutSalt.substring(encrypetedPassWithoutSalt.length()-6) == params?.str)
						{
							params.j_password = dcryptPass(encrypetedPassWithoutSalt, sec)
						}
						else{
							return
						}
						//println "params.j_password(((((" + params.j_password
						println "###############track .........3..........."
					}
//					println "InsiDE IF bloCk "


				}
				else if(controller && (controller?.equalsIgnoreCase('masterData'))){
					return
				}
				else if((controller && controller?.equalsIgnoreCase('testData')) && (action && action?.equalsIgnoreCase('uploadDocs'))){
					return
				}
				else {


//					println "###############track .........4..........."
					String salt
					if(params.csrfPreventionSalt){
						salt = params.csrfPreventionSalt
					}
					else{
						//salt = session["csrfPreventionSalt"]
						//salt = request.getAttribute("csrfPreventionSalt")
					}



//					System.out.println("controller ====" + controller);
					// Validate that the salt is in the cache
					Cache<String, Boolean> csrfPreventionSaltCache = (Cache<String, Boolean>) session["csrfPreventionSaltCache"]

//					println "###############track .........5........... "+csrfPreventionSaltCache

//					println "###############track .........SALT........... "+salt

					//test for CSRF salt......................................
					try {
						if (csrfPreventionSaltCache != null && csrfPreventionSaltCache.getIfPresent(salt) != null) {
							// If the salt is in the cache, we move on
//							System.out.println("salt is in the cache " + salt);
						} else {
							flash.message = "Sorry! Session has expired."
//							println"inside else of csrf test"
							redirect(controller: 'login', action: 'auth')
							//redirect(controller: 'logout', action: 'index')
							return false
						}
					}
					catch (Exception e) {
//						println("Exception:  " + e.message)
						flash.message = "Sorry! Session has expired."
						//						flash.message = "Potential CSRF detected!! Inform a scary sysadmin ASAP."
						redirect(controller: 'login', action: 'auth')
						return false
					}

					if (params.password && params.password != '') {
						println "###############track .........6..........."
						String encrypetedPassWithSalt = params.password
						def encrypetedPassWithoutSalt = encrypetedPassWithSalt.replace(session["csrfPreventionSalt"], "")
						println "pasword..........................." + params.password
						params.password = dcryptPass(encrypetedPassWithoutSalt,sec)
						println "pasword..........................." + params.password
						println params.password
					}

					if (params.password2 && params.password2 != '') {
						println "###############track .........7..........."
						String encrypetedPassWithSalt = params.password2
						def encrypetedPassWithoutSalt = encrypetedPassWithSalt.replace(session["csrfPreventionSalt"], "")
						params.password2 = dcryptPass(encrypetedPassWithoutSalt,sec)
						println "pasword..........................." + params.password2
						println params.password2
					}

					if (params.newPassword && params.newPassword != '') {
						println "###############track .........8..........."
						String encrypetedPassWithSalt = params.newPassword
						def encrypetedPassWithoutSalt = encrypetedPassWithSalt.replace(session["csrfPreventionSalt"], "")
						println "## ============== "
						params.newPassword = dcryptPass(encrypetedPassWithoutSalt,sec)
						println "** ============== "
						println "pasword.................... ......."
						println params.newPassword
						println "==========================================## " + session["csrfPreventionSalt"]
					}

					if (params.confirmPassword && params.confirmPassword != '') {
						println "###############track .........9..........."
						String encrypetedPassWithSalt = params.confirmPassword
						def encrypetedPassWithoutSalt = encrypetedPassWithSalt.replace(session["csrfPreventionSalt"], "")
						params.confirmPassword = dcryptPass(encrypetedPassWithoutSalt,sec)
						println "pasword..........................."
						println params.confirmPassword
					}

					if (params.oldPassword && params.oldPassword != '') {
						println "###############track .........10..........."
						String encrypetedPassWithSalt = params.oldPassword
						def encrypetedPassWithoutSalt = encrypetedPassWithSalt.replace(session["csrfPreventionSalt"], "")
						params.oldPassword = dcryptPass(encrypetedPassWithoutSalt,sec)
						println "pasword..........................."
						println params.oldPassword
					}

					if (params.oldPwd && params.oldPwd != '') {
						println "###############track .........10..........."
						println "csrf session---- "+session["csrfPreventionSalt"]
						println "params.oldPwd---- "+params.oldPwd
						String encrypetedPassWithSalt = params.oldPwd
						//						def encrypetedPassWithoutSalt = encrypetedPassWithSalt.replace(session["csrfPreventionSalt"], "")
						def encrypetedPassWithoutSalt = encrypetedPassWithSalt.replace(params?.csrfPreventionSalt, "")
						println "encrypetedPassWithoutSalt = "+encrypetedPassWithoutSalt
						println "encrypetedPassWithSalt = "+encrypetedPassWithSalt
						params.oldPwd = dcryptPass(encrypetedPassWithoutSalt,sec)
						println "pasword..........................."
						println params.oldPwd
					}
					if (params.newPwd && params.newPwd != '') {
						println "###############track .........10..........."
						String encrypetedPassWithSalt = params.newPwd
						println " encrypetedPassWithSalt !!!!!!!!!!!!!!!!!!!!!"+encrypetedPassWithSalt
						//						def encrypetedPassWithoutSalt = encrypetedPassWithSalt.replace(session["csrfPreventionSalt"], "")
						def encrypetedPassWithoutSalt = encrypetedPassWithSalt.replace(params?.csrfPreventionSalt, "")
						println "encrypetedPassWithoutSalt @@@@@@@@@@@@@@@"+encrypetedPassWithoutSalt
						params.newPwd = dcryptPass(encrypetedPassWithoutSalt,sec)
						println "pasword..........................."
						println params.newPwd
					}
					if (params.confirmNewPwd && params.confirmNewPwd != '') {
						println "###############track .........10..........."
						String encrypetedPassWithSalt = params.confirmNewPwd
						//						def encrypetedPassWithoutSalt = encrypetedPassWithSalt.replace(session["csrfPreventionSalt"], "")
						def encrypetedPassWithoutSalt = encrypetedPassWithSalt.replace(params?.csrfPreventionSalt, "")
						params.confirmNewPwd = dcryptPass(encrypetedPassWithoutSalt,sec)
						println "pasword..........................."
						println params.confirmNewPwd
					}

					return
				}
			}
			after = {
				//Map model ->

				response.setHeader('Cache-Control', 'no-cache')
			}
			afterView = { Exception e ->

			}
		}
	}

	/*String dcryptPass(String pass) {
	 println "pass = "+pass
	 String[] pass1 = pass.split('ZZZaAaYx')
	 def decryptedString = ''
	 for (def i = 0; i < pass1.size(); i++) {
	 if (pass1[i]) {
	 //println pass1[i]
	 def decryptedText = pass1[i].toInteger() + (int) ('A')
	 decryptedString += (char) decryptedText
	 println "decryptedString == "+decryptedString
	 }
	 }
	 return decryptedString.toString();
	 }*/

	public String dcryptPass(String pass, String sec)
	throws NoSuchPaddingException, BadPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, InvalidKeyException {

		println "pass is:"+pass

		//		String secret = pass.substring(0,5)
		//		String secret = "ZZZaAaYx";
		String secret = sec
		//		String cipherText = pass?.substring(5);
		String cipherText = pass

		byte[] cipherData = Base64.getDecoder().decode(cipherText);
		byte[] saltData = Arrays.copyOfRange(cipherData, 8, 16);
		MessageDigest md5 = MessageDigest.getInstance("MD5");
		final byte[][] keyAndIV = generateKeyAndIV(32, 16, 1, saltData, secret.getBytes(StandardCharsets.UTF_8), md5);
		SecretKeySpec key = new SecretKeySpec(keyAndIV[0], "AES");
		IvParameterSpec iv = new IvParameterSpec(keyAndIV[1]);
		byte[] encrypted = Arrays.copyOfRange(cipherData, 16, cipherData.length);
		Cipher aesCBC = Cipher.getInstance("AES/CBC/PKCS5Padding");
		aesCBC.init(Cipher.DECRYPT_MODE, key, iv);
		byte[] decryptedData = aesCBC.doFinal(encrypted);
		String decryptedText = new String(decryptedData, StandardCharsets.UTF_8);

		//System.out.println("decryptedText--"+decryptedText);

		return decryptedText;
	}

	public static byte[][] generateKeyAndIV(int keyLength, int ivLength, int iterations, byte[] salt, byte[] password, MessageDigest md)
	throws InvalidKeySpecException, NoSuchAlgorithmException {

		int digestLength = md.getDigestLength();
		int requiredLength = (keyLength + ivLength + digestLength - 1) / digestLength * digestLength;
		byte[] generatedData = new byte[requiredLength];
		int generatedLength = 0;

		try {
			md.reset();

			// Repeat process until sufficient data has been generated
			while (generatedLength < keyLength + ivLength) {

				// Digest data (last digest if available, password data, salt if available)
				if (generatedLength > 0)
					md.update(generatedData, generatedLength - digestLength, digestLength);
				md.update(password);
				if (salt != null)
					md.update(salt, 0, 8);
				md.digest(generatedData, generatedLength, digestLength);

				// additional rounds
				for (int i = 1; i < iterations; i++) {
					md.update(generatedData, generatedLength, digestLength);
					md.digest(generatedData, generatedLength, digestLength);
				}

				generatedLength += digestLength;
			}

			// Copy key and IV into separate byte arrays
			byte[][] result = new byte[2][];
			result[0] = Arrays.copyOfRange(generatedData, 0, keyLength);
			if (ivLength > 0)
				result[1] = Arrays.copyOfRange(generatedData, keyLength, keyLength + ivLength);
			return result;

		}
		catch (DigestException e) {
			throw new RuntimeException(e);

		} finally {
			// Clean out temporary data
			Arrays.fill(generatedData, (byte)0);
		}
	}


}
