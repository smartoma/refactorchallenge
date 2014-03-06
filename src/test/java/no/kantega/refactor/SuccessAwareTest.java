package no.kantega.refactor;

import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import org.junit.Rule;
import org.junit.rules.TestRule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

import static java.lang.Boolean.TRUE;
import static java.nio.charset.StandardCharsets.UTF_8;
import static java.nio.file.Files.readAllLines;

public abstract class SuccessAwareTest {

    private boolean isReady;

    private Firebase fb = new Firebase("https://refactorchallenge.firebaseio.com/test/");

    @Rule
    public TestRule rule = new TestWatcher() {

        @Override
        protected void succeeded(final Description description) {
            sendData(fb, description);
            waitUntilReady();
        }

        @Override
        protected void finished(Description description) {
        }
    };

    private void sendData(Firebase fb, Description description) {
        String usernameAndId = readUsernameAndId();
        Map<String, Object> toSet = new HashMap<String, Object>();
        toSet.put("test", description.getClassName());
        toSet.put("id", usernameAndId.split(":")[1]);
        toSet.put("name", usernameAndId.split(":")[0]);
        fb.push().setValue(toSet, notifyCompletion());
    }

    private Firebase.CompletionListener notifyCompletion() {
        return new Firebase.CompletionListener() {
            @Override
            public void onComplete(FirebaseError firebaseError, Firebase firebase) {
                isReady = TRUE;
            }
        };
    }

    private void waitUntilReady() {
        while (!isReady) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private String readUsernameAndId()  {
        try {
            return readAllLines(getFilePath(), UTF_8).get(0);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }



    private Path getFilePath() {
        try {
            return Paths.get(ClassLoader.class.getResource("/.user").toURI());
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return null;
    }

}
