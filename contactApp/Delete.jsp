<%@ page import= "com.lxisoft.contact.ContactModel"%>
<%@ page import= "com.lxisoft.contact.RepositoryImpl"%>
<%@ page import="java.sql.*"%>
<%@ page import="java.util.*"%>
<%ArrayList<ContactModel>contacts=new ArrayList<ContactModel>();
	RepositoryImpl ri=new RepositoryImpl();
contacts=ri.viewAllContact();
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



        <!-- Main navigation -->
        <header>
          <!--Navbar-->
          <nav class="navbar navbar-expand-lg navbar-dark fixed-top scrolling-navbar">
            <div class="container">
              <a class="navbar-brand" href="#">
                <strong>AGZ</strong>
              </a>
              <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent-7" aria-controls="navbarSupportedContent-7" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
              </button>
              <div class="collapse navbar-collapse" id="navbarSupportedContent-7">
                <ul class="navbar-nav mr-auto">
                  <li class="nav-item active">
                    <a onclick="window.location.href='index.html'" class="nav-link" href="#">Home
                      <span class="sr-only">(current)</span>
                    </a>
                  </li>
                  
                  <li class="nav-item">
                    <a onclick="window.location.href='create.html'" class="nav-link" href="#">Create</a>
                  </li>
                  <li class="nav-item">
                    <a class="nav-link" data-toggle="dropdown" href="Update.html" target="_blank">Update</a>
                    <div class="dropdown-menu">
                      <a onclick="window.locaton.href='upFirstName.html'" class="dropdown-item" href="upFirstName.html">Update First_Name</a>
                      <a onclick="window.locaton.href='upLastName.html'" class="dropdown-item" href="upLastName.html">Update Last_Name</a>
                      <a onclick="window.locaton.href='upPhoneN.html'" class="dropdown-item" href="upPhoneN.html">Update Phone_Number</a>
                      <a onclick="window.locaton.href='upMobN.html'" class="dropdown-item" href="upMobN.html">Update Mobile_Number</a>
                      <a onclick="window.locaton.href='upEmailId.html'" class="dropdown-item" href="upEmailId.html">Update Email_ID</a>
                    </div>
                  </li>
                  <li class="nav-item">
                    <a onclick="window.location.href='Delete.jsp'" class="nav-link" href="#">Delete</a>
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
      

<!-- Editable table -->
<div class="card">
        <form name="" action="Remove.jsp" method="post">
        <h3 class="card-header text-center font-weight-bold text-uppercase py-4"></h3>
        <div class="card-body">
          <div id="table" class="table-editable">
            <span class="table-add float-right mb-3 mr-2"><a href="create.html" class="text-success"><i
                  class="fas fa-plus fa-2x" aria-hidden="true"></i></a></span>
            <table class="table table-bordered table-responsive-md table-striped text-center">
              <thead>
                <tr>
                        
                  <th class="text-center">First Name</th>
                  <th class="text-center">Last Name</th>
                  <th class="text-center">Phone Number</th>
                  <th class="text-center">Mobile Number</th>
                  <th class="text-center">Email Id</th>
                
                  <th class="text-center">Remove</th>
                </tr>
              </thead>
              <tbody>
                    <tr>
        
                            <%for(int i=0;i<contacts.size();i++)
                            {%>
                               
                          <td class="pt-3-half" contenteditable="true"><%=contacts.get(i).getFirstName()%></td>
                          <td class="pt-3-half" contenteditable="true"><%=contacts.get(i).getLastName()%></td>
                          <td class="pt-3-half" contenteditable="true"><%=contacts.get(i).getPhone()%></td>
                          <td class="pt-3-half" contenteditable="true"><%=contacts.get(i).getMobNumber()%></td>
                          <td class="pt-3-half" contenteditable="true"><%=contacts.get(i).getEmail()%></td>
                          <td>
                                <div class="form-row mb-4">
                                        
                                <span class="table-remove"><button type="submit" value="<%=contacts.get(i).getId()%>" name="Id"
                                    class="btn btn-danger btn-rounded btn-sm my-0">Remove</button></span>
                              </td>
                              
                            </tr>
                            <%}%>
                     
                <!-- <tr>
                  <td class="pt-3-half" contenteditable="true">Aurelia Vega</td>
                  <td class="pt-3-half" contenteditable="true">30</td>
                  <td class="pt-3-half" contenteditable="true">Deepends</td>
                  <td class="pt-3-half" contenteditable="true">Spain</td>
                  <td class="pt-3-half" contenteditable="true">Madrid</td>
                  
                  <td>
                    <span class="table-remove"><button type="button"
                        class="btn btn-danger btn-rounded btn-sm my-0">Remove</button></span>
                  </td>
                </tr>
                <!-- This is our clonable table line -->
                <!-- <tr>
                  <td class="pt-3-half" contenteditable="true">Guerra Cortez</td>
                  <td class="pt-3-half" contenteditable="true">45</td>
                  <td class="pt-3-half" contenteditable="true">Insectus</td>
                  <td class="pt-3-half" contenteditable="true">USA</td>
                  <td class="pt-3-half" contenteditable="true">San Francisco</td>
                  
                  <td>
                    <span class="table-remove"><button type="button"
                        class="btn btn-danger btn-rounded btn-sm my-0">Remove</button></span>
                  </td>
                </tr> -->
                <!-- This is our clonable table line -->
                <!-- <tr>
                  <td class="pt-3-half" contenteditable="true">Guadalupe House</td>
                  <td class="pt-3-half" contenteditable="true">26</td>
                  <td class="pt-3-half" contenteditable="true">Isotronic</td>
                  <td class="pt-3-half" contenteditable="true">Germany</td>
                  <td class="pt-3-half" contenteditable="true">Frankfurt am Main</td>
                  
                  <td>
                    <span class="table-remove"><button type="button"
                        class="btn btn-danger btn-rounded btn-sm my-0">Remove</button></span>
                  </td>
                </tr> -->
                <!-- This is our clonable table line -->
                <!-- <tr class="hide">
                  <td class="pt-3-half" contenteditable="true">Elisa Gallagher</td>
                  <td class="pt-3-half" contenteditable="true">31</td>
                  <td class="pt-3-half" contenteditable="true">Portica</td>
                  <td class="pt-3-half" contenteditable="true">United Kingdom</td>
                  <td class="pt-3-half" contenteditable="true">London</td>
                  
                  <td>
                    <span class="table-remove"><button type="button"
                        class="btn btn-danger btn-rounded btn-sm my-0">Remove</button></span>
                  </td>
                </tr> --> 
              </tbody>
            </table>
          </div>
        </div>
        </form>
      </div>
      <!-- Editable table -->


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
      </body>
      
      </html>
      