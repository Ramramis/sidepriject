package user.side.dto;

import lombok.Data;

@Data
public class Product {
	
	 private int id;
	    private String name;
	    private String description;
	    private double price;
	    private String imageUrl;

}
