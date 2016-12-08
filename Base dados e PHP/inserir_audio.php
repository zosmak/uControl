<?php
include 'database.php';

$pDatabase = Database::getInstance();


if (isset($_GET['idAudio']) && isset($_GET['divisao']) && isset($_GET['estado']) && isset($_GET['dispositivos']) && isset($_GET['volume']))

{
$sql = "INSERT INTO audio (idAudio, divisao, estado, dispositivos, volume) VALUES ('".$_GET['idAudio']."','".$_GET['divisao']."','".$_GET['estado']."','".$_GET['dispositivos']."','".$_GET['volume']."');";
$pDatabase->query($sql);
$outp ="Inserted";
}
else $outp ="Not inserted";

echo($outp);
?>