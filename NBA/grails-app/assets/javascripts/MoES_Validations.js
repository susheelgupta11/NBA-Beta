/* Validation functions */

function GetMessage(m) {
	return "<div msg='1' class='tooltip_outer col-sm-12 less-padding'><div class='arrow-left'></div><div class='tool_tip'>"
			+ m + "</div></div>";
}
function wordCountOnEditMode1(maxWord, spanid) {
	var currentWordCount = 0;
	var wordLeft;
	$('.jqte_editor').each(
			function() {

				var controlNo = $(this).next().find("textarea").attr(
						"controlcounter");

				var controlText = $(this).html().replace(/&nbsp;/g, '');
				var c = wordCount(controlText);
				var currentWordCount = c.words;
				if (currentWordCount > maxWord) {
					var extraWords = currentWordCount - maxWord;
					var editorContent = controlText.substring(0,
							$(this).html().length - extraWords);
					$(this).html(editorContent);
					wordLeft = 0;
				} else {
					wordLeft = maxWord - parseInt(currentWordCount);
				}
				$(spanid).text(wordLeft);

			});
}

function decimalonly(ob) {
	var validChars = /[^0-9][^.][^0-9]/gi
	if (validChars.test(ob.value)) {
		ob.value = ob.value.substring(0, ob.value.length - 1);
		ob.focus();
	}
}

function BindRemoveError2() {
	$("input:text").each(function() {
		var o = $(this);
		o.on("click", function() {
			o.next('.tooltip_outer').remove();
			o.removeClass("error1");
		});
	});

}

function ValidUpload() {
	$("input:submit")
			.click(
					function(e) {
						var btnid = $(this).attr("id");
						var uploadClass = "." + btnid;
						$(uploadClass)
								.each(
										function() {
											var o = $(this);
											var flag = 0;
											var value = (o).val();
											var exten = value.split('.').pop();
											if (value != "") {
												if (o.attr("pdf2")
														&& ((exten != "pdf") && (exten != "PDF"))) {
													BindRemoveError(o,
															"Upload only pdf");
													e.preventDefault();
													return true;
												} else {

													var size = (o)[0].files[0].size;
													if (o.attr("mb5")
															&& ((size <= 5245880))) {
														return true;
													} else {
														flag = 1;
														if (!((o.attr("mb10") == undefined))) {
															if (o.attr("mb10")
																	&& (size <= 10485760)) {
																return true;
															} else {
																flag = 2;
																e
																		.preventDefault();
															}
														} else {
															if (flag == 1) {
																BindRemoveError(
																		o,
																		"Maximum 5 MB file is valid");
																e
																		.preventDefault();
															} else {
																BindRemoveError(
																		o,
																		"Maximum 10 MB file is valid");
																e
																		.preventDefault();
															}
														}
													}

												}
											} else {
												if (o.attr("req2")
														&& $(o).val() == "") {
													BindRemoveError(o,
															"Required");
													e.preventDefault();
													return true;
												}
											}
											return false;
										});

					});
}

function BindRemoveError(o, m) {
	o.addClass("error1");
	// o.focus();
	o.after(GetMessage(m)).show("slow");
	o.on("focusin", function() {
		var s = o.next().next().attr("msg");
		var j = o.next().attr("msg");
		if ((s != undefined)) {
			o.next().next('.tooltip_outer').remove();
			o.removeClass("error1");
		} else if ((j != undefined)) {
			o.next('.tooltip_outer').remove();
			o.removeClass("error1");
		} else {
		}
	});
	// o.on("blur", function() {
	// o.next('.tooltip_outer').hide();
	// o.removeClass("error1");
	// });
}

function BindValidation(txtclass, btnclass) {

	$(document)
			.on(
					"click",
					"input:submit." + btnclass,
					function(e) {
						// alert("hi");
						var IsValid = true;
						if ($(this).attr("disVal")) {
							form_original_data = $("form").serialize();
							return true;
						}
						$("input:text." + txtclass)
								.each(
										function() {
											var o = $(this);
											if (IsValid) {
												if (o.attr("req1")
														&& $.trim(o.val()) == '') {
													e.preventDefault();
													BindRemoveError(o,
															"Required field");
													// IsValid = false;
													return IsValid;
												}
											}
											if (IsValid) {
												if (o.attr("mob1")
														&& (o.val().length > 15)) {
													e.preventDefault();
													BindRemoveError(o,
															"Should be of 15 digits");
													// IsValid = false;
													return IsValid;
												}
											}
											if (IsValid) {
												var validChars = /^[a-zA-Z\s]*$/;
												if (o.attr("alp1")
														&& !(validChars.test(o
																.val()))) {
													e.preventDefault();
													BindRemoveError(o,
															" enter only alphabets.");
													// IsValid = false;
													return IsValid;
												}
											}
											if (IsValid) {
												var validChars = /^[1-9]\d*(\.\d+)?$/;
												var value = $(o).val();
												if (value != "") {
													if (o.attr("dec1")
															&& !(validChars
																	.test(o
																			.val()))) {
														e.preventDefault();
														BindRemoveError(o,
																" Enter only number.");
														// IsValid = false;
														return IsValid;
													}
												}
											}
											if (IsValid) {
												
												var value =$.trim($(o).val()).split(' ').length; 												
												
												if (value > 50) {
													if (o.attr("maxword50")
															&& !(validChars
																	.test(o
																			.val()))) {
														e.preventDefault();
														BindRemoveError(o,
																"Only 50 words allowed");
														// IsValid = false;
														return IsValid;
													}
												}
											}
											
												


											if (IsValid) {
												var validChars = /^(0[1-9]|1\d|2\d|3[01])\/(0[1-9]|1[0-2])\/(19|20)\d{2}$/
												var value = $(o).val();
												if (value != "") {
													if (o.attr("dateformat1")
															&& !(validChars
																	.test(o
																			.val()))) {
														e.preventDefault();
														BindRemoveError(o,
																"Invalid Date formate (dd/mm/yyyy");
														// IsValid = false;
														return IsValid;
													}
												}
											}
											if (IsValid) {
												var validChars = /^[0-9]*$/;
												if (o.attr("num1")
														&& !(validChars.test(o
																.val()))) {
													e.preventDefault();
													BindRemoveError(o,
															" Enter only number.");
													// IsValid = false;
													return IsValid;
												}
											}
											if (IsValid) {
												var filter = /^([\w-\.]+)@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.)|(([\w-]+\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\]?)$/;
												if (o.attr("email1")
														&& !(filter.test(o
																.val()))) {
													e.preventDefault();
													BindRemoveError(o,
															"Not a valid mail Id");
													// IsValid = false;
													return IsValid;
												}
											}
											return IsValid;
										});
						
						$("textarea." + txtclass)
						.each(
								function() {
									var o = $(this);
									if (IsValid) {
										if (o.attr("txtreq1")
												&& $.trim(o.val()) == '') {
											e.preventDefault();
											BindRemoveError(o,
													"Required field");
											// IsValid = false;
											return IsValid;
										}
									}
									
									if (IsValid) {												
										var value =$.trim($(o).val()).split(' ').length; 												
										
										if (value > 500) {
											if (o.attr("txtmaxword100")) {
												e.preventDefault();
												BindRemoveError(o,
														"Only 500 words allowed");
												//alert("Only 100 words allowed");
												// IsValid = false;
												return IsValid;
											}
										}
									}
									if (IsValid) {												
										var value =$.trim($(o).val()).split(' ').length; 												
										
										if (value > 500) {
											if (o.attr("txtmaxword200")) {
												e.preventDefault();
												BindRemoveError(o,
														"Only 500 words allowed");
												// IsValid = false;
												return IsValid;
											}
										}
									}
									return IsValid;
								});
						$("input:password." + txtclass)
								.each(
										function() {
											var o = $(this);
											if (IsValid) {
												if (o.attr("passreq1")
														&& $.trim(o.val()) == '') {
													e.preventDefault();
													BindRemoveError(o,
															"Required field");
													IsValid = false;
													// return IsValid;
												}

											}
											if (IsValid) {
												if (o.attr("pass1")
														&& (o.val().length < 6 || o
																.val().length > 15)) {
													e.preventDefault();
													BindRemoveError(o,
															"Must be between 6 to 15");
													IsValid = false;
													// return IsValid;
												}
											}
										});
						$("select." + txtclass)
								.each(
										function() {
											var o = $(this);
											if (IsValid) {
												if (o.attr("req1")
														&& $('option:selected',
																o).index() == 0) {
													e.preventDefault();
													BindRemoveError(o,
															"Required field");
													// IsValid = false;
													return IsValid;
												}
											}
										});
						var flag=true;
						$("input[type='checkbox']."+txtclass)
						.each(
								function() {
									var o = $(this);
									
									if (IsValid) {
										if (o.attr("chkreq1")&& ($('input[type=checkbox]:checked').length<=0)) {
											e.preventDefault();
											if(flag==true)
												{
											alert("Please check at least one checkbox");
											flag=false;
											e.preventDefault();
												}
											else
												{
												e.preventDefault();
												}
											/*BindRemoveError(o,
													"Required field");*/
											// IsValid = false;
											return IsValid;
										}
									}
								
								});
						
						
						
						
						$("input:file." + txtclass)
								.each(
										function() {
											var o = $(this);
											if (IsValid) {
												if (o.attr("req1")
														&& $(o).val() == "") {
													e.preventDefault();
													BindRemoveError(o,
															"Required field");
													// IsValid = false;
													return IsValid;
												}
											}

											if (IsValid) {
												var val = $(o).val();
												var ext = val.split('.').pop();
												var flag = 0;

												if ((o.attr("pdf1"))
														&& ((ext != "pdf") && (ext != "PDF"))) {
													e.preventDefault();
													BindRemoveError(o,
															"Upload only pdf");
													// IsValid = false;
													return IsValid;
												} else {

													var size = (o)[0].files[0].size;
													if (o.attr("mb5")
															&& ((size <= 5245880))) {
														return true;
													} else {
														flag = 1;
														if (!((o.attr("mb10") == undefined))) {
															if (o.attr("mb10")
																	&& (size <= 10485760)) {
																return true;
															} else {
																flag = 2;

															}
															if (flag == 1) {
																BindRemoveError(
																		o,
																		"Maximum 5 MB file is valid");
																e
																		.preventDefault();
															} else {
																BindRemoveError(
																		o,
																		"Maximum 10 MB PDF is valid");
																e
																		.preventDefault();
															}

														} else {
															// if (flag == 1) {
															// BindRemoveError(o,"Maximum
															// 5 MB file is
															// valid");
															// e.preventDefault();
															// } else {
															// BindRemoveError(o,"Maximum
															// 10 MB file is
															// valid");
															// e.preventDefault();
															// }
														}
													}

												}

											}

										});

						return IsValid;
					});
}



function checkFileUpload(fileUploadControl, event) {
	var val = $("#" + fileUploadControl).val();
	var o = $("#" + fileUploadControl);
	var flag = 0;
	var ext = val.split('.').pop();
	if ($("#" + fileUploadControl).val() == "") {
		event.preventDefault();
		BindRemoveError($("#" + fileUploadControl), "Please select the file.");
		return false;
	} else if ((ext != "pdf") && (ext != "PDF")) {
		event.preventDefault();
		BindRemoveError($("#" + fileUploadControl), "Upload only pdf");
		return false;
	} else {

		var size = (o)[0].files[0].size;
		if (o.attr("mb5") && ((size <= 5245880))) {
			return true;
		} else {
			flag = 1;
			if (!((o.attr("mb10") == undefined))) {
				if (o.attr("mb10") && (size <= 10485760)) {
					return true;
				} else {
					flag = 2;

				}
			} else {
				if (flag == 1) {
					BindRemoveError(o, "Maximum 5 MB file is valid");
					e.preventDefault();
				} else {
					BindRemoveError(o, "Maximum 10 MB PDF file is valid");
					e.preventDefault();
				}
			}
		}

	}
}

function BindValidationMethod() {
	$(document)
			.on(
					"click",
					"input:submit",
					function(e) {
						var IsValid = true;
						if ($(this).attr("disVal")) {
							form_original_data = $("form").serialize();
							return true;
						}
						$("input:text")
								.each(
										function(ex) {
											var o = $(this);
											if (IsValid) {
												if (o.attr("req")
														&& $.trim(o.val()) == '') {
													e.preventDefault();
													BindRemoveError(o,
															"Required field");
													// IsValid = false;
													return IsValid;
													// IsValid = true;
													// return IsValid;
												}
												// return true
											}
											if (IsValid) {
												if (o.attr("mob")
														&& (o.val().length > 15)) {
													e.preventDefault();
													BindRemoveError(o,
															"Should be of 15 digits");
													// IsValid = false;
													return IsValid;
												}
											}
											if (IsValid) {
												if (o.attr("minlength")
														&& (o.val().length < 5)) {
													e.preventDefault();
													BindRemoveError(o,
															"Minimum 5 character required");
													// IsValid = false;
													return IsValid;
												}
											}
											if (IsValid) {
												var whiteSpace = /\s/;
												if (o.attr("WhiteSpace")
														&& (whiteSpace.test(o
																.val()))) {
													e.preventDefault();
													BindRemoveError(o,
															"No space are allowed");
													// IsValid = false;
													return IsValid;
												}
											}

											if (IsValid) {
												if (o.attr("_maxlength")
														&& (o.val().length > 50)) {
													e.preventDefault();
													BindRemoveError(o,
															"Maximum 50 character required");
													// IsValid = false;
													return IsValid;
												}
											}

											if (IsValid) {
												var validChars = /^[a-zA-Z\s]*$/;
												if (o.attr("alp")
														&& !(validChars.test(o
																.val()))) {
													e.preventDefault();
													BindRemoveError(o,
															" Enter only alphabets.");
													// IsValid = false;
													return IsValid;
												}
											}

											if (IsValid) {
												var validChars = /^[0-9]*$/;
												if (o.attr("num")
														&& !(validChars.test(o
																.val()))) {
													e.preventDefault();
													BindRemoveError(o,
															" Enter only number.");
													// IsValid = false;
													return IsValid;
												}
											}

											if (IsValid) {
												var validChars = /^[1-9]\d*(\.\d+)?$/;
												if (o.attr("dec")
														&& !(validChars.test(o
																.val()))) {
													e.preventDefault();
													BindRemoveError(o,
															" Enter only number.");
													// IsValid = false;
													return IsValid;
												}
											}

											if (IsValid) {
												var validChars = /^(0[1-9]|1\d|2\d|3[01])\/(0[1-9]|1[0-2])\/(19|20)\d{2}$/
												if (o.attr("dateformat")
														&& !(validChars.test(o
																.val()))) {
													e.preventDefault();
													BindRemoveError(o,
															"Invalid Date formate (dd/mm/yyyy");
													// IsValid = false;
													return IsValid;
												}
											}

											if (IsValid) {
												var filter = /^([\w-\.]+)@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.)|(([\w-]+\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\]?)$/;
												if (o.attr("email")
														&& !(filter.test(o
																.val()))) {
													e.preventDefault();
													BindRemoveError(o,
															"Not a valid mail Id");
													// IsValid = false;
													return IsValid;
												}
											}
											return IsValid;
										});

						// Checkbox
						$("input:checkbox").each(function(ex) {
							var o = $(this);
							var len = $('input[class=check]:checked').length;
							if (IsValid) {
								if (len > 2) {
									e.preventDefault();
									BindRemoveError(o, "Required time field");
									// IsValid = false;
									return IsValid;
									// IsValid = true;
									// return IsValid;
								}
								// return true
							}

							return IsValid;
						});
						// checkbox

						// Time

						$("input.time").each(function(ex) {
							var o = $(this);
							if (IsValid) {
								if (o.attr("reqt") && $.trim(o.val()) == '') {
									e.preventDefault();
									BindRemoveError(o, "Required time field");
									// IsValid = false;
									return IsValid;
									// IsValid = true;
									// return IsValid;
								}
								// return true
							}

							return IsValid;
						});
						// Time

						$("input:password")
								.each(
										function() {
											var o = $(this);
											if (IsValid) {
												if (o.attr("req")
														&& $.trim(o.val()) == '') {
													e.preventDefault();
													BindRemoveError(o,
															"Required field");
													// IsValid = false;
													return IsValid;
												}

											}
											// if (IsValid) {
											// var validChars =
											// /^(?=.*\d)(?=.*[a-z])(?=.*[A-Z])[0-9a-zA-Z]{8}$/
											//									
											// ///^[a-zA-Z\s(0,3)][0-9\s][@!#$%^&*]*$/;
											// var value=o.val();
											// var
											// check=validChars.test(o.val());
											// if (o.attr("Passfmt") &&
											// !(validChars.test(o.val()))) {
											// e.preventDefault();
											// BindRemoveError(o,
											// " Minimum length 7
											// ex-(abcd@123).");
											// //IsValid = false;
											// return IsValid;
											// }
											// }
											if (IsValid) {
												var wh_Space = /\s/;
												if ((o.attr("whiteSpace"))
														&& (wh_Space.test(o
																.val()))) {
													e.preventDefault();
													BindRemoveError(o,
															"No space are allowed");
													// IsValid = false;
													return IsValid;
												}
											}

											if (IsValid) {
												if (o.attr("req")
														&& $.trim(o.val()) == '') {
													e.preventDefault();
													BindRemoveError(o,
															"Required field");
													// IsValid = false;
													return IsValid;
												}

											}

											if (IsValid) {
												if (o.attr("pass")
														&& (o.val().length < 6 || o
																.val().length > 15)) {
													e.preventDefault();
													BindRemoveError(o,
															"Must be between 6 to 15");
													// IsValid = false;
													return IsValid;
												}
											}
											return IsValid;
										});
						$("select").each(
								function() {
									var o = $(this);
									if (IsValid) {
										if (o.attr("req")
												&& $('option:selected', o)
														.index() == 0) {
											e.preventDefault();
											BindRemoveError(o,
													"Required    field");
											// IsValid = true;
											return IsValid;
										}
										// return true
									}

									return IsValid;

								});
						$("input:file")
								.each(
										function() {

											var o = $(this);
											if (IsValid) {
												if (o.attr("req")
														&& $(o).val() == "") {
													e.preventDefault();
													BindRemoveError(o,
															"Required field");
													// IsValid = false;
													return IsValid;
												}
											}

											if (IsValid) {
												var val = $(o).val();
												var ext = val.split('.').pop();

												if ((o.attr("pdf"))
														&& ((ext != "pdf") && (ext != "PDF"))) {
													e.preventDefault();
													BindRemoveError(o,
															"Upload only pdf");
													// IsValid = false;
													return IsValid;
												}
											}

											if (IsValid) {
												var val = $(o).val();
												if (val != "") {
													var ext = val.split('.')
															.pop();
													if ((o.attr("pdfValid"))
															&& ((ext != "pdf") && (ext != "PDF"))) {
														e.preventDefault();
														BindRemoveError(o,
																"Upload only pdf");
														// IsValid = false;
														return IsValid;
													} else {

														var size = (o)[0].files[0].size;
														if (o.attr("mb5")
																&& ((size <= 5245880))) {
															return true;
														} else {
															flag = 1;
															if (!((o
																	.attr("mb10") == undefined))) {
																if (o
																		.attr("mb10")
																		&& (size <= 10485760)) {
																	return true;
																} else {
																	flag = 2;
																	e
																			.preventDefault();
																}

																if (flag == 1) {
																	BindRemoveError(
																			o,
																			"Maximum 5 MB file is valid");
																	e
																			.preventDefault();
																} else {
																	BindRemoveError(
																			o,
																			"Maximum 10 MB file is valid");
																	e
																			.preventDefault();
																}

															} else {
																// if (flag ==
																// 1) {
																// BindRemoveError(o,"Maximum
																// 5 MB file is
																// valid");
																// e.preventDefault();
																// } else {
																// BindRemoveError(o,"Maximum
																// 10 MB file is
																// valid");
																// e.preventDefault();
																// }
															}
														}

													}

												}
												return IsValid;
											}

										});
						

						$("textarea")
								.each(
										function() {
											var o = $(this);
											if (IsValid) {
												if (o.attr("req")
														&& $.trim(o.val()) == '') {
													e.preventDefault();
													BindRemoveError(o,
															"Required field");
													// IsValid = false;
													return IsValid;
												}
											}
											if (IsValid) {
												if (o.attr("mob")
														&& (o.val().length > 15)) {
													e.preventDefault();
													BindRemoveError(o,
															"Should be of 15 digits");
													// IsValid = false;
													return IsValid;
												}
											}
											if (IsValid) {												
												var value =$.trim($(o).val()).split(' ').length; 												
												
												if (value > 500) {
													if (o.attr("txtmaxword100")) {
														e.preventDefault();
														BindRemoveError(o,
																"Only 500 words allowed");
														// IsValid = false;
														return IsValid;
													}
												}
											}
											return IsValid;
											
											
											if (IsValid) {
												var validChars = /^[a-zA-Z]*$/;
												if (o.attr("alp")
														&& !(validChars.test(o
																.val()))) {
													e.preventDefault();
													BindRemoveError(o,
															" Enter only alphabets.");
													// IsValid = false;
													return IsValid;
												}
											}

											if (IsValid) {
												var validChars = /^[0-9]*$/;
												if (o.attr("num")
														&& !(validChars.test(o
																.val()))) {
													e.preventDefault();
													BindRemoveError(o,
															" Enter only number.");
													// IsValid = false;
													return IsValid;
												}
											}

											if (IsValid) {
												var filter = /^([\w-\.]+)@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.)|(([\w-]+\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\]?)$/;
												if (o.attr("email")
														&& !(filter.test(o
																.val()))) {
													e.preventDefault();
													BindRemoveError(o,
															"Not a valid mail Id");
													// IsValid = false;
													return IsValid;
												}
											}
											return IsValid;
										});

						return IsValid;
					});
}

/* Validation functions */
/* Validate form State */

function HandleBackFunctionality() {
	if (window.history && window.history.pushState) {
		$(window)
				.on(
						'popstate',
						function(event) {
							var hashLocation = location.hash;
							var hashSplit = hashLocation.split("#!/");
							var hashName = hashSplit[1];

							if (hashName !== '') {
								var hash = window.location.hash;
								if (hash === '') {
									// if(${isProjectInViewMode == true} )
									// {
									if ($(this).closest('form').data('changed')) {
										var discard = confirm("Do you want to save all unsaved changes?");
										if (discard) {
											console.log(discard
													+ " Discard changes.")
										} else {
											return false;
										}
									}
									// }
								}
							}

						});

		window.history.pushState('forward', null, '');
	}
}
/* Validate form State */

/* Validate Password formate */
var specialChars = "<>@!#$%^&*()_+[]{}?:;|'\"\\,./~`-=";
var check = function(string) {
	var isSecial = false;
	var isNumber = false;
	var isAlphabet = false;
	var isUpperAlphabet = false;
	for (i = 0; i < specialChars.length; i++) {
		if (string.indexOf(specialChars[i]) > -1) {
			isSecial = true;
		}
	}
	if (/\d/.test(string))
		isNumber = true;
	if (/[a-z]/.test(string))
		isAlphabet = true;
	// if (/[A-Z]/.test(string))
	// isUpperAlphabet = true;
	if (isSecial == true && isNumber == true && isAlphabet == true) {
		return true;
	}
	return false;
}

function validateSpecialCharacters(text) {
	var isSecial = false;
	for (i = 0; i < specialChars.length; i++) {
		if (text.indexOf(specialChars[i]) > -1) {
			isSecial = true;
		}
	}
	if (isSecial) {
		return true;
	} else {
		return false;
	}
}

/* Validate Password formate */
$(document).ready(function() {
	
//	$(".confirmpassword").focusin(function(){
//		var o=$(this);
//		var ss=$(this).next().attr("msg");
//		if(ss!=null)
//			{
//			o.next('.tooltip_outer').remove();
//			o.removeClass("error1");
//			
//			}
//		else if(o.next().next().attr("msg"))
//			{
//			o.next().next('.tooltip_outer').remove();
//			o.removeClass("error1");			
//			}
//		else
//			{
//			
//			}
//	});
	
});

/*$(document).ready(function() {
	/* Validate form State */
	/*removeActive();*/
	/*$('input, textarea, select').change(function() {
		$(this).closest('form').data('changed', true);
	});
	$(':password').change(function(e) {
		var passwordText = $(this).val();
		if (!check(passwordText)) {
			e.preventDefault();
			// $(this).val('');
			$(this).focus();
		}
	});

	BindValidationMethod();
});
	// BindRemoveError2();

	// $('input[num="1"]').on("keyup", function() {
	// $(this).next('.tooltip_outer').hide();
	// numericsonly(this); // definition of this function is
	// // above
	// });
	// $('input[dec="1"]').on("keyup", function() {
	// $(this).next('.tooltip_outer').hide();
	// decimalonly(this); // definition of this function is
	// // above
	// });

	// $('input[alp="1"]').on("keyup", function(e) {
	// $(this).next('.tooltip_outer').hide();
	// var validChars = /^[a-zA-Z]*$/;
	// var o = $(this);
	// if (!(validChars.test(o.val()))) {
	// e.preventDefault();
	// BindRemoveError(o, "Please enter only alphabets.");
	// }
	// })
	/* Validation code area */

//});
/* This funtion is used in Comments.gsp page */
function ShowTextEditor() {
	// $("textarea").jqte();
	$(".selftextarea").jqte();
	$(".jqte_toolbar").hide();
	$(".jqte_editor").each(function() {
		$(this).focusin(function() {
			var leng = $(this).next().children().attr("contcounter");
			var o = $(this).parent().children().toArray();
			var myDiv = o[0];
			var att = document.createAttribute("Him"); // Create a "class"
			// attribute
			att.value = leng;
			$(myDiv).addClass(leng); // Set the value of the class attribute
			myDiv.setAttributeNode(att);
			var attra = $(this).parent().children().attr("Him");
			$("." + attra).show();
		});
		$(this).focusout(function() {
			var leng = $(this).next().children().attr("contcounter");
			var attra = $(this).parent().children().attr("Him");
			$("." + attra).hide();
		});
	});
}


/*This function is used to count the Word limit with ShowTextEditor() function()*/
function Max_WordLimit()
{
	$('.jqte_editor')
	.on(
			'change',
			function(e) {
				var controlNo = $(this).next().find(
						"textarea").attr("contcounter");
				var maxWord = 200;
				var controlText = $(this).html().replace(
						/&nbsp;/g, '');
				var c = wordCount(controlText);
				var currentWordCount = c.words;
				if (currentWordCount > maxWord) {
					var extraWords = currentWordCount
							- maxWord;
					var editorContent = controlText
							.substring(0,
									$(this).html().length
											- extraWords);
					$(this).html(editorContent);
					wordLeft = 0;
				} else {
					wordLeft = maxWord
							- parseInt(currentWordCount);
				}
				$("#wordLeft" + controlNo).val(wordLeft);
				$('#lblTotalWords' + controlNo).html(
						wordLeft);
			});
}


/*
 * This function is used in Generate In princiapal Diary No to validate the
 * radio button
 */

function checkradiovalid(rboclass)
{
	var chkflag=false;
	$("."+rboclass).each(function(){
		if($(this).is(":checked"))
			{
			chkflag=true;
			}		
	});
	if(chkflag==false)
		{
		$("#errormsg").text("Please check at least one");
		
		}
	
}


function checkvalidRadio(e) {

	var a = $(".onecheck").is(":checked");
	var b = $(".twocheck").is(":checked");
	var o1 = $(".twocheck");
	if (o1.attr("data_two") && (a != true) && (b != true)) {
		BindRemoveError(o1, "Select at least one");
		e.preventDefault();

		return false;
	}

}
/*This function is used to hide validation message In generateInPrincipalIFDNo.*/
function hideone(o)
{
	if(o.next().next().hasClass("tooltip_outer"))
	{				
	o.next().next(".tooltip_outer").remove();
	o.next().removeClass("error1")
	}
}
function hideTwo(o)
{
	if(o.next().hasClass("tooltip_outer"))
	{
	alert("true");
	o.next(".tooltip_outer").remove();
	o.removeClass("error1")
	}
	}
/*This function is used in else administrative order for storing budget table*/
function store_table()
{
	$(".editForBudgut").jqte();
	$(".tblbordermargin").parent().parent().attr("contenteditable","false");
	$(".tblbordermargin").parent().parent().prev().prev().css("display","none");
	}

function txtareawordcount(e)
{
		var value1=$(e).val();			
		var value =$.trim($(e).val()).split(' ').length; 												
		
		if (value > 500) {			
				alert("Only 500 words allowed");			
				
				
			
		}
		

}