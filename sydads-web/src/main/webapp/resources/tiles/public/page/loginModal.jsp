<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="modal fade" id="loginModal" tabindex="-1" role="dialog" aria-labelledby="loginModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <form name="login" action="/login" method="post">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
          <h4 class="modal-title" id="loginModalLabel">用户登录</h4>
        </div>
        <div class="modal-body">
          <div>
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            <fieldset>
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
                <label for="username">邮箱</label>
                <input type="email" class="form-control" id="username" placeholder="Email" name="username">
              </div>
              <div class="form-group">
                <label for="password">密码</label>
                <input type="password" class="form-control" id="password" placeholder="Password" name="password">
              </div>
            </fieldset>
          </div>
        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
          <button type="submit" class="btn btn-primary">登录</button>
        </div>
      </form>
    </div>
  </div>
</div>