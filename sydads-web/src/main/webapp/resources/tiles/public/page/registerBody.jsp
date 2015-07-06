<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div>
    <c:choose>
        <c:when test="${status == 'success'}">
            <p class="bg-success">注册成功，点击右上角登录。</p>
        </c:when>
        <c:when test="${status == 'error'}">
            <p class="bg-danger">注册出错，请联系管理员。</p>
        </c:when>
        <c:otherwise>
            <c:if test="${status == 'used'}">
                <p class="bg-danger">此邮箱已经被注册。</p>
            </c:if>
            <form class="form-horizontal" action="/register" method="post">
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                <div class="form-group">
                    <label for="email" class="col-sm-2 control-label">邮箱</label>
                    <div class="col-xs-4">
                        <input type="email" class="form-control" id="email" name="email" placeholder="Email">
                    </div>
                </div>
                <div class="form-group">
                    <label for="password" class="col-sm-2 control-label">密码</label>
                    <div class="col-xs-4">
                        <input type="password" class="form-control" id="password" name="password" placeholder="Password">
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-offset-2 col-sm-10">
                        <button type="submit" class="btn btn-default">注册</button>
                    </div>
                </div>
            </form>
        </c:otherwise>
    </c:choose>
</div>