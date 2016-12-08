<?php
include 'database.php';

$pDatabase = Database::getInstance();

if (isset($_GET['idDivisao']) && isset($_GET['descricao']))
{
$sql = "INSERT INTO divisao (idDivisao, descricao) VALUES ('".$_GET['idDivisao']."','".$_GET['descricao']."');";
$pDatabase->query($sql);
$outp ="Inserted";
}
else $outp ="Not inserted";

echo($outp);
?>