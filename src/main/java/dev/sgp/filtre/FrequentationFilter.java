package dev.sgp.filtre;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import dev.sgp.entite.VisiteWeb;
import dev.sgp.service.DepartementService;
import dev.sgp.service.StatsService;
import dev.sgp.util.Constantes;

public class FrequentationFilter implements Filter {
	
	private StatsService statsService = Constantes.STATS_SERVICE;
	

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
		
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		int before = (int) System.currentTimeMillis();
			
		chain.doFilter(request, response);
		
		int after = (int) System.currentTimeMillis();
		
		String path= ((HttpServletRequest) request).getRequestURI();

		
		statsService.sauvegarderVisiteWeb(new VisiteWeb(path,after-before));
		
	
		
	}

	@Override
	public void destroy() {
		
		// TODO Auto-generated method stub
		
	}

}
