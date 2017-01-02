<?php
include 'database.php';

$pDatabase = Database::getInstance();


if (isset($_GET['divisao']) && isset($_GET['estado']) && isset($_GET['sensor']))
{
$sql = "INSERT INTO alarme (divisao, estado, sensor) VALUES ('".$_GET['divisao']."','".$_GET['estado']."','".$_GET['sensor']."');";
$pDatabase->query($sql);
$outp ="Inserted";
}
else $outp ="Not inserted";

echo($outp);
?>