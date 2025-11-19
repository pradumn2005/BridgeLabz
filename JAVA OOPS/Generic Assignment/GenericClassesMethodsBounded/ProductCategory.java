public abstract class ProductCategory {

    private String categoryName;

    public ProductCategory(String name) {
        this.categoryName = name;
    }

    public String getCategoryName() {
        return categoryName;
    }
}
