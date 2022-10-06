<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="br.org.recode.educagro.model.Professor"%>
<%@ page import="br.org.recode.educagro.model.Materias"%>
<%@ page import="br.org.recode.educagro.model.Voluntario"%>
<%@ page import="java.util.List"%>
<%
List<Professor> professores = (List<Professor>) request.getAttribute("professores");
%>
<%
List<Materias> materias = (List<Materias>) request.getAttribute("materias");
%>
<%
List<Voluntario> voluntarios = (List<Voluntario>) request.getAttribute("voluntarios");
%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<link rel="icon" href="../../assets/img/logo.png" />
<link rel="stylesheet" href="../../assets/css/style.css" />
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" />
<title>EducAgro | Criar Aula</title>
</head>
<body>
	<main>
		<header class="header">
			<h1>Aula</h1>
		</header>

		<ul class="nav justify-content-center">
			<li class="nav-item"><a class="nav-link active"
				aria-current="page" href="../../index.html">Home</a></li>
			<li class="nav-item"><a class="nav-link" href="../../aulas">Aulas</a>
			</li>
			<li class="nav-item"><a class="nav-link" href="../../professors">Materias</a>
			</li>
			<li class="nav-item"><a class="nav-link"
				href="../../professores">Professor</a></li>
			<li class="nav-item"><a class="nav-link" href="#">Voluntá¡rio</a>
			</li>
		</ul>

		<div class="container py-3">
			<form action="./create-aula">
				<h2 class="text-center">Criar Aula</h2>
				<div class="form-group mb-3">
					<label for="materia" class="form-label"> Matéria: </label>
					 <select
						name="materia">
						<option value="">Selecionar</option>
						<%
						for (Materias materia : materias) {
						%>
						<option value="<%=materia.getNome() %>"><%=materia.getNome()%></option>
						<%
						}
						%>
					</select> <label for="professor" class="form-label"> Professor: </label> <select
						name="professor">
						<option value="">Selecionar</option>
						<%
						for (Professor professor : professores) {
						%>
						<option value="<%=professor.getNome() %>"><%=professor.getNome()%></option>
						<%
						}
						%>
					</select> <label for="voluntario" class="form-label"> Voluntário: </label> <select
						name="voluntario">
						<option value="">Selecionar</option>
						  	<%for(Voluntario voluntario : voluntarios){ %>
	                		<option value="<%=voluntario.getNome()%>"><%=voluntario.getNome() %></option>
	                	<%} %>
					</select>
				</div>

				<button type="submit" class="btn btn-primary">Enviar</button>
				<a href="../../aulas" class="btn btn-danger"
					style="margin-left: 10px"> Cancelar </a>
			</form>
		</div>

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

	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
</body>
</html>