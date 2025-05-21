// package com.example.demo.entity;

// import jakarta.persistence.Entity;
// import jakarta.persistence.GeneratedValue;
// import jakarta.persistence.GenerationType;
// import jakarta.persistence.Id;

// @Entity
// public class Department {
//     @Id
//     @GeneratedValue(strategy = GenerationType.AUTO)
//     private long Departmentid;
//     private long Departmentname;
//     private long Departmentaddress;
//     private long Departmentcode;
//     public long getDepartmentid() {
//         return Departmentid;
//     }
//     public void setDepartmentid(long departmentid) {
//         Departmentid = departmentid;
//     }
//     public long getDepartmentname() {
//         return Departmentname;
//     }
//     public void setDepartmentname(long departmentname) {
//         Departmentname = departmentname;
//     }
//     public long getDepartmentaddress() {
//         return Departmentaddress;
//     }
//     public void setDepartmentaddress(long departmentaddress) {
//         Departmentaddress = departmentaddress;
//     }
//     public long getDepartmentcode() {
//         return Departmentcode;
//     }
//     public void setDepartmentcode(long departmentcode) {
//         Departmentcode = departmentcode;
//     }
//     public Department(long departmentid, long departmentname, long departmentaddress, long departmentcode) {
//         Departmentid = departmentid;
//         Departmentname = departmentname;
//         Departmentaddress = departmentaddress;
//         Departmentcode = departmentcode;
//     }
//     @Override
//     public String toString() {
//         return "Department [Departmentid=" + Departmentid + ", Departmentname=" + Departmentname
//                 + ", Departmentaddress=" + Departmentaddress + ", Departmentcode=" + Departmentcode + "]";
//     }


// }

package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long departmentId;
    @NotBlank(message = "please enter the department name")
    @NotNull(message = "can be empty")
    private String departmentName;
    private String departmentAddress;
    private String departmentCode;

    // Getters and Setters

    // public Long getDepartmentId() {
    //     return departmentId;
    // }

    // public void setDepartmentId(Long departmentId) {
    //     this.departmentId = departmentId;
    // }

    // public String getDepartmentName() {
    //     return departmentName;
    // }

    // public void setDepartmentName(String departmentName) {
    //     this.departmentName = departmentName;
    // }

    // public String getDepartmentAddress() {
    //     return departmentAddress;
    // }

    // public void setDepartmentAddress(String departmentAddress) {
    //     this.departmentAddress = departmentAddress;
    // }

    // public String getDepartmentCode() {
    //     return departmentCode;
    // }

    // public void setDepartmentCode(String departmentCode) {
    //     this.departmentCode = departmentCode;
    // }
    // @Override
    //     public String toString() {
    //         return "Department [Departmentid=" + departmentId + ", Departmentname=" + departmentName
    //                 + ", Departmentaddress=" + departmentAddress + ", Departmentcode=" + departmentCode + "]";
    //     }
}
