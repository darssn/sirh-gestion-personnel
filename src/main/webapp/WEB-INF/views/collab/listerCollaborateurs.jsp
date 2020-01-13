

<%@page import="dev.sgp.entite.Departement"%>
<%@page import="dev.sgp.entite.Collaborateur"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html lang="fr">

<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-tofit=
no">
<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
	integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
	crossorigin="anonymous">
<title>SGP - Accueil</title>
</head>

<body>

	<nav class="navbar navbar-expand-lg navbar-dark bg-dark">

		<img src="<c:url value='/img/arobase.png'></c:url>" width="30"
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
					href="<c:url value='lister'></c:url>">Collaborateurs</a></li>

				<li class="nav-item"><a class="nav-link" href="stats.html">Statistiques</a>
				</li>
				<li class="nav-item"><a class="nav-link" href="activites.html">Activités</a>
				</li>
			</ul>
		</div>


	</nav>
	<main class="container-fluid">

	<div class="row">
		<div class="col-12 mt-2">
			<h1>Les collaborateurs</h1>
		</div>

	</div>

	<div class="row mt-1" style="margin-bottom: 50px">
		<div class="col-12 col-xl-4 offset-xl-8 mt-2">
			<a class="btn btn-primary" href="<c:url value='nouveau'></c:url>"
				role="button">Ajouter un nouveau collaborateur</a>
		</div>
	</div>




	<form method="" action="#" style="margin-bottom: 60px">

		<div class="row">

			<div class="col-xl-3 col-12 text-xl-right ">

				<label for="recherche">Rechercher un nom ou un prénom qui
					commence par :</label>

			</div>

			<div class="col-xl-3 col-12 ">
				<input type="text" id="recherche" class="form-control">
			</div>

			<div class="col-xl-2 col-12 mt-2">
				<input type="checkbox" class="form-check-label"> Voir les
				collaborateurs désactivés
			</div>

		</div>

		<div class="row" style="margin-top: 20px">
			<div class="col-12 col-xl-3  text-xl-right">
				<label for="filtreDep">Filtrer par département : </label>
			</div>
			<div class="col-12 col-xl-3">

				<select id="filtreDep" name="filtre" class="form-control">
					<option value="Tous">Tous</option>

					<c:forEach items="${listeDep}" var="dep">
						<option value="<c:out value=' ${dep.nom} ' />"><c:out
								value=' ${dep.nom} ' /></option>
					</c:forEach>


				</select>
			</div>
		</div>


		<div class="row" style="margin-top: 20px">
			<div class="col-xl-2 offset-xl-5 offset-7">
				<button class="btn btn-primary" type="submit">Rechercher</button>
			</div>
		</div>

	</form>

	<div class="row">

		<c:forEach items="${listeCollab}" var="collab">

			<div class="col-12 col-xl-4   mb-2 mt-2">
				<div class="card">
					<h5 class="card-header">
						<c:out value="${collab.nom}" />
						<c:out value="${collab.prenom}" />
					</h5>
					<div class="card-body">
						<div class="row">
							<div class="col-12 col-xl-2 text-center">
								<img src="<c:url value='/img/${collab.photo}'/>" width="80" height="80">
							</div>
							<div class="col offset-xl-1">
								<div class="row">
									<div class="col">
										<p class="card-text">Fonction</p>
									</div>

									<div class="col">
										<p class="card-text">
											<c:out value="${collab.intitulePoste}" />
										</p>
									</div>
								</div>
								<div class="row">
									<div class="col">
										<p class="card-text">Département</p>
									</div>
									<div class="col">
										<p class="card-text">


											<c:out value="${collab.departement.nom}" />

										</p>

									</div>
								</div>
								<div class="row">
									<div class="col">
										<p class="card-text">Email</p>
									</div>
									<div class="col">
										<p class="card-text">
											<c:out value="${collab.emailPro}" />
										</p>
									</div>
								</div>
								<div class="row">
									<div class="col">
										<p class="card-text">Téléphone</p>
									</div>
									<div class="col">
										<p class="card-text">
											<c:out value="${collab.telephone}" />
										</p>
									</div>
								</div>
							</div>

						</div>

						<div class="row mb-1 mt-2 pt-2">
							<div class="col offset-8">
								<a class="btn btn-primary"
									href="<c:url value='editer?matricule=${collab.matricule}'></c:url>" role="button">Editer</a>
							</div>
						</div>
					</div>
				</div>
			</div>

		</c:forEach>
	</div>
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