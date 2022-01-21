# Learn_Spring4

# 2022/01/02 學習 proxy 及 AOP(Aspect-oriented-programming)切面導向程式設計
  一、JDK 靜態代理 com.study.springcore.proxy.sta
  二、JDK 動態代理 com.study.springcore.proxy.dyn
  三、第三方代理【cglib】 com.study.springcore.proxy.cglib
	1. POM檔，加入AOP依賴
  四、Spring 中 AOP 如何使用 com.study.springcore.aop

# 2022/01/14 設計 01/09 回家作業
  一、新增 src/main/java/com.study.springcore.jdbc.aop.MyLoggerAsperct
        設定切面程式切點測試成功，待新增作業功能(建立查詢LOG)
  二、修改 src/main/java/com.study.springcore.jdbc.template.EmpDao
        將Test1內取得【ename】代碼放置到這邊
  三、修改 src/test/java/com.study.springcore.jdbc.TempplateTest1
        重新設計內容為選單模式，目前測試正常
  四、修改 conf/jdbc-config.xml
        加入【<aop:aspectj-autoproxy></aop:aspectj-autoproxy】代理

# 2022/01/20 設計 01/16 回家作業
  一、建立 sql table Invoice,Item,ItemProduct 及 values
  二、建立 entity Invoice,Item,ItemProduct
  三、建立 template 及 Dao
  四、建立 MainLab01
  目前進度：可以將資料抓出來，目前測試其它語法

# 2022/01/20 設計 01/16 回家作業
  一、建立 contrllers ItemInvidIpidController
  目前進度：已經例用entity return toString 實現回家作業內容
            目前正在改用 menu loop 方式，變成可選。
