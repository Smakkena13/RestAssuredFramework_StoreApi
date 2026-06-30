package routes;

public class Routes {
    public static final String BASE_URL="https://fakestoreapi.com";

    //products
    public static final String GET_ALL_PRODUCTS="/products";
    public static final String GET_SINGLE_PRODUCT="/products/{id}";
    public static final String GET_LIMIT_PRODUCTS="/products?limit={limit}";
    public static final String GET_SORTING_PRODUCTS="/products?sort={order}";
    public static final String GET_ALL_PRODUCTS_CATEGORIES="/products/categories";
    public static final String GET_PRODUCT_CATEGORY="/products/category/{category}";
    public static final String POST_NEW_PRODUCT="/products";
    public static final String PUT_SINGLE_PRODUCT="/products/{id}";
    public static final String PATCH_SINGLE_PRODUCT="/products/{id}";
    public static final String DELETE_SINGLE_PRODUCT="/products/{id}";

    //carts
    public static final String GET_ALL_CARTS="/carts";
    public static final String GET_SINGLE_CART="/carts/{id}";
    public static final String GET_LIMIT_CARTS="/carts?limit=x";
    public static final String GET_SORTING_CARTS="/carts?sort=asc|desc";
    public static final String GET_CARTS_DATERANGE="/carts?startDate=YYYY-MM-DD&endDate=YYYY-MM-DD";
    public static final String GET_CARTS_BY_USERID="/carts/user/{userId}";
    public static final String POST_NEW_CART="/carts";
    public static final String PUT_SINGLE_CART="/carts/{id}";
    public static final String PATCH_SINGLE_CART="/carts/{id}";
    public static final String DELETE_SINGLE_CART="/carts/{id}";

    //user
    public static final String POST_GENERATE_TOKEN="/auth/login";
    public static final String GET_SINGLE_USER="/users/{id}";
    public static final String GET_ALL_USERS="/users";
    public static final String POST_NEW_USER="/users";
    public static final String PUT_UPDATE_USER="/users/{id}";
    public static final String PATCH_UPDATE_USER="/users/{id}";
}
