package utilities;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Logs_Implementation {

    private Logs_Implementation() {
        // Prevent instantiation
    }

    /**
     * Retrieves a logger named after the class that is the logical caller in the current call stack.
     *
     * <p>This method uses the current thread's stack trace to determine the caller class name.
     * The stack trace array contains the sequence of method calls currently executing, where
     * the element at index 0 is the {@code getStackTrace()} method itself, index 1 is
     * {@code currentThread()}, index 2 is the method calling this logger retrieval method,
     * and index 3 is typically the immediate caller of that method.
     *
     * <p>In a layered test automation framework, where utility methods wrap WebElement actions
     * (e.g., {@code clickElement()} in a utility class) which are then called by action methods
     * (e.g., {@code click_Login_Button()} in an actions class), index 3 usually corresponds to
     * the action method that performed the business-level operation on the WebElement.
     *
     * <p>If the utility layer is deeper, the index can be adjusted (e.g., 4) to reach the actual
     * caller class representing the action in the test framework.
     *
     * <p>This technique helps dynamically name loggers according to the class performing the
     * action, enabling contextual logging that reflects the logical caller rather than
     * the utility implementation.
     *
     * @return Logger instance named after the caller class determined by the stack trace.
     */
    public static Logger logger()
    {
        return LogManager.getLogger(Thread.currentThread().getStackTrace()[4].getClassName());
    }


    /**
     * Logs an informational message at the INFO level.
     *
     * <p>This method accepts a variable number of string arguments,
     * joins them into a single string separated by spaces,
     * and sends the resulting message to the logger.</p>
     *
     * @param message the parts of the message to be logged,
     *                which will be concatenated with spaces in between
     *
     * <p>Example usage:</p>
     * <pre>
     * info("User", username, "logged in");
     * </pre>
     * This logs the message: "User john_doe logged in"
     */
    public static void info(String ...message)
    {
        logger().info(String.join(" ", message));
    }
}


