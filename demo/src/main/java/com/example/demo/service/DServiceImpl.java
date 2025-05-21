// package com.example.demo.service;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Service;
// import org.springframework.web.bind.annotation.RestController;

// import com.example.demo.entity.Department;
// import com.example.demo.repo.drepo;

// @Service
// public class dserviceimpl implements dservice{
//     @Autowired
//     private drepo drrepo;
//     @Override
//     public  Department savDepartment(Department department){
//         return drrepo.save(department);
//     }
// }
package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Department;
import com.example.demo.repo.DRepo;
import java.util.List;
import java.util.Objects;


@Service
public class DServiceImpl implements DService {

    @Autowired
    private DRepo dRepo;

    @Override
    public Department saveDepartment(Department department) {
        return dRepo.save(department);
    }
    @Override
    public List<Department> fetchDepartment(){
        return dRepo.findAll();
    }
    public Department fetchbyid(Long departmentid){
        return dRepo.findById(departmentid).get();
    }
    @Override
    public void deletebyid(Long departmentid){
         dRepo.deleteById(departmentid);
    }
    @Override
    public Department updatebyid(Long departmentid,Department department){
        Department db = dRepo.findById(departmentid).get();
        if(Objects.nonNull(department.getDepartmentName())&&!"".equalsIgnoreCase(department.getDepartmentName())){
            db.setDepartmentName(department.getDepartmentName());
        }
        if(Objects.nonNull(department.getDepartmentAddress())&&!"".equalsIgnoreCase(department.getDepartmentAddress())){
            db.setDepartmentName(department.getDepartmentAddress());
        }
        if(Objects.nonNull(department.getDepartmentCode())&&!"".equalsIgnoreCase(department.getDepartmentCode())){
            db.setDepartmentName(department.getDepartmentCode());
        }
        return dRepo.save(db);
    }
    @Override
    public Department getbyname(String departmentname){
     //return dRepo.findByDepartmentName(departmentname);
     return dRepo.findByDepartmentNameIgnoreCase(departmentname);
    }
}
