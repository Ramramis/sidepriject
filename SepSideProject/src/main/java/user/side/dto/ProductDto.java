package user.side.dto;

import lombok.Data;

@Data
public class ProductDto {
	
	 private Long id;           // 제품 ID
	    private String name;       // 제품 이름
	    private String description; // 제품 설명
	    private String imageUrl;   // 제품 이미지 URL
	    private int price;         // 제품 가격
	    private String memo;

}
