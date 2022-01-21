package com.study.springcore.homework.lab01.controllers;

import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.study.springcore.homework.lab01.entity.Invoice;
import com.study.springcore.homework.lab01.entity.Item;
import com.study.springcore.homework.lab01.entity.ItemProduct;
import com.study.springcore.homework.lab01.template.ItemInvidIpidDao;

@Controller
public class ItemInvidIpidController {

	@Autowired
	private ItemInvidIpidDao itemInvIdIpidDao;
	
	public void showAllStream () {

		Iterator s = itemInvIdIpidDao.queryInvoice().iterator();
		while (s.hasNext()) {
			Invoice a = (Invoice) s.next();
			Integer sum = 0;
			System.out.printf("發票序號:%3d  發票日期:%11s\n", a.getId(), a.getInvdate());
			Iterator b = a.getItems().iterator();
			Iterator c = a.getItemProducts().iterator();
			while (b.hasNext() && c.hasNext()) {
				Item d = (Item) b.next();
				ItemProduct e = (ItemProduct) c.next();
				System.out.printf("    品項:%3d  品名:%6s  數量:%3d  單價:%4d  小計:%4d\n", 
						d.getId(), e.getText(), d.getAmount(), e.getPrice(), (d.getAmount() * e.getPrice()));
				sum += d.getAmount() * e.getPrice();
			}
			System.out.printf("%44s發票金額:%4d\n\n", "", sum);
		}
	}
}
