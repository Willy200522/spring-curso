# Spring-security
## 2.- Configuración:

Los archivos alojados en src/main/java/com/tgi/springSecurity/config
son la base para que spring pueda inicializarse 

Los decoradores de la clase App (
@Configuration,
@EnableWebMvc,
@ComponentScan(basePackages = "com.tgi.springSecurity")) sirven para indicarle a Spring que esta clase activará la configuración de Spring MVC's Java-based configuration, especificará qué paquetes debería escanear para los componentes de spring (como controller, etc.)

La clase que hereda de **AbstractAnnotationConfigDispatcherServletInitializer** simplifica la configuración de SpringMVC usando java-based configuration, permite registrar el DispatcherServlet y configurar el contexto de la aplicación sin usar XML

**InternalResourceViewResolver**
En Spring MVC las vistas se retornan como respuesta a las solicitudes; se puede devolver directamente el nombre del recurso físico
````
    @Controller
    public class MiControlador {
    @GetMapping("/inicio")
    public String mostrarInicio() {
        // Estás devolviendo la ubicación física exacta del archivo
        return "/WEB-INF/views/paginas/usuarios/index.jsp"; 
    }
}
````
pero esto haría un acoplamiento fuerte. Otra forma sería usar esta clase para asignar los nombres de vista lógica al recurso físico en un directorio preconfigurado. Agregaremos prefijos y sufijos al nombre de vista lógica para localizar el recurso físico correspondiente.

````
    @Bean
    public ViewResolver viewResolver(){
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();

        viewResolver.setPrefix("/WEB-INF/view/");

        viewResolver.setSuffix(".jsp");

        return viewResolver;
    }

````