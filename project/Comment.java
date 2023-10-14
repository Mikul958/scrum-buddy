package project;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;

public class Comment
{
    private Account user;
    private LocalDateTime dateTime;
    private String content;
    private ArrayList<Comment> replies;

    public Comment(Account user, LocalDateTime dateTime, String content)
    {
        this.user = user;
        this.dateTime = dateTime;
        this.content = content;
    }

    public String toString()
    {
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        return "User: "+user+"\n"+"DTG: "+format+"\n"+" Content: "+content;
    }
}
