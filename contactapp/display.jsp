<%@ page import= "com.lxisoft.contact.model.*"%>
<%@ page import= "com.lxisoft.contact.repo.*"%>
<%@ page import="java.util.*"%>
<%@ page import="java.io.*"%>
<%ArrayList<Contact>list=new ArrayList<Contact>();
RepositoryImpl rep=new RepositoryImpl();
rep.view(list);
%>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta http-equiv="x-ua-compatible" content="ie=edge">
  <title>Material Design Bootstrap</title>
  <!-- Font Awesome -->
  <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.2/css/all.css">
  <!-- Bootstrap core CSS -->
  <link href="css/bootstrap.min.css" rel="stylesheet">
  <!-- Material Design Bootstrap -->
  <link href="css/mdb.min.css" rel="stylesheet">
  <!-- Your custom styles (optional) -->
  <link href="css/style.css" rel="stylesheet">
  <link href="css/home.css" rel="stylesheet">
  <link href="css/create.css" rel="stylesheet">
</head>

<body>

        <header>
          <!-- Navbar -->
          <nav class="navbar navbar-expand-lg navbar-dark fixed-top scrolling-navbar">
            <div class="container">
              <a class="navbar-brand" href="#">
                <strong></strong>
              </a>
              <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent-7" aria-controls="navbarSupportedContent-7" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
              </button>
              <div class="collapse navbar-collapse" id="navbarSupportedContent-7">
                <ul class="navbar-nav mr-auto">
				<li class="nav-item">
                    <a class="nav-link" href="view.jsp">Home</a>
                  </li>
                  <li class="nav-item">
                    <a class="nav-link" href="create.jsp">Create
                      
                    </a>
                  </li>
                  <li class="nav-item active">
                    <a class="nav-link" href="#">View
					<span class="sr-only">(current)</span></a>
                  </li>
                  <li class="nav-item">
                    <a class="nav-link" href="edit.jsp">Edit</a>
                  </li>
				  <li class="nav-item">
                    <a class="nav-link" href="delete.jsp">Delete</a>
                  </li>
                </ul>
                <form class="form-inline">
                  <div class="md-form my-0">
                    <input class="form-control mr-sm-2" type="text" placeholder="Search" aria-label="Search">
                  </div>
                </form>
              </div>
            </div>
          </nav>
          <!-- Navbar -->
          <!-- Full Page Intro -->
          <div class="view" style="background-image: url('https://mdbootstrap.com/img/Photos/Others/images/91.jpg'); background-repeat: no-repeat; background-size: cover; background-position: center center;">
            <!-- Mask & flexbox options-->
            <div class="mask rgba-gradient align-items-center">
              <!-- Content -->
              <div class="container">
			   top:50px;
			   position :relative
                <!--Grid row-->
                <div class="row mt-5">
                  <!--Grid column-->
                  <div class="col-md-6 mb-5 mt-md-0 mt-5 white-text text-center text-md-left">
                    <h1 class="h1-responsive font-weight-bold wow fadeInLeft" data-wow-delay="0.3s">My Contacts </h1>
                    <hr class="hr-light wow fadeInLeft" data-wow-delay="0.3s">
                    <h6 class="mb-3 wow fadeInLeft" data-wow-delay="0.3s"></h6>
                     </div>

		 
<table class="table white-text">
  <thead>
  
    <tr>
     
      <th scope="col"><h4>Name</h4></th>
      <th scope="col"><h4>PhoneNumber</h4></th>
      
    </tr>
  </thead>
  <tbody>
    
	<%for(int i=0;i<list.size();i++){%>
<tr>
      <td><%=list.get(i).getName()%></td>
      <td><%=list.get(i).getPhoneNumber()%></td>
	  </tr>
	<%}%>
    
    
  </tbody>
</table>




</header>
</body>
	
	 <!-- SCRIPTS -->
  <!-- JQuery -->
  <script type="text/javascript" src="js/jquery-3.4.1.min.js"></script>
  <!-- Bootstrap tooltips -->
  <script type="text/javascript" src="js/popper.min.js"></script>
  <!-- Bootstrap core JavaScript -->
  <script type="text/javascript" src="js/bootstrap.min.js"></script>
  <!-- MDB core JavaScript -->
  <script type="text/javascript" src="js/mdb.min.js"></script>

	</header>
</body>
	
	
</html>