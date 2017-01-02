<?php
include 'database.php';

$pDatabase = Database::getInstance();

if (isset($_GET['descricao']) && isset($_GET['divisao']) && isset($_GET['estado']))
{
$sql = "INSERT INTO porta (descricao, divisao, estado) VALUES ('".$_GET['descricao']."','".$_GET['divisao']."','".$_GET['estado']."');";
$pDatabase->query($sql);
$outp ="Inserted";
}
else $outp ="Not inserted";

echo($outp);
?>