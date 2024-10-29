package ClientServlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import TestConnection.DataConnect;
import User.User;
import exceptions.ResourceNotFoundException;

/**
 * Servlet implementation class ClientServlet
 */
public class ClientServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClientServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		String name = request.getParameter("name");
		String email = request.getParameter("email");		
		String locate = request.getParameter("locate");
		String gender = request.getParameter("gender"); 
		String phone = request.getParameter("phone");
		String birthday = request.getParameter("birthday");
		String edit = request.getParameter("Edit");
		boolean sex = "1".equals(gender);
		String regex = "^(\\+84|0)(\\d{9,10})$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(phone);
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String[] KoT = request.getParameterValues("Type");
		
		 if (name == null || name.isEmpty() || email == null || email.isEmpty() || locate == null || locate.isEmpty() || phone == null || phone.isEmpty()) {
	            throw new ResourceNotFoundException("No source found");
	        }
		 
		User user = new User();
		user.setEmail(email);
		user.setName(name);
		user.setLocate(locate);
		user.setSex(sex);
		user.setPhone(phone);
		user.setKoT(KoT);
		
		String Kind = "";
		for(String type: user.getKoT())
		{
		Kind=Kind+type+" ";
		}
//		
		 
//		 
		
//		System.out.println(edit);
		
		String url="";
		Connection conn = null;
        PreparedStatement stmt = null;

        try {
             conn = DataConnect.getConnection(); 
                
             String sql = "INSERT INTO client (accname, email, locate, phone, sex, birthday, delivery) VALUES (?, ?, ?, ?, ?, ?, ?)";
                
             stmt = conn.prepareStatement(sql);
             stmt.setString(1, user.getName());
             stmt.setString(2, user.getEmail()); 
             stmt.setString(3, user.getLocate());
             if (matcher.matches()) {
            	 stmt.setString(4, user.getPhone());
              } else {
                 System.out.println(phone + " không hợp lệ.");
              }
             if(user.isSex())
             stmt.setString(5, "Nữ"); 
             else stmt.setString(5, "Nam");
             try {
            	    Date birthDate = dateFormat.parse(birthday); 
            	    
            	    java.sql.Date sqlBirthDate = new java.sql.Date(birthDate.getTime()); 
            	    
            	    user.setBoD(birthDate);
            	    System.out.println("Ngày sinh: " + birthDate);
            	    
            	    stmt.setDate(6, sqlBirthDate);  
            	    
            	} catch (ParseException e) {
            	    e.printStackTrace();
            	}
             stmt.setString(7,  Kind);
                
             int rowsInserted = stmt.executeUpdate();
                
             if (rowsInserted > 0) {
                 System.out.println("Inserted Successfull");
             } else {
            	 System.out.println("Inserted Fail");
             }

             } catch (ClassNotFoundException | SQLException e) {
                response.getWriter().append("Database error: ").append(e.getMessage());
            } finally {
                if (stmt != null) try { stmt.close(); } catch (SQLException ignore) {}
                if (conn != null) try { conn.close(); } catch (SQLException ignore) {}
            }
        if("isEdit".equals(edit)) url = "/EditInfo.jsp";
        else url = "/OrderConfirm.jsp";
		request.setAttribute("user", user);
		getServletContext().getRequestDispatcher(url).forward(request,response);
		
		displayClientList();
	}

	private void displayClientList() {
	    Connection conn = null;
	    PreparedStatement stmt = null;
	    ResultSet rs = null;

	    try {
	        conn = DataConnect.getConnection();
	        String sql = "SELECT accname, email, locate, phone, sex, birthday, delivery FROM client";
	        stmt = conn.prepareStatement(sql);
	        rs = stmt.executeQuery();

	        System.out.println("Danh sách người dùng:");
	        while (rs.next()) {
	            String accname = rs.getString("accname");
	            String email = rs.getString("email");
	            String locate = rs.getString("locate");
	            String phone = rs.getString("phone");
	            String sex = rs.getString("sex");
	            String birthday = rs.getString("birthday");
	            String delivery = rs.getString("delivery");
	            System.out.println("Name: " + accname + " Email: " + email + " Locate: " + locate + " Phone: " + phone + " Gender: " + sex + " Birthday: " + birthday + " Delivery: " + delivery);
	        }
	    } catch (ClassNotFoundException | SQLException e) {
	        System.out.println("Database error: " + e.getMessage());
	    } finally {
	        if (rs != null) try { rs.close(); } catch (SQLException ignore) {}
	        if (stmt != null) try { stmt.close(); } catch (SQLException ignore) {}
	        if (conn != null) try { conn.close(); } catch (SQLException ignore) {}
	    }
	}
}
