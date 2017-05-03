package cc.feedback.dao;

import java.util.List;

import cc.feedback.entities.CategoryEntity;

public interface CategoryDao {
	
	List<CategoryEntity> getAllCategories();
}
