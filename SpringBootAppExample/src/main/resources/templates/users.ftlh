<!doctype html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport"
              content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <title>Пользователи</title>
    </head>
    <body>
        <table>
            <tr>
                <th>Идентификатор</th>
                <th>Имя</th>
                <th>Фамилия</th>
                <th>Возраст</th>
                <th>Почта</th>
                <th>Подтверждение почты</th>
                <th>Статус подтверждения</th>
            </tr>
            <#list users as user>
                <tr>
                    <td>${(user.id)!"нет"}</td>
                    <td>${(user.firstName)!"нет"}</td>
                    <td>${(user.lastName)!"нет"}</td>
                    <td>${(user.age)!"нет"}</td>
                    <td>${(user.email)!"нет"}</td>
                    <td>${(user.confirmCode)!"нет"}</td>
<#--                    <td>${(user.state)!"нет"}</td>-->
                </tr>
            </#list>
        </table>
    </body>
</html>