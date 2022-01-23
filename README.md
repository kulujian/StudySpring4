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

# 2022/01/21 設計 01/16 回家作業
  目前進度：完成作業，待上傳

# 2022/01/23 上課學習 Spring TX 交易/事務管理
  練習路徑：
	scr/main/java/com/study/springcore/tx/*.*
  配置 jdbc-config.xml 需要加入以下配置
	<beans xmlns:tx="http://www.springframework.org/schema/tx"
		xsi:schemaLocation="http://www.springframework.org/schema/tx http://www.springframework.org/schema/tx/spring-tx-4.3.xsd">

	    <!-- 需要 Bean 掃描的位置 -->
	    <context:component-scan base-package="com.study.springcore.tx" />

	    <!-- 配置事務管理器 -->
	    <bean id="transactionManager" class="org.springframework.jdbc.datasource.DataSourceTransactionManager">
		<property name="dataSource" ref="dataSource" ></property>
	    </bean>

	    <!-- 開啟註解驅動，對事務相關的註解進行掃描與解析 -->
		<tx:annotation-driven transaction-manager="transactionManager"></tx:annotation-driven>

	</beans>

  若是不用 Spring Template 進行事務管理，傳統使用 Java 方式
	路徑：scr/main/java/com/study/springcore/jdbc/template
	檔案：EmpDao.java
	方法：addOne1TX()
	main方法：scr/text/java/com/study/springcore/jdbc/Template4.java
  一樣可以達到效果，舊專案可能會遇到

