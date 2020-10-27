package logic.models;

public class Book 
{
    public int id;
    public int catId;
    public String title;
    public String writer;
    public Double price;
    public String imgPath;

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
            id == book.id &&
            catId == book.catId &&
            title == book.title &&
            writer == book.writer &&
            price == book.price &&
            imgPath == book.imgPath;
    }
}
