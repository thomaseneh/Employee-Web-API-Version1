package Phase1;

import java.io.IOException;
import java.io.InputStream;
import java.util.Set;

import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/employee/api")
public class employeeServlet extends HttpServlet{

	EmployeeDAO dao = new EmployeeDAO();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Set<EmployeePojo> servletOut = dao.findAll();
		// convert it json object
		String json = new ObjectMapper().writeValueAsString(servletOut);
		
		resp.getWriter().print(json);
		resp.setContentType("application/json");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// Request user input
		InputStream servletIn = req.getInputStream();
		
		EmployeePojo servletData = new ObjectMapper().readValue(servletIn, EmployeePojo.class);
		
		EmployeePojo updatedServletData = dao.create(servletData);
		
		String updatedJson = new ObjectMapper().writeValueAsString(updatedServletData);
		resp.getWriter().print(updatedJson);
		
		resp.getWriter().print(new ObjectMapper().writeValueAsString(updatedJson));
		
		resp.setStatus(201);
		resp.setContentType("application/json");
	}
}
