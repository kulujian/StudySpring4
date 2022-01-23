package com.study.springcore.tx.service;

import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.study.springcore.tx.dao.BookDao;
import com.study.springcore.tx.exception.InsufficientAmount;
import com.study.springcore.tx.exception.InsufficientQuantity;

@Repository
public class BookServiceImpl implements BookService{

	@Autowired
	private BookDao bookDao;
	
	// getConnection()、setAutoconmmit(false)、commit()  ← ↓ 讓資料庫控管這三項
	@Transactional(propagation = Propagation.REQUIRED,  //傳播模式  
		       rollbackFor = {InsufficientAmount.class, InsufficientQuantity.class},
		       noRollbackFor = {ArithmeticException.class}) 
	@Override
	public void buyOne(Integer wid, Integer bid)  throws InsufficientAmount, InsufficientQuantity{
		// 減去一本庫存
		bookDao.updateStock(bid, 1);
		// 取得書籍價格
//		if(true) {
//			throw new Error();
//		}
//		System.out.println(10/0); // 產生 ,ArithmeticException 錯誤 (根據上面的定義資料庫不會做回滾)
		Integer price = bookDao.getPrice(bid);
		// 減去錢包裡的金額
		bookDao.updateWallet(wid, price);
		// Log ...
	}

	// getConnection()、setAutoconmmit(false)、commit()  ← ↓ 讓資料庫控管這三項
	@Transactional(propagation = Propagation.REQUIRED,  //傳播模式  (這邊放第二個 不會的影響前面，因為Propagation)
			       rollbackFor = {InsufficientAmount.class, InsufficientQuantity.class},
			       noRollbackFor = {ArithmeticException.class}) 
	@Override
	public void buyMany(Integer wid, Integer ... bids)  throws InsufficientAmount, InsufficientQuantity{
		// 重複執行 buyOne
//		Stream.of(bids).forEach(bid -> buyOne(wid, bid));
		for(Integer bid : bids) {
			buyOne(wid, bid);
		}
		// 會有Log問題，到底Log是要切在哪裡
	}

}
