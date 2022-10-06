<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="br.org.recode.educagro.model.Professor" %>
<%@ page import="java.util.List" %>
<%  List<Professor> professores = (List<Professor>)request.getAttribute("professor"); %>



<!-- Bootstrap CSS -->
<link rel='stylesheet'
	href='https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.1.2/css/bootstrap.min.css'>
<!-- Font Awesome CSS -->
<link rel='stylesheet'
	href='https://use.fontawesome.com/releases/v5.3.1/css/all.css'>
<!-- Bootstrap CSS v5.2.0-beta1 -->
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css"
	integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor"
	crossorigin="anonymous">
<link rel="stylesheet" href="Css/educagro.css">
<link rel="stylesheet" href="./assets/css/style.css" />
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<div class="contanier-body">
<body>
	
		<!--NAVBAR-->
		<div class="container-nav m-0">
			<div class="row justify-content-center m-0">
				<div class="logo col-md-6 text-center">
					<img src="./views/images/logo.png" width="100px" height="100 px">
				</div>
			</div>
			<div class="row justify-content-center m-0">

				<div class="col-md-8 d-flex justify-content-center">
					<h2 class="educagro">EducAgro</h2>
				</div>

			</div>
			<div class="row m-0">
				<nav
					class="navbar navbar-expand-lg navbar-dark ftco_navbar ftco-navbar-light "
					id="ftco-navbar" style="background-color: #4c6233;">
					<div class="container-fluid">
						<div class="collapse navbar-collapse" id="ftco-nav">
							<ul class="navbar-nav m-auto">
								<li class="nav-item active fs-5 fw-bold"><a
									href="login.html" class="nav-link">Home</a></li>
								<li class="nav-item active fs-5 fw-bold"><a href="./aulas"
									class="nav-link">Aulas</a></li>
								<li class="nav-item active fs-5 fw-bold"><a
									href="./materias" class="nav-link">Materias</a></li>
								<li class="nav-item active fs-5 fw-bold"><a
									href="./professor" class="nav-link">Professor</a></li>
								<li class="nav-item active fs-5 fw-bold"><a
									href="./voluntario" class="nav-link">Voluntário</a></li>
								<li class="nav-item active fs-5 fw-bold"><a href="#"
									class="nav-link" data-toggle="modal"
									data-target="#modalContato">Sair</a></li>
							</ul>
						</div>
					</div>
				</nav>
			</div>
		</div>
		<!--FIM NAVBAR-->
		
		 <section class="container">
		 
	     	<div class="p-4">
			 	<a href="./views/professores/create.html" class="btn btn-primary mb-2 botao1">
		            Novo Professor
		        </a>
				<table class="table  table-hover">
				  <thead class="table-dark">
				    <tr>
				      <th scope="col">#id</th>
				      <th scope="col">Nome</th>
				      <th scope="col">E-mail</th>
				      <th scope="col" colspan="2">Operações</th>
				    </tr>
				  </thead>
				 <tbody>
				  <%for(Professor professor : professores){ %>
				  	<tr>
				  		<td scope="col"><%=professor.getId() %></td>
				  		<td scope="col"><%=professor.getNome() %></td>
				  		<td scope="col"><%=professor.getEmail() %></td>
				  		<td><a class="btn btn-warning" href="edit-professor?id=<%=professor.getId() %>">EDITAR</a></td>
				  		<td><a class="btn btn-danger" href="delet-professor?id=<%=professor.getId() %>">EXCLUIR</a></td>
				  	</tr>
				  	<%} %>
				</table>
			 </div>
	      </section>
	      
	    </main>
    
	<footer>
		<img
			src="./assets/img/logo.png"
			alt="" />
	</footer>

	<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js" integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.min.js" integrity="sha384-7VPbUDkoPSGFnVtYi0QogXtr74QeVeeIs99Qfg5YCF+TidwNdjvaKZX19NZ/e6oz" crossorigin="anonymous"></script>

</body>
</div>
</html>