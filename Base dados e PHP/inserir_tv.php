<?php
include 'database.php';

$pDatabase = Database::getInstance();


if (isset($_GET['descricao']) && isset($_GET['divisao']) && isset($_GET['estado']) && isset($_GET['canal']) && isset($_GET['gravacao']) && isset($_GET['volume']))
{
$sql = "INSERT INTO tv(descricao, divisao, estado, canal, gravacao, volume) VALUES ('".$_GET['descricao']."','".$_GET['divisao']."','".$_GET['estado']."','".$_GET['canal']."','".$_GET['gravacao']."','".$_GET['volume']."');";
$pDatabase->query($sql);
$outp ="Inserted";
}
else $outp ="Not inserted";

echo($outp);
?>