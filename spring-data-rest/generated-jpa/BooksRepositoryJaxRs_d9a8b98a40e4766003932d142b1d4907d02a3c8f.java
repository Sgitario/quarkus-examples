package acme;

import io.quarkus.arc.Arc;
import io.quarkus.arc.ArcContainer;
import io.quarkus.hal.HalCollectionWrapper;
import io.quarkus.hal.HalService;
import io.quarkus.panache.common.Page;
import io.quarkus.panache.common.Sort;
import io.quarkus.panache.common.Sort.Direction;
import io.quarkus.rest.data.panache.RestDataPanacheException;
import io.quarkus.rest.data.panache.runtime.UpdateExecutor;
import io.quarkus.rest.data.panache.runtime.sort.SortQueryParamValidator;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.DefaultValue;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.Link;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.UriBuilder;
import jakarta.ws.rs.core.UriInfo;
import jakarta.ws.rs.core.Link.Builder;
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
@Path("books")
public class BooksRepositoryJaxRs_d9a8b98a40e4766003932d142b1d4907d02a3c8f {
   @Inject
   BooksRepositoryResourceImpl_d9a8b98a40e4766003932d142b1d4907d02a3c8f resource;

   @Path("/{id}")
   @GET
   @Produces({"application/json", "application/hal+json"})
   @LinkResource(
      entityClassName = "acme.Book",
      rel = "self"
   )
   public Response get(@PathParam("id") Long id) {
      BooksRepositoryResourceImpl_d9a8b98a40e4766003932d142b1d4907d02a3c8f var2 = this.resource;

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
      entityClassName = "acme.Book",
      rel = "list"
   )
   @SortQueryParamValidator
   public Response list(
      @QueryParam("sort") List<String> sort,
      @QueryParam("page") @DefaultValue("0") int page,
      @QueryParam("size") @DefaultValue("20") int size,
      @Context UriInfo uriInfo,
      @QueryParam("namedQuery") String namedQuery
   ) {
      BooksRepositoryResourceImpl_d9a8b98a40e4766003932d142b1d4907d02a3c8f var16 = this.resource;
      Sort var11 = Sort.by(new String[0]);
      LinkedList var7 = new LinkedList();
      Iterator var6 = var1.iterator();

      while(var6.hasNext()) {
         List var8 = Arrays.asList(((String)var6.next()).split(","));
         var7.addAll(var8);
      }

      for(Object var10 : var7) {
         if (!((String)var10).startsWith("-")) {
            var11.and((String)var10);
         } else {
            String var12 = ((String)var10).substring(1);
            Direction var13 = Direction.Descending;
            var11.and(var12, var13);
         }
      }

      int var14;
      if (var2 < 0) {
         var14 = 0;
      } else {
         var14 = var2;
      }

      int var15;
      if (var3 < 1) {
         var15 = 20;
      } else {
         var15 = var3;
      }

      Page var17 = Page.of(var14, var15);

      try {
         int var29 = var16.$$_page_count_list(var17);
         ArrayList var27 = new ArrayList(4);
         Page var18 = var17.first();
         UriBuilder var20 = var4.getAbsolutePathBuilder();
         int var19 = var18.index;
         Object[] var21 = new Object[]{var19};
         var20.queryParam("page", var21);
         int var22 = var18.size;
         Object[] var23 = new Object[]{var22};
         var20.queryParam("size", var23);
         Object[] var24 = new Object[0];
         Builder var25 = Link.fromUri(var20.build(var24));
         var25.rel("first");
         Object[] var26 = new Object[0];
         Link var28 = var25.build(var26);
         var27.add(var28);
         int var30 = Math.max(Integer.sum(var29, -1), 0);
         Page var31 = var17.index(var30);
         UriBuilder var33 = var4.getAbsolutePathBuilder();
         int var32 = var31.index;
         Object[] var34 = new Object[]{var32};
         var33.queryParam("page", var34);
         int var35 = var31.size;
         Object[] var36 = new Object[]{var35};
         var33.queryParam("size", var36);
         Object[] var37 = new Object[0];
         Builder var38 = Link.fromUri(var33.build(var37));
         var38.rel("last");
         Object[] var39 = new Object[0];
         Link var40 = var38.build(var39);
         var27.add(var40);
         int var41 = var17.index;
         int var42 = var18.index;
         if (var41 != var42) {
            Page var43 = var17.previous();
            UriBuilder var45 = var4.getAbsolutePathBuilder();
            int var44 = var43.index;
            Object[] var46 = new Object[]{var44};
            var45.queryParam("page", var46);
            int var47 = var43.size;
            Object[] var48 = new Object[]{var47};
            var45.queryParam("size", var48);
            Object[] var49 = new Object[0];
            Builder var50 = Link.fromUri(var45.build(var49));
            var50.rel("previous");
            Object[] var51 = new Object[0];
            Link var52 = var50.build(var51);
            var27.add(var52);
         }

         int var53 = var17.index;
         int var54 = var31.index;
         if (var53 != var54) {
            Page var55 = var17.next();
            UriBuilder var57 = var4.getAbsolutePathBuilder();
            int var56 = var55.index;
            Object[] var58 = new Object[]{var56};
            var57.queryParam("page", var58);
            int var59 = var55.size;
            Object[] var60 = new Object[]{var59};
            var57.queryParam("size", var60);
            Object[] var61 = new Object[0];
            Builder var62 = Link.fromUri(var57.build(var61));
            var62.rel("next");
            Object[] var63 = new Object[0];
            Link var64 = var62.build(var63);
            var27.add(var64);
         }

         Link[] var65 = new Link[var27.size()];
         Object[] var69 = var27.toArray((Object[])var65);
         HashMap var68 = new HashMap();
         ArrayList var66 = new ArrayList();
         String var67;
         if (var5 != null) {
            var67 = "#".concat(var5);
         } else {
            var67 = String.join(" AND ", var66);
         }

         ResponseBuilder var70 = Response.ok(var16.list(var17, var11, var67, var68));
         var70.links((Link[])var69);
         return var70.build();
      } catch (Throwable var72) {
         throw (Throwable)(new RestDataPanacheException("Failed to list the entities", var72));
      }
   }

   @GET
   @Produces({"application/json"})
   @Path("/count")
   public Response count() {
      BooksRepositoryResourceImpl_d9a8b98a40e4766003932d142b1d4907d02a3c8f var1 = this.resource;

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
      entityClassName = "acme.Book",
      rel = "add"
   )
   public Response add(@Valid Book entity, @Context UriInfo uriInfo) {
      BooksRepositoryResourceImpl_d9a8b98a40e4766003932d142b1d4907d02a3c8f var3 = this.resource;

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
      entityClassName = "acme.Book",
      rel = "update"
   )
   public Response update(@PathParam("id") Long id, @Valid Book entity, @Context UriInfo uriInfo) {
      BooksRepositoryResourceImpl_d9a8b98a40e4766003932d142b1d4907d02a3c8f var8 = this.resource;

      try {
         ArcContainer var5 = Arc.container();
         ClassLoader var4 = Thread.currentThread().getContextClassLoader();
         Class var6 = Class.forName("io.quarkus.rest.data.panache.runtime.UpdateExecutor", false, var4);
         Annotation[] var7 = new Annotation[0];
         Object var9 = var5.instance(var6, var7).get();
         if (var9 != null) {
            BooksRepositoryJaxRs_d9a8b98a40e4766003932d142b1d4907d02a3c8f$$function$$1 var10 = new BooksRepositoryJaxRs_d9a8b98a40e4766003932d142b1d4907d02a3c8f$$function$$1(
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
      entityClassName = "acme.Book",
      rel = "remove"
   )
   public Response delete(@PathParam("id") Long id) {
      BooksRepositoryResourceImpl_d9a8b98a40e4766003932d142b1d4907d02a3c8f var2 = this.resource;

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
      entityClassName = "acme.Book",
      rel = "list"
   )
   @SortQueryParamValidator
   public Response listHal(
      @QueryParam("sort") List<String> sort,
      @QueryParam("page") @DefaultValue("0") int page,
      @QueryParam("size") @DefaultValue("20") int size,
      @Context UriInfo uriInfo,
      @QueryParam("namedQuery") String namedQuery
   ) {
      BooksRepositoryResourceImpl_d9a8b98a40e4766003932d142b1d4907d02a3c8f var16 = this.resource;
      Sort var11 = Sort.by(new String[0]);
      LinkedList var7 = new LinkedList();
      Iterator var6 = var1.iterator();

      while(var6.hasNext()) {
         List var8 = Arrays.asList(((String)var6.next()).split(","));
         var7.addAll(var8);
      }

      for(Object var10 : var7) {
         if (!((String)var10).startsWith("-")) {
            var11.and((String)var10);
         } else {
            String var12 = ((String)var10).substring(1);
            Direction var13 = Direction.Descending;
            var11.and(var12, var13);
         }
      }

      int var14;
      if (var2 < 0) {
         var14 = 0;
      } else {
         var14 = var2;
      }

      int var15;
      if (var3 < 1) {
         var15 = 20;
      } else {
         var15 = var3;
      }

      Page var17 = Page.of(var14, var15);

      try {
         int var29 = var16.$$_page_count_list(var17);
         ArrayList var27 = new ArrayList(4);
         Page var18 = var17.first();
         UriBuilder var20 = var4.getAbsolutePathBuilder();
         int var19 = var18.index;
         Object[] var21 = new Object[]{var19};
         var20.queryParam("page", var21);
         int var22 = var18.size;
         Object[] var23 = new Object[]{var22};
         var20.queryParam("size", var23);
         Object[] var24 = new Object[0];
         Builder var25 = Link.fromUri(var20.build(var24));
         var25.rel("first");
         Object[] var26 = new Object[0];
         Link var28 = var25.build(var26);
         var27.add(var28);
         int var30 = Math.max(Integer.sum(var29, -1), 0);
         Page var31 = var17.index(var30);
         UriBuilder var33 = var4.getAbsolutePathBuilder();
         int var32 = var31.index;
         Object[] var34 = new Object[]{var32};
         var33.queryParam("page", var34);
         int var35 = var31.size;
         Object[] var36 = new Object[]{var35};
         var33.queryParam("size", var36);
         Object[] var37 = new Object[0];
         Builder var38 = Link.fromUri(var33.build(var37));
         var38.rel("last");
         Object[] var39 = new Object[0];
         Link var40 = var38.build(var39);
         var27.add(var40);
         int var41 = var17.index;
         int var42 = var18.index;
         if (var41 != var42) {
            Page var43 = var17.previous();
            UriBuilder var45 = var4.getAbsolutePathBuilder();
            int var44 = var43.index;
            Object[] var46 = new Object[]{var44};
            var45.queryParam("page", var46);
            int var47 = var43.size;
            Object[] var48 = new Object[]{var47};
            var45.queryParam("size", var48);
            Object[] var49 = new Object[0];
            Builder var50 = Link.fromUri(var45.build(var49));
            var50.rel("previous");
            Object[] var51 = new Object[0];
            Link var52 = var50.build(var51);
            var27.add(var52);
         }

         int var53 = var17.index;
         int var54 = var31.index;
         if (var53 != var54) {
            Page var55 = var17.next();
            UriBuilder var57 = var4.getAbsolutePathBuilder();
            int var56 = var55.index;
            Object[] var58 = new Object[]{var56};
            var57.queryParam("page", var58);
            int var59 = var55.size;
            Object[] var60 = new Object[]{var59};
            var57.queryParam("size", var60);
            Object[] var61 = new Object[0];
            Builder var62 = Link.fromUri(var57.build(var61));
            var62.rel("next");
            Object[] var63 = new Object[0];
            Link var64 = var62.build(var63);
            var27.add(var64);
         }

         Link[] var65 = new Link[var27.size()];
         Object[] var76 = var27.toArray((Object[])var65);
         HashMap var68 = new HashMap();
         ArrayList var66 = new ArrayList();
         String var67;
         if (var5 != null) {
            var67 = "#".concat(var5);
         } else {
            var67 = String.join(" AND ", var66);
         }

         List var74 = var16.list(var17, var11, var67, var68);
         ArcContainer var70 = Arc.container();
         ClassLoader var69 = Thread.currentThread().getContextClassLoader();
         Class var71 = Class.forName("io.quarkus.resteasy.links.runtime.hal.ResteasyHalService", false, var69);
         Annotation[] var72 = new Annotation[0];
         Object var73 = var70.instance(var71, var72).get();
         Class var75 = Class.forName("acme.Book", false, var69);
         HalCollectionWrapper var77 = ((HalService)var73).toHalCollectionWrapper(var74, "books", var75);
         var77.addLinks((Link[])var76);
         ResponseBuilder var78 = Response.ok(var77);
         var78.links((Link[])var76);
         return var78.build();
      } catch (Throwable var80) {
         throw (Throwable)(new RestDataPanacheException("Failed to list the entities", var80));
      }
   }
}
