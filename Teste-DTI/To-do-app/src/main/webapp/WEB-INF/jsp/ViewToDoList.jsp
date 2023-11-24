<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lembretes</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/toastr.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/toastr.min.js"></script>

<style>
a {
	color: black;
	text-decoration: none;
}

a:hover {
	color: white;
	text-decoration: none;
}

.error-message {
	color: #FF4A3B;
}

body {
	background-color: #DDD2CE;
}

/* Botao Deletar */
.delete-button {
	width: 20px;
	height: 20px;
	border-radius: 50%;
	background-color: rgb(255, 69, 69);
	border: 1px solid rgb(218, 67, 67);
	font-weight: 600;
	display: flex;
	align-items: center;
	justify-content: center;
	box-shadow: 0px 0px 20px rgba(0, 0, 0, 0.164);
	cursor: pointer;
	transition-duration: 0.3s;
	overflow: hidden;
	position: center;
}

/*Botao Adicionar */
.add-button {
	display: flex;
	justify-content: center;
	align-items: center;
	padding: 9px 12px;
	gap: 8px;
	height: 40px;
	width: 80px;
	border: 1px solid #34974d;
	background: #3aa856;
	border-radius: 20px;
	cursor: pointer;
	font-weight: 700
}

.add-button:hover {
	color: white;
	text-decoration: none;
}

/*LEMBRETES */
.make {
	margin-left: 40px;
	font-family:  Verdana, sans-serif;;
}

.table{
border
}



</style>
</head>
<body>

	<!-- INICIO ADICIONAR LEMBRETE -->


	<div class="make">
		<h1 class="p-3" style="color: #454D40;">Novo Lembrete</h1>



		<form:form action="/saveToDoItem" method="post" modelAttribute="todo"
			id="todoForm">



			<!-- Colocar nome -->
			<div class="row">
				<div class="form-group col-md-12">
					<label for="colFormLabelLg"
						class="col-sm-2 col-form-label col-form-label-lg"
						style="color: black;">Nome</label>
					<div class="col-md-3">

						<form:input type="text" path="title" id="title"
							class="form-control input-sm" required="required" />
					</div>
				</div>
			</div>



			<div class="row">
				<div class="form-group col-md-12">
					<label for="colFormLabelLg"
						class="col-sm-2 col-form-label col-form-label-lg"
						style="color: black;">Data</label>
					<div class="col-md-3">
						<form:input type="date" path="date" id="date"
							class="form-control input-sm" required="required" />

						<!-- Exibir a mensagem de erro -->
						<div class="error-message" id="dateError"></div>
					</div>
				</div>
			</div>


			<!-- Botao "Salvar" -->
			<div class="row p-2">
				<div class="col-md-2">
					<button type="submit" id="saveButton" class="add-button">Criar</button>
				</div>
			</div>
		</form:form>
	</div>
	<!--FIM  ADICIONAR LEMBRETE -->



	<!-- INICIO LISTAR LEMBRETES -->
	<div class="make">
	
	<h1 class="p-3" style="color:#454D40;">Lista de Lembretes</h1>

	<form:form>
		<c:set var="currentDate" value="" />
		<table class="table table-sm table-borderless" style="margin-left: 40px; max-width: 600px;">
			<c:forEach var="todo" items="${list}">
				<c:set var="todoDate" value="${todo.date}" />
				<c:if test="${todoDate ne currentDate}">
					<tr>
						<th colspan="5"><span class="format-date">${todoDate}</span></th>
					</tr>	
					<c:set var="currentDate" value="${todoDate}" />
				</c:if>
				<tr>
					<td >${todo.title}</td>

					<td>
						<button type="button" class="delete-button">
							<a href="/deleteToDoItem/${todo.id}">-</a>
						</button>
					</td>
				</tr>
			</c:forEach>
		</table>
	</form:form>
	</div>
	<!-- FIM LISTAR LEMBRETES -->





	<script th:inline="javascript">
	
	
	window.onload = function() {
		var msg = "${message}";
		console.log(msg);
		if (msg === "Save Success") {
			Command: toastr["success"]("Lembrete Adicionado");
		} else if (msg === "Delete Success") {
			toastr.success("Lembrete Deletado");}
		

		toastr.options = {
			"closeButton" : true,
			"debug" : false,
			"newestOnTop" : false,
			"progressBar" : true,
			"positionClass" : "toast-top-right",
			"preventDuplicates" : false,
			"showDuration" : "100",
			"hideDuration" : "1000",
			"timeOut" : "1000",
			"extendedTimeOut" : "1000",
			"showEasing" : "swing",
			"hideEasing" : "linear",
			"showMethod" : "fadeIn",
			"hideMethod" : "fadeOut"
		}
	
	<!-- Inicio VALIDAR DATA -->
	

	    var dateInput = document.getElementById("date");
	    var dateError = document.getElementById("dateError");
	    var saveButton = document.getElementById("saveButton");

	    dateInput.addEventListener("input", function() {
	        var selectedDate = new Date(dateInput.value);
	        var currentDate = new Date();
	        if (selectedDate <= currentDate) {
	            dateError.innerHTML = "DATA INVALIDA!!";
	        } else {
	            dateError.innerHTML = "";
	        }
	    });

	    saveButton.addEventListener("click", function(event) {
	        var selectedDate = new Date(dateInput.value);
	        var currentDate = new Date();
	        if (selectedDate <= currentDate) {
	            toastr.error("A data deve ser no futuro.");
	            event.preventDefault(); // Prevent form submission
	        }
	    });
	
	
		<!-- Fim VALIDAR DATA -->
		
		<!-- Inicio FORMATAR DATA -->
	    function formatDateForDisplay(inputDate) {
	        var parts = inputDate.split('-');
	        if (parts.length === 3) {
	            return parts[2] + '/' + parts[1] + '/' + parts[0];
	        } else {
	            return inputDate; // If the input format is incorrect, return it as is
	        }
	    }

	    // Get all elements with the class "format-date" and format their content
	    var elements = document.querySelectorAll('.format-date');
	    elements.forEach(function(element) {
	        element.textContent = formatDateForDisplay(element.textContent);
	    });
		
	    <!--Fim FORMATAR DATA -->
	
		}
	</script>
</body>
</html>

