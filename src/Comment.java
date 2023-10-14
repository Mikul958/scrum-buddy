package project;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;

public class Comment
{
    private Account user;
    private LocalDateTime dateTime;
    private String content;
    private ArrayList<Comment> replies;
    private DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");

    public Comment(Account user, String content)
    {
        //Date
        LocalDateTime now = LocalDateTime.now();
        this.dateTime = now;

        //User
        if(user.getIsVerified() == true){
            this.user = user;
        }
        else{
            this.user = null;
        }

        //Content
        if(content == null){
            this.content = "None.";
        }
        else{
            this.content = content;
        }
    }

    public String toString()
    {
        return "User: "+user+
        "\nDate: "+dateTime+
        "\nContent"+content;
    }
}
