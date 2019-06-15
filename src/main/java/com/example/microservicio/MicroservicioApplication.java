package com.example.microservicio;

import com.reto.bd.Cliente;
import com.reto.bd.ClienteRepositorio;
import io.swagger.annotations.Api;
import java.sql.SQLException;
import java.util.List;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@RestController
@EnableSwagger2
public class MicroservicioApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroservicioApplication.class, args);
	}
        
        @RequestMapping(value ="main", method = RequestMethod.GET)
        public String saludar(){
            return "Hola Mundo";
        }
        
        @RequestMapping(value ="ListCliente", method = RequestMethod.GET)
        public List<Cliente>  listarclientes() throws SQLException{
            
            return ClienteRepositorio.listarclientes();
        }

        @RequestMapping(value ="kpideclientes", method = RequestMethod.GET)
        public String  kpiclientes() throws SQLException{
            
            return ClienteRepositorio.kpiclientes();
        }        
        
        @RequestMapping(value = "/creacliente", method = RequestMethod.POST)
        public String  crearclientes(@RequestBody Cliente cliente) throws SQLException{
            ClienteRepositorio.Grabar(cliente);
            return "ok";
        }
        

}
