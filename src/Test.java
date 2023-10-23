package src;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Test
{
    public static void main(String[] args)
    {
        LocalDateTime dateTime = LocalDateTime.now();
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy/MM/dd 'at' HH:mm:ss");
        
        System.out.println(dateFormat.format(dateTime));
    }    
}
