package helpers.api.nuxeo.util;

import org.nuxeo.client.NuxeoClient;
import play.Play;

/**
 * @author jtremeaux
 */
public class NuxeoUtil {
    /**
     * Create a new Nuxeo client from Play! parameters.
     *
     * @return New Nuxeo client
     */
    public static NuxeoClient createNuxeoClient() {
        return new NuxeoClient.Builder()
                .url(getNuxeoUrl())
                .authentication(getNuxeoUsername(), getNuxeoPassword())
                .connect();
    }

    private static String getNuxeoUrl() {
        return Play.configuration.getProperty("nuxeo.url");
    }

    private static String getNuxeoUsername() {
        return Play.configuration.getProperty("nuxeo.username");
    }

    private static String getNuxeoPassword() {
        return Play.configuration.getProperty("nuxeo.password");
    }

    public static boolean isMock() {
        return Boolean.parseBoolean(Play.configuration.getProperty("nuxeo.mock", "false"));
    }
}
