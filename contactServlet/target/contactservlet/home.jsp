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
    height: 100vh;
  }
}

.top-nav-collapse {
  background-color: #78909c !important;
}

.navbar:not(.top-nav-collapse) {
  background: transparent !important;
}

@media (max-width: 991px) {
  .navbar:not(.top-nav-collapse) {
    background: #78909c !important;
  }
}

h1 {
  letter-spacing: 8px;
}

h5 {
  letter-spacing: 3px;
}

.hr-light {
  border-top: 3px solid #fff;
  width: 80px;
}
      </style>
  </head>
    <body>

        <header>
          <!--Navbar-->
          <nav class="navbar navbar-expand-lg navbar-dark fixed-top scrolling-navbar">
            <div class="container">
              <a class="navbar-brand" href="#"><strong>SP</strong></a>
              <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent-7" aria-controls="navbarSupportedContent-7" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
              </button>
              <div class="collapse navbar-collapse" id="navbarSupportedContent-7">
                <ul class="navbar-nav mr-auto">
                  <li class="nav-item active">
                    <a class="nav-link" href="#">Home <span class="sr-only">(current)</span></a>
                    <li class="nav-item">
                        <a onclick="window.location.href='Create.jsp'" class="nav-link"  target="_blank">Create</a>
                      </li>
                      <li class="nav-item">
                        <a onclick="window.location.href='Read.jsp'" class="nav-link"  target="_blank">View</a>
                      </li>
                      <li class="nav-item">
                          <a class="nav-link" data-toggle="dropdown" href="Update.jsp" target="_blank">Update</a>
                          <div class="dropdown-menu">
                              <a onclick="window.location.href='UpdateName.jsp'" class="dropdown-item" href="#">Update Name</a>
                              <a onclick="window.location.href='UpdatePhoneNumber.jsp'" class="dropdown-item" href="#">Update PhoneNumber</a>
                              <a onclick="window.location.href='AddNumber.jsp'" class="dropdown-item" href="#">Add PhoneNumber</a>
                              <a onclick="window.location.href='UpdateMailId.jsp'" class="dropdown-item" href="#">Update Emailid</a>
                            </div>
                          </li>
                      <li class="nav-item">
                        <a onclick="window.location.href='delete.jsp'" class="nav-link"  target="_blank">Delete</a>
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
          <div class="view" style="background-image: url('https://mdbootstrap.com/img/Photos/Others/img%20%2848%29.jpg'); background-repeat: no-repeat; background-size: cover; background-position: center center;">
            <!-- Mask & flexbox options-->
            <div class="mask rgba-black-light align-items-center">
              <!-- Content -->
              <div class="container">
                <!--Grid row-->
                <div class="row">
                  <!--Grid column-->
                  <div class="col-md-12 mb-4 white-text text-center">
                    <h1 class="h1-reponsive white-text text-uppercase font-weight-bold mb-0 pt-md-5 pt-5 wow fadeInDown" data-wow-delay="0.3s"><strong></strong></h1>
                    <h2 class="h1-reponsive white-text text-uppercase font-weight-bold mb-0 pt-md-5 pt-5 wow fadeInDown" data-wow-delay="0.3s"><strong></strong></h2>
                    <h3 class="h1-reponsive white-text text-uppercase font-weight-bold mb-0 pt-md-5 pt-5 wow fadeInDown" data-wow-delay="0.3s"><strong></strong></h3>
                    <h5 class="text-uppercase mb-4 white-text wow fadeInDown" data-wow-delay="0.4s"><strong>create your contact with better experience</strong></h5>
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
        </header>
        <!-- Main navigation -->
        <!--Main Layout-->
        <main>
          <div class="container">
            <!--Grid row-->
            <div class="row py-5">
              <!--Grid column-->
              <div class="col-md-12 text-center">
              </div>
              <!--Grid column-->
            </div>
            <!--Grid row-->
          </div>
        </main>
        <!--Main Layout-->
        <script type="text/javascript">
          // Animations initialization
          new WOW().init();
        </script>

    </body>
</html>
