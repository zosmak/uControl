<?php
include 'database.php';
$pDatabase = Database::getInstance();
if (isset($_POST['descricao']))
{
$sql = "SELECT FROM divisao,audio WHERE divisao.descricao='".$_POST['descricao']."';";
$pDatabase->query($sql);
echo "listed";
}
else echo "Not valid";
?>