<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html lang="en">

<body>
	<form id="productAddForm" method="POST" enctype="multipart/form-data">

                        <input id="input_id" type="hidden" name="id"/>
                        <div class="form-group">
                            <label for="input_product_name">Название</label>
                            <input id="input_product_name" class="form-control" type="text" name="name"
                                   placeholder="Название" required/>
                        </div>
                        <div class="form-group">
                            <label for="input_description">Описание</label>
                            <input id="input_description" class="form-control" type="text" name="description"
                                   placeholder="Описание"/>
                        </div>
                        <div class="form-group">
                            <label for="input_width">Ширина</label>
                            <div class="input-group">
                                <span class="input-group-addon">
                                  <input id="width_box" type="checkbox" aria-label="..."/>
                                </span>
                                <input id="input_width" class="form-control" type="number" name="width" placeholder="Ширина"
                                       disabled="disabled"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="input_height">Высота</label>
                            <div class="input-group">
                                <span class="input-group-addon">
                                  <input id="height_box" type="checkbox" aria-label="..."/>
                                </span>
                                <input id="input_height" class="form-control" type="number" name="height"
                                       placeholder="Высота"
                                       disabled="disabled"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="input_depth">Глубина</label>
                            <div class="input-group">
                                <span class="input-group-addon">
                                  <input id="depth_box" type="checkbox" aria-label="..."/>
                                </span>
                                <input id="input_depth" class="form-control" type="number" name="depth"
                                       placeholder="Глубина"
                                       disabled="disabled"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="input_price">Цена</label>
                            <input id="input_price" class="form-control" type="number" name="price" placeholder="Цена" required/>
                        </div>
                        <div class="form-group">
                            <label for="input_category">Категория</label>
                            <select id="input_category" name="category" class="form-control">
                                <c:forEach items="${categories}" var="current">
                                    <option value="${current.id}">${current.name}</option>
                                </c:forEach>
                            </select>
                        </div>
                        <div class="form-group">
                            <label for="input_dimension">Единица измерения</label>
                            <select id="input_dimension" name="countType" class="form-control">
                                <c:forEach items="${countType}" var="current">
                                    <option value="${current.value}">${current.value}</option>
                                </c:forEach>
                            </select>
                        </div>
                        <div class="form-group">
                            <input id="input_photo" class="form-control" type="file" name="photo" required/>
                        </div>
                    <button onclick="submitProductAddForm()" id="submitProductBtn" type="button"
                                                    class="btn btn-primary">Сохранить
                                            </button>
                </form>
</body>

</html>