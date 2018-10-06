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
package com.assignment.organizationstructure.repository;

import com.assignment.organizationstructure.model.EmployeeResource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("organizationStructureRepository")
public interface OrganizationStructureRepository extends JpaRepository<EmployeeResource, Long> {

  @SuppressWarnings("unchecked")
  EmployeeResource save(EmployeeResource employeeResource);

  EmployeeResource findByEmpId(Long employeeId);

  @Query(value = "SELECT b.first_name, COUNT(*) AS Number_of_suborinates FROM organization_Employee e "
      + "JOIN organization_Employee b ON b.emp_id=e.manager_ID GROUP BY b.emp_id, b.first_name "
      + "ORDER BY Number_of_suborinates DESC LIMIT 1", nativeQuery = true)
  String getMaxSubordinateEmployee();


  @Query(value = "SELECT SUM(e.SALARY) FROM organization_Employee e "
      + "JOIN organization_Employee b ON b.Emp_ID=e.manager_ID AND b.Emp_ID = ?1", nativeQuery = true)
  Long totalSalary(Long employeeId);

  @Query(value = "SELECT e.first_name as empName, b.first_name as ManagerName  FROM organization_Employee e JOIN organization_Employee b "
      + "ON b.Emp_ID=e.manager_ID GROUP BY b.Emp_ID, b.first_name,e.EMP_ID", nativeQuery = true)
  List<Object[]> printOrganizationStructure();
}
