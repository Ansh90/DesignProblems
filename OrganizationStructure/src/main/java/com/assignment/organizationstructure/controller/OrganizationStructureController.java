/**
 * The MIT License
 * Copyright (c) 2018 Anshul Mohil
 * <p>
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * <p>
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 * <p>
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package com.assignment.organizationstructure.controller;

import com.assignment.organizationstructure.exception.BusinessException;
import com.assignment.organizationstructure.model.DataDumpResponse;
import com.assignment.organizationstructure.model.EmployeeResource;
import com.assignment.organizationstructure.model.OrganizationStructureExceptionResource;
import com.assignment.organizationstructure.service.IOrganizationStructureService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.*;
import java.util.ArrayList;
import java.util.List;

@Path("/organization-structure")
public class OrganizationStructureController {

  private static final Logger logger = LoggerFactory.getLogger(OrganizationStructureController.class);

  @Autowired
  private IOrganizationStructureService organizationStructureService;


  //TODO: This call should be a put call as the behaviour is idempotent
  @Produces("application/json")
  @Consumes("application/json")
  @POST
  @Path("/dump")
  public DataDumpResponse loadEmployees(List<EmployeeResource> employeeResource) {
    DataDumpResponse response = new DataDumpResponse();

    try {
      response = organizationStructureService.loadEmployees(employeeResource);
    } catch (BusinessException businessException) {
      return getDataDumpResponse(response, businessException);
    }
    return response;
  }

  private DataDumpResponse getDataDumpResponse(DataDumpResponse response, BusinessException businessException) {
    logger.error("Exception code {}", businessException.getCode());
    logger.error("Exception: {}", businessException.getException().toString());

    response.setStatus(businessException.getStatus());
    response.setStatusCode(businessException.getCode());


    List<OrganizationStructureExceptionResource> exceptions = new ArrayList<>();
    OrganizationStructureExceptionResource exception = new OrganizationStructureExceptionResource();
    exception.setErrorCode(businessException.getCode());
    exception.setErrorMessage(businessException.getException().toString());
    exceptions.add(exception);
    response.setExceptions(exceptions);

    return response;
  }

  @Produces("application/json")
  @GET
  @Path("/change-manager/{employeeId}/{managerId}")
  public DataDumpResponse changeManager(@PathParam("employeeId") long employeeId, @PathParam("managerId") long managerId) {
    DataDumpResponse response = new DataDumpResponse();

    try {
      response = organizationStructureService.changeManager(employeeId, managerId);
    } catch (BusinessException businessException) {
      return getDataDumpResponse(response, businessException);
    }

    return response;
  }

  @Produces("application/text")
  @GET
  @Path("/max-subordinate-employee")
  public String maxSubordinateEmployee() {
    String response = null;

    try {
      response = organizationStructureService.getMaxSubordinateEmployee();
    } catch (BusinessException businessException) {
      return fillExceptionObject(response, businessException);
    }

    return response;
  }

  @Produces("application/text")
  @GET
  @Path("/total-salary/{employeeId}")
  public String totalSalary(@PathParam("employeeId") long employeeId) {
    String response;

    try {
      response = organizationStructureService.totalSalary(employeeId);
    } catch (BusinessException businessException) {
      return fillExceptionObject(null, businessException);
    }

    return response;
  }

  private String fillExceptionObject(String response, BusinessException businessException) {
    logger.error("Exception code {}", businessException.getCode());
    logger.error("Exception: {}", businessException.getException().toString());
    List<OrganizationStructureExceptionResource> exceptions = new ArrayList<>();
    OrganizationStructureExceptionResource exception = new OrganizationStructureExceptionResource();
    exception.setErrorCode(businessException.getCode());
    exception.setErrorMessage(businessException.getException().toString());
    exceptions.add(exception);
    return response;
  }

  @Produces("application/text")
  @GET
  @Path("/print-organization-structure")
  public String printOrganizationStructure() {
    String response;

    try {
      organizationStructureService.printOrganizationStructure();
      response = "Please refer console";
    } catch (BusinessException businessException) {
      return fillExceptionObject(null, businessException);
    }

    return response;
  }

  @Produces("application/text")
  @GET
  @Path("/resignation/{employeeId}")
  public String removeEmployee(@PathParam("employeeId") Long employeeId) {
    String response;

    try {
      organizationStructureService.removeEmployee(employeeId);
      response = "Employee " + employeeId + " resigned from organization.";
    } catch (BusinessException businessException) {
      return fillExceptionObject(null, businessException);
    }
    return response;
  }
}
