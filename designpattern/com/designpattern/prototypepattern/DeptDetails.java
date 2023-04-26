package designpattern.com.designpattern.prototypepattern;

import java.util.ArrayList;
import java.util.List;

public class DeptDetails implements Cloneable{
    
    public int deptId;
    public List<Employee>employees;

    public DeptDetails(){
        employees=new ArrayList<>();
        for(int i=0;i<5;i++){
            Employee empl=new Employee();
            empl.setId(i);
            empl.setName("empl"+i);
            this.employees.add(empl);
        }
    }

    public DeptDetails(int id,List<Employee> employees){
        this.deptId=id;
        this.employees=employees;
    }

    // /**
    //  * Shallow copy
    //  */
    // @Override
    // public DeptDetails clone() throws CloneNotSupportedException{
    //   return  (DeptDetails) super.clone();
    // }

    /**
     * Deep copy
     */
 @Override
    public DeptDetails clone() throws CloneNotSupportedException{
    
        List<Employee> listNew=new ArrayList<>();
        for(Employee i: this.employees){
            listNew.add(i);
        }
      DeptDetails deptNew=new DeptDetails(deptId,listNew);
      return deptNew;
    }

    /** 
     * Copy constructor also does deep copy
     */
    // DeptDetails(DeptDetails deptDetails){
    //     this.deptId=deptDetails.deptId;
    //     this.employees=deptDetails.employees;
    // }

}
