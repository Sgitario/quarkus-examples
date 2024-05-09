package acme;

import io.quarkus.hibernate.orm.panache.PanacheQuery;
import io.quarkus.hibernate.orm.panache.common.runtime.AbstractJpaOperations;
import io.quarkus.hibernate.orm.panache.runtime.JpaOperations;
import io.quarkus.spring.data.runtime.TypesConverter;
import jakarta.enterprise.context.ApplicationScoped;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

// $VF: synthetic class
@ApplicationScoped
public class BooksRepository_d9a8b98a40e4766003932d142b1d4907d02a3c8fImpl implements BooksRepository {
   private final Class entityClass;

   public BooksRepository_d9a8b98a40e4766003932d142b1d4907d02a3c8fImpl() {
      ClassLoader var1 = Thread.currentThread().getContextClassLoader();
      Class var2 = Class.forName("acme.Book", false, var1);
      this.entityClass = var2;
   }

   public List<Book> findAll(Sort var1) {
      io.quarkus.panache.common.Sort var4 = TypesConverter.toPanacheSort(var1);
      JpaOperations var2 = JpaOperations.INSTANCE;
      Class var3 = this.entityClass;
      return ((PanacheQuery)((AbstractJpaOperations)var2).findAll(var3, var4)).list();
   }

   public Iterable findAll(Sort var1) {
      return this.findAll(var1);
   }

   public Page<Book> findAll(Pageable var1) {
      Sort var2 = var1.getSort();
      io.quarkus.panache.common.Page var9 = TypesConverter.toPanachePage(var1);
      io.quarkus.panache.common.Sort var7 = TypesConverter.toPanacheSort(var2);
      PanacheQuery var8;
      if (var7 != null) {
         JpaOperations var5 = JpaOperations.INSTANCE;
         Class var6 = this.entityClass;
         var8 = (PanacheQuery)((AbstractJpaOperations)var5).findAll(var6, var7);
      } else {
         JpaOperations var3 = JpaOperations.INSTANCE;
         Class var4 = this.entityClass;
         var8 = (PanacheQuery)((AbstractJpaOperations)var3).findAll(var4);
      }

      PanacheQuery var10 = var8.page(var9);
      List var11 = var10.list();
      long var12 = var10.count();
      return (Page<Book>)(new PageImpl(var11, var1, var12));
   }
}
