package cl.ferosalgado.surbtc.constant;

public class Path {

	public static final String URLPATTERN = "%s://%s/%s/%s";
	public static final String URLPATTERNWITHPORT = "%s://%s:%s/%s/%s";
    public static final String MARKETS = "markets";
    public static final String MARKET_DETAILS = "markets/%s";
    public static final String TICKER = "markets/%s/ticker";
    public static final String ORDER_BOOK = "markets/%s/order_book";
    public static final String QUOTATION = "markets/%s/quotations";
    public static final String FEE_PERCENTAGE = "markets/%s/fee_percentage";
    public static final String TRADE_TRANSACTIONS = "markets/%s/trade_transactions";
    public static final String REPORTS = "markets/%s/reports";
    public static final String BALANCES = "balances";
    public static final String BALANCE_DETAIL = "balances/%s";
    public static final String BALANCES_EVENTS = "balance_events";
    public static final String ORDERS = "markets/%s/orders";
    public static final String SINGLE_ORDER = "orders/%s";
    public static final String WITHDRAWAL = "currencies/%s/withdrawals";
    public static final String DEPOSITS = "currencies/%s/deposits";
    public static final String RECEIVE_ADDRESSES = "currencies/%s/receive_addresses";
}
