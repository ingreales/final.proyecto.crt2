package controllers;


import mapping.dto.ProductoDto;
import services.LoginService;
import services.LoginServiceSessionImpl;
import services.ProductoService;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@WebServlet({"/productos.html", "/productos"})
public class ProductoServlet extends HttpServlet {

    @Inject
    private ProductoService service;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        List<ProductoDto> productos = service.listar();

        LoginService auth = new LoginServiceSessionImpl();
        Optional<String> usernameOptional = auth.getUsername(req);

        req.setAttribute("productos",productos);
        req.setAttribute("usurios",usernameOptional);
        req.setAttribute("titulo",req.getAttribute("titulo") + ": Listado de productos");
        getServletContext().getRequestDispatcher("/listar.jsp").forward(req,resp);
    }
}