package org.opendatakit.thin;

import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

import java.io.IOException;
import java.net.URI;

public class Application {
    private static final String DEFAULT_BASE_URL = "http://localhost:8080/";

    // Base URL on which the Grizzly server will listen.
    private static String baseUrl() {
        String url = System.getenv("BASE_URL");
        if (url == null)
            url = DEFAULT_BASE_URL;
        return url;
    }

    private static HttpServer startServer() {
        URI uri = URI.create(baseUrl());
        String packageName = Application.class.getPackage().getName();
        ResourceConfig config = new ResourceConfig().packages(packageName);
        return GrizzlyHttpServerFactory.createHttpServer(uri, config);
    }

    public static void waitForKeyPress() {
        try {
            System.in.read();
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        HttpServer server = startServer();
        System.out.printf(
            "Jersey app started with WADL available at %sapplication.wadl.%n" +
            "Press any key to stop it...%n", baseUrl()
        );
        waitForKeyPress();
        server.stop();
    }
}
