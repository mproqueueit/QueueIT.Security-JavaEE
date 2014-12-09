<%@tag description="Master Page Template" pageEncoding="UTF-8"%>
<%@attribute name="title" fragment="true" %>
<%@attribute name="body" fragment="true" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <title><jsp:invoke fragment="title"/> - Reference Implementation</title>
        <meta name="viewport" content="width=device-width" />
        <link rel="stylesheet" href="Content/Site.css" />
    </head>
    <body id="<jsp:invoke fragment="title"/>">
        <header>
            <div class="content-wrapper">
                <div class="float-left">
                    <p class="site-title"><img src="Images/logo.jpg" alt=""/></p>
                </div>
                <div class="float-right">
                    <nav>
                        <ul id="menu">
                            <li><a href="index.jsp">Home</a></li>
                            <li><a href="simple.jsp">Simple</a></li>
                            <li><a href="advanced.jsp">Advanced</a></li>
                            <li><a href="codeonly.jsp">Code Only</a></li>
                            <li><a href="link.jsp">Link</a></li>
                        </ul>
                    </nav>
                </div>
            </div>
        </header>
        <div id="body">
            <section class="featured">
		        <div class="content-wrapper">
		            <hgroup class="title">
		                <h1><jsp:invoke fragment="title"/>.</h1>
		                <h2>Configuration of queues.</h2>
		            </hgroup>
		            <p>
		                To learn more about configuring queues, please contact Queue-it.
		            </p>
		        </div>
		    </section>
            <section class="content-wrapper main-content clear-fix">
                <jsp:invoke fragment="body"/>
            </section>
        </div>
        <footer>
            <div class="content-wrapper">
                <div class="float-left">
                    <p>&copy; 2013 - Queue-it</p>
                </div>
            </div>
        </footer>
    </body>
</html>