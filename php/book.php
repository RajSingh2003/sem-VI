<?php
$str=<<<XML
<?xml version="1.0" encoding="UTF-8"?>

<BookInfo>
<book>
<PHP>
<bookno>1</bookno>
<bookname>Java</bookname>
<authorname>Balguru Swami</authorname>
<price>250</price>
<year>1992</year>
</PHP>

<PHP>
<bookno>2</bookno>
<bookname>c</bookname>
<authorname>Denis Retchie</authorname>
<price>500</price>
<year>1971</year>
</PHP>
</book>

</BookInfo>

XML;

$fname="book.xml";
$fp=fopen($fname,"w");
fwrite($fp,$str);
fclose($fp);

echo "Created filename is: ".$fname;
?>
