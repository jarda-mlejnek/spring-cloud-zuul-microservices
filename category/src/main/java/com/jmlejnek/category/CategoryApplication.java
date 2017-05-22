package com.jmlejnek.category;

import com.jmlejnek.category.domain.Category;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@EnableDiscoveryClient
@RestController
@RequestMapping(CategoryApplication.MAPPING)
@SpringBootApplication
public class CategoryApplication {

	public static final String MAPPING = "/categories";

	private static final Map<Long, Category> CATEGORIES = new HashMap<>();

	static {
		Category cat1 = new Category();
		cat1.setId((long) 1);
		cat1.setNameI18N("Šperky");
		cat1.setUrl("http:\\\\www.shop.cz\\api\\v1\\categories\\1");
		cat1.setImageUrl("http:\\\\cdn.shop.cz\\images\\ca1.jpg");
		cat1.setLevel(1);

		Category cat2 = new Category();
		cat2.setId((long) 2);
		cat2.setNameI18N("Prsteny");
		cat2.setUrl("http:\\\\www.shop.cz\\api\\v1\\categories\\2");
		cat2.setImageUrl("http:\\\\cdn.shop.cz\\images\\ca2.jpg");
		cat2.setLevel(2);

		Category cat3 = new Category();
		cat3.setId((long) 3);
		cat3.setNameI18N("Náhrdelníky");
		cat3.setUrl("http:\\\\www.shop.cz\\api\\v1\\categories\\3");
		cat3.setImageUrl("http:\\\\cdn.shop.cz\\images\\ca3.jpg");
		cat3.setLevel(3);

		cat1.setSubCategories(Arrays.asList(new Category [] { cat2, cat3 }));
		//cat2.setParentCategory(cat1);
		//cat3.setParentCategory(cat1);

		CATEGORIES.put((long) 1, cat1);
		CATEGORIES.put((long) 2, cat2);
		CATEGORIES.put((long) 3, cat3);
	}

	public static void main(String[] args) {
		SpringApplication.run(CategoryApplication.class, args);
	}

	@RequestMapping(method = RequestMethod.GET)
	public Collection<Category> getCategories() {
		return CATEGORIES.values();
	}

	@RequestMapping(value = "/{categoryId}", method = RequestMethod.GET)
	public ResponseEntity<Category> getCategory(@PathVariable Long categoryId) {
		Category category = CATEGORIES.get(categoryId);
		if (category == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		return ResponseEntity.ok(category);
	}

}
