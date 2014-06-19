<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<!DOCTYPE html>
<html>
<head>
<title><spring:message code="application.global.title" /></title>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<meta name="description" content="Time Clock Demo Applicaton by Steve Carlson" />
<meta name="keywords" content="time clock demo" />
<link href="http://fonts.googleapis.com/css?family=Open+Sans:300,600,700" rel="stylesheet" />
<script src="js/jquery.min.js"></script>
<script src="js/config.js"></script>
<script src="js/skel.min.js"></script>
<noscript>
	<link rel="stylesheet" href="css/skel-noscript.css" />
	<link rel="stylesheet" href="css/style.css" />
	<link rel="stylesheet" href="css/style-desktop.css" />
</noscript>
</head>
</head>
<body>

	<!-- Home -->
	<div class="wrapper wrapper-style1 wrapper-first">
		<article class="container" id="top">
			<form:form commandName="timeclockUser" method="POST">
				<div class="row">
					<div class="6u">
						<spring:message code="application.global.description" htmlEscape="false" />
						
					</div>
					<div class="5u">
							<p>
								<strong><spring:message code="login.text.welcome_message" /></strong> <br />
								<spring:message code="login.text.instructions" />
							</p>
							
							<form:input path="emailAddress"/>
							<input type="submit" value='<spring:message code="login.button.login.text"/>' class="button" />
							<div><form:errors path="emailAddress" cssClass="fieldValidationError" element="div" htmlEscape="false"/></div>
							<div><spring:message code="${logoutMessage}" /></div>
							
							<div class="nonErrorSystemMessage">${logoutMessage}</div>
							<div>
								<spring:message code="login.text.demo_hint"/>
							</div>
						
					</div>
				</div>
			</form:form>
		</article>
	</div>

	<!-- Contact -->
	<div class="wrapper wrapper-style4">
		<article id="contact" class="container small">
			<header>
				<h2>Looking for an experienced developer or project manager?</h2>
				<span>I have a unique ability to quickly envision and
					organize a work-flow with a wide scope from cradle to grave
					maximizing the use of employee time and other valuable resources
					with over 15 years of professional experience in Java development,
					UI design, project management, and 4 years of database and systems
					administration.</span>
			</header>
			<div>
				<div class="row">
					<div class="12u"></div>
				</div>
				<div class="row">
					<div class="12u"><h3>I'm on ...</h3>
						<ul class="social">
							<li class="linkedin"><a
								href="https://www.linkedin.com/in/stevecarlsondsd"
								class="fa fa-linkedin" target="_blank"><span>LinkedIn</span></a></li>
						</ul>
						<a href="about.html">About this application</a>
					</div>
				</div>
			</div>
			<footer>
				<ul id="copyright">
					<li><spring:message code="application.global.footer.copyright" htmlEscape="false" /></li>
					<li><spring:message code="application.global.footer.language_select" htmlEscape="false" /></li>
				</ul>
			</footer>
		</article>
	</div>
</body>
</html>