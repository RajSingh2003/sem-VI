<?php
session_start();
$e1=$_POST['be'];
$e2=$_POST['dp'];
$e3=$_POST['hra'];

$_SESSION['e1']=$e1;
$_SESSION['e2']=$e2;
$_SESSION['e3']=$e3;

echo "<h3> Employee Details: </h3>";

echo "<br><br> Employee No:", $_SESSION['eno'];
echo "<br><br> Employee No:", $_SESSION['ename'];
echo "<br><br> Employee No:", $_SESSION['eadd'];

echo "<h3><br><br> Earning Detail:</h3>";

echo "<br><br> Basic Earning is :",$_SESSION['e1'];
echo "<br><br> DA Earning is :",$_SESSION['e2'];
echo "<br><br> HRA Earning is :",$_SESSION['e3'];

$totalEarn=$e1+$e2+$e3;

echo "<h3><br><br> Total earning is : $totalEarn </h3>";
?>
