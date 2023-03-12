package javadeveloper.module11.migration;

import org.flywaydb.core.Flyway;

public class DatabaseMigrationService {
    public void migrate() {
        String connectionUrl = "jdbc:h2:./spacetravel";
        String user = "sa";
        Flyway flyway = Flyway
                .configure()
                .dataSource(connectionUrl, user, "")
                .load();
        flyway.migrate();
    }
}
