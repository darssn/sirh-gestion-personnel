<%@page import="dev.sgp.entite.Departement"%>
<%@page import="dev.sgp.util.Constantes"%>
<%@page import="dev.sgp.service.DepartementService"%>
<%@page import="dev.sgp.entite.Collaborateur"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!doctype html>
<html lang="fr">

<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-tofit=no">
<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
	integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
	crossorigin="anonymous">
<title>SGP - Accueil</title>
</head>

<body>

	<nav class="navbar navbar-expand-lg navbar-dark bg-dark">

		<img src="<%=request.getContextPath()%>/img/arobase.png" width="30" height="30" alt="">

		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>


		<div class="collapse navbar-collapse ml-2" id="navbarSupportedContent">


			<ul class="navbar-nav mr-auto nav-pills">
				<li class="nav-item "><a class="nav-link active "
					href="index.html">Collaborateurs</a></li>

				<li class="nav-item"><a class="nav-link" href="stats.html">Statistiques</a>
				</li>
				<li class="nav-item"><a class="nav-link" href="activites.html">Activités</a>
				</li>
			</ul>
		</div>
	</nav>

	<main class="container-fluid"> <%
 	Collaborateur col = (Collaborateur) request.getAttribute("collaborateur");
 %>


	<div class="row" style="margin-top: 50px">

		<div class="col-12 col-xl-3 text-center">
			<img src="<%=request.getContextPath()%>/<%=col.getPhoto()%>">
		</div>

		<div class="col-xl-7">
			<div class="row mb-2">
				<div class="col-xl-5 ">
					<h2><%=col.getNom()%>
						<%=col.getPrenom()%>
						-
						<%=col.getMatricule()%></h2>
				</div>
				<div class="col-xl-2 my-auto">
					<input type="checkbox" class="form-check-label"> Désactiver</input>
				</div>
			</div>

			<form action="editer" method="post" >
				<div class="row">
					<div class="col">
						<div class="accordion" id="accordionExample">
							<div class="card">
								<div class="card-header" id="headingOne">
									<h2 class="mb-0">
										<button class="btn btn-link" type="button"
											data-toggle="collapse" data-target="#collapseOne"
											aria-expanded="true" aria-controls="collapseOne">
											Identité</button>
									</h2>
								</div>

								<div id="collapseOne" class="collapse show"
									aria-labelledby="headingOne" data-parent="#accordionExample">
									<div class="card-body">

									<input type="hidden" value="<%=col.getMatricule()%>" name="matricule">
	

										<div class="row mt-2 mb-2">
											<div class="col-12 col-xl-4 text-xl-right">
												<label for="civ">Civilité</label>
											</div>
											<div class="col-12 col-xl-8">
												<select id="civ" name="civ" class="form-control">
													<option value="Mr">Mr</option>
													<option value="M">M</option>
												</select>
											</div>

										</div>

										<div class="row mt-2 mb-2">
											<div class="col-12 col-xl-4 text-xl-right">
												<label for="nom">Nom</label>
											</div>

											<div class="col-12 col-xl-8">
												<input type="text" id="nom" class="form-control" readonly
													value="<%=col.getNom()%>">
											</div>

										</div>

										<div class="row mt-2 mb-2">
											<div class="col-12 col-xl-4 text-xl-right">
												<label for="prenom">Prenom</label>
											</div>

											<div class="col-12 col-xl-8">
												<input type="text" id="prenom" class="form-control"
													value="<%=col.getPrenom()%>" readonly>
											</div>

										</div>

										<div class="row mt-2 mb-2">
											<div class="col-12  col-xl-4 text-xl-right">
												<label for="dateN">Date de naissance</label>
											</div>

											<div class="col-12 col-xl-8">
												<input type="date" id="dateN" class="form-control"
													value="<%=col.getDateNaissance()%>" readonly>
											</div>

										</div>
										<div class="row mt-2 mb-2">
											<div class="col-12 col-xl-4 text-xl-right">
												<label for="adresse">Adresse</label>
											</div>

											<div class="col-12 col-xl-8">
												<textarea id="adresse" name="adresse" class="form-control"
												><%=col.getAdresse()%></textarea>
											</div>

										</div>
										<div class="row mt-2 mb-2">
											<div class="col-12 col-xl-4 text-xl-right">
												<label for="numSS">Numéro de sécurité sociale</label>
											</div>

											<div class="col-12 col-xl-8">
												<input type="text" id="sumSS" class="form-control"
													value="<%=col.getNumSS()%>" readonly>
											</div>

										</div>
										<div class="row mt-2 mb-2">
											<div class="col-12 col-xl-4 text-xl-right">
												<label for="tel">Télephone</label>
											</div>

											<div class="col-12 col-xl-8">
												<input type="tel" id="tel" class="form-control">
											</div>

										</div>





									</div>
								</div>
							</div>
							<div class="card">
								<div class="card-header" id="headingTwo">
									<h2 class="mb-0">
										<button class="btn btn-link collapsed" type="button"
											data-toggle="collapse" data-target="#collapseTwo"
											aria-expanded="false" aria-controls="collapseTwo">
											Poste</button>
									</h2>
								</div>
								<div id="collapseTwo" class="collapse"
									aria-labelledby="headingTwo" data-parent="#accordionExample">
									<div class="card-body">



										<div class="row mt-2 mb-2">
											<div class="col-12 col-xl-3 text-xl-right">
												<label for="dep">Département</label>
											</div>
											<div class="col-12 col-xl-6">
												<select id="dep" name="dep" class="form-control">

													<%
														DepartementService depService = Constantes.DEP_SERVICE;

														for (Departement dep : depService.listerDepartement()) {

															if (col.getDepartement() != null) {

																if (dep.getNom().equals(col.getDepartement().getNom())) {
													%>

													<option value="<%=dep.getNom()%>" selected><%=dep.getNom()%></option>

													<%
														} else {
													%>

													<option value="<%=dep.getNom()%>"><%=dep.getNom()%></option>


													<%
														}
															} else {
													%>

													<option value="<%=dep.getNom()%>"><%=dep.getNom()%></option>

													<%
														}

														}
													%>

												</select>
											</div>

										</div>

										<div class="row mt-2 mb-2">
											<div class="col-12 col-xl-3 text-xl-right">
												<label for="nomPoste">Poste</label>
											</div>

											<div class="col-12 col-xl-6">
												<input type="text" name="poste" id="nomPoste" class="form-control"
													value="<%=col.getIntitulePoste()%>">
											</div>

										</div>



									</div>
								</div>
							</div>
							<div class="card">
								<div class="card-header" id="headingThree">
									<h2 class="mb-0">
										<button class="btn btn-link collapsed" type="button"
											data-toggle="collapse" data-target="#collapseThree"
											aria-expanded="false" aria-controls="collapseThree">
											Coordonnées Bancaires</button>
									</h2>
								</div>
								<div id="collapseThree" class="collapse"
									aria-labelledby="headingThree" data-parent="#accordionExample">
									<div class="card-body">


										<div class="row mt-2 mb-2">
											<div class="col-12 col-xl-3 text-xl-right">
												<label for="iban">IBAN</label>
											</div>

											<div class="col-12 col-xl-6">
												<input type="text" name="iban"id="iban" class="form-control"
													value="<%=col.getIban()%>">
											</div>

										</div>

										<div class="row mt-2 mb-2">
											<div class="col-12 col-xl-3 text-xl-right">
												<label for="bic">BIC</label>
											</div>

											<div class="col-12 col-xl-6">
												<input type="text" name="bic" id="bic" class="form-control"
													value="<%=col.getBic()%>">
											</div>

										</div>

									</div>
								</div>
							</div>
						</div>
					</div>

				</div>
				
				<div class="row mt-2 mb-2">
				<div class="col-2 offset-6 offset-xl-10 mt-2">

					<button type="submit" class="btn btn-primary">Sauvegarder</button>
				</div>
			</div>
			</form>
			
		</div>


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