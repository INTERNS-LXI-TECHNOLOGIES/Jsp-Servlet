<%@ page import ="com.lxisoft.contact.ContactModel"%>
<%@ page import ="com.lxisoft.contact.RepositoryImpl"%>
<%@ page import ="java.sql.*"%>
<%@ page import ="java.util.*"%>
<%ArrayList <ContactModel> contacts = new ArrayList <ContactModel>();
ArrayList<String> phno = new ArrayList<String>();
RepositoryImpl ri = new RepositoryImpl();
RepositoryImpl si = new RepositoryImpl();
contacts=ri.readContact();%>
<html>
<head>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
	<title> read </title>
	<nav>
  <div class="nav nav-tabs md-tabs" id="nav-tab" role="tablist">
    <a class="nav-item nav-link active" id="nav-home-tab" data-toggle="tab" href="contact.html" role="tab"
      aria-controls="nav-home" aria-selected="true">Home</a>
    <a onclick="window.location.href='create.html'" class="nav-item nav-link" id="nav-profile-tab" data-toggle="tab" href="create.html" role="tab"
      aria-controls="nav-create" aria-selected="false">Create</a>
    <a onclick="window.location.href='read.jsp'" class="nav-item nav-link" id="nav-contact-tab" data-toggle="tab" href="read.html" role="tab"
      aria-controls="nav-read" aria-selected="false">Read</a>
    <a onclick="window.location.href='update.html'" class="nav-item nav-link" id="nav-contact-tab" data-toggle="tab" href="update.html" role="tab"
      aria-controls="nav-update" aria-selected="false">Update</a>  
    <a onclick="window.location.href='delete.html'" class="nav-item nav-link" id="nav-contact-tab" data-toggle="tab" href="delete.html" role="tab"
      aria-controls="nav-delete" aria-selected="false">Delete</a>  
  </div>
</nav>
</head>
        <body>
            <h1> read </h1>
      <table border="1" width="1000px" class="table-bordered text-center" style="border: 6px solid Red">
            <tbody>
           <tr>
          <td>Name</td>
          <td>Email</td>
          <td>Phone Number</td>
          </tr>
          <% for(int i=0;i<contacts.size();i++){%>
          <tr>
            <td><%=contacts.get(i).getName()%></td>
              <td><%=contacts.get(i).getMailId()%></td>
                <td><%=contacts.get(i).getPhoneNumber()%></td>
          </tr>
          <%}%>
          </tbody>
          </table> 
          
      </div>

          
    </body>
   
</head>
</html>
