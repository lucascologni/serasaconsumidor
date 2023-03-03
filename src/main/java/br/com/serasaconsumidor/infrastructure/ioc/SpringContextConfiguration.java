package br.com.serasaconsumidor.infrastructure.ioc;

import org.springframework.context.annotation.ComponentScan;

/**
 * Essa classe é responsável por dizer ao Container IoC do Spring para escanear todos os pacotes configurados
 * para instanciar, configurar e montar objetos conhecidos como beans (@Component, @Configuration, @Bean...)
 */
@ComponentScan(basePackages = "br.com.serasaconsumidor")
public class SpringContextConfiguration { }