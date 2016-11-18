/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api;

import javax.enterprise.context.RequestScoped;
import javax.json.JsonObject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author NguyenTrung
 */
@RequestScoped
@Path(value = "/register")
public class Register {

    @Context
    private HttpServletRequest request;
    @Context
    private HttpServletResponse response;

    @Produces(MediaType.TEXT_HTML)
    @GET
    public Response get() throws Exception {
        String myJsfPage = "/faces/employee.xhtml";
        String contextPath = request.getContextPath();
        response.sendRedirect(contextPath + myJsfPage);
        return Response.accepted().build();
    }

    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    @POST
    public Response post(JsonObject json) {
        String name = json.getString("name");
        String email = json.getString("email");
        String gender = json.getString("gender");
        String str = name + " " + email + " " + gender;
        return Response.accepted(str).build();
    }

}
