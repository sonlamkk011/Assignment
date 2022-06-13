<%@ page import="java.util.HashMap" %>
<%@ page import="com.example.assignment.entity.Category" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.example.assignment.SQLContans.Validate" %>
<%@ page import="com.example.assignment.entity.entityEnum.CategoryStatus" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="/client/components/header.jsp"/>
<jsp:include page="/client/components/navbar.jsp"/>
<jsp:include page="/client/components/sidebar.jsp"/>
<%

    HashMap<String, String> errors = (HashMap<String, String>) request.getAttribute("errors");
    if (errors == null) {
        errors = new HashMap<>();
    }
    List<Category> categoryList = (List<Category>) request.getAttribute("categoryList");
    if (categoryList == null) {
        categoryList = new ArrayList<>();
    }
    Category category = (Category) request.getAttribute("category");
    if (category == null) {
        category = Category.CategoryBuilder.aCategory().build();
    }
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<section class="section" style="margin-left: 400px; margin-top: 100px">
    <div class="row">
        <div class="card">
            <div class="card-body">
                <div class="col-lg-8">
                    <div class="col-md-4">
                        <label> Create Category</label>
                    </div>
                    <form action="/client/View/Food/create" method="post">
                        <div class="col-md-6">
                            <label class="col-md-6 col-form-label">Name</label>
                            <div class="col-sm-12">
                                <input type="text" class="form-control" <%= category.getName() %>
                                <% if (errors.containsKey(Validate.FOOD_ERROR_KEY_NAME)) { %>
                                <div class="invalid-feedback">
                                    <%= errors.get(Validate.FOOD_ERROR_KEY_NAME) %>
                                </div>
                                <% } %>
                            </div>
                            <div class="col-md-12 mb-3">
                                <label for="parentId">Parent</label>
                                <select class="form-control " name="parentId" id="parentId">
                                    <option value="0">Select Parent</option>
                                    <% for (Category item : categoryList) { %>
                                    <option value="<%= item.getId() %>" <% if (category.getParentId() == item.getId()) { %>
                                            selected <% } %> >
                                        <%= item.getName() %>
                                    </option>
                                    <% } %>
                                </select>
                                <% if (errors.containsKey(Validate.CATEGORY_ERROR_KEY_PARENT_ID_REQUIRED)) { %>
                                <div class="invalid-feedback">
                                    <%= errors.get(Validate.CATEGORY_ERROR_KEY_PARENT_ID_REQUIRED) %>
                                </div>
                                <% } %>
                            </div>

                            <div class="col-md-2" style="margin-top: 80px">
                                <label for="inputState" class="form-label">Status</label>
                                <select id="inputState" class="form-select"
                                <% for (CategoryStatus categoryStatus : CategoryStatus.values()) { %>
                                <option value="<%= categoryStatus.getValue() %>" <% if (categoryStatus.getValue() == CategoryStatus.ACTIVE.getValue()) { %>
                                        selected <% } %> >
                                    <%= category.getName() %>
                                </option>
                                <% } %>>
                                <option selected>Active</option>
                                <option selected>DeActive</option>
                                </select>
                                <% if (errors.containsKey(Validate.FOOD_ERROR_KEY_STATUS)) { %>
                                <div class="invalid-feedback">
                                    <%= errors.get(Validate.FOOD_ERROR_KEY_STATUS) %>
                                </div>
                                <% } %>
                            </div>
                            <div class="row mb-3" style="margin-top: 30px">
                                <div class="col-sm-10">
                                    <button type="submit" class="btn btn-primary">Submit</button>
                                </div>
                            </div>

                            <jsp:include page="/client/components/footer.jsp"/>
                            <jsp:include page="/client/components/script.jsp"/>

</body>
</html>
