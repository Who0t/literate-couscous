package fi.taktik.app;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String genre;
    private String name;
    private String description;
    private double price;
    private double discountPrice;
    private String publisher;
    private String developer;
    //private List<String> platforms;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getDiscountPrice() {
        return discountPrice;
    }

    public void setDiscountPrice(double discountPrice) {
        this.discountPrice = discountPrice;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getDeveloper() {
        return developer;
    }

    public void setDeveloper(String developer) {
        this.developer = developer;
    }
/*
    public List<String> getPlatforms() {
        return platforms;
    }

    public void setPlatforms(List<String> platforms) {
        this.platforms = platforms;
    }
*/
    public Item() {
        //platforms = new ArrayList<String>();
    }

    public Item(String name) {
        //platforms = new ArrayList<String>();
        this.name = name;
    }
/*
    public void addPlatform(String platform) {
        platforms.add(platform);
    }

    public double getDiscountPercentage() {
        return 1-(discountPrice/price);
    }
*/
    public void copyItem(Item item) {

        this.genre = item.getGenre();
        this.name = item.getName();
        this.description = item.getDescription();
        this.price = item.getPrice();
        this.discountPrice = item.getDiscountPrice();
        this.publisher = item.getPublisher();
        this.developer = item.getDeveloper();
        //this.platforms = item.getPlatforms();
    }
}
