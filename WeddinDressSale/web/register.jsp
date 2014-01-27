<%-- 
    Document   : register
    Created on : Jan 19, 2014, 12:56:16 AM
    Author     : Nargiz
--%>

<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <jsp:include page="common/meta.jsp"/>
        <jsp:include page="common/style.jsp"/>		
    </head>

    <body>
        <div class="container-fluid">
            <div class="row-fluid">

                <div class="row-fluid">
                    <div class="span12 center login-header">
                        <h2>Wedding Dress Sales Registration Page</h2>
                    </div><!--/span-->
                </div><!--/row-->

                <div class="row-fluid sortable">
                    <div class="box span12">
                        <div class="box-header well" data-original-title>
                            <h2><i class="icon-edit"></i>Registration form</h2>                            
                        </div>
                        <div class="box-content">
                            <form class="form-horizontal" method="POST" action="cs?action=register">
                                <fieldset>  
                                   
                                    <c:choose>
                                        <c:when test="${not empty sessionScope.registrationErrors.firstname}">
                                            <div class="control-group error">
                                                <label class="control-label" for="firstname">Name </label>
                                                <div class="controls">
                                                    <input type="text" class="input-xlarge" id="firstname" name="firstname" value="${sessionScope.registrationForm.firstname}">

                                                    <c:if test="${not empty sessionScope.registrationErrors.firstname}">
                                                        <span class="help-inline">
                                                            <c:forEach var="err" items="${sessionScope.registrationErrors.firstname}">
                                                                ${err} <br/>
                                                            </c:forEach>
                                                        </span>
                                                    </c:if> 
                                                </div>
                                            </div>
                                        </c:when>
                                        <c:otherwise>
                                            <div class="control-group">
                                                <label class="control-label" for="firstname">Firstname </label>
                                                <div class="controls">
                                                    <input type="text" class="input-xlarge" id="firstname" name="firstname">            
                                                </div>
                                            </div>
                                        </c:otherwise>
                                    </c:choose>

                                    <c:choose>
                                        <c:when test="${not empty sessionScope.registrationErrors.lastname}">
                                            <div class="control-group error">
                                                <label class="control-label" for="lastname">Lastname </label>
                                                <div class="controls">
                                                    <input type="text" class="input-xlarge" id="lastname" name="lastname" value="${sessionScope.registrationForm.lastname}">

                                                    <c:if test="${not empty sessionScope.registrationErrors.lastname}">
                                                        <span class="help-inline">
                                                            <c:forEach var="err" items="${sessionScope.registrationErrors.lastname}">
                                                                ${err} <br/>
                                                            </c:forEach>
                                                        </span>
                                                    </c:if> 
                                                </div>
                                            </div>
                                        </c:when>
                                        <c:otherwise>
                                            <div class="control-group">
                                                <label class="control-label" for="lastname">Last Name </label>
                                                <div class="controls">
                                                    <input type="text" class="input-xlarge" id="lastname" name="lastname">            
                                                </div>
                                            </div>
                                        </c:otherwise>
                                    </c:choose>
                                    <div class="control-group">
                                        <label class="control-label" for="email">Email </label>
                                        <div class="controls">
                                            <input type="text" class="input-xlarge" id="email" name="email">

                                            <c:if test="${not empty sessionScope.registrationErrors.email}">
                                                <span class="help-inline">
                                                    <c:forEach var="err" items="${sessionScope.registrationErrors.email}">
                                                        ${err} <br/>
                                                    </c:forEach>
                                                </span>
                                            </c:if> 
                                        </div>
                                    </div>

                                   <c:choose>
                                        <c:when test="${not empty sessionScope.registrationErrors.username}">
                                            <div class="control-group error">
                                                <label class="control-label" for="username">Username </label>
                                                <div class="controls">
                                                    <input type="text" class="input-xlarge" id="username" name="username" value="${sessionScope.registrationForm.username}">
                                                    <span class="help-inline">
                                                        <c:forEach var="err" items="${sessionScope.registrationErrors.username}">
                                                            ${err} <br/>
                                                        </c:forEach>
                                                    </span>

                                                </div>
                                            </div>
                                        </c:when>
                                        <c:otherwise>
                                            <div class="control-group">
                                                <label class="control-label" for="username">Username </label>
                                                <div class="controls">
                                                    <input type="text" class="input-xlarge" id="username" name="username">                                                   
                                                </div>
                                            </div>
                                        </c:otherwise>

                                    </c:choose>

                                    <div class="control-group">
                                        <label class="control-label" for="password">Password </label>
                                        <div class="controls">
                                            <input type="password" class="input-xlarge" id="password" name="password">

                                            <c:if test="${not empty sessionScope.registrationErrors.password}">
                                                <span class="help-inline">
                                                    <c:forEach var="err" items="${sessionScope.registrationErrors.password}">
                                                        ${err} <br/>
                                                    </c:forEach>
                                                </span>
                                            </c:if> 
                                        </div>
                                    </div>

                                    <div class="control-group">
                                        <label class="control-label" for="password">Password confirmation</label>
                                        <div class="controls">
                                            <input type="password" class="input-xlarge" id="passwordConfirmation" name="passwordConfirmation">
                                        </div>
                                    </div>
 <c:choose>
                                        <c:when test="${not empty sessionScope.registrationErrors.country}">
                                            <div class="control-group error">
                                                <label class="control-label" for="country">Country </label>
                                                <div class="controls">
                                                    <input type="text" class="input-xlarge" id="country" name="country" value="${sessionScope.registrationForm.country}">
                                                    <span class="help-inline">
                                                        <c:forEach var="err" items="${sessionScope.registrationErrors.country}">
                                                            ${err} <br/>
                                                        </c:forEach>
                                                    </span>

                                                </div>
                                            </div>
                                        </c:when>
                                        <c:otherwise>
                                            <div class="control-group">
                                                <label class="control-label" for="country">Country </label>
                                                <div class="controls">
                                                    <input type="text" class="input-xlarge" id="country" name="country">                                                   
                                                </div>
                                            </div>
                                        </c:otherwise>

                                    </c:choose> 
                                  
                                           <c:choose>
                                        <c:when test="${not empty sessionScope.registrationErrors.city}">
                                            <div class="control-group error">
                                                <label class="control-label" for="city">City </label>
                                                <div class="controls">
                                                    <input type="text" class="input-xlarge" id="city" name="city" value="${sessionScope.registrationForm.city}">
                                                    <span class="help-inline">
                                                        <c:forEach var="err" items="${sessionScope.registrationErrors.city}">
                                                            ${err} <br/>
                                                        </c:forEach>
                                                    </span>

                                                </div>
                                            </div>
                                        </c:when>
                                        <c:otherwise>
                                            <div class="control-group">
                                                <label class="control-label" for="city">City </label>
                                                <div class="controls">
                                                    <input type="text" class="input-xlarge" id="city" name="city">                                                   
                                                </div>
                                            </div>
                                        </c:otherwise>

                                    </c:choose>  
                                             <c:choose>
                                        <c:when test="${not empty sessionScope.registrationErrors.address}">
                                            <div class="control-group error">
                                                <label class="control-label" for="Address">Address </label>
                                                <div class="controls">
                                                    <input type="text" class="input-xlarge" id="address" name="address" value="${sessionScope.registrationForm.address}">
                                                    <span class="help-inline">
                                                        <c:forEach var="err" items="${sessionScope.registrationErrors.address}">
                                                            ${err} <br/>
                                                        </c:forEach>
                                                    </span>

                                                </div>
                                            </div>
                                        </c:when>
                                        <c:otherwise>
                                            <div class="control-group">
                                                <label class="control-label" for="address">Address </label>
                                                <div class="controls">
                                                    <input type="text" class="input-xlarge" id="address" name="address">                                                   
                                                </div>
                                            </div>
                                        </c:otherwise>

                                    </c:choose>
                                     <c:choose>
                                        <c:when test="${not empty sessionScope.registrationErrors.postalCode}">
                                            <div class="control-group error">
                                                <label class="control-label" for="postalCode">Postal Code </label>
                                                <div class="controls">
                                                    <input type="text" class="input-xlarge" id="postalCode" name="postalCode" value="${sessionScope.registrationForm.postalCode}">
                                                    <span class="help-inline">
                                                        <c:forEach var="err" items="${sessionScope.registrationErrors.postalCode}">
                                                            ${err} <br/>
                                                        </c:forEach>
                                                    </span>

                                                </div>
                                            </div>
                                        </c:when>
                                        <c:otherwise>
                                            <div class="control-group">
                                                <label class="control-label" for="postalCode">Postal Code </label>
                                                <div class="controls">
                                                    <input type="text" class="input-xlarge" id="postalCode" name="postalCode">                                                   
                                                </div>
                                            </div>
                                        </c:otherwise>

                                    </c:choose>
                                    <c:choose>
                                        <c:when test="${not empty sessionScope.registrationErrors.phoneNo}">
                                            <div class="control-group error">
                                                <label class="control-label" for="phoneNo">Phone No </label>
                                                <div class="controls">
                                                    <input type="text" class="input-xlarge" id="phoneNo" name="phoneno" value="${sessionScope.registrationForm.phoneNo}">
                                                    <span class="help-inline">
                                                        <c:forEach var="err" items="${sessionScope.registrationErrors.phoneNo}">
                                                            ${err} <br/>
                                                        </c:forEach>
                                                    </span>
                                                </div>
                                            </div>
                                        </c:when>
                                        <c:otherwise>
                                            <div class="control-group">
                                                <label class="control-label" for="phoneNo">Phone No </label>
                                                <div class="controls">
                                                    <input type="text" class="input-xlarge" id="phoneNo" name="phoneNo">                                                   
                                                </div>
                                            </div>
                                        </c:otherwise>
                                    </c:choose>
                                        </div>
                                    </div>

</div>


                                        </div>
                                    </div>
                                    <div class="form-actions">
                                        <button type="submit" class="btn btn-primary">Register</button>
                                        <button type="reset" class="btn">Clear</button>
                                    </div>
                                </fieldset>
                            </form>   

                        </div>
                    </div><!--/span-->
                    <!--/row-->
                </div><!--/fluid-row-->

            </div><!--/.fluid-container-->

            <jsp:include page="common/javascript.jsp"/>
    </body>
</html>

