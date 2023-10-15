package src;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Edit
{
    private Account editor;
    private LocalDateTime dateTime;
    private String description;

    public Edit(Account editor, LocalDateTime date, String description)
    {

    }


    public Edit(Account editor, String description)
    {
        this.editor = editor;
        this.dateTime = LocalDateTime.now();
        this.description = description;
    }


    public String toString()
    {
        LocalDateTime local = LocalDateTime.now();
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

        return editor + "\n" + description + "\ntime stamp: " + local.format(format);
    }
}
