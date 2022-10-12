package co.usa.ciclo3.ciclo3.repositories;

import co.usa.ciclo3.ciclo3.model.Category;
import co.usa.ciclo3.ciclo3.repositories.crud.CategoryCrudRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CategoryRepository {
    
    @Autowired
    private CategoryCrudRepository categoryCrudRepository;
    
    //GET
    public List<Category> getAllCategories(){
        return (List<Category>) categoryCrudRepository.findAll();
    }
    public Optional<Category> getCategory(int id){
        return categoryCrudRepository.findById(id);
    }
    
    //POST
    public Category saveCategory(Category category){ 
        if(category.getId()==null){
            return categoryCrudRepository.save(category);
        }
        else{
            Optional<Category> categoryAux = categoryCrudRepository.findById(category.getId());
            if (!categoryAux.isPresent()) {
                return categoryCrudRepository.save(category);
            }
            else{
                return category;
            }
        }
    }
    
    //DELETE
    public void deleteCategory(int id){
        if (categoryCrudRepository.findById(id).isPresent()) {
            categoryCrudRepository.deleteById(id);
        }
    }
    
    //PUT
    public void updateCategory(int id, Category category){
        if(categoryCrudRepository.findById(id).isPresent()){
            Category categoryDB = categoryCrudRepository.findById(id).get();
            if (category.getName() != null) {
                categoryDB.setName(category.getName());
            }
            if (category.getDescription() != null) {
                categoryDB.setDescription(category.getDescription());
            }
            categoryCrudRepository.save(categoryDB);
        }
    }
    
}
