<?php
include 'database.php';

$pDatabase = Database::getInstance();


if (isset($_GET['idArCondicionado']) && isset($_GET['divisao']) && isset($_GET['estado']) && isset($_GET['temperatura']) && isset($_GET['modo']))
{
$sql = "INSERT INTO ar_condicionado (idArCondicionado, divisao, estado, temperatura, modo) VALUES ('".$_GET['idArCondicionado']."','".$_GET['divisao']."','".$_GET['estado']."','".$_GET['temperatura']."','".$_GET['modo']."');";
$pDatabase->query($sql);
$outp ="Inserted";
}
else $outp ="Not inserted";

echo($outp);
?>
