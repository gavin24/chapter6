package com.ackerman.j.gavin.zootrack.FactoryTests;

import com.ackerman.j.gavin.zootrack.Domain.Employee;
import com.ackerman.j.gavin.zootrack.Factory.EmployeeFactory;
import com.ackerman.j.gavin.zootrack.Factory.Impl.EmployeeFactoryImpl;

import junit.framework.Assert;
import junit.framework.TestCase;

import org.junit.Test;

import java.sql.Date;

/**
 * Created by gavin.ackerman on 2016-04-15.
 */
public class EmployeeTest extends TestCase {
    private EmployeeFactory factory;


    public void setUp() throws Exception{
        factory = EmployeeFactoryImpl.getInstance();
    }

    @Test
    public void testEmployeeCreation()
    {
        Date start = new Date(2013,10,13);
        Employee employee = factory.createEmployee((long) 2323, "John", "Peters", 23,"South Africa");
        Assert.assertEquals(23, employee.getAge());
    }

    @Test
    public void testEmployeeCreationUpdate()
    {
        Date start = new Date(2013,10,13);
        Employee employee = factory.createEmployee((long) 2323, "John", "Peters", 23,"South Africa");
        Assert.assertEquals(23, employee.getAge());

        Employee upodateEmployee = new Employee.Builder(employee.getId())
                .copy(employee)
                .name("bruce")
                .build();

        Assert.assertEquals("bruce", upodateEmployee.getName());

    }
}
