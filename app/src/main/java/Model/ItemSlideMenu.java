package Model;

/**
 * Created by yasmeen on 3/8/2016.
 */
public class ItemSlideMenu {
    private int id_image;
    private String title;

    public ItemSlideMenu(int id_image, String title) {
        this.id_image = id_image;
        this.title = title;
    }

    public int getId_image() {
        return id_image;
    }

    public void setId_image(int id_image) {
        this.id_image = id_image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
