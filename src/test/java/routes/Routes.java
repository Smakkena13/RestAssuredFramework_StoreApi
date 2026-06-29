package routes;

public class Routes {
    public static final String BASE_URL="https://fakestoreapi.com";

    //products
    public static final String GET_ALL_PRODUCTS="/products";
    public static final String GET_SINGLE_PRODUCT="/products/{id}";
    public static final String GET_LIMIT_PRODUCTS="/products?limit=x";
    public static final String GET_SORTING_PRODUCTS="/products?sort=asc|desc";
    public static final String GET_ALL_PRODUCTS_CATEGORIES="/products/categories";
    public static final String GET_PRODUCT_CATEGORY="/products/category/{category}";
    public static final String POST_NEW_PRODUCT="/products";
    public static final String PUT_SINGLE_PRODUCT="/products/{id}";
    public static final String PATCH_SINGLE_PRODUCT="/products/{id}";
    public static final String DELETE_SINGLE_PRODUCT="/products/{id}";

    //carts

    //user

}
