package br.com.fornax.fundos.config.web;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.UrlBasedViewResolver;
import org.springframework.web.servlet.view.tiles2.TilesConfigurer;

@Configuration
@EnableWebMvc
@ComponentScan(value = { "br.com.fornax.fundos" })
public class WebSpringConfig extends WebMvcConfigurerAdapter {

	@Override
	// Carrega as configurações default do Spring
	public void configureDefaultServletHandling(
			DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}
	
	@Bean
	// Resolve as requisições de chamadas de páginas jsp, xhtml, html...
	// Utilizando tiles
	public ViewResolver configureViewResolver(){
		UrlBasedViewResolver viewResolver = new UrlBasedViewResolver();
		viewResolver.setViewClass(org.springframework.web.servlet.view.tiles2.TilesView.class);
		return viewResolver;
	}

	@Bean
	// Inicializa a configuração do tiles para a criação de templates
	public TilesConfigurer tilesConfigurer(){
		TilesConfigurer tilesConfigurer = new TilesConfigurer();
		tilesConfigurer.setDefinitions("/tiles/tiles-config.xml");
		return tilesConfigurer;
	}
}