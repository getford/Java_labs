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

@WebServlet(urlPatterns = "/QueryWhereSelect")
public class QueryWhereSelect extends HttpServlet {
    private ArrayList<Values> valuesArrayList = new ArrayList<Values>();

    @Override
    protected void doPost(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        PrintWriter printWriter = httpServletResponse.getWriter();

        String param = httpServletRequest.getParameter("whereValue");
        int countValue = 0;

        String query = "SELECT * FROM `values` WHERE value = " + param;
        String queryCount = "SELECT COUNT(*) FROM `values` WHERE value = " + param;

        if (!param.equals("")) {
            try {
                ConnectionDataBase connectionDataBase = new ConnectionDataBase();
                Statement statement = connectionDataBase.getConnection().createStatement();

                ResultSet resultSet;
                resultSet = statement.executeQuery(queryCount);
                while (resultSet.next())
                    countValue = resultSet.getInt(1);

                if (!(countValue < 1)) {
                    resultSet = statement.executeQuery(query);

                    valuesArrayList.clear();

                    while (resultSet.next()) {
                        valuesArrayList.add(
                                new Values(resultSet.getInt(1), resultSet.getInt(2), resultSet.getString(3)));
                    }

                    printWriter.println("ID\tValue\tNote\n");
                    for (Values val : valuesArrayList) {
                        printWriter.println(val.getId() + "\t" + val.getValue() + "\t" + val.getNote());
                    }

                    printWriter.println("\n\nCount: " + countValue);
                } else
                    printWriter.println("<br><h1>No lines!</h1>");

                resultSet.close();
                statement.close();
                connectionDataBase.close();

            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        } else
            printWriter.println("<br><h1>Enter value!</h1>");
    }
}
