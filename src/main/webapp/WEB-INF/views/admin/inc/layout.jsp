<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title><%-- <tiles:getAsString name="title"/> --%></title>
    <link href="../../css/style.css" type="text/css" rel="stylesheet" />
    <script defer src="../../js/list.js"></script>
    <%-- <script defer src="<tiles:getAsString name="js" />"></script> --%>
    <c:set var="js"><tiles:getAsString name="js" /></c:set>
    <script defer src="${js}"></script>
  </head>

  <body>
    <div id="root">
      <!--  header -->
      <tiles:insertAttribute name="header"/>
      <div id="visual">
        <div class="float-content"></div>
      </div>

      <div id="body">
        <div class="float-content">
          <!--  aside -->
          <tiles:insertAttribute name="aside"/>
          <!--  main -->
          <tiles:insertAttribute name="main"/>
        </div>
      </div>

      <!--  footer -->
      <tiles:insertAttribute name="footer"/>
    </div>
  </body>
</html>
