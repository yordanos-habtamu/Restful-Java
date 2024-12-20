package com.example;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.servlet.ServletContainer;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

public class App {
    public static void main(String[] args) throws Exception {
        // Create and start the embedded Jersey server (Jetty)
        Server server = new Server(8080);
        ServletContextHandler handler = new ServletContextHandler();
        handler.setContextPath("/");

        // Set up the Jersey application
        ResourceConfig config = new ResourceConfig();
        config.packages("com.example");  // Specify the package containing your JAX-RS resources

        // Create and configure the ServletHolder
        ServletHolder servletHolder = new ServletHolder(new ServletContainer(config));
        handler.addServlet(servletHolder, "/api/*");

        server.setHandler(handler);
        server.start();
        System.out.println("Server started at http://localhost:8080/");
        server.join();
    }
}

