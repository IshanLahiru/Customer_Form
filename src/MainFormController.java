import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TouchEvent;

public class MainFormController {
    public TextField txtCustId;
    public TextField txtCustName;

    public TextField txtCustAddress;
    public TextField txtCustSallery;
    public TableColumn colId;
    public TableColumn colName;
    public TableColumn colAddress;
    public TableColumn colSalary;
    public TableColumn colOperation;
    public TableView tblCustomer;

    public void initialize() {
        colId.setCellValueFactory(new PropertyValueFactory<CustomerTM, String>("custId"));
        colName.setCellValueFactory(new PropertyValueFactory<CustomerTM, String>("custName"));
        colAddress.setCellValueFactory(new PropertyValueFactory<CustomerTM, String>("custAddress"));
        colSalary.setCellValueFactory(new PropertyValueFactory<CustomerTM, Double>("salary"));
        colOperation.setCellValueFactory(new PropertyValueFactory<CustomerTM, Button>("btn"));

        setData();
    }

    public void setData() {
        ObservableList<CustomerTM> cust = FXCollections.observableArrayList();

        for (Customer ob : Database.ar) {
            Button tem = new Button("Delete");
            CustomerTM temp = new CustomerTM(ob.getCustId(), ob.getCustName(), ob.getCustAddress(), ob.getSalary(), tem);
            cust.add(temp);
            tem.setOnAction(e -> {
                Database.ar.remove(ob);
                setData();
            });
        }
        tblCustomer.setItems(cust);
    }

    public void saveButtonOnAction(ActionEvent actionEvent) {
        Customer c1 = new Customer(txtCustId.getText(), txtCustName.getText(), txtCustAddress.getText(),
                Double.parseDouble(txtCustSallery.getText()));
        Database.ar.add(c1);

        setData();

        txtCustId.clear();
        txtCustSallery.clear();
        txtCustName.clear();
        txtCustAddress.clear();
    }

    public void updateButtonOnAction(ActionEvent actionEvent) {
        for(Customer ob : Database.ar){
            if(ob.getCustId().equals(txtCustId.getText())){
                ob.setCustName(txtCustName.getText());
                ob.setCustAddress(txtCustAddress.getText());
                ob.setSalary(Double.parseDouble(txtCustSallery.getText()));
                setData();
            }
        }
        txtCustId.setDisable(false);
        txtCustId.clear();
        txtCustSallery.clear();
        txtCustName.clear();
        txtCustAddress.clear();
    }

    public void tblAction(TouchEvent touchEvent) {
        System.err.println("tbl 1");
    }

    public void tblAction2(MouseEvent mouseEvent) {
        System.err.println("tbl 2");
    }

    public void tblAction3(MouseEvent mouseEvent) {
        txtCustId.setDisable(true);
       if(tblCustomer.getSelectionModel().getSelectedItem()!=null) {
           CustomerTM temp = (CustomerTM) tblCustomer.getSelectionModel().getSelectedItem();
           txtCustId.setText(temp.getCustId());
           txtCustName.setText(temp.getCustName());
           txtCustAddress.setText(temp.getCustAddress());
           txtCustSallery.setText(String.valueOf(temp.getSalary()));
       }
    }
}
