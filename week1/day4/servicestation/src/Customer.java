class Customer extends Vechicle{

    private String name;
    private String empName;
    private long contactNo;
    private int age;
    private int empId;

    public void setName(String name){
        this.name=name;
    }

    public String getName() {
        return name;
    }

    public void setEmpName(String  empName) {
        this.empName = empName;
    }

    public String getEmpName() {
        return empName;
    }

    public void setContactNo(long contactNo) {
        this.contactNo = contactNo;
    }

    public long getContactNo() {
        return contactNo;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public int getEmpId() {
        return empId;
    }

}

