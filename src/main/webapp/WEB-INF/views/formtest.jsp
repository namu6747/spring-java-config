<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>

<h1><s:message code="hello" /></h1>

<f:form modelAttribute="testVO" method="POST">
    <table>
        <tr>
            <td>id:</td>
            <td><f:input path="id"/></td>
            <%-- Show errors for firstName field --%>
            <td><f:errors path="id"/></td>
        </tr>

        <tr>
            <td>pw:</td>
            <td><f:input path="pw"/></td>
            <%-- Show errors for lastName field --%>
            <td><f:errors path="pw"/></td>
        </tr>
        <tr>
            <td colspan="3">
                <input type="submit" value="Save Changes"/>
            </td>
        </tr>
    </table>
</f:form>