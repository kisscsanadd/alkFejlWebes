<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<html>
<head>
    <jsp:include page="common/common-header.jsp"/>
    <title>Add Contact</title>
</head>
<body>
<jsp:include page="common/menu.jsp"/>
<div class="container">
    <form action="../ContactController" method="post">
        <div class="form-group">
            <label for="name">Name</label>
            <input required name="name" type="text" class="form-control" id="name"
                   placeholder="Enter name"/>
        </div>
        <div class="form-group">
            <label for="birth">Birth</label>
            <input required name="birth" type="text" class="form-control" id="birth"
                   placeholder="Birth"/>
        </div>
        <div class="form-group">
            <label for="email">Email</label>
            <input required name="email" type="email" class="form-control" id="email"
                   placeholder="Email"/>
        </div>
        <div class="form-group">
            <label for="phone">Phone</label>
            <input required name="phone" type="text" class="form-control" id="phone"
                   placeholder="Phone number"/>
        </div>
        <div class="form-group">
            <label for="address">Address</label>
            <input required name="address" type="text" class="form-control" id="address"
                   placeholder="Address"/>
        </div>
        <div class="form-group">
            <label for="organization">Organization</label>
            <input required name="organization" type="text" class="form-control" id="organization"
                   placeholder="Organization"/>
        </div>
        <div class="form-group">
            <label for="position">Position</label>
            <input required name="position" type="text" class="form-control" id="position"
                   placeholder="Position"/>
        </div>
        <button id="submit" type="submit" class="btn btn-primary">Submit</button>
    </form>
</div>

</body>


</html>