package org.example;


import org.example.entity.Employee;

import java.util.*;

public class Main {
    private static Map<Integer, Employee> employeeMap;
    private static List<Employee> duplicatedEmployees;

    public static void main(String[] args) {


        List<Object> employees = new LinkedList<>();
        employees.add(new Employee(21,"Omer","Ozy"));
        employees.add(new Employee(33,"Batu","Kans"));
        employees.add(new Employee(12,"Johny","Bravo"));
    }

    public static List<Employee> findDuplicates(List<Employee> employees) {
        duplicatedEmployees = new LinkedList<>();
        employeeMap = new HashMap<>();
        Iterator<Employee> iterator = employees.iterator();
        while (iterator.hasNext()){
            Employee employee = iterator.next();
            if (employee==null){
                System.out.println("null data buldum");
                continue;
            }
            if(employeeMap.containsKey(employee.getId())){
                duplicatedEmployees.add(employee);
            }else{
                employeeMap.put(employee.getId(),employee);
            }
        }
        return  duplicatedEmployees;
    }
    //frequency update


    public static Map<Integer, Employee> findUniques(List<Employee> employees) {
        employeeMap = new HashMap<>();
        Iterator<Employee> iterator = employees.iterator();
        while (iterator.hasNext()){
            Employee employee = iterator.next();
            if (employee==null){
                System.out.println("null data buldum");
                continue;
            }
            if (!employeeMap.containsKey(employee.getId())){
                employeeMap.put(employee.getId(),employee);
            }
        }
        return employeeMap;
    }

    public static List<Employee> removeDuplicates(List<Employee> employees) {
        List<Employee> duplicates = findDuplicates(employees);
        Map<Integer, Employee> uniques = findUniques(employees);
        List<Employee> onlyUnique = new LinkedList<>(uniques.values());
        onlyUnique.removeAll(duplicates);
        return onlyUnique;
    }


}