package acme;

import io.quarkus.arc.Arc;
import io.quarkus.arc.ArcContainer;
import io.quarkus.panache.common.Page;
import io.quarkus.panache.common.Sort;
import io.quarkus.rest.data.panache.RestDataResource;
import jakarta.enterprise.context.ApplicationScoped;
import java.lang.annotation.Annotation;
import java.util.List;
import java.util.Map;
import org.springframework.data.repository.CrudRepository;

// $VF: synthetic class
@ApplicationScoped
public class AuthorsRepositoryResourceImpl_e12acf7985d291f8b895b3918294612f06ce6513 implements RestDataResource {
   public List list(Page var1, Sort var2, String var3, Map var4) {
      ArcContainer var6 = Arc.container();
      ClassLoader var5 = Thread.currentThread().getContextClassLoader();
      Class var7 = Class.forName("acme.AuthorsRepository", false, var5);
      Annotation[] var8 = new Annotation[0];
      Object var9 = var6.instance(var7, var8).get();
      if (var9 != null) {
         return (List)((CrudRepository)var9).findAll();
      } else {
         throw (Throwable)(new RuntimeException("acme.AuthorsRepository instance was not found"));
      }
   }

   public int $$_page_count_list(Page var1) {
      throw (Throwable)(new RuntimeException("Method not implemented"));
   }

   public Object get(Object var1) {
      ArcContainer var3 = Arc.container();
      ClassLoader var2 = Thread.currentThread().getContextClassLoader();
      Class var4 = Class.forName("acme.AuthorsRepository", false, var2);
      Annotation[] var5 = new Annotation[0];
      Object var6 = var3.instance(var4, var5).get();
      if (var6 != null) {
         return ((CrudRepository)var6).findById(var1).orElse(null);
      } else {
         throw (Throwable)(new RuntimeException("acme.AuthorsRepository instance was not found"));
      }
   }

   public Object add(Object var1) {
      ArcContainer var3 = Arc.container();
      ClassLoader var2 = Thread.currentThread().getContextClassLoader();
      Class var4 = Class.forName("acme.AuthorsRepository", false, var2);
      Annotation[] var5 = new Annotation[0];
      Object var6 = var3.instance(var4, var5).get();
      if (var6 != null) {
         return ((CrudRepository)var6).save(var1);
      } else {
         throw (Throwable)(new RuntimeException("acme.AuthorsRepository instance was not found"));
      }
   }

   public Object update(Object var1, Object var2) {
      ((Author)var2).$$_hibernate_write_id((Long)var1);
      ArcContainer var4 = Arc.container();
      ClassLoader var3 = Thread.currentThread().getContextClassLoader();
      Class var5 = Class.forName("acme.AuthorsRepository", false, var3);
      Annotation[] var6 = new Annotation[0];
      Object var7 = var4.instance(var5, var6).get();
      if (var7 != null) {
         return ((CrudRepository)var7).save(var2);
      } else {
         throw (Throwable)(new RuntimeException("acme.AuthorsRepository instance was not found"));
      }
   }

   public boolean delete(Object var1) {
      ArcContainer var3 = Arc.container();
      ClassLoader var2 = Thread.currentThread().getContextClassLoader();
      Class var4 = Class.forName("acme.AuthorsRepository", false, var2);
      Annotation[] var5 = new Annotation[0];
      Object var6 = var3.instance(var4, var5).get();
      if (var6 != null) {
         boolean var7;
         if (((CrudRepository)var6).findById(var1).orElse(null) == null) {
            var7 = false;
         } else {
            ((CrudRepository)var6).deleteById(var1);
            var7 = true;
         }

         return var7;
      } else {
         throw (Throwable)(new RuntimeException("acme.AuthorsRepository instance was not found"));
      }
   }
}
