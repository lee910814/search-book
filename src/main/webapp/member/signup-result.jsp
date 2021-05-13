<%@ page contentType="text/html;charset=UTF-8" %>

<html>
<head>
    <%@ include file="/fragments/common-head.jsp" %>
    <title>회원가입 결과</title>
    <style>
        @import url('https://fonts.googleapis.com/css2?family=Ubuntu&display=swap');
        #wrap{
            width:100%;
            height:100%;
            background:rgb(233, 227, 227);
            position:relative;
        }
        #wrap .box{
            width:500px;
            height:500px;
            position:absolute;
            left:45%;
            top:35%;
            margin-left:-150px;
            margin-top:-150px;
        }



        .box {
            border: 3px solid rgb(17, 116, 70);
            border-radius: 10px;
            text-align: center;
            width: 500px;
            position: relative;
            display: inline-block;
            height: 500px;

        }
        h1{
            margin: 40px;
            font-size: 3rem;
            font-family: 'Ubuntu', sans-serif;
        }

        button {

            padding: 20px;
            background-color: rgb(17, 116, 70);
            border-radius: 50px;
            width: 300px;
            font-size: 1.5rem;
            margin: 10px;

        }
        button:hover{
            cursor: pointer;
        }

        p {
            margin-bottom: 100px;
            font-size: 1.5rem;
            font-family: 'Ubuntu', sans-serif;
        }



    </style>
</head>
<body>
<div id="wrap">
    <div class="box">
        <h1>가입을 축하합니다!</h1>
        <p>
            5만 권 도서를 즐겨보세요<br>
            오직 library 에서
        </p>
        <a href="main.jsp"><button type="submit"><b>홈으로</b></button></a>
    </div>
</div>


<%=request.getParameter("ok")%> <%-- ok is boolean type --%>
</body>
</html>
