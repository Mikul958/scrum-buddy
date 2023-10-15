package src;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;

/**
 * @author Miles Wedeking, Michael Pikula
 */
public class Comment
{
    private LocalDateTime dateTime;
    private Account user;
    private String content;
    private ArrayList<Comment> replies;
    private DateTimeFormatter dtf;  // I don't know how to use this, is it one-time use?

    public Comment(Account user, String content)
    {
        this.dateTime = LocalDateTime.now();  // Set date to time of construction.
        this.user = user;
        this.content = content;
        this.replies = new ArrayList<Comment>();
        this.dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
    }

    public String toString()
    {
        String out = "User: ";

        if (user != null)
            out += user;
        else
            out += "anonymous";

        out += "\nDate: " + dateTime + "\nContent: " + content;
        return out;
    }
    public void addReply(Account user, String content)
    {
        Comment newReply = new Comment(user, content);
        replies.add(newReply);
    }
    public void deleteReply(Comment reply)
    {
        replies.remove(reply);
    }
}
