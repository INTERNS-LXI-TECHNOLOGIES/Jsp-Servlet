<%@ page import= "com.lxisoft.Contact.model.ContactModel"%>
<%@ page import= "com.lxisoft.Contact.repositoryImpl.RepositoryImpl"%>
<%@ page import="java.sql.*"%>
<%@ page import ="java.util.*"%>
<%ArrayList <ContactModel> contacts=new ArrayList <ContactModel>();
	RepositoryImpl ri=new RepositoryImpl();
contacts=ri.viewAllContact();
%>
<!DOCTYPE html>
<html lang="en">

        <header>
            <!-- Navbar -->
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
                      <a onclick="window.location.href='index.jsp'" class="nav-link" href="#">Home
                        <span class="sr-only">(current)</span>
                      </a>
                    </li>
                    <li class="nav-item">
                        <a onclick="window.location.href='create.jsp'" class="nav-link" href="#">Create</a>
                      </li>
                      <li class="nav-item">
                        <a class="nav-link" data-toggle="dropdown" href="Update.html">Update</a>
                        <div class="dropdown-menu">
                          <a onclick="window.locaton.href='upFirstName.jsp'" class="dropdown-item" href="upFirstName.jsp">Update First_Name</a>
                          <a onclick="window.locaton.href='upLastName.jsp'" class="dropdown-item" href="upLastName.jsp">Update Last_Name</a>
                          <a onclick="window.locaton.href='upPhoneN.jsp'" class="dropdown-item" href="upPhoneN.jsp">Update Phone_Number</a>
                          <a onclick="window.locaton.href='upMobN.jsp'" class="dropdown-item" href="upMobN.jsp">Update Mobile_Number</a>
                          <a onclick="window.locaton.href='upEmailId.jsp'" class="dropdown-item" href="upEmailId.jsp">Update Email_ID</a>
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


<div
class="view view-cascade gradient-card-header blue-gradient narrower py-2 mx-4 mb-3 d-flex justify-content-between align-items-center">

<div>
  <button type="button" class="btn btn-outline-white btn-rounded btn-sm px-2">
    <i class="fas fa-th-short mt-1"></i>
  </button>
  <button type="button" class="btn btn-outline-white btn-rounded btn-sm px-2">
    <i class="fas fa-columns mt-0"></i>
  </button>
</div>

<a href="" class="white-text mx-3">Contact Details </a>

<div>
  <button type="button" class="btn btn-outline-white btn-rounded btn-sm px-2">
    <i class="fas fa-pencil-alt mt-0"></i>
  </button>
  <button type="button" class="btn btn-outline-white btn-rounded btn-sm px-2">
    <i class="far fa-trash-alt mt-0"></i>
  </button>
  <button type="button" class="btn btn-outline-white btn-rounded btn-sm px-2">
    <i class="fas fa-info-circle mt-0"></i>
  </button>
</div>

</div>
<!--/Card image-->

<div class="px-4">

<div class="table-wrapper">
  <!--Table-->
  <table class="table table-hover mb-0">

    <!--Table head-->
    <thead>
      <tr>
        <th>
          <input class="form-check-input" type="checkbox" id="checkbox">
          <label class="form-check-label" for="checkbox" class="mr-2 label-table"></label>
        </th>
        <th class="th-lg">
          <a>First Name
            <i class="fas fa-sort ml-1"></i>
          </a>
        </th>
        <th class="th-lg">
          <a href="">Last Name
            <i class="fas fa-sort ml-1"></i>
          </a>
        </th>
        <th class="th-lg">
          <a href="">Phone Number 
          <i class="fas fa-sort ml-1"></i>
          </a>
        </th>
        <th class="th-lg">
          <a href="">Mobile Number
            <i class="fas fa-sort ml-1"></i>
          </a>
        </th>
        <th class="th-lg">
          <a href="">Email Id
            <i class="fas fa-sort ml-1"></i>
          </a>
        </th>
        
      </tr>
    </thead>
    <!--Table head-->

    <!--Table body-->
    <tbody>
      <tr>
        
          <%for(int i=0;i<contacts.size();i++)
          {%>
            <th scope="row">
          <input class="form-check-input" type="checkbox" id="checkbox1">
          <label class="form-check-label" for="checkbox1" class="label-table"></label>
        </th>
        <td><%=contacts.get(i).getFirstName()%></td>
        <td><%=contacts.get(i).getLastName()%></td>
        <td><%=contacts.get(i).getPhone()%></td>
        <td><%=contacts.get(i).getMobNumber()%></td>
        <td><%=contacts.get(i).getEmail()%></td>
        </tr>

          <%}%>
        
       
      
    
    </tbody>
    <!--Table body-->
  </table>
  <!--Table-->
</div>

</div>


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

