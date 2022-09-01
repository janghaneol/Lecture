package namoo.yorizori.dto.cookbook;

/**
 * Recipe DTO
 * @author 김기정
 *
 */
public class Recipe {
	private int recipe_id;
	private int book_id;
	private String recipe_name;
	private int recipe_time;
	private int recipe_level;
	private String ingredients;
	private String writer_id; 
	
	public Recipe() {
		
	}

	public Recipe(int recipe_id, int book_id, String recipe_name, int recipe_time, int recipe_level, String ingredients,
			String writer_id) {
		
		this.recipe_id = recipe_id;
		this.book_id = book_id;
		this.recipe_name = recipe_name;
		this.recipe_time = recipe_time;
		this.recipe_level = recipe_level;
		this.ingredients = ingredients;
		this.writer_id = writer_id;
	}

	

	public int getRecipe_id() {
		return recipe_id;
	}

	public void setRecipe_id(int recipe_id) {
		this.recipe_id = recipe_id;
	}

	public int getBook_id() {
		return book_id;
	}

	public void setBook_id(int book_id) {
		this.book_id = book_id;
	}

	public String getRecipe_name() {
		return recipe_name;
	}

	public void setRecipe_name(String recipe_name) {
		this.recipe_name = recipe_name;
	}

	public int getRecipe_time() {
		return recipe_time;
	}

	public void setRecipe_time(int recipe_time) {
		this.recipe_time = recipe_time;
	}

	public int getRecipe_level() {
		return recipe_level;
	}

	public void setRecipe_level(int recipe_level) {
		this.recipe_level = recipe_level;
	}

	public String getIngredients() {
		return ingredients;
	}

	public void setIngredients(String ingredients) {
		this.ingredients = ingredients;
	}

	public String getWriter_id() {
		return writer_id;
	}

	public void setWriter_id(String writer_id) {
		this.writer_id = writer_id;
	}

	@Override
	public String toString() {
		return "Recipe [recipe_id=" + recipe_id + ", book_id=" + book_id + ", recipe_name=" + recipe_name
				+ ", recipe_time=" + recipe_time + ", recipe_level=" + recipe_level + ", ingredients=" + ingredients
				+ ", writer_id=" + writer_id + "]";
	}
	
	
}
