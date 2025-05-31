<!DOCTYPE html>
<html>
<head>
    <title>Login page</title>
</head>

<body>
   <div align= center>
       <h1>
           Login to Your Account
       </h1>
       <p> Greetings everyone! Excited to share some fresh new designs about Web flow</p>
   </div>

   <form action = ServletLogin method = post>
       <table>
           <tr>
               <td>User name</td>
               <td><input type = text name = uname></td>
           </tr>
           <tr>
               <td>Password</td>
               <td> <input type = password name = upass> </td>
           </tr>
           <tr><td><input type = submit value = login> <input type = reset value = reset></td></tr>
       </table>

   </form>

</body>
</html>