<%@page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>


<div class="container">
    <div class="navbar-header">
        <a class="navbar-brand" href="/">首页</a>
        <a class="navbar-brand" href="#">广告分类</a>
        <a class="navbar-brand" href="#">推手指南</a>
        <a class="navbar-brand" href="#">商家入驻</a>
        <a class="navbar-brand" href="#">关于我们</a>
    </div>
    <div id="navbar" class="navbar-collapse collapse navbar-right navbar-form">
        <sec:authorize access="!hasAuthority('Pusher')">
            <button type="button" class="btn btn-success" data-toggle="modal" data-target="#loginModal">登录</button>
        </sec:authorize>
        <sec:authorize access="hasAuthority('Pusher')">
            <form action="/logout" method="post">
                <sec:authentication property="principal.username"/>
                <a href="javascript:;" onclick="parentNode.submit();">退出</a>
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            </form>
        </sec:authorize>
    </div>
</div>