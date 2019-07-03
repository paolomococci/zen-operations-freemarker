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
    <link type="text/css" rel="stylesheet" media="all" href="/css/control-panel.css">
    <title>Zen Operations Control Panel</title>
</head>
<body>
    <header>
        <nav class="navbar fixed-top navbar-light bg-light flex-md-nowrap p-0 shadow">
            <a class="navbar-brand col-sm-3 col-md-2 mr-0" href="/root">Zen Operations</a>
            <input class="form-control form-control-dark w-100" type="text" placeholder="Search" aria-label="Search">
            <ul class="navbar-nav px-3">
                <li class="nav-item text-nowrap">
                    <a class="nav-link" href="/login">sign out</a>
                </li>
            </ul>
        </nav>
    </header>
    <div class="container-fluid">
        <div class="row">
            <nav class="col-md-2 d-none d-md-block bg-light sidebar">
                <div class="sidebar-sticky">
                    <ul class="nav flex-column">
                        <li class="nav-item">
                            <a class="nav-link active" href="#">
                                <span data-feather="home"></span>
                                control panel <span class="sr-only">(current)</span>
                            </a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="#">
                                <i data-feather="file"></i>orders
                            </a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="#">
                                <i data-feather="shopping-cart"></i>products
                            </a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="#">
                                <i data-feather="users"></i>customers
                            </a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="#">
                                <i data-feather="bar-chart-2"></i>reports
                            </a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="#">
                                <i data-feather="layers"></i>integrations
                            </a>
                        </li>
                    </ul>
                    <h6 class="sidebar-heading d-flex justify-content-between align-items-center px-3 mt-4 mb-1 text-muted">
                        <span>Saved reports</span>
                        <a class="d-flex align-items-center text-muted" href="#">
                            <i data-feather="plus-circle"></i>
                        </a>
                    </h6>
                    <ul class="nav flex-column mb-2">
                        <li class="nav-item">
                            <a class="nav-link" href="#">
                                <i data-feather="file-text"></i>current month
                            </a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="#">
                                <i data-feather="file-text"></i>last quarter
                            </a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="#">
                                <i data-feather="file-text"></i>social engagement
                            </a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="#">
                                <i data-feather="file-text"></i>year-end sale
                            </a>
                        </li>
                    </ul>
                </div>
            </nav>
            <main role="main" class="col-md-9 ml-sm-auto col-lg-10 px-4">
                <div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
                    <h1 class="h2">control panel</h1>
                    <div class="btn-toolbar mb-2 mb-md-0">
                        <div class="btn-group mr-2">
                            <button type="button" class="btn btn-sm btn-outline-secondary">Share</button>
                            <button type="button" class="btn btn-sm btn-outline-secondary">Export</button>

                        </div>
                        <button type="button" class="btn btn-sm btn-outline-secondary dropdown-toggle">
                            <span data-feather="calendar"></span>
                            this week
                        </button>
                    </div>
                </div>
                <canvas class="my-4 w-100" id="cpChart" width="900" height="380"></canvas>
                <h2>Section title</h2>
                <div class="table-responsive">
                    <table class="table table-striped table-sm">
                        <thead>
                            <tr>
                                <th>data</th>
                                <th>data</th>
                                <th>data</th>
                                <th>data</th>
                                <th>data</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td>
                                    1.002
                                </td>
                                <td>
                                    3.345
                                </td>
                                <td>
                                    0.345
                                </td>
                                <td>
                                    7.321
                                </td>
                                <td>
                                    5.987
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    2.002
                                </td>
                                <td>
                                    4.345
                                </td>
                                <td>
                                    1.345
                                </td>
                                <td>
                                    8.321
                                </td>
                                <td>
                                    6.987
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    3.002
                                </td>
                                <td>
                                    5.345
                                </td>
                                <td>
                                    2.345
                                </td>
                                <td>
                                    9.321
                                </td>
                                <td>
                                    7.987
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    4.002
                                </td>
                                <td>
                                    6.345
                                </td>
                                <td>
                                    3.345
                                </td>
                                <td>
                                    10.321
                                </td>
                                <td>
                                    8.987
                                </td>
                            </tr>
                        </tbody>
                    </table>
                </div>
            </main>
        </div>
    </div>
    <script src="/webjars/jquery/3.4.1/jquery.min.js" type="text/javascript"></script>
    <script src="/webjars/bootstrap/4.3.1/js/bootstrap.bundle.min.js" type="text/javascript"></script>
    <script src="/webjars/feather-icons/4.22.1/dist/feather.min.js" type="text/javascript"></script>
    <script src="/webjars/chart.js/2.8.0/dist/Chart.min.js" type="text/javascript"></script>
    <script src="/js/control-panel.js" type="text/javascript"></script>
</body>
</html>
