import Util.PropertyLoader;
import com.mailosaur.MailosaurClient;
import com.mailosaur.MailosaurException;
import com.mailosaur.models.Message;
import com.mailosaur.models.MessageSearchParams;
import com.mailosaur.models.SearchCriteria;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.SortedMap;

public class MailosaurTesting {

    @Test
    public void testingMailosaur() throws MailosaurException, IOException {

        MailosaurClient mailosaur = new MailosaurClient(PropertyLoader.returnConfigValue("MailosaurAPI"));

        MessageSearchParams params = new MessageSearchParams();
        params.withServer(PropertyLoader.returnConfigValue("MailosaurServerId"));

        SearchCriteria criteria = new SearchCriteria();
        criteria.withSentTo("history-poetry@" + PropertyLoader.returnConfigValue("MailosaurServerDomain"));

        Message message = mailosaur.messages().get(params, criteria);

        System.out.println(message.subject());
        System.out.println(message.text().body());

    }

}
