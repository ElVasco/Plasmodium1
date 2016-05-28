<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter"%>
<%@ page import="org.springframework.security.web.WebAttributes"%>
<%@ page
	import="org.springframework.security.core.AuthenticationException"%>
<%@ include file="/include/IncludeHeaderStart.xhtml"%>
<html lang="en" xmlns="http://www.w3.org/1999/xhtml"
	xmlns:ui="http://java.sun.com/jsf/facelets"
	xmlns:h="http://java.sun.com/jsf/html"
	xmlns:p="http://primefaces.org/ui"
	xmlns:f="http://java.sun.com/jsf/core">

<body  >

	<form id="login" action="j_spring_security_check" method="post">



		<!-- <p class="register">Not a member? <a href="#">Register here!</a></p>-->
		<h9>Bienvenido, Ingrese sus datos</h9>
		<div>
			<label for="login_username">Usuario</label> <input type="text"
				name="j_username" id="login_username" class="field required"
				title="El usuario es requerido" maxlength="30" size="14" />

		</div>
		<div>
			<label for="login_password">Contraseña</label> <input type="password"
				name="j_password" id="pass" class="field required"
				title="La contraseña es requerida" maxlength="20" size="14" /><br>
				<input id="unmask" type="checkbox" onclick="checkmask()"/>Mostrar contraseña.

		</div>
		<p class="forgot"><a href="#">Olvido su contraseña?</a></p>

		<div class="submit">
			<center>
				<button type="submit">Ingresar</button>
			</center>

		</div>


		<!-- <p class="back"><a href="http://cssglobe.com/post/9688/the-anatomy-of-a-perfect-login-page">Go back to the article</a></p>-->



	</form>

	<!--  <a href="./pages/VendedorExterno.jsf">Registrarse como Vendedor Externo </a> -->
	<div id="badlogin">
		<c:out value="${SPRING_SECURITY_LAST_EXCEPTION.message}"/>

	</div>
	 
	<div class="cert">
		<!-- GeoTrust True Site [tm] Smart Icon tag. Do not edit. 
			<div class="cert">
		<script type="text/javascript" src="//smarticon.geotrust.com/si.js"></script>
	
			 end GeoTrust Smart Icon tag -->

	</div>

</body>
</html>
