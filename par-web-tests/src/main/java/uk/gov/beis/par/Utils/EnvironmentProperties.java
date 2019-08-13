package uk.gov.beis.par.Utils;

public class EnvironmentProperties {
    public static String getServiceUrl() {
        return String.format("https://%s:%s@%s",
            AppProperties.get("auth.username"),
            AppProperties.get("auth.password"),
            AppProperties.get("hostname")
        );
    }

    public static String getResponsiblePersonUsername() {
        return AppProperties.get("account.rp.username");
    }

    public static String getResponsiblePersonPassword() {
        return AppProperties.get("account.rp.password");
    }

    public static String getPoisonCentreUsername() {
        return AppProperties.get("account.npis.username");
    }

    public static String getPoisonCentrePassword() {
        return AppProperties.get("account.npis.password");
    }
}
