<?php
session_start();
$no=$_GET['empno'];
$name=$_GET['empname'];
$add=$_GET['empadd'];

$_SESSION['eno']=$no;
$_SESSION['ename']=$name;
$_SESSION['eadd']=$add;

?>

<html>
<body>
<center>
<h1> Earning detail: </h1><br><br>

<form action="final.php" method="post">

BasicE: <input type="text" name="be"><br><br> 
DPEarn: <input type="text" name="dp"><br><br> 
HRAErn: <input type="text" name="hra"><br><br> 

<input type="submit" value="Show">

</form>
</center>
</body>
</html> 
