<div class="container-fluid col-sm-12">
    <div class="row">
        <div class="col-sm-12">
            <table class="table table-striped">
                <tr>
                    <th>Id</th>
                    <th>UserName</th>
                    <th>Email</th>
                    <th>FirstName</th>
                    <th>LastName</th>
                    <th>Active</th>
                    <th>Manage</th>
                    <th></th>
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
        </div>

    </div>
</div>