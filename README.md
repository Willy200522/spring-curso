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
```java
    @Controller
    public class MiControlador {
    @GetMapping("/inicio")
    public String mostrarInicio() {
        // Estás devolviendo la ubicación física exacta del archivo
        return "/WEB-INF/views/paginas/usuarios/index.jsp"; 
    }
}
```
pero esto haría un acoplamiento fuerte. Otra forma sería usar esta clase para asignar los nombres de vista lógica al recurso físico en un directorio preconfigurado. Agregaremos prefijos y sufijos al nombre de vista lógica para localizar el recurso físico correspondiente.

````java
    @Bean
    public ViewResolver viewResolver(){
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();

        viewResolver.setPrefix("/WEB-INF/view/");

        viewResolver.setSuffix(".jsp");

        return viewResolver;
    }

````

## 3.- Add dependencies for security:

He agregado las dependencias que usa spring security 
[spring.security-web](https://mvnrepository.com/artifact/org.springframework.security/spring-security-web) &
[spring.security-config](https://mvnrepository.com/artifact/org.springframework.security/spring-security-config)
y además establecido como propiedades la versiones de estas que se usarán, se pueden establecer como variables estas versiones para tener todo compatible al compilar maven.


## 4.- Add login page

- Creación de la clase MyServletSecurityInitializer, que extiende de AbstractSecurityWebApplicationInitializer para habilitar automáticamente la infraestructura de seguridad en el proyecto.
  > Es necesario hacer esto porque Tomcat solo maneja el tráfico web a través de los Servlets. Si no especificamos el inicializador de este servlet, tomcat arranca sin saber que debe interceptar las peticiones HTTP y pasárselas a las reglas de tu SecurityAppConfig
- Se crea la clase SecurityAppConfig (ya no extiende de WebSecurityConfigurerAdapter, ya que a partir de la v5.^ de spring se considera deprecado, y se cambia por solo la clase SecurityFilterChain) y utilizando las anotaciones @Configuration y @EnableWebSecurity.
- También en la misma clase se sobrescribe el método configure para cargar usuarios en memoria (inMemoryAuthentication) con nombres, contraseñas y roles definidos manualmente.
