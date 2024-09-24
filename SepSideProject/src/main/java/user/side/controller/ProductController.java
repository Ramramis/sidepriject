package user.side.controller;

import java.io.File;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import jakarta.servlet.http.HttpServletRequest;
import user.side.dto.ProductDto;
import user.side.service.ProductService;

@Controller
public class ProductController {
	
	
	
	 @Autowired
	    private ProductService productService;

	  // 제품 목록을 보여주는 GET 요청
	    @GetMapping("/products")
	    public String showProductList(Model model) {
	        model.addAttribute("products", productService.getAllProducts());
	        return "home";
	    }

	    // 제품 상세 페이지를 보여주는 GET 요청
	    @GetMapping("/product/{id}")
	    public String showProductDetail(@PathVariable("id") Long productId, Model model) {
	        model.addAttribute("product", productService.getProductById(productId));
	        return "productDetail";
	    }
	    
	 // 제품 등록 폼을 보여주는 GET 요청
	    @GetMapping("/product/new")
	    public String showProductForm(Model model) {
	        model.addAttribute("product", new ProductDto());
	        return "productForm";
	    }

	 // 제품 등록 처리 POST 요청 (이미지 업로드 포함)
		@PostMapping("/product/new")
		public String registerProduct(
		        @ModelAttribute("product") ProductDto product,
		        @RequestParam("file") MultipartFile photo, // 이미지 파일 처리
		        HttpServletRequest request,
		        Model model) {

		    // 이미지 업로드 처리
		    String newFileName = makeFileName(photo.getOriginalFilename());  // 파일명 생성
		    File newFile = null;

		    try {
		        // 서버에 파일을 저장할 경로 지정
		        String path = request.getServletContext().getRealPath("/img/");
		        newFile = new File(path, newFileName);
		        if (!newFile.getParentFile().exists()) {
		            newFile.getParentFile().mkdirs();  // 디렉토리가 없으면 생성
		        }
		        photo.transferTo(newFile);  // 파일을 서버에 저장
		    } catch (IOException | IllegalStateException e) {
		        e.printStackTrace();
		    }

		    // 파일 저장 경로가 생성되었을 때
		    if (newFile != null) {
		        product.setImageUrl("/img/" + newFileName);  // 업로드된 이미지 경로 설정
		    }

		    // 제품 정보 저장 처리
		    productService.insertProduct(product);

		    // 제품 목록 페이지로 리다이렉트
		    return "redirect:/products";
		}

		// 파일명 생성 메서드 (기존 파일명 중복을 피하기 위해)
		private String makeFileName(String originalFilename) {
		    return System.currentTimeMillis() + "_" + originalFilename;  // 타임스탬프를 붙여 파일명 생성
		}

}
