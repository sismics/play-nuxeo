package helpers.api.nuxeo.mock;

import org.nuxeo.client.objects.Document;
import org.nuxeo.client.objects.Operation;
import play.libs.Codec;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * @author jtremeaux
 */
public class MockOperation {
    /**
     * Create a mock of Operation.
     *
     * @return The mock
     */
    public static Operation create() {
        Operation operation = mock(Operation.class);

        when(operation.input(any(Object.class))).thenAnswer(i -> operation);
        when(operation.param(any(String.class), any(Object.class))).thenAnswer(i -> operation);
        when(operation.voidOperation(any(boolean.class))).thenAnswer(i -> operation);
        when(operation.execute()).thenAnswer(i -> Document.createWithId(Codec.UUID(), "doc"));

        return operation;
    }
}
