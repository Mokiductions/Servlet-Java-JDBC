<%-- 
    Document   : index
    Created on : 19-oct-2016, 17:45:56
    Author     : gines
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JDBC Servlet</title>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>
        <script>
            $(document).ready(function () {
                $('#alumnesList').change(function (event) {
                    // Aquí la carga de la información de cada alumno al cambiar la selección
                    var dataString = "code=" + $('#alumnesList').val() + "&name=" + $('#alumnesList option:selected').text();
                    $.ajax({
                        type: "POST",
                        url: "DbServlet",
                        data: dataString,
                        success: function (responseJson) {
                            $.each(responseJson, function (key, value) {
                                $('#infoAlumne').html(value['nom']);
                                $('#asi').show();
                                $('#listAssignatures').html(value['assignatures']);
                                $('#tut').show();
                                $('#listTutories').html(value['tutories']);
                            });

                        }
                    });

                });
                $.get('DbServlet', function (responseJson) {
                    if (responseJson !== null) {
                        var alumnSelect = $('#alumnesList');
                        alumnSelect.find('option').remove();
                        $.each(responseJson, function (key, value) {
                            $('<option>').val(value['codi']).text(value['nom']).appendTo(alumnSelect);
                        });
                    }
                });
            });
        </script>
    </head>
    <body style="font-family: arial;">
        <h1 style="padding-left: 80px;">Información por alumno</h1>
        <br/>
        <select id="alumnesList" style="font-size: 25px; margin-left: 80px;">
        </select>
        <br/><br/>
        <div>
            <div id="infoAlumne" style="padding-left: 80px; margin-top: 15px; margin-bottom:20px; background-color: grey; font-size: 40px; font-weight: bold;"></div>
            <span id="asi" style="padding-left: 100px; display: none; font-size: 32px;">Assignatures:</span><br/>
            <div id="listAssignatures" style="margin-bottom:20px; padding-left: 130px; font-size: 22px;"></div>
            <span id="tut" style="padding-left: 100px; display: none; font-size: 32px;">Tutoríes:</span><br/>
            <div id="listTutories" style="padding-left: 130px; font-size: 22px;"></div>
        </div>
    </body>
</html>
