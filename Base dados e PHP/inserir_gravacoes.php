<?php
include 'database.php';

$pDatabase = Database::getInstance();

if (isset($_GET['descricao']) && isset($_GET['horaInicio']) && isset($_GET['horaFim']))
{
$sql = "INSERT INTO gravacoes (descricao, horaInicio, horaFim) VALUES ('".$_GET['descricao']."','".$_GET['horaInicio']."','".$_GET['horaFim']."');";
$pDatabase->query($sql);
$outp ="Inserted";
}
else $outp ="Not inserted";

echo($outp);
?>