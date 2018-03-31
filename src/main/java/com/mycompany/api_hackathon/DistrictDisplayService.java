package com.mycompany.api_hackathon;

import com.mycompany.DTO.DistrictDisplay;
import com.mycompany.DTO.DistrictFormat;
import com.mycompany.DTO.List.DistrictDisplays;
import com.mycompany.DTO.List.DistrictFormats;
import com.mycompany.DTO.List.Visits;
import com.mycompany.DTO.Task;
import com.mycompany.Model.DistrictDisplay_AccessManager;
import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import java.util.HashMap;
import java.util.Map;
import javax.ws.rs.PathParam;

@Path("/DistrictDisplayService")
public class DistrictDisplayService
{ 
    DistrictDisplay_AccessManager accessManager = new DistrictDisplay_AccessManager();
    private static Map<String,DistrictDisplay> actionMap = new HashMap<String,DistrictDisplay>();
    
    @GET
    @Path("/{id}/getAllDesc")
    @Produces("application/json")
    public DistrictDisplays districtDisplay(@PathParam("id") int id) 
    {
//		String actions = null;
                actionMap = new HashMap<String,DistrictDisplay>();
                DistrictDisplays c = new DistrictDisplays();
		try
		{
                    actionMap = accessManager.getDistrictDisplays(id);
                    ArrayList<DistrictDisplay> districtDisplayList = new ArrayList(actionMap.values());                    
                    c.setDistrictDisplayList(districtDisplayList);
                    
//                    Gson gson = new Gson();
//                    actions = gson.toJson(actionList);
		} 
                catch (Exception e)
		{
                    e.printStackTrace();
		}
                
		return c;
    }
    
    @GET
    @Path("/{TOKEN_ID}/{Name}/get")
    @Produces("application/json")
    public DistrictFormat districtDisplay(@PathParam("TOKEN_ID") int TOKEN_ID, @PathParam("Name") String Name) 
    {
                DistrictDisplays c = districtDisplay(TOKEN_ID);
                DistrictFormat df = new DistrictFormat();
                
		try
		{
                    Integer Assigned = 0 , Completed =0 , Pending =0, VisitCount =0;
                    
                    ArrayList<Task> atask = actionMap.get(Name).getTask();
                    Assigned = atask.size();
                    
                    for(Task t : atask)
                    {
                        if(t.getStatusId().getStatusId()==1)
                            Completed++;  
                        Visits v = accessManager.getDistrictFormat(t.getTid());
                        VisitCount += v.getVisitList().size();
                    }
                    
                    Pending = Assigned - Completed;
                    
                    df.setName(Name);
                    df.setAssigned(Assigned);
                    df.setCompleted(Completed);
                    df.setPending(Pending);
                    df.setVisitCount(VisitCount);
//                    Gson gson = new Gson();
//                    actions = gson.toJson(actionList);
		} 
                catch (Exception e)
		{
                    e.printStackTrace();
		}
                
		return df;
    }
    
    @GET
    @Path("/{TOKEN_ID}/getAll")
    @Produces("application/json")
    public DistrictFormats districtFormats(@PathParam("TOKEN_ID") int TOKEN_ID) 
    {
                DistrictDisplays c = districtDisplay(TOKEN_ID);
                DistrictFormats dfs = new DistrictFormats();
                ArrayList<DistrictFormat> dflist = new ArrayList<>();
                
		try
		{
                    for(Map.Entry<String, DistrictDisplay> entry : actionMap.entrySet())
                    {
                        String Name = entry.getKey();
                        DistrictDisplay dd = entry.getValue();
                        
                        Integer Assigned = 0 , Completed =0 , Pending =0, VisitCount =0;
                        
                        ArrayList<Task> atask = dd.getTask();
                        Assigned = atask.size();
                        
                        for(Task t : atask)
                        {
                            if(t.getStatusId().getStatusId()==1)
                                Completed++;  
                            Visits v = accessManager.getDistrictFormat(t.getTid());
                            VisitCount += v.getVisitList().size();
                        }
                    
                    Pending = Assigned - Completed;
                    
                    DistrictFormat df = new DistrictFormat();
                    df.setName(Name);
                    df.setAssigned(Assigned);
                    df.setCompleted(Completed);
                    df.setPending(Pending);
                    df.setVisitCount(VisitCount);
                    dflist.add(df);
                    
                    }
                    
                    dfs.setDistrictFormatList(dflist);
		} 
                catch (Exception e)
		{
                    e.printStackTrace();
		}
                
                
		return dfs;
    }
}