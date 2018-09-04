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
package com.comparator_comparable;

import java.util.Comparator;

/**
 *
 */
public class Employee implements Comparable<Employee> {

  /**
   * Implementing comaparators
   */
  public static final Comparator<Employee> ID_COMPARATOR = new Comparator<Employee>() {
    @Override
    public int compare(Employee o1, Employee o2) {
      return o1.getId() - o2.getId();
    }
  };
  public static final Comparator<Employee> SALARY_COMPARATOR = new Comparator<Employee>() {
    @Override
    public int compare(Employee o1, Employee o2) {
      return o1.getSalary() - o2.getSalary();
    }
  };
  public static final Comparator<Employee> AGE_COMPARATOR = new Comparator<Employee>() {
    @Override
    public int compare(Employee o1, Employee o2) {
      return o1.getAge() - o2.getAge();
    }
  };
  private int id;
  private String name;
  private int age;
  private int salary;

  /**
   * @param id     id
   * @param name   name
   * @param age    age
   * @param salary salary
   */
  public Employee(int id, String name, int age, int salary) {
    this.id = id;
    this.name = name;
    this.age = age;
    this.salary = salary;
  }

  public int getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public int getAge() {
    return age;
  }

  public int getSalary() {
    return salary;
  }

  @Override
  public int compareTo(Employee emp) {
    //let's sort the employee based on id in ascending order
    //returns a negative integer, zero, or a positive integer as this employee id
    //is less than, equal to, or greater than the specified object.
    return (this.id - emp.id);
  }

  @Override
  //this is required to print the user friendly information about the Employee
  public String toString() {
    return "[id=" + this.id + ", name=" + this.name + ", age=" + this.age + ", salary="
        + this.salary + "]";
  }

}

