package acme;

import io.quarkus.arc.Arc;
import io.quarkus.arc.ArcContainer;
import io.quarkus.panache.common.Page;
import io.quarkus.panache.common.Sort;
import io.quarkus.panache.common.Sort.Column;
import io.quarkus.panache.common.Sort.Direction;
import io.quarkus.rest.data.panache.RestDataResource;
import jakarta.enterprise.context.ApplicationScoped;
import java.lang.annotation.Annotation;
import java.util.List;
import java.util.Map;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Order;
import org.springframework.data.repository.PagingAndSortingRepository;

// $VF: synthetic class
@ApplicationScoped
public class BooksRepositoryResourceImpl_d9a8b98a40e4766003932d142b1d4907d02a3c8f implements RestDataResource {
   public List list(Page var1, Sort var2, String var3, Map var4) {
      int var14 = var1.index;
      int var15 = var1.size;
      org.springframework.data.domain.Sort var12 = org.springframework.data.domain.Sort.unsorted();

      for(Object var6 : var2.getColumns()) {
         Order[] var9 = new Order[1];
         String var8 = ((Column)var6).getName();
         Direction var7 = ((Column)var6).getDirection();
         if (!Direction.valueOf("Ascending").equals(var7)) {
            Order var11 = Order.desc(var8);
            var9[0] = var11;
         } else {
            Order var10 = Order.asc(var8);
            var9[0] = var10;
         }

         org.springframework.data.domain.Sort var13 = org.springframework.data.domain.Sort.by(var9);
         var12 = var12.and(var13);
      }

      PageRequest var21 = PageRequest.of(var14, var15, var12);
      ArcContainer var17 = Arc.container();
      ClassLoader var16 = Thread.currentThread().getContextClassLoader();
      Class var18 = Class.forName("acme.BooksRepository", false, var16);
      Annotation[] var19 = new Annotation[0];
      Object var20 = var17.instance(var18, var19).get();
      if (var20 != null) {
         return ((PagingAndSortingRepository)var20).findAll((Pageable)var21).getContent();
      } else {
         throw (Throwable)(new RuntimeException("acme.BooksRepository instance was not found"));
      }
   }

   public int $$_page_count_list(Page var1) {
      int var2 = var1.index;
      int var3 = var1.size;
      PageRequest var9 = PageRequest.of(var2, var3);
      ArcContainer var5 = Arc.container();
      ClassLoader var4 = Thread.currentThread().getContextClassLoader();
      Class var6 = Class.forName("acme.BooksRepository", false, var4);
      Annotation[] var7 = new Annotation[0];
      Object var8 = var5.instance(var6, var7).get();
      if (var8 != null) {
         return ((PagingAndSortingRepository)var8).findAll((Pageable)var9).getTotalPages();
      } else {
         throw (Throwable)(new RuntimeException("acme.BooksRepository instance was not found"));
      }
   }

   public int $$_page_count_get(Page var1) {
      throw (Throwable)(new RuntimeException("Method not implemented"));
   }

   public int $$_page_count_add(Page var1) {
      throw (Throwable)(new RuntimeException("Method not implemented"));
   }

   public int $$_page_count_update(Page var1) {
      throw (Throwable)(new RuntimeException("Method not implemented"));
   }

   public int $$_page_count_delete(Page var1) {
      throw (Throwable)(new RuntimeException("Method not implemented"));
   }
}
