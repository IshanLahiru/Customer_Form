import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CustomerModel {

    public static ArrayList<Customer> getAllCustomers() throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM customer";
        ResultSet result = CrudUtil.execute(sql);
        System.out.println("result set size is = "+result.getFetchSize());
        ArrayList<Customer> customer = new ArrayList<>();

        if (result.next()) {
            customer.add(new Customer(
                    result.getString(1),
                    result.getString(2),
                    result.getString(3),
                    Double.parseDouble(result.getString(4))
            ));
        }
        System.out.println(customer.size());
        return customer;

    }
}
