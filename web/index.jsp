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
                // Acciones al hacer click en '#xmlBtn'
                $('#xmlBtn').click(function () {
                    var dataString = "code=" + $('#alumnesList').val();
                    $.ajax({
                        type: "GET",
                        url: "XmlServlet",
                        dataType: "text",
                        data: dataString,
                        success: function (response) {
                            $('#xmlH').show();
                            $('#xmlB').show();
                            $('#xmlB').text(response);
                            $('#xmlBtn').prop('disabled', true);
                        }
                    });
                });

                // Acciones al cambiar la selección del ComboBox
                $('#alumnesList').change(function (event) {
                    $('#xmlH').hide();
                    $('#xmlB').hide();
                    $('#xmlBtn').prop('disabled', false);
                    var dataString = "code=" + $('#alumnesList').val();
                    $.ajax({
                        type: "POST",
                        url: "DbServlet",
                        dataType: "json",
                        data: dataString,
                        success: function (responseJson) {
                            $('#infoAlumne').html(responseJson.nom);
                            $('#asi').show();
                            var assignatures = "";
                            $.each(responseJson.assignatures, function (key, value) {
                                assignatures += value + "<br/>";
                            });
                            $('#listAssignatures').html(assignatures);
                            $('#tut').show();
                            var tutories = "";
                            $.each(responseJson.tutories, function (key, value) {
                                tutories += value + "<br/>";
                            });
                            $('#listTutories').html(tutories);
                            $('#listAssignatures').show();
                            $('#listTutories').show();
                            $('#infoAlumne').show();
                        }
                    });
                });

                // Carga de opciones de la ComboBox
                $.ajax({
                    type: "GET",
                    url: "DbServlet",
                    dataType: "json",
                    success: function (responseJson) {
                        if (responseJson !== null) {
                            var alumnSelect = $('#alumnesList');
                            alumnSelect.find('option').remove();
                            $.each(responseJson, function (key, value) {
                                $('<option>').val(value['codi']).text(value['nom']).appendTo(alumnSelect);
                            });
                            $('#alumnesList').prop('disabled', false);
                        }
                    }
                });
            });
        </script>
    </head>
    <body style="font-family: arial; background-color: #e6e6e6;">
        <h1 style="padding-left: 80px;">Información por alumno</h1>
        <br/>
        <select id="alumnesList" style="font-size: 25px; margin-left: 80px;" disabled>
            <option>Cargando lista de alumnos...</option>
        </select><input type="button" id="xmlBtn" style="font-size: 25px; margin-left: 70px;" value="Obtenir XML" disabled/>
        <br/><br/>
        <div>
            <div id="infoAlumne" style="padding-left: 80px; margin-top: 15px; margin-bottom:20px; background-color: grey; font-size: 40px; font-weight: bold;"></div>
            <div style="float: left; width: 47%;">
                <span id="asi" style="padding-left: 100px; display: none; font-size: 32px;">Assignatures:</span><br/>
                <div id="listAssignatures" style="margin-bottom:20px; padding-left: 130px; font-size: 22px;"></div>
                <span id="tut" style="padding-left: 100px; display: none; font-size: 32px;">Tutoríes:</span><br/>
                <div id="listTutories" style="padding-left: 130px; font-size: 22px;"></div>
            </div>
            <div style="float: left; width: 47%; padding-left: 30px;">
                <span id="xmlH" style="padding-left: 40px; display: none; font-size: 32px;">Codi XML:</span><br/>
                <pre lang="xml" id="xmlB" style="display: none; background-color:#EFF0F1; border: 1px solid black; border-radius: 8px; padding: 20px;"></pre>
            </div>
        </div>
    </body>
</html>
