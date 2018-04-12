package icisacultive.devweb.projet.filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

@WebFilter(filterName = "EncodingFilter")
public class EncodingFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        request.setCharacterEncoding(StandardCharsets.UTF_8.displayName());
        response.setCharacterEncoding(StandardCharsets.UTF_8.displayName());
        response.setContentType("text/html;charset=UTF-8");
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}

