package helpers.api.nuxeo.mock;

import org.nuxeo.client.NuxeoClient;
import org.nuxeo.client.objects.Repository;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * @author jtremeaux
 */
public class MockNuxeoClient {
    public static Repository repository = MockRepository.create();

    /**
     * Create a mock of NuxeoClient.
     *
     * @return The mock
     */
    public static NuxeoClient create() {
        NuxeoClient nuxeoClient = mock(NuxeoClient.class);

        when(nuxeoClient.repository()).thenAnswer(i -> repository);
        when(nuxeoClient.operation(any(String.class))).thenAnswer(i -> MockOperation.create());

        return nuxeoClient;
    }
}
