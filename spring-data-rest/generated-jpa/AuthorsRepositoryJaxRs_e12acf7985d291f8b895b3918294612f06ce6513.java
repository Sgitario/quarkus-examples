package acme;

import io.quarkus.arc.Arc;
import io.quarkus.arc.ArcContainer;
import io.quarkus.hal.HalService;
import io.quarkus.panache.common.Sort;
import io.quarkus.panache.common.Sort.Direction;
import io.quarkus.rest.data.panache.RestDataPanacheException;
import jakarta.annotation.security.DenyAll;
import jakarta.annotation.security.PermitAll;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.Response;
import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.jboss.resteasy.links.LinkResource;

// $VF: synthetic class
@Path("authors")
@DenyAll
public class AuthorsRepositoryJaxRs_e12acf7985d291f8b895b3918294612f06ce6513 {
   @Inject
   AuthorsRepositoryResourceImpl_e12acf7985d291f8b895b3918294612f06ce6513 resource;

   @Path("/{id}")
   @GET
   @Produces({"application/json", "application/hal+json"})
   @LinkResource(
      entityClassName = "acme.Author",
      rel = "self"
   )
   public Response get(@PathParam("id") Long id) {
      AuthorsRepositoryResourceImpl_e12acf7985d291f8b895b3918294612f06ce6513 var2 = this.resource;

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
      entityClassName = "acme.Author",
      rel = "list"
   )
   @PermitAll
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

      AuthorsRepositoryResourceImpl_e12acf7985d291f8b895b3918294612f06ce6513 var12 = this.resource;

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
      AuthorsRepositoryResourceImpl_e12acf7985d291f8b895b3918294612f06ce6513 var1 = this.resource;

      try {
         return Response.ok(var1.count()).build();
      } catch (Throwable var3) {
         throw (Throwable)(new RestDataPanacheException("Failed to count the entities", var3));
      }
   }

   @GET
   @Path("")
   @Produces({"application/hal+json"})
   @LinkResource(
      entityClassName = "acme.Author",
      rel = "list"
   )
   @PermitAll
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

      AuthorsRepositoryResourceImpl_e12acf7985d291f8b895b3918294612f06ce6513 var12 = this.resource;

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
         Class var21 = Class.forName("acme.Author", false, var15);
         return Response.ok(((HalService)var19).toHalCollectionWrapper(var20, "authors", var21)).build();
      } catch (Throwable var23) {
         throw (Throwable)(new RestDataPanacheException("Failed to list the entities", var23));
      }
   }
}
