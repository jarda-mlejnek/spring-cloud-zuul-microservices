package com.jmlejnek.product;

import com.jmlejnek.product.domain.Product;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@EnableDiscoveryClient
@RestController
@RequestMapping(ProductApplication.MAPPING)
@SpringBootApplication
public class ProductApplication {

	public static final String MAPPING = "/products";

	private static final Map<Long, Product> PRODUCTS = new HashMap<>();

	static {
		Product product1 = new Product();
		product1.setId((long) 1);
		product1.setNameI18N("Zlatý prstýnek");
		product1.setDescription("Zlatý prstýnek s růžovým diamantem");
		product1.setUrl("\"http:\\\\\\\\www.shop.cz\\\\api\\\\v1\\\\products\\\\1\"");
		product1.setImageUrl("http:\\\\cdn.shop.cz\\images\\product1.jpg");
		product1.setCategoryId((long) 2);

		Product product2 = new Product();
		product2.setId((long) 1);
		product2.setNameI18N("Stříbrný prstýnek");
		product2.setDescription("Stříbrný prstýnek s erbem");
		product2.setUrl("\"http:\\\\\\\\www.shop.cz\\\\api\\\\v1\\\\products\\\\2\"");
		product2.setImageUrl("http:\\\\cdn.shop.cz\\images\\product2.jpg");
		product2.setCategoryId((long) 2);

		Product product3 = new Product();
		product3.setId((long) 1);
		product3.setNameI18N("Zlatý náhrdelník");
		product3.setDescription("Zlatý náhrdelník s růžovým diamantem");
		product3.setUrl("\"http:\\\\\\\\www.shop.cz\\\\api\\\\v1\\\\products\\\\3\"");
		product3.setImageUrl("http:\\\\cdn.shop.cz\\images\\product3.jpg");
		product3.setCategoryId((long) 3);

		Product product4 = new Product();
		product4.setId((long) 1);
		product4.setNameI18N("Stříbrný náhrdelník");
		product4.setDescription("Stříbrný náhrdelník s erbem");
		product4.setUrl("\"http:\\\\\\\\www.shop.cz\\\\api\\\\v1\\\\products\\\\4\"");
		product4.setImageUrl("http:\\\\cdn.shop.cz\\images\\product4.jpg");
		product4.setCategoryId((long) 3);

		PRODUCTS.put((long) 1, product1);
		PRODUCTS.put((long) 2, product2);
		PRODUCTS.put((long) 3, product3);
		PRODUCTS.put((long) 4, product4);
	}

	public static void main(String[] args) {
		SpringApplication.run(ProductApplication.class, args);
	}

	@RequestMapping(method = RequestMethod.GET)
	public Collection<Product> getProducts() {
		return PRODUCTS.values();
	}

	@RequestMapping(value = "/{productId}", method = RequestMethod.GET)
	public ResponseEntity<Product> getProduct(Long productId) {
		Product product = PRODUCTS.get(productId);
		if (product == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		return ResponseEntity.ok(product);
	}

}
