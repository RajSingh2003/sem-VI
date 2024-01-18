<?php
session_start();
//session_register('count');
$c=$_SESSION['count']++;

echo "You have $c times open";

?>
