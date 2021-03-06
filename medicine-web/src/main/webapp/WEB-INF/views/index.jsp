<%--
    JBoss, Home of Professional Open Source
    Copyright 2013, Red Hat, Inc. and/or its affiliates, and individual
    contributors by the @authors tag. See the copyright.txt in the
    distribution for a full listing of individual contributors.

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at
    http://www.apache.org/licenses/LICENSE-2.0
    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>

<head>
<title>Medicine</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" type="text/css"
	href="<c:url value="/static/resources/css/screen.css"/>" />
</head>

<body>
	<div id="container">
		<h1>Welcome to Medicine!</h1>

		<div >
			<c:out value="${msg}"/>
		</div>
		
		<h2>Incidents</h2>
		
		
		<c:choose>
			<c:when test="${incidents.size()==0}">
				<em>No registered Incidents.</em>
			</c:when>
			<c:otherwise>
				<table id="membersTable" class="simpletablestyle">
					<thead>
						<tr>
							<th>incidentNumber</th>
							<th>priority</th>
							<th>impact</th>
							<th>urgency</th>

						</tr>
					</thead>
					<tbody>
						<c:forEach items="${incidents}" var="incident">
							<tr>
								<td>${incident.incidentNumber}</td>
								<td>${incident.priority}</td>
								<td>${incident.impact}</td>
								<td>${incident.urgency}</td>

							</tr>
						</c:forEach>
					</tbody>
				</table>
			</c:otherwise>
		</c:choose>




	</div>
	<div id="footer">
		<p>
			This project was generated from a Maven archetype from JBoss.<br />
		</p>
	</div>
</body>
</html>