<?php
include 'database.php';

$pDatabase = Database::getInstance();

if (isset($_GET['idSensor']) && isset($_GET['descricao'])
{
$sql = "INSERT INTO sensor (idSensor, descricao) VALUES ('".$_GET['idSensor']."','".$_GET['descricao']."');";
$pDatabase->query($sql);
$outp ="Inserted";
}
else $outp ="Not inserted";

echo($outp);
?>