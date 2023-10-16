package src;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Edit
{
    private LocalDateTime dateTime;
    private Account editor;
    private String description;
    private DateTimeFormatter dateFormat;

    public Edit(Account editor, String description)
    {
        this.dateTime = LocalDateTime.now();
        this.editor = editor;
        this.description = description;
        this.dateFormat = DateTimeFormatter.ofPattern("yyyy/MM/dd 'at' HH:mm:ss");

    }
    public Edit(LocalDateTime dateTime, Account editor, String description)
    {
        this.dateTime = dateTime;
        this.editor = editor;
        this.description = description;
        this.dateFormat = DateTimeFormatter.ofPattern("yyyy/MM/dd 'at' HH:mm:ss");
    }

    public String toString()
    {
        return "Edit on " + dateFormat.format(dateTime) + " by " + editor + ":\n" + description;
    }
}
