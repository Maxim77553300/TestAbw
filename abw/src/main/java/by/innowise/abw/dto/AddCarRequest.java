package by.innowise.abw.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

public class AddCarRequest {
    @NotBlank
    private String name;

    private String brand;

    private String description;
    @Min(100)
    private Integer price;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
}
