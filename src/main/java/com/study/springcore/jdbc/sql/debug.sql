-- 【誤錯訊息】this is incompatible with sql_mode=only_full_group_by --
	--  檢查MySql配置參數
	select @@GLOBAL.sql_mode;
	--  暫時性變更設定，重啟服務後失效
	set @@GLOBAL.sql_mode="STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION";