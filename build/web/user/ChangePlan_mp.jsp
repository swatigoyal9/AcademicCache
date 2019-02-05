 

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Academic Cache</title>
        <jsp:include page="stylesheet.jsp"/>
    </head>
    <body>
        <table border="0" cellpadding="0" cellspacing="0" width="100%">
            <tr>
                <td>
                    <jsp:include page="header.jsp"/>
                </td>
            </tr>
            <tr>
                <td>
                    <jsp:include page="topmenu.jsp"/>
                </td>
            </tr>
            <tr>
                <td>
                    <div id="content">
                        <jsp:include page="ChangePlan.jsp"/>
                    </div>
                </td>
            </tr>
            <tr>
                <td>
                    <jsp:include page="footer.jsp"/>
                </td>
            </tr>
        </table>
    </body>
</html>
