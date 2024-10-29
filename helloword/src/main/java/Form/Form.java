package Form;

import jakarta.servlet.ServletException;
import java.util.regex.*;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.ParseException;
import User.User;
import exceptions.ResourceNotFoundException;
/**
 * Servlet implementation class Form
 */
public class Form extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Form() {
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
		String password = request.getParameter("password");
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
		String maxConnections = getServletContext().getInitParameter("maxConnections");
		String[] KoT = request.getParameterValues("Type");
		
		 if (name == null || name.isEmpty() || email == null || email.isEmpty() || password == null || password.isEmpty() || locate == null || locate.isEmpty() || phone == null || phone.isEmpty()) {
	            // Ném ngoại lệ tùy chỉnh nếu tài nguyên không tồn tại
	            throw new ResourceNotFoundException("No source found");
	        }
		 
		User user = new User();
		user.setEmail(email);
		user.setName(name);
		user.setLocate(locate);
		user.setSex(sex);
		user.setPhone(phone);
		user.setKoT(KoT);
		try 
		{
		        Date birthDate = dateFormat.parse(birthday);
		        user.setBoD(birthDate);
		        System.out.println("Ngày sinh: " + birthDate);
		}
		catch (ParseException e) 
		{
		        e.printStackTrace();
		}
		System.out.println(user.getEmail());
		System.out.println(user.getName());
		System.out.println(user.getLocate());
		System.out.println(user.getPhone());
		if(user.isSex()) System.out.println("Nữ");
		else System.out.println("Nam");
		for(String type: user.getKoT())
		{
			System.out.println(type);
		}
		
		 if (matcher.matches()) {
             System.out.println(phone + " là số điện thoại hợp lệ.");
         } else {
             System.out.println(phone + " không hợp lệ.");
         }
		 
		String url="";
		System.out.println(edit);
		if(edit==null || !edit.equals("isEdit"))
		{
			url="/OrderConfirm.jsp";
		}
		else url="/EditInfo.jsp";
		System.out.println(maxConnections);
		request.setAttribute("user", user);
		getServletContext().getRequestDispatcher(url).forward(request,response);
	}

}
