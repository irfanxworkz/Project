<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script>
$(function() {
	  enable_cb();
	  $("#group1").click(enable_cb);
	});

	function enable_cb() {
	  if (this.checked) {
	    $("input.group1").removeAttr("disabled");
	  } else {
	    $("input.group1").attr("disabled", true);
	  }
	}
</script>

  <meta charset="utf-8">
  <title>Disable/enable the form submit button</title>
  <link rel="stylesheet" href="Simple.css">
</head>
<body >

<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<form action="send" method="post">
  <input type="checkbox" name="chkcc9" id="group1">click Agriment <br>
  <input type="submit" class="group1" value="save"><br>

</form>
</body>
</html>