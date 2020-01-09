<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<html lang="fr">

<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-tofit=no">
<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/bootstrap-4.4.1-dist/css/bootstrap.css">
<title>SGP - App</title>
</head>

<body>

	<nav class="navbar navbar-expand-lg navbar-dark bg-dark"> <img
		src="<%=request.getContextPath()%>/img/arobase.png" width="30"
		height="30" alt="">

	<button class="navbar-toggler" type="button" data-toggle="collapse"
		data-target="#navbarSupportedContent"
		aria-controls="navbarSupportedContent" aria-expanded="false"
		aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>


	<div class="collapse navbar-collapse ml-2" id="navbarSupportedContent">


		<ul class="navbar-nav mr-auto nav-pills">
			<li class="nav-item "><a class="nav-link active "
				href="<%=application.getContextPath()%>/collaborateurs/lister">Collaborateurs</a>
			</li>

			<li class="nav-item"><a class="nav-link" href="stats.html">Statistiques</a>
			</li>
			<li class="nav-item"><a class="nav-link" href="activites.html">Activités</a>
			</li>
		</ul>
	</div>


	</nav>

	<main class="container-fluid ">


	<div class="row">
		<div class="col-12 mt-2 ">
			<h1>Nouveau Collaborateur</h1>
		</div>
	</div>

	<!--   <a class="btn btn-primary" href="creer_errors.html" role="button">Afficher les erreurs formulaire</a> -->

	<form method="post" action="nouveau" style="margin-top: 50px"
		class="offset-xl-1">

		<div class="row mt-2 mb-2">
			<div class="col-12 col-xl-3">
				<label for="nom">Nom</label>
			</div>
			<div class="col-12 col-xl-6">
				<input type="text" id="nom" name="nom" value="<%=request.getAttribute("nom") %>" 
				
					class="form-control <%if ((Boolean)request.getAttribute("checkNom") == false) {%>                   
                    is-invalid            
                    <%}%>">

				<div class="invalid-feedback">Le nom est obligatoire.</div>
			</div>


		</div>

		<div class="row mb-2 mt-2">
			<div class="col-12 col-xl-3">
				<label for="prenom">Prénom</label>
			</div>
			<div class="col-12 col-xl-6">
				<input type="text" id="prenom" name="prenom" value="<%=request.getAttribute("prenom") %>" 
					class="form-control <%if  ((Boolean)request.getAttribute("checkPrenom") == false)  {%>                   
                    is-invalid            
                    <%}%>">
                    <div class="invalid-feedback">Le prenom est obligatoire.</div>
			</div>
			

		</div>

		<div class="row mb-2 mt-2">
			<div class="col-12 col-xl-3">
				<label for="dateNaissance">Date de naissance</label>
			</div>
			<div class="col-12 col-xl-6"> 
				<input type="date" id="dateNaissance" name="dateNaissance" value="<%=request.getAttribute("dateN") %>" 
					class="form-control <%if  ((Boolean)request.getAttribute("checkDateN") == false)  {%>                   
                    is-invalid            
                    <%}%>">
                    <div class="invalid-feedback">La date de naissance est
				obligatoire.</div>
			</div>
			

		</div>


		<div class="row mb-2 mt-2">
			<div class="col-12 col-xl-3">
				<label for="adresse">Adresse</label>
			</div>
			<div class="col-12 col-xl-6">
				<textarea id="adresse" name="adresse" rows="3" value="<%=request.getAttribute("adresse") %>" 
					class="form-control <%if ((Boolean)request.getAttribute("checkAdresse") == false)  {%>                   
                    is-invalid            
                    <%}%>"></textarea>
                    <div class="invalid-feedback">L'adresse est
				obligatoire.</div>
			</div>
			

		</div>



		<div class="row mb-2 mt-2">
			<div class="col-12 col-xl-3">
				<label for="numSS">Numéro de sécurité social</label>
			</div>
			<div class="col-12 col-xl-6">
				<input type="text" id="numSS" name="numSS" value="<%=request.getAttribute("numSS") %>" 
					class="form-control <%if ((Boolean)request.getAttribute("checkNumSS") == false) {%>                   
                    is-invalid            
                    <%}%>">
                    <div class="invalid-feedback">Le numero de sécurité social de
				naissance est obligatoire.</div>
			</div>
			
		</div>



		<div class="row" style="margin-top: 20px; margin-bottom: 50px;">
			<div class="col offset-8">
				<button class="btn btn-primary" type="button" data-toggle="modal"
					data-target="#formModal">Créer</button>
			</div>
		</div>

		<!-- Modal -->
		<div class="modal fade" id="formModal" tabindex="-1" role="dialog"
			aria-labelledby="exampleModalLabel" aria-hidden="true">
			<div class="modal-dialog" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title" id="exampleModalLabel">Création d'un
							collaborateur</h5>
					</div>
					<div class="modal-body">
						<div class="row">
							<div class="col">
								<p>Vous êtes sur le point de créer un nouveau collaborateur</p>
							</div>
						</div>
						<div class="row">
							<div class="col">
								<p>Nom</p>
							</div>
							<div class="col">*************</div>
						</div>
						<div class="row">
							<div class="col">
								<p>Prenom</p>
							</div>
							<div class="col">*************</div>
						</div>
						<div class="row">
							<div class="col">
								<p>Date de naissance</p>
							</div>
							<div class="col">*************</div>
						</div>
						<div class="row">
							<div class="col">
								<p>Adresse</p>
							</div>
							<div class="col">*************</div>
						</div>
						<div class="row">
							<div class="col">
								<p>Numéro de sécurité sociale</p>
							</div>
							<div class="col">*************</div>
						</div>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-secondary"
							data-dismiss="modal">Annuler</button>
						<button type="submit" class="btn btn-primary">Confirmer</button>
					</div>
				</div>
			</div>
		</div>



	</form>



	</main>


	<!-- TODO -->
	<!-- Optional JavaScript -->
	<!-- jQuery first, then Popper.js, then Bootstrap JS -->
	<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"
		integrity="sha384-
J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
		integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"
		integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6"
		crossorigin="anonymous"></script>
</body>

</html>