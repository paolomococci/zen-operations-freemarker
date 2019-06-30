<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no"/>
    <meta http-equiv="x-ua-compatible" content="ie=edge"/>
    <meta name="description" content=""/>
    <meta name="author" content="Paolo Mococci"/>
    <link type="text/css" rel="stylesheet" media="all" href="/webjars/font-awesome/5.8.2/css/all.css"/>
    <link type="text/css" rel="stylesheet" media="all" href="/webjars/bootstrap/4.3.1/css/bootstrap.min.css"/>
    <link type="text/css" rel="stylesheet" media="all" href="/css/style.css">
    <link type="text/css" rel="stylesheet" media="all" href="/css/statistical-panel.css">
    <title>Zen Operations Statistical Panel</title>
</head>
<body>
    <header>
        <nav class="navbar fixed-top navbar-light bg-light flex-md-nowrap p-0 shadow">
            <a class="navbar-brand col-sm-3 col-md-2 mr-0" href="root">Zen Operations</a>
            <input class="form-control form-control-dark w-100" type="text" placeholder="Search" aria-label="Search">
        </nav>
    </header>
    <div class="container-fluid">
        <div class="row">
            <nav class="col-md-2 d-none d-md-block bg-light sidebar">
                <div class="sidebar-sticky">
                    <ul class="nav flex-column">
                        <li class="nav-item">
                            <a class="nav-link active" href="#">
                                <span data-feather="bookmark"></span>
                                colors<span class="sr-only">(current)</span>
                            </a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="#">
                                <i data-feather="bookmark"></i>fruits
                            </a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="#">
                                <i data-feather="bookmark"></i>products
                            </a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="#">
                                <i data-feather="bookmark"></i>customers
                            </a>
                        </li>
                    </ul>
                </div>
            </nav>
            <main role="main" class="col-md-9 ml-sm-auto col-lg-10 px-4">
                <canvas class="my-4 w-100" id="statisticalPanelChart" width="900" height="300"></canvas>
                <h2>data table</h2>
                <div class="table-responsive">
                    <table id="dataColors" class="table table-striped table-sm">
                        <thead>
                            <tr>
                                <th>color</th>
                                <th>liking</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td class="colors">
                                    red
                                </td>
                                <td class="likings">
                                    0.23
                                </td>
                            </tr>
                            <tr>
                                <td class="colors">
                                    blue
                                </td>
                                <td class="likings">
                                    0.32
                                </td>
                            </tr>
                            <tr>
                                <td class="colors">
                                    yellow
                                </td>
                                <td class="likings">
                                    0.12
                                </td>
                            </tr>
                            <tr>
                                <td class="colors">
                                    green
                                </td>
                                <td class="likings">
                                    0.33
                                </td>
                            </tr>
                        </tbody>
                    </table>
                </div>
            </main>
        </div>
    </div>
    <footer class="fixed-bottom">
        <nav class="navbar navbar-expand-md navbar-light bg-light">
            <ul class="navbar-nav mr-auto">
                <li class="nav-item active">
                    <a class="nav-link" href="home">home</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="admin">admin</a>
                </li>
            </ul>
        <nav>
    </footer>
    <script src="/webjars/jquery/3.4.1/jquery.min.js" type="text/javascript"></script>
    <script src="/webjars/bootstrap/4.3.1/js/bootstrap.bundle.min.js" type="text/javascript"></script>
    <script src="/webjars/feather-icons/4.22.1/dist/feather.min.js" type="text/javascript"></script>
    <script src="/webjars/chart.js/2.8.0/dist/Chart.min.js" type="text/javascript"></script>
    <script src="/js/statistical-panel.js" type="text/javascript"></script>
</body>
</html>
