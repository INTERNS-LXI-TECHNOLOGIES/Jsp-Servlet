<%@ page import="java.util.*"%>
<%@ page import="java.io.*"%>
<%@ page import="com.lxisoft.contact.model.*"%>
<%@ page import="com.lxisoft.contact.repo.*"%>
<%ArrayList<Contact>list=new ArrayList<Contact>();
RepositoryImpl reps=new RepositoryImpl();
reps.view(list);
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
  <link href="css/delete.css" rel="stylesheet">
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
                  <li class="nav-item">
                    <a class="nav-link" href="display.jsp">View
					</a>
                  </li>
                  <li class="nav-item">
                    <a class="nav-link" href="edit.jsp">Edit</a>
                  </li>
				  <li class="nav-item active">
                    <a class="nav-link" href="delete.jsp">Delete</a>
					<span class="sr-only">(current)</span></a>
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
                    <h1 class="h1-responsive font-weight-bold wow fadeInLeft" data-wow-delay="0.3s">Can Remove now! </h1>
                    <hr class="hr-light wow fadeInLeft" data-wow-delay="0.3s">
                    <h6 class="mb-3 wow fadeInLeft" data-wow-delay="0.3s">You can remove a contact now...</h6>
                     </div>                
         


<!-- Editable table -->
<form action = "delete" method = "post">
<div class="card">
  <h3 class="card-header text-center font-weight-bold text-uppercase py-4">My contacts</h3>
  <div class="card-body">
    <div id="table" class="table-editable">
      <span class="table-add float-right mb-3 mr-2"><a href="#!" class="text-success"><i
            class="fas fa-plus fa-2x" aria-hidden="true"></i></a></span>
      <table class="table table-bordered table white-text table-responsive-md table-striped text-center">
        <thead>
          <tr>
            <th class="text-center">Name</th>
            <th class="text-center">PhoneNumber</th>
            <th class="text-center">Sort</th>
            <th class="text-center">Remove</th>
          </tr>
        </thead>
        <tbody>
		
		<%for(int i=0;i<list.size();i++){%>
          <tr>
            <td class="pt-3-half" contenteditable="true"><%=list.get(i).getName()%></td>
            <td class="pt-3-half" contenteditable="true"><%=list.get(i).getPhoneNumber()%></td>
             <td class="pt-3-half">
              <span class="table-up"><a href="#!" class="indigo-text"><i class="fas fa-long-arrow-alt-up"
                    aria-hidden="true"></i></a></span>
              <span class="table-down"><a href="#!" class="indigo-text"><i class="fas fa-long-arrow-alt-down"
                    aria-hidden="true"></i></a></span>
            </td>
            <td>
              <span class="table-remove"><button type="submit" value=<%=list.get(i).getName()%> name="name"
                  class="btn btn-danger btn-rounded btn-sm my-0">Remove</button></span>
				  
            </td>
          </tr>
		  <%}%>
		  </form>
          <!-- This is our clonable table line -->
          
          <!-- This is our clonable table line -->
          
          <!-- This is our clonable table line -->
          
        </tbody>
      </table>
    </div>
  </div>
</div>
<!-- Editable table -->
</header>


<!-- Main navigation -->
        <!--Main Layout-->
        <main>
          <div class="container">
            <!--Grid row-->
            <div class="row py-5">
              <!--Grid column-->
              <div class="col-md-12 text-center">
                <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</p>
              </div>
              <!--Grid column-->
            </div>
            <!--Grid row-->
          </div>
        </main>
        <!--Main Layout-->


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