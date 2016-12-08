<?php
include 'database.php';

$pDatabase = Database::getInstance();

if (isset($_GET['idPorta']) && isset($_GET['divisao']) && isset($_GET['estado']))
{
$sql = "INSERT INTO porta (idPorta, divisao, estado) VALUES ('".$_GET['idPorta']."','".$_GET['divisao']."','".$_GET['estado']."');";
$pDatabase->query($sql);
$outp ="Inserted";
}
else $outp ="Not inserted";

echo($outp);
?>