package cs174.starsrus.entities;

public class DBTables {

    public static final String DATABASE_NAME = "starsrus";

    // TODO: Add more attribute constants to use later
    /**
     * TABLENAME: The name of the table
     * ATTR_: attribute/column in the table
     * Example, ATTR_USERNAME is the column 'username' in table User
     */
    public static class TABLE_USER {
        public static final String TABLENAME = "user";    
        public static final String ATTR_ID = "id";
        public static final String ATTR_USERNAME = "username";
        public static final String ATTR_PASSWORD = "password";
        public static final String ATTR_FIRSTNAME = "firstname";
        public static final String ATTR_LASTNAME = "lastname";
        public static final String ATTR_DOB = "dob";
        public static final String ATTR_ADDRESS = "address";
        public static final String ATTR_STATE = "state";
        public static final String ATTR_PHONE = "phone";
        public static final String ATTR_EMAIL = "email";
        public static final String ATTR_SSN = "ssn";
        public static final String ATTR_REGISTRATION_DATE = "registration_date";
        public static final String ATTR_NET_BALANCE = "net_balance";
    }

    public static class TABLE_USER_WATCH_LIST {
        public static final String TABLENAME = "user_watch_list";   
    }

    public static class TABLE_USER_STOCK_LIST {
        public static final String TABLENAME = "user_stock_list";   
    }

    public static class TABLE_BUY_STOCK {
        public static final String TABLENAME = "buy_stock";   
    }

    public static class TABLE_SELL_STOCK {
        public static final String TABLENAME = "sell_stock";   
    }

    public static class TABLE_STATEMENT {
        public static final String TABLENAME = "user_statement";   
    }

    public static class TABLE_WALLET_TRANSACTION {
        public static final String TABLENAME = "user_wallet_transaction";   
    }

    public static class TABLE_ROLE {
        public static final String TABLENAME = "role";
        public static final String ATTR_ROLE_ID = "role_id";
        public static final String ATTR_ROLE_NAME = "role_name";   
    }

    public static class TABLE_USER_ROLE {
        public static final String TABLENAME = "user_role";   
        public static final String ATTR_USER_ID = "user_id";
        public static final String ATTR_USERNAME = TABLE_USER.ATTR_USERNAME;
        public static final String ATTR_ROLE_ID = TABLE_ROLE.ATTR_ROLE_ID;
        
    }

    

}
