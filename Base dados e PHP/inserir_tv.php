<?php
include 'database.php';

$pDatabase = Database::getInstance();

if (isset($_GET['idTv']) && isset($_GET['divisao']) && isset($_GET['estado']) && isset($_GET['canal']) && isset($_GET['gravacao']) && isset($_GET['volume']))
{
$sql = "INSERT INTO tv (idTv, divisao, estado, canal, gravacao, volume) VALUES 
('".$_GET['idTv']."','".$_GET['divisao']."','".$_GET['estado']."','".$_GET['canal']."','".$_GET['gravacao']."','".$_GET['volume']."');";
$pDatabase->query($sql);
$outp ="Inserted";
}
else $outp ="Not inserted";

echo($outp);
?>