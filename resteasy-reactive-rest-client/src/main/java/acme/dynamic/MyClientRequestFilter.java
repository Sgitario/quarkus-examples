package acme.dynamic;

import java.net.URI;

import jakarta.ws.rs.client.ClientRequestContext;
import jakarta.ws.rs.client.ClientRequestFilter;

public class MyClientRequestFilter implements ClientRequestFilter {

    private static final String HEADER = "abs";

    @Override
    public void filter(ClientRequestContext requestContext) {
        String uri = requestContext.getHeaderString(HEADER);
        if (uri != null) {
            requestContext.setUri(URI.create(requestContext.getUri() + uri));
            requestContext.getHeaders().remove(HEADER);
        }
    }
}
