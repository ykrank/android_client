


function  test(source)
  --获取JSON文件
  local objects=json:objectFromJSON(source);
  --解析JSON
  local num,ope,the,rep,ver,cop,reg,mile,own,pri,com,ant;

  for k,v in pairs(objects) do
    if k == "TicketNum" then
      num=v;
      
    elseif k == "Opened" then
      ope=v;
    elseif k == "Theme" then
      the=v;
    elseif k == "Reporter" then
      rep=v;
      global_tab["userName"] = v;     
    elseif k == "Owner" then
      own=v;
    elseif k == "Priority" then
      pri=v;
    elseif k == "Milestone" then
      mile=v;
      
    elseif k == "Component" then
      com=v;
    elseif k == "Antistop" then
      ant=v;
    elseif k == "Versions" then
      ver=v;
    elseif k == "Copy" then
      cop=v; 
    else
      reg=v;
                     
    --m[1]:setPropertyByName("TicketNum",v);
    end;    
  end;

  local m = document:getElementsByName("myviewcontent");
  local content = [[ <div name="myviewcontent"><myview

	              			  class="myview1"        

	     								  TicketNum="]]..num..[[" 

	     								  Opened="]]..ope..[["

	     	    						Theme="]]..the..[["

	     	    						Reporter="]]..rep..[["

	     	    						Owner="]]..own..[["

	     	    						Priority="]]..pri..[["     

	     	    						Milestone="]]..mile..[["

	     	    						Component="]]..com..[["

	     	    						Versions="]]..ver..[["

	     	    						Antistop="]]..ant..[["			

	     	    						Copy="]]..cop..[[" 

	     	    						Regression="]]..reg..[["	

	     	    						

	     	    					></myview>

									</div>]]      
	      	
  m[1]:setInnerHTML(content);
  
end;


function append()
    local time,pre,note;
    
    local text=document:getElementsByName("textarea1");
    global_tab["note"]=text[1]:getPropertyByName("value");


    pre=global_tab["userName"];
    note=global_tab["note"];
    
    local tm= os.date("*t");
    time=tm.year.."-"..tm.month.."-"..tm.day.." "..tm.hour..":"..tm.min;
    local m = document:getElementsByName("div2");
    local content = [[ <div border="0" class="div2" name="div2"><mylist name="mylist1" 
                      time="]]..time..[["
                      person="]]..pre..[[" 
                      text="]]..note..[["
                                     
                     ></mylist></div>]];
    --mylua:appedChild(m[1],content);                   
    m[1]:setInnerHTML(content);
end;

function fuck()
    local time,pre,note;  
    pre=global_tab["userName"]; 
     
    note=global_tab["note"];

    local tm= os.date("*t");
    time=tm.year.."-"..tm.month.."-"..tm.day.." "..tm.hour..":"..tm.min;
    local m = document:getElementsByName("div2");
    local content = [[ <div border="0" class="div2" name="div2"><mylist name="mylist1" 
                      time="]]..time..[["
                      person="]]..pre..[[" 
                      text="]]..note..[["
                                     
                     ></mylist></div>]];
                    
    m[1]:setInnerHTML(content);
end;