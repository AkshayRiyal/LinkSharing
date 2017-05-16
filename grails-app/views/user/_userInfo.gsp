<%@ page import="com.ttn.linksharing.User" %>
<div class="container-fluid col-sm-12">
    <div class="row">
        <div class="col-sm-12">
            <table class="table table-striped">
                <th>
                    <g:sortableColumn property="id" title="Id"/>
                    <g:sortableColumn property="userName" title="UserName"/>
                    <g:sortableColumn property="email" title="Email"/>
                    <g:sortableColumn property="firstName" title="FirstName"/>
                    <g:sortableColumn property="lastName" title="LastName"/>
                    <g:sortableColumn property="active" title="Active"/>
                <th>Manage</th>
                <th></th>
                %{--   <th>Id</th>
                   <th>UserName</th>
                   <th>Email</th>
                   <th>FirstName</th>
                   <th>LastName</th>
                   <th>Active</th>
                   <th>Manage</th>
                   <th></th>--}%
            </tr>
                <g:each in="${userList}" var="user">
                    <g:if test="${user.admin == false}">
                        <tr>
                            <td>${user.id}</td>
                            <td>${user.userName}</td>
                            <td>${user.email}</td>
                            <td>${user.firstName}</td>
                            <td>${user.lastName}</td>
                            <td>${user.active}</td>

                            <form action="/user/activate" method="post">
                                <td>
                                    <select name="status">
                                        <option value="1">Activate</option>
                                        <option value="0">De-Activate</option>
                                    </select>
                                </td>
                                <input type="hidden" name="userId" value="${user.id}">
                                <td>
                                    <input type="submit" value="Save">
                                </td>
                            </form>
                        </tr>
                    </g:if>
                </g:each>

            </table>
            <g:paginate max="5" total="${com.ttn.linksharing.User.count()}"/>

        </div>

    </div>
</div>