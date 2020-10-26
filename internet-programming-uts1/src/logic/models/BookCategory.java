package logic.models;

public class BookCategory
{
    int _id;
    String _name;

    public int getId()
    {
        return _id;
    }

    public void setId(int id)
    {
        _id = id;
    }

    public String getName()
    {
        return _name;
    }

    public void setName(String name)
    {
        _name = name;
    }

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
            getId() == cat.getId() &&
            getName() == cat.getName();
    }
}
