public class Customer {
    private String custId;
    private String custName;
    private String custAddress;
    private double salary;


    public Customer(String custId, String custName, String custAddress, double salary) {
        this.custId = custId;
        this.custName = custName;
        this.custAddress = custAddress;
        this.salary = salary;
    }



    public String getCustId() {
        return custId;
    }

    public void setCustId(String custId) {
        this.custId = custId;
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public String getCustAddress() {
        return custAddress;
    }

    public void setCustAddress(String custAddress) {
        this.custAddress = custAddress;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
