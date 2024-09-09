package user.side.dto;

import lombok.Data;

@Data
public class Order {
	
	 private int id;
	    private String customerName;
	    private String customerEmail;
	    private int productId;
	    private int quantity;
	    private double totalPrice;

}
