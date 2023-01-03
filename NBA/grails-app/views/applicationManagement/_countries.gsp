<script type="text/javascript">
function updateCountryCodes(e){

	//alert("22222222222222");
	$('#statesdivD').removeAttr('name');
//var code = $(e).val();
//$("#statesdivDef").hide();
e.data.split('=')[1]
var dataElement = e.data? e.data.split('&')[0]:"No value"
	var countryId = dataElement? dataElement.split('=')[1]:"No value"
	$.ajax({
		type : "POST",
		url : fetchCodes,
		data : {
			countryId : countryId,
			csrfPreventionSalt : csrfPreventionSalt
		},
		success : function(result) {
			$('#mobileCode').val('');
			$('#mobileCode').val(result.phonecode);
			$('#PhoneCode').val('');
			$('#PhoneCode').val(result.phonecode);
			$('#countryPhoneCode').val('');
			$('#countryPhoneCode').val(result.phonecode);
			

		},
		error : function() {
			//alert("An error has (Himanshu jain) occured!!!");
		}

	});	
	}
</script>
<g:javascript>
  var fetchCodes = "${createLink(controller:'applicationManagement',action:'fetchMobileCode')}"
  var csrfPreventionSalt = "${csrfPreventionSalt}"
  </g:javascript>
 <g:select name="countryId" from="${listOfCountries}" optionKey="id"
	optionValue="country" value="${individualProfile?.country?.id}" req1="1"
	class="width controlclass1 country" noSelection="['':'-Select-']" id="nonIndianCountry"
		  onchange="${remoteFunction(controller: 'applicationManagement', action: 'fetchStates',
				  params: "'countryId='+this.value+'&csrfPreventionSalt=${csrfPreventionSalt}'",
				  update: 'updateStates',onComplete: 'updateCountryCodes(this)')}"/>

