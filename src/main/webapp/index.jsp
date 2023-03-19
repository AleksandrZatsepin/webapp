<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=windows-1251">
    <link rel="stylesheet" type="text/css" href="style.css">
    <title>Вывод данных</title>
</head>

<body>
<fieldset>
    <form method="post" action="select_user.php">
        <label >Имя для поиска:</label><br/>
        <input type="text" name="first_name" size="30"><br/>
        <label>Фамилия для поиска:</label><br/>
        <input type="text" name="last_name" size="30"><br/>
        <input id="submit" type="submit" value="Найти и вывести"><br/>
    </form>
</fieldset>
<fieldset>
    <form method="post" action="all_users.php">
        <input id="submit" type="submit" value="Вывести всех пользователей"><br/>
    </form>
</fieldset>
<a href="info_form.html">Добавить пользователя</a>
</body>
</html>