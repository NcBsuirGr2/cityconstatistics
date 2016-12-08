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
                <h4>Cities statistics</h4>
            </div>
            <div class="panel-body">
                <form class="form-horizontal" action="/user" method="POST" role="form" id="form">
                    <div class="form-group">
                        <div class="col-xs-4 test-right"><strong>Total cities num:</strong></div>
                        <div class="col-xs-7">
                            ${citiesNum}
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-xs-4 test-right"><strong>City with max routers:</strong></div>
                        <div class="col-xs-7">
                            ${maxRouterCity["name"]}, ${maxRouterCity["routers"]} routers
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-xs-4 test-right"><strong>City with max connections:</strong></div>
                        <div class="col-xs-7">
                            ${maxConnectionCity["name"]}, ${maxConnectionCity["connections"]} connections
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-xs-4 test-right"><strong>Average connections per city:</strong></div>
                        <div class="col-xs-7">
                            ${avgConnectionsPerCity}
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