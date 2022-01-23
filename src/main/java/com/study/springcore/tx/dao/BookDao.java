package com.study.springcore.tx.dao;

import com.study.springcore.tx.exception.InsufficientAmount;
import com.study.springcore.tx.exception.InsufficientQuantity;

public interface BookDao {
	Integer getPrice(Integer bid);
	Integer getStockAmount(Integer bid);
	Integer getWalletMoney(Integer wid);
	Integer updateStock(Integer bid, Integer amount) throws InsufficientQuantity;  // 減去庫存 (若是有變動都要拋例外)
	Integer updateWallet(Integer wid, Integer money) throws InsufficientAmount;  // 減去餘額 (若是有變動都要拋例外)
}
