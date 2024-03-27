import Util.PropertyLoader;
import com.mailosaur.MailosaurClient;
import com.mailosaur.MailosaurException;
import com.mailosaur.models.Message;
import com.mailosaur.models.MessageSearchParams;
import com.mailosaur.models.SearchCriteria;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;

public class MailosaurTesting {

    @Test
    public void testingMailosaur() throws MailosaurException, IOException {

        MailosaurClient mailosaur = new MailosaurClient(PropertyLoader.returnConfigValue("MailosaurAPI"));

        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MINUTE, -525960);
        Date pastDate = calendar.getTime();
        //This is done to fetch all the emails for past 1 year (In minutes), as Date type does not work well

        MessageSearchParams params = new MessageSearchParams();
        params.withServer(PropertyLoader.returnConfigValue("MailosaurServerId")).withReceivedAfter(pastDate);

        SearchCriteria criteria = new SearchCriteria();
        criteria.withSentTo("history-poetry@" + PropertyLoader.returnConfigValue("MailosaurServerDomain"));

        Message message = mailosaur.messages().get(params, criteria);


        System.out.println(message.received() + "  +00:00 UTC");
        System.out.println("From: " + message.from().get(0).email());
        System.out.println("To: " + message.to().get(0).email());
        System.out.println(message.subject());
        System.out.println(message.text().body());
        String HTMLBody = message.html().body();

        Document doc = Jsoup.parse(HTMLBody);
        Elements elements = doc.getElementsByAttribute("dir");
        System.out.println("The body was extracted from HTML \n" + elements.get(0).text());

        System.out.println(message.html().body());

    }

}
