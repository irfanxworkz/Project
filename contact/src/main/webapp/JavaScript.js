
function forName() {
		var firstName = document.getElementById("name");
		console.log(firstName.value);
		var errFirstName = document.getElementById("errName");
		/* errFirstName.innerHTML = '' */
		if (firstName.value != '' && firstName.value.length > 3
				&& firstName.value.length < 30) {
			errFirstName.innerHTML = ''

		} else {

			errFirstName.innerHTML = "name should be >3 & <30"
			errFirstName.style.color = 'red'
		}
	}

	function forEmail() {
		var firstName = document.getElementById("email");
		console.log(firstName.value);
		var errFirstName = document.getElementById("errEmail");
		/* errFirstName.innerHTML = '' */
		if (firstName.value != '' && firstName.value.length > 7
				&& firstName.value.length < 30) {
			errFirstName.innerHTML = ''

		} else {

			errFirstName.innerHTML = "email should be >7 & <30"
			errFirstName.style.color = 'red'
		}
	}

	/* 	function forMobile() {
	 var numContact = document.getElementById("mobile");
	 console.log(numContact.value);
	 var errContact = document.getElementById("errMobile");
	 errFirstName.innerHTML = ''
	 if (numContact.value != '' && numContact.value != 0
	 && numContact.value > 3 && numContact.value < 30) {
	 errContact.innerHTML = ''

	 } else {

	 errContact.innerHTML = "please enter valid Number"
	 errContact.style.color = 'red'
	 }
	 } */

	function forComment() {
		var comment = document.getElementById("comments");
		console.log(comment.value);
		var errText = document.getElementById("errText");
		/* errFirstName.innerHTML = '' */
		if (comment.value != '' && comment.value.length > 3
				&& comment.value.length < 30) {
			errText.innerHTML = ''

		} else {

			errText.innerHTML = "name should be >3 & <80"
			errText.style.color = 'red'
		}
	}