package src;

/**
 * An enumeration containing all categories that a project can select.
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

    /**
     * @param description
     */
    private Category(String description)
    {
        this.description = description;
    }

    public String toString()
    {
        return description;
    }
}
