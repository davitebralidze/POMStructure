public class GetAndNavigateExplanation {
    /*
Navigating
The first thing you’ll want to do with WebDriver is navigate to a page. The normal way to do this is by calling get:

driver.get("http://www.google.com");
WebDriver will wait until the page has fully loaded (that is, the onload event has fired) before returning control to your test or script. It’s worth noting that if your page uses a lot of AJAX on load then WebDriver may not know when it has completely loaded. If you need to ensure such pages are fully loaded then you can use waits.

Navigation: History and Location
Earlier, we covered navigating to a page using the get command (driver.get("http://www.example.com")) As you’ve seen, WebDriver has a number of smaller, task-focused interfaces, and navigation is a useful task. Because loading a page is such a fundamental requirement, the method to do this lives on the main WebDriver interface, but it’s simply a synonym to:

driver.navigate().to("http://www.example.com");
To reiterate: navigate().to() and get() do exactly the same thing. One's just a lot easier to type than the other!

The navigate interface also exposes the ability to move backwards and forwards in your browser’s history:

driver.navigate().forward();
driver.navigate().back();

The difference between these two methods comes not from their behavior, but from the behavior in the way the application works and how browser deal with it.

navigate().to() navigates to the page by changing the URL like doing forward/backward navigation.

Whereas, get() refreshes the page to changing the URL.

So, in cases where application domain changes, both the method behaves similarly. That is, page is refreshed in both the cases. But, in single-page applications, while navigate().to() do not refreshes the page, get() do.

Moreover, this is the reason browser history is getting lost when get() is used due to application being refreshed.

 */
}
