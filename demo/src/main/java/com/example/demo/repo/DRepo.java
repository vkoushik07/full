//  package com.example.demo.repo;

// import org.springframework.data.jpa.repository.JpaRepository;
// import org.springframework.stereotype.Repository;

// import com.example.demo.entity.Department;

// @Repository
// public interface drepo extends JpaRepository <Department,Long>{

    

    
// }
package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Department;
@Repository
public interface DRepo extends JpaRepository<Department, Long> {
    public Department findByDepartmentName(String departmentname);
    public Department findByDepartmentNameIgnoreCase(String departmentname);
}
