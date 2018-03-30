package com.mycompany.api_hackathon;

import com.mycompany.DTO.DistrictDisplay;
import com.mycompany.DTO.List.DistrictDisplays;
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
    @Path("/{id}/getAll")
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
}