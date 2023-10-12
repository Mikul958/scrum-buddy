package src;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;

/**
 * @author Al Pacicco
 */
public class Comment
{
    private Account user;
    private LocalDateTime dateTime;
    private String content;
    private ArrayList<Comment> replies;

    public Comment(Account user, Calendar date, String content)
    {

    }

    public String toString()
    {
        return null;
    }
}
