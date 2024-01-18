<?php
$dom=new DomDocument();

$dom->load("movie.xml");

echo "<h2> Name of Movie </h2>";

$bname=$dom->getElementsByTagName("MovieTitle");

foreach($bname as $b){
echo "<b>$b->textContent<b><br><br>";
}
?>
