<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Dark
  Date: 07.11.2016
  Time: 14:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<style type="text/css">
    span.error {
        color: red;
    }
</style>
<spring:message code="message_add_idea" var="messageaddidea" />
<form:form method="POST" action="${pageContext.servletContext.contextPath}/addideapost" enctype="multipart/form-data">
    <table id="tableAddIdea">
        <tr>
            <td><form:label path="caption">Title</form:label></td>
            <td><form:input path="caption" maxlength="128"/></td>
            <td><span class="error" ><form:errors path="caption" /></span></td>
        </tr>
        <tr>
            <td><form:label path="category">Category</form:label></td>
            <td><form:select path="category" items="${cat}">


            </form:select></td>
        </tr>
        <tr>
            <td><form:label path="txt">Text</form:label></td>
            <td><form:textarea path="txt" cols="30" rows="5"/></td>
            <td><span class="error" ><form:errors path="txt" /></span></td>
        </tr>
        <tr>
            <td><form:label path="pict">Picture</form:label></td>

            <td><input name="p" type="file"/></td>
            <td><span class="error" ><form:errors path="file" /></span></td>

        </tr>
        <tr>
            <td><form:label path="video">Video YOUTUBE</form:label></td>
            <td><form:input path="video" maxlength="11"/></td>
            <td><span class="error" ><form:errors path="video" /></span></td>
        </tr>
        <tr>
            <td><form:label path="tags">Tags</form:label></td>
            <td><form:input path="tags" maxlength="256"/></td>
            <td><span class="error" ><form:errors path="tags" /></span></td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" value="Submit"/>
            </td>
        </tr>
    </table>
</form:form>
<br />
${messageaddidea}