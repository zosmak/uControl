<?php
include 'database.php';

$pDatabase = Database::getInstance();

if (isset($_GET['idGravacao']) && isset($_GET['dataInicio']) && isset($_GET['nome']) && isset($_GET['dataFim']))
{
$sql = "INSERT INTO gravacoes (idGravacao, dataInicio, nome,dataFim) VALUES ('".$_GET['idGravacao']."','".$_GET['dataInicio']."','".$_GET['nome']."','".$_GET['dataFim']."');";
$pDatabase->query($sql);
$outp ="Inserted";
}
else $outp ="Not inserted";

echo($outp);
?>