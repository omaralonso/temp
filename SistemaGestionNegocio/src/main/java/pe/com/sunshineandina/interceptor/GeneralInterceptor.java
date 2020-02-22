/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.sunshineandina.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 *
 * @author FERNANDO
 */
public class GeneralInterceptor extends HandlerInterceptorAdapter {

    @Autowired
    private HttpSession session;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (!request.getRequestURI().equals("/SistemaGestionNegocio/")
                && !request.getRequestURI().equals("/SistemaGestionNegocio/login")) {
            session = request.getSession();
            if (session.getAttribute("usuario") == null || session.getAttribute("perfil") == null) {
                response.sendRedirect("/SistemaGestionNegocio/");
                return false;
            }

        }
        return true;
    }

}
