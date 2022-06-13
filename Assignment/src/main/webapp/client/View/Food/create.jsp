<%@ page import="java.util.HashMap" %>
<%@ page import="com.example.assignment.entity.Category" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.example.assignment.entity.CategoryFood" %>
<%@ page import="com.example.assignment.SQLContans.Validate" %>
<%@ page import="com.example.assignment.entity.entityEnum.CategoryFoodStatus" %>
<%@ page import="com.example.assignment.util.FormatHelper" %>
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
    CategoryFood categoryFood = (CategoryFood) request.getAttribute("food");
    if (categoryFood == null) {
        categoryFood = CategoryFood.CategoryFoodBuilder.aCategoryFood().build();
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
                        <label for="inputState" style="margin-top: 30px" class="form-label">Option</label>
                        <select class="form-select" style="width: 150px">
                            <option selected>Đồ ăn</option>
                            <option selected>Đồ uống</option>
                        </select>
                    </div>
                    <form action="/client/View/Food/create" method="post">
                        <div class="col-md-6">
                            <label class="col-md-6 col-form-label">Name</label>
                            <div class="col-sm-12" style="width: 180px">
                                <input type="text" class="form-control" <%= categoryFood.getName() %>
                                <% if (errors.containsKey(Validate.FOOD_ERROR_KEY_NAME)) { %>
                                <div class="invalid-feedback">
                                    <%= errors.get(Validate.FOOD_ERROR_KEY_NAME) %>
                                </div>
                                <% } %>
                            </div>
                        </div>
                        <div class="col-md-6">
                            <label class="form-label">Code</label>
                            <input type="number" class="form-control" <%= categoryFood.getCode() %>
                            <% if (errors.containsKey(Validate.FOOD_ERROR_KEY_CODE)) { %>
                            <div class="invalid-feedback">
                                <%= errors.get(Validate.FOOD_ERROR_KEY_CODE) %>
                            </div>
                            <% } %>>
                        </div>
                        <div class="col-md-6">
                            <label class="form-label">Price</label>
                            <input type="number" class="form-control" <%= categoryFood.getPrice() %>
                            <% if (errors.containsKey(Validate.FOOD_ERROR_KEY_PRICE)) { %>
                            <div class="invalid-feedback">
                                <%= errors.get(Validate.FOOD_ERROR_KEY_PRICE) %>
                            </div>
                            <% } %>
                            >
                        </div>

                        <div class="col-md-6">
                            <label class="col-md-6 col-form-label">Textarea</label>
                            <textarea class="form-control" style="height: 100px" <%= categoryFood.getDescription() %>
                            <% if (errors.containsKey(Validate.FOOD_ERROR_KEY_DESCRIPTION)) { %>
                            <div class="invalid-feedback">
                                <%= errors.get(Validate.FOOD_ERROR_KEY_DESCRIPTION) %>
                            </div>
                            <% } %>
                            ></textarea>
                        </div>
                        <div class="row mb-3" style="margin-top: 10px">
                            <div class="col-sm-10">
                                <label>Thumbnail</label>
                                <input class="form-control" type="file" id="formFile" <%= categoryFood.getThumbnail() %>
                                <% if (errors.containsKey(Validate.FOOD_ERROR_KEY_THUMBNAIL)) { %>
                                <div class="invalid-feedback">
                                    <%= errors.get(Validate.FOOD_ERROR_KEY_THUMBNAIL) %>
                                </div>
                                <% } %>
                                >
                            </div>
                        </div>
                        <div class="row mb-3">
                            <div class="col-sm-10">
                                <label> Details</label>
                                <div class="quill-editor-default">
                                </div>
                            </div>
                        </div>

                        <div class="col-md-2" style="margin-top: 100px; width: 150px">
                            <label for="inputState" class="form-label">Status</label>
                            <select id="inputState" class="form-select"
                            <% for (CategoryFoodStatus categoryFoodStatus : CategoryFoodStatus.values()) { %>
                            <option value="<%= categoryFoodStatus.getValue() %>" <% if (categoryFood.getStatus().getValue() == categoryFoodStatus.getValue()) { %>
                                    selected <% } %> >
                                <%= categoryFoodStatus.name() %>
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
                        <div class="col-md-12 mb-3" style="margin-top: 10px; width: 150px">
                            <label for="saleAt">Sale At</label>
                            <input type="date" class="form-control " id="saleAt"
                                   placeholder="Sale At" name="saleAt"
                                   value="<%= FormatHelper.formatDate(categoryFood.getSaleAt(), "yyyy-MM-dd") %>"
                            >
                        </div>
                        <div class="row mb-3" style="margin-top: 30px">
                            <div class="col-sm-10">
                                <button type="submit" class="btn btn-primary">Submit</button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</section>
<jsp:include page="/client/components/footer.jsp"/>
<jsp:include page="/client/components/script.jsp"/>
</header>
</body>
</html>
</body>
</html>
