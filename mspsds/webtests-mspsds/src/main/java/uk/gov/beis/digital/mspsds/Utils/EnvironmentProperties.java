package uk.gov.beis.digital.mspsds.Utils;

public class EnvironmentProperties {
    public static String getServiceUrl() {
        return String.format("https://%s:%s@%s",
            AppProperties.get("auth.username"),
            AppProperties.get("auth.password"),
            AppProperties.get("hostname")
        );
    }

    public static String getOpssUsername() {
        return AppProperties.get("account.opss.username");
    }

    public static String getOpssPassword() {
        return AppProperties.get("account.opss.password");
    }

    public static String getTradingStandardsUsername() {
        return AppProperties.get("account.ts.username");
    }

    public static String getTradingStandardsPassword() {
        return AppProperties.get("account.ts.password");
    }
}
