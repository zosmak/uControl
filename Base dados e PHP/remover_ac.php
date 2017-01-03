<?php
include 'database.php';
$pDatabase = Database::getInstance();
if (isset($_POST['idArCondicionado']))
{
$sql = "DELETE FROM ar_condicionado WHERE idArCondicionado='".$_POST['idArCondicionado']."';";
$pDatabase->query($sql);
echo "Removed";
}
else echo "Not valid";
?>