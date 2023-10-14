package project;

public enum Category
{
    BUSINESS("Business"),
    DEVELOPMENT("Development"),
    EDUCATION("Education"),
    PERSONAL("Personal"),
    OTHER("Other");

    public final String description;

    private Category(String description)
    {
        this.description = description;
    }
}
