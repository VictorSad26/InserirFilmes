<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Filme</title>
</head>
<body>
	<h1>Filme id: ${filme.id}</h1>
	<p><strong>Título:</strong>${filme.titulo}</p>
	<p><strong>Descricao:</strong>${filme.descricao}</p>
	<p><strong>Popularidade:</strong>${filme.popularidade}</p>
	<p><strong>Diretor:</strong>${filme.diretor}</p>
	<p><strong>Genero</strong>${filme.genero.nome}</p>
	<p><img src="${filme.posterPath}"/><br>
	
</body>
</html>