package helpers.api.nuxeo;

import helpers.api.nuxeo.mock.MockNuxeoClient;
import helpers.api.nuxeo.util.NuxeoUtil;
import org.nuxeo.client.NuxeoClient;

/**
 * @author jtremeaux
 */
public class NuxeoApi {
    private static NuxeoApi nuxeoApi;

    public static NuxeoApi get() {
        if (nuxeoApi == null) {
            nuxeoApi = new NuxeoApi();
        }
        return nuxeoApi;
    }

    public NuxeoApi() {
    }

    public NuxeoClient getNuxeoClient() {
        if (NuxeoUtil.isMock()) {
            return MockNuxeoClient.create();
        } else {
            return NuxeoUtil.createNuxeoClient();
        }
    }
}
