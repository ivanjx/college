package logic.models;

public class BookCategory
{
    public int id;
    public String name;

    @Override
    public boolean equals(Object obj)
    {
        if (obj == this)
        {
            return true;
        }

        if(!(obj instanceof BookCategory))
        {
            return false;
        }

        BookCategory cat = (BookCategory)obj;

        return 
            id == cat.id &&
            name == cat.name;
    }
}
