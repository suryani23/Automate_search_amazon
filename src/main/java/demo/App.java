/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package demo;
import java.net.MalformedURLException;


public class App {
    public void getGreeting() throws InterruptedException, MalformedURLException {
        //TestCases tests = new TestCases(); // Initialize your test class
        //Automate_search_amazon asa = new Automate_search_amazon();
        Automate_count_hyperlinks ach = new Automate_count_hyperlinks();

        //TODO: call your test case functions one after other here

        //tests.testCase01();
        //asa.AmazonSearch();
        ach.hyperlinksCount();

        //END Tests


        //tests.endTest(); // End your test by clearning connections and closing browser
        //asa.endTest();
        ach.endTest();
    }

    public static void main(String[] args) throws InterruptedException, MalformedURLException {
        new App().getGreeting();
    }
}
