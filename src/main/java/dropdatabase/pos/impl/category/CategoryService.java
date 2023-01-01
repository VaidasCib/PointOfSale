package dropdatabase.pos.impl.category;

import dropdatabase.pos.common.Service;
import dropdatabase.pos.impl.category.categoryDto.CategoryDto;
import dropdatabase.pos.impl.category.categoryDto.CategoryPostDto;

import javax.inject.Inject;
import java.util.List;
import java.util.UUID;

public class CategoryService extends Service {
    @Inject
    private CategoryRepository categoryRepository;

    public List<CategoryDto> getAll() {
        return categoryRepository.getList().stream().map(category -> getMapper().map(category, CategoryDto.class)).toList();
    }

    public void post(CategoryPostDto categoryPostDto) {
        Category category = categoryRepository.newObject();
        getMapper().map(categoryPostDto, category);
        categoryRepository.save(category);
    }

    public void put(UUID categoryId, CategoryPostDto categoryPostDto) {
        Category category = categoryRepository.getObject(categoryId);
        getMapper().map(categoryPostDto, category);
        categoryRepository.update(category);
    }

    public void delete(UUID categoryId) {
        categoryRepository.delete(categoryId);
    }
}
