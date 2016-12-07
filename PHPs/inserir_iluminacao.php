<?php
include 'database.php';

$pDatabase = Database::getInstance();

if (isset($_GET['idIluminacao']) && isset($_GET['divisao']) && isset($_GET['estado']) && isset($_GET['intensidade']))
{
$sql = "INSERT INTO iluminacao (idIluminacao, divisao, estado, intensidade) VALUES ('".$_GET['idIluminacao']."','".$_GET['divisao']."','".$_GET['estado']."','".$_GET['intensidade']."');";
$pDatabase->query($sql);
$outp ="Inserted";
}
else $outp ="Not inserted";

echo($outp);
?>