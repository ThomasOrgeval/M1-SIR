package rs;

import io.swagger.v3.jaxrs2.integration.resources.OpenApiResource;
import rs.rest.PetResource;
import rs.rest.SwaggerResource;
import rs.rest.UserResource;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

@ApplicationPath("/")
public class TestApplication extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        final Set<Class<?>> clazzes = new HashSet<>();
        clazzes.add(OpenApiResource.class);
        clazzes.add(PetResource.class);
        clazzes.add(UserResource.class);
        clazzes.add(SwaggerResource.class);
        return clazzes;
    }
}
