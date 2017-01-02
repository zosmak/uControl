<?php
include 'database.php';

$pDatabase = Database::getInstance();

if (isset($_GET['descricao']))
{
$sql = "INSERT INTO sensor (descricao) VALUES ('".$_GET['descricao']."');";
$pDatabase->query($sql);
$outp ="Inserted";
}
else $outp ="Not inserted";

echo($outp);
?>