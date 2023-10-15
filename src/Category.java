package src;

/**
 * @author Michael Pikula
 */
public enum Category
{
    BUSINESS("Business"),
    DEVELOPMENT("Development"),
    EDUCATION("Education"),
    PERSONAL("Personal"),
    OTHER("Miscellaneous");

    public final String description;

    private Category(String description)
    {
        this.description = description;
    }
}
