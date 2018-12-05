package data

fun insertBaseData() {
    insertMarkets()
}

fun insertMarkets() {
    MarketEntity.new("btc-usdt") {}
    MarketEntity.new("ltc-btc") {}
    MarketEntity.new("bch-btc") {}
    MarketEntity.new("bnb-usdt") {}
    MarketEntity.new("eth-usdt") {}
    MarketEntity.new("eth-btc") {}
    MarketEntity.new("etc-btc") {}
    MarketEntity.new("zrx-btc") {}
    MarketEntity.new("bat-usdt") {}
    MarketEntity.new("zec-usdt") {}
    MarketEntity.new("waves-btc") {}
    MarketEntity.new("btc-pax") {}
    MarketEntity.new("bnb-btc") {}
    MarketEntity.new("eos-usdt") {}
    MarketEntity.new("xrp-usdt") {}
    MarketEntity.new("xlm-btc") {}
    MarketEntity.new("bsv-btc") {}
    MarketEntity.new("ada-btc") {}
    MarketEntity.new("tron-btc") {}
}
