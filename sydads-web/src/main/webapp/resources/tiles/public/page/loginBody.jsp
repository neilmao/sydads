<%@page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div>
    <form name="login" form:action="@{/login}" method="post" class="form-inline">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        <fieldset>
            <legend>用户登录</legend>
            <c:choose>
                <c:when test="${status == 'error'}">
                    <div class="bg-danger">
                        用户名或者密码错误.
                    </div>
                </c:when>
                <c:when test="${status == 'logout'}">
                    <div class="bg-success">
                        您已经退出登录.
                    </div>
                </c:when>
            </c:choose>
            <div class="form-group">
                <label class="sr-only" for="username">Email address</label>
                <input type="email" class="form-control" id="username" placeholder="Email" name="username">
            </div>
            <div class="form-group">
                <label class="sr-only" for="password">Password</label>
                <input type="password" class="form-control" id="password" placeholder="Password" name="password">
            </div>
            <button type="submit" class="btn btn-default">登录</button>
            <span>没有账号？<a href="/register" style="color: red">新用户注册</a></span>
        </fieldset>
    </form>
</div>