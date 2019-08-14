<%@ page import = "com.lxisoft.Contact.model.ContactModel" %>
<%@ page import = "com.lxisoft.Contact.repositoryImpl.RepositoryImpl" %>
<%@ page import = "com.lxisoft.Contact.servlet.Updatephno"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
  <link href="css/style.min.css" rel="stylesheet">
  <style type="text/css">
    html,
    body,
    header,
    .view {
      height: 100%;
    }

    @media (max-width: 740px) {
      html,
      body,
      header,
      .view {
        height: 1000px;
      }
    }

    @media (min-width: 800px) and (max-width: 850px) {
      html,
      body,
      header,
      .view {
        height: 650px;
      }
    }
    @media (min-width: 800px) and (max-width: 850px) {
              .navbar:not(.top-nav-collapse) {
                  background: #1C2331!important;
              }
          }
  </style>
</head>

<body>

  <!-- Navbar -->
  <nav class="navbar fixed-top navbar-expand-lg navbar-dark scrolling-navbar">
    <div class="container">

      <!-- Brand -->
      <a class="navbar-brand" href="" target="_blank">
        <strong>SP</strong>
      </a>

      <!-- Collapse -->
      <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent"
        aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>

      <!-- Links -->
      <div class="collapse navbar-collapse" id="navbarSupportedContent">

        <!-- Left -->
        <ul class="navbar-nav mr-auto">
          <li class="nav-item">
            <a onclick="window.location.href='home.jsp'" class="nav-link"  target="_blank">Home</a>
          </li>
            <li class="nav-item">
            <a onclick="window.location.href='Create.jsp'" class="nav-link"  target="_blank">Create</a>
          </li>
          <li class="nav-item">
            <a onclick="window.location.href='Read.jsp'" class="nav-link"  target="_blank">view</a>
          </li>
          <li class="nav-item">
             <a class="nav-link" data-toggle="dropdown" href="Update.jsp" target="_blank">Update<span class="sr-only">(current)</span></a>
            <div class="dropdown-menu">
                <a onclick="window.location.href='UpdateName.jsp'" class="dropdown-item" href="#">Update Name</a>
                <a onclick="window.location.href='UpdatePhoneNumber.jsp'" class="dropdown-item" href="#">Update PhoneNumber</a>
                <a onclick="window.location.href='AddNumber.jsp'" class="dropdown-item" href="#">Add PhoneNumber</a>
                <a onclick="window.location.href='UpdateMailId.jsp'" class="dropdown-item" href="#">Update Emailid</a>
              </div>
          </li>
          <li class="nav-item">
            <a onclick="window.location.href='delete.jsp'" class="nav-link"  target="_blank">delete</a>
          </li>
        </ul>

        <!-- Right -->
        <ul class="navbar-nav nav-flex-icons">
          <li class="nav-item">
            <a href="https://www.facebook.com/mdbootstrap" class="nav-link" target="_blank">
              <i class="fab fa-facebook-f"></i>
            </a>
          </li>
          <li class="nav-item">
            <a href="https://twitter.com/MDBootstrap" class="nav-link" target="_blank">
              <i class="fab fa-twitter"></i>
            </a>
          </li>
          <li class="nav-item">
            <a href="https://github.com/mdbootstrap/bootstrap-material-design" class="nav-link border border-light rounded"
              target="_blank">
              <i class="fab fa-github mr-2"></i>MDB GitHub
            </a>
          </li>
        </ul>

      </div>

    </div>
  </nav>
  <!-- Navbar -->

  <!-- Full Page Intro -->
  <div class="view full-page-intro" style="background-image: url('https://mdbootstrap.com/img/Photos/Others/images/100.jpg'); background-repeat: no-repeat; background-size: cover;">

    <!-- Mask & flexbox options-->
    <div class="mask rgba-black-light d-flex justify-content-center align-items-center">

      <!-- Content -->
      <div class="container">

        <!--Grid row-->
        <div class="row wow fadeIn">

          <!--Grid column-->
          <div class="col-md-6 mb-4 white-text text-center text-md-left">

            <h1 class="display-4 font-weight-bold">ContactApp</h1>

            <hr class="hr-light">

            <p class="mb-4 d-none d-md-block">
              <strong>get best contact app in your hands</strong>
            </p>

          </div>
          <!--Grid column-->

          <!--Grid column-->
          <div class="col-md-6 col-xl-5 mb-4">

            <!--Card-->
            <div class="card">

              <!--Card content-->
              <div class="card-body">

                <!-- Form -->
                <form name="" action="updateph" method="post">
                  <!-- Heading -->
                  <h3 class="dark-grey-text text-center">
                    <strong>your contacts</strong>
                  </h3>
                  <hr>

                  <div class="md-form">
                    <i class="fas fa-phone prefix grey-text"></i>
                    <input type="text" id="form3" class="form-control" name="number">
                    <label for="form3">Number</label>
                  </div>
                  <div class="md-form">
                    <i class="fas fa-phone prefix grey-text"></i>
                    <input type="text" id="form2" class="form-control" name="newnumber">
                    <label for="form2">New Number</label>
                  </div>

                  <div class="text-center">
                    <button class="btn btn-indigo" type="submit" value="submit">Submitt</button>
                    <hr>
                  </div>

                </form>
                <!-- Form -->

              </div>

            </div>
            <!--/.Card-->

          </div>
          <!--Grid column-->

        </div>
        <!--Grid row-->

      </div>
      <!-- Content -->

    </div>
    <!-- Mask & flexbox options-->

  </div>
  <!-- Full Page Intro -->
  
  <!--/.Footer-->

  <!-- SCRIPTS -->
  <!-- JQuery -->
  <script type="text/javascript" src="js/jquery-3.4.1.min.js"></script>
  <!-- Bootstrap tooltips -->
  <script type="text/javascript" src="js/popper.min.js"></script>
  <!-- Bootstrap core JavaScript -->
  <script type="text/javascript" src="js/bootstrap.min.js"></script>
  <!-- MDB core JavaScript -->
  <script type="text/javascript" src="js/mdb.min.js"></script>
  <!-- Initializations -->
  <script type="text/javascript">
    // Animations initialization
    new WOW().init();
  </script>
</body>

</html>