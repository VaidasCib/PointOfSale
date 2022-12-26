package dropdatabase.pos.api;

import io.swagger.jaxrs.config.BeanConfig;

import javax.servlet.ServletConfig;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.Context;

@ApplicationPath("/api")
public class RestApplication extends Application {
    public RestApplication(@Context ServletConfig servletConfig) {
        super();
        BeanConfig beanConfig = new BeanConfig();
        beanConfig.setVersion("1.0.0");
        beanConfig.setTitle("Point of Sale API");
        beanConfig.setBasePath("/pos-1.0.0/api");
        beanConfig.setResourcePackage("dropdatabase.pos");
        beanConfig.setScan(true);
    }
}