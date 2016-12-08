<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

    <script type="text/javascript" src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

    <link rel="stylesheet" type="text/css" href="/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="/css/style.css">
    <link rel="icon" href="favicon.ico" />
    <title>Statistics</title>
</head>
<body>
<div class="content-wrapper">

    <%@ include file="/include/header.html" %>

    <div class="before-footer">

        <div class="panel panel-default">
            <div class="panel-heading text-center">
                <h4>Users statistics</h4>
            </div>
            <div class="panel-body">
                <form class="form-horizontal" action="/user" method="POST" role="form" id="form">
                    <div class="form-group">
                        <div for="name" class="col-xs-4 test-right"><strong>Total users num:</strong></div>
                        <div class="col-xs-7">
                            ${usersNum}
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-xs-4 test-right"><strong>Admins:</strong></div>
                        <div class="col-xs-7">
                            ${userGroups[0]["count"]}
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-xs-4 test-right"><strong>Guests:</strong></div>
                        <div class="col-xs-7">
                            ${userGroups[1]["count"]}
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-xs-4 test-right"><strong>Operators:</strong></div>
                        <div class="col-xs-7">
                            ${userGroups[2]["count"]}
                        </div>
                    </div>
                </form>
            </div>

            <div class="panel-footer">
                <div class="row">
                    <div class="col-sm-3">
                        <a href="/cityconstatistics/users" class="btn btn-primary btn-block center-block">Users</a>
                    </div>
                    <div class="col-sm-3">
                        <a href="/cityconstatistics/cities" class="btn btn-primary btn-block center-block">Cities</a>
                    </div>
                    <div class="col-sm-3">
                        <a href="/cityconstatistics/routers" class="btn btn-primary btn-block center-block">Routers</a>
                    </div>
                    <div class="col-sm-3">
                        <a href="/cityconstatistics/connections" class="btn btn-primary btn-block center-block">Connections</a>
                    </div>
                </div>
            </div>


        </div>
    </div>

    <%@ include file="/include/footer.html" %>

</div>
</body>


</html>