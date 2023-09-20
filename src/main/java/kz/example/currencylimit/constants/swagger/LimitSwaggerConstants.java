package kz.example.currencylimit.constants.swagger;

public class LimitSwaggerConstants {

    public static final String LIMIT_CREATE_DTO_TITLE="LimitCreateDto (Dto для создания лимите)";
    public static final String LIMIT_RESPONSE_DTO="LimitResponseDto (Dto для получения данные о лимите)";
    //Controller
    public static final String NAME_OF_LIMIT_SERVICE="Limit Service";
    public static final String DESCRIPTION_OF_LIMIT_CONTROLLER="Limit Api with description";
    public static final String DESCRIPTION_OF_FOR_CREATING_LIMIT="Api для создания лимита";

    public static final String DESCRIPTION_OF_FOR_GET_ALL_LIMITS = "Api для получения списка лимитов";

    //Fields
    public static final String FIELD_LIMIT_VALUE_DESCRIPTION="Сумма лимита";
    public static final String FIELD_LIMIT_VALUE_EXAMPLE="1000";
    public static final String FIELD_LIMIT_DATE_DESCRIPTION="Дата устаноления лимита";
    public static final String FIELD_LIMIT_DATE_EXAMPLE="2022-12-26T22:14:00.046Z";
    public static final String FIELD_LIMIT_CURRENCY_DESCRIPTION="вид валюты лимита";
    public static final String FIELD_LIMIT_CURRENCY_EXAMPLE="USD";
    public static final String FIELD_LIMIT_BALANCE_DESCRIPTION="остаток лимита";
    public static final String FIELD_LIMIT_BALANCE_EXAMPLE="400";
    public static final String FIELD_LIMIT_ACTUAL_DESCRIPTION="актуальность лимитв";
    public static final String FIELD_LIMIT_ACTUAL_EXAMPLE="false";
    public static final String FIELD_LIMIT_EXPENSE_CATEGORY_DESCRIPTION="категория лимита";
    public static final String FIELD_LIMIT_EXPENSE_CATEGORY_EXAMPLE="PRODUCT";
}
