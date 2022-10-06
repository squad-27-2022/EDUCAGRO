<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="br.org.recode.educagro.model.Aulas"%>
<%@ page import="java.util.List"%>

<%
List<Aulas> aulas = (List<Aulas>) request.getAttribute("aulas");
%>
<!Doctype html>
<html lang="pt-br">

<head>
<title>EducAgro</title>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">


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
				<a href="initAulas" class="btn btn-primary mb-2 botao1"> Nova
					Aula </a>
				<table class="table  table-hover">
					<thead class="table-dark">
						<tr>
							<th scope="col">#id</th>
							<th scope="col">Materia</th>
							<th scope="col">Professor</th>
							<th scope="col">Voluntário</th>
							<th scope="col" colspan="2">Operações</th>
						</tr>
					</thead>
					<tbody>
						<%
						for (Aulas aula : aulas) {
						%>
						<tr>
							<td scope="col"><%=aula.getId_aulas()%></td>
							<td scope="col"><%=aula.getNomeMateria()%></td>
							<td scope="col"><%=aula.getNomeProfessor()%></td>
							<td scope="col"><%=aula.getNomeVoluntario()%></td>
							<td><a class="btn btn-warning"
								href="edit-materias?id=<%=aula.getId_aulas()%>">EDITAR</a></td>
							<td><a class="btn btn-danger"
								href="delet-materias?id=<%=aula.getId_aulas()%>">EXCLUIR</a></td>
						</tr>
						<%
						}
						%>
					</tbody>
				</table>
			</div>
		</section>

		</main>

		<footer>
			<!-- INICIO FOOTER -->
			<section class="container">
				<footer
					class="d-flex flex-wrap justify-content-between align-items-center py-3 my-4 border-top">
					<div class="col-md-4 d-flex align-items-center">
						<img class="m-3" width="30" height="24"
							src="./views/images/logo.png"> </a> <span
							class="mb-3 mb-md-0 text-muted">&copy; 2022 EducAgro</span>
					</div>

					<ul class="nav col-md-4 justify-content-end list-unstyled d-flex">
						<li class="ms-3"><a href="#"><a href="#"><span
									class="fa fa-facebook m-3 text-dark"><i class="sr-only">Facebook</i></span></a></li>
						<li class="ms-3"><a href="#"><span
								class="fa fa-twitter m-3 text-dark"><i class="sr-only">Twitter</i></span></a></li>
						<li class="ms-3"><a href="#"><span
								class="fa fa-instagram m-3 text-dark"><i class="sr-only">Instagram</i></span></a></li>
					</ul>
				</footer>
			</section>
			<!-- FIM FOOTER -->
		</footer>

		<script
			src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"
			integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3"
			crossorigin="anonymous"></script>
		<script
			src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.min.js"
			integrity="sha384-7VPbUDkoPSGFnVtYi0QogXtr74QeVeeIs99Qfg5YCF+TidwNdjvaKZX19NZ/e6oz"
			crossorigin="anonymous"></script>
	</body>
</div>
</html>
