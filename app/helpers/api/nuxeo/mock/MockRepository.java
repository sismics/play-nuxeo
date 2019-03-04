package helpers.api.nuxeo.mock;

import com.sismics.sapparot.reflection.ReflectionUtil;
import org.nuxeo.client.objects.Document;
import org.nuxeo.client.objects.Repository;
import play.libs.Codec;

import java.util.HashMap;
import java.util.Map;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * @author jtremeaux
 */
public class MockRepository {
    public static Map<String, Document> documentByIdMap = new HashMap<>();

    public static Map<String, Document> documentByPathMap = new HashMap<>();

    /**
     * Create a mock of Repository.
     *
     * @return The mock
     */
    public static Repository create() {
        Repository repository = mock(Repository.class);

        when(repository.createDocumentByPath(any(String.class), any(Document.class))).thenAnswer(i -> {
            String path = i.getArgument(0);
            Document document = i.getArgument(1);
            ReflectionUtil.setFieldValue(document, "uid", Codec.UUID());
            ReflectionUtil.setFieldValue(document, "path", path);
            documentByIdMap.put(document.getId(), document);
            documentByPathMap.put(document.getPath() + "/" + document.getName(), document);
            return document;
        });

        when(repository.updateDocument(any(Document.class))).thenAnswer(i -> {
            Document document = i.getArgument(0);
            documentByIdMap.put(document.getId(), document);
            documentByPathMap.put(document.getPath(), document);
            return document;
        });

        when(repository.fetchDocumentById(any(String.class))).thenAnswer(i -> {
            String id = i.getArgument(0);
            return documentByIdMap.get(id);
        });

        when(repository.fetchDocumentByPath(any(String.class))).thenAnswer(i -> {
            String path = i.getArgument(0);
            return documentByPathMap.get(path);
        });

        return repository;
    }
}
