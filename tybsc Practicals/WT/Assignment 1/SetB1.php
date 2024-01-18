<?php
 
    session_start();
    
    if(!isset($_SESSION['cnt']))
        $_SESSION['cnt']=0;
        
    $uname=$_GET['uname'];
    $pswd=$_GET['pswd'];
    
    if($uname==" " && pswd==" ")
    {
       echo "ERROE...";
    }  
    if($uname=="Harsh" && $pswd="2001")
    {
        echo"Correct username and password";
        echo "<br> Welcome";
        $_SESSION['cnt']=0;
    }
    else
    {
        $_SESSION['cnt']=$_SESSION['cnt']+1;
        if($_SESSION['cnt']>=3)
        {
            echo "Error! You used all chance";
            $_SESSION['cnt']=0;
        }
        else
        {
            echo "Login Failed".$_SESSION['cnt']."attempts made";
            include("b1.html");
        }
    }
?> 
