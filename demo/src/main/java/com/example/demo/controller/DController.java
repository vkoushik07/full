
package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;



import com.example.demo.entity.Department;
import com.example.demo.service.DService;

import jakarta.validation.Valid;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;




@RestController
@RequestMapping("/departments")
public class DController {

    @Autowired
    private DService departmentService;
   private final Logger LOGGER = LoggerFactory.getLogger(DController.class);



    @PostMapping
    public Department saveDepartment(@Valid @RequestBody Department department) {
        LOGGER.info("inside the save department");
        return departmentService.saveDepartment(department);
    }
    @GetMapping
    public List<Department> fetchDepartment() {
        return  departmentService.fetchDepartment();
    }
    @GetMapping("/{id}")
    public Department fetchbyid(@PathVariable("id") long departmentid) {
        return departmentService.fetchbyid(departmentid);
    }
    @DeleteMapping("/{id}")
    public String deletebyid(@PathVariable("id") long departmentid){
        departmentService.deletebyid(departmentid);
        return "department has been deleted";
    }
    @PutMapping("/{id}")
    public Department updatebyid(@PathVariable long departmentid, @RequestBody Department department) {
        //TODO: process PUT request
        
        return departmentService.updatebyid(departmentid,department);
    }
    @GetMapping("/name/{name}")
    public Department getbyname(@PathVariable("name") String departmentname) {
        return departmentService.getbyname(departmentname);
    }
    
}
