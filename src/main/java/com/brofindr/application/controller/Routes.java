package com.brofindr.application.controller;

public final class Routes {
    public static final String REGISTER_PATH = "/register";

    public static final String FIND_FRIENDS_PATH = "/friends/{userEmail:.+}";
    public static final String ADD_FRIENDS_PATH = "/friends";

    public static final String GET_ITEMS = "store/{storeId:.+}/items";
    public static final String GET_STORES = "/store/{zip:.+}";
    public static final String UNAVAILABLE_ITEM = "/item/{itemId:.+}/unavailable";
    public static final String AVAILABLE_ITEM = "/item/{itemId:.+}/available";
}
