package co.usa.ciclo3.ciclo3.service;

import co.usa.ciclo3.ciclo3.model.Category;
import co.usa.ciclo3.ciclo3.repositories.CategoryRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {
    
    @Autowired
    private CategoryRepository categoryRepository;
    
    //GET
    public List<Category> getAllCategories(){
        return categoryRepository.getAllCategories();
    }
    public Optional<Category> getCategory(int id){
        return categoryRepository.getCategory(id);
    }
    
    //POST
    public Category saveCategory(Category category){
        return categoryRepository.saveCategory(category);
    }
    
    //DELETE
    public void deleteCategory(int id){
        categoryRepository.deleteCategory(id);
    }
    
    //PUT
    public void updateCategory(int id, Category category){
        categoryRepository.updateCategory(id, category);
    }
    
}
