package acme;

import io.quarkus.arc.Arc;
import io.quarkus.arc.ArcContainer;
import io.quarkus.hal.HalService;
import io.quarkus.panache.common.Sort;
import io.quarkus.panache.common.Sort.Direction;
import io.quarkus.rest.data.panache.RestDataPanacheException;
import io.quarkus.rest.data.panache.runtime.UpdateExecutor;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.UriInfo;
import jakarta.ws.rs.core.Response.ResponseBuilder;
import java.lang.annotation.Annotation;
import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.jboss.resteasy.links.LinkResource;

// $VF: synthetic class
@Path("calendar")
public class CalendarRepositoryJaxRs_253b5300496aea63c836aa077421802281ec4c5b {
   @Inject
   CalendarRepositoryResourceImpl_253b5300496aea63c836aa077421802281ec4c5b resource;

   @Path("/{id}")
   @GET
   @Produces({"application/json", "application/hal+json"})
   @LinkResource(
      entityClassName = "acme.Calendar",
      rel = "self"
   )
   public Response get(@PathParam("id") Long id) {
      CalendarRepositoryResourceImpl_253b5300496aea63c836aa077421802281ec4c5b var2 = this.resource;

      try {
         Object var3 = var2.get(var1);
         return var3 != null ? Response.ok(var3).build() : Response.status(404).build();
      } catch (Throwable var5) {
         throw (Throwable)(new RestDataPanacheException("Failed to get an entity", var5));
      }
   }

   @GET
   @Path("")
   @Produces({"application/json"})
   @LinkResource(
      entityClassName = "acme.Calendar",
      rel = "list"
   )
   public Response list(@QueryParam("sort") List<String> sort, @QueryParam("namedQuery") String namedQuery) {
      Sort var8 = Sort.by(new String[0]);
      LinkedList var4 = new LinkedList();
      Iterator var3 = var1.iterator();

      while(var3.hasNext()) {
         List var5 = Arrays.asList(((String)var3.next()).split(","));
         var4.addAll(var5);
      }

      for(Object var7 : var4) {
         if (!((String)var7).startsWith("-")) {
            var8.and((String)var7);
         } else {
            String var9 = ((String)var7).substring(1);
            Direction var10 = Direction.Descending;
            var8.and(var9, var10);
         }
      }

      CalendarRepositoryResourceImpl_253b5300496aea63c836aa077421802281ec4c5b var12 = this.resource;

      try {
         HashMap var14 = new HashMap();
         ArrayList var11 = new ArrayList();
         String var13;
         if (var2 != null) {
            var13 = "#".concat(var2);
         } else {
            var13 = String.join(" AND ", var11);
         }

         return Response.ok(var12.list(null, var8, var13, var14)).build();
      } catch (Throwable var16) {
         throw (Throwable)(new RestDataPanacheException("Failed to list the entities", var16));
      }
   }

   @GET
   @Produces({"application/json"})
   @Path("/count")
   public Response count() {
      CalendarRepositoryResourceImpl_253b5300496aea63c836aa077421802281ec4c5b var1 = this.resource;

      try {
         return Response.ok(var1.count()).build();
      } catch (Throwable var3) {
         throw (Throwable)(new RestDataPanacheException("Failed to count the entities", var3));
      }
   }

   @Path("")
   @POST
   @Consumes({"application/json"})
   @Produces({"application/json", "application/hal+json"})
   @LinkResource(
      entityClassName = "acme.Calendar",
      rel = "add"
   )
   public Response add(@Valid Calendar entity, @Context UriInfo uriInfo) {
      CalendarRepositoryResourceImpl_253b5300496aea63c836aa077421802281ec4c5b var3 = this.resource;

      try {
         Object var7 = var3.add(var1);
         ArcContainer var5 = Arc.container();
         ClassLoader var4 = Thread.currentThread().getContextClassLoader();
         Class var6 = Class.forName("io.quarkus.resteasy.links.runtime.hal.ResteasyHalService", false, var4);
         String var8 = ((HalService)var5.instance(var6, null).get()).getSelfLink(var7);
         if (var8 != null) {
            URI var10 = URI.create(var8);
            ResponseBuilder var9 = Response.status(201);
            var9.entity(var7);
            var9.location(var10);
            return var9.build();
         } else {
            throw (Throwable)(new RuntimeException("Could not extract a new entity URL"));
         }
      } catch (Throwable var12) {
         throw (Throwable)(new RestDataPanacheException("Failed to add an entity", var12));
      }
   }

   @Path("/{id}")
   @PUT
   @Consumes({"application/json"})
   @Produces({"application/json", "application/hal+json"})
   @LinkResource(
      entityClassName = "acme.Calendar",
      rel = "update"
   )
   public Response update(@PathParam("id") Long id, @Valid Calendar entity, @Context UriInfo uriInfo) {
      CalendarRepositoryResourceImpl_253b5300496aea63c836aa077421802281ec4c5b var8 = this.resource;

      try {
         ArcContainer var5 = Arc.container();
         ClassLoader var4 = Thread.currentThread().getContextClassLoader();
         Class var6 = Class.forName("io.quarkus.rest.data.panache.runtime.UpdateExecutor", false, var4);
         Annotation[] var7 = new Annotation[0];
         Object var9 = var5.instance(var6, var7).get();
         if (var9 != null) {
            CalendarRepositoryJaxRs_253b5300496aea63c836aa077421802281ec4c5b$$function$$1 var10 = new CalendarRepositoryJaxRs_253b5300496aea63c836aa077421802281ec4c5b$$function$$1(
               var2, var8, var1
            );
            Object var14 = ((UpdateExecutor)var9).execute(var10);
            if (var14 == null) {
               return Response.status(204).build();
            } else {
               ArcContainer var12 = Arc.container();
               ClassLoader var11 = Thread.currentThread().getContextClassLoader();
               Class var13 = Class.forName("io.quarkus.resteasy.links.runtime.hal.ResteasyHalService", false, var11);
               String var15 = ((HalService)var12.instance(var13, null).get()).getSelfLink(var14);
               if (var15 != null) {
                  URI var17 = URI.create(var15);
                  ResponseBuilder var16 = Response.status(201);
                  var16.entity(var14);
                  var16.location(var17);
                  return var16.build();
               } else {
                  throw (Throwable)(new RuntimeException("Could not extract a new entity URL"));
               }
            }
         } else {
            throw (Throwable)(new RuntimeException("UpdateExecutor instance was not found"));
         }
      } catch (Throwable var19) {
         throw (Throwable)(new RestDataPanacheException("Failed to update an entity", var19));
      }
   }

   @Path("/{id}")
   @DELETE
   @LinkResource(
      entityClassName = "acme.Calendar",
      rel = "remove"
   )
   public Response delete(@PathParam("id") Long id) {
      CalendarRepositoryResourceImpl_253b5300496aea63c836aa077421802281ec4c5b var2 = this.resource;

      try {
         return !var2.delete(var1) ? Response.status(404).build() : Response.status(204).build();
      } catch (Throwable var4) {
         throw (Throwable)(new RestDataPanacheException("Failed to delete an entity", var4));
      }
   }

   @GET
   @Path("")
   @Produces({"application/hal+json"})
   @LinkResource(
      entityClassName = "acme.Calendar",
      rel = "list"
   )
   public Response listHal(@QueryParam("sort") List<String> sort, @QueryParam("namedQuery") String namedQuery) {
      Sort var8 = Sort.by(new String[0]);
      LinkedList var4 = new LinkedList();
      Iterator var3 = var1.iterator();

      while(var3.hasNext()) {
         List var5 = Arrays.asList(((String)var3.next()).split(","));
         var4.addAll(var5);
      }

      for(Object var7 : var4) {
         if (!((String)var7).startsWith("-")) {
            var8.and((String)var7);
         } else {
            String var9 = ((String)var7).substring(1);
            Direction var10 = Direction.Descending;
            var8.and(var9, var10);
         }
      }

      CalendarRepositoryResourceImpl_253b5300496aea63c836aa077421802281ec4c5b var12 = this.resource;

      try {
         HashMap var14 = new HashMap();
         ArrayList var11 = new ArrayList();
         String var13;
         if (var2 != null) {
            var13 = "#".concat(var2);
         } else {
            var13 = String.join(" AND ", var11);
         }

         List var20 = var12.list(null, var8, var13, var14);
         ArcContainer var16 = Arc.container();
         ClassLoader var15 = Thread.currentThread().getContextClassLoader();
         Class var17 = Class.forName("io.quarkus.resteasy.links.runtime.hal.ResteasyHalService", false, var15);
         Annotation[] var18 = new Annotation[0];
         Object var19 = var16.instance(var17, var18).get();
         Class var21 = Class.forName("acme.Calendar", false, var15);
         return Response.ok(((HalService)var19).toHalCollectionWrapper(var20, "calendar", var21)).build();
      } catch (Throwable var23) {
         throw (Throwable)(new RestDataPanacheException("Failed to list the entities", var23));
      }
   }
}
