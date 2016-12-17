<?php
include 'database.php';

$pDatabase = Database::getInstance();

if (isset($_GET['idDispositivo']) && isset($_GET['descricao']))
{
$sql = "INSERT INTO dispositivo (idDispositivo, descricao) VALUES 
('".$_GET['idDispositivo']."','".$_GET['descricao']."');";
$pDatabase->query($sql);
$outp ="Inserted";
}
else $outp ="Not inserted";

echo($outp);
?>