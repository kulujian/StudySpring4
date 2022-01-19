select e.eid, e.ename, e.age, e.createtime ,
		j.jid AS job_jid, j.jname AS job_jname, j.eid AS job_eid
from emp e left outer join job j
on e.eid = j.eid