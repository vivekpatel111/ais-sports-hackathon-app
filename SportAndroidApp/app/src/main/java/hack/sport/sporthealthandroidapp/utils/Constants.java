package hack.sport.sporthealthandroidapp.utils;

/**
 * Created by Abhishek Kumar on 11/14/2015.
 */

public class Constants {

    protected static final String GOOGLE_API_KEY = "key";
    protected static final String GOOGLE_API = "AIzaSyDA1nWX-2zzieT_HgCqTbugN7GubBStaUM";

    protected static final String GOOGLE_CUSTOM_SEARCH_ID_KEY = "cx";
    protected static final String GOOGLE_CUSTOM_SEARCH_ID = "011115417401836237376:gfzn90mzlxm";

    protected static final String GOOGLE_CUSTOM_SEARCH_HOST_KEY = "googlehost";
    protected static final String GOOGLE_CUSTOM_SEARCH_HOST = "google.com";

    protected static final String GOOGLE_CUSTOM_SEARCH_SAFE_TYPE_KEY = "safe";
    protected static final String GOOGLE_CUSTOM_SEARCH_MEDIUM_SAFE_TYPE = "medium";

    protected static final String GOOGLE_CUSTOM_SEARCH_IMAGE_SEARCH_TYPE = "image";
    protected static final String GOOGLE_CUSTOM_SEARCH_SEARCH_TYPE_KEY = "searchType";

    protected static final String  GOOGLE_CUSTOM_SEARCH_PRETTY_PRINT_KEY = "prettyPrint";
    protected static final String GOOGLE_CUSTOM_SEARCH_PRETTY_PRINT_DEFAULT_VALUE = "false";

    protected static final String GOOGLE_CUSTOM_SEARCH_START_INDEX_KEY = "start";
    public static final String  GOOGLE_CUSTOM_SEARCH_START_INDEX_DEFAULT_VALUE = "1";

    protected static final String GOOGLE_CUSTOM_SEARCH_N_RESULTS_KEY = "num";
    protected static final String GOOGLE_CUSTOM_SEARCH_N_RESULTS_DEFAULT_VALUE =  "20";

    protected static final String GOOGLE_CUSTOM_SEARCH_QUERY_KEY = "q";
    protected static final String GOOGLE_CUSTOM_SEARCH_URL = "https://www.googleapis.com/customsearch/v1";


    /*  Bing Search */
    protected static final String BING_IMAGE_SEARCH_URL = "https://api.datamarket.azure.com/Bing/Search/Image";
    protected static final String BING_SEARCH_QUERY_KEY = "Query";
    protected static final String BING_SEARCH_ADULT_KEY = "Adult";
    protected static final String BING_SEARCH_ADULT_MODERATE = "Moderate";
    protected static final String BING_SEARCH_FORMAT_KEY = "$format";
    protected static final String BING_SEARCH_JSON_FORMAT = "json";
    protected static final String BING_API_KEY = "OnU2Mxti1LltKV0xiBXh0wvlN3DbXwXngWfcHZ";

    public static String getBingApiKey() {
        return BING_API_KEY;
    }


    public static final int IMAGE_TO_SHARE_LIMIT = 5;

}
