// package com.example.demo.service;

// import com.example.demo.entity.Department;

// public interface dservice {
    
//     public  Department savDepartment(Department department);
    
// }
package com.example.demo.service;
import java.util.List;


import com.example.demo.entity.Department;

public interface DService {
    Department saveDepartment(Department department);
     public List<Department> fetchDepartment();
     public Department fetchbyid(Long departmentid);
     public void deletebyid(Long departmentid);
     public Department updatebyid(Long departmentid, Department department);
     public Department getbyname(String departmentname);
}
