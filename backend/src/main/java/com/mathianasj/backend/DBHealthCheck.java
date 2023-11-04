package com.mathianasj.backend;
import org.eclipse.microprofile.health.HealthCheck;
import org.eclipse.microprofile.health.HealthCheckResponse;
import org.eclipse.microprofile.health.Readiness;
import java.sql.*;
import org.jboss.logging.Logger;

import jakarta.enterprise.context.ApplicationScoped;

@Readiness
@ApplicationScoped
public class DBHealthCheck implements HealthCheck {
    private static final Logger LOG = Logger.getLogger(DBHealthCheck.class);

    @Override
    public HealthCheckResponse call() {
        String url = "jdbc:postgresql://postgresql/sampledb?user=user&password=secret&ssl=false";
        Connection conn = null;
        Statement st = null;
        try {
            conn = DriverManager.getConnection(url);
            st = conn.createStatement();
        } catch(Exception ex) {
            LOG.error(ex);
            return HealthCheckResponse.down("Database connection health check"); 
        } finally {
            if (st != null) {
                try {
                    st.close();
                } catch(Exception ex) {}
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch(Exception ex) {}
            }
        }

        return HealthCheckResponse.up("Database connection health check");
    }
}
