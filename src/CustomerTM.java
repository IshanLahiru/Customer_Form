import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;

public class CustomerTM {
    private String custId;
    private String custName;
    private String custAddress;
    private double salary;
    private Button btn;

    public CustomerTM(String custId, String custName, String custAddress, double salary, Button btn) {
        this.custId = custId;
        this.custName = custName;
        this.custAddress = custAddress;
        this.salary = salary;
        this.btn = btn;
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

    public Button getBtn() {
        return btn;
    }

    public void setBtn(Button btn) {
        this.btn = btn;
    }

    @Override
    public String toString() {
        return "CustomerTM{" +
                "custId='" + custId + '\'' +
                ", custName='" + custName + '\'' +
                ", custAddress='" + custAddress + '\'' +
                ", salary=" + salary +
                '}';
    }
}
