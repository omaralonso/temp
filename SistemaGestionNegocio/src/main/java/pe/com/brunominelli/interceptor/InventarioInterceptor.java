package pe.com.brunominelli.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import pe.com.brunominelli.dto.PerfilTO;
import pe.com.brunominelli.util.Constantes;

public class InventarioInterceptor extends HandlerInterceptorAdapter {

    @Autowired
    private HttpSession session;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (!request.getRequestURI().equals("/SistemaGestionNegocio/")
                && !request.getRequestURI().equals("/SistemaGestionNegocio/login")) {
            session = request.getSession();
            
            /* Obtenemos el codigo de perfil */
            PerfilTO perfil = (PerfilTO)session.getAttribute("perfil");
            String codigoPerfil = perfil.getCodigoPerfil();
            
            /* Verificamos si tiene perfil de inv*/
            if(!codigoPerfil.equals(Constantes.PERFIL_ENCARGADO_INV) && (
                    request.getRequestURI().matches("/SistemaGestionNegocio/inventario/listaCategorias.*") ||
                    request.getRequestURI().matches("/SistemaGestionNegocio/inventario/listaProductos.*")) ){
                switch(codigoPerfil){
                    default:
                        response.sendRedirect("/SistemaGestionNegocio/");
                        return false;
                }
            }
        }
        return true;
    }

}
