<?php
$xml=simplexml_load_file("bookRead.xml");
foreach($xml->book as $bk){
echo "Book no = $bk->bookno"."<br>";
echo "Book name = $bk->bookname"."<br>";
echo "Author name = $bk->authorname"."<br>";
echo "price = $bk->price"."<br>";
echo "year = $bk->year"."<br>";

}
?>
