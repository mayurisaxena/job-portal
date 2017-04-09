<!DOCTYPE html>
<html lang="en">
<head>
  <title>Job Search</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <link rel="stylesheet" href="css/jobs.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  
</head>
<body id="myPage" data-spy="scroll" data-target=".navbar" data-offset="60">

<div id="header">
	<jsp:include page="header.jsp"/>
</div>
<div class="jumbotron text-center">
  <h1>Job Search</h1> 
  <p>Search for your dream job.</p> 
  <form action="/jobSearch.do" method="post">
    <div class="input-group">
      <input type="text" class="form-control" size="50" placeholder="Job Title, Keywords" required>
      <div class="input-group-btn">
        <button type="submit" class="btn btn-danger">Search</button>
      </div>
    </div>
  </form>

  
</div>
<script>
  $(function() {
  var people = [];
   $.getJSON('test.json', function(data) {
     $.each(data.records, function(i, f) {
       var tblRow = "<tr>" + "<td>" + f.vEmail + "</td>" + "<td>" + f.vUserName +  "</td>" + "<td>" + f.nDepartmentId + "</td>" + "<td>" + f.nEnabled + "</td>" + "<td>" + f.department + "</td>" + "<td>" + f.vFatherName + "</td>" + "<td>" + f.vSurname + "</td>" + "<td>" + f.vAfm + "</td>" + "<td>" + f.vUsertype + "</td>" + "<td>" + f.vName + "</td>" + "<td>" + f.nId + "</td>" + "<td>" + f.rolesDesc + "</td>" + "</tr>"
       $(tblRow).appendTo("#userdata tbody");
    });
   });
  });
  </script>

<div class="wrapper">
 <div class="profile">
 <table id= "userdata" border="2">
 <tr>
        <th>Job Id</th>
        <th>Employee</th>
        <th>Description</th>
        <th>Skills</th>
    </tr>
    <tbody>

    </tbody>
   </table>
 </div>
 </div>




<footer class="container-fluid text-center">
  <a href="#myPage" title="To Top">
    <span class="glyphicon glyphicon-chevron-up"></span>
  </a>
  <p>CI6206-Internet Programming Project</p>
</footer>

<script>
$(document).ready(function(){
  // Add smooth scrolling to all links in navbar + footer link
  $(".navbar a, footer a[href='#myPage']").on('click', function(event) {
    // Make sure this.hash has a value before overriding default behavior
    if (this.hash !== "") {
      // Prevent default anchor click behavior
      event.preventDefault();

      // Store hash
      var hash = this.hash;

      // Using jQuery's animate() method to add smooth page scroll
      // The optional number (900) specifies the number of milliseconds it takes to scroll to the specified area
      $('html, body').animate({
        scrollTop: $(hash).offset().top
      }, 900, function(){
   
        // Add hash (#) to URL when done scrolling (default click behavior)
        window.location.hash = hash;
      });
    } // End if
  });
  
  $(window).scroll(function() {
    $(".slideanim").each(function(){
      var pos = $(this).offset().top;

      var winTop = $(window).scrollTop();
        if (pos < winTop + 600) {
          $(this).addClass("slide");
        }
    });
  });
})
</script>

</body>
</html>
