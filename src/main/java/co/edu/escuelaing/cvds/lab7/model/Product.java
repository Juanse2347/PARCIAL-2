package co.edu.escuelaing.cvds.lab7.model;
import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "Product")
public class Product {
    @Id
    @Column(name = "ID")
    private Long ID;
    @Column(name = "NAME")
    private String NAME;
    @Column(name = "DESCRIPTION")
    private String DESCRIPTION;
    @Column(name = "CATEGORY")
    private String CATEGORY;
    @Column(name = "RATING")
    private String RATING;
    @Column(name = "PRICE")
    private String PRICE;
    @Column(name = "QUANTITY")
    private String QUANTITY;

    public Product() {

    }
    public Product(Long ID, String NAME, String DESCRIPTION, String CATEGORY, String RATING, String PRICE, String QUANTITY) {
        this.ID = ID;
        this.NAME = NAME;
        this.DESCRIPTION = DESCRIPTION;
        this.CATEGORY = CATEGORY;
        this.RATING = RATING;
        this.PRICE = PRICE;
        this.QUANTITY = QUANTITY;
    }

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public String getNAME() {
        return NAME;
    }

    public void setNAME(String NAME) {
        this.NAME = NAME;
    }

    public String getDESCRIPTION() {
        return DESCRIPTION;
    }

    public void setDESCRIPTION(String DESCRIPTION) {
        this.DESCRIPTION = DESCRIPTION;
    }

    public String getCATEGORY() {
        return CATEGORY;
    }

    public void setCATEGORY(String CATEGORY) {
        this.CATEGORY = CATEGORY;
    }

    public String getRATING() {
        return RATING;
    }

    public void setRATING(String RATING) {
        this.RATING = RATING;
    }

    public String getPRICE() {
        return PRICE;
    }

    public void setPRICE(String PRICE) {
        this.PRICE = PRICE;
    }

    public String getQUANTITY() {
        return QUANTITY;
    }

    public void setQUANTITY(String QUANTITY) {
        this.QUANTITY = QUANTITY;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(ID, product.ID) && Objects.equals(NAME, product.NAME) && Objects.equals(DESCRIPTION, product.DESCRIPTION) && Objects.equals(CATEGORY, product.CATEGORY) && Objects.equals(RATING, product.RATING) && Objects.equals(PRICE, product.PRICE) && Objects.equals(QUANTITY, product.QUANTITY);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ID, NAME,DESCRIPTION,CATEGORY,RATING,PRICE,QUANTITY);
    }

    @Override
    public String toString() {
        return "Product{" +
                "ID ='" + ID + '\'' +
                ", NAME ='" + NAME + '\'' +
                ", DESCRIPTION ='" + DESCRIPTION + '\'' +
                ", CATEGORY ='" + CATEGORY + '\'' +
                ", RATING ='" + RATING + '\'' +
                ", PRICE ='" + PRICE + '\'' +
                ", QUANTITY  =" + QUANTITY +
                '}';
    }
}