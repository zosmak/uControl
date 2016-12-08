<?php
include 'database.php';
$pDatabase = DatabasegetInstance();
$sql = SELECT * FROM alarme;
$result = $pDatabase->query($sql);
$rows = array();
while($temp = mysqli_fetch_assoc($result)) {
    $rows[] = $temp;
}
echo json_encode($rows);

?>