<%@ page language="java" import="Pic"%>
<%@ page import="java.util.*"%>

<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
  <meta name="description" content="">
  <meta name="author" content="">
  <link rel="icon" href="../../favicon.ico">

  <title>Instagram Collection</title>

  <!-- Bootstrap core CSS -->
  <link href="assets/css/bootstrap.min.css" rel="stylesheet">

  <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
  <link href="assets/css/ie10-viewport-bug-workaround.css" rel="stylesheet">

  <!-- Custom styles for this template -->
  <link href="assets/css/index.css" rel="stylesheet">

</head>
<body>

  <div class="container">
    <div class="header clearfix">
      <h3 class="text-muted">Instagram Collection</h3>
    </div>

    <div class="jumbotron">

     <form class="form-horizontal" role="form" action="search.do" method="get">
      <div class="form-group">
        <label for="labelTag" class="col-sm-2 control-label">Tag</label>
        <div class="col-sm-10">
         <div class="input-group">
          <div class="input-group-addon">#</div>
          <input type="text" class="form-control" id="inputTag" name="tag" placeholder="pixlee">
        </div>
      </div>
    </div>
    <div class="form-group">
      <label for="labelStartDate" class="col-sm-2 control-label">Start Date</label>
      <div class="col-sm-10">
        <input type="date" class="form-control" id="inputStartDate" name="start" placeholder="yyyy-MM-dd">
      </div>
    </div>
    <div class="form-group">
      <label for="labelEndDate" class="col-sm-2 control-label">End Date</label>
      <div class="col-sm-10">
        <input type="date" class="form-control" id="inputEndDate" name="end" placeholder="yyyy-MM-dd">
      </div>
    </div>

    <div class="form-group">
      <div class="col-sm-offset-2 col-sm-10">
        <input type="submit" class="btn btn-default" name="action" value="Search"/>
      </div>
    </div>
  </form>
</div>

<div class="container">
  <div class="row">
   <c:forEach var="pic" items="${picArray}" varStatus="count">
      <div class="col-md-4">
        88<a href="${pic.link}"><img src="${pic.url}"/></a>
      </div>

  
</c:forEach>          

</div>
</div>



</body>
</html>
