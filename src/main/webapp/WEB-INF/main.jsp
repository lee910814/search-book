<%--
  Created by IntelliJ IDEA.
  User: 이의정
  Date: 2021-05-13
  Time: 오후 7:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <script src="https://use.fontawesome.com/releases/v5.2.0/js/all.js"></script>




    <title>library</title>
    <style>
        @import url('https://cdn.jsdelivr.net/npm/@fortawesome/fontawesome-free@5.15.3/css/fontawesome.min.css');
        body{
            margin: 0%;
            padding: 0%;
            width: 100%;
            height: 100%;
        }
        .header{
            display: inline-block;
            width: 100%;
            height:80px;
            background-color: white(90, 133, 214);
            /* border-bottom: 2px solid rgb(213, 217, 224);*/
            position: relative;

        }
        .login{

            float: right;
            margin: 20px;
            padding: 10px;
            text-decoration: none;
            text-align: center;
            border: 3px solid rgb(17, 116, 70);
            border-radius: 50px;
            width: 80px;
            color: black;
        }
        .join{
            float: right;
            display: flex;
            text-decoration: none;
            margin: 30px;
            color: black;


        }
        .join:hover{
            color: rgb(17, 116, 70);
        }
        .section{
            width: 100%;
            height: 500px;
            background-color: white;
        }
        .footer{
            height: 123px;
            background-color: coral;
        }
        .login:hover{
            border: 3px solid #000;
        }
        .bar{
            display: inline-block;
            background-color: white;
            width: 80px;
            height: 100px;
        }

        .section{

            text-align: center;
        }
        form>input{
            padding-left: 20px;
            text-align: center;
            font-size: 1em;
            width: 30%;
            height: 60px;
            border-radius: 50px;
            border: 0.3px solid rgb(192, 191, 191);
            box-shadow: 1px 1px 1px 1px rgb(223, 218, 218) ;
        }
        .section>h2{
            font-size: 5rem;

        }
        h2 span:nth-child(1){
            color: rgb(066,133,244);
            font-size: 7rem;
            margin:2px;
            font-family: 'Krona One', sans-serif;
        }
        h2 span:nth-child(2){
            color: rgb(234,067,053);
            margin: 2px;
            font-family: 'Krona One', sans-serif;
        }
        h2 span:nth-child(3){
            color: rgb(251,188,005);
            margin: 2px;
            font-family: 'Krona One', sans-serif;
        }
        h2 span:nth-child(4){
            color: rgb(066,133,244);
            margin: 2px;
            font-family: 'Krona One', sans-serif;
        }
        h2 span:nth-child(5){
            color: rgb(052,168,083);
            margin: 2px;
            font-family: 'Krona One', sans-serif;
        }
        h2 span:nth-child(6){
            color: rgb(234,067,053);
            margin: 2px;
            font-family: 'Krona One', sans-serif;
        }

        h2 span:nth-child(7){
            color: rgb(251,188,005);
            font-family: 'Krona One', sans-serif;
        }
        select{
            height: 40px;
            width: 90px;
            border-radius: 5px;
            margin: 10px;
            padding:10px
        }
        a{
            text-decoration: none;
        }
        .fas fa-align-justify{
            background-color:white;
            color: #ddd;

            font-size: 3em;

            margin-top: 50px;


        }
        select{

            -moz-appearance: none; /*firefox*/
            -webkit-appearance: none; /*Safari and Chrome*/
            appearance: none; /*화살표 없애기 공통*/
        }
        .dropheader{
            position: relative;
            display: inline-block;
            margin: 30px;
        }

        .drop-content{
            display: none;
            position: absolute;
            background-color: #fff;
            min-width: 160px;

            z-index: 1;
        }
        .drop-content > a{
            color: black;
            padding: 12px 16px;
            margin-left: 15px;
            text-decoration: none;
            display: block;
        }


        .drop-content a:hover{background-color: rgb(17, 116, 70); color: white;}
        .dropheader:hover .drop-content{display: block;}
        .dropheader:hover .fas fa-align-justify{background-color: #fff;}
        #search{
            width:80px;
            hegiht:20px;
            border-radius:20px;
            text-align:center;
        }




    </style>
</head>
<body>
<div class="header">
    <div class="logo">

        <a href="mini_login.html"class="login">로그인</a>
        <a href="login-form.jsp"class="join"><b>회원가입</b></a>
    </div>
    <div class="dropheader">
        <i class="fas fa-align-justify fa-2x"></i>
        <div class="drop-content">
            <a href="#">도서 등록</a>
            <a href="#">도서 구매</a>
            <a href="#">도서 후기</a>
        </div>
    </div>
</div>
<div class="section">
    <h2> <a href="mini_form.jsp"><span>l</span><span>i</span><span>b</span><span>r</span><span>a</span><span>r</span><span>y</span></a></h2>
    <form action="search-result.jsp"method="post">
        <select>
            <option>저자명</option>
            <option>도서명</option>
            <option>도서번호</option>
        </select>
        <input id="bookName"type="text" name="search"placeholder="검색어를 입력해주세요">
        <input type="button" id="search" value="검색">

    </form>
</div>


</body>
</html>