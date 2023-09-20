package kz.example.currencylimit.constants.swagger;

public class TransactionSwaggerConstants {
    public static final String TRANSACTION_CREATE_DTO="TransactionCreateDto (Dto для создания транзакций)";
    public static final String TRANSACTION_RESPONSE_DTO="TransactionResponseDto (Dto для получения данные о транзакций)";

    //Controller
    public static final String NAME_OF_TRANSACTION_CONTROLLER ="Transaction Service (сервис транзакций)";
    public static final String DESCRIPTION_OF_TRANSACTION_CONTROLLER="Transaction Service Api with description";
    public static final String DESCRIPTION_OF_API_FOR_CREATING_TRANSACTION="Api для добавления транзакций";
    public static final String DESCRIPTION_OF_API_FOR_GETTING_ALL_TRANSACTIONS="Api для получения всех транзакций(Пагинация)";


    //Fields
    public static final String FIELD_ACCOUNT_FROM_DESCRIPTION="Банковский счет клиента (Целочисленный, 10 знаков)";
    public static final String FIELD_ACCOUNT_FROM_EXAMPLE="777754546";
    public static final String FIELD_ACCOUNT_TO_DESCRIPTION="Банковский счет контрагента (Целочисленный, 10 знаков)";
    public static final String FIELD_ACCOUNT_TO_EXAMPLE="777754548";
    public static final String FIELD_CURRENCY_DESCRIPTION="Вид валюты";
    public static final String FIELD_CURRENCY_EXAMPLE="RUB";
    public static final String FIELD_SUM_DESCRIPTION="Сумма транзакций";
    public static final String FIELD_SUM_EXAMPLE="4000";
    public static final String FIELD_LIMIT_EXCEEDED_DESCRIPTION="лимит превышен";
    public static final String FIELD_LIMIT_EXCEEDED_EXAMPLE="false";
    public static final String FIELD_DATE_DESCRIPTION="Дата транзакций";
    public static final String FIELD_DATE_EXAMPLE="2022-12-26T22:14:00.046Z";
    public static final String FIELD_EXPENSE_CATEGORY_DESCRIPTION="Категория расхода (категория расходов и категория лимита должны быть равны)";
    public static final String FIELD_EXPENSE_CATEGORY_EXAMPLE="SERVICE";
}
