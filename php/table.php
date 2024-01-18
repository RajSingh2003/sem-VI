<?php 

$name = $_GET['name'];
$con = pg_connect("host=192.168.1.254 dbname = ty52 user = ty52") or die("could not connect");
$qry = "select tno,qualification from teacher where tname = $name";

$rs= pg_query($con,$qry) or die("unable to execute query");

if($rs!=null)
{
echo "Hlo";
}
}
?>
