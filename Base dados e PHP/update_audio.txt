<?php
include 'database.php';
$pDatabase = Database::getInstance();
if (isset($_POST['estado']) && isset($_POST['temperatura']) && isset($_POST['modo']) && isset($_POST['idArCondicionado']))
{
$sql = "UPDATE ar_condicionado SET estado='".$_POST['estado']."',temperatura='".$_POST['temperatura']."',modo='".$_POST['modo']."' WHERE idArCondicionado='".$_POST['idArCondicionado']."';";
$pDatabase->query($sql);
echo "Updated";
}
else echo "Not valid";
?>