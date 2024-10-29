package EditServlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import TestConnection.DataConnect;

public class EditServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public EditServlet() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Lấy các giá trị từ form
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String locate = request.getParameter("locate");
        String gender = request.getParameter("gender");
        String phone = request.getParameter("phone");
        String birthday = request.getParameter("birthday");
        String[] KoT = request.getParameterValues("Type");
        boolean sex = "1".equals(gender);
        String regex = "^(\\+84|0)(\\d{9,10})$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(phone);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        if (name == null || name.isEmpty() || email == null || email.isEmpty() || locate == null || locate.isEmpty() || phone == null || phone.isEmpty()) {
            throw new ServletException("Missing required parameters");
        }
        String Kind = String.join(" ", KoT);  

        Connection conn = null;
        PreparedStatement stmt = null;

        try {
        	
        	conn = DataConnect.getConnection(); 
        	
            String sql = "UPDATE client SET email = ?, locate = ?, sex = ?, phone = ?, birthday = ?, delivery = ? WHERE accname = ?";

            stmt = conn.prepareStatement(sql);

            stmt.setString(1, email);
            stmt.setString(2, locate);
            stmt.setString(3, sex ? "Nữ" : "Nam");
            stmt.setString(4, phone);

            try {
                Date birthDate = dateFormat.parse(birthday);
                java.sql.Date sqlBirthDate = new java.sql.Date(birthDate.getTime());
                stmt.setDate(5, sqlBirthDate);
            } catch (ParseException e) {
                e.printStackTrace();
            }

            stmt.setString(6, Kind);
            stmt.setString(7, name);

            int rowsUpdated = stmt.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Cập nhật thông tin tài khoản thành công!");
            } else {
                System.out.println("Không tìm thấy tài khoản để cập nhật!");
            }

        } catch (ClassNotFoundException | SQLException e) {
            response.getWriter().append("Database error: ").append(e.getMessage());
        } finally {
            if (stmt != null) try { stmt.close(); } catch (SQLException ignore) {}
            if (conn != null) try { conn.close(); } catch (SQLException ignore) {}
        }
        getServletContext().getRequestDispatcher("/FormNew.jsp").forward(request,response);
    }
}

