import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/gugu_servlet/gugu.do")
public class GuguController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int dan = Integer.parseInt(request.getParameter("dan"));
		String result = "";
		for(int i=1; i<10; i++){
			result += dan + " X " + i + " = " + dan*i + "<br>";
		}
		request.setAttribute("result", result);
		// requestDispatcher : 현재 request에 담고 있는 정보를 저장하고 있다가 
		//					   다음페이지, 그 다음페이지에서도 해당 정보를 볼 수 있게 저장하는 기능을 함
		RequestDispatcher rd = request.getRequestDispatcher("/exam/guguResult2.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
