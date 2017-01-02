<?php
include 'database.php';

$pDatabase = Database::getInstance();


if (isset($_GET['descricao']) && isset($_GET['divisao']) && isset($_GET['posicao']))
{
$sql = "INSERT INTO estore(descricao, divisao, posicao) VALUES ('".$_GET['descricao']."','".$_GET['divisao']."','".$_GET['posicao']."');";
$pDatabase->query($sql);
$outp ="Inserted";
}
else $outp ="Not inserted";

echo($outp);
?>