package controllers;



import java.io.IOException;

@WebServlet("/ver-carro")
public class VerCarroServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("title",req.getAttribute("title") + ": Carro de compras");
        getServletContext().getRequestDispatcher("/carro.jsp").forward(req, resp);
    }
}