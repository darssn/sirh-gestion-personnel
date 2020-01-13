<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html lang="fr">

<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-tofit=
no">
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
        integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <title>SGP - Accueil</title>
</head>

<body>

    <nav class="navbar navbar-expand-lg navbar-dark bg-dark">

      	<img src="<c:url value='/img/arobase.png'></c:url>" width="30"
			height="30" alt="">


        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
            aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>


        <div class="collapse navbar-collapse ml-2" id="navbarSupportedContent">


            <ul class="navbar-nav mr-auto nav-pills">
                <li class="nav-item ">
                    <a class="nav-link"  href="<c:url value='lister'></c:url>">Collaborateurs</a>
                </li>

                <li class="nav-item">
                    <a class="nav-link active" href="<c:url value='statistiques'></c:url>">Statistiques</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="activites.html">Activités</a>
                </li>
            </ul>
        </div>


    </nav>
    <main class="container-fluid">


        <div class="row mt-1">

            <div class="col-12 col-xl-12 mt-2">
                <h1>Statistiques</h1>
            </div>

        </div>

        <div class="row mt-1" style="margin-bottom : 50px">
            <div class="col-12 col-xl-4 offset-xl-8 mt-2">
                <a class="btn btn-primary" href="<c:url value='nouveau'></c:url>" role="button">Ajouter un nouveau collaborateur</a>
            </div>
        </div>

        <div class="row" style="margin-top:100px">

            <div class="col-12 col-xl-12">

             
                    <table class="table table-striped table-bordered ">
                        <thead>
                            <tr>
                                <th scope="col">Chemin</th>
                                <th scope="col">Nombre de visites</th>
                                <th scope="col">Min (ms)</th>
                                <th scope="col">Max (ms)</th>
                                <th scope="col">Moyenne (ms)</th>
                            </tr>
                        </thead>
                        <tbody>
                        
                      
                        
                        <c:forEach var="stats" items="${stats}" >
                        <tr>
                        
                                <td><c:out value="${stats.path}"/></td>
                                 <td><c:out value="${stats.nbVisite}"/></td>
                                <td><c:out value="${stats.tempsMin}"/></td>
                                 <td><c:out value="${stats.tempsMax}"/></td>
                                 <td><c:out value="${stats.moyenne}"/></td>
                        </tr>
                                              
                        </c:forEach>
  
                         
                        </tbody>

                    </table>
                

            </div>
        </div>
    </main>

    <!-- TODO -->
    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-
J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
        integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
        crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"
        integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6"
        crossorigin="anonymous"></script>
</body>

</html>