<!DOCTYPE html>
<html>
    <head>
        <title>Login page</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!-- Client side validations that need to be handled in javascript,
              it can be handled in separate file or in same jsp -->
        <script type="text/javascript">
            function validateEmail(userName)
            {
                var emailFormat= /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
                if (userName.value.match(emailFormat))
                {
                    document.getElementById('password').focus();
                    return true;
                }
                else {
                    alert("you have entered an invalid email address");
                    document.getElementById('userName').focus();
                    return false;
                }
            }
        </script>
    </head>

    <body>

        <div class="main-container">
            <div class="heading-container">
                <h1>
                    Login to Accessories
                </h1>
            </div>
            <div class="form-field">
                <form action="/servletlogin" accept-charset="UTF-8" method="post" onclick="validateEmail(document.getElementById('email'))">
                    <fieldset class="email-container">
                        <label for="email">Username or Email</label>
                        <input type="text" name="email" id="email" autocomplete="on" autocapitalize="off" placeholder="Enter your email id" required >
                    </fieldset>
                    <fieldset class="password-container">
                        <label for="password" class="password">Password <a href="" > Forget?</a> </label>
                        <input type="password" name="password" id="password" placeholder="Enter your password" required>
                    </fieldset>

                    <button type="submit">Login</button>
                </form>
            </div>
        </div>
    </body>
</html>