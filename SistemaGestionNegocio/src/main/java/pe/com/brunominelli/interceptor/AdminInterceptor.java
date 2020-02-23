package pe.com.brunominelli.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import pe.com.brunominelli.dto.PerfilTO;
import pe.com.brunominelli.util.Constantes;

public class AdminInterceptor extends HandlerInterceptorAdapter {

    @Autowired
    private HttpSession session;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        /* vemos si viene del login, para no ocasionar bucle infinito */
        if (!request.getRequestURI().equals("/SistemaGestionNegocio/")
                && !request.getRequestURI().equals("/SistemaGestionNegocio/login")) {
            session = request.getSession();
            /* Obtenemos el perfil */
            PerfilTO perfil = (PerfilTO) session.getAttribute("perfil");
            String codigoPerfil = perfil.getCodigoPerfil();

            /* Si viene de las urls del adm pero no es adm */
            if(!codigoPerfil.equals(Constantes.PERFIL_ENCARGADO_ADM) && (request.getRequestURI().equals("/SistemaGestionNegocio/admin/listaEmpleados")
                    || request.getRequestURI().equals("/SistemaGestionNegocio/admin/nuevoEmpleado")
                    || request.getRequestURI().equals("/SistemaGestionNegocio/admin/listaPoliticas"))){
                
                switch(codigoPerfil){
                    case Constantes.PERFIL_ENCARGADO_INV:
                        response.sendRedirect("/SistemaGestionNegocio/inventario/listaProductos");
                        return false;
                    default:
                        response.sendRedirect("/SistemaGestionNegocio/");
                        return false;
                }
                
            }
        }

        return true;
    }

}
