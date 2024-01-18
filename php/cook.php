<?php
$bg=$_GET['bg'];
$fg=$_GET['fg'];
$fs=$_GET['fs'];

setcookie('bg',$bg,time()+30); //Expire in 30 sec...

setcookie('fg',$fg);
setcookie('fs',$fs);

print_r($_COOKIE);
?>
