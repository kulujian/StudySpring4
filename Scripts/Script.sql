UPDATE backstage_try2 
SET Marketing='開啟',Password='MDgzMA=='
WHERE Numb IN (0830);

select seq, Name, Numb, Marketing, password
From backstage_try2
Where password = 'MTIzNA==';


select *
from backstage_try2 bt 
WHERE 1
LIMIT 1; 

insert into backstage_try2 (Numb,Name,Password,Email,phone,Department,Information,Marketing,Services,OnlineRepair,Announcement,DocOfficialSystem,ArchiveJob) values
('0735','傅柏淵','MDczNQ==','','','','關閉','開啟','關閉','關閉','關閉','開啟','關閉'),
('0747','徐兆鈞','MDc0Nw==','','','','關閉','開啟','關閉','關閉','關閉','開啟','關閉'),
('0758','梅挽瀾','MDc1OA==','','','','關閉','開啟','關閉','關閉','關閉','開啟','關閉'),
('0784','吳旻燊','MDc4NA==','','','','關閉','開啟','關閉','關閉','關閉','開啟','關閉'),
('0796','蔡堯明','MDc5Ng==','','','','關閉','開啟','關閉','關閉','關閉','開啟','關閉'),
('0830','洪嘉杏','MDgzMA==','','','','關閉','開啟','關閉','關閉','關閉','開啟','關閉');

select *
from Maxe_DOC_20210906.EMP_DATA ed ;
