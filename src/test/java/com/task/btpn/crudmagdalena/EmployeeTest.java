package com.task.btpn.crudmagdalena;

import com.task.btpn.crudmagdalena.data.model.Employee;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

/**
 * Created on 28/08/19
 *
 * Created by Magdalena WR
 */

public class EmployeeTest extends AbstractTest {
    @Override
    @Before
    public void setUp() {
        super.setUp();
    }

    @Test
    public void getAllEmployees() throws Exception{
        String uri = "http://localhost:8080/api/v1/employees";
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
            .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        Assert.assertEquals(200, status);
    }

    @Test
    public void getEmployeeByNIK() throws Exception{
        String uri = "http://localhost:8080/api/v1/employees/get-by-nik/12345";
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        Assert.assertEquals(200, status);
    }

    @Test
    public void getEmployeeByName() throws Exception{
        String uri = "http://localhost:8080/api/v1/employees/get-by-name/lena";
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        Assert.assertEquals(200, status);
    }

    @Test
    public void createEmployee() throws Exception {
        String uri = "http://localhost:8080/api/v1/employees/add";
        Employee employee = new Employee();
        employee.setNik(1234567);
        employee.setNama("lena");
        employee.setTglLahir("10/10/00");
        employee.setPendapatan(10000000.0);

        String inputJson = super.mapToJson(employee);
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(inputJson)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        Assert.assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        Employee check = super.mapFromJson(content, Employee.class);
        Assert.assertTrue(check != null);
    }

    @Test
    public void createEmployeeNIKDuplicate() throws Exception {
        String uri = "http://localhost:8080/api/v1/employees/add";
        Employee employee = new Employee();
        employee.setNik(123456);
        employee.setNama("lena");
        employee.setTglLahir("10/10/00");
        employee.setPendapatan(10000000.0);

        String inputJson = super.mapToJson(employee);
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(inputJson)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        Assert.assertEquals(409, status);
    }

    @Test
    public void createEmployeeTglLahirNotValid() throws Exception {
        String uri = "http://localhost:8080/api/v1/employees/add";
        Employee employee = new Employee();
        employee.setNik(12345678);
        employee.setNama("lena");
        employee.setTglLahir("10/10/2000");
        employee.setPendapatan(10000000.0);

        String inputJson = super.mapToJson(employee);
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(inputJson)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        Assert.assertEquals(400, status);
    }

    @Test
    public void updateEmployee() throws Exception {
        String uri = "http://localhost:8080/api/v1/employees/edit/10";
        Employee employee = new Employee();
        employee.setNik(123456);
        employee.setNama("lena");
        employee.setTglLahir("13/04/00");
        employee.setPendapatan(5000000.0);

        String inputJson = super.mapToJson(employee);
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.put(uri)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(inputJson)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        Assert.assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        Employee check = super.mapFromJson(content, Employee.class);
        Assert.assertTrue(check != null);
    }

    @Test
    public void updateEmployeeIDNotFound() throws Exception {
        String uri = "http://localhost:8080/api/v1/employees/edit/10000";
        Employee employee = new Employee();
        employee.setNik(123456);
        employee.setNama("lena");
        employee.setTglLahir("13/04/00");
        employee.setPendapatan(5000000.0);

        String inputJson = super.mapToJson(employee);
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.put(uri)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(inputJson)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        Assert.assertEquals(404, status);
    }

    @Test
    public void updateEmployeeNIKDuplicate() throws Exception {
        String uri = "http://localhost:8080/api/v1/employees/edit/10";
        Employee employee = new Employee();
        employee.setNik(12345);
        employee.setNama("lena");
        employee.setTglLahir("13/04/00");
        employee.setPendapatan(5000000.0);

        String inputJson = super.mapToJson(employee);
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.put(uri)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(inputJson)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        Assert.assertEquals(409, status);
    }

    @Test
    public void updateEmployeeTglLahirNotValid() throws Exception {
        String uri = "http://localhost:8080/api/v1/employees/edit/10";
        Employee employee = new Employee();
        employee.setNik(123456);
        employee.setNama("lena");
        employee.setTglLahir("13/04/2000");
        employee.setPendapatan(5000000.0);

        String inputJson = super.mapToJson(employee);
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.put(uri)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(inputJson)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        Assert.assertEquals(400, status);
    }

    @Test
    public void deleteEmployee() throws Exception {
        String uri = "http://localhost:8080/api/v1/employees/delete/4";

        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.delete(uri)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        Assert.assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        Assert.assertEquals(content, "Success Delete Employee");
    }

    @Test
    public void deleteEmployeeIDNotFound() throws Exception {
        String uri = "http://localhost:8080/api/v1/employees/delete/10000";

        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.delete(uri)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        Assert.assertEquals(404, status);
    }
}
