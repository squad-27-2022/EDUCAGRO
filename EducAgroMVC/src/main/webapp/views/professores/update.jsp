<%@ page 
	language="java" 
	contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<link rel="icon" href="./assets/img/book-2-fill.svg" type="image/svg" />
<link rel="stylesheet" href="./assets/css/style.css" />
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" />
<title>Educ Agro | Atualizar Professor</title>
</head>
<body>
	<main>
		<header class="header">
			<h1>Atualizar Professor</h1>
		</header>
		
		<ul class="nav justify-content-center">
		  <li class="nav-item">
		    <a class="nav-link active" aria-current="page" href="./index.html">Home</a>
		  </li>
		  <li class="nav-item">
		    <a class="nav-link" href="./aulas">Aulas</a>
		  </li>
		  <li class="nav-item">
		    <a class="nav-link" href="./materias">Materias</a>
		  </li>
		  <li class="nav-item">
		    <a class="nav-link" href="./professores">Professor</a>
		  </li>
		</ul>
		
		<div class="container py-3">
            <form action="./update">
	            <h2 class="text-center">Atualizar</h2>
	            
	            <div class="form-group mb-3">
	                <label for="id" class="form-label">
	                    Id
	                </label>
	                <input type="text" id="id" name="id" class="form-control"
	                value="<%=request.getAttribute("id") %>" readonly/>
	            </div>
	            
	            <div class="form-group mb-3">
	                <label for="nome" class="form-label">
	                    Nome
	                </label>
	                <input type="text" id="nome" name="nome"  class="form-control" 
	                value="<%=request.getAttribute("nome") %>" />
	            </div>
	            
	            <div class="form-group mb-3">
	                <label for="email" class="form-label">
	                    email
	                </label>
	                <input type="text" id="email" name="email" class="form-control" 
	                value="<%=request.getAttribute("email") %>" />
	            </div> 
	             <div class="form-group mb-3">
	                <label for="senha" class="form-label">
	                    senha
	                </label>
	                <input type="text" id="senha" name="senha" class="form-control" 
	                value="<%=request.getAttribute("senha") %>" />
	            </div> 
	            <button type="submit" class="btn btn-primary">
	                Enviar
	            </button>
	            <a href="./autores" class="btn btn-danger" style="margin-left: 10px">
	                Cancelar
	            </a>
            </form>
        </div>
		
    </main>
    
	<footer>
		<img
			src="./assets/img/recode.svg"
			alt="recodePro" />
	</footer>

	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
</body>
</html>