package diary.common;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class DoFillter
 */
public class DoFillter implements Filter {

    @Override
    public void destroy() {
        // TODO Auto-generated method stub
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse res,
            FilterChain chain) throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) req;
        HttpSession session = request.getSession(true);
        // kiểm tra xem đã tồn tài session username hay chưa
        String userName = (String) session.getAttribute("Admin");

        if (userName == null) {
            String url = request.getRequestURI();
            url.toLowerCase();
            HttpServletResponse response = (HttpServletResponse) res;
            // nếu url có chứa chuỗi admin thì chuyển đến trang login.jsp
            if (url.contains("admin")) {
                response.sendRedirect("login.jsp");
                return;
            }
        }
        chain.doFilter(req, res);
    }

    @Override
    public void init(FilterConfig arg0) throws ServletException {
        // TODO Auto-generated method stub
    }
}
