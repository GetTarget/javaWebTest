<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <style>
        *{
            margin: 0;
            padding: 0;
        }

        body{
            background: url("${pageContext.request.contextPath}/images/ApexLegends_tiwch1.jpg") no-repeat;
            background-size: 100%;
        }

        #inputBox{
            width: 550px;
            height: auto;
            border-radius: 15px;
            padding: 10px 30px 20px;
            margin: 0 auto;
            margin-top: 250px;
            background: #000000be;
            text-align: center;
        }

        #boxTitle{
            margin: 20px 0px;
        }

        #title1{
            font-size: 30px;
            color: #db4b4b;
        }

        #title2{
            font-size: 30px;
            color: #cccccc;
        }

        .inputItem{
            margin-top:15px;
        }

        .inputItem label{
            display: inline-block;
            width: 4em;
            font-size:18px;
            color:#fff;
        }

        .inputItem input{

            padding:5px 10px;
            border:0;
            border-bottom:2px solid #db4b4b;
            background:#ffffff00;
            font-size:18px;
            text-align: left;
            color:#fff;
        }

        .inputItem #emailError,#accountError,#passwordError{
            margin-top: 10px;
            font-size: 14px;
            color: #db4b4b;
        }

        #inputBox button{

            width:190px;
            height:30px;
            border:0;
            border-radius:15px;
            margin-top:20px;
            background-image: linear-gradient(to right, #f861cb 0%, #66e6f7 100%);
            font-size:20px;
            font-weight:600;
            color:#fff;

        }

        #inputBox button:hover{
            background-image: linear-gradient(to right, #f861cb98 0%, #66e6f798 100%);
        }

        #jumpLink{
            display: inline-block;
            margin-top: 2%;
            text-decoration: none;
            color: #fff;
        }

        #jumpLink:hover{
            text-decoration: underline;
            color: #db4b4b;
        }
    </style>
    <title>注册</title>
</head>
<body>
<div id="inputBox">
    <h1 id = "boxTitle"><span id="title1">Apex</span><span id="title2">Legends</span></h1>
    <form id="userForm" action="${pageContext.request.contextPath}/registerServlet" method="post">
        <div class="inputItem">
            <label for="emailInput">邮箱:</label><input id="emailInput" type="text" name="email" placeholder="E-mail">
            <div id="emailError"></div>
        </div>
        <div class="inputItem">
            <label for="accountInput">新账号:</label><input id="accountInput" type="text" name="account" placeholder="new Account">
            <div id="accountError"></div>
        </div>
        <div class="inputItem">
            <label for="passwordInput">新密码:</label><input id="passwordInput" type="password" name="password" placeholder="new Password">
            <div id="passwordError"></div>
        </div>
        <button id="submitButton" type="button">注册</button>
    </form>
    <a href="${pageContext.request.contextPath}/login" id="jumpLink">
        已有账号?去登录
    </a>
</div>
<script>
    var emailReg = /^\w+@\w+.\w+$/;
    var accountReg = /^\w{3,20}$/;
    var passwordReg = /^\w{6,20}$/;
    var emailInput = document.getElementById("emailInput");
    var emailError = document.getElementById("emailError");
    var accountInput = document.getElementById("accountInput");
    var accountError = document.getElementById("accountError");
    var passwordInput = document.getElementById("passwordInput");
    var passwordError = document.getElementById("passwordError");
    var userForm = document.getElementById("userForm");
    var submitButton = document.getElementById("submitButton");

    emailInput.onblur = function() {
        var email = emailInput.value.trim();
        var regResult = emailReg.test(email);
        if(email == "" || regResult)
        {
            emailError.innerHTML = "";
        }
        else
        {
            emailError.innerHTML = "邮箱格式不正确";
        }
    }

    accountInput.onblur = function() {
        var account = accountInput.value.trim();
        var regResult = accountReg.test(account);
        if(account == "" || regResult)
        {
            accountError.innerHTML = "";
        }
        else
        {
            accountError.innerHTML = "账号仅能为3至20位字母、数字和下划线";
        }
    }

    passwordInput.onblur = function() {
        var password = passwordInput.value.trim();
        var regResult = passwordReg.test(password);
        if(password == "" || regResult)
        {
            passwordError.innerHTML = "";
        }
        else
        {
            passwordError.innerHTML = "密码仅能为6至20位字母、数字和下划线";
        }
    }

    submitButton.onclick = function () {
        var email = emailInput.value.trim();
        var emailRegResult = emailReg.test(email);
        var account = accountInput.value.trim();
        var accountRegResult = accountReg.test(account);
        var password = passwordInput.value.trim();
        var passwordRegResult = passwordReg.test(password);

        if(emailRegResult && accountRegResult && passwordRegResult)
        {
            userForm.submit();
        }
        else
        {
            alert("输入格式不正确，请重新检查");
        }
    }

</script>
</body>
</html>