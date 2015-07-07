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
            <form id="logoutForm" action="/logout" method="post">
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                <div class="dropdown">
                    <a id="dropMenu" href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">
                        <sec:authentication property="principal.username" />
                        <span class="caret"></span>
                    </a>
                    <ul class="dropdown-menu" aria-labelledby="dropMenu">
                        <li class="dropdown-header">普通权限</li>
                        <li><a data-target="#"  href="/pusher/index">转发广告</a></li>
                        <sec:authorize access="hasAuthority('Vendor')">
                            <li class="dropdown-header">商家权限</li>
                            <li><a href="#">Another action</a></li>
                        </sec:authorize>
                        <sec:authorize access="hasAuthority('Admin')">
                            <li class="dropdown-header">管理权限</li>
                            <li><a href="#">Something else here</a></li>
                        </sec:authorize>
                        <li role="separator" class="divider"></li>
                        <li><a href="javascript:;" onclick="document.getElementById('logoutForm').submit();">退出</a></li>
                    </ul>
                </div>
            </form>
        </sec:authorize>
    </div>
</div>