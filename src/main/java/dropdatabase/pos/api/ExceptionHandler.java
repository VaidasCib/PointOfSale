package dropdatabase.pos.api;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
import java.util.logging.Level;
import java.util.logging.Logger;

@Provider
public class ExceptionHandler implements ExceptionMapper<Exception> {
    @Override
    public Response toResponse(Exception ex) {
        Logger logger = Logger.getAnonymousLogger();
        logger.log(Level.SEVERE, "Api Exception: ", ex);
        if (ex instanceof IllegalArgumentException) {
            return Response.status(400).entity(ex.getMessage()).build();
        }
        return Response.status(500).entity(ex.getMessage()).build();
    }
}