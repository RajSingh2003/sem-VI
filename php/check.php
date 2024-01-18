<?php

session_start();

$u=$_GET['un'];
$p=$_GET['pass'];

$_SESSION['uN']=$u;
$_SESSION['uP']=$p;

?>

