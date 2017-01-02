<?php
include 'database.php';
$pDatabase = Database::getInstance();
$sql = "SELECT * FROM divisao,audio WHERE 'quarto' = divisao.descricao";
$result = $pDatabase->query($sql);
$rows = array();
while($temp = mysqli_fetch_assoc($result)) {
    $rows[] = $temp;
}
echo json_encode($rows);
?>