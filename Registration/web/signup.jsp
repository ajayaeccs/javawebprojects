<%-- 
    Document   : signup
    Created on : 23-May-2021, 3:46:27 PM
    Author     : Ajay Srivastava
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Signup</title>
        <!--Import Google Icon Font-->
        <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
        <!-- Compiled and minified CSS -->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css">
        <!-- Compiled and minified JavaScript -->
        <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js"></script>
    </head>
    <body style="background: url(img/dairy_background_1.jpg); background-size: cover; background-attachment: fixed;">
        <div class="container">
            <div class="row">
                <div class="col s12 m5 offset-m3">
                    <div class="card">
                        <div class="card-content">
                            <h4 style="margin-top: 10px;">Registration Form</h4>
                            <h6 id="msg"></h6>
                            <br/>
                            <div class="form center-align">
                                <form id="myform" action="register" method="post">
                                    <div class="row">
                                        <div class="input-field">
                                            <span class="material-icons prefix">account_circle</span>
                                            <input id="name" type="text" name="name" class="validate" required="true">
                                            <label for="name">*Name</label>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="input-field">
                                            <span class="material-icons prefix">lock</span>
                                            <input id="password" type="password" name="password" class="validate" required="true" minlength="6">
                                            <label for="password">*Password</label>

                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="input-field">
                                            <span class="material-icons prefix">email</span>
                                            <input id="email" type="email" name="email" class="validate">
                                            <label for="email">Email</label>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="input-field">
                                            <span class="material-icons prefix">contact_phone</span>
                                            <input id="contact" type="tel" name="contact" class="validate" required="true" minlength="10" pattern="[0-9]{10}">
                                            <label for="contact">*Contact <small>(10 digit number)</small></label>
                                        </div>
                                    </div>

                                    <button class="btn waves-effect waves-light" type="submit">Submit
                                        <i class="material-icons right">send</i>
                                    </button>
                                </form>
                            </div>
                            <div class="loader center-align" style="margin-top: 10px; display: none">
                                <h6>Please wait ...</h6>
                                <div class="preloader-wrapper small active">
                                    <div class="spinner-layer spinner-green-only">
                                        <div class="circle-clipper left">
                                            <div class="circle"></div>
                                        </div><div class="gap-patch">
                                            <div class="circle"></div>
                                        </div><div class="circle-clipper right">
                                            <div class="circle"></div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <script src="https://code.jquery.com/jquery-3.6.0.min.js"
                integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4="
        crossorigin="anonymous"></script>

        <script>
            $(document).ready(function () {
                console.log("Page is ready ...");

                $("#myform").on('submit', function (event) {
                    event.preventDefault();
                    var f = $(this).serialize();
                    console.log(f);

                    $(".loader").show();

                    $.ajax({url: "register",
                        data: f,
                        type: 'post',
                        success: function (data, textStatus, jqXHR) {
                            console.log(data);
                            console.log("success");
                            $(".loader").hide();
                            if (data.trim() === 'Done') {
                                $("#msg").html("User successfully registered!");
                                $("#msg").addClass("green-text");
                            } else {
                                $("#msg").html("Something went wrong!");
                                $("#msg").addClass("red-text");
                            }
                        },
                        error: function (jqXHR, textStatus, errorThrown) {
                            console.log(data);
                            console.log("error");
                            $(".loader").hide();
                            $("#msg").html("Error occurred at server!");
                            $("#msg").addClass("red-text");
                        }
                    });
                });
            });
        </script>
    </body>
</html>
