<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> 
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>View <c:out value="${book.title}" /></title>
    <link rel="stylesheet" href="/webjars/bootstrap/4.5.0/css/bootstrap.min.css" />
    <script src="/webjars/jquery/3.5.1/jquery.min.js"></script>
    <script src="/webjars/bootstrap/4.5.0/js/bootstrap.min.js"></script>
  </head>
  <body>
    <div class="container mt-5">
      <a href="/books/" class="btn btn-primary my-2"">Back</a>
      <div class="card mt-2 p-3">
        <h1 class="card-title"><c:out value="${book.title}" /></h1>
        <p>Description: <c:out value="${book.description}" /></p>
        <p>Language: <c:out value="${book.language}" /></p>
        <p>Number of pages: <c:out value="${book.numberOfPages}" /></p>

        <div class="row">
          <div class="col">
            <a href="/books/${book.id}/edit" class="btn btn-primary btn-block">Edit Book</a>
          </div>
            <form class="col" action="/books/${book.id}" method="post">
              <input type="hidden" name="_method" value="delete" />
              <input type="submit" value="Delete" class="btn btn-danger btn-block" />
            </form>
        </div>
        
      </div>
    </div>
  </body>
</html>
