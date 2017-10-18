import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

@WebServlet(urlPatterns = "/QuerySelect")
public class QuerySelect extends HttpServlet {
    private ArrayList<Values> valuesArrayList = new ArrayList<Values>();

    @Override
    protected void doPost(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        String query = "SELECT * FROM `values`";

        try {
            ConnectionDataBase connectionDataBase = new ConnectionDataBase();
            Statement statement = connectionDataBase.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            valuesArrayList.clear();
            while (resultSet.next()) {
                valuesArrayList.add(
                        new Values(resultSet.getInt(1), resultSet.getInt(2), resultSet.getString(3)));
            }

            PrintWriter printWriter = httpServletResponse.getWriter();

            printWriter.println("ID\tValue\tNote\n");
            for (Values val : valuesArrayList) {
                printWriter.println(val.getId() + "\t" + val.getValue() + "\t" + val.getNote());
            }

            resultSet.close();
            statement.close();
            connectionDataBase.close();

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
