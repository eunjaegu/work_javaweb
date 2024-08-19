package servlets.member;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import dao.member.MemJoinDAO;
import model.mall.AddressVO;

/**
 * Servlet implementation class AddressServlet
 */
@WebServlet("/findAddress")
public class AddressServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	
    public AddressServlet() {
        super();
    }

	/**
	 * @see 주소 찾기
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/plain; charset=utf-8");
		List<AddressVO> addrList = null;
		MemJoinDAO memJoinDAO = new MemJoinDAO();
		PrintWriter out = response.getWriter();
		
		String addr = request.getParameter("addr");
		String jsonAddr = null;
		addrList = memJoinDAO.address(addr);
		
		JSONObject totalObject = new JSONObject();
		JSONArray addrArray = new JSONArray();
		JSONObject addrObject = new JSONObject();
		if(addrList.size() >= 1) {
			for (AddressVO address : addrList) {
				addrObject.put("zipcode", address.getZipcode());
				addrObject.put("area1", address.getArea1());
				addrObject.put("area2", address.getArea2());
				addrObject.put("area3", address.getArea3());
				addrArray.add(addrObject);
				addrObject = new JSONObject();
			}
			totalObject.put("addrList", addrArray);
			jsonAddr = totalObject.toJSONString();
		} else
			jsonAddr = "noData";

		out.print(jsonAddr);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
