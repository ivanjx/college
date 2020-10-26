package logic.models;

public class Book 
{
    int _id;
    int _catId;
    String _title;
    String _writer;
    Double _price;
    String _imgPath;

    public int getId()
    {
        return _id;
    }

    public void setId(int id)
    {
        _id = id;
    }

    public int getCatId()
    {
        return _catId;
    }

    public void setCatId(int catId)
    {
        _catId = catId;
    } 

    public String getTitle()
    {
        return _title;
    }

    public void setTitle(String title)
    {
        _title = title;
    }

    public String getWriter()
    {
        return _writer;
    }

    public void setWriter(String writer)
    {
        _writer = writer;
    }

    public Double getPrice()
    {
        return _price;
    }

    public void setPrice(Double price)
    {
        _price = price;
    }

    public String getImgPath()
    {
        return _imgPath;
    }

    public void setImgPath(String imgPath)
    {
        _imgPath = imgPath;
    }

    @Override
    public boolean equals(Object obj)
    {
        if (obj == this)
        {
            return true;
        }

        if (!(obj instanceof Book))
        {
            return false;
        }

        Book book = (Book)obj;

        return
            getId() == book.getId() &&
            getCatId() == book.getCatId() &&
            getTitle() == book.getTitle() &&
            getWriter() == book.getWriter() &&
            getPrice() == book.getPrice() &&
            getImgPath() == book.getImgPath();
    }
}
